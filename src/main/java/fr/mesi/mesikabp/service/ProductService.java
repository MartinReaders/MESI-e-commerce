package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.model.Product;
import org.springframework.data.domain.Page;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

public interface ProductService {
    Product createProduct(Product product) throws EntityExistsException;
    Product getProductById(Long idProduct) throws EntityNotFoundException;
    Page<Product> getProductByFilter(Integer page, Integer size, Long idBrand, Long idType) throws IllegalArgumentException;
    void deleteProduct(Long idProduct);
}
