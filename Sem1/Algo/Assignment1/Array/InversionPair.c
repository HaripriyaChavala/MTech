#include<stdio.h>
int InversionPair(int[],int,int);
int Merge(int[],int,int,int);
int n;
main()
{
	int i,a[100000],c;
	scanf("%d",&n);
	for(i=0;i<n;i++)
	scanf("%d",&a[i]);
	c=InversionPair(a,0,n-1);
	printf("%d",c);
}



int InversionPair(int a[100000],int i,int j)
{
	/*printf("\n");
	for(int x=0;x<n;x++)
		printf("%d  ",a[x]);
	printf("\n");*/
	int k,c;
	if(j-i==1)
	{
		if(a[i]>a[j])
		{
			int temp;
			temp=a[i];
			a[i]=a[j];
			a[j]=temp;
			return 1;
		}
		else
		return 0;
	}
	if(j==i)
		return 0;
	k=(i+j)/2;
	c=InversionPair(a,i,k)+InversionPair(a,k+1,j);
	//printf("\nc afetr addition =%d\n",c);
	c=c+Merge(a,i,k,j);
	//printf("\nc after merge %d\n",c);
	//for(int x=i;x<=j;x++)
	//	printf("%d   ",a[x]);		
	
	return c;
}
int Merge(int a[100000],int i,int k,int j)
{
	/*printf("\nin merge function\n");
	for(int x=i;x<=k;x++)
	printf("%d",a[x]);
	printf("\n");
	for(int x=k+1;x<=j;x++)
		printf("%d",a[x]);
	printf("\n");*/
	int c,l,p,r,b[100000];
	c=0;
	l=i;
	r=k+1;
	p=0;
	while(l<=k&&r<=j)
	{
		if(a[l]<=a[r])
		{
			b[p++]=a[l++];
		}
		else if(a[l]>a[r])
		{
			c=c+k-l+1;
			b[p++]=a[r++];
		}
	}
	while(l<=k)
		b[p++]=a[l++];
	while(r<=j)
		b[p++]=a[r++];
	for(l=i;l<=j;l++)
	{
		a[l]=b[l-i];
	}
	//printf("\n c in merge function %d\n",c);
	return c;
}	
