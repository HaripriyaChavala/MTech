//package home.haripriya.workspace.src.problem21;
import java.lang.*;

public class Stack_Generics<T>
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





	public Stack_Generics()
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
		System.out.println(content.toString());
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
		Stack_Generics<String> bookList = new Stack_Generics<String>();
		System.out.println(bookList);
		bookList.push("Harry Potter I");
		//bookList.push(1);
		System.out.println(bookList);
		bookList.push("Hamlet");
		bookList.push("LISP");
		bookList.push("Java");
		bookList.push("Cosmos");
		String x=bookList.pop().toString();
		System.out.println(bookList);
		
		System.out.println(x);
		
		
	}



}

