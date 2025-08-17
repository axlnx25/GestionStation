package entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Approvisionnement {
    private int identifiant;
    private String libelle;
    private String date;
    private String nomFournisseur;
    private String nomProduit;

    public void faireApprovisionnement() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez id d'approvisionnement: " );
        this.identifiant = sc.nextInt();
        System.out.print("Entrez libelle d'approvisionnement: " );
        this.libelle = sc.next();
        System.out.print("Entrez date: " );
        this.date = sc.next();
        System.out.print("Entrez nom du fournisseur: " );
        this.nomFournisseur = sc.next();
        System.out.println("Entrez nom produit: ");
        this.nomProduit = sc.next();
    }

    public void miseAJourStock() {
//        trouver l'id du produit par son nom pour modifier son stock (valeur quantite) dans stock general
        for (Carburant carburant : Stock.getStock().values()) {
            if (carburant.getNomCarburant().equalsIgnoreCase(this.nomProduit)) {
//                augmenter quantite apres approvisionnement
                Stock.setTotalQuantiteStock(Stock.gettotalQuantiteStock() +
                        Stock.synchroniserAvecApprovisionnementQuantite(carburant.getIdentifiant()));
//                augmenter valeur prix apres approvisionnement
                Stock.setTotalValeurStock(Stock.gettotalValeurStock() +
                        Stock.synchroniserAvecApprovisionnementPrix(carburant.getIdentifiant()));
            }
        }
    }

    public void annulerApprovisionnement() {
        for (Carburant carburant : Stock.getStock().values()) {
            if (carburant.getNomCarburant().equalsIgnoreCase(this.nomProduit)) {
//                soustraire quantite apres annuler approvisionnement
                Stock.setTotalQuantiteStock(Stock.gettotalQuantiteStock() -
                        Stock.synchroniserAvecApprovisionnementQuantite(carburant.getIdentifiant()));
//                soustraire valeur prix apres annuler approvisionnement
                Stock.setTotalValeurStock(Stock.gettotalValeurStock() -
                        Stock.synchroniserAvecApprovisionnementPrix(carburant.getIdentifiant()));
            }
        }
    }


}
