package App.Controleur;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Fonction ayant pour but de permettre l'accès via ses fonctions statiques
 * aux différents objets du design pattern "Data As Object" utilisés dans l'application.
 * @author Francois, Céline
 */
public class UsineDAO {

    /**
     * Template de la jdbc assigné au lancement du serveur par la classe de configuration.
     * @see App.config.AppConfig
     */
    private static JdbcTemplate jdbcTemplate;

    /**
     * Méthode permettant d'avoir accès à la classe DAOSite.
     * @return Renvoie un nouvel objet du type DAOSite.
     */
    public static DAOSite getDAOSite() {return new DAOSite(jdbcTemplate);}

    /**
     * Méthode permettant d'avoir accès à la classe DAOPoint.
     * @return Renvoie un nouvel objet du type DAOPoint.
     */
    public static DAOPoint getDAOPoint() {return new DAOPoint(jdbcTemplate);}

    /**
     * Méthode permetant d'affecter un objet static de type JbcTemplate à l'attribut {@link UsineDAO#jdbcTemplate}.
     * @param jdbcTemplate Objet à affecter à la classe.
     */
    public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        UsineDAO.jdbcTemplate = jdbcTemplate;
    }
}
