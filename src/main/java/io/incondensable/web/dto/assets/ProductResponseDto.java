package io.incondensable.web.dto.assets;

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
public class ProductResponseDto {
    private long id;
    private int price;
    private String name;
    private String color;
    private String category;
    private String providerName;
    private boolean isVotable;
    private boolean isOpenToAll;
    private boolean isCommentable;
}
