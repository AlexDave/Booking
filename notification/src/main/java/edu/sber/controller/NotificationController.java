package edu.sber.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import edu.sber.mapper.NotificationDetailToNotificationMapper;
import edu.sber.model.Notification;
import edu.sber.model.NotificationDetail;
import edu.sber.model.NotificationResponse;
import edu.sber.service.NotificationService;
import edu.sber.validator.NotificationValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Notification api", description = "Api for user notifications")
@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    private final NotificationService notificationService;
    private final NotificationDetailToNotificationMapper notificationMapper;
    private final NotificationValidator validator;


    public NotificationController(NotificationService notificationService,
                                  NotificationDetailToNotificationMapper notificationMapper,
                                  NotificationValidator validator) {
        this.notificationService = notificationService;
        this.notificationMapper = notificationMapper;
        this.validator = validator;
    }

    @Operation(
            summary = "Send notification with info from body",
            description = "Send notification to recipient with subject and message from body.")
    @ApiResponses({
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = NotificationResponse.class))}),
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema())})})

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<NotificationResponse> getRoom(@RequestBody NotificationDetail detail) {
        Notification notification = notificationMapper.notificationDetailToNotification(detail);
        List<String> validatorResult = validator.validate(notification);
        if (!validatorResult.isEmpty()) {
            return ResponseEntity.badRequest().body(NotificationResponse.builder()
                    .errorList(validatorResult)
                    .status("Error")
                    .build());
        }
        notificationService.sendSimpleNotification(notification);
        return ResponseEntity.ok(NotificationResponse.builder()
                .status("Good")
                .build());
    }
}
