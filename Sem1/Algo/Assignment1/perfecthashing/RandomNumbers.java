package perfecthashing;

import java.io.BufferedWriter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class RandomNumbers {

	public static void generate(int n) {
	  FileOutputStream out = null;
	      try {
		out = new FileOutputStream("/home/haripriya/input.txt");
      	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
	      long x=(long) Math.pow(10,10);
	      long m;
	      for(int i=0;i<n;i++)
        	{
      	  	m=(long) ((Math.random()*x));
      	  	while(m<Math.pow(10,9)-1)
      	  		m=m*10;
      	  		writer.write(m+"\n");
      	  		//System.out.println(m);
      	  		
      	  		
      	  	
        	}
	      writer.close();
	      }
	      catch(Exception e)
	      {
	    	  System.out.println(e);
	      }
		

	}
	public static void main(String args[])
	{
		generate(1000000);
	}

}
