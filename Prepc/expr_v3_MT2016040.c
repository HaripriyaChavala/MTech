	#include<stdio.h>
#include<string.h>
#include<math.h>
int top1=-1;
int top2=-1;
/*int isEmpty(char s[100]);
void push(char s[100],char c);
char pop(char s[100]);*/
int evaluate(int a,int b,char c);
int precedence(char a);

main()
{
	char expr[100],opr,op[100],x,y,z,y1;
	int var[10000],val[100],i=-1,i1=0,p1;
	scanf("%s",expr);	
	do
	{
	i++;
	scanf("%d",&var[i]);
	
	}while(var[i]!=1000);
	//printf("hello\n");
	while(var[i1]!=1000)
	{
		top1=-1;
		top2=-1;
		 i=0;
		while(1)
		{
			if(expr[i]=='\0')
			{
				while(top2!=-1)
				{
					x=val[top1--];
					y=val[top1--];
					opr=op[top2--];
					val[++top1]=evaluate(y,x,opr);
					
				}
			break;
			}

			if(expr[i]=='(')
				op[++top2]='(';
			else if(expr[i]==')')
			{
				while(op[top2]!='(')
				{
					x=val[top1--];
					y=val[top1--];
					opr=op[top2--];
					val[++top1]=evaluate(y,x,opr);
				}
				top2--;
			}
			else if(expr[i]>='0'&&expr[i]<='9')
			{
				p1=(int)expr[i]-48;
				while(expr[i+1]!='\0'&&expr[i+1]>='0'&&expr[i+1]<='9')
				{
					p1=p1*10+(int)expr[i+1]-48;
					i++;
				}			
				val[++top1]=p1;
			}
			else if(expr[i]=='x')
				val[++top1]=var[i1];
			else
			{
				if(top2!=-1 && (precedence(expr[i])>precedence(op[top2])) )
				{
					op[++top2]=expr[i];	
					
				}				
					
				else if(top2==-1)
					op[++top2]=expr[i];					
				else
				{
					char y1=expr[i];
					while(top2!=-1 && (precedence(y1)<=precedence(op[top2])))
					{
						x=val[top1--];
						y=val[top1--];
						opr=op[top2--];
						val[++top1]=evaluate(y,x,opr);
					}
					op[++top2]=expr[i];
				}
			}
			i++;
			//printf("expr[i]=%c\n stck top=%d\n opera top = %c\n",expr[i-1],val[top1],op[top2]);
		}
		printf("P(%d)=%d\n",var[i1],(int)val[top1]);
		i1++;
	}
		
	
	
}

/*int isEmpty(char s[100])
{
	if(top==-1)
		return 1;
	return 0;
}
void push(char s[100],char c)
{
	s[++top]=c;
}
char pop(char s[100])
{
	return(s[top--]);
}*/
int evaluate(int a,int b,char c)
{
	if(c=='+')
		return a+b;
	else if(c=='-')
		return a-b;
	else if(c=='*')
		return a*b;
	else if(c=='/')
		return a/b;
	else
		return pow(a,b);
}
int precedence(char a)
{
if(a=='(')
return 0;
else if(a=='-')
return 1;
else if(a=='+')
return 1;
else if(a=='*')
return 2;
else if(a=='/')
return 2;
else
return 3;
}
























		



