package io.incondensable.business.exception.feedback;

import io.incondensable.global.exception.BusinessException;
import io.incondensable.global.exception.ErrorDetails;
import org.springframework.http.HttpStatus;

/**
 * @author abbas
 */
public class FeedbackChangeToSubmittedStateException extends BusinessException {
    public FeedbackChangeToSubmittedStateException(long feedbackId) {
        super(new ErrorDetails(
                "feedback.state.cant.be.rolled.back.to.submitted",
                HttpStatus.BAD_REQUEST,
                feedbackId
        ));
    }
}
