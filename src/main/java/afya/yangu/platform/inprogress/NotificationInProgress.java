package afya.yangu.platform.inprogress;

import afya.yangu.platform.model.JobDescriptor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.quartz.JobDetail;

import javax.persistence.*;

/**
 * Created by ngune001.
 * User: John.Smith
 * Date: 6/1/11
 * Time: 12:54 PM
 * To change this template use File | Settings | File and Code Templates.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "m_notification_inprogress")
public class NotificationInProgress {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name",nullable = false)
    private String groupName;

    @Column(name = "job_name",nullable = false)
    private String jobName;
    public static NotificationInProgress of(JobDescriptor descriptor, JobDetail detail){
        return new NotificationInProgress(null, descriptor.getGroup(), descriptor.getName());
    }
}
