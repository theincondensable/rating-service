package io.incondensable.business.exception.feedback;

import io.incondensable.global.exception.BusinessException;
import io.incondensable.global.exception.ErrorDetails;
import org.springframework.http.HttpStatus;

/**
 * @author abbas
 */
public class FeedbackNotFoundWithId extends BusinessException {
    public FeedbackNotFoundWithId(long feedbackId) {
        super(new ErrorDetails(
                "feedback.not.found.with.given.id",
                HttpStatus.NOT_FOUND,
                feedbackId
        ));
    }
}
