package afya.yangu.platform.plans;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
@RequiredArgsConstructor
public class NotificationPlanController {
    NotificationPlanService service;

    @PostMapping(path = "")
    public ResponseEntity<NotificationPlan> createNotification( @Valid @RequestBody NotificationPlan requestBody) {
        return new ResponseEntity<>(service.createNotificationPlan(requestBody), CREATED);
    }
}
