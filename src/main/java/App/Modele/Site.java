package App.Modele;

import App.Controleur.UsineDAO;

import java.util.*;

/**
 * Classe permettant de représenter la table "site_antenne_relais" de la base de données.
 * @author Francois, Céline
 *
 */
public class Site {

    /**
     * Identifiant du site antenne relais.
     */
    private int id;
    /**
     * Ensemble des coordonnées qui permettent de représenter la zone de couverture du site.
     * Chaque élément correspond à une des zones couvertes.
     */
    private ArrayList<double[][]> coo;

    /**
     * Crée un nouvel objet de type Site à l'aide de son identifiant.
     * Une récupération de la couverture mobile est faite par la même occasion et
     * stocké dans l'attribut {@link Site#coo}.
     * @param id Identifiant du site dont on souhaite obtenir les informations en base de données.
     */
    public Site(int id) {
        this.id = id;
        coo = new ArrayList<>();
        double[][] temp;
        int index;

        TreeMap<Integer, ArrayList<Point>> tmp = UsineDAO.getDAOPoint().insert(id);

        //tri et transformation en coordonnées
        for (Map.Entry<Integer, ArrayList<Point>> entry : tmp.entrySet()) {

            ArrayList<Point> aLP = entry.getValue();
            Collections.sort(aLP, (p2, p1) -> Integer.valueOf(p1.getOrdre()).compareTo(Integer.valueOf(p2.getOrdre())));

            temp = new double[aLP.size()][2];
            ListIterator<Point> iterator = aLP.listIterator();
            index = 0;

            while (iterator.hasNext()) {
                Point p = iterator.next();
                temp[index][0] = p.getLongitude();
                temp[index][1] = p.getLatitude();
                index++;
            }

            coo.add(temp);
        }
    }

    /**
     *
     * @return Renvoie l'attribut {@link Site#coo}.
     */
    public ArrayList<double[][]> getCoo() {return coo;}

}
