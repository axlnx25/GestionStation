package entities;
import java.util.*;

public class GestionVente {
    private ArrayList<Vente> ventes = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // 1. Nouvelle vente
    public void nouvelleVente() {
        Stock.afficherProduitPourVente();
        String produit;

        while (true) {
            System.out.print("Nom du produit ( choisir dans la liste ): ");
            produit = sc.nextLine();
            if (Stock.estDansStock(produit)) {
                break;
            }
        }

        System.out.print("Quantité: ");
        double qte = sc.nextDouble();
        sc.nextLine();
        System.out.print("Prix unitaire: " + Stock.getItemPrice(produit));
        double prix = Stock.getItemPrice(produit);

//        ajuster le stock finacierement et en quantité après la vente
        Stock.vendreProduit(produit, prix, qte);

        Vente v = new Vente(produit, qte, prix);
        ventes.add(v);
        System.out.println("✅ Vente enregistrée avec succès : " + v);
    }

    // 2. Historique des ventes
    public void historique() {
        if (ventes.isEmpty()) {
            System.out.println(" Aucune vente enregistrée.");
        } else {
            System.out.println("Historique des ventes :");
            for (Vente v : ventes) {
                System.out.println(v);
            }
        }
    }

    // 3. Annuler une vente
    public void annulerVente() {
        historique();
        System.out.print("Entrez l'ID de la vente à annuler ( choisir un ID dans la liste ): ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Vente v : ventes) {
            if (v.getId() == id) {
                if (!v.isAnnule()) {
                    Stock.annulerVendreProduit(v.getProduit(), v.getTotal(), v.getQuantite());
                    v.annuler();
                    System.out.println(" Vente #" + id + " annulée avec succès.");
                } else {
                    System.out.println(" Cette vente est déjà annulée.");
                }
                return;
            }
        }
        System.out.println(" Vente introuvable !");
    }

    public void retour() {
        System.out.println(" Retour au menu principal...");
    }

    public int nombresDeVentes() {
        int nbVentes = 0;
        for (Vente v : ventes) {
            if (!v.isAnnule()) {
                nbVentes++;
            }
        }
        return nbVentes;
    }
}



