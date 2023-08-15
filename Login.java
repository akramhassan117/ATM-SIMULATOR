package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton Login,Clear,Sign;
    JTextField text2field;
    JPasswordField text3field;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setSize(800,500);
        JLabel ok = new JLabel();

        setVisible(true);

        setLocation(350,200);
        setLayout(null);
      ImageIcon iconn = new ImageIcon(ClassLoader.getSystemResource("bankmanagementsystem/logo.jpg"));
      Image iconn2 = iconn.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
      ImageIcon iconn3= new ImageIcon(iconn2);
       JLabel k = new JLabel(iconn3);
       k.setBounds(70,10,100,100);

       add(k);
       // WELCOME
       JLabel text = new JLabel("Welcome to ATM");
       text.setBounds(200,40,400,40);
       text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);
// CARD NUMBER
        JLabel text2 = new JLabel("CARD NO: ");
        text2.setBounds(120,150,150,40);
        text2.setFont(new Font("Osward",Font.BOLD,28));
        add(text2);
// CARD NUMBER TEXTFIELD
        text2field= new JTextField();
        text2field.setBounds(300,160,250,30 );
        add(text2field);
// PIN
        JLabel text3 = new JLabel("PIN: ");
        text3.setBounds(200,220,400,40);
        text3.setFont(new Font("Osward",Font.BOLD,28));
        add (text3);
// PIN TEXTFIELD
         text3field= new JPasswordField();
        text3field.setBounds(300,230,250,30 );
        add(text3field);
// BUTTONS
// SIGN IN
        Login = new JButton("SIGN IN");
        Login.setBounds(300,300,100,20);
        Login.addActionListener(this);
        add(Login);
// CLEAR BUTTON
         Clear = new JButton("CLEAR");
        Clear.setBounds(450,300,100,20);
        Clear.addActionListener(this);
        add(Clear);
// SIGN UP BUTTON
         Sign = new JButton("SIGN UP");
        Sign.setBounds(300,350,250,20);
        Sign.addActionListener(this);
        add(Sign);

        getContentPane().setBackground(Color.WHITE);
    }
    public  void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource()==Login){
                Conn c1 = new Conn();
                String cardno  = text2field.getText();
                String pin  = text3field.getText();
                String q  = "select * from Login where card_number = '"+cardno+"' and pin_number = '"+pin+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource()==Clear){
                text2field.setText("");
                text3field.setText("");
            }else if(ae.getSource()==Sign){
                setVisible(false);
                new Signnup().setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
