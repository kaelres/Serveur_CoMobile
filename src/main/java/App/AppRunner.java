package App;

import App.Vue.Accueil;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Classe Principale qui permet le lancement de l'application.
 */
@SpringBootApplication
public class AppRunner {

    /** Fonction main executée au lancement de l'application.
     * Elle crée une fenêtre Accueil.
     * @param  args Arguments fournis au lancement.
     * @see Accueil
     */
    public static void main(String[] args) {

        new Accueil(args);
    }
}
