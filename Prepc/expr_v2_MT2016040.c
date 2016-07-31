#include<stdio.h>
#include<string.h>
#include<math.h>
int eval(int,int,char);
main()
{
char expr[100];
int var[100],i=1,j,count=0,result,x,y,flag,l;
scanf("%s",expr);
//printf("%s",expr);
scanf("%d",&var[0]);
while(var[count]!=1000)
{
count++;
scanf("%d",&var[count]);

}
l=strlen(expr);
if(expr[l-1]==')')
l=l-1;
//for(i=0;i<count;i++)
//printf("%d\n",var[i]);
	for(i=0;i<count;i++)
	{

	result=(expr[0]=='x'?var[i]:((int)expr[0]-48));
	//printf("%d\n",result);
	for(j=0;j<l-2;j=j+2)
	{
		flag=1;
		if(expr[0]=='('&&j==0)
		{
			x=(expr[1]=='x')?var[i]:((int)expr[1]-48);
			y=(expr[3]=='x')?var[i]:((int)expr[3]-48);
			result=eval(x,y,expr[2]);
			j=j+4;
			
	
		}
		if(expr[j+2]=='(')
		{
			x=(expr[j+3]=='x')?var[i]:((int)expr[j+3]-48);
			y=(expr[j+5]=='x')?var[i]:((int)expr[j+5]-48);
			x=eval(x,y,expr[j+4]);
			flag=0;
		}
		else	
		x=(expr[j+2]=='x')?var[i]:((int)expr[j+2]-48);
		result=eval(result,x,expr[j+1]);
		if(flag==0)
		j=j+4;
		//printf("%d\n",result);
	}
	printf("P(%d)=%d\n",var[i],result);
}
}
int eval(int a,int b,char op)
{
		if(op=='+')
		a=a+b;
		else if(op=='-')
		a=a-b;
		else if(op=='*')
		a=a*b;
		else if(op=='/')
		a=a/b;
		else
		a=pow(a,b);
		return a;
}
