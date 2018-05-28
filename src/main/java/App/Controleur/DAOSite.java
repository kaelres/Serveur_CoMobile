package App.Controleur;

import App.Modele.Site;
import App.Modele.Feature;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Classe permettant l'interaction avec la table "site_antenne_relais" de la base de données.
 * @author Francois, Céline
 */
public class DAOSite {

    /**
     * JdbcTemplate permettant de faire des requêtes sur la base de données liée.
     */
    private JdbcTemplate jdbcTemplate;

    /**
     * Crée un objet de type DAOSite disposant d'un JdbcTemplate.
     * @param jdbcTemplate Valeur affectée à l'attribut {@link #jdbcTemplate}.
     */
    public DAOSite(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Cette méthode recherche dans la base de données les sites antennes relais qui appartiennent à
     * l'opérateur fourni en argument et délivrant la technologie passée en argument.
     * La représentation de chaque site est ensuite ajoutée au tableau passé en paramètres.
     * @param tech Technologie que le site doit délivrer afin d'être conforme à la demande utilisateur.
     * @param op Opérateur dont le site doit être la possession afin d'être conforme à la demande utilisateur.
     * @param features Liste comprenant l'ensemble des site conforme à la demande client.
     */
    public void search(String tech, String op, ArrayList<Feature> features) {

        String query1 =
                "SELECT s.identifiant "
                        +"FROM site_antenne_relais s "
                        + "INNER JOIN emet e ON e.identifiant_site = s.identifiant " +
                        "WHERE e.nom_technologie IN (SELECT nom FROM technologie WHERE nom IN (";
        String query2 = query1 + tech
                +")) AND s.id_operateur IN (SELECT identifiant FROM operateur WHERE nom IN (";

        String query3 = query2 + op + "))";


        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query3);
        for (Map row : rows) {
            System.out.println((int)row.get("identifiant"));
            Site site = new Site((int)row.get("identifiant"));
            features.add(new Feature(site));
        }
    }
}
