package ex2;

import java.util.Date;
import java.util.List;
import ma.projet.classes.*;
import ma.projet.service.*;
import ma.projet.util.HibernateUtil;



public class Ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        
  /*      ProduitService produitService = new ProduitService();
List<Produit> produitsCommande = produitService.findProduitsByCommandeId(4);

for (Produit produit : produitsCommande) {
    System.out.println("Référence: " + produit.getReference() + 
                       ", Prix: " + produit.getPrix() + 
                       ", Quantité: " + produit.getQuantite());
}
        */
      
        
        
        // Création du service pour les produits
        ProduitService ps = new ProduitService();
        CategorieService cs = new CategorieService();
        CommandeService cos = new CommandeService();
        LigneCommandeProduitService lcps = new LigneCommandeProduitService();
        // 1. Création des catégories
        
        Categorie categorie1 = new Categorie("C01", "Électronique");
        Categorie categorie2 = new Categorie("C02", "Alimentation");
        cs.create(categorie1);
        cs.create(categorie2);
        
        
        

        // 2. Création des produits associés aux catégories
        Produit produit1 = new Produit("ES12", 120, cs.findById(1));
        Produit produit2 = new Produit("ZR85", 100, cs.findById(2));
   //     Produit produit3 = new Produit("EE85", 200, categorie2);

         ps.create(produit1);
         ps.create(produit2);
       //  produitService.create(produit3);

        
        // 3. Création d'une commande
        Commande commande = new Commande(new Date(2024-10-13)); // Utilisation de la date actuelle
         cos.create(commande);
          Commande commande1 = new Commande(new Date(2024-10-14)); // Utilisation de la date actuelle
         cos.create(commande1);
        // 4. Création des lignes de commande (produits commandés)
        LigneCommandeProduit ligne1 = new LigneCommandeProduit(7, ps.findById(1), cos.findById(1)); // 7 unités du produit ES12
        LigneCommandeProduit ligne2 = new LigneCommandeProduit(14, ps.findById(2), cos.findById(2)); // 14 unités du produit ZR85
      //  LigneCommandeProduit ligne3 = new LigneCommandeProduit(5, produit3, commande); // 5 unités du produit EE85
        lcps.create(ligne1);
         lcps.create(ligne2);
     //     lcps.create(ligne3);
        
        
        
        // 5. Enregistrement des objets dans la base de données
       
        // Ici, on pourrait aussi implémenter un service pour Commande et LigneCommandeProduit 
        // pour persister ces objets dans la base de données si nécessaire.
         
        
          // 1. Test de la méthode findByCategorieId (trouver les produits par catégorie)
        System.out.println("----- Produits par catégorie -----");
        List<Produit> produitsParCategorie = ps.findByCategorieId(1); // Exemple avec catégorie ID = 1
        for (Produit p : produitsParCategorie) {
            System.out.println(p.getReference() + " - " + p.getPrix() + " DH");
        }

        
        
        // 2. Test de la méthode findCommandesBetweenDates (trouver les produits commandés entre deux dates)
        System.out.println("\n----- Produits commandés entre deux dates -----");
        Date startDate = new Date(2024-10-12);  // Par exemple, 1er Septembre 2023
        Date endDate = new Date(2024-10-15);   //
        
        // Par exemple, 30 Septembre 2023
        List<Produit> produitsEntreDates = ps.findCommandesBetweenDates(startDate, endDate);
        for (Produit pp : produitsEntreDates) {
            System.out.println("La reference du produit est : " +pp.getReference() + "Le prix du produit" + pp.getPrix() + " DH");
        }
        

        // 3. Test de la méthode findProductsAbovePrice (trouver les produits au-dessus d'un prix donné)
        System.out.println("\n----- Produits au-dessus d'un certain prix -----");
        List<Produit> produitsAbovePrice = ps.findProductsAbovePrice(100); // Par exemple, produits au-dessus de 150 DH
        for (Produit p : produitsAbovePrice) {
            System.out.println(p.getReference() + " - " + p.getPrix() + " DH");
        }

        // 4. Test de la méthode findProduitsByCommandeId (trouver les produits d'une commande donnée)
        System.out.println("\n----- Produits par commande -----");
      List<Produit> produitsCommande = ps.findProduitsByCommandeId(2);

    for (Produit produit : produitsCommande) {
    System.out.println("Référence: " + produit.getReference() + 
                       ", Prix: " + produit.getPrix() +"Catégorie " + produit.getCategorie().getLibelle() );
    }
   

        // Fermer la session Hibernate
     //   HibernateUtil.getSessionFactory().close();
  
         
         
         
         
         
         
         
         
        
        
        
    }
    
}
