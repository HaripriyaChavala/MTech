#include<stdio.h>
main()
{
	int denom[10],count=0,amount,number[10];

	do
	{
		scanf("%d",&denom[count]);
		count++;
		number[count]=0;
	}while(denom[count-1]!=1);
	scanf("%d",&amount);
	int result=0;
	int i=0;
	
	while(result!=amount)
	{
		
		
			number[i]=amount/denom[i];
			amount=amount-number[i]*denom[i];
		
		i++;
	}
	for(i=0;i<count;i++)
	printf("%d:%d,",denom[i],number[i]);
}
		
		

