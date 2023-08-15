package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;


public class Signnup extends JFrame implements ActionListener {
    long random;
    JTextField nametextfield,Fathertextfield,mailtextfield,addresstextfield,ciyttextfield,statetextfield,pinntextfield;
    //JPasswordField pinntextfield;
    JDateChooser dateChooser;
    JButton Next;
    JRadioButton radioButton, radioButton2,radioButton3,radioButton4;
    public Signnup(){
        Random ran = new Random();
         random = Math.abs((ran.nextLong()%9000L+1000L));
      //
        setSize(800,800);
        setVisible(true);
         setLocation(350,200);
        setLayout(null);
        JLabel text = new JLabel("APPLICATION FORM NO."+ random);
        text.setBounds(100,20,1000,40);
        text.setFont(new Font("Osward",Font.BOLD,32));
        add(text);

//NAME
        JLabel name = new JLabel("Name:");
        name.setBounds(50,85,400,40);
        name.setFont(new Font ("Osward",Font.BOLD,22));
        add(name);
//name TEXTFIELD
      nametextfield = new JTextField();
        nametextfield.setBounds(230,90,300,30 );
        add(nametextfield);
// Fathers Name
        JLabel Father = new JLabel("Father's Name:");
        Father.setBounds(50,125,400,40);
        Father.setFont(new Font ("Osward",Font.BOLD,22));
        add(Father);
//Fathers name TEXTFIELD
       Fathertextfield = new JTextField();
        Fathertextfield.setBounds(230,130,300,30 );
        add(Fathertextfield);
//DOB
        JLabel DOB = new JLabel("Date of Birth:");
        DOB.setBounds(50,175,400,40);
        DOB.setFont(new Font ("Osward",Font.BOLD,22));
        add(DOB);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(230,175,200,30);
        dateChooser.setForeground(Color.WHITE);
        add(dateChooser);

        // Gender
        JLabel gender = new JLabel("Gender:");
        gender.setBounds(50,225,400,40);
        gender.setFont(new Font ("Osward",Font.BOLD,22));
        add(gender);

       radioButton = new JRadioButton("Male");
        radioButton.setBounds(230,225,150,30);
        radioButton.setBackground(Color.WHITE);
        add(radioButton);
       radioButton2 = new JRadioButton("Female");
        radioButton2.setBounds(380,225,150,30);
        radioButton2.setBackground(Color.WHITE);
        add(radioButton2);

            ButtonGroup gendergroup = new ButtonGroup();
            gendergroup.add(radioButton); gendergroup.add(radioButton2);


//EMAIL
        JLabel mail = new JLabel("Email:");
        mail.setBounds(50,265,400,40);
        mail.setFont(new Font ("Osward",Font.BOLD,22));
        add(mail);
//Email TEXT-FIELD
        mailtextfield = new JTextField();
        mailtextfield.setBounds(230,270,300,30 );
        add(mailtextfield);
//MARITAL
        //EMAIL
        JLabel marital = new JLabel("Marital Status:");
        marital.setBounds(50,305,400,40);
        marital.setFont(new Font ("Osward",Font.BOLD,22));
        add(marital);
         radioButton3 = new JRadioButton("Married");
        radioButton3.setBounds(230,310,150,30);
        radioButton3.setBackground(Color.WHITE);
        add(radioButton3);

         radioButton4 = new JRadioButton("Single");
        radioButton4.setBounds(380,310,150,30);
        radioButton4.setBackground(Color.WHITE);
        add(radioButton4);

        ButtonGroup gendergroup2 = new ButtonGroup();
        gendergroup2.add(radioButton3); gendergroup2.add(radioButton4);

//Address
        JLabel address = new JLabel("Address:");
        address.setBounds(50,345,400,40);
        address.setFont(new Font ("Osward",Font.BOLD,22));
        add(address);
//ADDRESS TEXTFIELD
         addresstextfield = new JTextField();
        addresstextfield.setBounds(230,350,300,30 );
        add(addresstextfield);

//CITY
        JLabel city = new JLabel("City:");
        city.setBounds(50,385,400,40);
        city.setFont(new Font ("Osward",Font.BOLD,22));
        add(city);
// CITY TEXTFIELD
        ciyttextfield = new JTextField();
        ciyttextfield.setBounds(230,390,300,30 );
        add(ciyttextfield);

//STATE
        JLabel state = new JLabel("State:");
        state.setBounds(50,425,400,40);
        state.setFont(new Font ("Osward",Font.BOLD,22));
        add(state);
//STATE TEXTFIELD
        statetextfield = new JTextField();
        statetextfield.setBounds(230,430,300,30 );
        add(statetextfield);
//Pin
        JLabel Pinn = new JLabel("Pin Code:");
        Pinn.setBounds(50,465,400,40);
        Pinn.setFont(new Font ("Osward",Font.BOLD,22));
        add(Pinn);
//Email TEXTFIELD
       pinntextfield = new JTextField();
        pinntextfield.setBounds(230,470,300,30 );
        add(pinntextfield);
// NEXT BUTTON
        Next = new JButton("Next");
        Next.setBounds(550,550,100,20);
        Next.addActionListener(this);
        add(Next);

        getContentPane().setBackground(Color.WHITE);


    }
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nametextfield.getText();
        String fname = Fathertextfield.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if(radioButton.isSelected()){gender = "Male";}
        if(radioButton2.isSelected()){gender = "Female";}
        String email = mailtextfield.getText();

        String marital = null;
        if(radioButton3.isSelected()){marital = "Married";}
        if(radioButton4.isSelected()){marital = "Single";}

        String address = addresstextfield.getText();
        String city = ciyttextfield.getText();
        String state =statetextfield.getText();
        String pin = pinntextfield.getText();

        try {
            if(name.equals("") || fname.equals("") || dob.equals("") ||gender.equals("") || marital.equals("") || address.equals("") ||city.equals("") || state.equals("") || pin.equals("")){
                JOptionPane.showMessageDialog(null,"Fill All Fields");
            }else {
                Conn c1 = new Conn();
                String q1 = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pin + "','" + state + "')";
                c1.s.executeUpdate(q1);
                if (ae.getSource()==Next){
                    setVisible(false);
                    new Signup(formno).setVisible(true);
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new Signnup();
    }
}
