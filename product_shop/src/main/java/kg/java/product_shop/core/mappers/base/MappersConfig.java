package kg.java.product_shop.core.mappers.base;

import kg.java.product_shop.core.mappers.BuyerMapper;
import kg.java.product_shop.core.mappers.ProductMapper;
import kg.java.product_shop.core.mappers.PurchaseMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfig {
    @Bean
    public BuyerMapper buildBuyerMapper() {
        return new BuyerMapper();
    }

    @Bean
    public ProductMapper buildProductMapper() {
        return new ProductMapper();
    }

    @Bean
    public PurchaseMapper buildPurchaseMapper() {
        return new PurchaseMapper();
    }
}
