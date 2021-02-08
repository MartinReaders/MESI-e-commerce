package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.model.Produit;
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

    @Override
    public void createProduct(Produit produit) throws EntityExistsException {
        if(productRepository.findByCode(produit.getCode()).isPresent()) {
            //Le produit existe déjà alors on lève une exception pour gérér l'erreur plus haut
            throw new EntityExistsException("Le code pour ce produit existe déjà !"); //TODO Constante
        } else {
            //On enregistre le nouveau produit
            productRepository.save(produit);
        }
    }

    @Override
    public Produit getProductById(Long idProduct) throws EntityNotFoundException {
        Optional<Produit> productOpt = productRepository.findById(idProduct);
        if(productOpt.isPresent()) {
            //Le produit existe on le retourne
            return productOpt.get();
        } else {
            //Le produit n'existe pas alors on lève un exception
            throw new EntityNotFoundException("Le produit demandé n'existe pas !"); //TODO Constante
        }
    }

    @Override
    public Page<Produit> getProductByFilter(Integer page, Integer size) throws IllegalArgumentException {
        if(page < 0) {
            throw new IllegalArgumentException("Impossible d'accéder a une page négative !"); //TODO Constante
        }

        if(size < 1) {
            throw new IllegalArgumentException("Impossible de demander une taille de page nulle !"); //TODO Constante
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
