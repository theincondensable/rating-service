package io.incondensable.web.dto.assets;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * <p>This DTO is used for showing preview information of all Products</p>
 * <p>For the whole information, ProductResponseDto must be used.</p>
 * @author abbas
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductPreviewResponseDto {
    private long id;
    private int price;
    private String name;
    private int voteCount;
    private double voteAverage;
    private List<String> comments;
}
