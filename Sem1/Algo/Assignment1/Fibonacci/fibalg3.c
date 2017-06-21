#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int divideby2(int [1000000]);
int N[1000000];
long long int size_N;
int **y,**A;
void dec2bin(int[1000000]);
int** multiply(int**,int**);
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
		N[i++]=n;
	}*/
	i=0;
	printf("enter size");
	scanf("%lld",&size_N);
	if(size_N<=0||size_N>100000)
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
	size_N=i;
	//for(i=0;i<size_N;i++)
	//	printf("%d  ",N[i]);
	
	dec2bin(N);
	
	
	//for(j=0;j<size_N;j++)
	//	printf("%d   ",N[j]);

	while(size_N>0)
	{
		if(N[size_N-1]==1)
			y=multiply(y,A);
		A=multiply(A,A);
		
		size_N=size_N-1;
		
		
	}
	printf("%d",y[1][0]);
	//fclose(fp);
	free(y);
	free(A);

}	
void dec2bin(int N[1000000])
{
	long long int i=0;
	int rem;
	int bin[1000000];
	while(N[0]!=0)
	{
			rem=divideby2(N);
			bin[i++]=rem;
	}
	size_N=i;
	while(bin[size_N-1]==0)
		size_N--;
	for(i=0;i<size_N;i++)
	N[size_N-i-1]=bin[i];
	
	
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





int divideby2(int N[1000000])
{
	long long int i,j;
	int num,rem;
	i=0;
	num=0;
	
	while(num<2&&i<size_N)
	{
		num=num*10+N[i++];
	}
	j=0;
	do
	{
		N[j++]=num/2;
		rem=num-N[j-1]*2;
		num=rem*10+N[i++];
		//printf(" quo=%d rem=%d  num=%d \n",quo[j-1],rem,num);
	}
	while(i<=size_N);
	size_N=j;
return rem;
}
