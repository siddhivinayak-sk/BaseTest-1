/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sandeepkumar
 */
public class JFrameTest {
    
    public static void main(String...args) {
        JFrame jf = new JFrame("Test Frame");
        jf.setVisible(true);
        jf.setSize(400, 400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int b = JOptionPane.showConfirmDialog(jf, "Do you want to close this application?", "Confirm...?", JOptionPane.YES_NO_OPTION);
                if(b == 0) {
                    System.exit(0);
                }
            }
        });
        
        
        /*
        jf.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                int b = JOptionPane.showConfirmDialog(jf, "Do you want to close this application?", "Confirm...?", JOptionPane.YES_NO_OPTION);
                if(b == 0) {
                    System.exit(0);
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        */
    }
    
}
