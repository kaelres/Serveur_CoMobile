package App.Modele;

import java.io.Serializable;

/**
 * Cette classe, implémentant l'interface Serializable est utilisée afin d'interpréter l'objet Json envoyé
 * par l'application cliente dans sa requête afin d'obtenir une représentation de couverture mobile.
 * @author Francois, Céline
 * @see Serializable
 */
public class RequestCover implements Serializable {

    /**
     * Tableau contenant l'ensemble des demandes clients.  Chaque index du tableau représente une information :
     * <ul>
     *     <li>Bouygues</li>
     *     <li>Free</li>
     *     <li>Orange</li>
     *     <li>Sfr</li>
     *     <li>2G</li>
     *     <li>3G</li>
     *     <li>4G</li>
     * </ul>
     * Si un élément est à "vrai" c'est que l'utilisateur souhaite obtenir une couverture qui appartient
     * à l'opérateur en question/délivre la technologie en question.
     */
    private Boolean[] tabState;

    /**
     *
     * @return Renvoie la valeur de l'attribut {@link #tabState}.
     */
    public Boolean[] getTabState() {
        return tabState;
    }

    /**
     * Cette méthode permet d'affecter une valeur à l'attribut {@link #tabState}.
     * @param tabState Valeur à affecter à l'attribut {@link #tabState}.
     */
    public void setTabState(Boolean[] tabState) {
        this.tabState = tabState;
    }
}
