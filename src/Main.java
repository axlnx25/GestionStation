import entities.*;
import java.util.*;

public class Main  {
    public static void main(String[] args) {

    }

    public int menuCaisse () {
        int choix = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("1. LISTE DES ENTREES");
        System.out.println("2. LISTE DES SORTIES");
        System.out.println("3. RECAPITULATIF");
        System.out.println("4. RETOUR");
        System.out.print("Entrez votre choix: ");
        choix = sc.nextInt();
        return choix;
    }

    public int menuCarburant() {
        int choix = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("1. SAISIR PRODUIT");
        System.out.println("2. SUPPRIMER PRODUIT");
        System.out.println("3. MODIFIER PRODUIT");
        System.out.println("4. STOCK PRODUIT");
        System.out.println("5. APPROVISIONNEMENT");
        System.out.println("6. ANNULER APPROVISIONNEMENT");
        System.out.println("7. RETOUR");
        System.out.print("Entrez votre choix: ");
        choix = sc.nextInt();
        return choix;
    }

    public int menuFournisseur() {
        int choix = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("1. AJOUTER FOURNISSEUR");
        System.out.println("2. SUPPRIMER FOURNISSEUR");
        System.out.println("3. MODIFIER FOURNISSEUR");
        System.out.println("4. LISTE FOURNISSEUR");
        System.out.println("5. RETOUR");
        System.out.print("Entrez votre choix: ");
        choix = sc.nextInt();
        return choix;
    }


}