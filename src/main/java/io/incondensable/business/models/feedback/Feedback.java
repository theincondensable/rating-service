package io.incondensable.business.models.feedback;

import io.incondensable.business.models.assets.Product;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Instant;

/**
 * @author abbas
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Lob
    private String comment;

    @Min(value = 1, message = "{vote.must.be.greater.or.equal.to.than.one}")
    @Max(value = 5, message = "{vote.must.be.less.than.or.equal.to.five}")
    private Byte vote;

    @Enumerated(value = EnumType.STRING)
    private FeedbackStateEnum feedbackState;

    @CreationTimestamp
    private Instant createdOn;
    @UpdateTimestamp
    private Instant lastUpdatedOn;

}
