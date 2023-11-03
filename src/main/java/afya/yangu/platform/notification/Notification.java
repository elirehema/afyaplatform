package afya.yangu.platform.notification;

import afya.yangu.platform.schedules.NotificationSchedule;
import afya.yangu.platform.utils.CronsParseUtility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

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
@Table(name = "m_notifications")
public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id = UUID.randomUUID().toString();
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name = "start_date")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime startDate;
    @Column(name="end_date")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime endDate;
    @Column(name = "entity_name")
    private String entityName;
    private String cron;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private NotificationSchedule schedule;
    public static Notification of(NotificationSchedule schedule){
        CronsParseUtility utility = new CronsParseUtility(schedule);
        return new Notification(UUID.randomUUID().toString(), schedule.getPhoneNumber(), schedule.getStartDate(),schedule.getEndDate(), schedule.getEntityName(), utility.createCronExpression(), schedule);
    }
}
