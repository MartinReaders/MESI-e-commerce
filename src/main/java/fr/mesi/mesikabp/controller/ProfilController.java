package fr.mesi.mesikabp.controller;

import fr.mesi.mesikabp.Util;
import fr.mesi.mesikabp.dto.UserDto;
import fr.mesi.mesikabp.model.Basket;
import fr.mesi.mesikabp.repository.BrandRepository;
import fr.mesi.mesikabp.repository.TypeProductRepository;
import fr.mesi.mesikabp.service.AuthService;
import fr.mesi.mesikabp.service.BasketService;
import fr.mesi.mesikabp.service.ModelMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import static fr.mesi.mesikabp.Constantes.*;

@Controller
public class ProfilController {

    @Autowired
    private ModelMapService modelMapService;

    @Autowired
    private AuthService authService;

    @Autowired
    private BasketService basketService;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private TypeProductRepository typeProductRepository;

    @GetMapping("/profile")
    public String getProfilPage(HttpServletRequest request, final ModelMap model) {
        if(authService.isAuthenticated(request.getSession())) {
            UserDto userDto = authService.getUserInfoByLogin(((UserDto) request.getSession().getAttribute("user")).getLogin());
            Basket basketDao = basketService.getBasket(modelMapService.convertToDao(userDto));

            Util.putValueForHeader(model, userDto, basketDao.getProducts().size(), brandRepository.findAll(), typeProductRepository.findAll());
            return "profile";
        } else {
            return REDIRECT_LOGIN;
        }
    }

    @GetMapping("/profile/{idProfile}/order/{idOrder}")
    public String getOrderPage(final ModelMap model, @PathVariable Long idProfile, @PathVariable Long idOrder) {
        return "profile";
    }
}
