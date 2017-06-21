package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class DFS {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter no of nodes");
		int n=sc.nextInt();
		boolean status[]=new boolean[n];
		List<Integer> adj[]=new List[n];
		int pi[]=new int[n];
		for(int i=0;i<n;i++)
			status[i]=false;
		/*System.out.println("enter adjacency matrix");
		int adjacency_matrix[][]=new int[n][n];
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				adjacency_matrix[i][j]=sc.nextInt();
			}
			
		}*/
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
		Stack<Integer> s=new Stack<Integer>();
		s.push(0);
		int u;
		
		while(!s.isEmpty())
		{
			u=s.pop();
			if(status[u]==false)
			{
				System.out.println(u+"  ");
			}
			status[u]=true;
			for(int i=0;i<n;i++)
			{
				if(isAdjacent(adj,u,i)&&status[i]==false)
				{
					s.push(i);
					pi[i]=u;
				}
			}
		}
		sc.close();

	}
	static boolean isAdjacent(List<Integer> adj[],int u,int v)
	{
		for(int i=0;i<adj[u].size();i++)
		{
			if(adj[u].get(i)==v)
				return true;
		}
		return false;
	}


}
