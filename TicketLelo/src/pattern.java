import java.util.Scanner;

class pattern {
 public static void main(String []args)
 {
	 Scanner sc=new Scanner(System.in);
	 int a; int i; int j; int c;
	 System.out.println("Enter:");
	 a=sc.nextInt();
	 c=a;
	 for(i=0;i<a;i++)
	 {
		 System.out.println();
		 for(j=0;j<=i;j++)
		 {
			 System.out.println(c);
			 c--;
		 }
		 c=a;
	 }
 }
}
