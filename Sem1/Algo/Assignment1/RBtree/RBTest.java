package RBtree;

public class RBTest {
	public static void main(String args[])
	{
		RBTreeFunctions r=new RBTreeFunctions();
		RBNode p=new RBNode();
		p=r.insertRB(7,null);
		p=r.insertRB(6,p);
		p=r.insertRB(5,p);
		p=r.insertRB(4,p);
		p=r.insertRB(3,p);
		p=r.insertRB(2,p);
		p=r.insertRB(1,p);
		System.out.println("pre order is");
		r.preOrder(p);
		System.out.println("inorder is");
		r.inOrder(p);
		RBNode s=r.searchRB(5,p);
		p=r.deleteRB(s, p);
		System.out.println("pre order is");
		r.preOrder(p);
		System.out.println("inorder is");
		r.inOrder(p);
		
		
	}

}
