#include<stdio.h>
#include<stdlib.h>
#include<time.h>
long long int size_N;
int divide(int[1000000],int);
main()
{
	srand(time(NULL));
	int m=100,flag=0,n,p,j,x;
	long long int i;
	int *f;
	int n1;
	int N[1000000];
	FILE *fp;
	f=(int *)malloc(sizeof(int)*6*m);
	f[0]=0;
	f[1]=1;
	n=2;
	while(flag==0)
	{
		f[n]=(f[n-1]+f[n-2])%m;
		if(f[n]==1&&f[n-1]==0)
		{
			p=n-1;
			flag=1;
		}
		n++;
	}
	//printf("%d",p);
	//fp=fopen("input.txt","w+");
	/*for(i=0;i<1000;i++)
	{
		n=(int)rand()%10;
		n=n%10;
		fprintf(fp,"%d",n);
	}
	i=0;
	fseek(fp,0,SEEK_SET);
	while(!feof(fp))
	{
		fscanf(fp,"%d",&n);
		N[i++]=n;
	}*/
	printf("enter size");
	scanf("%lld",&size_N);
	if(size_N<=0||size_N>1000000)
	{
		printf("invalid size");
		exit(0);
	}
	N[0]=(int)rand()%9+1;
	for(i=1;i<size_N;i++)
	{
	
			n1=(int)rand()%10;
			N[i++]=n1;
	}
	//for(j=0;j<i;j++)
	//	printf("%d",N[j]);

	x=divide(N,p);
	
	printf("f= %d",f[x]);

		
}
int divide(int N[1000000],int p)
{
	long long int i,j;
	int num,rem;
	i=0;
	num=0;
	
	while(num<p&&i<size_N)
	{
		num=num*10+N[i++];
	}
	//printf("num= %d ",num);
	j=0;
	do
	{
		N[j++]=num/p;
		rem=num%p;
		num=rem*10+N[i++];
		//printf(" quo=%d rem=%d  num=%d \n",quo[j-1],rem,num);
	}
	while(i<=size_N);
	return rem;
}
