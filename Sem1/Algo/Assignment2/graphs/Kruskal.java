package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kruskal {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		//System.out.println("enter no of nodes");
		int n=sc.nextInt();
		ArrayList<Integer> edges=new ArrayList<Integer>();
		int color[]=new int[n];
		int no_of_nodes[]=new int[n];
		List<Integer> color_node_list[]=new List[n];
		for(int i=0;i<n;i++)
		{
			color_node_list[i]=new ArrayList<Integer>();
		}
		//System.out.println("no of edges");
		int x=sc.nextInt();
		for(int i=0;i<x;i++)
		{
			
			//System.out.println("enter two nodes");
			int p=sc.nextInt();
			int q=sc.nextInt();
			//System.out.println("enter cost");
			int cost=sc.nextInt();
			edges.add(p-1);
			edges.add(q-1);
			edges.add(cost);
			
		}
		for(int i=0;i<n;i++)
		{
			color[i]=i;
			no_of_nodes[i]=1;
			color_node_list[i].add(i);
		}
		int min=99999,u=0,v=0,u_index=0,v_index=0,count=0;
		for(int i=1;i<=x&&count<=n-1;i++)
		{
			min=99999;
			for(int k=1;k<=x;k++)
			{
			if(edges.get(3*k-1)<min)
			{
				u_index=3*k-3;
				v_index=3*k-2;
				
				u=edges.get(u_index);
				v=edges.get(v_index);
				
				min=edges.get(3*k-1);
				
			}
			}
			//System.out.println("u_index="+u_index+"v_index="+v_index);
			//System.out.println("u="+u+"v="+v);
			edges.set(v_index+1,99999);
			if(color[u]!=color[v])
			{
				//System.out.println(u+"->"+v);
				count++;
				if(no_of_nodes[color[v]]>0&&no_of_nodes[color[u]]>=no_of_nodes[color[v]])
				{
					color_node_list[color[u]].addAll(color_node_list[color[v]]);
					no_of_nodes[color[v]]=0;
					no_of_nodes[color[u]]+=no_of_nodes[color[v]];
					int p=color[v];
					for(int j=0;j<color_node_list[color[v]].size();j++)
					{
						color[color_node_list[color[v]].get(j)]=color[u];
					}
					
					
					
					
					color_node_list[p]=null;
				}
				if(no_of_nodes[color[u]]>0&&no_of_nodes[color[v]]>no_of_nodes[color[u]])
				{
					color_node_list[color[v]].addAll(color_node_list[color[u]]);
					no_of_nodes[color[v]]+=no_of_nodes[color[u]];
					no_of_nodes[color[u]]=0;
					int p=color[u];
					for(int j=0;j<color_node_list[color[u]].size();j++)
					{
						color[color_node_list[color[u]].get(j)]=color[v];
					}
					
					
					color_node_list[p]=null;
				}
			}
		}
		
		sc.close();
	}

}
