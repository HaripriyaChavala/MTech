package test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;
import parser.JSONObject;
import parser.JSONParser;
public class TokenizerTester
{
public static void main(String args[]) throws FileNotFoundException
{
/*JSONParser ob = new JSONParser("{\"name\":\"hari\",\"age\":\"25\","
+ "\"bfriend\":[\"priya\",\"nishant\",\"sri\"]}");*/
	File f=new File("/home/haripriya/workspace/JSON Parser/src/parser/java.txt");
	String text=new Scanner(f).useDelimiter("\\z").next();
	JSONParser ob=new JSONParser(text);
List<JSONObject> l = ob.getObjectList();
for(JSONObject i:l)
System.out.println(i);


}
}