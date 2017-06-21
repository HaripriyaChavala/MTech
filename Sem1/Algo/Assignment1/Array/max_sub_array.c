#include<stdio.h>
#include<stdlib.h>
main()
{
	int n,i,max,j,a[100],pos1,pos2,sum;
	scanf("%d",&n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	sum=0;
	i=0;
	max=a[0]+a[1];
	for(j=0;j<n;j++)
	{
		sum=sum+a[j];
		if(sum>max)
		{
			max=sum;
			pos1=i;
			pos2=j;
		}
		if(sum<0)
		{
			i=j+1;
			sum=0;
		}
	}
	printf(" %d to %d ,sum = %d ",pos1,pos2,max);

}
	
