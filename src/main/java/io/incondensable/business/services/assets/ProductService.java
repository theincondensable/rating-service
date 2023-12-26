package io.incondensable.business.services.assets;

import io.incondensable.business.exception.assets.ProductNotFoundWithId;
import io.incondensable.business.exception.feedback.CommentNotPossibleException;
import io.incondensable.business.exception.feedback.VoteNotPossibleException;
import io.incondensable.business.models.assets.Product;
import io.incondensable.business.models.feedback.Feedback;
import io.incondensable.business.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * @author abbas
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Product> getPreviewAllProducts() {
        return productRepository.findProductsPreview();
    }

    @Transactional(readOnly = true)
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(
                () -> {
                    throw new ProductNotFoundWithId(productId);
                }
        );
    }

    public Product changeCommentable(Long productId, boolean commentFlag) {
        Product product = getProductById(productId);

        if (product.isCommentable() != commentFlag) {
            product.setCommentable(commentFlag);
            product.setLastUpdatedOn(Instant.now());
            productRepository.save(product);
        }

        return product;
    }

    public Product changeVotable(Long productId, boolean voteFlag) {
        Product product = getProductById(productId);

        if (product.isVotable() != voteFlag) {
            product.setVotable(voteFlag);
            product.setLastUpdatedOn(Instant.now());
            productRepository.save(product);
        }

        return product;
    }

    public Product changeOpenToAll(Long productId, boolean openFlag) {
        Product product = getProductById(productId);

        if (product.isOpenToAll() != openFlag) {
            product.setOpenToAll(openFlag);
            product.setLastUpdatedOn(Instant.now());
            productRepository.save(product);
        }

        return product;
    }

    public void validateSubmittingFeedbackOnProduct(Feedback req, Product product) {
        if (!product.isCommentable() && Objects.nonNull(req.getComment()))
            throw new CommentNotPossibleException(product.getId());

        if (!product.isVotable() && Objects.nonNull(req.getVote()))
            throw new VoteNotPossibleException(product.getId());
    }
}
