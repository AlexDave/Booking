package edu.sber.mapper;

import edu.sber.model.Notification;
import edu.sber.model.NotificationDetail;
import org.mapstruct.Mapper;

@Mapper
public interface NotificationDetailToNotificationMapper {
    Notification notificationDetailToNotification(NotificationDetail source);

}
