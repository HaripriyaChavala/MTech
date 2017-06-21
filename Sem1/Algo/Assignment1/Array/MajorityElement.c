#include<stdio.h>
main()
{
int n,a[100000],i,A,B,c1,c2;
scanf("%d",&n);
for(i=0;i<n;i++)
scanf("%d",&a[i]);
c1=0;
c2=0;
for(i=0;i<n;i++)
{
if(c1>0&&A==a[i])
	c1++;
else if(c2>0&&B==a[i])
	c2++;
else if(c1==0)
{	c1++;A=a[i];}
else if(c2==0)
{	c2++;B=a[i];}
else
{	c1++;c2++;}

}
c1=0;
c2=0;
for(i=0;i<n;i++)
{
if(A==a[i])
c1++;
else if(B==a[i])
c2++;
}
if(c1>(n/3))
printf("majority element=%d\n",A);
else if(c2>(n/3))
printf("majority element=%d\n",B);
else
printf("No majority element");
}
