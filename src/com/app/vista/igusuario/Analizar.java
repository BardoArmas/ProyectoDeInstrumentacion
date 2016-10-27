/*
Ventana de analisis de las tramas que se encuentran llegando al puerto
 */
package com.app.vista.igusuario;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Analizar extends JFrame{

    public Analizar(){
        inicializar();
    }
    
    private void inicializar(){
        //Inicializar todos los componentes para visualizar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Comprobando");
        setUndecorated(true);
        setContentPane(new JPanel(new BorderLayout()));
        JLabel imagen = new JLabel();
        ImageIcon imagenIcon = new  ImageIcon("src/com/app/imagenes/processing.gif");
        imagen.setIcon(imagenIcon);
        imagenIcon.setImageObserver(imagen);
        setIconImage(new ImageIcon("src/com/app/imagenes/icon.png").getImage());
        add(imagen);
        setLocationRelativeTo(null);
        pack();
    }
    
    public static void main(String[] args) {
        //Prueba del jframe
        new Analizar().setVisible(true);
    }
    
}
