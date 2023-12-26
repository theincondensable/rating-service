package io.incondensable.business.repositories;

import io.incondensable.business.models.feedback.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author abbas
 */
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query("select f from Feedback f where f.product.id = :productId")
    List<Feedback> findAllByProductId(@Param("productId") long productId);

    @Query("select f from Feedback f where f.product.id = :productId order by f.id desc")
    List<Feedback> findAllByProductIdOrderedDescending(@Param("productId") long productId);

}
