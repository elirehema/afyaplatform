package afya.yangu.platform.schedules;

import afya.yangu.platform.plans.NotificationFrequencyType;
import afya.yangu.platform.plans.NotificationPlan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

/**
 * Created by ngune001.
 * For Afya-Yangu notification platform
 * Project File: platform.
 * Package: afya.yangu.platform.schedules.
 * Date & Time: 11/3/2023T9:19 PM.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "m_notification_schedules")
public class NotificationSchedule {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @Column(name = "entity_name")
    private String entityName; // Name of medicine, pills, syrup, injection etc
    private String quantity; // Quantity to use in a single consumption 1,2,3....etc
    @Column(name = "start_date")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime startDate; //When to start notifying the recipient
    @Column(name = "end_date")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime endDate; //When to start notifying the recipient
    @Column(name="no_of_days")
    private Integer days; // How many days expected for this consumption. I.e this will determine the end date to notify the recipient
    private Integer frequency; // How frequently to remind recipient
    @Enumerated(EnumType.STRING)
    private NotificationFrequencyType frequencyType; // What is that frequency type ? DAILY, WEEKLY etc
    @Column(name="phone_number")
    private String phoneNumber; // The phone number used for SMS delivery
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private NotificationPlan plan;

    public static NotificationSchedule of(NotificationPlan plan){
        NotificationSchedule sc = new NotificationSchedule();
        sc.setEntityName(plan.getEntityName());
        sc.setQuantity(plan.getQuantity());
        sc.setStartDate(plan.getStartDate().atTime(LocalTime.now()));
        sc.setEndDate(plan.getStartDate().plusDays(plan.getDays()).atTime(LocalTime.now()));
        sc.setDays(plan.getDays());
        sc.setFrequency(plan.getFrequency());
        sc.setFrequencyType(plan.getFrequencyType());
        sc.setPhoneNumber(plan.getPhoneNumber());
        sc.setPlan(plan);
        sc.setId(UUID.randomUUID().toString());
        return sc;
    }
    public void updateWithPlan(NotificationPlan plan){
        this.entityName = plan.getEntityName();
        this.quantity = plan.getQuantity();
        this.startDate = plan.getStartDate().atTime(LocalTime.now());
        this.endDate = plan.getStartDate().plusDays(plan.getDays()).atTime(LocalTime.now());
        this.days = plan.getDays();
        this.frequency = plan.getFrequency();
        this.frequencyType = plan.getFrequencyType();
        this.phoneNumber = plan.getPhoneNumber();
    }
}
