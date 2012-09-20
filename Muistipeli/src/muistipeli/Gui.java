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

    public Gui(int laattoja) {

        if (laattoja == 16) {
            kentanKoko = new GridLayout(4, 4);
        } else if (laattoja == 24) {
            kentanKoko = new GridLayout(6, 4);
        } else {
            kentanKoko = new GridLayout(6, 6);
        }

        JButton[] laatat = new JButton[laattoja];
        peliKentta = new JPanel(kentanKoko);
        for (i = 0; i < laatat.length; i++) {
            laatat[i] = new JButton(Integer.toString(i + 1));
            laatat[i].setSize(80, 80);
            laatat[i].addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent klikkaus) {
                            System.out.println();
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
