package afya.yangu.platform.plans;

import afya.yangu.platform.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationPlanRepository extends JpaRepository<NotificationPlan, String> {
    Optional<NotificationPlan> findById(String id);
}
