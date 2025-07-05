import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostrarForm extends JFrame {
    private JPanel mostrarPanel;
    private JButton regresarButton;
    private JLabel codigoField;
    private JLabel nombreField;
    private JLabel detalleField;
    private JLabel stockActualField;

    public MostrarForm(String usuario){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,350);
        setTitle("Factura");
        setLocationRelativeTo(null);
        setContentPane(mostrarPanel);
        setVisible(true);

        if (MenuForm.nuevoProducto == null){
            JOptionPane.showMessageDialog(mostrarPanel,"No existen registros de productos.");
        }else{
            codigoField.setText(MenuForm.nuevoProducto.getCodigo());
            nombreField.setText(MenuForm.nuevoProducto.getNombre());
            detalleField.setText(MenuForm.nuevoProducto.getDetalle());
            stockActualField.setText(String.valueOf(MenuForm.nuevoProducto.getStock()));
        }

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuForm(usuario);
                dispose();
            }
        });
    }
}
