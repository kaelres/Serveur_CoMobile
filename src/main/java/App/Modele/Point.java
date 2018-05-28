package App.Modele;

/**
 * Classe représentant la table "point" de la base de données.
 * @author Francois, Céline
 */
public class Point {

    /**
     * Latitude du point
     */
    private double latitude;
    /**
     * Longitude du point.
     */
    private double longitude;
    /**
     * Place dans la séquence de point formant une zone(polygone).
     */
    private int ordre;

    /**
     * Crée un nouvel objet Point disposant d'une latitude, d'une longitude ainsi que d'un ordre.
     * @param latitude Valeur affectée à l'attribut {@link #latitude}.
     * @param longitude Valeur affectée à l'attribut {@link #longitude}.
     * @param ordre Valeur affectée à l'attribut {@link #ordre}.
     */
    public Point(double latitude, double longitude, int ordre) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.ordre = ordre;
    }

    /**
     *
     * @return Renvoie l'attribut {@link Point#latitude}.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     *
     * @return Renvoie l'attribut {@link Point#longitude}.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     *
     * @return Renvoie l'attribut {@link Point#ordre}.
     */
    public int getOrdre() {
        return ordre;
    }
}
