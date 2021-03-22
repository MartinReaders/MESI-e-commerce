package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.model.Basket;
import fr.mesi.mesikabp.model.LinkBasketProduct;
import fr.mesi.mesikabp.model.Product;
import fr.mesi.mesikabp.model.User;
import fr.mesi.mesikabp.repository.BasketRepository;
import fr.mesi.mesikabp.repository.LinkBasketProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private LinkBasketProductRepository linkBasketProductRepository;

    public static final String EXCEPTION_PRODUCT_ALREADY_IN_BASKET = "Le produit est déjà dans votre panier !";
    public static final String EXCEPTION_PRODUCT_NOT_IN_BASKET = "Le produit n'est pas dans le panier !";
    public static final String EXCEPTION_BASKET_DOESNT_EXISTS = "Le panier n'existe pas !";

    @Override
    public void addProductToBasket(User userDao, Product product) throws EntityExistsException {
        Optional<Basket> basketOptional = basketRepository.findBasketLinkToUser(userDao.getId());
        Basket basketDao;
        if(basketOptional.isPresent()) {
            basketDao = basketOptional.get();
        } else {
            basketDao = new Basket();
            basketDao.setUser(userDao);
            basketDao = basketRepository.save(basketDao); //Save basket
        }

        Optional<LinkBasketProduct> linkBasketProductOptional =
                linkBasketProductRepository.findBasketLine(basketDao.getId(), product.getId());
        LinkBasketProduct linkBasketProduct;
        if(linkBasketProductOptional.isPresent()) {
            //Product already exist in this basket
            throw new EntityExistsException(EXCEPTION_PRODUCT_ALREADY_IN_BASKET);
        } else {
            //We add product in basket
            linkBasketProduct = new LinkBasketProduct();
            linkBasketProduct.setBasket(basketDao);
            linkBasketProduct.setProduct(product);
            linkBasketProduct.setQuantity(1); //Value by default
            linkBasketProductRepository.save(linkBasketProduct); //Save basket line
        }
    }

    @Override
    public void deleteProductToBasket(User userDao, Product product) throws EntityNotFoundException {
        Optional<Basket> basketOptional = basketRepository.findBasketLinkToUser(userDao.getId());
        if(basketOptional.isPresent()) {
            //Basket exist, we can delete product from basket
            Basket basketDao = basketOptional.get();
            Optional<LinkBasketProduct> linkBasketProductOptional =
                    linkBasketProductRepository.findBasketLine(basketDao.getId(), product.getId());
            if(linkBasketProductOptional.isPresent()) {
                //Product exist in basket, it can be deleted
                linkBasketProductRepository.delete(linkBasketProductOptional.get());
            } else {
                //Product doesn't exist in basket, throw an exception
                throw new EntityNotFoundException(EXCEPTION_PRODUCT_NOT_IN_BASKET);
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
            linkBasketProductRepository.deleteAllBasketLineOfBasket(basketOptional.get().getId());
            //Basket is now empty
        } else {
            //Basket doesn't exist, throw an exception
            throw new EntityNotFoundException(EXCEPTION_BASKET_DOESNT_EXISTS);
        }
    }
}
