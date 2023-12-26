package io.incondensable.business.repositories;

import io.incondensable.business.models.assets.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author abbas
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select new Product(p.id, p.name, p.color) from Product p")
    List<Product> findProductsPreview();

}
