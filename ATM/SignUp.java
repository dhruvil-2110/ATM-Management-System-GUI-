import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter;   
import java.io.IOException;
import java.io.BufferedWriter;

public class SignUp extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
	JButton b1;
	JTextField tf;
	JPasswordField pf;
	
	SignUp()
	{
		l1=new JLabel("Sign Up Page");
		l1.setFont(new Font("Osward",Font.BOLD,38));
		
		l2=new JLabel("Card No.:");
		l2.setFont(new Font("Osward",Font.BOLD,28));
		
		l3=new JLabel("New Pin:");
		l3.setFont(new Font("Osward",Font.BOLD,28));
		
		tf=new JTextField(15);
		pf=new JPasswordField(15);
		
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
		
		tf.setFont(new Font("Arial",Font.BOLD,14));
		tf.setBounds(300,235,230,30);
		add(tf);
		
		pf.setFont(new Font("Arial",Font.BOLD,14));
		pf.setBounds(300,310,230,30);
		add(pf);
		
		b1.setFont(new Font("Arial",Font.BOLD,14));
		b1.setBounds(300,450,230,30);
		add(b1);
		
		b1.addActionListener(this);
		setSize(750,710);
		setLocation(400,10);
		setVisible(true);
	}
	
	/*void File() {
		try {
		  FileWriter myWriter = new FileWriter("Database.txt");
		  myWriter.write(0+" "+tf.getText+" "+pf.getText+" "+-1);
		  myWriter.close();
		} catch (IOException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
		}
	  }*/
	  
	public void actionPerformed(ActionEvent ae)
	{
		String a=tf.getText();
		char ca[]=a.toCharArray();
		String b=pf.getText();
		char cb[]=b.toCharArray();
		int check1=0,check2=0;
		
		
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
					try {
					  FileWriter fr = new FileWriter("Database.txt", true);
					  BufferedWriter br = new BufferedWriter(fr);
					  br.write("1111"+" "+a+" "+b+" "+0+"\r\n");

					  br.close();
					  fr.close();
					} catch (IOException e) {
					  System.out.println("An error occurred.");
					  e.printStackTrace();
					}
					new Transaction().setVisible(true);
					setVisible(false);
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Please enter Proper card No.");
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



