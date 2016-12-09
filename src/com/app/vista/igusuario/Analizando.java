/*
Ventana de analisis de las tramas que se encuentran llegando al puerto
 */
package com.app.vista.igusuario;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Analizando extends JFrame{

    public Analizando(){
        inicializar();
    }
    
    private void inicializar(){
        //Inicializar todos los componentes para visualizar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Comprobando");
        setUndecorated(true);
        JPanel panel = new JPanel();
        setContentPane(panel);
        JLabel imagen = new JLabel();
        ImageIcon imagenIcon = new  ImageIcon("src/com/app/imagenes/processing.gif");
        imagen.setIcon(imagenIcon);
        imagenIcon.setImageObserver(imagen);
        setIconImage(new ImageIcon("src/com/app/imagenes/icon.png").getImage());
        panel.add(imagen);
        pack();
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        //Prueba del jframe
        new Analizando().setVisible(true);
    }
    
}
