package io.incondensable.business.exception.assets;

import io.incondensable.global.exception.BusinessException;
import io.incondensable.global.exception.ErrorDetails;
import org.springframework.http.HttpStatus;

/**
 * @author abbas
 */
public class ProductNotFoundWithId extends BusinessException {
    public ProductNotFoundWithId(Long productId) {
        super(new ErrorDetails(
                "product.not.found.with.given.id",
                HttpStatus.NOT_FOUND,
                productId
        ));
    }
}
