package logica;

import interfaces.DAOGimnasioImplementacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cliente extends JFrame {
    private JPanel panel1;
    private JPanel main;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JButton buscarButton;
    private JButton registrarButton;
    private JTextPane textPane1;

    private void limpiar() {

        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");

    }

    public Cliente() {

        this.setContentPane(this.main);
        this.setTitle("Registros  a BD");
        this.setDefaultCloseOperation(3);
        this.setSize(500, 300);
        this.setLocationRelativeTo((Component) null);
        this.setVisible(true);


        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (textField1.getText().equals("") || textField2.getText().equals("") || textField3.getText().equals("") || textField4.getText().equals("")) {

                    JOptionPane.showMessageDialog(null, "Porfavor ingrese todos los datos");
                } else {
                    Gimnasio persona = new Gimnasio();
                    DAOGimnasioImplementacion cliente = new DAOGimnasioImplementacion();

                    persona.setNombre(textField1.getText());
                    persona.setDni(textField2.getText());
                    persona.setDireccion(textField3.getText());
                    persona.setCelular(textField4.getText());

                    cliente.registar(persona);

                    JOptionPane.showMessageDialog(null, "Su registro fue exitoso");
                    limpiar();
                }


            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (textField1.getText().equals("") || textField2.getText().equals("") || textField3.getText().equals("") || textField4.getText().equals("")) {

                    JOptionPane.showMessageDialog(null, "Porfabor ingrese todos los datos para poder modificar");
                } else {
                    Gimnasio persona = new Gimnasio();
                    DAOGimnasioImplementacion cliente = new DAOGimnasioImplementacion();

                    persona.setNombre(textField1.getText());
                    persona.setDni(textField2.getText());
                    persona.setDireccion(textField3.getText());
                    persona.setCelular(textField4.getText());

                    cliente.modificar(persona);

                    limpiar();

                    JOptionPane.showMessageDialog(null, "Modificacion exitosa");
                }


            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Porfavor ingrese el dni");
                } else {
                    Gimnasio persona = new Gimnasio();
                    DAOGimnasioImplementacion cliente = new DAOGimnasioImplementacion();

                    persona.setDni(textField2.getText());

                    cliente.eliminar(persona);

                    JOptionPane.showMessageDialog(null, "se elimino con exito");
                }
            }
        });
        buscarButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                Gimnasio persona = new Gimnasio();
                DAOGimnasioImplementacion consulta = new DAOGimnasioImplementacion();
                if (textField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese el dni");
                } else if (textField1.getText().isEmpty() || textField2.getText().isEmpty() || textField3.getText().isEmpty() || textField4.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay dato");
                } else if (persona.getNombre() == null && persona.getDni() == null &&
                        persona.getDireccion() == null && persona.getCelular() == null) {
                    JOptionPane.showMessageDialog(null, "No hay datos registrados");
                } else {


                    persona.setDni(textField2.getText());
                    consulta.buscar(persona);

                    textPane1.setText("Nombre: " + persona.getNombre() + "\n");
                    textPane1.setText(textPane1.getText() + "DNI: " + persona.getDni() + "\n");
                    textPane1.setText(textPane1.getText() + "Dirección: " + persona.getDireccion() + "\n");
                    textPane1.setText(textPane1.getText() + "Celular: " + persona.getCelular() + "\n");

                    limpiar();

                }


            }
        });
    }

    public static void main(String[] args) {
        new Cliente();
    }
}
