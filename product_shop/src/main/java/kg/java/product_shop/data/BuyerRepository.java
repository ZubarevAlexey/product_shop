package kg.java.product_shop.data;

import kg.java.product_shop.core.models.entities.BuyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyerRepository extends JpaRepository<BuyerEntity, Long> {

    Optional<BuyerEntity> findBuyerEntityByFirstName(String firstName);
}
