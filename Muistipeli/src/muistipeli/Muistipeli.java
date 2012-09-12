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
public class Muistipeli {

//    private int vaikeus;
//    private int kaannetty1;
//    private int kaannetty2;
    
    private boolean onkoPari(Kentta peli) {
        ArrayList<Laatta> pari = new ArrayList();

        for (int i = 0; i < peli.getLaatat().size(); i++) {
            if (peli.getLaatat().get(i).getTila() == true) {
                pari.add(peli.getLaatat().get(i));
            }
        }
        if (pari.get(0).getTunniste() == pari.get(1).getTunniste()) {
            return true;
        } else {

            return false;
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
        // TODO code application logic here
    }
}
