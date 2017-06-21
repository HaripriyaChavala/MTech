package graphs;

import java.util.Scanner;

public class AllPair {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int adj[][]=new int[n][n];
		System.out.println("enter source");
		int x=sc.nextInt();
		int dist[][]=new int[n][n];
		int pi[]=new int[n];
		int no[]=new int[n];
		no[x]=0;
		System.out.println("enter adjacency matrix");
		for(int i=0;i<n;i++)
		{	for(int j=0;j<n;j++)
			{
				adj[i][j]=sc.nextInt();
				dist[i][j]=adj[i][j];
				
			}
		}
		for(int k=1;k<n;k++)
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(dist[i][k]+dist[k][j]<dist[i][j])
					{
						dist[i][j]=dist[i][k]+dist[k][j];
						//pi[i][j]=k;
					}
				
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
			System.out.println("distance from "+i+" to "+j+" is "+dist[i][j]);
			}
		}
		

	}

}
