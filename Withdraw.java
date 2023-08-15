package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    JTextField amount2;
    JButton back,deposit;
    String pin_number;
    public Withdraw(String pin_number){
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

        JLabel title = new JLabel("Enter the Amount You want to Withdraw");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("System", Font.BOLD, 16));
        title.setBounds(175,250,700,35);
        k.add(title);

        amount2 = new JTextField();
        amount2.setForeground(Color.BLACK);
        amount2.setFont(new Font("System", Font.BOLD, 16));
        amount2.setBounds(165,330,300,25);
        k.add(amount2);

        deposit = new JButton("Withdraw");
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
                String amount= amount2.getText();
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from bank where pin_number = '"+pin_number+"'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                if (ae.getSource() == back) {
                    this.setVisible(false);
                    new Transactions(pin_number).setVisible(true);
                }else{
                    Date date = new Date();
                    c.s.executeUpdate("insert into bank values('"+pin_number+"', '"+date+"', 'Withdrawal', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");

                    setVisible(false);
                    new Transactions(pin_number).setVisible(true);
                }
            }

        } catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new Withdraw("");
    }
}
