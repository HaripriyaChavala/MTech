package SmallK;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;

import java.util.Scanner;

public class Heap {
	public static void main(String args[])
	{
		try{
			//FileInputStream in=new FileInputStream("/home/haripriya/workspace/DataStructures/src/findrank/input.txt");
			//FileOutputStream out=new FileOutputStream("/home/haripriya/workspace/DataStructures/src/findrank/input.txt");
	int k,a[],i,p;
	long n;
	Scanner sc=new Scanner(System.in);
	n=sc.nextLong();
	k=sc.nextInt();
	a=new int[k];
	/*int p;
	long z;
	/*for(z=0;z<n;z++)
			{
				p=(int)(Math.random()*1000)%1000;
				out.write(p);
			}*/
	for(i=0;i<k;i++)
	{
		if(i<k)
			a[i]=(int)(Math.random()*1000)%1000;
		//a[i]=in.read();
		System.out.print(a[i]+"  ");
		
		
	}
	BuildHeap(a,k);
	for(i=k;i<n;i++)
	{
		p=(int)(Math.random()*1000)%1000;
		//p=in.read();
		System.out.print(p+"  ");
		if(a[0]>p)
		{
			//deleteMax(a,k);
			a[0]=p;
			topdownheapify(a,0,k);
		}
		/*for(int j=0;j<k;j++)
			System.out.print(a[j]+"  ");
		System.out.println();*/
	}
	System.out.println(k+"small elements are");
	for(i=0;i<k;i++)
		System.out.print(a[i]+"   ");
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
static void deleteMax(int a[],int k)
{
	int temp;
	temp=a[0];
	a[0]=a[k-1];
	a[k-1]=temp;
	topdownheapify(a,0,k-1);
	
}
static void insert(int a[],int k,int p)
{
	int i,temp;
	a[k-1]=p;
	i=k-1;
	while(i>0&&a[(i-1)/2]<a[i])
	{
		temp=a[(i-1)/2];
		a[(i-1)/2]=a[i];
		a[i]=temp;
		i=(i-1)/2;
	}
		
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
















