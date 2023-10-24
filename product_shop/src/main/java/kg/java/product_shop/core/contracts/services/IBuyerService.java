package kg.java.product_shop.core.contracts.services;

import kg.java.product_shop.core.exceptions.EntityDuplicateExceptions;
import kg.java.product_shop.core.exceptions.EntityNotFoundException;
import kg.java.product_shop.core.models.dtos.buyer.*;
import org.springframework.http.HttpStatus;

public interface IBuyerService {
    BuyerDto register(CreateBuyerDto model) throws EntityDuplicateExceptions;
    BuyerDto update(UpdateBuyerDto model) throws EntityNotFoundException,EntityDuplicateExceptions;
    HttpStatus delete(DeleteBuyerDto model) throws EntityNotFoundException;
    BuyerDto getById(FindByIdBuyerDto model) throws EntityNotFoundException;
}
