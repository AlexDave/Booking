package edu.sber.validator;

import edu.sber.model.Notification;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class NotificationValidator {
    public List<String> validate(Notification notification) {
        List<String> result = new ArrayList<>();
        if (notification.getRecipient() != null && !notification.getRecipient().isEmpty()) {
            if (!notification.getRecipient().matches("^[a-zA-Z0-9_! #$%&'*+/=?`|~^. -]+@[a-zA-Z0-9. -]+$")) {
                result.add("Recipient format is incorrect");
            }
        } else {
            result.add("Recipient is empty");
        }

        if (notification.getSubject() == null || notification.getSubject().isEmpty()) {
            result.add("Subject is empty");
        }

        if (notification.getMessage() == null || notification.getMessage().isEmpty()) {
            result.add("Message is empty");
        }

        return result;

    }
}
