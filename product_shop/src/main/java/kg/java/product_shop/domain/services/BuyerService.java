package kg.java.product_shop.domain.services;

import kg.java.product_shop.core.contracts.services.IBuyerService;
import kg.java.product_shop.core.exceptions.EntityDuplicateExceptions;
import kg.java.product_shop.core.exceptions.EntityNotFoundException;
import kg.java.product_shop.core.mappers.BuyerMapper;
import kg.java.product_shop.core.models.dtos.buyer.*;
import kg.java.product_shop.data.BuyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BuyerService implements IBuyerService {

    private final BuyerMapper buyerMapper;
    private final BuyerRepository buyerRepository;

    @Override
    public BuyerDto register(CreateBuyerDto model) throws EntityDuplicateExceptions {
        var buyer = buyerRepository.findBuyerEntityByFirstName(model.getFirstName());
        if (buyer.isPresent()) throw new EntityDuplicateExceptions();
        var entity = buyerRepository.save(buyerMapper.fromDomain(model));
        return buyerMapper.toDomain(entity);
    }

    @Override
    public BuyerDto update(UpdateBuyerDto model) throws EntityNotFoundException, EntityDuplicateExceptions {
        var buyer = buyerRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = buyer.toBuilder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .build();
        buyerRepository.save(entity);
        return buyerMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteBuyerDto model) throws EntityNotFoundException {
        var buyer = buyerRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        buyerRepository.deleteById(buyer.getId());
        return HttpStatus.OK;
    }

    @Override
    public BuyerDto getById(FindByIdBuyerDto model) throws EntityNotFoundException {
        var buyer = buyerRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return buyerMapper.toDomain(buyer);
    }
}
