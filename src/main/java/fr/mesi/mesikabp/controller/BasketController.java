package fr.mesi.mesikabp.controller;

import fr.mesi.mesikabp.Util;
import fr.mesi.mesikabp.dto.UserDto;
import fr.mesi.mesikabp.model.Basket;
import fr.mesi.mesikabp.model.Product;
import fr.mesi.mesikabp.repository.BrandRepository;
import fr.mesi.mesikabp.service.BasketService;
import fr.mesi.mesikabp.service.ModelMapService;
import fr.mesi.mesikabp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static fr.mesi.mesikabp.Constantes.*;

@Controller
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private ModelMapService modelMapService;

    @Autowired
    private BasketService basketService;

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandRepository brandRepository;

    private static final String TEMPLATE_NAME_BASKET = "basket";

    /*
     * Validé panier
     */
    @GetMapping("/checkout")
    public String getBasketPage(HttpServletRequest request, final ModelMap model) {
        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        if(userDto != null) {
            Basket basketDao = basketService.getBasket(modelMapService.convertToDao(userDto));
            Util.putValueForHeader(model, userDto, basketDao.getProducts().size(), brandRepository.findAll());

            model.put("productList", basketDao.getProducts());
            model.put("totalTTC", basketDao.getProducts().stream().map(Product::getPrice).reduce(0.0, Double::sum));
            return TEMPLATE_NAME_BASKET;
        } else {
            return REDIRECT_LOGIN;
        }
    }

    @PostMapping("/checkout")
    public String checkoutBasket(HttpServletRequest request, final ModelMap model) {
        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        if(userDto != null) {
            /*
             * Insert here code for basket validation
             */
            return REDIRECT_LOGIN;
        } else {
            return REDIRECT_LOGIN;
        }
    }

    @GetMapping("/add/{idProduct}")
    public String addProductToBasket(HttpServletRequest request, final ModelMap model, @PathVariable Long idProduct) {
        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        List<String> errors = new ArrayList<>();
        if(userDto != null) {
            Product productOptional = productService.getProductById(idProduct);
            if(productOptional != null) {
                try {
                    basketService.addProductToBasket(
                            modelMapService.convertToDao(userDto), productOptional);
                } catch(EntityExistsException entityExistsException) {
                    errors.add(entityExistsException.getMessage());
                }
            }
            model.put("errors", errors);
            model.put("user", userDto);
            return REDIRECT_BASKET;

        } else {
            model.put("errors", errors);
            return REDIRECT_LOGIN;
        }
    }

    @GetMapping("/delete/{idProduct}")
    public String deleteProductToBasket(HttpServletRequest request, @PathVariable Long idProduct) {
        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        if(userDto != null) {
            Product product = productService.getProductById(idProduct);
            basketService.deleteProductToBasket(modelMapService.convertToDao(userDto), product);
            return REDIRECT_BASKET;
        } else {
            return REDIRECT_LOGIN;
        }
    }
}
