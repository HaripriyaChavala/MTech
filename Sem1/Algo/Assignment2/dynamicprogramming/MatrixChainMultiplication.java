package dynamicprogramming;

import java.util.Scanner;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int p[]=new int[n+1];
		for(int i=0;i<=n;i++)
		{
			p[i]=sc.nextInt();
		}
		int m[][]=new int[n+1][n+1];
		int o[][]=new int[n+1][n+1];
		for(int i=1;i<=n;i++)
			m[i][i]=0;
		int p1=1;
		int q1=n-1;
		int w=1;
		while(p1<=q1)
		{
			int j=0;
			int i=0;
			int t=0;
		for(i=p1;i<=q1;i++)
		{
			j=i+w;
			System.out.println("i="+i+"j="+j);
			
					int min=9999999;
					for(int k=i;k<j;k++)
					{
						int z=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
						if(z<min)
						{
							min=z;
							t=k;
						}
					}
					//System.out.println("t="+t);
					m[i][j]=min;
					o[i][j]=t;
					
					
		}
		
		if(j-i==n-1)
		break;
		w++;
		q1--;
		}
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				System.out.print(m[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println(m[1][n]);
		print_par(1,n,o);
		sc.close();
			
	}
	static void print_par(int i,int j,int [][]o)
	{
		if(i==j)
			System.out.print(i);
		else
		{
			System.out.print("(");
			print_par(i,o[i][j],o);
			print_par(o[i][j]+1,j,o);
			System.out.print(")");
		}
	}

}
