package io.incondensable.business.services;

import io.incondensable.business.models.assets.Product;
import io.incondensable.business.models.aggregates.ProductPreview;
import io.incondensable.business.services.assets.ProductService;
import io.incondensable.business.services.feedback.FeedbackCalculatorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author abbas
 */
@Service
public class ProductPreviewService {

    private final ProductService productService;
    private final FeedbackCalculatorService feedbackCalculatorService;

    public ProductPreviewService(ProductService productService, FeedbackCalculatorService feedbackCalculatorService) {
        this.productService = productService;
        this.feedbackCalculatorService = feedbackCalculatorService;
    }

    public List<ProductPreview> getProductsPreview() {
        List<Product> products = productService.getPreviewAllProducts();
        List<ProductPreview> result = new ArrayList<>(products.size());

        products.forEach(
                p -> {
                    ProductPreview previewDetail = new ProductPreview();
                    previewDetail.setProduct(p);
                    feedbackCalculatorService.collectForProductPreview(p, previewDetail);
                    result.add(previewDetail);
                }
        );

        return result;
    }

}
