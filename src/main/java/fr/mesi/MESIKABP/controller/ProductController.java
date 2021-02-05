package fr.mesi.MESIKABP.controller;

import fr.mesi.MESIKABP.model.Produit;
import fr.mesi.MESIKABP.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String getProductPage(final ModelMap model, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "15") Integer size) {
        List<String> errors = new ArrayList<>();
        try {
            model.put("productList", productService.getProductByFilter(page, size));
            //Si tout se passe bien on retourne le template avec ses données
            return "listeProduits";
        } catch(IllegalArgumentException illegalArgumentException) {
            errors.add(illegalArgumentException.getMessage()); //On ajoute le message d'erreur a la liste
            model.put("errors", errors); //On passe la liste des erreurs au template
            //Une erreur est survenue
            return "listeProduits";
        }
    }

    @GetMapping("/{idProduct}")
    public String getProductPageById(final ModelMap model, @PathVariable Long idProduct) {
        List<String> errors = new ArrayList<>();
        try {
            Produit produit = productService.getProductById(idProduct);
            model.put("product", produit);
            return "detailProduit";
        } catch(EntityNotFoundException entityNotFoundException) {
            //L'article n'existe pas
            errors.add(entityNotFoundException.getMessage()); //On ajoute le message d'erreur a la liste
            model.put("errors", errors); //On passe la liste des erreurs au template
            return "404";
        }
    }

    @PostMapping
    public RedirectView createProduct(@RequestBody Produit product) {
        try {
            createProduct(product);
            //Le produit a été crée alors on redirige vers sa page
            return new RedirectView("/product/"+product.getCode());
        } catch(EntityExistsException entityExistsException) {
            //Le code produit existe déjà alors on redirige vers la liste d'article TODO a voir pour rajouter les erreurs a la page
            return new RedirectView("/product");
        }
    }
}
