package dynamicprogramming;

import java.util.Scanner;

public class ChangeMaker {
	
	
	public static void main(String args[]) {
	    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
	    int x,y,i,j,k;
	    int num[]=new int[100];
	    
	    
	    Scanner sc=new Scanner(System.in);
	    x=sc.nextInt();
	    y=sc.nextInt();
	    int denom[]=new int[x];
	    for(i=0;i<x;i++)
	        denom[i]=sc.nextInt();
	    int amount[]=new int[y];
	    for(i=0;i<y;i++)
	        amount[i]=sc.nextInt();
	    sort(denom,x);
	    
	    
	
	    for(i=0;i<y;i++)
	        {
		int v[][]=new int[x+1][amount[i]+1];
	       
	         for(j=0;j<=x;j++)
	        for(k=0;k<=amount[i];k++)
	    		v[j][k]=9999;
	          
	         for(j=1;j<=x;j++)
	             {
	             for(k=1;k<=amount[i];k++)
	                 {
	                  if(denom[j-1]==k)
	                     v[j][k]=1;
	                  else if(k-denom[j-1]>=0&&j>=1)
	                      v[j][k]=min(v[j-1][k],v[j][k-denom[j-1]]+1);
	                   else
	                     v[j][k]=v[j-1][k];
	                 }
	             }
		
		    for(j=0;j<x;j++)
	            num[j]=0;
	        j=x;
	        k=amount[i];	
	        
	        while(k!=0&&j>=0)
	            {
			if(denom[j-1]==k)
			{
			num[j-1]=num[j-1]+1;
			k=0;
			}
	            else if(k-denom[j-1]>=0&&v[j][k]==v[j][k-denom[j-1]]+1) 
	             {   num[j-1]=num[j-1]+1;
	              k=k-denom[j-1];
	             }
	            else
	                {
	                j=j-1;
	            }
	        }
	k=0;
	for(j=0;j<x;j++)
	if(num[j]>0)
	{
		k=j;
		break;
	}
	        for(j=x-1;j>=k;j--)
	        {
	        	if(num[j]!=0)    
	        	System.out.print(denom[j]+" - "+num[j]+"  ");
	        }
	        System.out.println();
	
	
		
	        
	    }
	    sc.close();
	    
	}
	 static int min(int a,int b)
	    {
	    if(a>b)
	        return b;
	    return a;
	    
	}
	static void sort(int array[],int n)
	    {
	    int c,d,swap;
	    for (c = 0 ; c < ( n - 1 ); c++)
	  {
	    for (d = 0 ; d < n - c - 1; d++)
	    {
	      if (array[d] > array[d+1]) /* For decreasing order use < */
	      {
	        swap       = array[d];
	        array[d]   = array[d+1];
	        array[d+1] = swap;
	      }
	    }
	  }
	}


}
