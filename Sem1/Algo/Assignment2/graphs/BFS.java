package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter no of nodes");
		int n=sc.nextInt();
		List<Integer> adj[]=new List[n];
		boolean status[]=new boolean[n];
		int pi[]=new int[n];
		for(int i=0;i<n;i++)
			status[i]=false;
		for(int i=0;i<n;i++)
		{
			adj[i]=new ArrayList<Integer>();
			System.out.println("no of nodes adjacent to "+i);
			int x=sc.nextInt();
			System.out.println("enter nodes adjacent to "+i);
			for(int j=0;j<x;j++)
			{
				int y=sc.nextInt();
				adj[i].add(y);
			}
				
			
		}
		/*System.out.println("enter adjacency matrix");
		int adjacency_matrix[][]=new int[n][n];
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				adjacency_matrix[i][j]=sc.nextInt();
			}
			
		}*/
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(0);
		int u;
		BFS b=new BFS();
		while(!q.isEmpty())
		{
			u=q.poll();
			System.out.println(u+"  ");
			status[u]=true;
			for(int i=0;i<n;i++)
			{
				if(b.isAdjacent(adj,u,i)&&status[i]==false)
				{
					q.add(i);
					status[i]=true;
					pi[i]=u;
				}
			}
		}
		
		
		
		sc.close();
		

	}
	 boolean isAdjacent(List<Integer> adj[],int u,int v)
	{
		for(int i=0;i<adj[u].size();i++)
		{
			if(adj[u].get(i)==v)
				return true;
		}
		return false;
	}

}
