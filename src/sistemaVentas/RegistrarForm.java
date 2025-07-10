package sistemaVentas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarForm extends JFrame {

    private JPanel registroPanel;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JTextField codigoField;
    private JTextField nombreField;
    private JTextField detalleField;
    private JTextField precioField;
    private JTextField stockField;
    private JButton volverButton;

    public RegistrarForm(String usuario){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,300);
        setTitle("REGISTRAR PRODUCTO");
        setLocationRelativeTo(null);
        setContentPane(registroPanel);
        setVisible(true);


        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoField.getText();
                String nombre = nombreField.getText();
                String detalle = detalleField.getText();
                String precioU = precioField.getText();
                String stock = stockField.getText();

                if (codigo.trim().isEmpty() || nombre.trim().isEmpty() || detalle.trim().isEmpty() || precioU.trim().isEmpty() || stock.trim().isEmpty()){
                    JOptionPane.showMessageDialog(registroPanel,"Por favor, llene todos los campos.");
                    return;
                }

                try {
                    double precioP = Double.parseDouble(precioU);
                    int stockP = Integer.parseInt(stock);

                    if ((precioP>9999.99 || precioP <0) || (stockP>999 || stockP<0)){
                        JOptionPane.showMessageDialog(registroPanel,"Ingrese precio y/o stock válidos.");
                        return;
                    }else{
                        MenuForm.nuevoProducto = new Producto(codigo,nombre,detalle,precioP,stockP);
                        JOptionPane.showMessageDialog(registroPanel,"Producto " + MenuForm.nuevoProducto.getNombre() +" agregado correctamente.");
                    }

                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(registroPanel,"Ingrese números no letras en stock y cantidad.");
                }
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codigoField.setText("");
                nombreField.setText("");
                detalleField.setText("");
                precioField.setText("");
                stockField.setText("");
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuForm(usuario);
                dispose();
            }
        });
    }
}
