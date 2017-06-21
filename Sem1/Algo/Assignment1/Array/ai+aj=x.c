#include<stdio.h>
#include<stdlib.h>
void sort(int[],int);
main()
{
	int n,i,x,l,r,a[100];
	printf("enter x");	
	scanf("%d",&x);
	scanf("%d",&n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	sort(a,n);
	l=0;
	r=n-1;
	while(l<=r)
	{
		if(a[l]+a[r]==x)
		{
			printf("true");
			exit(0);
		}
		else if(a[l]+a[r]<x)
			l++;
		else
			r--;
	}
	printf("false");
}
void sort(int a[100],int n)
{
int c,d,swap;
for (c = 0 ; c < ( n - 1 ); c++)
  {
    for (d = 0 ; d < n - c - 1; d++)
    {
      if (a[d] > a[d+1]) /* For decreasing order use < */
      {
        swap       = a[d];
        a[d]   = a[d+1];
        a[d+1] = swap;
      }
    }
  }
}
