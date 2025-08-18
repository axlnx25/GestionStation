package entities;
import java.util.*;

public class Vente {
    private static int compteur = 0;  // Pour générer des IDs automatiques
    private int id;
    private String produit;
    private int quantite;
    private double prixUnitaire;
    private Date date;
    private boolean estAnnule;

    public Vente(String produit, int quantite, double prixUnitaire) {
        this.id = ++compteur;
        this.produit = produit;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.date = new Date();
        this.estAnnule = false;
        }

    public int getId() {
        return id;
    }
    public double getTotal() {
        return quantite * prixUnitaire;
    }
    public boolean isAnnule() {
        return estAnnule;
    }
    public void annuler() {
        this.estAnnule = true;
    }

    @Override
    public String toString() {
        return "Vente #" + id +
                " | Produit: " + produit +
                " | Quantité: " + quantite +
                " | PU: " + prixUnitaire +
                " | Total: " + getTotal() +
                " | Date: " + date +
                (estAnnule ? " | [ANNULÉE]" : "");
    }

}
