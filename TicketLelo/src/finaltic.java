import java.awt.*;
import java.util.Date;

import javax.swing.*;
public class finaltic {
	JFrame f;
	JPanel p1,p2,p3;
	JLabel label_logo,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
	public finaltic() {
		// TODO Auto-generated constructor stub
	}

	
	
public void createtic(String name, String theatre, String movie, Date dt, int timing, String qty) {

	int cost=200,q;
		f = new JFrame();
		p1= new JPanel();
		p2= new JPanel();
		p3= new JPanel();
		Connect c = new Connect();
		
	 	label_logo= new JLabel("<html><i><strong><font size='8' color='RED' face='ROG Fonts'>MOVIEBAZAAR</font><font size='4'>TICKET</font></strong></i></html>");
		l1= new JLabel("NAME");
		l2= new JLabel(name);
		l3= new JLabel("CINEMA");
		l4= new JLabel(theatre);
		l5= new JLabel("MOVIES");
		l6= new JLabel(movie);
		l7= new JLabel("SHOWTIME");
		l8= new JLabel(Integer.toString(timing));
		l9= new JLabel("NUMBER OF SEATS");
		l10= new JLabel(qty);
		l11= new JLabel("COST");
		cost=cost*(Integer.parseInt(qty));
		l12= new JLabel(Integer.toString(cost));
		l13= new JLabel("Thank you for booking with us!");
		
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		p1.add(label_logo);
		p2.setLayout(new GridLayout(6,2));
		p2.add(l1);
		p2.add(l2);
		p2.add(l3);
		p2.add(l4);
		p2.add(l5);
		p2.add(l6);
		p2.add(l7);
		p2.add(l8);
		p2.add(l9);
		p2.add(l10);
		p2.add(l11);
		p2.add(l12);
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p3.add(l13);
		
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.setVisible(true);
		f.setSize(450, 250);
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
	
}

}
