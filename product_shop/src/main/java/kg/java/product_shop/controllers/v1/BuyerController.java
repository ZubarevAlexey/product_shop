package kg.java.product_shop.controllers.v1;

import kg.java.product_shop.core.contracts.facade.IBuyerFacade;
import kg.java.product_shop.core.exceptions.EntityDuplicateExceptions;
import kg.java.product_shop.core.exceptions.EntityNotFoundException;
import kg.java.product_shop.core.models.dtos.buyer.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/buyer")
@RequiredArgsConstructor
public class BuyerController {
    private final IBuyerFacade buyerFacade;

    @PostMapping("/signup")
    public ResponseEntity<BuyerDto> register(@RequestBody CreateBuyerDto request) {
        try {
            return ResponseEntity.ok(buyerFacade.register(request));
        } catch (EntityDuplicateExceptions e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<BuyerDto> update(@RequestBody UpdateBuyerDto request) {
        try {
            return ResponseEntity.ok(buyerFacade.update(request));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeleteBuyerDto request) {
        try {
            return ResponseEntity.ok(buyerFacade.delete(request));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/id")
    public ResponseEntity<BuyerDto> getById(@RequestBody FindByIdBuyerDto request) {
        try {
            return ResponseEntity.ok(buyerFacade.getById(request));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
