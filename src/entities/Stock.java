package entities;

import java.util.HashMap;
import java.util.Scanner;

public class Stock {
    public static HashMap<Integer, Carburant> stock =  new HashMap<>();
    private static double totalValeurStock = 5000;
    private static double totalQuantiteStock = 0.0;

    public static HashMap<Integer, Carburant> getStock() {
        return stock;
    }

    public HashMap<Integer, Carburant> getStockNonSt () {
        return stock;
    }

    private Integer creerCle (Carburant carburant) {
        return carburant.getIdentifiant();

    }

    public double gettotalValeurStock ()  {
        return totalValeurStock;
    }

    public double gettotalQuantiteStock () {
        return totalQuantiteStock;
    }

    public void setTotalValeurStock(double totalValeurStock) {
        Stock.totalValeurStock = totalValeurStock;
    }

    public void setTotalQuantiteStock(double totalQuantiteStock) {
        Stock.totalQuantiteStock = totalQuantiteStock;
    }

    public void ajouterAuStock(Carburant carburant) {
        int cle = carburant.getIdentifiant();
        if (stock.containsKey(cle)) {
            System.out.println("Ce produit existe déjà !!!!");
        }  else {
//            incrementation des valeur du stock a chaque ajout
            totalValeurStock = totalValeurStock + carburant.getPrix();
            totalQuantiteStock = totalQuantiteStock + carburant.getQuantite();
            stock.put(cle, carburant);
        }
    }

    public void afficherStock() {
        if (stock.isEmpty()) {
            System.out.println("Stock vide");
        }  else {
            System.out.println("Voici la liste des produits du stock :");
            for (Carburant carburant : stock.values()) {
//                avertissement concernant niveau stock / alerte
                if (carburant.getQuantite() < carburant.getNiveauAlerte()) {
                    System.out.println("Alerte au stock de ce produit !!!!");
                    System.out.println(carburant);
                    System.out.println("--------------------------------------");
                } else {
                    System.out.println(carburant);
                    System.out.println("--------------------------------------");
                }
            }
            System.out.println("Total de carburants ( nombre ): " + stock.size());
        }
    }

    public void afficherProduitPourVente() {
        if (stock.isEmpty()) {
            System.out.println("Stock vide");
        } else {
            System.out.println("Voici la liste des produits du stock :");
            for (Carburant carburant : stock.values()) {
                System.out.println("------------------------------------");
                System.out.println(carburant);
                System.out.println("------------------------------------");
            }
        }
    }

    public void supprimerDuStock(int idASupprimer) {
        if (stock.containsKey(idASupprimer)) {
            Carburant carburant = stock.get(idASupprimer);

//            ajustement du stock
            totalQuantiteStock = totalQuantiteStock - carburant.getQuantite();
            totalValeurStock = totalQuantiteStock - carburant.getPrix();

            stock.remove(carburant.getIdentifiant());
        } else  {
            System.out.println("Ce produit n'existe pas !!!!");
        }
    }

    public void supprimerStock() {
        if (stock.isEmpty()) {
            System.out.println("Stock vide !!!!");
        } else   {
            totalValeurStock = 0.0;
            totalQuantiteStock = 0.0;
            stock.clear();
        }
    }

//    pour modifier un produit carburant du stock
    public void modifierStock(int idModifier) {
        if (stock.isEmpty()) {
            Scanner sc = new Scanner(System.in);

//            modifier valeur dans le stock d'un produit
            if (stock.containsKey(idModifier)) {
                Carburant carburant = stock.get(idModifier);

//                ajustement du stock
                totalQuantiteStock = totalQuantiteStock - carburant.getQuantite();
                totalValeurStock = totalValeurStock - carburant.getPrix();

                System.out.print("Nouveau nom produit: ");
                carburant.setNomCarburant(sc.nextLine());
                System.out.print("Nouveau prix produit: ");
                carburant.setPrix(sc.nextDouble());
                sc.nextLine();
                System.out.print("Nouveau quantite: ");
                carburant.setQuantite(sc.nextDouble());
                sc.nextLine();
                System.out.print("Nouveau niveau d'alerte: ");
                carburant.setNiveauAlerte(sc.nextDouble());
                sc.nextLine();

//                prise en compte de la valeur modifié
                totalValeurStock = totalValeurStock + carburant.getPrix();
                totalQuantiteStock = totalQuantiteStock + carburant.getQuantite();

                stock.put(idModifier, carburant);
            } else {
                System.out.println("Ce produit n'existe pas !!!!");
            }
        } else   {
            System.out.println("Stocke vide ");
        }
    }

    public void rechercherProduit (int idProduit ) {
        if (!stock.isEmpty()) {
            if (stock.containsKey(idProduit)) {
                Carburant carburant = stock.get(idProduit);
                System.out.println(carburant);
            } else {
                System.out.println("Ce produit n'existe pas ");
            }
        } else   {
            System.out.println("Stock vide ");
        }
    }

    //    obtenir prixUnitaire d'un produit du stock
    public double getItemPrice (String itemName) {
        for (Carburant carburant : stock.values()) {
            if (carburant.getNomCarburant().equalsIgnoreCase(itemName)) {
                return carburant.getPrix();
            }
        }
        return 0.0;
    }

    public boolean estDansStock (String itemName) {
        int i = 0;
        for (Carburant carburant : stock.values()) {
            if (carburant.getNomCarburant().equalsIgnoreCase(itemName)) {
               i++;
            }
        }
        if (i == 0) {
            return false;
        } else  {
            return true;
        }
    }

    public void vendreProduit (String itemName, double prix, double quantite) {
        for (Carburant carburant : stock.values()) {
            if (carburant.getNomCarburant().equalsIgnoreCase(itemName)) {
                double valeurTmp = totalValeurStock + prix;
                double quantiteTmp = totalQuantiteStock - quantite;
                setTotalValeurStock(valeurTmp);
                setTotalQuantiteStock(quantiteTmp);
            }
        }
    }

    public void annulerVendreProduit (String itemName, double prix, double quantite) {
        for (Carburant carburant : stock.values()) {
            if (carburant.getNomCarburant().equalsIgnoreCase(itemName)) {
                double quantiteTmp = totalQuantiteStock + quantite;
                double valeurTmp = totalValeurStock - prix;
                carburant.setQuantite(carburant.getQuantite() + quantite);
                setTotalValeurStock(valeurTmp);
                setTotalQuantiteStock(quantiteTmp);
            }
        }
    }

    public boolean ventePossible (String itemName, double quantiteAVendre) {
        for (Carburant carburant : stock.values()) {
            if (carburant.getNomCarburant().equalsIgnoreCase(itemName)) {
                if((carburant.getQuantite() > 0) && (carburant.getQuantite() > quantiteAVendre)) {
                    return true;
                }
            }
        }
        return false;
    }


////    Obtenir les valeur/prixtotal et quantite total du stock
//
//    public static double getTotalValeurStock() {
//        double somme = 0.0;
//        for (Carburant carburant : stock.values()) {
//            somme += carburant.getPrix();
//        }
////        pour etre sur du calcul de la valeur/quantite du stock
//        if (somme == totalValeurStock) {
//            return somme;
//        }
//        else  {
//            System.out.println("ERREUR SUR LA VALEUR DU STOCK !!!!");
//            return 0.0;
//        }
//    }
//
//    public static double getTotalQuantiteStock() {
//        double somme = 0.0;
//        for (Carburant carburant : stock.values()) {
//            somme += carburant.getQuantite();
//        }
//        if  (somme == totalQuantiteStock) {
//            return somme;
//        } else {
//            System.out.println("ERREUR SUR LA QUANTITE DU STOCK !!!!");
//            return 0.0;
//        }
//    }


//    incrementer la valeur de quantite et valeur/prix de stock lors de l'approvisionnement

//    public static double synchroniserAvecApprovisionnementQuantite (int idProduit) {
//        Carburant carburant = stock.get(idProduit);
//        return carburant.getQuantite();
//    }
//
//    public static double synchroniserAvecApprovisionnementPrix (int idProduit) {
//        Carburant carburant = stock.get(idProduit);
//        return carburant.getPrix();
//    }


}
