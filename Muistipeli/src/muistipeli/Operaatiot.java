/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.util.ArrayList;

/**
 *
 * @author jojokine
 */
public class Operaatiot {

    static ArrayList<Laatta> pari;

    public static boolean onkoPari(Kentta peli) {
        pari = new ArrayList();
        haeKaannettyPari(peli);
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

    public static void haeKaannettyPari(Kentta peli) {
        pari.clear();
        for (int i = 0; i < peli.getLaatat().size(); i++) {
            if (peli.getLaatat().get(i).getTila() == true) {
                pari.add(peli.getLaatat().get(i));
            }
        }
    }
}
