package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.Random;



public class Signup3 extends JFrame implements ActionListener  {
    JRadioButton radioButton12,radioButton9,radioButton10,radioButton11;
    JCheckBox atm,internet,mobile,sms,chequebook,statement,terms;
    JButton submit,cancel;  String formno;
    public Signup3(String formno) {
        this.formno = formno;
        setSize(800, 800);
        setVisible(true);
        setLocation(350, 100);
        setLayout(null);

        JLabel page3 = new JLabel("Page 3: Account Details");
        page3.setBounds(240,60,1000,40);
        page3.setFont(new Font("Osward",Font.BOLD,28));
        add(page3);

        JLabel type = new JLabel("Account Type");
        type.setBounds(60,150,1000,40);
        type.setFont(new Font("Osward",Font.BOLD,20));
        add(type);

        radioButton9 = new JRadioButton("Saving Account");
        radioButton9.setBounds(60,185,150,30);
        radioButton9.setBackground(Color.WHITE);
        add(radioButton9);

        radioButton10 = new JRadioButton("Fixed Deposit Account");
        radioButton10.setBounds(270,185,250,30);
        radioButton10.setBackground(Color.WHITE);
        add(radioButton10);

        radioButton11 = new JRadioButton("Current Account");
        radioButton11.setBounds(60,225,150,30);
        radioButton11.setBackground(Color.WHITE);
        add(radioButton11);

        radioButton12 = new JRadioButton("Reoccurring Deposit Account");
        radioButton12.setBounds(270,225,250,30);
        radioButton12.setBackground(Color.WHITE);
        add(radioButton12);

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton9); group.add(radioButton10);
        group.add(radioButton11); group.add(radioButton12);

        JLabel card = new JLabel("Card Number:");
        card.setBounds(60,270,1000,40);
        card.setFont(new Font("Osward",Font.BOLD,20));
        add(card);

        JLabel cardnum = new JLabel("XXXX-XXXX-XXXX-4184");
        cardnum.setBounds(260,270,1000,40);
        cardnum.setFont(new Font("Osward",Font.BOLD,20));
        add(cardnum);

        JLabel digit = new JLabel("Your 16 Digit Card Number");
        digit.setBounds(63,290,1000,40);
        digit.setFont(new Font("Osward",Font.BOLD,10));
        add(digit);

        JLabel cardpin = new JLabel("PIN:");
        cardpin.setBounds(60,320,1000,40);
        cardpin.setFont(new Font("Osward",Font.BOLD,20));
        add(cardpin);

        JLabel digit2 = new JLabel("Your 4 Digit Password");
        digit2.setBounds(60,340,1000,40);
        digit2.setFont(new Font("Osward",Font.BOLD,10));
        add(digit2);

        JLabel cardpin2 = new JLabel("XXXX");
        cardpin2.setBounds(260,320,1000,40);
        cardpin2.setFont(new Font("Osward",Font.BOLD,20));
        add(cardpin2);

        JLabel Service = new JLabel("Services Required:");
        Service.setBounds(60,380,1000,40);
        Service.setFont(new Font("Osward",Font.BOLD,20));
        add(Service);

        atm = new JCheckBox("ATM CARD");
        atm.setBounds(60,430,150,20);
        atm.setFont(new Font("Osward",Font.BOLD,15));
        atm.setBackground(Color.WHITE);
        add(atm);

        internet = new JCheckBox("Internet Banking");
        internet.setBounds(260,430,200,20);
        internet.setFont(new Font("Osward",Font.BOLD,15));
        internet.setBackground(Color.WHITE);
        add(internet);

        mobile = new JCheckBox("Mobile Banking");
        mobile.setBounds(60,480,150,20);
        mobile.setFont(new Font("Osward",Font.BOLD,15));
        mobile.setBackground(Color.WHITE);
        add(mobile);

        sms = new JCheckBox("Email & SMS Alerts");
        sms.setBounds(260,480,200,20);
        sms.setFont(new Font("Osward",Font.BOLD,15));
        sms.setBackground(Color.WHITE);
        add(sms);

       chequebook = new JCheckBox("Cheque Book");
        chequebook.setBounds(60,530,150,20);
        chequebook.setFont(new Font("Osward",Font.BOLD,15));
        chequebook.setBackground(Color.WHITE);
        add(chequebook);

        statement = new JCheckBox("E-Statement");
        statement.setBounds(260,530,150,20);
        statement.setFont(new Font("Osward",Font.BOLD,15));
        statement.setBackground(Color.WHITE);
        add(statement);

       terms = new JCheckBox("I hereby declare that the above mentioned information is correct");
        terms.setBounds(60,590,430,15);
        terms.setFont(new Font("Osward",Font.BOLD,12));
        terms.setBackground(Color.WHITE);
        add(terms);

        submit= new JButton("Submit");
        submit.setBounds(100,650,100,20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(300,650,100,20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){

            String accounttype = null;
            if (radioButton9.isSelected()) {accounttype = "Savings Account";}
            else if (radioButton10.isSelected()) {accounttype = "Fixed Deposit Account";}
            else if (radioButton11.isSelected()) {accounttype = "Current Account";}
            else if (radioButton12.isSelected()) {accounttype = "Reoccurring Deposit Account";}
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String card_number = " " + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin_number = " " + Math.abs(first3);

            String facility = " ";
            if(atm.isSelected()){facility= facility + "ATM Card";}
           else if(internet.isSelected()){facility= facility + "Internet Banking";}
           else if(mobile.isSelected()){facility= facility + "Mobile Banking";}
           else if(sms.isSelected()){facility= facility + "Email & SMS Alerts";}
            else if(chequebook.isSelected()){facility= facility + "Cheque Book";}
           else if(statement.isSelected()){facility= facility + "E-Statement";}

        try{
            if(ae.getSource()==submit){

                if(accounttype.equals("") || facility.equals("") || terms.equals("")){
                    JOptionPane.showMessageDialog(null,"Fill All fields");
                }else{
                    Conn c1 = new Conn();
                    String q1 = "insert into signup3 values('"+formno+"','"+accounttype+"','"+card_number+"','"+pin_number+"','"+facility+"')";
                    String q2 = "insert into Login values('"+formno+"','"+card_number+"','"+pin_number+"')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + card_number+ "\n Pin:"+ pin_number);
                    setVisible(false);
                    new Deposit(pin_number).setVisible(true);


                }


            }else if(ae.getSource()==cancel){
                System.exit(0);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }


        public static void main(String[] args) {
        new Signup3("");
    }

}