package io.incondensable.business.exception.feedback;

import io.incondensable.global.exception.BusinessException;
import io.incondensable.global.exception.ErrorDetails;
import org.springframework.http.HttpStatus;

/**
 * @author abbas
 */
public class VoteNotPossibleException extends BusinessException {
    public VoteNotPossibleException(Long productId) {
        super(new ErrorDetails(
                "submitting.vote.on.product.not.possible",
                HttpStatus.BAD_REQUEST,
                productId
        ));
    }
}
