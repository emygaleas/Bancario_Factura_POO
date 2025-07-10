package simuladorBanco;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BancoForm extends JFrame{
    private JLabel nombreClienteLabel;
    private JButton depositoButton;
    private JButton retiroButton;
    private JButton transferenciaButton;
    private JButton salirButton;
    private JTextArea historialArea;
    private JLabel saldoLabel;
    private JPanel ventanaPrincipal;

    private double saldo = 1000.00;  // Saldo inicial

    public BancoForm(String usuario) {

        // Configurar el título y la ventana
        setTitle("Banco - Operaciones");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializar los componentes
        nombreClienteLabel.setText(usuario);
        saldoLabel.setText("Saldo Actual: $" + saldo);

        // Acciones para los botones
        depositoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarDeposito();
            }
        });

        retiroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarRetiro();
            }
        });

        transferenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarTransferencia();
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();  // Cerrar la ventana
            }
        });

        // Establecer el contenido de la ventana
        setContentPane(ventanaPrincipal);
        setVisible(true);
    }

    // Metodo para realizar un depósito
    private void realizarDeposito() {
        String input = JOptionPane.showInputDialog(this, "Ingrese el monto a depositar:");
        if (input != null) {
            try {
                double monto = Double.parseDouble(input);
                if (monto > 0) {
                    saldo += monto;
                    saldoLabel.setText("Saldo: $" + saldo);
                    historialArea.append("Depósito: +$" + monto + "\n");
                    JOptionPane.showMessageDialog(this, "Depósito realizado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(this, "El monto debe ser mayor a 0.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
            }
        }
    }

    // Metodo para realizar un retiro
    private void realizarRetiro() {
        String input = JOptionPane.showInputDialog(this, "Ingrese el monto a retirar:");
        if (input != null) {
            try {
                double monto = Double.parseDouble(input);
                if (monto > 0 && monto <= saldo) {
                    saldo -= monto;
                    saldoLabel.setText("Saldo: $" + saldo);
                    historialArea.append("Retiro: -$" + monto + "\n");
                    JOptionPane.showMessageDialog(this, "Retiro exitoso.");
                } else {
                    JOptionPane.showMessageDialog(this, "Fondos insuficientes o monto inválido.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
            }
        }
    }

    // Metodo para realizar una transferencia
    private void realizarTransferencia() {
        JTextField destinatarioField = new JTextField();
        JTextField montoField = new JTextField();
        Object[] mensaje = {
                "Destinatario:", destinatarioField,
                "Monto a transferir:", montoField
        };

        int opcion = JOptionPane.showConfirmDialog(this, mensaje, "Transferencia", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            try {
                String destinatario = destinatarioField.getText();
                double monto = Double.parseDouble(montoField.getText());
                if (monto > 0 && monto <= saldo && !destinatario.trim().isEmpty()) {
                    saldo -= monto;
                    saldoLabel.setText("Saldo: $" + saldo);
                    historialArea.append("Transferencia a " + destinatario + ": -$" + monto + "\n");
                    JOptionPane.showMessageDialog(this, "Transferencia exitosa.");
                } else {
                    JOptionPane.showMessageDialog(this, "Datos inválidos o saldo insuficiente.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Monto inválido.");
            }
        }
    }

}
