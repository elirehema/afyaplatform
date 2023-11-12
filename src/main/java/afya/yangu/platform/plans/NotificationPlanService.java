package afya.yangu.platform.plans;

import java.util.List;

public interface NotificationPlanService {
    NotificationPlan createNotificationPlan(NotificationPlan request);
    List<NotificationPlan> retrieveNotificationPlans();
    NotificationPlan retrieveNotificationPlan(String id);
    void updateNotificationPlan(String id, NotificationPlan request);
    void deleteNotificationPlan(String id);
}
