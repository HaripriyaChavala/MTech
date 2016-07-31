class Token
{
String text;
int type;
}
public class Tokenizer
{
RandomAccessFile f;
long ptr;
public Tokenizer(RandomAccessFile f)
{
this.f=f;
ptr=0;
}
Token getNextToken()
{
	char c=f.readChar();
	while(c==' ')
	{
		f.seek(ptr+1);
		c=f.readChar();
		ptr++;
	}
	if(Character.isLetter(c))
	{
		String s="";
		while(Character.isLetter(c))
		{
			s=s+c;
			f.seek(ptr+1);
			c=f.readChar();
			ptr++;
		}
		return Token(s);
	}
	ptr++;
	return Token(""+c);
}
