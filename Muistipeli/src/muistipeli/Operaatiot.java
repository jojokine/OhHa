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

    static ArrayList<Laatta> pari;
//    static int paikka1;
//    static int paikka2;

    public static boolean onkoPari(Kentta peli) {
        pari = haeKaannettyPari(peli);
        System.out.println("onkopari"+pari.toString());
        if (pari.size() < 2) {
            peli.eiPari(peli.haeLaatanIndeksi(pari.get(0).getTunniste()), peli.haeLaatanIndeksi(pari.get(1).getTunniste()));
            return false;
        }
        else if (pari.get(0).getTunniste() % 2 != 0 && pari.get(1).getTunniste() % 2 != 0) {
            peli.eiPari(peli.haeLaatanIndeksi(pari.get(0).getTunniste()), peli.haeLaatanIndeksi(pari.get(1).getTunniste()));
            return false;
        } else if (pari.get(0).getTunniste() % 2 == 0 && pari.get(1).getTunniste() % 2 == 0) {
            peli.eiPari(peli.haeLaatanIndeksi(pari.get(0).getTunniste()), peli.haeLaatanIndeksi(pari.get(1).getTunniste()));
            return false;
        } else if (pari.get(0).getTunniste() != (pari.get(1).getTunniste() + 1) && pari.get(0).getTunniste() != (pari.get(1).getTunniste() - 1)) {
            peli.eiPari(peli.haeLaatanIndeksi(pari.get(0).getTunniste()), peli.haeLaatanIndeksi(pari.get(1).getTunniste()));
            return false;
        } else {
            peli.nollaaKaannetyt();
            return true;
        }
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

        if (peli.getKaannetyt() == 0) {
            return kaanna1(peli, paikka);
        } else {
            return kaanna2(peli, paikka);
        }

    }

    private static boolean kaanna2(Kentta peli, int paikka2) {
        //System.out.println("Anna 2.laatan paikka");
        if (Operaatiot.voikoKaantaa(peli, paikka2)) {
            peli.getLaatat().get(paikka2).nayta();
            peli.lisaaKaannettyja();
            return true;
        } else {
            System.out.println("Ei voi kääntää!");
            peli.nollaaKaannetyt();
            return false;
        }
    }

    private static boolean kaanna1(Kentta peli, int paikka1) {
        //System.out.println("Anna 1.laatan paikka");
        if (Operaatiot.voikoKaantaa(peli, paikka1)) {
            peli.getLaatat().get(paikka1).nayta();
            peli.lisaaKaannettyja();
            return true;
        } else {
            System.out.println("Ei voi kääntää!");
            peli.nollaaKaannetyt();
            return false;

        }
    }
}
