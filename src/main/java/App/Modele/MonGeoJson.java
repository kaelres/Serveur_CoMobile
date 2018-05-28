package App.Modele;

import App.Controleur.UsineDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe permettant de représenter un GeoJson. Celle-ci possède la même structure
 * qu'un fichier geojson. Jackson json permet de ré-écrire l'objet sous format json en
 * ré-écrivant chaque attribut disposant d'un getter.
 * @author Francois, Céline
 */
public class MonGeoJson {

    /**
     * Attribut constant nécessaire au fonctionnement d'un geojson.
     */
    private final String type = "FeatureCollection";
    /**
     * Tableau de l'ensemble des sites répondant à la demande client.
     */
    private ArrayList<Feature> features;

    /**
     * Crée un objet MonGeoJson qui pourra être transformé en GeoJson.
     * Les sites qui seront recherchés en base de données devront utiliser la technologie
     * renseignée et appartenir à l'opérateur renseigné.
     * Plusieurs cas sont possible :
     * <ul>
     *     <li>Aucune technologie et aucun opérateur renseignée n'aura aucun effet.</li>
     *     <li>Renseigner uniquement un opérateur renvoie l'ensemble des antennes de cet opérateur toutes technologies confondues.</li>
     *     <li>Renseigner uniquement une technologie renvoie l'ensemble des antennes émettant cette technologie, tout opérateurs confondus.</li>
     *     <li>Les deux informations sont renseigéns, dans ce cas seules les antennes correspondant aux deux sont renvoyées.</li>
     * </ul>
     * @param tech Technologie que le site doit utiliser.
     * @param op Opérateur dont le site doit être la possession.
     */
    public MonGeoJson(String tech, String op) {

        features = new ArrayList<>();
        if (!tech.isEmpty() || !op.isEmpty()) {
            if (tech.isEmpty()) tech = "'2G','3G','4G'";
            if (op.isEmpty()) op = "'Bouygues','Orange','Free','Sfr'";
            UsineDAO.getDAOSite().search(tech, op, features);
        }
    }

    /**
     *
     * @return Renvoie l'attribut {@link MonGeoJson#type}.
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @return Renvoie l'attribut {@link MonGeoJson#features}.
     */
    public ArrayList<Feature> getFeatures() {
        return features;
    }
}
