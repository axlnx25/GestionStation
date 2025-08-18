package entities;

public class Caisse {
    private static int totalDesEntree;
    private static int totalDesSortes;

    public static void initialisationDesValeurs () {
        totalDesEntree = GestionVente.nombresDeVentes() ;
        totalDesSortes = ListeApprovisionnement.nombreApprovisionnement();
    }

    public static void afficherListeDesEntree() {
        GestionVente.ventesValides();
    }

    public static void afficherListeDesSortes () {
        ListeApprovisionnement.afficherListeApprovisionnement();
    }

    public static void recapitulatif () {
        System.out.println("Entrées ( nombre ): " + totalDesEntree);
        System.out.println("Sorties ( nombre ): " + totalDesSortes);
        double resultat = Stock.gettotalValeurStock() - GestionVente.valeurDesVentes();
        if (resultat < 0) {
            System.out.println("Vous avez une perte de " + resultat);
        } else  {
            System.out.println("Vous avez un benefice de " + resultat);
        }
    }

}
