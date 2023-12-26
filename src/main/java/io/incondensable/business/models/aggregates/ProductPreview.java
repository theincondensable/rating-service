package io.incondensable.business.models.aggregates;

import io.incondensable.business.models.assets.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author abbas
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPreview {
    private Product product;
    private int voteCount;
    private double voteAverage;
    private List<String> comments = new ArrayList<>(3);
}
