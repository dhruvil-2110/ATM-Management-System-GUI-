import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter;   
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.*;
import java.io.File;  
import java.io.FileNotFoundException; 
import java.io.FileReader;
import java.io.BufferedReader;

public class Main extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
	JButton b1,b2,b3;
	JTextField tf;
	JPasswordField pf;
	
	Main()
    {
		l1=new JLabel("Welcome to ATM");
		l1.setFont(new Font("Osward",Font.BOLD,38));
		
		l2=new JLabel("Card no.:");
		l2.setFont(new Font("Raleway",Font.BOLD,28));
		
		l3=new JLabel("Pin No.:");
		l3.setFont(new Font("Raleway",Font.BOLD,28));
		
		tf=new JTextField(15);
		pf=new JPasswordField(15);
		
		b1 = new JButton("Sign In");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		
		b2 = new JButton("Clear");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		
		b3 = new JButton("Sign Up");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		
		setLayout(null);
		
		l1.setBounds(175,50,450,200);
		add(l1);
		l2.setBounds(125,150,370,200);
		add(l2);
		l3.setBounds(125,225,450,200);
		add(l3);
		
		tf.setFont(new Font("Arial",Font.BOLD,14));
		tf.setBounds(300,235,230,30);
		add(tf);
		
		pf.setFont(new Font("Arial",Font.BOLD,14));
		pf.setBounds(300,310,230,30);
		add(pf);
		
		b1.setFont(new Font("Arial",Font.BOLD,14));
		b1.setBounds(300,400,100,30);
		add(b1);
		
		b2.setFont(new Font("Arial",Font.BOLD,14));
		b2.setBounds(430,400,100,30);
		add(b2);
		
		b3.setFont(new Font("Arial",Font.BOLD,14));
		b3.setBounds(300,450,230,30);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		//getContentPane().setBackgrond(Color.WHITE);
		setSize(750,710);
		setLocation(400,10);
		setVisible(true);
	}
		
	public void actionPerformed(ActionEvent ae)
	{
		String a=tf.getText();
		char ca[]=a.toCharArray();
		String b=pf.getText();
		char cb[]=b.toCharArray();
		int check1=0,check2=0,value=0;
		if (ae.getSource()==b1)
		{
			if (a.equals("") || b.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please enter card no. or password field");
			}
			else if (ca[0]>='0' && ca[0]<='9')
			{
				for(char i:ca)
				{
					if(i>='0' && i<='9')
					check1++;
					else
					{
						JOptionPane.showMessageDialog(null,"Please enter Proper card No.");
						break;
					}	
				}
				if (check1!=16)	
						JOptionPane.showMessageDialog(null,"Card No. should contains 16 digit");
				for(char i:cb)
				{
					if(i>='0' && i<='9')
					check2++;
					else
					{
						JOptionPane.showMessageDialog(null,"Password should be digit");	
						break;
					}
				}
				if (check2!=4)	
						JOptionPane.showMessageDialog(null,"Password contains 4 digits");
				if (check2==cb.length && check1==ca.length && check1==16 && check2==4) {
					
					 String newcontent="";
					 try {
					  File myObj = new File("Database.txt");
					  Scanner myReader = new Scanner(myObj);
					  while (myReader.hasNextLine()) {
						String data = myReader.nextLine();
						String st[]=data.split(" ");
						if (st[1].equals(a) && st[2].equals(b))
						{
							value=1;
							newcontent=newcontent+"1111"+" "+st[1]+" "+st[2]+" "+st[3]+"\r\n";
						}
						else
							newcontent=newcontent+data+"\r\n";
					  }
					  myReader.close();
					} catch (FileNotFoundException e) {
					  System.out.println("An error occurred.");
					  e.printStackTrace();
					}
					 if (value==1)
					 {
						try {
						  FileWriter fr = new FileWriter("Database.txt", false);
						  fr.write(newcontent);
						  fr.close();
						} catch (IOException e) {
						  System.out.println("An error occurred.");
						  e.printStackTrace();
						} 
					 }
 
		            if (value==1)
					{
						new Transaction().setVisible(true);
						setVisible(false);
					}						
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid Login");
						tf.setText("");
						pf.setText("");
					}
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Please enter Proper card No.");
			}
		}
		else if (ae.getSource()==b2)
		{
			tf.setText("");
			pf.setText("");
		}
		else if (ae.getSource()==b3)
		{
			new SignUp().setVisible(true);
			setVisible(false);
		}
	
	}
		
        
    
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}