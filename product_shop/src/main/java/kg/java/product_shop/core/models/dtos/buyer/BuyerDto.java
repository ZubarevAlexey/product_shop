package kg.java.product_shop.core.models.dtos.buyer;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BuyerDto {
    private Long id;
    private String firstName;
    private String lastName;
}
