package simuladorBanco;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame{
    private JTextField usuariotxt;
    private JPasswordField contraseniatxt;
    private JButton ingresarButton;
    private JPanel loginPanel;

    //metodo constructor
    public LoginForm(){
        setTitle("Inicio de Sesión"); //titulo de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //cierra el programa al cerrar la ventana
        setSize(300, 200); //dimensiones de la ventana
        setContentPane(loginPanel); //panel principal
        setLocationRelativeTo(null); // posiciona la ventana en el centro de la pantalla
        setVisible(true); //ventana visible

        //accion del boton "Ingresar" al presionarlo
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuariotxt.getText(); // se obtiene el usuario ingresado
                String contrasenia = String.valueOf(contraseniatxt.getPassword()); // se obtiene la contraseña ingresada

                //usuario y contraseña por default
                String usuarioCliente = "cliente123";
                String passwordCliente = "clave456";

                // validacion de campos vacios y con espacios
                if (usuario.trim().isEmpty() || contrasenia.trim().isEmpty()){
                    JOptionPane.showMessageDialog(loginPanel,"LLene los campos."); //ventana con mensaje
                    return;
                }

                if (usuario.equals(usuarioCliente) && contrasenia.equals(passwordCliente)){ // verificacion del usuario y contraseña
                    JOptionPane.showMessageDialog(null, "Acceso concedido"); //ventana con mensaje
                    new BancoForm(usuario); //se abre la ventana BancoForm
                    dispose(); // se cierra la ventana del inicio de sesion para evitar tener múltiples ventanas.
                }
                else {
                    JOptionPane.showMessageDialog(null, "Acceso denegado"); //ventana con mensaje
                }
            }
        });
    }

}
