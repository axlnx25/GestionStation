package entities;

import java.util.Scanner;

public class Fournisseur extends Personne {
    Scanner sc = new Scanner(System.in);

    public Fournisseur() {
        System.out.print("Entrez id fournisseur: " );
        this.identifiant = sc.nextInt();
        System.out.print("Entrez nom fournisseur: " );
        this.nom = sc.next();
        System.out.print("Entrez prenom fournisseur: " );
        this.prenom = sc.next();
        System.out.print("Entrez adresse fournisseur: " );
        this.adresse = sc.next();
        System.out.print("Entrez telephone fournisseur: " );
        this.telephone = sc.next();
    }

    public int getIdentifiantFournisseur () {
        return this.identifiant;
    }

    public String getNomFournisseur () {
        return this.nom;
    }

    public String getPrenomFournisseur () {
        return this.prenom;
    }

    public String getAdresseFournisseur () {
        return this.adresse;
    }

    public String getTelephoneFournisseur () {
        return this.telephone;
    }

    public void setIdentifiantFournisseur (int identifiant) {
        this.identifiant = identifiant;
    }

    public void setNomFournisseur (String nom) {
        this.nom = nom;
    }

    public void setPrenomFournisseur (String prenom) {
        this.prenom = prenom;
    }

    public void setAdresseFournisseur (String adresse) {
        this.adresse = adresse;
    }

    public void setTelephoneFournisseur (String telephone) {
        this.telephone = telephone;
    }

    public String toString() {
        return "Identifiant Fournisseur: " + this.identifiant +
                "/nNom Fournisseur: " + this.nom + "/nPreom Fournisseur: " +
                this.prenom + "/nAdresse Fournisseur: " + this.adresse + "/nTelephone Fournisseur"
                + this.telephone ;
    }


}
