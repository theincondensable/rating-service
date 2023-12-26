package io.incondensable.web.dto;

import io.incondensable.business.models.assets.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author abbas
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class FeedbackResponseDto {
    private String providerName;
    private String productName;
    private String comment;
    private Byte vote;
}
