package fr.mesi.mesikabp.controller;

import fr.mesi.mesikabp.dto.UserDto;
import fr.mesi.mesikabp.service.AuthService;
import fr.mesi.mesikabp.service.ModelMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfilController {

    @Autowired
    private ModelMapService modelMapService;

    @Autowired
    private AuthService authService;

    @GetMapping("/profile")
    public String getProfilPage(HttpServletRequest request, final ModelMap model) {
        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        if(userDto == null) {
            //Retourner 402
            return "";
        }

        userDto = modelMapService.convertToDto(authService.getUserInfoByLogin(userDto.getLogin()));
        model.put("user", userDto);
        return "profile";
    }

    @GetMapping("/profile/{idProfile}/order/{idOrder}")
    public String getOrderPage(final ModelMap model, @PathVariable Long idProfile, @PathVariable Long idOrder) {
        return "profile";
    }
}
