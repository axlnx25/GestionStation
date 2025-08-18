import entities.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Authentification auth = new Authentification();
        int reponse;

        while (true) {
            // Login obligatoire
            while (!auth.isConnecte()) {
                System.out.println("\n=== LOGIN REQUIS ===");
                auth.login(sc);
            }

            // Menu principal après connexion
            reponse = 1;
            while (reponse == 1 && auth.isConnecte()) {
                int choix = menuPrincipale(sc);

                switch (choix) {
                    case 1: menuVente(sc); break;
                    case 2: menuCaisse(sc); break;
                    case 3: menuCarburant(sc); break;
                    case 4: menuFournisseur(sc); break;
                    case 5: menuUtilisateur(sc); break;
                    case 6: // DECONNEXION
                        auth.logout();
                        reponse = 0; // sortir du sous-menu pour revenir au login
                        break;
                    default:
                        System.out.println("Erreur de choix !");
                }

                if (auth.isConnecte() && choix != 6) {
                    System.out.print("Souhaitez-vous continuer Oui (1) / Non (0) : ");
                    reponse = sc.nextInt();
                    sc.nextLine();
                }
            }
        }
    }

    // Menu principal
    public static int menuPrincipale(Scanner sc) {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. VENTE / SORTIE");
        System.out.println("2. CAISSE");
        System.out.println("3. CARBURANT");
        System.out.println("4. FOURNISSEUR");
        System.out.println("5. UTILISATEUR");
        System.out.println("6. DECONNEXION");
        System.out.print("Entrez votre choix: ");
        return sc.nextInt();
    }

    // MENU VENTE
    public static void menuVente(Scanner sc) {
        GestionVente vente = new GestionVente();
        int choix, reponse = 1;

        while (reponse == 1) {
            System.out.println("\n--- MENU VENTE ---");
            System.out.println("1. NOUVELLE VENTE");
            System.out.println("2. HISTORIQUE VENTE");
            System.out.println("3. ANNULER VENTE");
            System.out.println("4. RETOUR");
            System.out.print("Entrez votre choix: ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1: vente.nouvelleVente(sc); break;
                case 2: vente.historique(); break;
                case 3: vente.annulerVente(sc); break;
                case 4: reponse = 0; break;
                default: System.out.println("Erreur de choix !");
            }

            if (reponse != 0) {
                System.out.print("Souhaitez-vous continuer Oui (1) / Non (0) : ");
                reponse = sc.nextInt();
                sc.nextLine();
            }
        }
    }

    // MENU CAISSE
    public static void menuCaisse(Scanner sc) {
        Caisse caisse = new Caisse();
        int choix, reponse = 1;

        while (reponse == 1) {
            System.out.println("\n--- MENU CAISSE ---");
            System.out.println("1. LISTE DES ENTREES");
            System.out.println("2. LISTE DES SORTIES");
            System.out.println("3. RECAPITULATIF");
            System.out.println("4. RETOUR");
            System.out.print("Entrez votre choix: ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1: caisse.afficherListeDesEntree(); break;
                case 2: caisse.afficherListeDesSortes(); break;
                case 3: caisse.recapitulatif(); break;
                case 4: reponse = 0; break;
                default: System.out.println("Erreur de choix !");
            }

            if (reponse != 0) {
                System.out.print("Souhaitez-vous continuer Oui (1) / Non (0) : ");
                reponse = sc.nextInt();
                sc.nextLine();
            }
        }
    }

    // MENU CARBURANT
    public static void menuCarburant(Scanner sc) {
        Stock stock = new Stock();
        Approvisionnement a = new Approvisionnement();
        int choix, reponse = 1;

        while (reponse == 1) {
            System.out.println("\n--- MENU CARBURANT ---");
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
                case 1: Carburant item = new Carburant(); stock.ajouterAuStock(item); break;
                case 2: System.out.print("ID du produit à supprimer: "); stock.supprimerDuStock(sc.nextInt()); sc.nextLine(); break;
                case 3: System.out.print("ID du produit à modifier: "); stock.modifierStock(sc.nextInt()); sc.nextLine(); break;
                case 4: stock.afficherStock(); break;
                case 5: a.faireApprovisionnement(); ListeApprovisionnement.ajouterApprovisionnement(a); a.miseAJourStock(); break;
                case 6: ListeApprovisionnement.annulerApprovisionnement(); a.annulerApprovisionnement(); break;
                case 7: reponse = 0; break;
                default: System.out.println("Erreur de choix !");
            }

            if (reponse != 0) {
                System.out.print("Souhaitez-vous continuer Oui (1) / Non (0) : ");
                reponse = sc.nextInt();
                sc.nextLine();
            }
        }
    }

    // MENU FOURNISSEUR
    public static void menuFournisseur(Scanner sc) {
        Fournisseur f = new Fournisseur();
        int choix, reponse = 1;

        while (reponse == 1) {
            System.out.println("\n--- MENU FOURNISSEUR ---");
            System.out.println("1. AJOUTER FOURNISSEUR");
            System.out.println("2. SUPPRIMER FOURNISSEUR");
            System.out.println("3. MODIFIER FOURNISSEUR");
            System.out.println("4. LISTE FOURNISSEUR");
            System.out.println("5. RETOUR");
            System.out.print("Entrez votre choix: ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1: ListeFournisseur.ajouterAListeFournisseur(f);
                break;
                case 2: System.out.print("Entrez ID du Fournisseur à supprimer ( choisir dans la liste ): "); int id = sc.nextInt(); ListeFournisseur.supprimerFournisseur(id);
                break;
                case 3: System.out.print("Entrez ID du Fournisseur à modifier ( choisir dans la liste ): "); int id3 = sc.nextInt(); ListeFournisseur.modifierFournisseur(id3);
                break;
                case 4: ListeFournisseur.afficherTousLesFournisseurs();
                break;
                case 5: menuPrincipale(sc);
                break;

                default:System.out.println("Erreur de choix !"); break;
            }

            if (reponse != 0) {
                System.out.print("Souhaitez-vous continuer Oui (1) / Non (0) : ");
                reponse = sc.nextInt();
                sc.nextLine();
            }
        }
    }

    // MENU UTILISATEUR
    public static void menuUtilisateur(Scanner sc) {
        GestionUtilisateur u = new GestionUtilisateur();
        int choix, reponse = 1;

        while (reponse == 1) {
            System.out.println("\n--- MENU UTILISATEUR ---");
            System.out.println("1. AJOUTER UTILISATEUR");
            System.out.println("2. SUPPRIMER UTILISATEUR");
            System.out.println("3. MODIFIER UTILISATEUR");
            System.out.println("4. LISTE UTILISATEUR");
            System.out.println("5. RETOUR");
            System.out.print("Entrez votre choix: ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1: u.creerUtilisateur(); break;
                case 2: u.supprimerUtilisateur(); break;
                case 3: u.modifierUtilisateur(); break;
                case 4: u.listeUtilisateurs(); break;
                case 5: reponse = 0; break;
                default: System.out.println("Erreur de choix !");
            }

            if (reponse != 0) {
                System.out.print("Souhaitez-vous continuer Oui (1) / Non (0) : ");
                reponse = sc.nextInt();
                sc.nextLine();
            }
        }
    }
}
