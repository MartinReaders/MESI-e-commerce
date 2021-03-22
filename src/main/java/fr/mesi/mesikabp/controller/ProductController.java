package fr.mesi.mesikabp.controller;

import fr.mesi.mesikabp.dto.ProductDto;
import fr.mesi.mesikabp.dto.UserDto;
import fr.mesi.mesikabp.model.Product;
import fr.mesi.mesikabp.service.ModelMapService;
import fr.mesi.mesikabp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ModelMapService modelMapService;

    @Autowired
    private ProductService productService;

    private static final String TEMPLATE_NAME_PRODUCT_LIST = "productList";
    private static final String TEMPLATE_NAME_PRODUCT_DETAIL = "productDetail";
    private static final String TEMPLATE_NAME_ERROR_404 = "error404";

    @GetMapping
    public String getProductPage(final ModelMap model, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "15") Integer size) {
        List<String> errors = new ArrayList<>();
        try {
            model.put("productList", productService.getProductByFilter(page, size));
            //Si tout se passe bien on retourne le template avec ses données
            return TEMPLATE_NAME_PRODUCT_LIST;
        } catch(IllegalArgumentException illegalArgumentException) {
            errors.add(illegalArgumentException.getMessage()); //On ajoute le message d'erreur a la liste
            model.put("errors", errors); //On passe la liste des erreurs au template
            //Une erreur est survenue
            return TEMPLATE_NAME_PRODUCT_LIST;
        }
    }

    @GetMapping("/{idProduct}")
    public String getProductPageById(final ModelMap model, @PathVariable Long idProduct) {
        List<String> errors = new ArrayList<>();
        try {
            //Get product by id and transform DAO to DTO
            ProductDto productDto = modelMapService.convertToDto(productService.getProductById(idProduct));
            model.put("product", productDto);
            return TEMPLATE_NAME_PRODUCT_DETAIL;
        } catch(EntityNotFoundException entityNotFoundException) {
            //Product doesn't exist
            errors.add(entityNotFoundException.getMessage()); //On ajoute le message d'erreur a la liste
            model.put("errors", errors); //On passe la liste des erreurs au template
            return TEMPLATE_NAME_ERROR_404;
        }
    }

    /*
     * Only connected, only admin
     */
    @PostMapping
    public String createProduct(HttpServletRequest request, @RequestBody ProductDto productDto) {
        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        if(userDto != null) {
            try {
                Product productCreated = productService
                        .createProduct(modelMapService.convertToDao(productDto));
                //Le produit a été crée alors on redirige vers sa page
                return "redirect:/product/"+productCreated.getCode();
            } catch(EntityExistsException entityExistsException) {
                return "redirect:/product";
            }
        } else {
            //Not connected, redirect to login
            return "redirect:/login";
        }
    }
}
