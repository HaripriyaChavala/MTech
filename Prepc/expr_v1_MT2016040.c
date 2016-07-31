#include<stdio.h>
#include<string.h>
#include<math.h>
main()
{
char expr[100];
int var[100],i=1,j,count=0,result,x;
scanf("%s",expr);
//printf("%s",expr);
scanf("%d",&var[0]);
while(var[count]!=1000)
{
count++;
scanf("%d",&var[count]);

}
//for(i=0;i<count;i++)
//printf("%d\n",var[i]);
	for(i=0;i<count;i++)
	{

	result=(expr[0]=='x'?var[i]:((int)expr[0]-48));
	//printf("%d\n",result);
	for(j=0;j<strlen(expr)-2;j=j+2)
	{
		x=(expr[j+2]=='x')?var[i]:((int)expr[j+2]-48);
		if(expr[j+1]=='+')
		result=result+x;
		else if(expr[j+1]=='-')
		result=result-x;
		else if(expr[j+1]=='*')
		result=result*x;
		else if(expr[j+1]=='/')
		result=result/x;
		else
		result=pow(result,x);
		//printf("%d\n",result);
	}
	printf("P(%d)=%d\n",var[i],result);
}
}
			
