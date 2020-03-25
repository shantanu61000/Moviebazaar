import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Admin_login implements ActionListener {
	
JFrame frame_admin;
JPanel p1,p2,p3,p4;
JLabel n_id,ad_pass,label_logo;
JTextField id_t;
JPasswordField pass_t;
JButton login_b,bac;

Admin_login()
{
	frame_admin = new JFrame();
	p1 = new JPanel();
	p4 = new JPanel();
	//p1.setSize);
	p2 = new JPanel();
	p3 = new JPanel();
	bac = new JButton("Back");
	bac.addActionListener(this);
	label_logo = new JLabel("<html><font size='10' color='RED' face='ROG Fonts'><i><strong>MOVIEBAZAAR</strong></i></font></html>");
	n_id = new JLabel("<html><font size='6'> <strong>ADMIN ID&nbsp&nbsp&nbsp&nbsp&nbsp</strong></font></html>");
	ad_pass = new JLabel("<html><font size='6'> <strong>PASSWORD</strong></font></html>");
	id_t = new JTextField(10);
	pass_t = new JPasswordField(10);
	login_b = new JButton("ADMIN LOGIN");
	login_b.addActionListener(this);
	frame_admin.setLayout(new BorderLayout());
	p1.setLayout(new FlowLayout (FlowLayout.CENTER));
	p2.setLayout(new FlowLayout(FlowLayout.CENTER));
	p3.setLayout(new FlowLayout (FlowLayout.RIGHT));
	p1.add(label_logo);
	p2.add(n_id);
	p2.add(id_t);
	p2.add(ad_pass);
	p2.add(pass_t);
	p3.add(login_b);
	p4.add(bac);

	p2.add(p3);
	
	frame_admin.add(p1,BorderLayout.NORTH);
	frame_admin.add(p2,BorderLayout.CENTER);
	frame_admin.add(p4,BorderLayout.SOUTH);
	frame_admin.setVisible(true);
	frame_admin.setSize(400, 250);
}
@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==login_b) {
			
			String admin_id=id_t.getText();
			String admin_pass=pass_t.getText();
			
			if(admin_id.equals("") || admin_pass.equals("")) {
					JOptionPane.showMessageDialog(null, "Please input all the fields");
			}
			else {
				System.out.println(admin_id+" "+admin_pass);
				frame_admin.dispose();
				System.out.println(admin_id+admin_pass);
				Connect cn= new Connect();
				cn.login_admin(admin_id, admin_pass);
			}
		}
	else if(e.getSource()==bac) {
				frame_admin.dispose();
				new Start_access(); 
			}
			
			
		}
		
		
	

}
