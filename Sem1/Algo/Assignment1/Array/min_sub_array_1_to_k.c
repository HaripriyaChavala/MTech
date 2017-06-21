#include<stdio.h>
#include<stdlib.h>
main()
{
	int n,i,min,j,k,a[100],pos1,pos2,sum,b[100],c=0,p;
	printf("enter k");
	scanf("%d",&k);
	scanf("%d",&n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	min=n;j=0;
	pos1=0;
	pos2=n-1;
	for(i=0;i<k;i++)
		b[i]=0;
	for(i=0;i<n&&c!=k;i++)
	{
		
		
		if(a[i]<=k&&b[a[i]-1]==0)
			c++;
		if(a[i]<=k)
			b[a[i]-1]++;
		printf("\n");
		for(j=0;j<k;j++)
			printf(" %d ",b[j]);
		printf("c=%d\n",c);

		pos1=0;
		pos2=i;
		min=i+1;
	}
	printf("%d %d\n",pos1,pos2);
	j=0;
	printf("%d",i);
	i=i-1;
	while(i<n)
	{
		
		//printf("%d ",a[i]);
		if(a[j]>k)
			j++;
		else if(b[a[j]-1]>1)
		{	
			b[a[j]-1]--;
			j++;
			
		}
		else
		{
			p=i;
			while(i<n&&a[i]!=a[j])
			{
				if(a[i]<=k)
				b[a[i]-1]++;
				i++;
			}
			if(a[i]==a[j])
				{
					b[a[j]-1]--;
					j++;
				
				}
			if(i==n)
			{
				printf	("p if");
				//printf("min=%d\n",min);
				if(p-j+1<min)
				{
					pos1=p;
					pos2=j;
					min=p-j+1;
				}
				break;
			}	
			
		}
		if(i-j+1<min)
		{
			pos1=i;
			pos2=j;
			min=i-j+1;
		}
		printf("min=%d ,left ele=%d  present ele=%d\n",min,a[j],a[i]);
	}
	printf("\n pos1=%d  pos2=%d",pos1,pos2);	
	for(i=pos2;i<=pos1;i++)
		printf("%d  ",a[i]);
}
		
	
