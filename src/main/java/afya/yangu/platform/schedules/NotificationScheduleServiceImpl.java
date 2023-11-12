package afya.yangu.platform.schedules;

import afya.yangu.platform.notification.NotificationService;
import afya.yangu.platform.plans.NotificationPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ngune001.
 * For Afya-Yangu notification platform
 * Project File: platform.
 * Package: afya.yangu.platform.schedules.
 * Date & Time: 11/3/2023T10:20 PM.
 */
@Service
public class NotificationScheduleServiceImpl implements NotificationScheduleService{
    private final NotificationScheduleRepository scheduleRepository;
    private final NotificationService notificationService;

    @Autowired
    public NotificationScheduleServiceImpl(NotificationScheduleRepository scheduleRepository, NotificationService notificationService) {
        this.scheduleRepository = scheduleRepository;
        this.notificationService = notificationService;
    }

    @Override
    public void createNotificationSchedule(NotificationPlan plan) {
        NotificationSchedule schedule = NotificationSchedule.of(plan);
        NotificationSchedule sc = this.scheduleRepository.save(schedule);
        this.notificationService.createNotification(sc);
    }

    @Override
    public void updateNotificationSchedule(NotificationPlan plan) {
        this.scheduleRepository.findByNotificationPlanId(plan.getId()).map(schedule->{
            schedule.updateWithPlan(plan);
            NotificationSchedule updated = this.scheduleRepository.save(schedule);
            this.notificationService.updateNotification(updated);
            return null;
        });//.orElseThrow(()-> new RuntimeException("Notification schedule not found"));
    }
}
