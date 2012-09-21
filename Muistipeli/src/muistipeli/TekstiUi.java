/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.util.Scanner;

/**
 *
 * @author jojokine
 */
public class TekstiUi {

    private static Scanner lukija = new Scanner(System.in);

    public static void Tekstipeli() {

        int paikka1;
        int paikka2;
        muistipeli.Kentta peli;
        peli = new muistipeli.Kentta(1);

//        peli.getLaatat().get(1).setTunniste(1);
//        peli.getLaatat().get(2).setTunniste(2);
        while (peli.getParit()
                <= (peli.getLaattoja() / 2)) {

            paikka1 = kaanna1(peli);
            paikka2 = kaanna2(peli);

            if (Operaatiot.onkoPari(peli)) {
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

    private static int kaanna2(Kentta peli) {
        int paikka2;
        System.out.println("Anna 2.laatan paikka");
        paikka2 = lukija.nextInt();
        if (Operaatiot.voikoKaantaa(peli, paikka2)) {
            peli.getLaatat().get(paikka2).nayta();
            peli.lisaaKaannettyja();
        } else {
            System.out.println("Ei voi kääntää!");
            kaanna2(peli);
        }
        return paikka2;
    }

    private static int kaanna1(Kentta peli) {
        int paikka1;
        System.out.println("Anna 1.laatan paikka");
        paikka1 = lukija.nextInt();
        if (Operaatiot.voikoKaantaa(peli, paikka1)) {
            peli.getLaatat().get(paikka1).nayta();
            peli.lisaaKaannettyja();
        } else {
            System.out.println("Ei voi kääntää!");
            kaanna1(peli);
        }
        return paikka1;
    }
}
