package App.config;

import App.Controleur.ConnectiviteController;
import App.Controleur.HtmlController;
import App.Controleur.UsineDAO;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Classe de configuration de l'application. Instancie les beans et place ceux-ci/celles-ci dans un container.
 * @author Francois, Céline
 */
@Configuration
public class AppConfig {

    /**
     * Instancie le controller gérant la requête html Post "/geo".
     * @return Renvoie un objet connectiviteController.
     * @see ConnectiviteController
     */
    @Bean
    ConnectiviteController connectiviteController() { return new ConnectiviteController();}

    /**
     * Instancie le controlleur gérant le renvoi des pages html.
     * @return Renvoie un objet HtmlController.
     * @see HtmlController
     */
    @Bean
    HtmlController htmlController() {return new HtmlController();}

    /**
     * Instancie un JdbcTemplate à partir d'une piscine de connexion.
     * @return Renvoie un objet JdbcTemplate.
     * @see JdbcTemplate
     */
    @Bean
    JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        UsineDAO.setJdbcTemplate(jdbcTemplate);
        return jdbcTemplate;
    }

    /**
     * Instancie une piscine de connexions vers la base de données.
     * @return Renvoie un objet Datasource.
     * @see DataSource
     * @see HikariDataSource
     */
    @Bean
    public DataSource dataSource() {

        String url ="jdbc:postgresql://postgresql-francois-even.alwaysdata.net:5432/francois-even_projetinsi";
        String username = "francois-even";
        String password = "qf@1;a73";

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(url);
        return dataSource;
    }


}
