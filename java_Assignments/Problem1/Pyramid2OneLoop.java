package Problem2;

public class Pyramid2OneLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="";
		String s="          ";
		for(int i=0;i<10;i++)
		{
		
			StringBuffer sb=new StringBuffer(str);
			
			
			System.out.println(s+str+i+sb.reverse().toString());
			str=str+i;
			s=s.substring(0,s.length()-1);
			

	}

}
}

