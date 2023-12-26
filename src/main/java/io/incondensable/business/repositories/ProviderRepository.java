package io.incondensable.business.repositories;

import io.incondensable.business.models.assets.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author abbas
 */
@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

}
