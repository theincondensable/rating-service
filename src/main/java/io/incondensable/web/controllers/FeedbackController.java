package io.incondensable.web.controllers;

import io.incondensable.business.services.feedback.FeedbackService;
import io.incondensable.global.aspects.log.aspect.ControllerLog;
import io.incondensable.web.dto.FeedbackRequestDto;
import io.incondensable.web.dto.FeedbackResponseDto;
import io.incondensable.web.mappers.FeedbackMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author abbas
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackMapper mapper;
    private final FeedbackService service;

    public FeedbackController(FeedbackService feedbackService, FeedbackMapper mapper) {
        this.service = feedbackService;
        this.mapper = mapper;
    }

    @ControllerLog
    @GetMapping("/")
    public ResponseEntity<List<FeedbackResponseDto>> getAllFeedbacksForManager() {
        return ResponseEntity.ok(
                service.getAllFeedbacksForManager().stream().map(
                        mapper::entityToDto
                ).toList()
        );
    }

    @ControllerLog
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<FeedbackResponseDto>> getAllFeedbacksForManager(@PathVariable Long productId) {
        return ResponseEntity.ok(
                service.getAllFeedbacksForManagerOfProduct(productId).stream().map(
                        mapper::entityToDto
                ).toList()
        );
    }

    @ControllerLog
    @GetMapping("/submitted/product/{productId}")
    public ResponseEntity<List<FeedbackResponseDto>> getOnlySubmittedFeedbacksForManagerOfProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(
                service.getOnlySubmittedFeedbacksForManagerOfProduct(productId).stream().map(
                        mapper::entityToDto
                ).toList()
        );
    }

    @ControllerLog
    @PostMapping("/submit")
    public ResponseEntity<FeedbackResponseDto> submitFeedback(@RequestBody FeedbackRequestDto req) {
        return ResponseEntity.ok(
                mapper.entityToDto(
                        service.submitFeedback(
                                mapper.dtoToEntity(req)
                        )
                )
        );
    }

    @ControllerLog
    @PostMapping("/reject")
    public ResponseEntity<FeedbackResponseDto> rejectFeedback(@RequestParam Long feedbackId) {
        return ResponseEntity.ok(
                mapper.entityToDto(service.rejectFeedback(feedbackId))
        );
    }

    @ControllerLog
    @PostMapping("/approve")
    public ResponseEntity<FeedbackResponseDto> approveFeedback(@RequestParam Long feedbackId) {
        return ResponseEntity.ok(
                mapper.entityToDto(service.approveFeedback(feedbackId))
        );
    }

}
