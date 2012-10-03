/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pistelistat;

/**
 *
 * @author jojokine
 */   
    
import java.io.Serializable;

/**
 * Luokka määrittää HiScore-olion ominaisuudet, jokainen olio sisältää yhden pelaajan yhden pelikerran pelituloksen.
 * @author jojokine
 */

public class HiScore  implements Serializable, Comparable<HiScore>{
        private int pisteet;
        private String nimi;

        public int getPisteet() {
                return pisteet;
        }

        public String getNimi() {
                return nimi;
        }

        public HiScore(String nimi, int pisteet) {
                this.pisteet = pisteet;
                this.nimi = nimi;
        }
        @Override
        public int compareTo(HiScore pisteet1) {                      
                return ((Integer)(pisteet1.getPisteet())).compareTo(getPisteet());
        }
}