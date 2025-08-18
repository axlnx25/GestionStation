package entities;

import java.util.ArrayList;
import java.util.Scanner;

class GestionUtilisateur {
    private ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // 1. Créer utilisateur
    public void creerUtilisateur() {
        System.out.print("Nom: ");
        String nom = sc.nextLine();
        System.out.print("Prénom: ");
        String prenom = sc.nextLine();
        System.out.print("Role: ");
        String role = sc.nextLine();

        Utilisateur u = new Utilisateur(nom, prenom, role);
        utilisateurs.add(u);
        System.out.println(" Utilisateur créé : " + u);
    }

    // 2. Supprimer utilisateur
    public void supprimerUtilisateur() {
        System.out.print("Entrez l'ID de l'utilisateur à supprimer: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Utilisateur u : utilisateurs) {
            if (u.getId() == id) {
                utilisateurs.remove(u);
                System.out.println("✅ Utilisateur supprimé !");
                return;
            }
        }
        System.out.println(" Utilisateur introuvable !");
    }

    // 3. Modifier utilisateur
    public void modifierUtilisateur() {
        System.out.print("Entrez l'ID de l'utilisateur à modifier: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Utilisateur u : utilisateurs) {
            if (u.getId() == id) {
                System.out.print("Nouveau nom (" + u.getNom() + "): ");
                String nom = sc.nextLine();
                if (!nom.isEmpty()) u.setNom(nom);

                System.out.print("Nouveau prénom (" + u.getPrenom() + "): ");
                String prenom = sc.nextLine();
                if (!prenom.isEmpty()) u.setPrenom(prenom);

                System.out.print("Nouveau rôle (" + u.getRole() + "): ");
                String role = sc.nextLine();
                if (!role.isEmpty()) u.setRole(role);

                System.out.println("✅ Utilisateur modifié : " + u);
                return;
            }
        }
        System.out.println(" Utilisateur introuvable !");
    }

    // 4. Liste utilisateurs
    public void listeUtilisateurs() {
        if (utilisateurs.isEmpty()) {
            System.out.println(" Aucun utilisateur enregistré.");
        } else {
            System.out.println(" Liste des utilisateurs :");
            for (Utilisateur u : utilisateurs) {
                System.out.println(u);
            }
        }
    }

        // 5. Retour
        public void retour() {
            System.out.println("↩️ Retour au menu principal...");
        }
    }


