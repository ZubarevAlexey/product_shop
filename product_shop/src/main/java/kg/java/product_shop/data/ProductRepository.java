package kg.java.product_shop.data;

import kg.java.product_shop.core.models.dtos.product.ProductDto;
import kg.java.product_shop.core.models.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductDto> findProductEntityByName(String name);
}
