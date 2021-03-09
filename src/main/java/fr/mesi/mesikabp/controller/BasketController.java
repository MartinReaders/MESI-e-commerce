package fr.mesi.mesikabp.controller;

import fr.mesi.mesikabp.dto.ProductDto;
import fr.mesi.mesikabp.dto.UserDto;
import fr.mesi.mesikabp.model.Product;
import fr.mesi.mesikabp.model.User;
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
import java.util.Optional;

@Controller
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private ModelMapService modelMapService;

    @Autowired
    private BasketService basketService;

    @Autowired
    private ProductService productService;

    /*
     * Validé panier
     */
    @GetMapping("/checkout")
    public String getBasketPage(HttpServletRequest request, final ModelMap model) {
        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        if(userDto != null) {
            return "basket";
        } else {
            return "redirect:login";
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
                    model.put("errors", errors);
                }
                return "basket";
            } else {
                return "basket";
            }
        } else {
            return "redirect:login";
        }
    }

    @PostMapping("/delete")
    public String deleteProductToBasket(HttpServletRequest request, @RequestBody ProductDto productDto) {
        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        if(userDto != null) {
            User userDao = modelMapService.convertToDao(userDto);
            return "basket";
        } else {
            return "redirect:login";
        }
    }


}
