package afya.yangu.platform.notification;

import afya.yangu.platform.schedules.NotificationSchedule;

public interface NotificationService {
    void createNotification(NotificationSchedule schedule);
    void updateNotification(String id,NotificationSchedule payload);
    void deleteNotification(String id);
}
