#include<stdio.h>
#include<stdlib.h>
main()
{
	int n,i,max,j,a[100],l;
	scanf("%d",&l);
	scanf("%d",&n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	max=-1;
	i=0;
	for(j=l;j<n;j++)
	{
		if(a[j]-a[i]>max)
			max=a[j]-a[i];
		if(a[j-l]<a[i])
			i=j-l;
	}
	printf("%d",max);
}
	
