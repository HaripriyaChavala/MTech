#include<stdio.h>
main()
{
	int denom[10],count=0,amount[1000],number[10],num[10],x,c=-1,i1=0;
	char y;

	do
	{
		scanf("%d%c%d",&denom[count],&y,&num[count]);
		count++;
		number[count]=0;
	}while(denom[count-1]!=1);
	do
	{
	c++;
	scanf("%d",&amount[c]);
	
	}while(amount[c]!=-1)
	
	int i=0;
	while(amount[i1]!=-1)
	{
		int result=0;
		while(result!=amount[i1]&&i<count)
		{
		
		
			x=amount[i1]/denom[i];
			if(x<=num[i])
			{
				amount[i1]=amount[i1]-x*denom[i];
				num[i]=num[i]-x;
				number[i]=x;
			}
			else
			{
				amount[i1]=amount[i1]-num[i]*denom[i];
				number[i]=num[i];
				num[i]=0;
			}
		
			i++;
		}
		for(i=0;i<count;i++)
		printf("%d:%d,",denom[i],number[i]);
	}
}
		
		

