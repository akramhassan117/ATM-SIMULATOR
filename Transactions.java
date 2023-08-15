package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener {
        JButton deposit,withdraw,fast,mini,pin,enquiry,exit;
        String pinn;
    public Transactions(String pinn){
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

      JLabel transaction = new JLabel("Please Select Your Transaction");
        transaction.setForeground(Color.WHITE);
        transaction.setFont(new Font("System", Font.BOLD, 16));
        transaction.setBounds(205,280,700,35);
        k.add(transaction);

        deposit = new JButton(" Deposit ");
        deposit.setForeground(Color.BLACK);
        deposit.setBackground(Color.WHITE);
        deposit.setFont(new Font("System", Font.BOLD, 14));
        deposit.setBounds(139,360,150,30);
        deposit.addActionListener(this);
        k.add(deposit);


        withdraw = new JButton("Cash Withdrawal");
        withdraw.setForeground(Color.BLACK);
        withdraw.setBackground(Color.WHITE);
        withdraw.setFont(new Font("System", Font.BOLD, 14));
        withdraw.setBounds(339,360,160,30);
        withdraw.addActionListener(this);
        k.add(withdraw);

        fast = new JButton(" Fast Cash ");
        fast.setForeground(Color.BLACK);
        fast.setBackground(Color.WHITE);
        fast.setFont(new Font("System", Font.BOLD, 14));
        fast.setBounds(139,395,150,30);
        fast.addActionListener(this);
        k.add(fast);

        mini = new JButton(" Mini Statment ");
        mini.setForeground(Color.BLACK);
        mini.setBackground(Color.WHITE);
        mini.setFont(new Font("System", Font.BOLD, 14));
        mini.setBounds(339,395,160,30);
        k.add(mini);

        pin = new JButton(" Pin Change");
        pin.setForeground(Color.BLACK);
        pin.setBackground(Color.WHITE);
        pin.setFont(new Font("System", Font.BOLD, 14));
        pin.setBounds(139,430,150,30);
        k.add(pin);

        enquiry = new JButton("Balance Enquiry");
        enquiry.setForeground(Color.BLACK);
        enquiry.setBackground(Color.WHITE);
        enquiry.setFont(new Font("System", Font.BOLD, 14));
        enquiry.setBounds(339,430,160,30);
        k.add(enquiry);

        exit = new JButton("Exit");
        exit.setForeground(Color.BLACK);
        exit.setBackground(Color.WHITE);
        exit.setFont(new Font("System", Font.BOLD, 14));
        exit.setBounds(339,465,160,30);
        exit.addActionListener(this);
        k.add(exit);


    }

    public void actionPerformed(ActionEvent ae){
       try{
        if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinn).setVisible(true);

        }  if(ae.getSource()==withdraw){
               setVisible(false);
               new Withdraw(pinn).setVisible(true);

           } if(ae.getSource()==fast){
               setVisible(false);
               new Fast_Cash(pinn).setVisible(true);

           }

           if(ae.getSource()==exit){
               setVisible(false);
               new Login().setVisible(true);

           }

       } catch(Exception e){
        System.out.println(e);
    }}
    public static void main(String[] args) {
        new Transactions("");
    }
}
