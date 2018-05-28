package App.Controleur;

import App.Modele.Point;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

/**
 * Classe permettant l'interaction avec la table "point" de la base de données.
 * @author Francois, Céline
 */
public class DAOPoint {

    /**
     * JdbcTemplate permettant de faire des requêtes sur la base de données liée.
     */
    private JdbcTemplate jdbcTemplate;

    /**
     * Crée un objet de type DAOPoint disposant d'un JdbcTemplate.
     * @param jdbcTemplate Valeur affectée à l'attribut {@link #jdbcTemplate}.
     */
    public DAOPoint(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    /**
     * Cette méthode permet de récupérer l'ensemble des points représentant la couverture d'un site sous forme de Treemap :
     * <ul>
     *     <li>La clef est le numéro de la zone (chaque site est représenté par une ou plusieurs zones de couverture).</li>
     *     <li>Chaque zone est un polygone représenté par des points dans un ordre précis.</li>
     *     <li>Les valeurs de la treemap sont des listes de points triés selon cet ordre précis.</li>
     * </ul>
     * @param id Identifiant du site dont le point sert à représenter une zone de couverture mobile.
     * @return Renvoie l'ensemble des points représentant les zones de couverture du site demandé, trié par zone et par ordre.
     */
    public TreeMap<Integer,ArrayList<Point>> insert(int id) {


        TreeMap<Integer,ArrayList<Point>> tmp = new TreeMap<>();

        String query =
                "SELECT p.id_zone, p.latitude, p.longitude, p.ordre "
                + "FROM point p "
                + "INNER JOIN zone z ON p.id_zone = z.identifiant "
                + "WHERE z.id_site = " + id;

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        for (Map row : rows) {

            Integer id_zone = (int) row.get("id_zone");

            if (tmp.containsKey(id_zone)) {    //déjà créé

                ArrayList<Point> aLP = tmp.get(id_zone);
                aLP.add(
                        new Point(
                                (double) row.get("latitude"), (double) row.get("longitude"), (int) row.get("ordre")));

            } else {    //nouvelle zone

                tmp.put(id_zone, new ArrayList<Point>());
                ArrayList<Point> aLP = tmp.get(id_zone);
                aLP.add(
                        new Point(
                                (double) row.get("latitude"), (double) row.get("longitude"), (int) row.get("ordre")));
            }
        }

        return tmp;
    }
}
