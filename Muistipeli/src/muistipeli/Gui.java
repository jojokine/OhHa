/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author jojokine
 */
public class Gui extends JFrame {

    int i = 0;
    static JPanel peliKentta;
    GridLayout kentanKoko;
    int kaannettava;
    static ImageIcon pari1 = new ImageIcon("kuvat/pari1");

    public Gui(int vaikeus) {

        final muistipeli.Kentta peli;
        peli = new muistipeli.Kentta(vaikeus);

        if (peli.getLaattoja() == 16) {
            kentanKoko = new GridLayout(4, 4);
        } else if (peli.getLaattoja() == 24) {
            kentanKoko = new GridLayout(6, 4);
        } else if (peli.getLaattoja() == 36) {
            kentanKoko = new GridLayout(6, 6);
        }

        //peli.getLaatat().get(1).setTunniste(1);
        //peli.getLaatat().get(2).setTunniste(2);

        for (int j = 0; j < peli.getLaatat().size(); j++) {
            System.out.println((j + 1) + " on " + peli.getLaatat().get(j).getTunniste());
        }




        final JToggleButton[] laatat = new JToggleButton[peli.getLaattoja()];

        peliKentta = new JPanel(kentanKoko);
        for (i = 0; i < laatat.length; i++) {
            laatat[i] = new JToggleButton(pari1);
            // laatat[i] = new JButton(Integer.toString(i + 1));
            laatat[i].setSize(100, 100);
            laatat[i].addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            kaannettava = 0;

                            for (int i = 1; i < laatat.length; i++) {
                                if (e.getSource() == laatat[i]) {
                                    kaannettava = i;
                                }
                            }
                            System.out.println("yritetään kääntää" + ((kaannettava + 1)));


                            if (Operaatiot.kaannaLaatta(peli, (kaannettava))) {
                                System.out.println("käännettiin!");
                                if (peli.getKaannetyt() == 2) {
                                    if (Operaatiot.onkoPari(peli)) {
                                        System.out.println("löysit parin!");

                                    } else {
                                        System.out.println("eivät olleet pari!");

                                    }
                                }
                            }


                        }
                    });
            peliKentta.add(laatat[i]);

        }
    }

    public static void main(String args[]) {
        Gui ruudukko = new Gui(1);
        ruudukko.setTitle("Muistipeli");
        ruudukko.setPreferredSize(new Dimension(800, 800));
        ruudukko.add(peliKentta);
        ruudukko.pack();
        ruudukko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ruudukko.setVisible(true);

    }
}
