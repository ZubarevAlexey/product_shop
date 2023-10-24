package kg.java.product_shop.domain.facades;

import kg.java.product_shop.core.contracts.facade.IBuyerFacade;
import kg.java.product_shop.core.contracts.services.IBuyerService;
import kg.java.product_shop.core.exceptions.EntityDuplicateExceptions;
import kg.java.product_shop.core.exceptions.EntityNotFoundException;
import kg.java.product_shop.core.models.dtos.buyer.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuyerFacade implements IBuyerFacade {
    private final IBuyerService buyerService;

    @Override
    public BuyerDto register(CreateBuyerDto model) throws EntityDuplicateExceptions {
        return buyerService.register(model);
    }

    @Override
    public BuyerDto update(UpdateBuyerDto model) throws EntityNotFoundException, EntityDuplicateExceptions {
        return buyerService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteBuyerDto model) throws EntityNotFoundException {
        return buyerService.delete(model);
    }

    @Override
    public BuyerDto getById(FindByIdBuyerDto model) throws EntityNotFoundException {
        return buyerService.getById(model);
    }
}
