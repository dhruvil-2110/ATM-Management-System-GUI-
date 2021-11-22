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

public class Transaction extends JFrame implements ActionListener {
    JLabel l1;
	JButton b1,b2,b3,b5,b6,b7;
	
	Transaction()
	{
		l1=new JLabel("Please select your transaction");
		l1.setFont(new Font("Osward",Font.BOLD,38));
		
		b1 = new JButton("DEPOSIT");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
	
		b2 = new JButton("CASH WITHDRAWAL");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		
		b3 = new JButton("FAST CASH");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		
		/*b4 = new JButton("MINI STATEMENT");
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);*/
		
		b5 = new JButton("GREEN PIN");
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		
		b6 = new JButton("BALANCE INQUIRY");
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		
		b7 = new JButton("EXIT");
		b7.setBackground(Color.BLACK);
		b7.setForeground(Color.WHITE);
		
		setLayout(null);
		
		l1.setBounds(100,100,700,40);
		add(l1);
		
		b1.setFont(new Font("Arial",Font.BOLD,14));
		b1.setBounds(40,250,300,60);
		add(b1);
		
		b2.setFont(new Font("Arial",Font.BOLD,14));
		b2.setBounds(400,250,300,60);
		add(b2);
		
		b3.setFont(new Font("Arial",Font.BOLD,14));
		b3.setBounds(40,360,300,60);
		add(b3);
		
		b6.setFont(new Font("Arial",Font.BOLD,14));
		b6.setBounds(400,360,300,60);
		add(b6);
		
		b5.setFont(new Font("Arial",Font.BOLD,14));
		b5.setBounds(40,470,300,60);
		add(b5);
		
		b7.setFont(new Font("Arial",Font.BOLD,14));
		b7.setBounds(400,470,300,60);
		add(b7);
		
		/*b7.setFont(new Font("Arial",Font.BOLD,14));
		b7.setBounds(240,600,300,60);
		add(b7);*/
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		//b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		
		setSize(750,710);
		setLocation(400,10);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource()==b1)
		{
			new Deposit().setVisible(true);
			setVisible(false);
		}
		else if (ae.getSource()==b2)
		{
			new CashWithdrawal().setVisible(true);
			setVisible(false);
		}
		else if (ae.getSource()==b3)
		{
			new FastCash().setVisible(true);
			setVisible(false);
		}
		else if (ae.getSource()==b5)
		{
			new PinChange().setVisible(true);
			setVisible(false);
		}
		else if (ae.getSource()==b6)
		{
			try {
					  File myObj = new File("Database.txt");
					  Scanner myReader = new Scanner(myObj);
					  while (myReader.hasNextLine()) {
						String data = myReader.nextLine();
						String st[]=data.split(" ");
						if (st[0].equals("1111"))
						{
							JOptionPane.showMessageDialog(null,"Your Balance is : "+st[3]);
						}
						
					  }
					  myReader.close();
					} catch (FileNotFoundException e) {
					  e.printStackTrace();
					}
		}
		else if (ae.getSource()==b7)
		{	
		
			int value=0;
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
                new Transaction();
            }
        });
    }
}