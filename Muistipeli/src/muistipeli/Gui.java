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
    ImageIcon pari1 = new ImageIcon("kuvat/pari1");

    public Gui(int laattoja) {

        int paikka1;
        int paikka2;
        final muistipeli.Kentta peli;
        peli = new muistipeli.Kentta(1);

        if (laattoja == 16) {
            kentanKoko = new GridLayout(4, 4);
        } else if (laattoja == 24) {
            kentanKoko = new GridLayout(6, 4);
        } else {
            kentanKoko = new GridLayout(6, 6);
        }

        final JButton[] laatat = new JButton[laattoja];
        peliKentta = new JPanel(kentanKoko);
        for (i = 0; i < laatat.length; i++) {
            laatat[i] = new JButton(Integer.toString(i + 1));
            laatat[i].setSize(80, 80);
            
            
            laatat[i].addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            for (int i = 1; i < laatat.length; i++) {
                                if (e.getSource() == laatat[i]) {
                                    kaannettava = i;
                                    break;
                                }
                            }
                            System.out.println("yritetään kääntää" + kaannettava);

                            if (Operaatiot.kaannaLaatta(peli, kaannettava)) {
                                System.out.println("käännettiin!");
                                if (Operaatiot.onkoPari(peli)) {
                                    System.out.println("löysit parin!");
                                } else {
                                    System.out.println("eivät olleet pari!");
                                }
                            }

                        }
                    });
            peliKentta.add(laatat[i]);

        }
    }

    public static void main(String args[]) {
        Gui ruudukko = new Gui(16);
        ruudukko.setTitle("Muistipeli");
        ruudukko.add(peliKentta);
        ruudukko.pack();
        ruudukko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ruudukko.setVisible(true);
    }
}
