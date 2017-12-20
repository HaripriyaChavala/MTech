import java.util.*;
class BinarySearchTree
{
	class Node
	{
		Node left;
		int data;
		Node right;
		Node parent;
		Node nextRight;

		Node(int d)
		{
			left=null;
			data=d;
			right=null;
			parent=null;
			nextRight=null;
		}
		Node(){}
		public String toString()
		{
			return this.data+"";
		}
	}
	Node root=null;
	String add(int d)
	{
		Node n=new Node(d);
		if(root==null)
		{
			root=n;
			return ""+d+"";
		}
		Node current=root;
		n.parent=current;
		while(true)
		{
			//if(d<current.data)
			//{
				if(root!=null&&d<current.data&&current.left==null)
				{
					current.left=n;
					break;
				}
				else if(root!=null&&d<current.data&&!(current.left==null))
				{
					n.parent=current.left;
					current=current.left;
					
				}
			//}
			else
			{
				if(current.right==null)
				{
					current.right=n;
					break;
				}
				else
				{
					n.parent=current.right;
					current=current.right;
					
				}
			}
		}
		return inOrder(root);
	}
	/**********************************************************************************************************************/
	void display()
	{
		System.out.println("preorder of tree is:");
		preorder(root);
		System.out.println("");
		System.out.println("preorder in a iterative way of tree is:");
		preorderIterative();
		System.out.println("");
		System.out.println("postorder of tree is:");
		postOrder(root);
		System.out.println("");
		System.out.println("postorder in a iterative way of tree is:");
		postorderIterative(root);
		System.out.println("");
		System.out.println("inorder of tree is:");
		inOrder(root);
		System.out.println("");
		System.out.println("inOrderIteration of tree is:");
		inOrderIterative();
		System.out.println("");
		System.out.println("levelOrder of tree is:");
		levelOrder();
		System.out.println("");
		System.out.println("levelOrder in a recursive way of tree is:");
		levelOrderrec();
		System.out.println("");
		
	}
	void preorder(Node n)
	{
		if(n!=null)
		{
		System.out.print(n.parent+"  ");
		preorder(n.left);
		preorder(n.right);
		}
		else
		{
			
			return;
		}
	}
	void preorderIterative()
	{
		ArrayDeque<Node> st=new ArrayDeque<Node>();
		st.push(root);
		while(st.size()>0)
		{
			Node n=st.pop();
			System.out.print(n.data+"  ");
			if(n.right!=null)
				st.push(n.right);
			if(n.left!=null)
				st.push(n.left);
		}
	}
	String inOrder(Node n)
	{
		if(n!=null)
		{

			/*inOrder(n.left);
			System.out.print(n.data+"  ");
			inOrder(n.right);	*/
			return inOrder(n.left)+n.data+inOrder(n.right);
		}
		else
		{
			
			return "";
		}
	}
	void inOrderIterative()
    {
    	if(root==null)
    		return;
    	Node n=root;
    	ArrayDeque<Node> st=new ArrayDeque<Node>();
    	while(n!=null)
    	{
    		st.push(n);
    		n=n.left;
    	}
    	while(st.size()>0)
    	{
    		Node x=st.pop();
    		System.out.print(x.data+"  ");
    		if(x.right!=null)                                   
    		{
    			x=x.right;
    			while(x!=null)
    			{
    				st.push(x);
    				x=x.left;
    			}
    		}
    	}

    }
	void postOrder(Node n)
	{
		if(n!=null)
		{
			
			postOrder(n.left);
			postOrder(n.right);	
			System.out.print(n.data+"  ");
		}
		else
		{
			
			return;
		}
	}
	//we have three cases for solving it
	//curr=>standing at what pos
	//prev=>from where i have come

	//1. go down the tree, => prev is up and curr is down
	       //left or right(any)[marked by prev.left=curr or prev.right=curr]

	//2. coming up from left => pre
	        //prev is left down and curr is top => curr.left==prev

	//3. coming up from right => prev is right down and curr is top => curr.right==prev
	public String postorderIterative(Node curr)
	{
		Node prev=curr;
		ArrayDeque<Node>st=new ArrayDeque<Node>();
		String result = "";
		if(curr==null)
			return result;
		st.push(curr);

		//1st statement =>curr always peek
		//last statement=> prev always curr

		while(!st.isEmpty())
		{
			curr=st.element();

			// 1. go down
			//if(curr==prev || prev.left==curr|| prev.right==curr)
			//{
				if((curr==prev || prev.left==curr|| prev.right==curr)&&curr.left!=null)
					st.push(curr.left);
				else if((curr==prev || prev.left==curr|| prev.right==curr)&&curr.right!=null)
					st.push(curr.right);
				else if((curr==prev || prev.left==curr|| prev.right==curr)&&curr.left==null && curr.right==null)
				{
					int x = st.pop().data;
					System.out.print(x+"  ");
					result = result+x;
					
				}
			//}
			else if(curr.left==prev) //2. coming up from left=> go right or if no right print and pop
			{
				if(curr.right!=null)
					st.push(curr.right);
				else
				{
					int x = st.pop().data;
					System.out.print(x+"  ");
					result = result+x;
				}
			}	
			else  // 3. coming up from right => all left and right are over =>only print the curr
			{
				int x = st.pop().data;
				System.out.print(x+"  ");
				result = result+x;
			}


			//last statement
			prev=curr;
		}
		return result;

	}
	String FindAncestors(int d)
	{
		System.out.print("Ancestors of node with data "+d+" is: ");
		Node curr=root;
		Node prev=curr;

		ArrayDeque<Node>st=new ArrayDeque<Node>();

		if(curr==null||curr.data==d)
			return "-1";
		st.push(curr);
		String result = "";
		while(!st.isEmpty())
		{
			curr=st.element();

			// 1. go down
			if(curr==prev || prev.left==curr|| prev.right==curr)
			{
				if(curr.left!=null)
					st.push(curr.left);
				else if(curr.right!=null)
					st.push(curr.right);
				else if(curr.left==null && curr.right==null)
				{
					Node temp=st.pop();
					if(temp.data==d)
					{
						
							System.out.println(st);
							ArrayDeque<Node> st1 = st.clone();
							for(int z=0;z<st.size();z++)
							{
								result = result+st1.pollFirst().data;
							}
							System.out.println("result "+result);
							
					}
				}

			}
			else if(curr.left==prev) //2. coming up from left=> go right or if no right print and pop
			{
				if(curr.right!=null)
					st.push(curr.right);
				else
				{
					Node temp=st.pop();
					if((curr.left==prev)&&(curr.right==null)&&temp.data==d)
					{
						
							System.out.println(st);
							ArrayDeque<Node> st1 = st.clone();
							for(int z=0;z<st.size();z++)
							{
								result = result+st1.pollFirst().data;
							}
							System.out.println("result "+result);
					}
		
				}
			}	
			else  // 3. coming up from right => all left and right are over =>only print the curr
			{ 
					Node temp=st.pop();
					if(temp.data==d)
					{
						
							System.out.println(st);
							ArrayDeque<Node> st1 = st.clone();
							for(int z=0;z<st.size();z++)
							{
								result = result+st1.pollFirst().data;
							}
							System.out.println("result "+result);
					}
						
			}


			//last statement
			prev=curr;
		}
		return result;

	}
	
	void levelOrder()
	{
		//BFS
		Queue<Node> level=new LinkedList<Node>();
		level.add(root);
		while(!level.isEmpty())
		{
			Node temp=level.element();
			System.out.print(temp.data+"  ");
			if(temp.left!=null)
				level.add(temp.left);
			if(temp.right!=null)
				level.add(temp.right);
			level.remove();
		}
	}
	int height()
	{
		int x=FindHeight(root);
		return x;
	}
	//the height is w.r.t node. height of the node is number of edges from that node to its leaf node 
	//so if there is only one node its height is zero.
	//thats why at the and return -1;

	//or if for leaf node also if you consider height 1,then if n==null return 0.
	int FindHeight(Node n)
	{
		if(n==null)
		{
			return 0;
		}
		return(1+Math.max(FindHeight(n.left),FindHeight(n.right)));
	}
	void levelOrderrec()
	{
		System.out.println("level order:");
		for(int i=1;i<=height();i++)
		{
			levelOrderR(root,i);
		}
	}
	void levelOrderR(Node n,int i)
	{
		if(n==null)
		{
			return ;
		}
	    if(i==1)
		{
			System.out.print(n.data+"  ");
		}
		else if(i>=1)
		{
			levelOrderR(n.left,i-1);
			levelOrderR(n.right,i-1);
		}

	}
	//int count=0;
	void widthOfTree()
	{
		//int count=0;
		int max=0;
		int count=0;
		for(int i=1;i<=height();i++)
		{
			
			count=levelOrderForWidthOfTree(root,i);
			//System.out.println("i:"+i+" count="+count);
			if(max<count)
				max=count;
			count=0;
		}
		System.out.println("width of a tree: "+max);
	}
	int levelOrderForWidthOfTree(Node n,int i)
	{
		
		if(n==null)
		{
			return 0;
		}
	    if(i==1)
		{
			return 1;
		}		
		else if(i>=1)
		{
			int a=levelOrderForWidthOfTree(n.left,i-1);
			int b=levelOrderForWidthOfTree(n.right,i-1);
			//System.out.println(a+b);
			return a+b;
		}
		return 0;

	}

	void diameter()
	{
		int x=FindDiameter(root);
		System.out.println("Diameter:"+x);
	}
	int FindDiameter(Node n)
	{
		if(n==null)
			return 0;
		int lHeight=FindHeight(n.left);
		int rHeight=FindHeight(n.right);

		int lDiameter=FindDiameter(n.left);
		int rDiameter=FindDiameter(n.right);

		return Math.max((1+lHeight+rHeight),Math.max(lDiameter,rDiameter));
	}
	void size()
	{
		
		int x=findSize(root);
		System.out.println("size:"+x);
		
	}
	int findSize(Node n)
	{
		if(n!=null)
		{
			return(1+findSize(n.left)+findSize(n.right));
		
		}
		return 0;
	}
	void printKthLevelNodes(int k)
    {
    	if(k>=1 && k<=height())
    	{
    		levelOrderR(root,k);
    	}
    	else
    		System.out.println("not Posiible");
    }

    public String connectNodesAtLevel()
	{
		getWidth(root);
		Node current=root;
		ArrayList<Node> list=new ArrayList<Node>();

		
		String result = "";
		System.out.println("connecting nodes at each level:");
		for(int i=1;i<=height();i++)
		{
			Node first=levelOrderForConnectingNodes(root,i);
			while(first!=null)
			{
				System.out.print(first.data+"  ");
				result = result+first.data;
				first=first.nextRight;
			}
			System.out.println("");	
			
		}

		return result;
	}
	Node levelOrderForConnectingNodes(Node n,int i)
	{
		if(n==null)
		{
			return null;
		}
	    if(i==1)
		{
			return n;
		}
		else if(i>=1)
		{
			if(n!=null&&i>=1&&n.left!=null)
			{
				return levelOrderForConnectingNodes(n.left,i-1);
			}
			else if(n.right!=null)
			{
				 return levelOrderForConnectingNodes(n.right,i-1);
			}
			else
			{
				return levelOrderForConnectingNodes(n.nextRight,i);
			}
		}
		return null;

	}
	
	public void getWidth(Node curr)
	{
		if(curr==null)
			return;

		ArrayDeque<Node>q1=new ArrayDeque<Node>();
		q1.add(curr);
		Node prevMark,currMark=curr;
		//System.out.print(1+" ");
		//int maxNodes=1;
		while(!q1.isEmpty())
		{
			Node front=q1.getFirst();
			prevMark=currMark;
			if(front.left!=null)
				q1.add(front.left);
			if(front.right!=null)
				q1.add(front.right);

			Node temp=q1.remove();
			if(temp==prevMark) //end of lvele
			{
				if(!q1.isEmpty())
				currMark=q1.getLast();

				temp.nextRight=null;
			}
			else
			{
				temp.nextRight=q1.getFirst();
			}

		}
	}
	boolean isSubtree(Node n,Node s)
	{
		if(s==null)
			return true;
		if(n==null)
			return false;
		if(equalization(n,s))
			return true;
		else
			return(isSubtree(n.left,s)||isSubtree(n.right,s));
	}
	boolean equalization(Node n,Node s)
	{
		if(n!=null && s!=null)
		{
			if(n.data==s.data)
			{
				return(equalization(n.left,s.left) && equalization(n.right,s.right));
			}
			else
				return false;
		}
		else if(n==null && s==null)
			return true;
		else
			return false;
	}
	/***************************************************************************************************************************/

	boolean search(int d)
	{
		Node current=root;
		while(current!=null)
		{
			if(d==current.data)
				return true;
			if(d<current.data)
				current=current.left;
			else
				current=current.right;
		}
		return false;
	}
	//recursive way for searching.
	Node searchR(int d)
	{
		Node s=searchRecursive(root,d);
		return s;
	}
	Node searchRecursive(Node current,int d)
	{
		if(current==null)
			return null;
		if(d==current.data)
			return current;
		else if(d<current.data)
			return searchRecursive(current.left,d);
		else
			return searchRecursive(current.right,d);
	}
	String remove(int d)
	{
		Node current=searchR(d);
		Node currentParent=current.parent;
		//if given node is not present in the tree
		if(current==null)
			return "-1";
		//if given node is the leaf node
		if(current!=null&&current.left==null && current.right==null)
		{
			if(currentParent!=null)
			{
				if(currentParent.left==current)
					currentParent.left=null;
				else
					currentParent.right=null;
			}
			else //parent is null means node is root
			{
				root=null;
			}
			
		}
		//if given node has only child
		else if(current!=null&&(current.left==null||current.right==null))
		{
			if(currentParent!=null)
			{
				if(current.left==null)
				{
					if(currentParent.left==current)
					{
						currentParent.left=current.right;
						current.right.parent=currentParent;
					}
					else
					{
						currentParent.right=current.right;
						currentParent.right.parent=currentParent;
					}
				}
				else
				{
					if(currentParent.left==current)
					{
						currentParent.left=current.left;
						current.left.parent=currentParent;
					}
					else
					{
						currentParent.right=current.left;
						current.left.parent=currentParent;
					}
				}
			}
			else //node is root;
			{
				if(current.left!=null)
				{
					root=current.left;
					current.left.parent=null;
				}
				if(current.right!=null)
				{
					root=current.right;
					current.right.parent=null;
				}
			}
		}
		else //node have two children
		{
			Node inorderSuccessor=inorderSuccessor(current.data);
			current.data=inorderSuccessor.data;
			if(inorderSuccessor.right!=null)
			{
				if(inorderSuccessor.parent==current)
				{
					current.right=inorderSuccessor.right;
					inorderSuccessor.right.parent=current;
				}
				else
				{
					inorderSuccessor.parent.left=inorderSuccessor.right;
					inorderSuccessor.right.parent=inorderSuccessor.parent;
				}
			}
			else
			{
				if(inorderSuccessor.parent==current)
				{
					current.right=null;
				}
				else
				{
					inorderSuccessor.parent.left=null;
				}
			}
			
		}
		if(root==null)
			return "-1";
		return inOrder(root);

	}
	String FindAncestorsRec(int d)
	{
		System.out.print("Ancestors of node with data "+d+" is: ");
		Node curr=root;
		Node prev=curr;

		ArrayDeque<Node>st=new ArrayDeque<Node>();

		if(curr==null||curr.data==d)
			return "-1";
		st.push(curr);
		String result = "";
		while(!st.isEmpty())
		{
			curr=st.element();

			// 1. go down
			if(curr==prev || prev.left==curr|| prev.right==curr)
			{
				if(curr.left!=null)
					st.push(curr.left);
				else if(curr.right!=null)
					st.push(curr.right);
				else if(curr.left==null && curr.right==null)
				{
					Node temp=st.pop();
					if(temp.data==d)
					{
						
							System.out.println(st);
							ArrayDeque<Node> st1 = st.clone();
							for(int z=0;z<st.size();z++)
							{
								result = result+st1.pollFirst().data;
							}
							System.out.println("result "+result);
							
					}
				}

			}
			else if(curr.left==prev) //2. coming up from left=> go right or if no right print and pop
			{
				if(curr.right!=null)
					st.push(curr.right);
				else
				{
					Node temp=st.pop();
					if((curr.left==prev)&&(curr.right==null)&&temp.data==d)
					{
						
							System.out.println(st);
							ArrayDeque<Node> st1 = st.clone();
							for(int z=0;z<st.size();z++)
							{
								result = result+st1.pollFirst().data;
							}
							System.out.println("result "+result);
					}
		
				}
			}	
			else  // 3. coming up from right => all left and right are over =>only print the curr
			{ 
					Node temp=st.pop();
					if(temp.data==d)
					{
						
							System.out.println(st);
							ArrayDeque<Node> st1 = st.clone();
							for(int z=0;z<st.size();z++)
							{
								result = result+st1.pollFirst().data;
							}
							System.out.println("result "+result);
					}
						
			}


			//last statement
			prev=curr;
		}
		return result;

	}
	void findInordersuccessor(int d)
	{
		Node current=inorderSuccessor(d);
		if(current!=null)
			System.out.println("inorderSuccessor: "+current.data);
		else
			System.out.println("no inorderSuccessor");
	}
	Node inorderSuccessor(int d)
	{
		Node current=searchR(d);
		Node inorderSuccessor=current.right;
		if(inorderSuccessor!=null)
		{
			while(inorderSuccessor.left!=null)
			{
				inorderSuccessor=inorderSuccessor.left;
			}
		}
		return inorderSuccessor;
	}
	void findInorderpredecessor(int d)
	{
		Node current=inorderPredecessor(d);
		if (current!=null)
			System.out.println("inorderPredecessor: "+current.data);
		else
			System.out.println("no inorderPredecessor");
	}
	Node inorderPredecessor(int d)
	{
		Node current=searchR(d);
		Node inorderPredecessor=current.left;
		if(inorderPredecessor!=null)
		{
			while(inorderPredecessor.right!=null)
			{
				inorderPredecessor=inorderPredecessor.right;
			}
		}
		return inorderPredecessor;
	}
	Node minimum()
	{
		Node current=root;
		if(root==null)
		{
			System.out.println("no minimum coz tree is empty");
			return null;
		}
		while(current.left!=null)
		{
			current=current.left;
		}
		System.out.println("minimum node data of this tree is:"+current.data);
		return current;
	}
	Node maximum()
	{
		Node current=root;
		if(root==null)
		{
			System.out.println("no maximum coz tree is empty");
			return null;
		}
		while(current.right!=null)
		{
			current=current.right;
		}
		System.out.println("maximum node data of this tree is:"+current.data);
		return current;
	}
	int depthOfTheNode(int d)
	{
		Node current=searchR(d);
		int count=0;
		while(current.parent!=null)
		{
			count++;
			current=current.parent;
		}
		return count;
	}
	int LowestCommonAncestor(int n1,int n2)
	{
		Node current=FindLCA(n1,n2);
		if(current!=null)
			return current.data;
		else
			return -10000000;
	}
	Node FindLCA(int n1,int n2)
	{
		Node node1=searchR(n1);
		Node node2=searchR(n2);
		if(node1!=null && node2!=null)
		{
			int d1=depthOfTheNode(n1);
			int d2=depthOfTheNode(n2);
			if(d1>d2)
			{
				int diff=d1-d2;
				for(int i=1;i<=diff;i++)
				{
					node1=node1.parent;
				}
			
			}
			else if(d2>d1)
			{
				int diff=d2-d1;
				for(int i=1;i<=diff;i++)
				{
					node2=node2.parent;
				}
			}
			while(node1!=node2)
			{
				node1=node1.parent;
				node2=node2.parent;
			}
			return node1;
		}
		else
			return null;
	}
	int KthSmallestElement(int k)
	{
		Node current=FindKthSmallestElement(k);
		if(current!=null)
		{
			return current.data;
		}
		else 
			return -10000000;
	}
	Node FindKthSmallestElement(int k)
	{
		//inorder iterative!!!!!!!!!!!!!!!!!!
		if(root==null)
    		return null;
    	Node n=root;
    	ArrayDeque<Node> st=new ArrayDeque<Node>();
    	while(n!=null)
    	{
    		st.push(n);
    		n=n.left;
    	}
    	if(k<=findSize(root))
    	{
    		while(k>1)
    		{
    			Node x=st.pop();
    			//System.out.print(x.data+"  ");
    			if(x.right!=null)
    			{
    				x=x.right;
    				while(x!=null)
    				{
    					st.push(x);
    					x=x.left;
    				}
    			}
    			k--;
    		}
    		Node x=st.pop();
    		return x;
		}
		else 
			return null;
    	
	}
	void InorderOfBothBST(Node root1,Node root2)
	{
		System.out.println("soretd order of both input binary search tree:");
		if(root1==null && root2==null)
			return;
		Node n1=root1,n2=root2;
		ArrayDeque<Node> st1=new ArrayDeque<Node>();
		ArrayDeque<Node> st2=new ArrayDeque<Node>();
		//you have to add bottom node biggest one so that even one
		//stack gets empty other stack can compare with that bottom
		//element
		Node bottom=new Node(100000);
		st1.push(bottom);
		st2.push(bottom);
    	while(n1!=null)
    	{
    		st1.push(n1);
    		n1=n1.left;
   		}	
    	while(n2!=null)
   		{
   	    	st2.push(n2);
   			n2=n2.left;
   		}
   		while(st1.size()>0||st2.size()>0)
   		{
   			Node x1=st1.peek();
   			Node x2=st2.peek();
   			//System.out.println("x1.data:"+x1.data+" x2.data:"+x2.data);
   			if(x1!=null && x2!=null)
   			{
   				if(x1.data<=x2.data)
   				{
   					if(x1.data==100000 && x2.data==100000)
   					{
   						System.out.println("");
   						break;
   					}
   					else
   					{
						Node y1=st1.pop();
						if(y1!=bottom)
	    					System.out.print(y1.data+"  ");
    					if(y1.right!=null)                                   
    					{
	    					y1=y1.right;
    						while(y1!=null)
    						{
    							st1.push(y1);
    							y1=y1.left;
		    				}
    					}
   					}
   				}
   				else if(x1.data>x2.data)
	   			{
   					Node y2=st2.pop();
    				System.out.print(y2.data+"  ");
    				if(y2.right!=null)                                   
    				{
	    				y2=y2.right;
    					while(y2!=null)
    					{
    						st2.push(y2);
    						y2=y2.left;
    					}
	    			}
   				}
   			}
   			else
   			{
   				System.out.println("");
   				break;	
   			}
   			
	   	}
	}
	int ceil(int d)
	{
		return ceil(root,d);
	}
	int ceil(Node current,int d)
	{
		if(current==null)
			return -1;
		if(current.data==d)
			return current.data;
		if(current.data<d)
			return ceil(current.right,d);
		if(current.data>d)
		{
			int x=ceil(current.left,d);
			return (x>=d) ? x:current.data;
		}
		return -1;
	}
	int floor(int d)
	{
		return floor(root,d);
	}
	int floor(Node current,int d)
	{
		if(current==null)
			return Integer.MAX_VALUE;
		if(current.data==d)
			return current.data;
		if(current.data>d)
			return floor(current.left,d);
		if(current.data<d)
		{
			int x=floor(current.right,d);
			return (x<=d) ? x : current.data;
		}
		return Integer.MAX_VALUE;
	}

}

