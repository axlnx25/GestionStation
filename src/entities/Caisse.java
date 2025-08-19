package entities;

public class Caisse {
    private static int totalDesEntree;
    private static int totalDesSortes;
    Stock stock =  new Stock();
    ListeApprovisionnement l = new ListeApprovisionnement();

    public void initialisationDesValeurs () {
        totalDesEntree = GestionVente.nombresDeVentes() ;
        totalDesSortes = l.nombreApprovisionnement();
    }

    public void afficherListeDesEntree() {
        GestionVente.ventesValides();
    }

    public void afficherListeDesSortes () {
        l.afficherListeApprovisionnement();
    }

    public void recapitulatif (double valeur) {
        System.out.println("Entrées ( nombre ): " + totalDesEntree);
        System.out.println("Sorties ( nombre ): " + totalDesSortes);
        double resultat = GestionVente.valeurDesVentes() - valeur;
        if (resultat < 0) {
            System.out.println("Vous avez une perte de " + resultat);
        } else  {
            System.out.println("Vous avez un benefice de " + resultat);
        }
    }

}
