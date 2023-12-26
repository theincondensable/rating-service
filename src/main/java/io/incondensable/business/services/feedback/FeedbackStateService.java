package io.incondensable.business.services.feedback;

import io.incondensable.business.exception.feedback.FeedbackChangeToSubmittedStateException;
import io.incondensable.business.models.feedback.Feedback;
import io.incondensable.business.models.feedback.FeedbackStateEnum;
import org.springframework.stereotype.Service;

/**
 * @author abbas
 */
@Service
public class FeedbackStateService {

    /**
     * <p>as the Feedback is submitted by the Customer or let's say User, its state must be set to SUBMITTED,
     * as it is the first stage of any Feedbacks submitted, then it can be whether REJECTED or APPROVED by the Manager.</p>
     *
     * <p>Whenever the Feedback is submitted, this method must be called.</p>
     * <p>This method actually mutates the Feedback object by setting its state to SUBMITTED.</p>
     *
     * @param feedback object to set its state with SUBMITTED.
     * @throws FeedbackChangeToSubmittedStateException when the state is about to be back to SUBMITTED from either REJECTED or APPROVED.
     */
    public void feedbackIsSubmitted(Feedback feedback) {
        if (feedback.getFeedbackState() != null) {
            if (feedback.getFeedbackState().equals(FeedbackStateEnum.SUBMITTED))
                return;

            if (feedback.getFeedbackState().equals(FeedbackStateEnum.REJECTED) || feedback.getFeedbackState().equals(FeedbackStateEnum.APPROVED))
                throw new FeedbackChangeToSubmittedStateException(feedback.getId());
        }

        feedback.setFeedbackState(FeedbackStateEnum.SUBMITTED);
    }

    /**
     * <p>For Feedbacks with SUBMITTED state, when the Manager feels that the Feedback is not proper or something, they might
     * want to REJECT it.</p>
     *
     * <p>The Manager might also want to change Feedback's state from APPROVED to REJECTED.</p>
     *
     * <p>This function also mutates the Feedback Object.</p>
     * <p>This Function must be called from an API.</p>
     *
     * @param feedback object to REJECTED from SUBMITTED or even APPROVED states.
     */
    public void rejectFeedback(Feedback feedback) {
        if (feedback.getFeedbackState().equals(FeedbackStateEnum.REJECTED))
            return;

        feedback.setFeedbackState(FeedbackStateEnum.REJECTED);
    }

    /**
     * <p>For Feedbacks with SUBMITTED or REJECTED state, the Manager can approve it.</p>
     *
     * <p>This function also mutates the Feedback Object.</p>
     * <p>This Function must be called from an API.</p>
     *
     * @param feedback object to APPROVED from SUBMITTED.
     */
    public void approveFeedback(Feedback feedback) {
        if (feedback.getFeedbackState().equals(FeedbackStateEnum.APPROVED))
            return;

        feedback.setFeedbackState(FeedbackStateEnum.APPROVED);
    }

}
