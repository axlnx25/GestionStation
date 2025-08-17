package entities;

import java.util.Scanner;

public class Carburant {
    private int identifiant;
    private String nomCarburant;
    private double prix;
    private double quantite;
    private double niveauAlerte;
    public Scanner sc = new Scanner (System.in);

    public Carburant() {
        System.out.print("Entrez id du produit: " );
        this.identifiant = sc.nextInt();
        System.out.print("Entrez nom du produit: " );
        this.nomCarburant = sc.next();
        System.out.print("Entrez prix du produit: " );
        this.prix = sc.nextDouble();
        System.out.print("Entrez quantite du produit: " );
        this.quantite = sc.nextDouble();
        System.out.print("Entrez valeur niveau d'alerte :");
        this.niveauAlerte = sc.nextDouble();
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getNomCarburant() {
        return nomCarburant;
    }

    public void setNomCarburant(String nomCarburant) {
        this.nomCarburant = nomCarburant;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public void enregistrerCarburantAuStock () {
        Stock.ajouterAuStock(this);
    }

    public double getNiveauAlerte() {
        return niveauAlerte;
    }

    public void setNiveauAlerte(double niveauAlerte) {
        this.niveauAlerte = niveauAlerte;
    }

    //    public void modifierCarburant() {
//        int idDeModification;
//        System.out.println("Entrez id du produit à modifier: ");
//        idDeModification = sc.nextInt();
//        Stock.modifierStock(idDeModification);
//    }

    @Override
    public String toString() {
       return "Identifiant: " + this.identifiant +
                "/nNomCarburant: " + this.nomCarburant + "/nPrix: " +
                this.prix + "/nNiveau d'alerte" + this.niveauAlerte + "/nQuantite: " + this.quantite ;
    }


}
