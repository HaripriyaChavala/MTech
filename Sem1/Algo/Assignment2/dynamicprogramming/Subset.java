package dynamicprogramming;

import java.util.Scanner;

public class Subset {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n+1];
		a[0]=0;
		for(int i=1;i<=n;i++)
			a[i]=sc.nextInt();
		
		int x=sc.nextInt();
		int t[][]=new int[n+1][x+1];
		for(int i=0;i<=x;i++)
			t[0][i]=1;
		for(int i=0;i<=n;i++)
			t[i][0]=1;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=x;j++)
			{
				if(i==1)
				{
				if(j==a[1])	
				t[1][j]=1;
				else
					t[1][j]=0;
				}
				else
				{
					//if(j>=a[i]&&t[i-1][j-a[i]]==1)
						//System.out.println(a[i]);
					if(t[i-1][j]==1||(j>=a[i]&&t[i-1][j-a[i]]==1))
					{
						t[i][j]=1;
					}
					else
						t[i][j]=0;
				}
			}
				
		}
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=x;j++)
			{
				System.out.print(t[i][j]+" ");
				
			}
			System.out.println();
		}
		System.out.println(t[n][x]);
		int i=n;int j=x;
		int sum=x;
		if(t[n][x]==1)
		{
			System.out.println("taken elements are");
		while(sum!=0&&i>0&&j>0)
		{
			//cSystem.out.println("i="+i+"j="+j+"a[i]="+a[i]+"sum="+sum);
			if(j>=a[i]&&t[i-1][j-a[i]]==1)
			{	System.out.println(a[i]);
				
				j=j-a[i];
				sum=sum-a[i];
				i--;
			}
			else
				i--;
		}
		}
		sc.close();
	}

}
