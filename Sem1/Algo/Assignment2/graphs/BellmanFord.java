package graphs;

import java.util.Scanner;

public class BellmanFord {
	//static int pi[]=new int[n];

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int adj[][]=new int[n][n];
		System.out.println("enter source");
		int x=sc.nextInt();
		int dist[]=new int[n];
		int pi[]=new int[n];
		int no[]=new int[n];
		no[x]=0;
		System.out.println("enter adjacency matrix");
		for(int i=0;i<n;i++)
		{	for(int j=0;j<n;j++)
			{
				adj[i][j]=sc.nextInt();
				if(i==x)
				{
					dist[j]=adj[x][j];
					if(adj[x][j]!=99999)
						no[j]=1;
					else
						no[j]=0;
				}
				
				
			}
		//no[i]=1;
		pi[i]=x;
		}
		no[x]=0;
		//System.out.println(dist.toString());
		//System.out.println(no.toString());
		for(int i=0;i<n;i++)
		{
			if(i==x)
				dist[i]=0;
			else
				dist[i]=adj[x][i];
		}
		for(int k=2;k<=n-1;k++)
		{
			for(int v=0;v<n;v++)
			{
				for(int u=0;u<n;u++)
				{
					if(adj[u][v]!=99999)
					{
						if(u!=v&&dist[u]+adj[u][v]<dist[v])
						{
							dist[v]=dist[u]+adj[u][v];
							pi[v]=u;
							no[v]=no[u];
						}
						else if(u!=v&&dist[u]+adj[u][v]==dist[v]&&pi[v]!=u)
						{
							System.out.println("in else if "+no[v]+"  "+no[u]);
							no[v]=no[v]+no[u];
							
						}
					}
				}
			}
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.println("distance from source: "+x+" to:"+i+"is:"+dist[i]);
			System.out.println("no of paths:"+no[i]);
			System.out.print("path:"+x+"->");
			
			path(i,x,pi);
			System.out.println();
		}

	}
	static void path(int v,int s,int [] pi)
	{
		if(v==s)
			return;
		path(pi[v],s,pi);
		System.out.print(v+"->");
		
	}
	

}
