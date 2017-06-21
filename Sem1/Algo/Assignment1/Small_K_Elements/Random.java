package smallknumbers;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;

import java.util.Scanner;

public class Random {
public static void main(String args[])
{
	try
	{
		//FileInputStream in=new FileInputStream("/home/haripriya/workspace/DataStructures/src/findrank/input.txt");
		//FileOutputStream out=new FileOutputStream("/home/haripriya/workspace/DataStructures/src/findrank/input.txt");
	Random p1=new Random();
	long n;
	int k,a[],i,x,j,p,r;
	Scanner sc=new Scanner(System.in);
	n=sc.nextLong();
	k=sc.nextInt();
	a=new int[2*k];
	/*int p;
	long z;
	for(z=0;z<n;z++)
	{
		//p=(int)(Math.random()*1000)%1000;
		out.write(p);
	}*/
	for(i=0;i<k;i++)
	{
		//a[i]=in.read();
		a[i]=(int)(Math.random()*1000)%1000;
		System.out.print(a[i]+"  ");
		
		
	}
	j=i;
	x=k-1;
	for(;j<n;)
	{
		if(x==2*k-1)
		{
			//a[x]=in.read();
			a[x]=(int)(Math.random()*1000)%1000;
			System.out.println(a[x]+"  ");
			j++;
		}
		
		for(i=x+1;i<2*k&&j<n;i++)
		{
			//a[i]=in.read();
			a[i]=(int)(Math.random()*1000)%1000;
			
			System.out.print(a[i]+"  ");
			j++;
			
			
		}
		//for(int z=0;z<i;z++)
			//System.out.print(a[z]+"  ");
		//System.out.println();
		p=i;
		if(j==n)
			x=p1.findrank(a,0,p-1,p-k);
		else
		{
		r=0;
		do
		{
		r=(int)(Math.random()*1000)%(2*k);
		
		x=p1.partition(a,0,2*k-1,r);
		}while(x<k-1);
		//System.out.println("x="+x);
		
		}
		//System.out.println("j="+j);
		
	}
	System.out.println("small "+k+" elements are");
	for(x=0;x<k;x++)
	System.out.print("    "+a[x]);
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
		return p;
	else if(r<j-k+1)
		return findrank(a,k+1,j,r);
	else if(r>j-k+1)
		return findrank(a,i,k-1,r-(j-k)-1);
	return -1;
	
}
int partition(int a[],int l,int r,int p)
{
	int i,j,temp;
	i=l+1;
	j=r;
	temp=a[l];
	a[l]=a[p];
	a[p]=temp;
	while(i<j)
	{
		while(i<=r&&a[i]<=a[l])
			i++;
		while(j>l&&a[j]>a[l])
			j--;
		if(i<j)
		{
			temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
	}
	temp=a[l];
	a[l]=a[j];
	a[j]=temp;
	return j;
}




}

