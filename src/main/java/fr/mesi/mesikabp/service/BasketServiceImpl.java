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
import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private LinkBasketProductRepository linkBasketProductRepository;

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
            throw new EntityExistsException("Le produit est déjà dans votre panier !");
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
    public void deleteProductToBasket(User userDao, Product product) {
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
            }
        } else {
            //Basket doesn't exist, throw an exception
        }
    }
}
