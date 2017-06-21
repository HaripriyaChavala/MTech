package dynamicprogramming;

import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int w[]=new int[n+1];
		int v[]=new int[n+1];
		w[0]=-1;
		for(int i=1;i<=n;i++)
		{
			w[i]=sc.nextInt();
		}
		v[0]=-1;
		for(int i=1;i<=n;i++)
		{
			v[i]=sc.nextInt();
		}
		int weight=sc.nextInt();
		int t[][]=new int[n+1][weight+1];
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=weight;j++)
			{
				if(i==1)
				{
					if(w[1]<=j)
						t[1][j]=v[1];
					else
						t[1][j]=0;
				}
				else
				{
				if(j>=w[i])
				{
					if(i==3&&j==4)
					{
						System.out.println(v[i]+t[i-1][j-w[i]]+"  "+t[i-1][j]);
					}
					t[i][j]=max(v[i]+t[i-1][j-w[i]],t[i-1][j]);
					
				}
				else
					t[i][j]=t[i-1][j];
				}
			}
		}
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=weight;j++)
			{
				System.out.print(t[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println("items taken");
		int p=n;
		int q=weight;
		while(p>0&&q>0&&t[p][q]>0)
		{
			//System.out.println("p="+p+"q="+q);
			if(t[p][q]==t[p-1][q])
				p--;
			else
			{
				System.out.println(p);
				q=q-w[p];
				p--;
				
			}
			
		}
		System.out.println("max profit");
		System.out.println(t[n][weight]);
		
		
		sc.close();

	}
	static int max(int a,int b)
	{
		if(a>b)
			return a;
		else
			return b;
	}

}
