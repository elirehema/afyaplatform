package afya.yangu.platform.utils;

import afya.yangu.platform.plans.NotificationFrequencyType;
import afya.yangu.platform.schedules.NotificationSchedule;
import com.cronutils.builder.CronBuilder;
import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.field.value.SpecialChar;

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
        //Cron cron = builder.instance();
        if (this.schedule.getFrequencyType().equals(NotificationFrequencyType.DAILY)) {
           Cron cron = builder
                   .withYear(on(schedule.getStartDate().getYear()))
                   .withDoM(between(schedule.getStartDate().getDayOfMonth(),schedule.getEndDate().getDayOfMonth()))
                   .withMonth(between(schedule.getStartDate().getMonthValue(), schedule.getEndDate().getMonthValue()))
                   .withDoW(questionMark())
                   .withHour(always())
                   .withMinute(always())
                   .withSecond(on(0))
                   .instance();
           /** RESERSED FOR LIVE TASK **/
           /**
            Cron cron = builder
                    .withYear(on(schedule.getStartDate().getYear()))
                    .withDoM(between(schedule.getStartDate().getDayOfMonth(),schedule.getEndDate().getDayOfMonth()))
                    .withMonth(between(schedule.getStartDate().getMonthValue(), schedule.getEndDate().getMonthValue()))
                    .withDoW(questionMark())
                    .withHour(every(8))
                    .withMinute(on(1))
                    .withSecond(on(0))
                    .instance();
            **/
            return cron.asString();
        }
        return "null";

    }

    public static void main(String[] args) {
        CronBuilder builder = CronBuilder.cron(CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ));
        Cron cron = builder
                .withYear(on(2023))
                .withDoM(between(1, 3))
                .withMonth(always())
                .withDoW(questionMark())
                .withHour(every(8))
                .withMinute(on(1))
                .withSecond(on(0))
                .instance();
        System.out.println(cron.asString());
    }
}
