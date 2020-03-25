import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.*;


import javax.swing.*;

import com.toedter.calendar.JDateChooser;
public class places implements ActionListener{
	JFrame f;
	JPanel movie_bazaar,p1,p2,btn;
	JLabel l1,l2,l3,l4,l5,label_date,label_phone;
	JLabel a1,a2,a3,a4,a5,a6;
	JTextField t_phone;
	JRadioButton radio_timeSlot,radio_timeSlot2,radio_timeSlot3;
	ButtonGroup timeslot;
	JButton b1,bac;
	JComboBox<String> jc,jd,jd2,jd3;
	String name;
	JDateChooser book_date;
	
	ArrayList<String> arr = new ArrayList<String>();
	ArrayList<String> arr2 = new ArrayList<String>();
	ArrayList<String> arr3 = new ArrayList<String>();

	
	
	
	  String text = "<html><font size='18' color='RED' face='ROG Fonts'><i><strong>MOVIEBAZAAR</strong></i></font></html>";
	  places(){}
	public  void mainframe(String login_id) {
	
		  	int i=0;
		  	name =login_id;
		  	bac = new JButton("<html><font color=white>LOGOUT</font></html>");
		  	bac.addActionListener(this);
		  	f = new JFrame();
			f.setLayout(new BorderLayout());
			f.setTitle("MOVIEBAZAAR BOOKING");
			book_date= new JDateChooser();
			movie_bazaar = new JPanel();
			movie_bazaar.setSize(500,200);
			l1 = new JLabel(text);
            movie_bazaar.add(l1);

            p2 = new JPanel(); 
            label_date=new JLabel("<html><font size='4'><strong>SELECT BOOKING DATE</strong></font></html>");
            jc = new JComboBox<String>();
            jc.addActionListener(this);
     
            label_phone = new JLabel("<html><font size='4'><strong>PHONE NUMBER</strong></font></html>");
            t_phone= new JPasswordField(10);
            
			jd = new JComboBox<String>();
			
			jd2 = new JComboBox<String>();
			jd3 = new JComboBox<String>();
 
			l3  =new JLabel("<html><font size='5'><strong>PLACES</strong></font></html>");
			
			Connect c = new Connect();

			arr=c.ret_places("places","");
			while(i<arr.size()) {
				jc.addItem(arr.get(i));
				i=i+1;
			}
			
			i=0;
			
			/*
			
			}*/
			
			p2.add(l3);
			p2.add(jc);
		
			a1 = new JLabel("<html><font size='5'><strong>CINEMAS</strong></font></html>");
			a2 = new JLabel("<html><font size='5'><strong>MOVIES</strong></font></html>");
			a3 = new JLabel("<html><font size='5'><strong>TIMINGS</strong></font></html>");
			a4 = new JLabel("<html><font size='5'><strong>NO. OF SEATS</strong></font></html>");
			a5 = new JLabel("<html><font size='5'><strong>PRICE:</strong></font></html>");
			a6 = new JLabel("<html><font size='4'>Rs.200/person</font></html>");

			
			p1 = new JPanel();
			p1.setLayout(new GridLayout(1,3));
			radio_timeSlot = new JRadioButton("8:00 AM");
			radio_timeSlot2 = new JRadioButton("1:00 PM");
			radio_timeSlot3 = new JRadioButton("9:00 PM");
			timeslot = new ButtonGroup();
	
			timeslot.add(radio_timeSlot);
			timeslot.add(radio_timeSlot2);
			timeslot.add(radio_timeSlot3);
			p1.add(radio_timeSlot);
			p1.add(radio_timeSlot2);
			p1.add(radio_timeSlot3);
					
		
			
			
			
            p2.setLayout(new GridLayout(8,2));
             
        	p2.add(a1);
    		p2.add(jd);
			p2.add(a2);
			p2.add(jd2);
			p2.add(a3);
			p2.add(p1);
			p2.add(a4);
			p2.add(jd3);
			p2.add(a5);
			p2.add(a6);
			p2.add(label_date);
			p2.add(book_date);
			p2.add(label_phone);
			p2.add(t_phone);
			btn = new JPanel();
			b1 = new JButton("BOOK NOW");
			b1.addActionListener(this);
			btn.add(b1);
			btn.add(bac);
			bac.setBackground(Color.RED);
			b1.setBackground(Color.cyan);
			b1.setPreferredSize(new Dimension(150,30));
			bac.setPreferredSize(new Dimension(150,30));

			btn.setLayout(new FlowLayout(FlowLayout.CENTER));

			f.setVisible(true);
			f.setSize(500,400);
			f.add(movie_bazaar,BorderLayout.NORTH);
			f.add(p2,BorderLayout.CENTER);
			
			f.add(btn,BorderLayout.SOUTH);
			
			}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	
		Connect c = new Connect();
	if(e.getSource()==jc) {
		String sel_pl=(String) jc.getSelectedItem();	
		
		int i=0;
			arr2.clear();arr3.clear();
			jd.removeAllItems();jd2.removeAllItems();jd3.removeAllItems();
			arr2=c.ret_places("theatre",sel_pl);		
			
				while(i<arr2.size()) {
						jd.addItem(arr2.get(i));
						i=i+1;
					}
				
				if(jd.getItemAt(0)!=null) {
					i=0;
					arr3=c.ret_places("movie","");	
				
						while(i<arr3.size()) {
							jd2.addItem(arr3.get(i));
							i=i+1;
							}
						
						jd3.addItem("1");
						jd3.addItem("2");
						jd3.addItem("3");
						jd3.addItem("4");
						
						
				}
			}
	
	
	else if(e.getSource()==b1) {
			ArrayList<String> ar= new ArrayList<String>();
			
			String movie,place,theatre,qty,no,a;
			int timing=0;
			String tim;
			java.util.Date date;
			date=book_date.getDate();
			no=t_phone.getText();
			//User u = new User();
		//	u.f1.setVisible(false);
			
			movie=(String) jd2.getSelectedItem();
			places p=new places();
			
			place=(String) jc.getSelectedItem();
			qty=(String) jd3.getSelectedItem();
			theatre=(String)jd.getSelectedItem();
			if(radio_timeSlot.isSelected()) {
				timing=8;
				tim=Integer.toString(timing);
				 a= date.toString();
			}
			if(radio_timeSlot2.isSelected()) {
				timing=13;
				tim=Integer.toString(timing);
				a= date.toString();
			}
			if(radio_timeSlot3.isSelected()) {
				timing=21;
				tim=Integer.toString(timing);
				a= date.toString();
			}
			
			
			qtydatecheck q= new qtydatecheck(); 
			boolean flag=q.check(qty,date,movie,theatre);
			
			if (flag==true) {
				
			c.book_ticket(place,theatre,movie,timing,qty,name,date,no);
				}
			
			else if(flag==false){JOptionPane.showMessageDialog(null, "HOUSE FULL");}
			
			//c.book_ticket(place,theatre,movie,timing,qty,name,date,no);
			
			
			
			
		}
	else if(e.getSource()==bac) {
		f.dispose();
		new User();
	}
		}
	
	

}