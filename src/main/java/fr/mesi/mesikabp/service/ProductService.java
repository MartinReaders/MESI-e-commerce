package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.model.Product;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface ProductService {
    Product createProduct(Product product) throws EntityExistsException;
    Product getProductById(Long idProduct) throws EntityNotFoundException;
    List<Product> getProductByFilter(Integer page, Integer size, Long idBrand) throws IllegalArgumentException;
    void deleteProduct(Long idProduct);
}
