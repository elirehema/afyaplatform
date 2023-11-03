package afya.yangu.platform.utils;

import afya.yangu.platform.model.ScheduledNotification;
import afya.yangu.platform.plans.NotificationFrequencyType;
import afya.yangu.platform.plans.NotificationPlan;
import afya.yangu.platform.schedules.NotificationSchedule;
import com.cronutils.builder.CronBuilder;
import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinitionBuilder;

import static com.cronutils.model.field.expression.FieldExpressionFactory.*;

/**
 * Created by ngune001.
 * For Afya-Yangu notification platform
 * Project File: platform.
 * Package: afya.yangu.platform.utils.
 * Date & Time: 11/3/2023T9:43 PM.
 */
public class CronsParseUtility {
    private final NotificationSchedule schedule;
    public CronsParseUtility(NotificationSchedule schedule){
        this.schedule = schedule;
    }
    public String createCronExpression() {
        CronBuilder builder = CronBuilder.cron(CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ));
        Cron cron = builder.instance();
        if (this.schedule.getFrequencyType().equals(NotificationFrequencyType.DAILY)) {
            cron = builder
                    .withHour(every(8))
                    .withHour(between(8,22))
                    .withSecond(on(0))
                    .instance();
        }

        return cron.toString();
    }
}
