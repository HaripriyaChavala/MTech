#include<stdio.h>
#include<stdlib.h>
main()
{
	int n,i,max,j,a[100];
	scanf("%d",&n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	max=-1;
	i=0;
	for(j=1;j<n;j++)
	{
		if(a[j]-a[i]>max)
			max=a[j]-a[i];
		if(a[j]<a[i])
			i=j;
	}
	printf("%d",max);
}
	
