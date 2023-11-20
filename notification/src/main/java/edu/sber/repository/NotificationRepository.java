package edu.sber.repository;

import edu.sber.model.Notification;
import java.util.List;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description.
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, String> {
    List<Notification> findAllByStatus(String status);
}
