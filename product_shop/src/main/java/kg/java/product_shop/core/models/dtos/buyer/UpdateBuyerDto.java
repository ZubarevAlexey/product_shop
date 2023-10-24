package kg.java.product_shop.core.models.dtos.buyer;

import kg.java.product_shop.core.models.dtos.base.BaseDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdateBuyerDto extends BaseDto {
    private String firstName;
    private String lastName;
}
