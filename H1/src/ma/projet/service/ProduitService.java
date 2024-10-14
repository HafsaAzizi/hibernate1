/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ma.projet.dao.IDao;
import ma.projet.entity.Produit;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author YASSINE
 */
public class ProduitService implements IDao<Produit> {

    @Override
    public boolean create(Produit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Produit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean update(Produit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public Produit findById(int id) {
        Produit produit = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produit = (Produit) session.get(Produit.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return produit;
    }

    @Override
    public List<Produit> findAll() {
        List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.createQuery("from Produit").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return produits;
    }
    public List<Produit> produitsSup100() {
    List<Produit> produits = null;
    Session session = null;
    Transaction tx = null;
    
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        String hql = "FROM Produit p WHERE p.prix > 100";
        produits = session.createQuery(hql).list();

        tx.commit();
    } catch (HibernateException e) {
        if (tx != null)
            tx.rollback();
    } finally {
        if (session != null)
            session.close();
    }
    
    return produits;
}
public void twoDateProducts(){
Scanner s = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDebut = null;
        Date dateFin = null;
        ProduitService ps = new ProduitService();
        Produit p1 = new Produit("YAN&ONE", "SUPER",  new Date("2020/01/20"), 90.0,"RAL");
        Produit p2 = new Produit("ESSENCE", "SUPER", new Date("2020/02/20"), 190.0, "MASCARA");
        Produit p3 = new Produit("GOLDEN", "SUPER", new Date("2020/03/20"), 120.0, "GR");
        Produit p4 = new Produit("MAC", "MAKEUP", new Date("2020/04/20"), 200.0, "GLOSE");
        Produit p5 = new Produit("HBT", "GAMME", new Date("2020/05/20"), 600.000, "HAUTEGAMME");
//        ps.create(p1);
//        ps.create(p2);
//        ps.create(p3);
//        ps.create(p4);
//        ps.create(p5);
        for (Produit p : ps.findAll()) {
            System.out.println(p);
        }
        System.out.println(ps.findById(2));
      //  ps.delete(ps.findById(3));
     Produit pp = ps.findById(1);

 pp.setDateAchat(new Date());
        ps.update(pp);
        
        for (Produit p : ps.findAll()) {
            if (p.getPrix() > 100) {
                System.out.println(p);
            }
        }
        System.out.println("entrez la date de debut ");
        try {
            dateDebut = dateFormat.parse(s.nextLine());
        } catch (ParseException ex) {
            System.out.println("date invalide");
        }
        System.out.println("entrez la date de fin");
        try {
            dateFin = dateFormat.parse(s.nextLine());
        } catch (ParseException ex) {
            System.out.println("date non valide");
        }
        for (Produit p : ps.findAll()) {
            if (p.getDateAchat().after(dateDebut) && p.getDateAchat().before(dateFin)) {
                System.out.println(p);
            }
        }
}
}
