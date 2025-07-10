package sistemaVentas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuForm extends JFrame{
    private JButton registroButton;
    private JButton ventasButton;
    private JButton verProductosButton;
    private JLabel usuarioNombre;
    private JPanel menuPanel;

    //con array list: public static ArrayList<Producto> listaProductos = new ArrayList<>();

    //sin array list:
    public static Producto nuevoProducto = null;

    public MenuForm(String usuario){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,400);
        setTitle("MENÚ DE OPCIONES");
        setLocationRelativeTo(null);
        setContentPane(menuPanel);
        setVisible(true);
        usuarioNombre.setText(usuario);


        registroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrarForm(usuario);
                dispose();
            }
        });
        ventasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FacturarForm(usuario);
                dispose();
            }
        });
        verProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MostrarForm(usuario);
                dispose();
            }
        });
    }
}
