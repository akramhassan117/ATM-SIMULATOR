package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.Date;

public class Fast_Cash extends JFrame implements ActionListener {
    JButton rs1000,withdraw,fast,mini,pin,enquiry, Back;
    String pinn;
    public Fast_Cash(String pinn){
        this.pinn=pinn;
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

        JLabel transaction = new JLabel("Please Select Your Withdrawal Amount");
        transaction.setForeground(Color.WHITE);
        transaction.setFont(new Font("System", Font.BOLD, 16));
        transaction.setBounds(185,280,700,35);
        k.add(transaction);

        rs1000 = new JButton("1000");
        rs1000.setForeground(Color.BLACK);
        rs1000.setBackground(Color.WHITE);
        rs1000.setFont(new Font("System", Font.BOLD, 14));
        rs1000.setBounds(139,360,150,30);
        rs1000.addActionListener(this);
        k.add(rs1000);


        withdraw = new JButton("5000");
        withdraw.setForeground(Color.BLACK);
        withdraw.setBackground(Color.WHITE);
        withdraw.setFont(new Font("System", Font.BOLD, 14));
        withdraw.setBounds(339,360,160,30);
        withdraw.addActionListener(this);
        k.add(withdraw);

        fast = new JButton("2000");
        fast.setForeground(Color.BLACK);
        fast.setBackground(Color.WHITE);
        fast.setFont(new Font("System", Font.BOLD, 14));
        fast.setBounds(139,395,150,30);
        fast.addActionListener(this);
        k.add(fast);

        mini = new JButton("10000");
        mini.setForeground(Color.BLACK);
        mini.setBackground(Color.WHITE);
        mini.setFont(new Font("System", Font.BOLD, 14));
        mini.setBounds(339,395,160,30);
        mini.addActionListener(this);
        k.add(mini);

        pin = new JButton("3000");
        pin.setForeground(Color.BLACK);
        pin.setBackground(Color.WHITE);
        pin.setFont(new Font("System", Font.BOLD, 14));
        pin.setBounds(139,430,150,30);
        pin.addActionListener(this);
        k.add(pin);

        enquiry = new JButton("20000");
        enquiry.setForeground(Color.BLACK);
        enquiry.setBackground(Color.WHITE);
        enquiry.setFont(new Font("System", Font.BOLD, 14));
        enquiry.setBounds(339,430,160,30);
        enquiry.addActionListener(this);
        k.add(enquiry);

        Back = new JButton(" Back ");
        Back.setForeground(Color.BLACK);
        Back.setBackground(Color.WHITE);
        Back.setFont(new Font("System", Font.BOLD, 14));
        Back.setBounds(339,465,160,30);
        Back.addActionListener(this);
        k.add(Back);


    }

    public void actionPerformed(ActionEvent ae){

        try {
            String amount = ((JButton)ae.getSource()).getText(); //k
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin_number = '"+pinn+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            if (ae.getSource() != Back && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == Back) {
                this.setVisible(false);
                new Transactions(pinn).setVisible(true);
            }else{
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pinn+"', '"+date+"', 'Withdrawal', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");

                setVisible(false);
                new Transactions(pinn).setVisible(true);
            }
        }  catch(Exception e){
            System.out.println(e);
        }}

    public static void main(String[] args) {
        new Fast_Cash("");
    }}




