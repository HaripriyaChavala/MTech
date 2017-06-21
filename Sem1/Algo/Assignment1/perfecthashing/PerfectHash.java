package perfecthashing;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class PerfectHash {
	public static void main(String args[]) throws IOException
	{
	
		FileInputStream in = null;
		FileOutputStream out = null;
	      try {
	          	in = new FileInputStream("/home/haripriya/input.txt");
	          	out = new FileOutputStream("/home/haripriya/output.txt");
	          	BufferedReader reader=new BufferedReader(new InputStreamReader(in));
	          	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
	          	long x=(long) Math.pow(10, 10);
	          	System.out.println(x);
	          	String line;
	          	//long q[]=new long[10];
	          	int i=0;
	          
	          	//reader.close();
	          	
	          	@SuppressWarnings("unchecked")
				List<Long>[] l=new List[2000000];
	          	for(i=0;i<2000000;i++)
	          	{
	          		l[i]=new ArrayList<Long>();
	          	}
	          	boolean flag=true;
	          	long p=(long)Math.pow(10,10)+7;
	          	
	          	int a;
	          	long q;
	          	int list_no;
	          	int a_h1=0,b_h1=0;
	          	while(flag)
	          	{
	          		a_h1=(int)(Math.random()*1000);
	          		b_h1=(int)(Math.random()*1000);
	       
	          		System.out.println(a_h1+"  "+b_h1);
	          		//int i1=1;
	          		while((line=reader.readLine())!=null)
		          	{
		          		
		          		q=Long.parseLong(line);
		          		//System.out.println(q);
		          		list_no=Math.abs((int)((a_h1*q+b_h1)%p));
		          			list_no=list_no%2000000;
		          			//System.out.println("list_no"+list_no);
		          			l[list_no].add(q);
		          			
		          	}
	          		int sum=0,ni_square,size;
	          		for(i=0;i<2000000;i++)
	          		{
	          			size=l[i].size();
	          			ni_square=size*size;
	          			sum=sum+ni_square;
	          		}
	          		if(sum<2000000)
	          		{
	          			System.out.println("sum="+sum);
	          			flag=false;
	          		}
	          	    
	          		
	          		
	          		
	          	}
	          	for(a=0;a<2000000;a++)
          		{
          		for(i=0;i<l[a].size();i++){
          			 
          			 for(int j=i+1;j<l[a].size();j++){
          			            if(l[a].get(i).equals(l[a].get(j))){
          			                l[a].remove(j);
          			                j--;
          			            }
          			    }
          			 
          			 }
          		}
	          	SecondaryHash s[]=new SecondaryHash[2000000];
	          	int location;
	          	int size,a1=0,b1=0;
	          	for(a=0;a<2000000;a++)
	          	{
	          		flag=true;
	          		size=l[a].size();
	          		s[a]=new SecondaryHash(size*size);
	          		while(flag)
	          		{
	          			s[a].intializeArray();
	          			a1=(int)(Math.random()*1000);
		          		b1=(int)(Math.random()*1000);
		          		
		          		for(i=0;i<size;i++)
		          		{
		          		location=Math.abs((int)((a1*l[a].get(i)+b1)%p));
		          		location=location%(size*size);
		          		if(s[a].h2[location]!=-1)
		          		{
		          			break;
		          		}
		          		else
		          		{
		          			s[a].h2[location]=l[a].get(i);
		          		}
		          		}
		          		if(i==size)
		          		{
		          			s[a].ChangeValues(a1, b1, p);
		          			writer.write(a1+"\n"+b1+"\n"+p+"\n");
		          			for(int j=0;j<s[a].size;j++)
		          			{
		          				//writer.write(s[a].h2[j]+"\n");
		          			}
		          			flag=false;
		          		}
		          		
	          		}
	          		
	          	
	          			
	          	}
	          	Scanner sc=new Scanner(System.in);
	          	/*for(i=0;i<4;i++)
	          	{
	          	System.out.println("enter element to search");
	          	q=sc.nextLong();
	          	
	          	list_no=Math.abs((int)((a_h1*q+b_h1)%p));
      			list_no=list_no%2000000;
      			a1=s[list_no].a;
      			b1=s[list_no].b;
      			location=0;
      			if(l[list_no].size()==0)
      				System.out.println("not found");
      			else
      			{	
      				location=Math.abs((int)((a1*q+b1)%p));
      			location=location%(l[list_no].size()*l[list_no].size());
      			}
          		
          		if(s[list_no].h2[location]==q)
          			
          			System.out.println("found");
          		else
          			System.out.println("not found");
      			
	          	}*/
	          	for(a=0;a<2000000;a++)
	          	{
	          		for(i=0;i<s[a].size-1;i++)
	          		{
	          			for(int j=i+1;j<s[a].size;j++)
	          			{
	          		long p1=s[a].h2[i];
	          		long p2=s[a].h2[j];
	          			
	          			
	          			if(p1!=-1&&p2!=-1&&Math.abs(p1-p2)<=1000000)
	          				System.out.println(p1+"    "+p2);
	          			}		
	          					
	          		}
	          			
	          	}
      			reader.close();
	          	writer.close();
	          	sc.close();
	          }
	      	catch(Exception e)
	      	{
	      		System.out.println(e);
	      	}
	      
	}

}
