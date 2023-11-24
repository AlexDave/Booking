package edu.sber.service;

import edu.sber.model.Notification;
import edu.sber.repository.NotificationRepository;
import java.util.List;
import java.util.UUID;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final JavaMailSender javaMailSender;
    private final NotificationRepository notificationRepository;

    @Value("${spring.mail.username}")
    private String sender;

    public NotificationService(JavaMailSender javaMailSender, NotificationRepository notificationRepository) {
        this.javaMailSender = javaMailSender;
        this.notificationRepository = notificationRepository;
    }

    @Async
    public void sendSimpleNotification(Notification notification) {

        notification.setRetryNum(notification.getRetryNum() + 1);
        notification = notificationRepository.save(notification.setStatus("InProgress"));

        SimpleMailMessage mailMessage
                = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setTo(notification.getRecipient());
        mailMessage.setSubject(notification.getSubject());
        mailMessage.setText(notification.getMessage());
        try {
            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            notificationRepository.save(notification.setStatus("Error"));
            return;
        }
        notificationRepository.save(notification.setStatus("Completed"));
    }

    @Scheduled(fixedRate = 5 * 1000)
    public void retryErrors() {
        List<Notification> notifications = notificationRepository.findAllByStatus("Error");
        for (Notification notification : notifications) {
            if (notification.getRetryNum() == 3) {
                notificationRepository.save(notification.setStatus("Broken"));
            } else {
                sendSimpleNotification(notification);
            }
        }
    }

    public Notification getById(String id){
        return notificationRepository.findById(id).get();
    }

}

