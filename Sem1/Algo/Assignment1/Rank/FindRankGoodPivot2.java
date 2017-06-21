package findrank;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class FindRankGoodPivot2 {
	public static void main(String args[])
	{
		try{
			//FileInputStream in=new FileInputStream("/home/haripriya/workspace/DataStructures/src/findrank/input.txt");
			//FileOutputStream out=new FileOutputStream("/home/haripriya/workspace/DataStructures/src/findrank/input.txt");
		
		FindRankGoodPivot2 p1=new FindRankGoodPivot2();
		int n,i,r,x;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int a[]=new int[n];
		//for(i=0;i<n;i++)
			//a[i]=sc.nextInt();
		int b[]=new int[n];
		//int p;
		/*for(i=0;i<n;i++)
		{
			p=(int)(Math.random()*1000)%1000;
			out.write(p);
		}*/
		for(i=0;i<n;i++)
		{	
			//a[i]=in.read();
			a[i]=(int)(Math.random()*10000)%10000;
			b[i]=a[i];
		System.out.print(a[i]+"  ");
		}
		Arrays.sort(b);
		System.out.println("enter rank you want to find");
		r=sc.nextInt();
		if(r<=0||r>n)
		{
			System.out.println("invalid rank");
			System.exit(0);
		}

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
	int goodpivot(int a[],int i,int j)
	{
		int temp,p,z,y;
		//pos=new int[((j-i+1)/5)+1];
		y=i;
			
		if(j==i)
			return i; 
		for(p=i;p<=j;p=p+5)
		{
			if(p+4>j)
				z=sort(a,p,j);
			else
				z=sort(a,p,p+4);
			temp=a[y];
			a[y]=a[z];
			a[y]=temp;
			y++;
			
			
		}
		/*for(p=i;p<k;p++)
		{
			
			temp=a[p];
			a[p]=a[pos[p]];
			a[pos[p]]=temp;
			
		}*/
		
		if((j-i+1)/10==0)
		{
			return sort(a,i,i+(j-i+1)/5);
		}
		return findrank(a,i,i+(j-i+1)/5,(j-i+1)/10);
	}
	int sort(int a[],int l,int r)
	{
		int i,j,temp,k=0;
		int b[]=new int[5];
		for(i=l;i<=r;i++)
		{
			b[k++]=a[i];
		}
		for(i=0;i<k-1;i++)
		{
			for(j=0;j<k-i-1;j++)
			{
				if(b[j]>b[j+1])
				{
					temp=b[j];
					b[j]=b[j+1];
					b[j+1]=temp;
				}
			}
		}
		for(i=0;i<k;i++)
			if(l+i<=r)
			a[l+i]=b[i];
			
		return (l+r)/2;
	}
	int findrank(int a[],int i,int j,int r)
	{
		int p,k;
		p=goodpivot(a,i,j);
		//System.out.println("p="+p+"a[p]="+a[p]);
		k=partition(a,i,j,p);
		//System.out.println("k="+k);
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
