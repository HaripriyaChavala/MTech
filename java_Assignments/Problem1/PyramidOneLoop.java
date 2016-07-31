package Problem2;

public class PyramidOneLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="";
		for(int i=0;i<10;i++)
		{
			StringBuffer sb=new StringBuffer(str);
			System.out.println(str+i+sb.reverse().toString());
			str=str+i;

	}

}
}

