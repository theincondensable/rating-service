package io.incondensable.business.services.feedback;

import io.incondensable.business.models.aggregates.ProductPreview;
import io.incondensable.business.models.assets.Product;
import io.incondensable.business.models.feedback.Feedback;
import io.incondensable.business.repositories.FeedbackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>This Service is responsible for collecting Votes and Comments based on the requirements below:
 * <li>Last Three Comments on a Product</li>
 * <li>Average of all the Votes on a product</li>
 * <li>The Count of all Comments on a product</li>
 * </p>
 *
 * @author abbas
 */
@Service
public class FeedbackCalculatorService {

    private final FeedbackRepository repository;

    public FeedbackCalculatorService(FeedbackRepository feedbackRepository) {
        this.repository = feedbackRepository;
    }

    /**
     * <p>mutates the input ProductPreviewDetail object and setting required values.</p>
     *
     * @param product the Product to get its Preview Details
     * @param preview the ProductPreviewDetails aggregation which contains the vote average, vote count, and last three comments
     */
    @Transactional(readOnly = true)
    public void collectForProductPreview(Product product, ProductPreview preview) {
        List<Feedback> feedbacks = repository.findAllByProductIdOrderedDescending(product.getId());

        int count = (int) feedbacks.stream().filter(f -> f.getVote() != null).count();
        double voteAverage = feedbacks.stream().filter(f -> f.getVote() != null).mapToInt(Feedback::getVote).summaryStatistics().getAverage();

        preview.setVoteCount(count);
        preview.setVoteAverage(voteAverage);

        List<String> comments = feedbacks.stream().map(Feedback::getComment).limit(3).toList();
        preview.setComments(comments);
    }

}
