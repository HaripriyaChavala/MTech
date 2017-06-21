package findrank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FindRankRandomPivot {
	public static void main(String args[]) //throws IOException
	{
		//FileInputStream in=null;
		//FileOutputStream out=null;
		try
		{
		//in=new FileInputStream("/home/haripriya/workspace/DataStructures/src/findrank/input.txt");
		//out=new FileOutputStream("/home/haripriya/workspace/DataStructures/src/findrank/input.txt");
		
		FindRankRandomPivot p1=new FindRankRandomPivot();
		
		int n,i,r,x;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int a[]=new int[n];
		int b[]=new int[n];
		/*int p;
		for(i=0;i<n;i++)
		{
			p=(int)(Math.random()*1000)%1000;
			out.write(p);
		}*/
		//for(i=0;i<n;i++)
			//a[i]=sc.nextInt();
		for(i=0;i<n;i++)
		{
			a[i]=(int)(Math.random()*1000)%1000;
			//a[i]=in.read();
			b[i]=a[i];
		System.out.print(a[i]+"  ");
		}
		Arrays.sort(b);
		System.out.println("enter rank you want to find");
		r=sc.nextInt();
		x=p1.findrank(a,0,n-1,r);
		System.out.println("final result is"+a[x]);
		System.out.println("correct result should be"+b[n-r]);
		sc.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		/*finally
		{
		
			in.close();
			
			out.close();
		}*/
	}
	int randompivot(int a[],int i,int j)
	{
		//int x;
		//x=(int)Math.random()%(j-i);
		return j;
	}
	
	int findrank(int a[],int i,int j,int r)
	{
		int p,k;
		p=randompivot(a,i,j);
		//System.out.println(p);
		k=partition(a,i,j,p);
		//System.out.println(k);
		if(i==j)
			return i;
		if(r==j-k+1)
			return k;
		else if(r<j-k+1)
			return findrank(a,k+1,j,r);
		else if(r>j-k+1)
			return findrank(a,i,k-1,r-(j-k)-1);
		return -1;
		
	}
	int partition(int a[],int l,int r,int p)
	{
		int i,j,temp;
		i=l;
		j=r;
		while(i<j)
		{
			while(i<=r&&a[i]<=a[p])
				i++;
			while(j>l&&a[j]>a[p])
				j--;
			if(i<j)
			{
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		temp=a[p];
		a[p]=a[j];
		a[j]=temp;
		return j;
	}

}
