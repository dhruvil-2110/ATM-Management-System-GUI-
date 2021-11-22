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

public class Deposit extends JFrame implements ActionListener{
    JLabel l1;
	JButton b1,b2,b3;
	JTextField tf;
	
	Deposit()
	{
		l1=new JLabel("Deposit Amount : ");
		l1.setFont(new Font("Osward",Font.BOLD,38));
		
		b1 = new JButton("Enter");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
	
		b2 = new JButton("BACK");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		
		b3 = new JButton("EXIT");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		
		tf=new JTextField(15);
		
		setLayout(null);
		
		l1.setBounds(200,50,450,200);
		add(l1);
		
		tf.setFont(new Font("Arial",Font.BOLD,14));
		tf.setBounds(300,235,230,30);
		add(tf);
		
		b1.setFont(new Font("Arial",Font.BOLD,14));
		b1.setBounds(300,310,100,30);
		add(b1);
		
		b2.setFont(new Font("Arial",Font.BOLD,14));
		b2.setBounds(430,310,100,30);
		add(b2);
		
		b3.setFont(new Font("Arial",Font.BOLD,14));
		b3.setBounds(300,400,230,30);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		setSize(750,710);
		setLocation(400,10);
		setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String a=tf.getText();
		int check=0;
		char ca[]=a.toCharArray();
		if (ae.getSource()==b1)
		{
			if (a.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please enter Amount");
			}
			else if (ca[0]>='0' && ca[0]<='9')
			{
				for(char i:ca)
				{
					if(i>='0' && i<='9')
					check++;	
					else
					{
						JOptionPane.showMessageDialog(null,"Please enter proper Amount");
						break;
					}	
				}
				if (check==ca.length) {
					
					String newcontent="";
					try {
					  File myObj = new File("Database.txt");
					  Scanner myReader = new Scanner(myObj);
					  while (myReader.hasNextLine()) {
						String data = myReader.nextLine();
						String st[]=data.split(" ");
						if (st[0].equals("1111"))
						{
							int amt = Integer.parseInt(st[3])+Integer.parseInt(a);
							String str=Integer.toString(amt);
							newcontent=newcontent+st[0]+" "+st[1]+" "+st[2]+" "+str+"\r\n";
						}
						else
						newcontent=newcontent+data+"\r\n";
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
					
					
					JOptionPane.showMessageDialog(null,a+" Rupees are transfered to your account");
					tf.setText("");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Please enter proper Amount");
			}
		}
		else if (ae.getSource()==b2)
		{
			new Transaction().setVisible(true);
			setVisible(false);
		}
		else if (ae.getSource()==b3)
		{
			String newcontent="";
					 try {
					  File myObj = new File("Database.txt");
					  Scanner myReader = new Scanner(myObj);
					  while (myReader.hasNextLine()) {
						String data = myReader.nextLine();
						String st[]=data.split(" ");
						newcontent=newcontent+"0000"+" "+st[1]+" "+st[2]+" "+st[3]+"\r\n";
					  }
					  myReader.close();
					} catch (FileNotFoundException e) {
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
		
			System.exit(0);
		}
			
	}
	
	public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Deposit();
            }
        });
    }
}