package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.model.Product;
import fr.mesi.mesikabp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public static final String EXCEPTION_PRODUCT_CODE_ALREADY_EXISTS = "Le code pour ce produit existe déjà !";
    public static final String EXCEPTION_PRODUCT_DOESNT_EXISTS = "Le produit demandé n'existe pas !";
    public static final String EXCEPTION_NEGATIVE_PAGE = "Impossible d'accéder a une page négative !";
    public static final String EXCEPTION_SIZE_PAGE_NULL = "Impossible de demander une taille de page nulle !";

    @Override
    public Product createProduct(Product product) throws EntityExistsException {
        if(productRepository.findByCode(product.getCode()).isPresent()) {
            //Le produit existe déjà alors on lève une exception pour gérér l'erreur plus haut
            throw new EntityExistsException(EXCEPTION_PRODUCT_CODE_ALREADY_EXISTS);
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
            Product product = productOpt.get();
            product.setScore(productRepository.countAllLike(product.getId()));
            return product;
        } else {
            //Le produit n'existe pas alors on lève un exception
            throw new EntityNotFoundException(EXCEPTION_PRODUCT_DOESNT_EXISTS);
        }
    }

    @Override
    public Page<Product> getProductByFilter(Integer page, Integer size, Long idBrand) throws IllegalArgumentException {
        Page<Product> listProduct;

        if(page < 0) {
            throw new IllegalArgumentException(EXCEPTION_NEGATIVE_PAGE);
        }

        if(size < 1) {
            throw new IllegalArgumentException(EXCEPTION_SIZE_PAGE_NULL);
        }
        //TODO Limite sur les paramètre
//        Long countProduct = productRepository.count(); // 20
//        if(countProduct % size == 0) {
//
//        }

        if(idBrand > 0) {
            listProduct = productRepository.findAllByBrand(idBrand, PageRequest.of(page, size));
        } else {
            listProduct = productRepository.findAll(PageRequest.of(page, size));
        }

        return listProduct;
    }

    @Override
    public void deleteProduct(Long idProduct) {
        Optional<Product> product = productRepository.findById(idProduct);
        if(product.isPresent()) {
            productRepository.delete(product.get());
        } else {
            throw new EntityNotFoundException(EXCEPTION_PRODUCT_DOESNT_EXISTS);
        }
    }
}
