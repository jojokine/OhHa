/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

/**
 *
 * @author jojokine
 */
public class Muistipeli {

//    private int vaikeus;
//    private int kaannetty1;
//    private int kaannetty2;

//    private boolean onkoPari(Kentta peli) {
//        if 
//      {
//        }
//    }

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
