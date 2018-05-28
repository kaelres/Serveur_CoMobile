package App.Modele;

import java.util.ArrayList;

/**
 * Classe permettant de représenter l'objet "geometry" d'un GeoJson.
 * Jackson json permet de réécrire l'objet sous format json en
 * réécrivant chaque attribut disposant d'un getter.
 * Chaque objet Geometry contiendra la couverture mobile d'un site.
 * @author Francois, Céline
 */
public class Geometry {

    /**
     * Attribut constant nécessaire au fonctionnement d'un geojson.
     */
    private final String type = "Polygon";
    /**
     * Ensemble des coordonnées formant la couverture d'un site.
     */
    private ArrayList<double[][]> coordinates;

    /**
     * Crée un objet de type Geometry en lui fournissant un ensemble de coordonnées.
     * @param coo Coordonnées à affecter au point.
     */
    public Geometry(ArrayList<double[][]> coo) {
        this.coordinates = coo;
    }

    /**
     *
     * @return Renvoie l'attribut {@link Geometry#type}.
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @return Renvoie l'attribut {@link Geometry#coordinates}.
     */
    public ArrayList<double[][]> getCoordinates() {
        return coordinates;
    }
}
