package afya.yangu.platform.notification;

import afya.yangu.platform.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Created by ngune001.
 * User: John.Smith
 * Date: 6/1/11
 * Time: 12:54 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public interface NotificationRepository extends JpaRepository<Notification, String> {
    @Query("SELECT n FROM Notification n WHERE CURRENT_DATE  <=  DATE(n.endDate)")
    List<Notification> findByEndDate();
    Optional<Notification> findById(String id);
}
