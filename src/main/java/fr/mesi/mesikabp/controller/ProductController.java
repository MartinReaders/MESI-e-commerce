package fr.mesi.mesikabp.controller;

import fr.mesi.mesikabp.dto.ProductDto;
import fr.mesi.mesikabp.model.Product;
import fr.mesi.mesikabp.service.ModelMapService;
import fr.mesi.mesikabp.service.ProductService;
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
    private ModelMapService modelMapService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public String getProductPage(final ModelMap model, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "15") Integer size) {
        List<String> errors = new ArrayList<>();
        try {
            model.put("productList", productService.getProductByFilter(page, size));
            //Si tout se passe bien on retourne le template avec ses données
            return "productList";
        } catch(IllegalArgumentException illegalArgumentException) {
            errors.add(illegalArgumentException.getMessage()); //On ajoute le message d'erreur a la liste
            model.put("errors", errors); //On passe la liste des erreurs au template
            //Une erreur est survenue
            return "productList";
        }
    }

    @GetMapping("/{idProduct}")
    public String getProductPageById(final ModelMap model, @PathVariable Long idProduct) {
        List<String> errors = new ArrayList<>();
        try {
            //Get product by id and transform DAO to DTO
            ProductDto productDto = modelMapService.convertToDto(productService.getProductById(idProduct));
            model.put("product", productDto);
            return "productDetail";
        } catch(EntityNotFoundException entityNotFoundException) {
            //Product doesn't exist
            errors.add(entityNotFoundException.getMessage()); //On ajoute le message d'erreur a la liste
            model.put("errors", errors); //On passe la liste des erreurs au template
            return "error404";
        }
    }

    @PostMapping
    public RedirectView createProduct(@RequestBody ProductDto productDto) {
        Product productDao = modelMapService.convertToDao(productDto);
        try {
            productService.createProduct(productDao);
            //Le produit a été crée alors on redirige vers sa page
            return new RedirectView("/product/"+productDto.getCode());
        } catch(EntityExistsException entityExistsException) {
            //Le code produit existe déjà alors on redirige vers la liste d'article TODO a voir pour rajouter les erreurs a la page
            return new RedirectView("/product");
        }
    }
}
