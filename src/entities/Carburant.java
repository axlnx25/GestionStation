package entities;

import java.util.Scanner;

public class Carburant {
    private static int compteur = 0;
    private int identifiant;
    private String nomCarburant;
    private double prix;
    private double quantite;
    private double niveauAlerte;
    public Scanner sc = new Scanner (System.in);

    public Carburant() {
        this.identifiant = compteur++;
        System.out.print("Entrez nom du produit: " );
        this.nomCarburant = sc.next();
        sc.nextLine();
        System.out.print("Entrez prix du produit unitaire: " );
        this.prix = sc.nextDouble();
        sc.nextLine();
        System.out.print("Entrez quantite du produit: " );
        this.quantite = sc.nextDouble();
        sc.nextLine();
        System.out.print("Entrez valeur niveau d'alerte :");
        this.niveauAlerte = sc.nextDouble();
        sc.nextLine();
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
        Stock stock = new Stock();
        stock.ajouterAuStock(this);
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
                "\nNomCarburant: " + this.nomCarburant + "\nPrix: " +
                this.prix + "\nNiveau d'alerte: " + this.niveauAlerte + "\nQuantite: " + this.quantite ;
    }


}
