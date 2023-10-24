package kg.java.product_shop.core.mappers;


import kg.java.product_shop.core.models.dtos.buyer.BuyerDto;
import kg.java.product_shop.core.models.dtos.product.ProductSearchDataDto;
import kg.java.product_shop.core.models.dtos.purchase.CreatedPurchaseDto;
import kg.java.product_shop.core.models.dtos.purchase.PurchaseDto;
import kg.java.product_shop.core.models.dtos.purchase.UpdatedPurchaseDto;
import kg.java.product_shop.core.models.entities.PurchaseEntity;


public class PurchaseMapper {
    public PurchaseDto toDomain(PurchaseEntity model) {
        var buyer = model.getBuyer();
        var product = model.getProduct();
        return PurchaseDto.builder()
                .id(model.getId())
                .datePurchase(model.getDatePurchase())
                .product(ProductSearchDataDto.builder()
                        .name(product.getName())
                        .cost(product.getCost())
                        .build())
                .buyer(BuyerDto.builder()
                        .firstName(buyer.getFirstName())
                        .lastName(buyer.getLastName())
                        .build())
                .build();
    }

    public PurchaseEntity fromDomain(CreatedPurchaseDto model){
        return PurchaseEntity.builder()
                .datePurchase(model.getDatePurchase())
                .build();
    }
    public PurchaseEntity fromDomain(UpdatedPurchaseDto model){
        return PurchaseEntity.builder()
                .id(model.getId())
                .datePurchase(model.getDatePurchase())
                .build();
    }
}
