package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Vertex
{
	int left;
	int right;
	int weight;
	public Vertex(int i,int j,int k)
	{
		left=i;
		right=j;
		weight=k;
	}
	
}
class WeightComparator implements Comparator<Vertex>
{
	public int compare(Vertex n1,Vertex n2)
	{
		return n1.weight-n2.weight;
	}
}
public class Kruskal_2 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		//System.out.println("enter no of nodes");
		int n=sc.nextInt();
		ArrayList<Vertex> edges=new ArrayList<Vertex>();
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
			edges.add(new Vertex(p,q,cost));
			
			
		}
		Comparator<Vertex> comp=new WeightComparator();
		edges.sort(comp);
		for(int i=0;i<n;i++)
		{
			color[i]=i;
			no_of_nodes[i]=1;
			color_node_list[i].add(i);
		}
		int min=0,u=0,v=0,count=0;
		int weight = 0;
		for(int i=1;i<=x&&count<=n-1;i++)
		{
			Vertex vertex=edges.get(0);
			edges.remove(0);
			
				
				u=vertex.left;
				v=vertex.right;
				
				min=vertex.weight;
				if(color[u]!=color[v])
				{
				//System.out.println(u+"->"+v);
				weight = weight+min;
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
