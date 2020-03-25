import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class register implements ActionListener{
	
JFrame f2;
JPanel p2;
JLabel l1,l2,l3,l4,l5,l6,l7,name,blank;
JTextField t1,t2;
public JPasswordField pass1,pass2;
JButton b1;

register(){
	
	p2 = new JPanel();
	f2 = new JFrame();
	l1 = new JLabel("<html><font size='6'>REGISTER USER</font></html>");
	l2 = new JLabel("");
	l3 = new JLabel("Name");
	l4 = new JLabel("login ID");
	l5 = new JLabel("Password");
	l6 = new JLabel("Confirm Password");
	l7 = new JLabel("");
	name = new JLabel("<html><font size='18' color='RED' face='ROG Fonts'><i><strong>MOVIEBAZAAR</strong></i></font></html>");
	blank = new JLabel("");
	t1 = new JTextField(10);
	t2 = new JTextField(10);
	
	pass1 = new JPasswordField(10);
	pass2 = new JPasswordField(10);
	
	b1 = new JButton("Register");
	b1.addActionListener(this);
	
	p2.setLayout(new GridLayout(7,2));
	p2.add(name);
	p2.add(blank);
	p2.add(l1);
	p2.add(l2);
	p2.add(l3);
	p2.add(t1);
	p2.add(l4);
	p2.add(t2);
	p2.add(l5);
	p2.add(pass1);
	p2.add(l6);
	p2.add(pass2);
	p2.add(l7);
	p2.add(b1);
	
	f2.add(p2);
	f2.setVisible(true);
	f2.pack();
	
}
public void actionPerformed(ActionEvent e) {
	String pass,cnfpass;
	pass=pass1.getText();
	cnfpass=pass2.getText();  
	if(pass.equals(cnfpass)){
			
		if (e.getSource()==b1) {
		String name,login;
		name = t1.getText();
		login= t2.getText();
		
		f2.dispose();
		Connect c = new Connect();
		c.register(login,name,pass);
		}
	}
	else {
		JOptionPane.showMessageDialog(null,"password did not match");
	}
	
}

}
