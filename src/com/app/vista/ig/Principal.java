/*
Aqui se edita las condiciones para poder mostrar las graficas de los sensores
como baudios, bytes, bit de paro
 */
package com.app.vista.ig;

import com.app.controlador.sesion.Sesion;
import com.app.controlador.usuario.ComunicarArduino;
import com.app.modelo.entidades.Parametro;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {

    //Aqui en los atributos se puede pasar los parametros del usuario
    private Sesion sesion;
    private Parametro parametros;
    
    public Principal(Sesion sesion) {
        initComponents();
        this.sesion = sesion;
        iniciarParametros();
        setIconImage(new ImageIcon("src/com/app/imagenes/icon.png").getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelParametros = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboBaudios = new javax.swing.JComboBox();
        comboDatos = new javax.swing.JComboBox();
        comboParo = new javax.swing.JComboBox();
        comboParidad = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        numeroSensores = new javax.swing.JComboBox<>();
        botonConectar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        comboPuertos = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuMuestrasAlmacenadas = new javax.swing.JMenuItem();
        menuUsuario = new javax.swing.JMenu();
        menuVerUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parametros iniciales");
        setResizable(false);

        panelParametros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parametros", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        jLabel1.setText("Baudios:");

        jLabel2.setText("Bits de Datos:");

        jLabel3.setText("Paridad");

        jLabel4.setText("Bit de paro: ");

        comboBaudios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "110", "300", "600", "1200", "4800", "9600", "14400", "19200", "38400", "57600", "115200", "128000", "256000" }));
        comboBaudios.setSelectedIndex(5);
        comboBaudios.setToolTipText("");

        comboDatos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "6", "7", "8" }));
        comboDatos.setSelectedIndex(3);

        comboParo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "1.5" }));

        comboParidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ninguna", "impar", "par", "marca", "spacio" }));

        jLabel5.setText("Numero de Sensores");

        numeroSensores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3" }));

        botonConectar.setText("Conectar");
        botonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConectarActionPerformed(evt);
            }
        });

        jLabel6.setText("Puertos");

        javax.swing.GroupLayout panelParametrosLayout = new javax.swing.GroupLayout(panelParametros);
        panelParametros.setLayout(panelParametrosLayout);
        panelParametrosLayout.setHorizontalGroup(
            panelParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelParametrosLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(comboBaudios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelParametrosLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelParametrosLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboParo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelParametrosLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboParidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelParametrosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonConectar)
                .addGap(51, 51, 51))
            .addGroup(panelParametrosLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboPuertos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelParametrosLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(numeroSensores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelParametrosLayout.setVerticalGroup(
            panelParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParametrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBaudios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboParidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboParo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(numeroSensores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboPuertos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(botonConectar)
                .addContainerGap())
        );

        jMenu1.setText("Archivo");

        jMenuItem2.setText("Conectar");
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Reporte");

        menuMuestrasAlmacenadas.setText("Muestras Almacanadas");
        menuMuestrasAlmacenadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMuestrasAlmacenadasActionPerformed(evt);
            }
        });
        jMenu2.add(menuMuestrasAlmacenadas);

        jMenuBar1.add(jMenu2);

        menuUsuario.setText("Usuario");

        menuVerUsuario.setText("ver");
        menuVerUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVerUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(menuVerUsuario);

        jMenuBar1.add(menuUsuario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelParametros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelParametros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConectarActionPerformed
        // TODO add your handling code here:
        establecerParametros();
        ComunicarArduino.hacer(sesion, this);
    }//GEN-LAST:event_botonConectarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            // TODO add your handling code here:
            //Aqui se puede ser una funcion para guardar los cambios que se han realizado
            sesion.getArduino().terminar();
        } catch (Exception ex) {
            System.err.println("Error al cerrar arduino " + ex);
        }
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuMuestrasAlmacenadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMuestrasAlmacenadasActionPerformed
        // TODO add your handling code here:
        new MuestrasAlmacenadas(sesion).setVisible(true);
    }//GEN-LAST:event_menuMuestrasAlmacenadasActionPerformed

    private void menuVerUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVerUsuarioActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, sesion.getUsuario().nombreCompleto());
    }//GEN-LAST:event_menuVerUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConectar;
    private javax.swing.JComboBox comboBaudios;
    private javax.swing.JComboBox comboDatos;
    private javax.swing.JComboBox comboParidad;
    private javax.swing.JComboBox comboParo;
    private javax.swing.JComboBox<String> comboPuertos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem menuMuestrasAlmacenadas;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JMenuItem menuVerUsuario;
    private javax.swing.JComboBox<String> numeroSensores;
    private javax.swing.JPanel panelParametros;
    // End of variables declaration//GEN-END:variables

    private void iniciarParametros() {
        List<String> puertos = sesion.getArduino().puertos();
        for (String puerto : puertos) {
            comboPuertos.addItem(puerto);
        }
    }

    private void establecerParametros() {
        int baudios = Integer.valueOf(String.valueOf(comboBaudios.getSelectedItem()));
        int datos = Integer.valueOf(String.valueOf(comboDatos.getSelectedItem()));
        int paridad = Integer.valueOf(String.valueOf(comboParidad.getSelectedIndex()));
        int paro = Integer.valueOf(String.valueOf(comboParo.getSelectedItem()));
        String puerto = String.valueOf(comboPuertos.getSelectedItem());
        //Se establecen los parametros de la conexion a arduino
        JOptionPane.showMessageDialog(null, "Baudios " + baudios + "datos " + datos + "paridad " + paridad + "paro " + paro + " COM " + puerto);
        parametros = new Parametro(puerto, datos, baudios, paro, paridad);
        sesion.setParametros(parametros);
    }
}
