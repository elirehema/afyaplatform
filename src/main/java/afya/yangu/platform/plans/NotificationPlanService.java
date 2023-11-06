package afya.yangu.platform.plans;

import java.util.List;

public interface NotificationPlanService {
    NotificationPlan createNotificationPlan(NotificationPlan request);
    List<NotificationPlan> retrieveNotificationPlans();
    void updateNotificationPlan(NotificationPlan request);
    void deleteNotificationPlan(String id);
}
