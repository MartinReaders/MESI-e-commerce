package fr.mesi.mesikabp.controller;

import fr.mesi.mesikabp.Constantes;
import fr.mesi.mesikabp.dto.ProductDto;
import fr.mesi.mesikabp.dto.UserDto;
import fr.mesi.mesikabp.model.Basket;
import fr.mesi.mesikabp.model.Product;
import fr.mesi.mesikabp.service.AuthService;
import fr.mesi.mesikabp.service.BasketService;
import fr.mesi.mesikabp.service.ModelMapService;
import fr.mesi.mesikabp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static fr.mesi.mesikabp.Constantes.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ModelMapService modelMapService;

    @Autowired
    private ProductService productService;

    @Autowired
    private AuthService authService;

    @Autowired
    private BasketService basketService;

    @GetMapping
    public String getProductPage(HttpServletRequest request, final ModelMap model
            , @RequestParam(defaultValue = "0") Integer page
            , @RequestParam(defaultValue = "15") Integer size
            , @RequestParam(defaultValue = "0") Long brand) {
        if(authService.isAuthenticated(request.getSession())) {
            List<String> errors = new ArrayList<>();
            UserDto userDto = authService.getUserInfoByLogin(((UserDto) request.getSession().getAttribute("user")).getLogin());
            Basket basketDao = basketService.getBasket(modelMapService.convertToDao(userDto));
            try {
                Page<Product> productPage = productService.getProductByFilter(page, size, brand);
                model.put("productList", productPage);
                model.put("user", userDto);
                model.put("nbProduct", basketDao.getProducts().size());
                model.put("size", size);
                model.put("pageNumber", page + 1);
                model.put("previousPage", page - 1);
                model.put("nextPage", page + 1);
                model.put("start", page * size + 1);
                model.put("end", (page)*size + productPage.getNumberOfElements());
                //Si tout se passe bien on retourne le template avec ses données
                return TEMPLATE_NAME_PRODUCT_LIST;
            } catch(IllegalArgumentException illegalArgumentException) {
                errors.add(illegalArgumentException.getMessage()); //On ajoute le message d'erreur a la liste
                model.put("errors", errors); //On passe la liste des erreurs au template
                model.put("nbProduct", basketDao.getProducts().size());
                //Une erreur est survenue
                return TEMPLATE_NAME_PRODUCT_LIST;
            }
        } else {
            return REDIRECT_LOGIN;
        }
    }

    @GetMapping("/{idProduct}")
    public String getProductPageById(HttpServletRequest request, final ModelMap model, @PathVariable Long idProduct) {
        if(authService.isAuthenticated(request.getSession())) {
            List<String> errors = new ArrayList<>();
            UserDto userDto = authService.getUserInfoByLogin(((UserDto) request.getSession().getAttribute("user")).getLogin());
            Basket basketDao = basketService.getBasket(modelMapService.convertToDao(userDto));
            try {
                //Get product by id and transform DAO to DTO
                Product product = productService.getProductById(idProduct);
                ProductDto productDto = modelMapService.convertToDto(product);
                model.put("product", productDto);
                model.put("user", userDto);
                model.put("nbProduct", basketDao.getProducts().size());
                model.put("isExist", basketService.isProductAlreadyInBasket(modelMapService.convertToDao(userDto), modelMapService.convertToDao(productDto)));
                return TEMPLATE_NAME_PRODUCT_DETAIL;
            } catch(EntityNotFoundException entityNotFoundException) {
                //Product doesn't exist
                errors.add(entityNotFoundException.getMessage()); //On ajoute le message d'erreur a la liste
                model.put("errors", errors); //On passe la liste des erreurs au template
                return TEMPLATE_NAME_ERROR_404;
            }
        } else {
            return REDIRECT_LOGIN;
        }
    }

    /*
     * Only connected, only admin
     */
    @PostMapping
    public String createProduct(HttpServletRequest request, @RequestBody ProductDto productDto) {
        if(authService.isAuthenticated(request.getSession())) {
            try {
                Product productCreated = productService
                        .createProduct(modelMapService.convertToDao(productDto));
                //Le produit a été crée alors on redirige vers sa page
                return "redirect:/product/"+productCreated.getCode();
            } catch(EntityExistsException entityExistsException) {
                return "redirect:/product";
            }
        } else {
            return REDIRECT_LOGIN;
        }
    }
}
