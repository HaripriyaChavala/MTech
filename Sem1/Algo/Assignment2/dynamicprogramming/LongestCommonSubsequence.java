package dynamicprogramming;

import java.util.Scanner;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s1=sc.next();
		String s2=sc.next();
		int m=s1.length()-1;
		int n=s2.length()-1;
		int a[][]=new int[s1.length()][s2.length()];
		for(int i=0;i<s1.length();i++)
		{
			for(int j=0;j<s2.length();j++)
			{
				if(s1.charAt(i)==s2.charAt(j))
				{
					if(i==0||j==0)
					{
						a[i][j]=1;
					}
					else
					{
						a[i][j]=1+a[i-1][j-1];
					}
					
					
				}
				else
				{
					if(i>0&&j>0)
					a[i][j]=a[i-1][j]>a[i][j-1]?a[i-1][j]:a[i][j-1];
					else if(i>0)
					a[i][j]=a[i-1][j];
					else if(j>0)
						{
						//System.out.println("i="+i+"j="+j);
						a[i][j]=a[i][j-1];
						
						}
					else
						a[i][j]=0;
				}
			}
		}
		//int p=a[m-1][n-1];
		while(m>=0&&n>=0&&a[m][n]!=0)
		{
			if(s1.charAt(m)==s2.charAt(n))
			{
				
				System.out.print(s1.charAt(m));
				if(a[m][n]==1)
					break;
				m--;
				n--;
			}
			else if(n-1>=0&&a[m][n]==a[m][n-1])
				n--;
			else
				m--;
		}
		
		
		
		
		
		
		
			
		sc.close();
	}

}
