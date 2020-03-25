import java.util.Date;

public class qtydatecheck {
	public qtydatecheck() {
		// TODO Auto-generated constructor stub
	}

	public boolean check(String qty, java.util.Date date, String movie, String theatre) {
		Connect cn = new Connect();
		
		boolean flag=cn.check(Integer.parseInt(qty),date,movie,theatre);
		return flag;
	}
}
