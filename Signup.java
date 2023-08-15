package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Signup extends  JFrame implements  ActionListener {
    JRadioButton radioButton5,radioButton6,radioButton7,radioButton8;
    JComboBox religiontextfield,Categorytextfield,Incometextfield,Educationtextfield,Occupationtextfield;
    JTextField CNICtextfield;
    ButtonGroup gendergroup3,gendergroup4;
    String formno;  JButton Next;
    public Signup(String formno){
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2");
        setSize(800,600);
        setVisible(true);setLocation(350,200);
        setLayout(null);
// DETAIL title
        JLabel Deatils = new JLabel("Page 2: Addiotional Details");
        Deatils.setBounds(200,30,1000,40);
        Deatils.setFont(new Font("Osward",Font.BOLD,30));
        add(Deatils);
// RELIGION
        JLabel religion = new JLabel("Religion:");
        religion.setBounds(50,80,400,40);
        religion.setFont(new Font ("Osward",Font.BOLD,20));
        add(religion);
// RELIGION TEXTFIELD
        String Religion []= {"Null","Hindu","Muslim","Christian","Other"};
        religiontextfield = new JComboBox(Religion);
        religiontextfield.setBounds(190,85,220,30 );
        add(religiontextfield);

// Category
        JLabel Category = new JLabel("Category:");
       Category.setBounds(50,120,400,40);
        Category.setFont(new Font ("Osward",Font.BOLD,20));
        add(Category);
// Category TEXTFIELD
        String category[]={"Null","General","OBC","SC","ST"};
        Categorytextfield = new JComboBox(category);
        Categorytextfield.setBounds(190,125,220,30 );
        add(Categorytextfield);

// Income
        JLabel Income = new JLabel("Income:");
        Income.setBounds(50,160,400,40);
        Income.setFont(new Font ("Osward",Font.BOLD,20));
        add(Income);
//Income TEXTFIELD
        String income[]= {"Null","<1,50,000","<2,50,000","<5,00,000","Other"};
         Incometextfield = new  JComboBox(income);
        Incometextfield.setBounds(190,165,220,30 );
        add(Incometextfield);
// Edu.Q
        JLabel Education = new JLabel("Education:");
        Education.setBounds(50,220,400,40);
        Education.setFont(new Font ("Osward",Font.BOLD,20));
        add(Education);
//Edu.Q TEXTFIELD
        String edu[]= {"Null","High School","Bachelors","Masters","P.H.D"};
         Educationtextfield = new JComboBox<>(edu);
        Educationtextfield.setBounds(190,225,220,30 );
        add(Educationtextfield);

// Occupation
        JLabel Occupation = new JLabel("Occupation:");
        Occupation.setBounds(50,260,400,40);
        Occupation.setFont(new Font ("Osward",Font.BOLD,20));
        add(Occupation);
//Occupation
        String occ[]= {"Null","Student","Self-Employed","Salaried","Business"};
        Occupationtextfield = new JComboBox<>(occ);
        Occupationtextfield.setBounds(190,265,220,30 );
        add(Occupationtextfield);
// CNIC
        JLabel CNIC  = new JLabel("CNIC NO:");
        CNIC .setBounds(50,300,400,40);
        CNIC .setFont(new Font ("Osward",Font.BOLD,20));
        add(CNIC );
//CNIC TEXTFIELD
         CNICtextfield = new JTextField();
        CNICtextfield.setBounds(190,305,220,30 );
        add(CNICtextfield);

// Senior
        JLabel senior  = new JLabel("Senior");
        JLabel citizen  = new JLabel("Citizen:");
        senior .setBounds(50,335,400,40);
        senior .setFont(new Font ("Osward",Font.BOLD,20));
        citizen .setBounds(50,355,400,40);
       citizen .setFont(new Font ("Osward",Font.BOLD,20));
        add(senior); add(citizen);

       radioButton5 = new JRadioButton("Yes");
        radioButton5.setBounds(190,360,150,30);
        radioButton5.setBackground(Color.WHITE);
        add(radioButton5);

          radioButton6 = new JRadioButton("No");
        radioButton6.setBounds(350,360,150,30);
        radioButton6.setBackground(Color.WHITE);
        add(radioButton6);

        gendergroup3 = new ButtonGroup();
        gendergroup3.add(radioButton5); gendergroup3.add(radioButton6);
        // Account
        JLabel account  = new JLabel("Existing");
        account .setBounds(50,390,400,40);
        account .setFont(new Font ("Osward",Font.BOLD,20));
        add(account );
        JLabel exisitng  = new JLabel("Account:");
        exisitng .setBounds(50,410,400,40);
         exisitng .setFont(new Font ("Osward",Font.BOLD,20));
        add( exisitng );
          radioButton7 = new JRadioButton("Yes");
        radioButton7.setBounds(190,415,150,30);
        radioButton7.setBackground(Color.WHITE);
        add(radioButton7);

          radioButton8 = new JRadioButton("No");
        radioButton8.setBounds(350,415,150,30);
        radioButton8.setBackground(Color.WHITE);
        add(radioButton8);

         gendergroup4 = new ButtonGroup();
        gendergroup4.add(radioButton7); gendergroup4.add(radioButton8);

        Next = new JButton("Next");
        Next.setBounds(500,450,100,20);
        Next.addActionListener(this);
        add(Next);

        getContentPane().setBackground(Color.WHITE);

    }

   public void actionPerformed(ActionEvent ae){
       /// String formno = "" + random;
        String religion = (String) religiontextfield.getSelectedItem();
        String category =  (String)Categorytextfield.getSelectedItem();
        String income =  (String)Incometextfield.getSelectedItem();
    String education =  (String)Educationtextfield.getSelectedItem();
    String occupation =  (String)Occupationtextfield.getSelectedItem();
         String cnic = CNICtextfield.getText();



        String citizen = null;
       if (radioButton5.isSelected()) {citizen= "Yes";}
       if (radioButton6.isSelected()) {citizen= "No";}

       String account = null;
       if(radioButton7.isSelected()){account = "Yes";}
       if(radioButton8.isSelected()){account = "No";}


       try {
           if(religion.equals("") || category.equals("") || income.equals("") || education.equals("") || occupation.equals("") || cnic.equals("") || citizen.equals("") || account.equals("")){
               JOptionPane.showMessageDialog(null,"Fill All fields");
           }else {
               Conn c1 = new Conn();
               String q2 = "insert into signup2 values('" + formno + "','" + religion + "','" + category + "','" + income + "','" + education + "','" +occupation + "','" + cnic + "','" + citizen + "','" + account +  "')";
               c1.s.executeUpdate(q2);

               if (ae.getSource()==Next){
                   setVisible(false);
                   new Signup3(formno).setVisible(true);
               }


           }
       } catch (Exception e) {
           System.out.println(e);}}


       public static void main(String[] args) {
           new Signup("");
       }









}
