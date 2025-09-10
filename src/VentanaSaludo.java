import java.awt.event.*;
import javax.swing.*;

public class VentanaSaludo {
    public static void main(String[] args){
        JFrame ventana = new JFrame("App de Saludo ICC490");
        ventana.setSize(420,220);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        JTextField campoTexto = new JTextField();
        campoTexto.setBounds(20, 30, 260, 25);

        JButton botonSaludar = new JButton("Saludar");
        botonSaludar.setBounds(295, 30, 90, 25);

        JButton botonLimpiar = new JButton("Limpiar");
        botonLimpiar.setBounds(295, 65, 90, 25);
        
        JLabel etiquetaSaludo = new JLabel("");
        etiquetaSaludo.setBounds(20, 110, 360, 25);

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
        botonLimpiar.addActionListener(e -> {
            campoTexto.setText("");
            etiquetaSaludo.setText("");
            campoTexto.requestFocus();

        });
        campoTexto.addKeyListener(new KeyAdapter () {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    botonSaludar.doClick();
                }
            }
        });

        ventana.add(campoTexto);
        ventana.add(botonSaludar);
        ventana.add(botonLimpiar);
        ventana.add(etiquetaSaludo);

        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}