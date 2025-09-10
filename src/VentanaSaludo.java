import java.awt.event.*;
import javax.swing.*;

public class VentanaSaludo {
    public static void main(String[] args){
        //Creacion de la ventana principal
        JFrame ventana = new JFrame("App de Saludo ICC490");
        ventana.setSize(420,220);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        //Creacion de botones y etiqueta
        JTextField campoTexto = new JTextField();
        campoTexto.setBounds(20, 30, 260, 25);

        JButton botonSaludar = new JButton("Saludar");
        botonSaludar.setBounds(295, 30, 90, 25);

        JButton botonLimpiar = new JButton("Limpiar");
        botonLimpiar.setBounds(295, 65, 90, 25);
        
        JLabel etiquetaSaludo = new JLabel("");
        etiquetaSaludo.setBounds(20, 110, 360, 25);

        //Acción al presionar el boton Saludar
        botonSaludar.addActionListener(e -> {
            String nombre = campoTexto.getText();
            if (nombre == null || nombre.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Por favor ingresa tu nombre.");
                campoTexto.requestFocus();
            } else {
                Usuario user = new Usuario(nombre);
                etiquetaSaludo.setText(user.Saludo());

            }
        });
        //Acción al presionar el boton Limpiar
        botonLimpiar.addActionListener(e -> {
            campoTexto.setText("");
            etiquetaSaludo.setText("");
            campoTexto.requestFocus();

        });
        //Permite utilizar el Enter
        campoTexto.addKeyListener(new KeyAdapter () {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    botonSaludar.doClick();
                }
            }
        });

        //Agrega los botones y etiqueta a la ventana principal
        ventana.add(campoTexto);
        ventana.add(botonSaludar);
        ventana.add(botonLimpiar);
        ventana.add(etiquetaSaludo);

        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}