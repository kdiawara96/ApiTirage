package com.apitirage.FreeTirage.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/")

/**
 * Ajoutez la classe RootController ci-dessous dans votre code pour rediriger vers la page de
 * l'interface utilisateur Swagger. De cette façon, vous n'avez pas besoin de mettre le dossier
 * dist de Swagger-UI dans votre répertoire de ressources.
 */
public class SwaggerController {
    @RequestMapping(method = RequestMethod.GET)
    public String swaggerUi() {
        return "redirect:/swagger-ui.html";
    }
}