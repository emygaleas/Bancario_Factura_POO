package sistemaVentas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginForm extends JFrame{
    private JPanel loginPanel;
    private JButton ingresarButton;
    private JButton limpiarButton;
    private JTextField usuarioField;
    private JPasswordField contraseniaField;
    private JPanel panelL;

    private ArrayList<Usuario> listaUsuarios= new ArrayList<>();

    public LoginForm(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,300);
        setTitle("INICIO DE SESIÓN");
        setLocationRelativeTo(null);
        panelL.setPreferredSize(new Dimension(350, 275));
        setContentPane(loginPanel);
        setVisible(true);

        //datos
        listaUsuarios.add(new Usuario("cliente123","clave456"));
        listaUsuarios.add(new Usuario("emily","emily"));
        listaUsuarios.add(new Usuario("1","1"));


        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String contrasenia = String.valueOf(contraseniaField.getPassword());

                if (usuario.trim().isEmpty() || contrasenia.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Por favor, llene los campos.");
                    return;
                }

                boolean acceso = false;
                for (Usuario u : listaUsuarios) {
                    if (usuario.equals(u.getUsuario()) && u.getContrasenia().equals(contrasenia)){
                        acceso = true;
                        break;
                    }
                }

                if(!acceso) {
                  JOptionPane.showMessageDialog(null,"Credenciales incorrectas.");
                }else{
                    JOptionPane.showMessageDialog(null,"ACCESO CONCEDIDO");
                    new MenuForm(usuario);
                    dispose();
                }
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuarioField.setText("");
                contraseniaField.setText("");
            }
        });
    }
}
