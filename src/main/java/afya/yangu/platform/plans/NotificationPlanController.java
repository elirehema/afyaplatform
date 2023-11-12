package afya.yangu.platform.plans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * Created by ngune001.
 * For Afya-Yangu notification platform
 * Project File: platform.
 * Package: afya.yangu.platform.plans.
 * Date & Time: 11/3/2023T10:12 PM.
 */
@RestController
@RequestMapping("/notifications")
public class NotificationPlanController {
    private  final NotificationPlanService service;

    @Autowired
    public NotificationPlanController(NotificationPlanService service) {
        this.service = service;
    }
    @GetMapping(path = "")
    public ResponseEntity<List<NotificationPlan>> retrieveAllNotification() {
        return new ResponseEntity<>(service.retrieveNotificationPlans(), CREATED);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<NotificationPlan> retrieveAllNotification(@PathVariable("id") String id) {
        return new ResponseEntity<>(service.retrieveNotificationPlan(id), CREATED);
    }
    @DeleteMapping(path = "/{id}")
    public void deleteNotification(@PathVariable("id") String id) {
        service.deleteNotificationPlan(id);
    }
    @PostMapping(path = "")
    public ResponseEntity<NotificationPlan> createNotification( @Valid @RequestBody NotificationPlan requestBody) {
        return new ResponseEntity<>(service.createNotificationPlan(requestBody), CREATED);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateNotification(@PathVariable(value = "id", required = true) String id, @Valid @RequestBody NotificationPlan requestBody) {
        this.service.updateNotificationPlan(id,requestBody);
        return new ResponseEntity<>("Received", CREATED);
    }
}
