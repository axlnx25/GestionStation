import entities.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int reponse = 1;

        while(reponse == 1) {
            switch (menuPrincipale()) {
                case 1 -> menuVente();
                case 2 -> menuCaisse();
                case 3 -> menuCarburant();
                case 4 -> menuFournisseur();
                case 5 -> menuUtilisateur();
                default -> System.out.println("Erreur de choix !");
            }

            System.out.print("Souhaitez vous continuer Oui (1) / Non (0): ");
            reponse = sc.nextInt();
            sc.nextLine();
        }

    }

    public static void menuCaisse() {
        int choix = 0;
        int reponse = 1;
        Scanner sc = new Scanner(System.in);
        ListeApprovisionnement l  = new ListeApprovisionnement();

        while(reponse == 1) {
            System.out.println("1. LISTE DES ENTREES");
            System.out.println("2. LISTE DES SORTIES");
            System.out.println("3. RECAPITULATIF");
            System.out.println("4. RETOUR");
            System.out.print("Entrez votre choix: ");
            choix = sc.nextInt();
            sc.nextLine();
            Caisse caisse = new Caisse();
            switch (choix) {
                case 1 : caisse.afficherListeDesEntree();
                         break;
                case 2 : caisse.afficherListeDesSortes();
                         break;
                case 3 : caisse.initialisationDesValeurs();
                         caisse.recapitulatif(l.valeurHistoriqueApprovisionnement());
                         break;
                case 4 : menuPrincipale();
                         break;
                default: System.out.println("Erreur de choix !");
            }

            System.out.print("Souhaitez vous continuer Oui (1) / Non (0): ");
            reponse = sc.nextInt();
            sc.nextLine();
            if (reponse == 0) {
                break;
            }
        }

    }

    public static void menuCarburant() {
        int choix = 0;
        int reponse = 1;
        Scanner sc = new Scanner(System.in);
        Approvisionnement a = new Approvisionnement();
        Stock stock = new Stock();
        ListeApprovisionnement l  = new ListeApprovisionnement();
        GestionVente vente = new GestionVente();

        while(reponse == 1) {
            System.out.println("1. SAISIR PRODUIT");
            System.out.println("2. SUPPRIMER PRODUIT");
            System.out.println("3. MODIFIER PRODUIT");
            System.out.println("4. STOCK PRODUIT");
            System.out.println("5. APPROVISIONNEMENT");
            System.out.println("6. ANNULER APPROVISIONNEMENT");
            System.out.println("7. RETOUR");
            System.out.print("Entrez votre choix: ");
            choix = sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                    Carburant item = new Carburant();
                    stock.ajouterAuStock(item);
                    break;
                case 2:
                    System.out.print("Entrez ID du produit à supprimer ( choisir dans la liste ): ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    stock.supprimerDuStock(id);
                    break;
                case 3:
                    System.out.print("Entrez ID du produit à modifier ( choisir dans la liste ): ");
                    int id3 = sc.nextInt();
                    sc.nextLine();
                    stock.modifierStock(id3);
                    break;
                case 4:
                    stock.afficherStock();
                    break;
                case 5:
                    a.faireApprovisionnement();
                    l.ajouterApprovisionnement(a);
                    a.miseAJourStock();
                    break;
                case 6: if (GestionVente.getVentes().isEmpty() ) l.annulerApprovisionnement();
                        else System.out.println("Impossible d'annuler approvisionnement car il y'a des ventes");
                    break;
                case 7:
                    menuPrincipale();
                    break;
                default:
                    System.out.println("Erreur de choix !");
            }

            System.out.print("Souhaitez vous continuer Oui (1) / Non (0): ");
            reponse = sc.nextInt();
            sc.nextLine();
            if (reponse == 0) {
                break;
            }
        }

    }

    public static void menuFournisseur() {
        int choix = 0;
        int reponse = 1;
        Scanner sc = new Scanner(System.in);

        while(reponse == 1) {
            System.out.println("1. AJOUTER FOURNISSEUR");
            System.out.println("2. SUPPRIMER FOURNISSEUR");
            System.out.println("3. MODIFIER FOURNISSEUR");
            System.out.println("4. LISTE FOURNISSEUR");
            System.out.println("5. RETOUR");
            System.out.print("Entrez votre choix: ");
            choix = sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                    Fournisseur f = new Fournisseur();
                    ListeFournisseur.ajouterAListeFournisseur(f);
                    break;
                case 2:
                    System.out.print("Entrez ID du Fournisseur à supprimer ( choisir dans la liste ): ");
                    int id = sc.nextInt();
                    ListeFournisseur.supprimerFournisseur(id);
                    break;
                case 3:
                    System.out.print("Entrez ID du Fournisseur à modifier ( choisir dans la liste ): ");
                    int id3 = sc.nextInt();
                    ListeFournisseur.modifierFournisseur(id3);
                    break;
                case 4:
                    ListeFournisseur.afficherTousLesFournisseurs();
                    break;
                case 5:
                    menuPrincipale();
                    break;
                default:
                    System.out.println("Erreur de choix !");
            }

            System.out.print("Souhaitez vous continuer Oui (1) / Non (0): ");
            reponse = sc.nextInt();
            sc.nextLine();
            if (reponse == 0) {
                break;
            }
        }

    }

    public static void menuUtilisateur() {
        int choix = 0;
        int reponse = 1;
        Scanner sc = new Scanner(System.in);

        while(reponse == 1) {
            System.out.println("1. AJOUTER UTILISATEUR");
            System.out.println("2. SUPPRIMER UTILISATEUR");
            System.out.println("3. MODIFIER UTILISATEUR");
            System.out.println("4. LISTE UTILISATEUR");
            System.out.println("5. RETOUR");
            System.out.print("Entrez votre choix: ");
            choix = sc.nextInt();
            sc.nextLine();
            GestionUtilisateur u = new GestionUtilisateur();
            switch (choix) {
                case 1:
                    u.creerUtilisateur();
                    break;
                case 2:
                    u.supprimerUtilisateur();
                    break;
                case 3:
                    u.modifierUtilisateur();
                    break;
                case 4:
                    u.listeUtilisateurs();
                    break;
                case 5:
                    u.retour();
                    menuPrincipale();
                    break;
                default:
                    System.out.println("Erreur de choix !");
            }

            System.out.print("Souhaitez vous continuer Oui (1) / Non (0): ");
            reponse = sc.nextInt();
            sc.nextLine();
            if (reponse == 0) {
                break;
            }
        }

    }

    public static void menuVente() {
        int choix = 0;
        int reponse = 1;
        Scanner sc = new Scanner(System.in);

        while(reponse == 1) {
            System.out.println("1. NOUVELLE VENTE ");
            System.out.println("2. HISTORIQUE VENTE ");
            System.out.println("3. ANNULER VENTE ");
            System.out.println("4. RETOUR");
            System.out.print("Entrez votre choix: ");
            choix = sc.nextInt();
            sc.nextLine();
            GestionVente vente = new GestionVente();
            switch (choix) {
                case 1:
                    vente.nouvelleVente();
                    break;
                case 2:
                    vente.historique();
                    break;
                case 3:
                    vente.annulerVente();
                    break;
                case 4:
                    vente.retour();
                    menuPrincipale();
                    break;
                default:
                    System.out.println("Erreur de choix !");
            }

            System.out.print("Souhaitez vous continuer Oui (1) / Non (0): ");
            reponse = sc.nextInt();
            sc.nextLine();
            if (reponse == 0) {
                break;
            }
        }

    }

    public static int menuPrincipale() {
        int choix = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("1. VENTE / SORTIE ");
        System.out.println("2. CAISSE");
        System.out.println("3. CARBURANT");
        System.out.println("4. FOURNISSEUR");
        System.out.println("5. UTILISATEUR");
        System.out.println("6. DECONNEXION");
        System.out.print("Entrez votre choix: ");
        choix = sc.nextInt();
        return choix;
    }
}
