package sistemaVentas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacturarForm extends JFrame {
    private JTextField codigoField;
    private JTextField nombreField;
    private JButton calcularButton;
    private JButton volverButton;
    private JButton buscarButton;
    private JPanel facturaPanel;
    private JTextField cantidadField;
    private JTextField precioField;
    private JLabel txtSubtotal;
    private JLabel txtTotal;
    private JTextField ivaField;

    public FacturarForm(String usuario){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,350);
        setTitle("FACTURA");
        setLocationRelativeTo(null);
        setContentPane(facturaPanel);
        setVisible(true);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoField.getText();

                if (codigo.trim().isEmpty()){
                    JOptionPane.showMessageDialog(facturaPanel,"Ingrese el código de un producto para buscar.");
                    cantidadField.setText("");
                    return;
                }else if (codigo.equals(MenuForm.nuevoProducto.getCodigo())){
                    nombreField.setText(MenuForm.nuevoProducto.getNombre());
                    precioField.setText(String.format("%.2f",MenuForm.nuevoProducto.getPrecioU()));
                    ivaField.setText("15%");
                }
            }
        });


        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (codigoField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Ingrese un producto.");
                    return;
                } else if (cantidadField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(facturaPanel,"Ingrese la cantidad a adquirir.");
                    return;
                }

                try {
                    int cantidadP = Integer.parseInt(cantidadField.getText());

                    if (cantidadP > MenuForm.nuevoProducto.getStock()) {
                        JOptionPane.showMessageDialog(facturaPanel,"Stock insuficiente.");
                        return;
                    }else if (cantidadP<0){
                        JOptionPane.showMessageDialog(facturaPanel,"Ingrese una cantidad válida.");
                    }

                    double iva = 0.15;
                    double subtotal = cantidadP * (MenuForm.nuevoProducto.getPrecioU());
                    double total = subtotal + (subtotal*iva);

                    txtSubtotal.setText(String.format("%.2f",subtotal));
                    txtTotal.setText(String.format("%.2f",total));
                    MenuForm.nuevoProducto.actualizarStock(cantidadP);

                    JOptionPane.showMessageDialog(facturaPanel,"Producto comprado correctamente.");

                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(facturaPanel,"Ingresa una cantidad válida.");
                }
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
