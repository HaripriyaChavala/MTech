package Problem3;
import java.util.Scanner;

public class TaxiEfficiency {
	static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		sc=new Scanner(System.in);
		int count=sc.nextInt();
		int[] type=new int[count];
		float[] efficiency=new float[count];
		float[] fuel=new float[count];
		for (int i=0;i<count;i++)
		{
			type[i]=sc.nextInt();
			efficiency[i]=sc.nextFloat();
			fuel[i]=sc.nextFloat();
			
		}
		for(int i=0;i<count;i++)
		{
			if(type[i]==1)
			{
				System.out.println("Car "+(i+1)+":range = "+(efficiency[i]*fuel[i]));
				
			}
			else
			{
				System.out.println("Car "+(i+1)+":range = "+(fuel[i]*1000/efficiency[i]));
			}
		}
			
		

	}

}
