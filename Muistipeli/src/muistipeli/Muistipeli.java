/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jojokine
 */
public class Muistipeli {

    private static Scanner lukija = new Scanner(System.in);

//    private int vaikeus;
//    private int kaannetty1;
//    private int kaannetty2;
    public static boolean onkoPari(Kentta peli) {
        ArrayList<Laatta> pari = new ArrayList();
        for (int i = 0; i < peli.getLaatat().size(); i++) {
            if (peli.getLaatat().get(i).getTila() == true) {
                pari.add(peli.getLaatat().get(i));
            }
        }
        if (pari.get(0).getTunniste() % 2 != 0 && pari.get(1).getTunniste() % 2 != 0) {
            return false;
        } else if (pari.get(0).getTunniste() % 2 == 0 && pari.get(1).getTunniste() % 2 == 0) {
            return false;
        } else if (pari.get(0).getTunniste() != (pari.get(1).getTunniste() + 1) && pari.get(0).getTunniste() != (pari.get(1).getTunniste() - 1)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean voikoKaantaa(Kentta peli, int paikka) {
        if (peli.getKaannetyt() == 0) {
            return true;
        } else if (peli.getKaannetyt() == 1 && peli.getLaatat().get(paikka).getTila() == false) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int paikka1;
        int paikka2;

        muistipeli.Kentta peli;
        peli = new muistipeli.Kentta(1);

//        peli.getLaatat().get(1).setTunniste(1);
//        peli.getLaatat().get(2).setTunniste(2);

        while (peli.getParit() <= (peli.getLaattoja() / 2)) {
            System.out.println("Anna 1.laatan paikka");
            paikka1 = lukija.nextInt();
            System.out.println("Anna 2.laatan paikka");
            paikka2 = lukija.nextInt();

            if (voikoKaantaa(peli, paikka1)) {
                peli.getLaatat().get(paikka1).nayta();
                peli.lisaaKaannettyja();
            } else {
                System.out.println("Ei voi kääntää!");
            }
            if (voikoKaantaa(peli, paikka2)) {
                peli.getLaatat().get(paikka2).nayta();
                peli.lisaaKaannettyja();
            } else {
                System.out.println("Ei voi kääntää!");
            }

            if (onkoPari(peli)) {
                System.out.println("Löysit parin!");
                peli.nollaaKaannetyt();
                peli.getLaatat().get(paikka1).loyda();
                peli.getLaatat().get(paikka2).loyda();
                peli.loytyi();
            } else {
                System.out.println("Ei pari!");
                peli.eiPari(paikka1, paikka2);
            }
        }
    }
}
