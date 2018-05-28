package App.Modele;

/**
 * Classe représentant un site dans le GeoJson. Elle correspond à une "feature"
 * du GeoJson.
 * Jackson json permet de ré-écrire l'objet sous format json en
 * ré-écrivant chaque attribut disposant d'un getter.
 * @author Francois, Céline
 */
public class Feature {

    /**
     * Attribut constant nécessaire au fonctionnement d'un geojson.
     */
    private final String type = "Feature";
    /**
     * Ensemble des polygones représentants la zone de couverture d'un site.
     */
    private Geometry geometry;

    /**
     *
     * @param s Site dont la couverture est affectée à l'attribut {@link #geometry}.
     */
    public Feature(Site s) {
        geometry = new Geometry(s.getCoo());
    }

    /**
     *
     * @return Renvoie l'attribut {@link #type}.
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @return Renvoie l'attribut {@link #geometry}.
     */
    public Geometry getGeometry() {
        return geometry;
    }
}
