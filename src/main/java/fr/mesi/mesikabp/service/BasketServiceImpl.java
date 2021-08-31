package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.model.Basket;
import fr.mesi.mesikabp.model.Product;
import fr.mesi.mesikabp.model.User;
import fr.mesi.mesikabp.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private BasketRepository basketRepository;

    public static final String EXCEPTION_PRODUCT_ALREADY_IN_BASKET = "Le produit est déjà dans votre panier !";
    public static final String EXCEPTION_PRODUCT_NOT_IN_BASKET = "Le produit n'est pas dans le panier !";
    public static final String EXCEPTION_BASKET_DOESNT_EXISTS = "Le panier n'existe pas !";

    @Override
    public void addProductToBasket(User userDao, Product product) throws EntityExistsException {
        Basket basketDao = getBasket(userDao);

        boolean isExistInBasket = isProductAlreadyInBasket(userDao, product);

        if(isExistInBasket) {
            //In normal way, never
            throw new EntityExistsException(EXCEPTION_PRODUCT_ALREADY_IN_BASKET);
        } else {
            basketDao.getProducts().add(product);
            basketRepository.save(basketDao);
        }
    }

    @Override
    public void deleteProductToBasket(User userDao, Product product) throws EntityNotFoundException {
        Optional<Basket> basketOptional = basketRepository.findBasketLinkToUser(userDao.getId());
        if(basketOptional.isPresent()) {
            //Basket exist, we can delete product from basket
            Basket basketDao = basketOptional.get();

            boolean isExistInBasket = isProductAlreadyInBasket(userDao, product);

            if(isExistInBasket) {
                basketDao.setProducts(basketDao.getProducts().stream().filter(p -> p.getId() != product.getId()).collect(Collectors.toSet()));
                basketRepository.save(basketDao);
            }
        } else {
            //Basket doesn't exist, throw an exception
            throw new EntityNotFoundException(EXCEPTION_BASKET_DOESNT_EXISTS);
        }
    }

    @Override
    public void dumpBasket(User userDao) {
        Optional<Basket> basketOptional = basketRepository.findBasketLinkToUser(userDao.getId());
        if(basketOptional.isPresent()) {
//            linkBasketProductRepository.deleteAllBasketLineOfBasket(basketOptional.get().getId());
            //Basket is now empty
        } else {
            //Basket doesn't exist, throw an exception
            throw new EntityNotFoundException(EXCEPTION_BASKET_DOESNT_EXISTS);
        }
    }

    @Override
    public boolean isProductAlreadyInBasket(User userDao, Product product) {
        Basket basketDao = getBasket(userDao);

        return basketDao.getProducts().stream().anyMatch(p -> p.getId().equals(product.getId()));
    }

    @Override
    public Basket getBasket(User userDao) {
        Optional<Basket> basketOptional = basketRepository.findBasketLinkToUser(userDao.getId());
        Basket basketDao;
        if(basketOptional.isPresent()) {
            basketDao = basketOptional.get();
        } else {
            basketDao = new Basket();
            basketDao.setUser(userDao);
            basketDao = basketRepository.save(basketDao); //Save basket
        }
        return basketDao;
    }


}
