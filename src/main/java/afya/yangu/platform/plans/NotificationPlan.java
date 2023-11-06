package afya.yangu.platform.plans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Elirehema Paul.
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
@Table(name = "m_notification_plans")
public class NotificationPlan {
    private static final long serialVersionUID = 1L;
    @Id
    private String id = UUID.randomUUID().toString();
    @Column(name = "entity_name")
    private String entityName; // Name of medicine, pills, syrup, injection etc
    private String quantity; // Quantity to use in a single consumption 1,2,3....etc
    @Column(name = "start_date")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate startDate = LocalDate.now(); //When to start consumption default today
    @Column(name="no_of_days")
    private Integer days; // How many days expected for this consumption. I.e this will determine the end date to notify the recipient
    private Integer frequency; // How frequently to remind recipient
    @Enumerated(EnumType.STRING)
    private NotificationFrequencyType frequencyType; // What is that frequency type ? DAILY, WEEKLY etc
    @Column(name="phone_number")
    private String phoneNumber; // The phone number used for notifications
    public NotificationPlan setId(){
        this.id = UUID.randomUUID().toString();
        return this;
    }

    public void update(NotificationPlan p){
        this.entityName = p.entityName;
        this.quantity = p.quantity;
        this.startDate = p.startDate;
        this.days = p.days;
        this.frequency = p.frequency;
        this.phoneNumber = p.getPhoneNumber();
        this.frequencyType = p.getFrequencyType();
    }
}
