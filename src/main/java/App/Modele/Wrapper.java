package App.Modele;

/**
 * Cette classe a pour unique but d'envelopper le geojson envoyé afin de rendre sa lecture et utilisation
 * plus simple par l'application cliente.
 * @author Francois, Céline
 */
public class Wrapper {

    /**
     * ObjetMonGeoJson à renvoyer.
     */
    private MonGeoJson monGeoJson;

    /**
     * Crée un nouvel objet de type Wrapper à l'aide d'un objet MonGeoJson.
     * @param monGeoJson Valeur affectée à l'attribut {@link #monGeoJson}.
     */
    public Wrapper(MonGeoJson monGeoJson) {
        this.monGeoJson = monGeoJson;
    }

    /**
     *
     * @return Renvoie la valeur de l'attribut {@link #monGeoJson}.
     */
    public MonGeoJson getMonGeoJson() {
        return monGeoJson;
    }
}
