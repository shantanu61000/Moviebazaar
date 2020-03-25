import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class User implements ActionListener{
	JFrame f1;
	JPanel	p;
	JLabel blank1_l,login_l,pass_l,userlogin_l,name,blank2;
	JTextField login_t;
	JPasswordField pass_t;
	JButton sub_button,reg_button,bac;
	String getName() {
		
		String name;
		name=login_l.getText();
		return name;
		
	}
	User(){
		bac = new JButton("<html><font color=WHITE>BACK</font></html>");
		bac.addActionListener(this);
		f1 = new JFrame();
		p =  new JPanel();
		blank1_l = new JLabel(" ");
		blank2 = new JLabel("");
		//userlogin_l = new JLabel("<html><font size='4'>USER LOGIN</font></html>");
		name = new JLabel("<html><i><strong><font size='8' color='RED' face='ROG Fonts'>MOVIEBAZAAR</font><font size='4'>USER LOGIN</font></strong></i></html>");
		login_l = new JLabel("<html><font size='5'> <strong>LOGIN ID</strong></font></html>");
		pass_l = new JLabel("<html><font size='5'><strong> PASSWORD</strong></font></html>");
		login_t = new JTextField(10);
		pass_t = new JPasswordField(10);
		sub_button = new JButton("<html><font color=WHITE>LOGIN</font></html>");
		sub_button.addActionListener(this);
		
		reg_button = new JButton("<html><font color=WHITE>REGISTER</font></html>");
		reg_button.addActionListener(this);
		
	//userlogin_l.setSize(200,100);
		p.setLayout(new FlowLayout(FlowLayout.CENTER));
		p.add(name);
		p.add(blank2);
	//	p.add();
		p.add(blank1_l);
		
		p.add(login_l);
		
		p.add(login_t);
		
		p.add(pass_l);
		
		p.add(pass_t);
		
	
		p.add(sub_button);
		p.add(reg_button);
		p.add(bac);
		sub_button.setBackground(Color.DARK_GRAY);
		reg_button.setBackground(Color.DARK_GRAY);
		bac.setBackground(Color.DARK_GRAY);
		f1.add(p);
		f1.setVisible(true);
		f1.setSize(500,200);		
	}



	

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		if (e.getSource()==sub_button) {
			
			String login_id,pass;		
			login_id=login_t.getText();
			pass=pass_t.getText();
			f1.dispose();
			Connect c = new Connect();
			c.login(login_id,pass,false);
			//f1.dispose();
			
		}
		else if(e.getSource()==bac) {
			f1.dispose();
			new Start_access();
		}
	

		else if(e.getSource()==reg_button) {
			new register();
			}
	
		
		}

}
