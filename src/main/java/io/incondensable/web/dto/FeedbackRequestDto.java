package io.incondensable.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author abbas
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class FeedbackRequestDto {
    private long productId;
    private String comment;
    private Byte vote;
}
