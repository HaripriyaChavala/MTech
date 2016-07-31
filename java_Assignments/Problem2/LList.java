//package home.haripriya.workspace.src.problem21;
import java.lang.*;

public class LList
{
	Node head;
	int len;
	public LList()
	{
		head=null;
		len=0;
	}


	public void append(Object obj)
	{
		Node obj1=new Node(obj.toString());
		Node temp=head;
		if(head==null)
			head=obj1;
		else
			{
				while(temp.getNextLink()!=null)
					temp=temp.getNextLink();
				obj1.setNextLink(temp.getNextLink());
				temp.setNextLink(obj1);
			}
			
			

	}



	public void insert(int pos, Object obj)
	{
		Node obj1=new Node(obj.toString());
		Node temp=head;
		if(pos>len)
			System.out.println("Can't insert in that position");
		else
		{
			if(head==null)
			head=obj1;
			else if(pos==0)
			{
				obj1.setNextLink(temp);
				head=obj1;
			}

			else
			{
				for(int i=1;i<pos;i++)
					temp=temp.getNextLink();
				obj1.setNextLink(temp.getNextLink());
				temp.setNextLink(obj1);
			}
			len++;
		}	

	}



	public void remove(int pos)
	{
		Node temp;
		if(pos==0||pos>len)
			System.out.println("Cannot remove element");
		else if(pos==1)
		head=head.getNextLink();
		
		else
		{
			temp=head;
			for(int i=0;i<pos-1;i++)
			temp=temp.getNextLink();
			temp.setNextLink(temp.getNextLink().getNextLink());
		}
	}

	public Object get(int pos)
	{
		Node temp=head;
		if(pos>len)
		System.out.println("No nodes present in that position");
		for(int i=1;i<=pos;i++)
		temp=temp.getNextLink();
		return temp;
	}

	public int find(Object obj)
	{
		Node temp=head;
		int pos=1;
		//System.out.println(obj.toString());
		while(temp!=null)
		{
			
			if(temp.data.equals(obj.toString()))
			{
			return pos;
			}
			temp=temp.getNextLink();
			pos=pos+1;
		}
		return 0;
	}
			
		
	void clear()
	{
		head=null;
		len=0;
	}
			
	public int size()
	{
		return len;
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
		LList bookList = new LList();
		System.out.println(bookList);
		bookList.append("Harry Potter I");
		System.out.println(bookList);
		bookList.insert(0,"Hamlet");
		bookList.insert(0,"LISP");
		bookList.insert(0,"Java");
		bookList.insert(0,"Cosmos");
		System.out.println(bookList);
		bookList.remove(1);
		System.out.println(bookList);
		int n=bookList.find("LISP");
		System.out.println(n);
		System.out.println("size = "+bookList.size());
		
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
