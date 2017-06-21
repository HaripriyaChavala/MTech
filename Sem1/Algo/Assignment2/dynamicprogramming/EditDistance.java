package dynamicprogramming;

import java.util.Scanner;

public class EditDistance {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String s1=sc.next();
		String s2=sc.next();
		System.out.println("enter addition cost");
		int add=sc.nextInt();
		System.out.println("enter deletion cost");
		int del=sc.nextInt();
		System.out.println("enter replacement cost");
		int rep=sc.nextInt();
		int t[][]=new int[s1.length()+1][s2.length()+1];
		t[0][0]=0;
		for(int i=1;i<=s2.length();i++)
			t[0][i]=add*i;
		for(int i=1;i<=s1.length();i++)
			t[i][0]=del*i;
		for(int i=1;i<=s1.length();i++)
		{
			for(int j=1;j<=s2.length();j++)
			{
				
				if(s1.charAt(i-1)==s2.charAt(j-1))
					t[i][j]=t[i-1][j-1];
				else
				{
					/*if(j<=1)
						t[i][j]=t[i-1][j]+del;
					else if(i<=1)
						t[i][j]=t[i][j-1]+add;*/
					//if(i>1&&j>1)
					t[i][j]=minimum(t[i-1][j-1]+rep,t[i][j-1]+add,t[i-1][j]+del);
				}
					
			}
		}
		for(int i=1;i<=s1.length();i++)
		{
			for(int j=1;j<=s2.length();j++)
			{
				System.out.print(t[i][j]+" ");
				
			}
			System.out.println();
		}
		System.out.println(t[s1.length()][s2.length()]);
		int i=s1.length(),j=s2.length();
		while(i>0||j>0)
		{
			if(i>0&&j>0&&t[i][j]==t[i-1][j-1]+rep)
			{
				System.out.println("replace "+s1.charAt(i-1)+" with "+s2.charAt(j-1));
				i--;
				j--;
			}
			else if(i>0&&t[i][j]==t[i-1][j]+del)
			{	System.out.println("delete "+s1.charAt(i-1));
			i--;
			}
			else if(j>0&&t[i][j]==t[i][j-1]+add)
			{	System.out.println("add "+s2.charAt(j-1));
			j--;
			}
			else
			{
				i--;
				j--;
			}
		}
		sc.close();

	}
	static int minimum(int a,int b,int c)
	{
		int min=9999999;
		if(a<min)
		{
			min=a;
		}
		if(b<min)
		{
			min=b;
		}
		if(c<min)
		{
			min=c;
		}
		return min;
	}

}
