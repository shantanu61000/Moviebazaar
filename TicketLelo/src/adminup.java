import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.*;

public class adminup implements ActionListener{
	
	JFrame show_update;
	JPanel p_1,p_2,p_3,p_4,p_5,p_6;
	JLabel label_logo,l1_mname,l2_tname,l3_t1,l4_t2,l5_t3,l6_not1,l7_not2,l8_dat;
	JTextField t1_mname,t2_tname,t3_t1,t4_t2,t5_t3,t6_not1,t7_not2,t8_not3;
	JButton b_update,bac;
	JDateChooser dat;
	adminup(){
		show_update = new JFrame();
		dat = new JDateChooser();
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		bac = new JButton("LOGOUT");
		bac.addActionListener(this);
		p_6 =new JPanel();
		p_1 = new JPanel();
		p_2 = new JPanel();
		p_3 = new JPanel();
		p_4 = new JPanel();
		p_5 = new JPanel();
		label_logo = new JLabel("<html><font size='10' color='RED' face='ROG Fonts'><i><strong>MOVIEBAZAAR</strong></i></font><font size=4><strong>Admin Page</strong></font></html>");
		l1_mname = new JLabel("<html><font size='6'> <strong>MOVIE NAME</strong></font></html>");
		l2_tname = new JLabel("<html><font size='6'> <strong>CINEMA NAME</strong></font></html>");
		l3_t1 = new JLabel("<html><font size='4'> <strong>TIME SLOT 1</strong></font></html>");
		l6_not1 = new JLabel("<html><font size='4'> <strong>NUMBER OF TICKETS</strong></font></html>");
		t1_mname = new JTextField(20);
		l8_dat = new JLabel("ENTER DATE            ");
		t2_tname = new JTextField(20);
		t3_t1 = new JTextField(20);
		t4_t2 = new JTextField(20);
		t5_t3 = new JTextField(20);
		t6_not1 = new JTextField(20);
		t7_not2 = new JTextField(20);
		t8_not3 = new JTextField(20);
		b_update = new JButton("UPDATE");
		b_update.addActionListener(this);
		p_1.setLayout(new FlowLayout(FlowLayout.CENTER));
		p_1.add(label_logo);
		p_2.setLayout(new BorderLayout());
		p_5.add(b_update);
		p_3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p_3.add(l1_mname);
		p_3.add(t1_mname);
		p_3.add(l2_tname);
		p_3.add(t2_tname);
		p_4.setLayout(new FlowLayout(FlowLayout.CENTER));
		p_4.add(l3_t1);
		p_4.add(t3_t1);
		p_4.add(l6_not1);
		p_4.add(t6_not1);
		p_4.add(l8_dat);
		p_4.add(dat);
		p_6.setLayout(new FlowLayout(FlowLayout.CENTER));
		p_6.add(bac);
		p_2.add(p_3,BorderLayout.NORTH);
		p_2.add(p_4,BorderLayout.CENTER);
		p_2.add(p_5,BorderLayout.SOUTH);
		show_update.setLayout(new BorderLayout());
		show_update.add(p_1,BorderLayout.NORTH);
		show_update.add(p_2,BorderLayout.CENTER);
		show_update.add(bac,BorderLayout.SOUTH);
		show_update.setVisible(true);
		show_update.setSize(850,350);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b_update)
		{
			
			String mov = t1_mname.getText();
			String thea = t2_tname.getText();
			String	time = t3_t1.getText();
			int noTic = Integer.parseInt(t6_not1.getText());
			Date dats = dat.getDate();
			//String strDate = formatter.format(dats);
				
			System.out.println(dats);
				Connect co= new Connect();
			
			
				co.create_shows(mov,thea,time,noTic,dats);
			
			
			JOptionPane.showMessageDialog(null,"Your details have been updated!");
			
		}
		else if(e.getSource()==bac) {
			show_update.dispose();
			new Admin_login();
		}
		
	}
}
