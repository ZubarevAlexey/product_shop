package kg.java.product_shop.core.mappers;

import kg.java.product_shop.core.models.dtos.buyer.BuyerDto;
import kg.java.product_shop.core.models.dtos.buyer.CreateBuyerDto;
import kg.java.product_shop.core.models.dtos.buyer.UpdateBuyerDto;
import kg.java.product_shop.core.models.entities.BuyerEntity;

public class BuyerMapper {

    public BuyerDto toDomain(BuyerEntity model) {
        return BuyerDto.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .build();
    }

    public BuyerEntity fromDomain(CreateBuyerDto model) {
        return BuyerEntity.builder()
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .build();
    }

    public BuyerEntity fromDomain(UpdateBuyerDto model) {
        return BuyerEntity.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .build();
    }

}
