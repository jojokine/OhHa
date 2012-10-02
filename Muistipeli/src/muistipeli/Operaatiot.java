/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.util.ArrayList;

/**
 * Luokassa suoritetaan pelikentän tutkimiseen ja muokkaamiseen liittyvät
 * operaatiot
 *
 * @author jojokine
 */
public class Operaatiot {

    private static ArrayList<Laatta> pari;
//    static int paikka1;
//    static int paikka2;

    /**
     * Metodi tutki kentällä käännettynä olevaa laattaparia ja palauttaa true
     * tai false sen mukaan, olivatko ne pari.
     *
     * @param peli
     * @return true/false sen mukaan, oliko kyseessä pari vai ei.
     */
    public static boolean onkoPari(Kentta peli) {
        pari = haeKaannettyPari(peli);
        // System.out.println("onkopari" + pari.toString());
        if (pari.get(0).getTunniste() == pari.get(1).getTunniste()) {
            return oliPari(peli);
        } else {
            eiOllutPari(peli);
            return false;
        }
//        if (pari.size() < 2) {
//            eiOllutPari(peli);
//            return false;
//        } else if (pari.get(0).getTunniste() % 2 != 0 && pari.get(1).getTunniste() % 2 != 0) {
//            eiOllutPari(peli);
//            return false;
//        } else if (pari.get(0).getTunniste() % 2 == 0 && pari.get(1).getTunniste() % 2 == 0) {
//            eiOllutPari(peli);
//            return false;
//        } else if (pari.get(0).getTunniste() != (pari.get(1).getTunniste() + 1) && pari.get(0).getTunniste() != (pari.get(1).getTunniste() - 1)) {
//            eiOllutPari(peli);
//            return false;
//        } else {
//            return oliPari(peli);
//        }
    }

    /**
     * Metodi tutkii voidaanko kentällä oleva laatta kääntää
     *
     * @param peli kenttä, jota tutkitaan
     * @param paikka laatan sijainti kentällä
     * @return true tai false sen mukaan, voidaanko laatta kääntää.
     */
    public static boolean voikoKaantaa(Kentta peli, int paikka) {
        if (peli.getKaannetyt() == 0) {
            return true;
        } else if (peli.getKaannetyt() == 1 && peli.getLaatat().get(paikka).getTila() == false) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi hakee kentältä käännettynä olevan laattaparin ja lisää ne listaan
     * pari
     *
     * @param peli kenttä, jota tutkitaan
     */
    public static ArrayList<Laatta> haeKaannettyPari(Kentta peli) {
        pari = new ArrayList();
        pari.clear();
        for (int i = 0; i < peli.getLaatat().size(); i++) {
            if (peli.getLaatat().get(i).getTila() == true) {
                pari.add(peli.getLaatat().get(i));
            }
        }
        return pari;
    }

    /**
     * Metodi kääntää laatan kentältä
     *
     * @param peli kenttä, jolta laatta halutaan kääntää
     * @param paikka käännettävän laatan sijainti
     * @return
     */
    public static boolean kaannaLaatta(Kentta peli, int paikka) {
        if (Operaatiot.voikoKaantaa(peli, paikka)) {
            peli.getLaatat().get(paikka).nayta();
            peli.lisaaKaannettyja();
            return true;
        } else {
            peli.nollaaKaannetyt();
            return false;
        }
    }

    /**
     * Metodi suoritaa tarvittavat toimenpiteet laattaparin löydyttyä; -nollaa
     * käännettynä olevien laattojen määrän -merkitsee parin löytyneeksi
     * -piilottaa löydetyt laatat kentän käännetyistä, sillä ne on jo asetettu
     * löydetyiksi
     *
     * @param peli Kenttä, jonka arvoja muokataan
     * @return
     */
    public static boolean oliPari(Kentta peli) {
        peli.nollaaKaannetyt();
        peli.loytyi();
        for (int i = 0; i < peli.getLaatat().size(); i++) {
            if (peli.getLaatat().get(i).getTunniste() == pari.get(0).getTunniste()) {
                peli.getLaatat().get(i).piilota();
                peli.getLaatat().get(i).loyda();
            }
        }
        
        return true;
    }

    /**
     * Etsii käännetyt laatat ja kutsuu eiPari-metodia niillä.
     *
     * @param peli
     */
    private static void eiOllutPari(Kentta peli) {

        for (int i = 0; i < peli.getLaatat().size(); i++) {
            if (!peli.getLaatat().get(i).onkoLoydetty()) {
                peli.getLaatat().get(i).piilota();
                peli.nollaaKaannetyt();
            }


        }

    }
}
