/*
Un pequeño login para logearse dentro de este sistema
para poder controlar a los usarios esto se puede remplazar por
una conexion a base de datos con el manejador de datos deseado
 */
package com.app.vista.ig;

import com.app.controlador.sesion.Sesion;
import com.app.controlador.usuario.BuscarUsuario;
import com.app.modelo.entidades.Usuario;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends javax.swing.JFrame {

    private Sesion sesion;
    private Usuario usuario;
    
    public Login(Sesion sesion) {
        initComponents();
        this.sesion = sesion;
        setIconImage(new ImageIcon("src/com/app/imagenes/icon.png").getImage());
    }

    public JPasswordField getTextoContrasenia() {
        return textoContrasenia;
    }

    public void setTextoContrasenia(JPasswordField textoContrasenia) {
        this.textoContrasenia = textoContrasenia;
    }

    public JTextField getTextoUsuario() {
        return textoUsuario;
    }

    public void setTextoUsuario(JTextField textoUsuario) {
        this.textoUsuario = textoUsuario;
    }
    

    /*
    Codigop por defecto usando IDE Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaUsuario = new javax.swing.JLabel();
        textoUsuario = new javax.swing.JTextField();
        etiquetaContra = new javax.swing.JLabel();
        botonEntrar = new javax.swing.JButton();
        textoContrasenia = new javax.swing.JPasswordField();
        botonBorrar = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login de Usuario");
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                enter(evt);
            }
        });

        etiquetaUsuario.setText("Usuario");

        etiquetaContra.setText("Contrasenia");

        botonEntrar.setText("Entrar");
        botonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEntrarActionPerformed(evt);
            }
        });

        textoContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                enter(evt);
            }
        });

        botonBorrar.setText("Borrar");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titulo.setText("Inserte el usuario y contrasenia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(etiquetaContra)
                                .addComponent(etiquetaUsuario))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textoUsuario)
                                .addComponent(textoContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonBorrar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(botonEntrar)))
                    .addComponent(titulo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaUsuario)
                    .addComponent(textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaContra)
                    .addComponent(textoContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEntrar)
                    .addComponent(botonBorrar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEntrarActionPerformed
        //Aqui se puede revisar si el usuario realmente es valido por medio de una lectura de base de datos o de archivos
        buscar();
    }//GEN-LAST:event_botonEntrarActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        // TODO add your handling code here:
        textoContrasenia.setText("");
        textoUsuario.setText("");
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void enter(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enter
        // Se detecta un enter en el jlabel de password
        if(evt.getKeyCode() == 10){
            buscar();
        }
    }//GEN-LAST:event_enter

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonEntrar;
    private javax.swing.JLabel etiquetaContra;
    private javax.swing.JLabel etiquetaUsuario;
    private javax.swing.JPasswordField textoContrasenia;
    private javax.swing.JTextField textoUsuario;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

    private void buscar() {
        String nick = textoUsuario.getText();
        String contrasenia = textoContrasenia.getText();
        usuario = new Usuario(nick, contrasenia);
        sesion.setUsuario(usuario);
        //Aqui se puede traer un objeto usuario para validar el login
        new BuscarUsuario().get(sesion, this);
    }

}
