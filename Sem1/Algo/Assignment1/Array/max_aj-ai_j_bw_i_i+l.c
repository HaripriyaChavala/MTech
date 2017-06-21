#include<stdio.h>
main()
{
	int n,a[100],q[100],first,last,i,j,max,l,k,pos1,pos2;
	scanf("%d",&n);
	for(i=0;i<n;i++)
	scanf("%d",&a[i]);
	scanf("%d",&l);
	first=-1;
	last=-1;
	max=-1;
	j=1;
	for(i=0;j<n;i++)
	{
		while(first!=last&&q[first]<=j-l-1)
		{
			first++;
		}
		while(first!=last&&a[i]<a[q[last-1]])
		{
			last--;
		}
		if(first==-1&&last==-1)
		{
			first=0;
			last=0;
		}
		q[last++]=i;
		if(a[j]-a[q[first]]>max)
		{
			max=a[j]-a[q[first]];
			pos1=q[first];
			pos2=j;
		}
		j++;
		for(k=first;k<last;k++)
			printf("%d   ",a[q[k]]);
		printf("\n");
	}
	printf("pos=%d  pos2=%d  value=%d",pos1+1,pos2+1,max);
}

