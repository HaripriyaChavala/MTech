import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class TreeTest {

	@Test
	public void testMain() {
		
	Scanner sc = new Scanner(System.in);
	BinarySearchTree obj = new BinarySearchTree();
	while(true)
	{
		/*System.out.println("1.add");
		System.out.println("2.remove");
		System.out.println("3.post order iterative");
		System.out.println("4.connect nodes at level");
		System.out.println("5.find ancestors");
		
		System.out.println("enter your choice");*/
		
		int ch = sc.nextInt();
		if(ch==6)
			break;
		String originalOutput = "";
		switch(ch)
		{
			case 1://System.out.println("enter element to add");
					int x = sc.nextInt();
					originalOutput = obj.add(x);
					break;
			case 2://System.out.println("enter element to remove");
				x = sc.nextInt();
			originalOutput = obj.remove(x);
			break;
			case 3 : originalOutput = obj.postorderIterative(obj.root);
					break;
			case 4:originalOutput = obj.connectNodesAtLevel();
					break;
			case 5 : //System.out.println("enter node that you want to find ancestors");
				x = sc.nextInt();
				originalOutput = obj.FindAncestors(x);
				break;
		}
		//System.out.println("want to test enter 1 just to call method enter 0");
		int choice = sc.nextInt();
		
		if(choice == 1)
		{
			//System.out.println("enter expected output");
			String expectedOutput = sc.next();
			/*System.out.println("orig"+originalOutput);
			System.out.println("exp"+expectedOutput);
			System.out.println(originalOutput.equals(expectedOutput));*/
			assertEquals("success",originalOutput,expectedOutput);
		}
		
		
		
		
		
		
		
		
		
		
	}
		
		
		
	
	
	
	

	
	
	
	
	}
	
	
	

}
