package afya.yangu.platform.schedules;

import afya.yangu.platform.plans.NotificationPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Created by ngune001.
 * For Afya-Yangu notification platform
 * Project File: platform.
 * Package: afya.yangu.platform.schedules.
 * Date & Time: 11/3/2023T10:11 PM.
 */
public interface NotificationScheduleRepository extends JpaRepository<NotificationSchedule, String> {
    @Query(value = "select * from m_notification_schedules sc where sc.plan_id = :id", nativeQuery = true)
    Optional<NotificationSchedule> findByNotificationPlanId(@Param("id") String id);
}
