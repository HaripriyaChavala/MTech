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
	//l=l+1;
	for(i=0;j<=n;i++)
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
		j++;
		if(i>=l-1)
		{
			printf("%d    ",a[q[first]]);
		}
	}
	//printf("pos=%d  pos2=%d  value=%d",pos1+1,pos2+1,max);
}

