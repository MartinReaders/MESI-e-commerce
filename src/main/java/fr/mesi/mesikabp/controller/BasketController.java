package fr.mesi.mesikabp.controller;

import fr.mesi.mesikabp.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basket")
public class BasketController {

    /*
     * Validé panier
     */
    @GetMapping("/checkout")
    public String getBasketPage(final ModelMap model) {
        return "basket";
    }

    @PostMapping("/add")
    public void addProductToBasket(@RequestBody ProductDto productDto) {

    }

    @PostMapping("/delete")
    public void deleteProductToBasket(@RequestBody ProductDto productDto) {

    }


}
