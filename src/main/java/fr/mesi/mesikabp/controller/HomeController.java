package fr.mesi.mesikabp.controller;


import fr.mesi.mesikabp.Constantes;
import fr.mesi.mesikabp.dto.UserDto;
import fr.mesi.mesikabp.repository.BrandRepository;
import fr.mesi.mesikabp.repository.ProductRepository;
import fr.mesi.mesikabp.service.AuthService;
import fr.mesi.mesikabp.service.ModelMapService;
import fr.mesi.mesikabp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelMapService modelMapService;

    @Autowired
    private AuthService authService;


    @GetMapping(value = "/home")
    public String getHomePage(HttpServletRequest request, final ModelMap model) {
        if(authService.isAuthenticated(request.getSession())) {
            UserDto userDto = authService.getUserInfoByLogin(((UserDto) request.getSession().getAttribute("user")).getLogin());

            model.put("products", productService.getProductByFilter(0, 7));
            model.put("listeBestProduct", productService.getProductByFilter(2, 10));
            model.put("listeSoonProduct", productService.getProductByFilter(1, 5));
            model.put("listeBrand", brandRepository.findAll());

            model.put("user", userDto);

            return "home";
        } else {
            return Constantes.REDIRECT_LOGIN;
        }
    }
}
