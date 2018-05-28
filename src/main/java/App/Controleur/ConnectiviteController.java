package App.Controleur;

import App.Modele.MonGeoJson;
import App.Modele.RequestCover;
import App.Modele.Wrapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Classe gérant les requêtes Http nécessitant en réponse un fichier json. Celle-ci suit une architecture REST et fait donc usage de l'annotation @RestController.
 * @author Francois, Céline
 */
@RestController
public class ConnectiviteController {

    /**
     * Cette méthode utilise Jackson json afin de créer et envoyer un objet geojson lisible par le client.
     * Elle traite la méthode Http "Post" d'argument "/geo" et se sert de la classe RequestCover afin de
     * récupérer l'argument envoyé par le client.
     * @param requestCover Objet java permettant de récupérer l'argument de la requête client.
     * @return Renvoie un ensemble de zone de couverture mobile au format geojson.
     * @see RequestCover
     */
    @RequestMapping(value = "/geo", method = RequestMethod.POST)
    public Wrapper monGeoJson(@RequestBody RequestCover requestCover) {
        Boolean[] tabState = requestCover.getTabState();


        String op = "";
        String tech = "";

        if (tabState[0]) op = op+ "'Bouygues', ";
        if (tabState[1]) op = op+ "'Free', ";
        if (tabState[2]) op = op+ "'Orange', ";
        if (tabState[3]) op = op+ "'Sfr'";
        //Regexp supprimant les ", " en fin de chaîne
        op = op.replaceAll(",\\s$", "");

        if (tabState[4]) tech = tech+ "'2G', ";
        if (tabState[5]) tech = tech+ "'3G', ";
        if (tabState[6]) tech = tech+ "'4G'";

        tech = tech.replaceAll(",\\s$", "");

        System.out.println("tech : "+tech+"\nop :"+op);
        Wrapper w = new Wrapper(new MonGeoJson(tech, op));
        return w;
    }
}
