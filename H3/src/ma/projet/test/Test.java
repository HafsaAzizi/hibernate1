/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Calendar;
import java.util.Date;
import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.EmployeTachePK;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.services.EmployeService;
import ma.projet.services.EmployeTacheService;
import ma.projet.services.ProjetService;
import ma.projet.services.TacheService;

public class Test {
    public static void main(String[] args) {
        EmployeService es = new EmployeService();
        EmployeTacheService ets = new EmployeTacheService();
        ProjetService ps = new ProjetService();
        TacheService ts = new TacheService();

        Employe e1 = new Employe("anas", "ghazi", "0600552211");
        Employe e2 = new Employe("yassine", "ghazi","0645708840");
        es.create(e1);
        es.create(e2);

        Calendar dateDebut = Calendar.getInstance();
        dateDebut.set(2022, Calendar.OCTOBER, 5);
        Calendar calendarDebut2 = Calendar.getInstance();
        calendarDebut2.set(2022, Calendar.DECEMBER, 16);
        Projet p = new Projet("Finance", dateDebut.getTime(), calendarDebut2.getTime(), e2);


        ps.create(p);


        Tache t = new Tache("finance", dateDebut.getTime(), calendarDebut2.getTime(), 20000, p);
        Tache t2 = new Tache("info", dateDebut.getTime(), calendarDebut2.getTime(), 10000, p);
        ts.create(t);
        ts.create(t2);

        Date dateAttribution = new Date();

        EmployeTachePK employeTachePK1 = new EmployeTachePK(e2.getId(), t.getId(), dateAttribution);
        EmployeTache employeTache1 = new EmployeTache(employeTachePK1);
        ets.create(employeTache1);

        EmployeTachePK employeTachePK2 = new EmployeTachePK(e2.getId(), t2.getId(), dateAttribution);
        EmployeTache employeTache2 = new EmployeTache(employeTachePK2);
        ets.create(employeTache2);

        System.out.println("tache de'yassine'.");
        es.getTachesByEmploye(e2);
        es.getProjectsByEmploye(e2);

        ps.getTachesByProjets(p);
    }
}


