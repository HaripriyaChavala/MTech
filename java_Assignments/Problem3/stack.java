//package home.haripriya.workspace.src.problem21;
import java.lang.*;

public class stack
{
	Node head;
	int len;
	public stack()
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

	

	public void push(Object obj)
	{
		Node obj1=new Node(obj.toString());
		obj1.setNextLink(head);
		head=obj1;
		
	}



	public String pop()
	{
		String content=head.getData();
		head=head.getNextLink();
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
		stack bookList = new stack();
		System.out.println(bookList);
		bookList.push("Harry Potter I");
		bookList.push(1);
		System.out.println(bookList);
		bookList.push("Hamlet");
		bookList.push("LISP");
		bookList.push("Java");
		bookList.push("Cosmos");
		System.out.println(bookList);
		bookList.pop();
		System.out.println(bookList);
		//int n=bookList.find("LISP");
		//System.out.println(n);
		//System.out.println("size = "+bookList.size());
		//System.out.println("the element in pos 2 is"+bookList.get(3).toString());
		
	}



}
class Node
{
	String data;
	Node nextLink;
	public Node(String d)
	{
		this.data=d;
		this.nextLink=null;
			
	}

	void setData(String d)
	{
		this.data=d;
	}
	String getData()
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
