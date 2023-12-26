package io.incondensable.business.services.feedback;

import io.incondensable.business.exception.feedback.FeedbackNotFoundWithId;
import io.incondensable.business.models.assets.Product;
import io.incondensable.business.models.feedback.Feedback;
import io.incondensable.business.models.feedback.FeedbackStateEnum;
import io.incondensable.business.repositories.FeedbackRepository;
import io.incondensable.business.services.assets.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

/**
 * @author abbas
 */
@Service
public class FeedbackService {

    private final ProductService productService;
    private final FeedbackRepository feedbackRepository;
    private final FeedbackStateService feedbackStateService;

    public FeedbackService(ProductService productService, FeedbackRepository feedbackRepository, FeedbackStateService feedbackStateService) {
        this.productService = productService;
        this.feedbackRepository = feedbackRepository;
        this.feedbackStateService = feedbackStateService;
    }

    @Transactional(readOnly = true)
    public List<Feedback> getAllFeedbacksForManager() {
        return feedbackRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Feedback> getAllFeedbacksForManagerOfProduct(Long productId) {
        return feedbackRepository.findAllByProductId(
                productService.getProductById(productId).getId()
        );
    }

    @Transactional(readOnly = true)
    public List<Feedback> getOnlySubmittedFeedbacksForManagerOfProduct(Long productId) {
        return feedbackRepository.findAllByProductId(
                productService.getProductById(productId).getId()
        ).stream().filter(
                feedback -> feedback.getFeedbackState().equals(FeedbackStateEnum.SUBMITTED)
        ).toList();
    }

    public Feedback submitFeedback(Feedback req) {
        Product product = productService.getProductById(req.getProduct().getId());
        req.setProduct(product);

        productService.validateSubmittingFeedbackOnProduct(req, product);

        feedbackStateService.feedbackIsSubmitted(req);
        req.setCreatedOn(Instant.now());

        feedbackRepository.save(req);
        return req;
    }

    public Feedback rejectFeedback(Long feedbackId) {
        Feedback feedback = getFeedbackById(feedbackId);

        feedbackStateService.rejectFeedback(feedback);
        feedback.setLastUpdatedOn(Instant.now());
        feedbackRepository.save(feedback);

        return feedback;
    }

    public Feedback approveFeedback(Long feedbackId) {
        Feedback feedback = getFeedbackById(feedbackId);

        feedbackStateService.approveFeedback(feedback);
        feedback.setLastUpdatedOn(Instant.now());
        feedbackRepository.save(feedback);

        return feedback;
    }

    private Feedback getFeedbackById(Long feedbackId) {
        return feedbackRepository.findById(feedbackId).orElseThrow(
                () -> {
                    throw new FeedbackNotFoundWithId(feedbackId);
                }
        );
    }

}
