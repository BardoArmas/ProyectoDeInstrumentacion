/*
Aqui se puede hacer un espacio
para cargar todos los elementos necesarios para acceder
al sistema ya sea una conexion a un manejador de base de datos
o cehcar los puertos necesarios
 */
package com.app.vista.ig;

import com.app.controlador.sesion.Sesion;
import com.app.modelo.arduino.ComunicacionArduino;
import com.app.modelo.conexion.db.Conexion;

public class Splash extends javax.swing.JFrame {

    private class BarraDeEstado extends Thread {
        
        private Splash splash;
        private Sesion sesion;
        private Conexion conexion;
        private ComunicacionArduino arduino;

        public BarraDeEstado(Splash splash){
            this.splash = splash;
        }
        @Override
        public void run() {
            //Procedimiento de guardar
           //Se checa que realmente se puede caragar todo
            try {
                //Iniciar la seccion
                sesion = new Sesion();
                estado.setText("Session Iniciada");
                barra.setValue(10);
                Thread.sleep(150);
                //Iniciar la conexion a SQL y conectar
                conexion = new Conexion();
                conexion.conectar();
                estado.setText("Inicio de la conexion a MySQL");
                sesion.setMySQL(conexion);
                barra.setValue(30);
                Thread.sleep(150);
                //Iniciar la conexion con arduino
                arduino = new ComunicacionArduino();
                estado.setText("Conexion con puertos COM");
                sesion.setArduino(arduino);
                barra.setValue(49);
                Thread.sleep(150);
                for (int i = 50; i < 100; i++) {
                    //Cargando, aqui se puede agegar el estado de los elementos que se estan cargando antes de el menu pricipal
                    barra.setValue(i);
                    Thread.sleep(15);
                }
                estado.setText("Se subio la session");
                new Login(sesion).setVisible(true);
                estado.setText("Terminado");
                splash.setVisible(false);
                splash.dispose();
            } catch (InterruptedException ex) {
                System.err.println("Error " + this.toString() + ", " + ex);
            }
        }

    }

    public Splash() {
        initComponents();
        new BarraDeEstado(this).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenLogo = new javax.swing.JLabel();
        barra = new javax.swing.JProgressBar();
        estado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        imagenLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/imagenes/logo.png"))); // NOI18N

        estado.setText("Cargando...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagenLogo)
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(538, 538, 538)
                .addComponent(estado))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imagenLogo)
                .addGap(33, 33, 33)
                .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(estado)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel imagenLogo;
    // End of variables declaration//GEN-END:variables
}
