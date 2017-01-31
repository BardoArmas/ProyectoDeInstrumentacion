/*
 */
package test;

import com.app.modelo.dialpanel.Termometro;
import java.awt.Dimension;
import javax.swing.JFrame;

public class TestTermometro {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Prueba de Termometro");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 500));
        Termometro termometro = new Termometro();
        frame.setContentPane(termometro.crearChart());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
