package afya.yangu.platform.notification;

import afya.yangu.platform.inprogress.NotificationInProgress;
import afya.yangu.platform.inprogress.NotificationInProgressRepository;
import afya.yangu.platform.model.*;
import afya.yangu.platform.schedules.NotificationSchedule;
import afya.yangu.platform.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ngune001.
 * User: John.Smith
 * Date: 6/1/11
 * Time: 12:54 PM
 * To change this template use File | Settings | File and Code Templates.
 */
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final JobService jobService;
    private final NotificationRepository repository;
    private final NotificationInProgressRepository notificationInProgressRepository;



    /**
     * A scheduled function to create a Notification Jobs
     * Trigger after specified time to prepare for the patient Day notification
     *
     */
    @Scheduled(cron = "0 */2 * * * ?")
    public void scheduleFixedDelayTask() {
        System.out.println("Scheduling............");
        List<Notification> nts = this.repository.findByEndDate();
        for (Notification nt : nts) {
            JobDescriptor jd = JobDescriptor.buildDescriptorFromNotification(nt);
            jobService.createJob("notification",jd);
            System.out.println("Notification: "+ nt.getEntityName());
        }
    }

    /**
     * A schedules method to delete all active notification jobs
     * Executed in midnight
     * Delete all day notification jobs
     * This will always take time before a new schedule for preparing new tasks
     */
    @Scheduled(cron = "0 */13 * * * ?")
    public void deleteActiveScheduledJobs(){
        List<NotificationInProgress> schedules = this.notificationInProgressRepository.findAll();
        /**
        schedules.forEach(schedule->{
            this.jobService.deleteJob(schedule.getGroupName(), schedule.getJobName());
        });
        **/
        this.jobService.deleteAllJobs();
        this.notificationInProgressRepository.deleteAll();

    }

    @Override
    public void createNotification(NotificationSchedule schedule) {
        Notification notification = Notification.of(schedule);
        this.repository.save(notification);
    }

    @Override
    public void updateNotification(String id,NotificationSchedule payload) {
         this.repository.findById(id).map(notification -> {
            notification.update(payload);
            return this.repository.save(notification);
        });
    }

    @Override
    public void deleteNotification(String id) {
        this.repository.findById(id).map(notification -> {
            this.repository.delete(notification);
            return null;
        });
    }
}
