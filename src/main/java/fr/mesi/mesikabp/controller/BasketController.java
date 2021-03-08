package fr.mesi.mesikabp.controller;

import fr.mesi.mesikabp.dto.ProductDto;
import fr.mesi.mesikabp.dto.UserDto;
import fr.mesi.mesikabp.model.User;
import fr.mesi.mesikabp.service.BasketService;
import fr.mesi.mesikabp.service.ModelMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private ModelMapService modelMapService;

    @Autowired
    private BasketService basketService;

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

    @PostMapping("/add")
    public String addProductToBasket(HttpServletRequest request, final ModelMap model, @RequestBody ProductDto productDto) {
        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        List<String> errors = new ArrayList<>();
        if(userDto != null) {
            try {
                basketService.addProductToBasket(
                        modelMapService.convertToDao(userDto), modelMapService.convertToDao(productDto));
            } catch(EntityExistsException entityExistsException) {
                errors.add(entityExistsException.getMessage());
                model.put("errors", errors);
            }
            return "basket";
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
