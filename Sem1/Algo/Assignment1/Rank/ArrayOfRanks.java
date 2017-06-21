package findrank;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;



public class ArrayOfRanks {
	static int res[];
	public static void main(String args[])
	{
		try{
			//FileInputStream in=new FileInputStream("/home/haripriya/workspace/DataStructures/src/findrank/input.txt");
			//FileOutputStream out=new FileOutputStream("/home/haripriya/workspace/DataStructures/src/findrank/input.txt");
			HashSet<Integer> set = new HashSet<>();
	int a[],b[],i,m,n;
	ArrayOfRanks p1=new ArrayOfRanks();
	Scanner sc=new Scanner(System.in);
	m=sc.nextInt();
	n=sc.nextInt();
	a=new int[n];
	b=new int[m];
	for(i=0;i<m;i++)
	{
		b[i]=(int)(Math.random()*1000)%n+1;
		//b[i]=sc.nextInt();
		if(b[i]<=0||b[i]>n)
		{
			System.out.println(b[i]+"is invalid rank so ignoring it");
			i--;
			
		}
		System.out.print(b[i]+"  ");
	}
	m=i;
	int c[]=new int[m];
	Arrays.sort(b);
	c[0]=b[0];
	int j=1;
	for(i=1;i<m;i++)
	{
		if(b[i]!=b[i-1])
			c[j++]=b[i];
	}
	m=j;
	res=new int[m];
	        //System.out.println("m="+m);
	       
	//int p;
	/*for(i=0;i<n;i++)
	{
		p=(int)(Math.random()*1000)%1000;
		out.write(p);
	}*/
	for(i=0;i<n;i++)
	{
		//a[i]=sc.nextInt();
		//a[i]=in.read();
		a[i]=(int)(Math.random()*1000)%1000;
		System.out.print(a[i]+"  ");
	}
	System.out.println();
	i=0;
	int r=(m-1)/2;
	 System.out.println("the elements having ranks");
	 for(i=0;i<m;i++)
	 {
		 System.out.print(c[i]+"  ");
	 }
	 System.out.println("are");
	  p1.findranks(a,0,n-1,c,0,m-1,c[r],n);
	  for(i=0;i<m;i++)
		  System.out.print(res[i]+"  ");
	  System.out.println();
	  Arrays.sort(a);
	  for(i=0;i<n;i++)
		  System.out.print(a[i]+"  ");
	  sc.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		/*finally{
			in.cloce();
			out.close();
		}*/
		
	}

void findranks(int a[],int l_a,int r_a,int b[],int l_b,int r_b,int r,int n)
{
	int x;
	int mid;
	mid=(l_b+r_b)/2;
	x=mid;
	if(l_b<=r_b)
	{
	if(l_a<=r_a)
	{
	
	x=findrank(a,l_a,r_a,r);
	if(x!=-1)
	{
	//System.out.println("ele having "+ b[mid] +" rank is"+a[x] );
	res[mid]=a[x];}
	}
	
	findranks(a,x+1,r_a,b,l_b,mid-1,b[(l_b+mid-1)/2]-(n-r_a)+1,n);
	findranks(a,l_a,x-1,b,mid+1,r_b,b[(mid+1+r_b)/2]-(n-(x-1))+1,n);
	
	}
	
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
	if(r<=0)
		return -1;
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