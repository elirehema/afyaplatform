package afya.yangu.platform.plans;

import afya.yangu.platform.schedules.NotificationScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ngune001.
 * For Afya-Yangu notification platform
 * Project File: platform.
 * Package: afya.yangu.platform.plans.
 * Date & Time: 11/3/2023T10:12 PM.
 */
@Service
public class NotificationPlanServiceImpl implements NotificationPlanService{
    private final NotificationPlanRepository repository;
    private final NotificationScheduleService scheduleService;
    @Autowired
    public NotificationPlanServiceImpl(NotificationPlanRepository repository, NotificationScheduleService scheduleService) {
        this.repository = repository;
        this.scheduleService = scheduleService;
    }

    @Override
    public NotificationPlan createNotificationPlan(NotificationPlan request) {
        NotificationPlan plan = this.repository.save(request.setId());
       this.scheduleService.createNotificationSchedule(plan);
        return plan;
    }
}
