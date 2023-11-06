package afya.yangu.platform.schedules;

import afya.yangu.platform.plans.NotificationPlan;

/**
 * Created by ngune001.
 * For Afya-Yangu notification platform
 * Project File: platform.
 * Package: afya.yangu.platform.schedules.
 * Date & Time: 11/3/2023T10:19 PM.
 */
public interface NotificationScheduleService {
    void createNotificationSchedule(NotificationPlan plan);
    void updateNotificationSchedule(NotificationPlan plan);
}
