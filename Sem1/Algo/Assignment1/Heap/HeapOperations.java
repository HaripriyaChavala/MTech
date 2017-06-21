package Heap;

import java.util.Scanner;

public class HeapOperations {
	static int n;

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int a[]=new int[10000];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		BuildHeap(a,n);
		char c;
		System.out.println("want to add element (y/n)");
		c=sc.next().charAt(0);
		while(c!='n')
		{
			System.out.println("enter the element");
			int x=sc.nextInt();
			add(a,n,x);
			System.out.println("heap elements are");
			for(int i=0;i<n;i++)
				System.out.print(a[i]);
			System.out.println("want to add element (y/n)");
			c=sc.next().charAt(0);
		}
		System.out.println("want to delete max element (y/n)");
		c=sc.next().charAt(0);
		while(c!='n')
		{
			
			delete(a,n);
			System.out.println("heap elements are");
			for(int i=0;i<n;i++)
				System.out.print(a[i]);
			System.out.println("want to delete max element (y/n)");
			c=sc.next().charAt(0);
		}
		sc.close();

	}
	static void delete(int a[],int k)
	{
		int temp;
		temp=a[0];
		a[0]=a[k-1];
		a[k-1]=temp;
		topdownheapify(a,0,k-1);
		n=n-1;
		
	}
	static void add(int a[],int k,int p)
	{
		int i,temp;
		a[n]=p;
		i=n;
		while(i>0&&a[(i-1)/2]<a[i])
		{
			temp=a[(i-1)/2];
			a[(i-1)/2]=a[i];
			a[i]=temp;
			i=(i-1)/2;
		}
		n=n+1;
			
	}
	static void BuildHeap(int a[],int k)
	{
		for(int i=(k/2);i>=0;i--)
		{
			topdownheapify(a,i,k);
		}
	}
	static void topdownheapify(int a[],int i,int k)
	{
		int l,r,temp,m;
		while(2*i+1<k)
		{
			l=2*i+1;
			r=2*i+2;
			if(r<k&&a[l]<a[r])
				m=r;
			else
				m=l;
			if(a[i]<a[m])
			{
				temp=a[i];
				a[i]=a[m];
				a[m]=temp;
				i=m;
			}
			else
				break;
		}
	}

}
