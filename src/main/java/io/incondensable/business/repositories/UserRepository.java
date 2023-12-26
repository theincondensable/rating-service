package io.incondensable.business.repositories;

import io.incondensable.business.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author abbas
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
