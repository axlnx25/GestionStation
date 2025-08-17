package entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ListeApprovisionnement {
    private static Map<Integer, Approvisionnement> ListeApprovisionnements = new HashMap<>();

    public static void ajouterApprovisionnement(Approvisionnement approvisionnement) {
        ListeApprovisionnements.put(approvisionnement.getIdentifiant(), approvisionnement);
        System.out.println("Ajouté avec succes ");
    }

    public static void afficherListeApprovisionnement() {
        if (ListeApprovisionnements.isEmpty()) {
            System.out.println("Liste d'approvisionnement vide !!!!");
        } else {
            System.out.println("Historique des approvisionnements: ");
            for (Approvisionnement approvisionnement: ListeApprovisionnements.values()) {
                System.out.println("----------------------------------------------");
                System.out.println(approvisionnement);
                System.out.println("----------------------------------------------");
            }
        }
    }

    public static void annulerApprovisionnement() {
        if (ListeApprovisionnements.isEmpty()) {
            System.out.println("Liste d'approvisionnement vide, pas " +
                    "d'approvisionnement à annuler!!!!");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Historique des approvisionnements: ");
            for (Approvisionnement approvisionnement: ListeApprovisionnements.values()) {
                System.out.println("----------------------------------------------");
                System.out.println(approvisionnement);
                System.out.println("----------------------------------------------");
            }
            System.out.print("Entrez identifiant de l'approvisionnement que vous souhaitez supprimer: ");
            int idDeSuppression = sc.nextInt();
            int i = 0;
            for (Approvisionnement approvisionnement: ListeApprovisionnements.values()) {
                if (idDeSuppression == approvisionnement.getIdentifiant()) {
//                    pour enlever du stock l'approvisionnement qui vient d'etre annuler
                    Approvisionnement a = ListeApprovisionnements.get(approvisionnement.getIdentifiant());
                    a.annulerApprovisionnement();
                    ListeApprovisionnements.remove(approvisionnement.getIdentifiant());
                    i++;
                    break;
                }
            }
            if (i == 0) {
                System.out.println("Cet approvisionnement que vous souhaitez supprimer " +
                        "n'est pas dans la liste des approvisionnement !" +
                        "/nRecommencez l'operation");
            } else System.out.printf("Approvisionnement annuler avec succès !!!!");
        }
    }
}
