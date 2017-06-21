#include<stdio.h>
#include<stdlib.h>
void sort(int[],int);
main()
{
	int n,i,l,r,k,a[100];
	scanf("%d",&n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	sort(a,n);
	
	for(k=0;k<n;k++)
	{
		l=0;
		r=n-1;
		
		while(l<=r)
		{
			if(a[l]+a[r]==a[k])
			{
				printf("true");
				printf("%d + %d = %d",a[l],a[r],a[k]);
				exit(0); 
			}
			else if(a[l]+a[r]<a[k])
				l++;
			else
				r--;
		}
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
