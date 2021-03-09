package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.model.Product;
import fr.mesi.mesikabp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public static final String exceptionProductCodeAlreadyExists = "Le code pour ce produit existe déjà !";
    public static final String exceptionProductDoesntExists = "Le produit demandé n'existe pas !";
    public static final String exceptionNegativePage = "Impossible d'accéder a une page négative !";
    public static final String exceptionSizePageNull = "Impossible de demander une taille de page nulle !";

    @Override
    public Product createProduct(Product product) throws EntityExistsException {
        if(productRepository.findByCode(product.getCode()).isPresent()) {
            //Le produit existe déjà alors on lève une exception pour gérér l'erreur plus haut
            throw new EntityExistsException(exceptionProductCodeAlreadyExists);
        } else {
            //On enregistre le nouveau produit
            return productRepository.save(product);
        }
    }

    @Override
    public Product getProductById(Long idProduct) throws EntityNotFoundException {
        Optional<Product> productOpt = productRepository.findById(idProduct);
        if(productOpt.isPresent()) {
            //Le produit existe on le retourne
            return productOpt.get();
        } else {
            //Le produit n'existe pas alors on lève un exception
            throw new EntityNotFoundException(exceptionProductDoesntExists);
        }
    }

    @Override
    public Page<Product> getProductByFilter(Integer page, Integer size) throws IllegalArgumentException {
        if(page < 0) {
            throw new IllegalArgumentException(exceptionNegativePage);
        }

        if(size < 1) {
            throw new IllegalArgumentException(exceptionSizePageNull);
        }
        //TODO Limite sur les paramètre
//        Long countProduct = productRepository.count(); // 20
//        if(countProduct % size == 0) {
//
//        }

        //Retourne la page N°page comprenant size produits sans aucun tri
        return productRepository.findAll(PageRequest.of(page, size));
    }
}
