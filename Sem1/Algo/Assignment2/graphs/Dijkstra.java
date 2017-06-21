package graphs;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
class Node
{
	int value;
	int weight;
	public Node(int v,int w)
	{
		value=v;
		weight=w;
	}
}
public class Dijkstra {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter no of nodes");
		int n=sc.nextInt();
		System.out.println("enter adjacency matrix");
		//int adjacency_matrix[][]=new int[n][n];
		boolean status[]=new boolean[n];
		int pi[]=new int[n];
		for(int i=0;i<n;i++)
			status[i]=false;
		List<Node> a[]=new ArrayList[n];
		for(int i=0;i<n;i++)
			a[i]=new ArrayList<Node>();
		a[0].add(new Node(1,5));
		a[0].add(new Node(2,2));
		a[2].add(new Node(1,1));
		
		
		
		/*for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				adjacency_matrix[i][j]=sc.nextInt();
			}
			
		}*/
		
		Node1 u=new Node1();
		Node1 list[]=new Node1[n];
		for(int i=0;i<n;i++)
		{
			list[i]=new Node1();
			list[i].value=i;
			list[i].priority=99999;
			list[i].status=false;
		}
		Comparator<Node1> comp=new PriorityComparator();
		PriorityQueue<Node1> p=new PriorityQueue<Node1>(n,comp);
		list[0].priority=0;
		p.add(list[0]);
		
		while(!p.isEmpty())
		{
			System.out.println("size of queue"+p.size());
			u=p.poll();
			System.out.println(u.value+" ");
			list[u.value].status=true;
			for(int i=0;i<n;i++)
			{
				/*if(adjacency_matrix[u.value][i]!=0&&list[i].priority>list[u.value].priority+adjacency_matrix[u.value][i]&list[i].status!=true)
				{
					if(p.contains(list[i]))
					p.remove(list[i]);
					list[i].priority=list[u.value].priority+adjacency_matrix[u.value][i];
					System.out.println("i="+i+"priority"+list[i].priority);
					p.add(list[i]);
					pi[i]=u.value;
					
				}*/
				int z=edgecost(a,u.value,i);
				if(z!=0&&list[i].priority>list[u.value].priority+z&&list[i].status!=true)
				{
					if(p.contains(list[i]))
						p.remove(list[i]);	
					list[i].priority=list[u.value].priority+z;
					System.out.println("i="+i+"priority"+list[i].priority);
					p.add(list[i]);
					pi[i]=u.value;
				}
			}
			
		}
		for(int i=0;i<n;i++)
		{
			System.out.println("   "+list[i].priority);
			System.out.println("pi["+i+"]="+pi[i]);
		}
		int z;
		for(int i=1;i<n;i++)
		{
			z=i;
			//System.out.print(z+1+"<-");
			while(z!=0)
			{
				System.out.print(z+"<-");
				z=pi[z];
			}
			System.out.println(0);
		}

	}
	static int edgecost(List<Node>[] a,int u,int v)
	{
		for(int i=0;i<a[u].size();i++)
		{
			if(a[u].get(i).value==v)
				return a[u].get(i).weight;
		}
		return 0;
	}

}
class PriorityComparator implements Comparator<Node1>
{
	public int compare(Node1 n1,Node1 n2)
	{
		return n1.priority-n2.priority;
	}
}
class Node1
{
	int value;
	int priority;
	boolean status;
}
