package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton back,deposit;
    String pin_number;
    public Deposit(String pin_number){
        this.pin_number=pin_number;
        setSize(860,580);
        setVisible(true);
        setLocation(350, 10);
        setLayout(null);
        ImageIcon iconn = new ImageIcon(ClassLoader.getSystemResource("bankmanagementsystem/atm.jpg"));
        Image iconn2 = iconn.getImage().getScaledInstance(900,880,Image.SCALE_DEFAULT);
        ImageIcon iconn3= new ImageIcon(iconn2);
        JLabel k = new JLabel(iconn3);
        k.setBounds(0,0,860,780);
        add(k);

        JLabel title = new JLabel("Enter the Amount You want to Deposit");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("System", Font.BOLD, 16));
        title.setBounds(175,250,700,35);
        k.add(title);

         amount = new JTextField();
        amount.setForeground(Color.BLACK);
        amount.setFont(new Font("System", Font.BOLD, 16));
        amount.setBounds(165,330,300,25);
        k.add(amount);

       deposit = new JButton("Deposit");
        deposit.setForeground(Color.BLACK);
        deposit.setBackground(Color.WHITE);
        deposit.setFont(new Font("System", Font.BOLD, 14));
        deposit.setBounds(339,430,160,30);
        deposit.addActionListener(this);
        k.add(deposit);

        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setFont(new Font("System", Font.BOLD, 14));
        back.setBounds(339,465,160,30);
        back.addActionListener(this);
        k.add(back);

    }
    public void actionPerformed(ActionEvent ae) {

        try{
            if(ae.getSource()==back){setVisible(false);
            new Transactions(pin_number).setVisible(true);
            }
            else if(ae.getSource()==deposit){
                String number = amount.getText();
                long number2 = Integer.parseInt(number);
                if(number.equals("")){JOptionPane.showMessageDialog(null,"Enter the Amount");}
                Date date = new Date();
                Conn c1 = new Conn();
                String query = "insert into bank values('"+pin_number+"','"+date+"','Deposit','"+number2+"')";
                c1.s.executeUpdate(query);

               JOptionPane.showMessageDialog(null, "Rs. "+number2+" Deposited Successfully");

                setVisible(false);
                new Transactions(pin_number).setVisible(true);
            }

        } catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}
