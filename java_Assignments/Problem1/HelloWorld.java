import java.util.Scanner;

public class HelloWorld {

	static Scanner sc;

	public static void main(String[] args) {
		 sc = new Scanner(System.in);
System.out.println("enter the no of times you want to print hello world");
int c=sc.nextInt();
for(int i=0;i<c;i++)
	System.out.println("Hello World");
	}
}
