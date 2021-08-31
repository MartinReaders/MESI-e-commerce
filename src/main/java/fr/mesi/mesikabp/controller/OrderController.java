package fr.mesi.mesikabp.controller;

import fr.mesi.mesikabp.dto.ProductDto;
import fr.mesi.mesikabp.dto.UserDto;
import fr.mesi.mesikabp.model.Product;
import fr.mesi.mesikabp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static fr.mesi.mesikabp.Constantes.*;

@Controller
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private AuthService authService;


    @GetMapping("/orderConfirmation")
    public String getProductPageById(HttpServletRequest request, final ModelMap model, @PathVariable Long idProduct) {
        if(authService.isAuthenticated(request.getSession())) {
            List<String> errors = new ArrayList<>();
            UserDto userDto = authService.getUserInfoByLogin(((UserDto) request.getSession().getAttribute("user")).getLogin());

            try {
                return TEMPLATE_NAME_ORDER_CONFIRMATION;
            } catch(EntityNotFoundException entityNotFoundException) {
                return TEMPLATE_NAME_ERROR_404;
            }


        } else {
            return REDIRECT_LOGIN;
        }
    }
}


