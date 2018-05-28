package App.Controleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Classe controleur permettant de gérer l'envoi de pages html au client.
 */
@Controller
public class HtmlController {

    /**
     * Cette méthode permet au client se connectant à la racine du serveur d'obtenir la page d'accueil automatiquement.
     * @return Renvoie la page d'accueil du site.
     */
    @RequestMapping(value ="/")
    public String getHome() {
        System.out.println("index");
        return "index.html";
    }
}
