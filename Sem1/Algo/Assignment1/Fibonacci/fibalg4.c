#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<time.h>
int **y,**A;
long long int size_N;
int N[1000000];
int** multiply(int**,int**);
int ** power(int **,int );
void divideby2(int [1000000]);
main()
{
	srand(time(NULL));
	FILE *fp;
	long long int i,j;
	int n;
	y=(int**)malloc(sizeof(int *)*2);
	for(i=0;i<2;i++)
		y[i]=(int*)malloc(sizeof(int)*2);
	A=(int**)malloc(sizeof(int *)*2);
	for(i=0;i<2;i++)
		A[i]=(int*)malloc(sizeof(int)*2);
	y[0][0]=1;
	y[0][1]=0;
	y[1][0]=0;
	y[1][1]=1;
	A[0][0]=1;
	A[0][1]=1;
	A[1][0]=1;
	A[1][1]=0;	
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
		if(n>='0'&&n<='9')
			N[i++]=(int)n-48;
		N[i++]=n;
	}*/
	i=0;
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
		//fread(&n,sizeof(char),1,fp);
		//if(n>='0'&&n<='9')
		n=(int)rand()%10;
			N[i++]=n;
	}
	//for(j=0;j<i;j++)
	//	printf("%d  ",N[j]);
	
	size_N=i;
	while(N[0]>0&&size_N>0)
	{
		if(N[size_N-1]%10!=0)
			y=multiply(y,power(A,N[size_N-1]));
		
		
		A=power(A,10);
		
		size_N=size_N-1;
		//for(i=0;i<size_N;i++)
		//printf("%d  ",N[i]);
		
	}
	printf("%d",y[1][0]);
	//fclose(fp);
	free(y);
	free(A);
}
int ** power(int **a,int n)
{
int **p;
p=(int**)malloc(sizeof(int *)*2);
	for(int i=0;i<2;i++)
		p[i]=(int*)malloc(sizeof(int)*2);
p[0][0]=1;
	p[0][1]=0;
	p[1][0]=0;
	p[1][1]=1;
while(n>0)
{
p=multiply(p,a);
n--;
}
return p;
}
int** multiply(int **a,int **b)
{
	int **res;
	int i,j,k;
	res=(int**)malloc(sizeof(int *)*2);
	for(i=0;i<2;i++)
		res[i]=(int*)malloc(sizeof(int)*2);
	for(i=0;i<2;i++)
		for(j=0;j<2;j++)
			res[i][j]=0;
	for(i=0;i<2;i++)
	for(j=0;j<2;j++)
	{	
		for(k=0;k<2;k++)
		{	
			res[i][j]=res[i][j]+a[i][k]*b[k][j];
		}
		res[i][j]=res[i][j]%100;
	}
	
	return res;
}

