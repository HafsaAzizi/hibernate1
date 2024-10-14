/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h1;

import java.util.Date;
import java.util.List;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;

/**
 *
 * @author YASSINE
 */
public class H1 {
      

    public static void main(String[] args) {
        ProduitService ps = new ProduitService();

       // Créez cinq produits
        Produit produit1 = new Produit("zara", "z", new Date(), 29.99,"produit1" );
        Produit produit2 = new Produit("yassine", "e", new Date(), 29.99,"produit2" );  
        Produit produit3 = new Produit("maha", "f", new Date(), 29.99,"produit3" );
        Produit produit4 = new Produit("mouha", "i", new Date(), 29.99,"produit4" );
        Produit produit5 = new Produit("derb", "p", new Date(), 29.99,"produit5" );
        
        
        // Ajoutez les produits à la base de données
        ps.create(produit1);
        ps.create(produit2);
        ps.create(produit3);
        ps.create(produit4);
        ps.create(produit5);
                System.out.println("yassine");

        // Affichez la liste des produits
         for(Produit p : ps.findAll())
            System.out.println(p.getMarque());
         
        //Afficher les informations du produit dont id = 2
        System.out.println(ps.findById(2));
        
       // Supprimer le produit dont id = 3
        //ps.delete(ps.findById(3));
        
       // Modifier les informations du produit dont id = 1,
        Produit updated =ps.findById(1);
        updated.setPrix(100);
        ps.update(updated);
                
       //Afficher la liste des produits dont le prix est supérieur à 100 DH
        List<Produit> produits = ps.produitsSup100();
       for (Produit produit : produits) {
       System.out.println("Marque : " + produit.getMarque());
       }
       //Afficher la liste des produits Commander entre deux dates lus au clavier
       ps.twoDateProducts();
    
    }  
}
