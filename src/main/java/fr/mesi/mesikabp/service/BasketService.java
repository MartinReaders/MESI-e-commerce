package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.model.Product;
import fr.mesi.mesikabp.model.User;

public interface BasketService {

    void addProductToBasket(User userDao, Product product);
    void deleteProductToBasket(User userDao, Product product);
}
