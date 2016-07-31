//package stack;

//package home.haripriya.workspace.src.problem21;
//import java.lang.*;
import java.util.*;
//import java.io.*;

public class Stack_Par<T>
{
	Node head;
	int len;
class Node
{
	T data;
	Node nextLink;
	public Node(T d)
	{
		this.data=d;
		this.nextLink=null;
			
	}

	void setData(T d)
	{
		this.data=d;
	}
	public T getData()
	{
		return this.data;
	}
	void setNextLink(Node n)
	{
		this.nextLink=n;
	}
	Node getNextLink()
	{
		return this.nextLink;
	}
}





	public Stack_Par()
	{
		head=null;
		len=0;
	}
	public boolean isEmpty()
	{
		if(head==null)
			return true;
		return false;
	} 

	

	public void push(T obj)
	{
		Node obj1=new Node(obj);
		obj1.setNextLink(head);
		head=obj1;
		
	}



	public T pop()
	{
		T content=head.getData();
		head=head.getNextLink();
		//System.out.println(content.toString());
		return content;
	}

	public String toString()
	{
		Node temp=head;
		String s="";
		while(temp!=null)
		{
		s=s+temp.getData()+"->";
		temp=temp.getNextLink();
		}
		return s;	
	}
			
		
	
	
	public static void main(String args[])
	{
		Stack_Par<Character> stack = new Stack_Par<Character>();
		System.out.println("enter the expression");
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='{'||s.charAt(i)=='['||s.charAt(i)=='(')
				stack.push(s.charAt(i));
			else 
			{
				if(stack.isEmpty())
				{System.out.println("not balanced");System.exit(1);}
				char c=stack.pop();
				if((s.charAt(i)==')'&&c!='(')||(s.charAt(i)=='}'&&c!='{')||(s.charAt(i)==']'&&c!='['))
				{
					System.out.println("Not balanced");System.exit(1);
				}
			}
		}

		System.out.println("Balanced");		
				
			
	}



}

