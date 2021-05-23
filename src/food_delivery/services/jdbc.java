package food_delivery.services;

import food_delivery.user.Client;
import food_delivery.user.ClientList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class jdbc extends javax.swing.JFrame {
    Connection con;
    private JTextField Address;
    private JButton insertButton;
    private JTextField Name;
    private JTextField PhoneNumber;
    private JTextField ClientID;
    private JTextField Email;
    private JPanel clientPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("jdbc");
        frame.setContentPane(new jdbc().clientPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public jdbc(){
        createUIComponents();

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String clientID = ClientID.getText();
                    String name = Name.getText();
                    String phoneNumber = PhoneNumber.getText();
                    String email = Email.getText();
                    String address = Address.getText();

                    Statement statement = con.createStatement();

                    String dbop = "INSERT INTO jdbc.clients VALUES('" + clientID + "', '"+ name +"', '"+ phoneNumber +"', '"+ email +"', '"+ address +"')";

                    statement.execute(dbop);
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    public void createConnection(ClientList List) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM jdbc.clients");
            while(rs.next()){
                Client aux = new Client();

                String id = rs.getString("id");
                String name = rs.getString("name");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                String address = rs.getString("address");

                aux.setClient_id(id);
                aux.setName(name);
                aux.setPhone(phoneNumber);
                aux.setEmail(email);
                aux.setAddress(address);

                List.addClient(aux);
            }

            statement.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void $$$setupUI$$$() {
        createUIComponents();
    }

    private void createUIComponents() {
        clientPanel = new JPanel();
        insertButton = new JButton("Insert");
        ClientID = new JTextField();
        Name = new JTextField();
        PhoneNumber = new JTextField();
        Email = new JTextField();
        Address = new JTextField();
    }
}
