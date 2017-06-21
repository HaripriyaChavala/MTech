package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter no of nodes");
		int n=sc.nextInt();
		boolean status[]=new boolean[n];
		int pi[]=new int[n];
		for(int i=0;i<n;i++)
			status[i]=false;
		List<Node> a[]=new ArrayList[n];
		for(int i=0;i<n;i++)
			a[i]=new ArrayList<Node>();
		System.out.println("enter no of edges");
		int z=sc.nextInt();
		for(int i=0;i<z;i++)
		{
			int a1=sc.nextInt();
			int b1=sc.nextInt();
			int c1=sc.nextInt();
			a[a1].add(new Node(b1,c1));
		}
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].size();j++)
			{
				System.out.print(i+" "+a[i].get(j).value+" "+a[i].get(j).weight+",");
			}
			System.out.println();
		}
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
			//System.out.println("size of queue"+p.size());
			u=p.poll();
			System.out.println(u.value+" ");
			list[u.value].status=true;
			for(int i=0;i<n;i++)
			{
				z=edgecost(a,u.value,i);
				if(z!=0&&list[i].priority>z&&list[i].status!=true)
				{
					if(p.contains(list[i]))
						p.remove(list[i]);	
					list[i].priority=z;
					System.out.println("i="+i+"priority"+list[i].priority);
					p.add(list[i]);
					pi[i]=u.value;
				}
			}
		}
		System.out.println("spanning tree edges are");
		for(int i=1;i<n;i++)
		{
			System.out.println(pi[i]+"->"+i);
		}
		sc.close();

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

