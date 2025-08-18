package entities;

import java.util.Scanner;

public class Approvisionnement {
    private static int compteur = 0;
    private int identifiant;
    private String libelle;
    private String date;
    private String nomFournisseur;
    private String nomProduit;
    private double quantitApprovisionne;

    public void faireApprovisionnement() {
//        L'approvisionnement ne se fait que quand il y'a au moins un fourniseur
        if (ListeFournisseur.getHistoriqueFournisseur().isEmpty()) {
            System.out.println("Impossible d'approvisionner car Liste fournisseur vide !!! " +
                    "Veuillez ajouter au moins un fournisseur ");
        } else {
            Scanner sc = new Scanner(System.in);
            this.identifiant = compteur++;
            System.out.print("Entrez libelle d'approvisionnement: " );
            this.libelle = sc.nextLine();
            System.out.print("Entrez date: " );
            this.date = sc.nextLine();
            System.out.print("Entrez quantite approvisionée: ");
            this.quantitApprovisionne = sc.nextDouble();
            sc.nextLine();

//        Pour que l'utilisateur entre un nom de fournisseur dans la liste
            while (true) {
                ListeFournisseur.afficherTousLesFournisseurs();
                System.out.print("Entrez nom du fournisseur ( choisir dans la liste," +
                        " Si elle est vide aller enregistrer un fournisseur ): " );
                String choisir = sc.next();
                sc.nextLine();
                if (ListeFournisseur.estDansLaListeFournisseur(choisir)) {
                    this.nomFournisseur = choisir;
                    break;
                }
            }

//            L'approvisionement est fait pour un produit deja enrgistreé
            while (true) {
                Stock.afficherStock();
                System.out.print("Entrez nom produit approvisionner ( choisir dans la liste ): ");
                String choisir = sc.next();
                sc.nextLine();
                if (Stock.estDansStock(choisir)) {
                    this.nomProduit = choisir;
                }
            }
        }

    }

    public int getIdentifiant() {
        return identifiant;
    }

    public double getQuantitApprovisionne() {
        return quantitApprovisionne;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getDate() {
        return date;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setQuantitApprovisionne(double quantitApprovisionne) {
        this.quantitApprovisionne = quantitApprovisionne;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

//    methode qui calcule la valeur prix de l'approvisionnement en cours et la retourne
//    pour incremanter la valeur prix du stock
    public double valeurApprovisionnementEncours () {
        return Stock.getItemPrice(this.nomProduit) * this.quantitApprovisionne;
    }

//    methode a appeler dans le menu apres nouvelle approvisionnement
    public void miseAJourStock() {
//        trouver l'id du produit par son nom pour modifier son stock (valeur quantite) dans stock general
        for (Carburant carburant : Stock.getStock().values()) {
            if (carburant.getNomCarburant().equalsIgnoreCase(this.nomProduit)) {
//                augmenter quantite apres approvisionnement
                Stock.setTotalQuantiteStock(Stock.gettotalQuantiteStock() +
                        this.valeurApprovisionnementEncours());
//                augmenter valeur prix apres approvisionnement
                Stock.setTotalValeurStock(Stock.gettotalValeurStock() +
                        this.getQuantitApprovisionne());
            }
        }
    }

//    methode appeler lors de la suppression d'un approvisionnement
    public void annulerApprovisionnement() {
        for (Carburant carburant : Stock.getStock().values()) {
            if (carburant.getNomCarburant().equalsIgnoreCase(this.nomProduit)) {
//                soustraire quantite apres annuler approvisionnement
                Stock.setTotalQuantiteStock(Stock.gettotalQuantiteStock() -
                        this.valeurApprovisionnementEncours());
//                soustraire valeur prix apres annuler approvisionnement
                Stock.setTotalValeurStock(Stock.gettotalValeurStock() -
                        this.getQuantitApprovisionne());
            }
        }
    }

    public String toString () {
        return "Identifiant d'approvisionnement: " + this.identifiant + "/nLibelle: " + this.libelle
                + "/nDate: " + this.date + "/nNom du fournisseur: " + this.nomFournisseur
                + "/nNom du produit approvisionné: " + this.nomProduit
                + "/nValeur (prix) approvisionnée: " + this.valeurApprovisionnementEncours() +
                "/nQuantite approvisionnée: " + this.quantitApprovisionne;
    }


}
