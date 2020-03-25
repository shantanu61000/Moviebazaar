import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Start_access implements ActionListener{
	JFrame access;
    JPanel p1,p2,p3;
    JLabel label_logo;
    JButton user,admin;
 
    JButton enter;
    Start_access(){
    	access = new JFrame();
    	p1 = new JPanel();
    	p2 = new JPanel();
    	p3 = new JPanel();
    	label_logo = new JLabel("<html><font size='18' color='RED' face='ROG Fonts'><i><strong>MOVIEBAZAAR</strong></i></font></html>");
    	//ua = new ButtonGroup();
    	user = new JButton("USER");
    	user.addActionListener(this);

    	admin = new JButton("ADMIN");
    	admin.addActionListener(this);
   // 	enter = new JButton("LOGIN");
    //	ua.add(user);
    //	ua.add(admin);
    	p1.setLayout(new FlowLayout(FlowLayout.CENTER));
    	p1.add(label_logo);
    	p2.setLayout(new FlowLayout(FlowLayout.CENTER));
    	p2.add(user);
    	
    	p2.add(admin);
    	access.setLayout(new BorderLayout());
    	access.add(p1,BorderLayout.NORTH);
    	access.add(p2,BorderLayout.CENTER);
    	access.setVisible(true);
    	access.setSize(450,200);
    	
    }
	public static void main(String[] args) {
		
    new Start_access();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==admin) {
			access.dispose();
			new Admin_login();
		}
		else if(e.getSource()==user) {
			access.dispose();
			new User();
		}
		
	}

}
