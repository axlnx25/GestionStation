package entities;
import java.util.*;

public class GestionVente {
    private ArrayList<Vente> ventes = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // 1. Nouvelle vente
    public void nouvelleVente() {
        System.out.print("Nom du produit: ");
        String produit = sc.nextLine();
        System.out.print("Quantité: ");
        int qte = sc.nextInt();
        System.out.print("Prix unitaire: ");
        double prix = sc.nextDouble();
        sc.nextLine();

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
        System.out.print("Entrez l'ID de la vente à annuler: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Vente v : ventes) {
            if (v.getId() == id) {
                if (!v.isAnnule()) {
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
}



