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

public class PinChange extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
	JButton b1;
	JPasswordField pf1,pf2;
	
	PinChange()
	{
		l1=new JLabel("PinChange Page");
		l1.setFont(new Font("Osward",Font.BOLD,38));
		
		l2=new JLabel("Original Pin : ");
		l2.setFont(new Font("Osward",Font.BOLD,28));
		
		l3=new JLabel("New Pin :");
		l3.setFont(new Font("Osward",Font.BOLD,28));
		
		pf1=new JPasswordField(15);
		pf2=new JPasswordField(15);
		
		b1 = new JButton("Submit");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		
		setLayout(null);
		
		l1.setBounds(175,50,450,200);
		add(l1);
		l2.setBounds(125,150,370,200);
		add(l2);
		l3.setBounds(125,225,450,200);
		add(l3);
		
		pf1.setFont(new Font("Arial",Font.BOLD,14));
		pf1.setBounds(300,235,230,30);
		add(pf1);
		
		pf2.setFont(new Font("Arial",Font.BOLD,14));
		pf2.setBounds(300,310,230,30);
		add(pf2);
		
		b1.setFont(new Font("Arial",Font.BOLD,14));
		b1.setBounds(300,450,230,30);
		add(b1);
		
		b1.addActionListener(this);
		setSize(750,710);
		setLocation(400,10);
		setVisible(true);
	}
	  
	 public void actionPerformed(ActionEvent ae)
	{
		String a=pf2.getText();
		char ca[]=a.toCharArray();
		int check1=0;		
		
		if (ae.getSource()==b1)
		{
			if (a.equals(""))
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
						JOptionPane.showMessageDialog(null,"Password should be digit");	
						break;
					}
				}
				if (check1!=4)	
						JOptionPane.showMessageDialog(null,"Password contains 4 digits");
				if (check1==ca.length && check1==4)
				{
					String newcontent="";
					try {
					  File myObj = new File("Database.txt");
					  Scanner myReader = new Scanner(myObj);
					  while (myReader.hasNextLine()) {
						String data = myReader.nextLine();
						String st[]=data.split(" ");
						if (st[0].equals("1111"))
						{
							newcontent=newcontent+"0000"+" "+st[1]+" "+a+" "+st[3]+"\r\n";
						}
						else
						newcontent=newcontent+"0000"+" "+st[1]+" "+st[2]+" "+st[3]+"\r\n";
					  }
					  myReader.close();
					} catch (FileNotFoundException e) {
					  System.out.println("An error occurred.");
					  e.printStackTrace();
					}
					try {
						 FileWriter fr = new FileWriter("Database.txt", false);
						 fr.write(newcontent);
					     fr.close();
					} catch (IOException e) {
						 System.out.println("An error occurred.");
						 e.printStackTrace();
					} 
					JOptionPane.showMessageDialog(null,"Your pin is changed successfully");
					System.exit(0);	
				
	
		        }
	        }
	    }
	}
	
		public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SignUp();
            }
        });
    }
}
