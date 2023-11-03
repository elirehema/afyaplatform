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
        this.notificationService.createNotification(schedule);
        this.scheduleRepository.save(schedule);
    }
}
