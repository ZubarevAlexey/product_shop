package kg.java.product_shop.core.models.dtos.purchase;

import kg.java.product_shop.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class FindByIdPurchaseDto extends BaseDto {
}
