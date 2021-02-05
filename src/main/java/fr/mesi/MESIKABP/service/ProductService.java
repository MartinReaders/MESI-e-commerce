package fr.mesi.MESIKABP.service;

import fr.mesi.MESIKABP.model.Produit;
import org.springframework.data.domain.Page;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

public interface ProductService {
    void createProduct(Produit produit) throws EntityExistsException;
    Produit getProductById(Long idProduct) throws EntityNotFoundException;
    Page<Produit> getProductByFilter(Integer page, Integer size) throws IllegalArgumentException;
}
