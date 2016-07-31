#include <stdio.h>
#include<stdlib.h>
void sort(int[1000],int);
int min(int,int);
int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
    int x,y,denom[1000],amount[1000],**v,i,j,k,num[100];
    //printf("hello");
    scanf("%d%d",&x,&y);
    for(i=0;i<x;i++)
        scanf("%d",&denom[i]);
    for(i=0;i<y;i++)
        scanf("%d",&amount[i]);
    sort(denom,x);
    
    for(i=x-1;i>=0;i--)
        printf("%d ",denom[i]);
printf("\n");
/*v=(int **)malloc(size(int *)*(x+1));
    for(i=0;i<=x;i++)
v[i]=(int*)malloc(size(int)*(amount[i]+1));
    for(i=0;i<=x;i++)
        for(j=0;j<=amount[i];j++)
    v[i][j]=9999;*/
    for(i=0;i<y;i++)
        {
	v=(int **)malloc(sizeof(int *)*(x+1));
       for(j=0;j<=x;j++)
		v[j]=(int*)malloc(sizeof(int)*(amount[i]+1));
         for(j=0;j<=x;j++)
        for(k=0;k<=amount[i];k++)
    		v[j][k]=9999;
          
         for(j=1;j<=x;j++)
             {
             for(k=1;k<=amount[i];k++)
                 {
                  if(denom[j-1]==k)
                     v[j][k]=1;
                  else if(k-denom[j-1]>=0&&j>=1)
                      v[j][k]=min(v[j-1][k],v[j][k-denom[j-1]]+1);
                   else
                     v[j][k]=v[j-1][k];
                 }
             }
	/*for(j=0;j<=x;j++){
	for(k=0;k<=amount[i];k++)
	{
		printf("%d  ",v[j][k]);
	}
		printf("\n");
	}*/
	
        for(j=0;j<x;j++)
            num[j]=0;
        j=x;
        k=amount[i];	
        
        while(k!=0&&j>=0)
            {
		if(denom[j-1]==k)
		{
		num[j-1]=num[j-1]+1;
		k=0;
		}
            else if(k-denom[j-1]>=0&&v[j][k]==v[j][k-denom[j-1]]+1) 
             {   num[j-1]=num[j-1]+1;
              k=k-denom[j-1];
             }
            else
                {
                j=j-1;
            }
        }
k=0;
for(j=0;j<x;j++)
if(num[j]>0)
{k=j;break;}
        for(j=x-1;j>k;j--)
        if(num[j]!=0)    
        printf("%d:%d,",denom[j],num[j]);
printf("%d:%d\n",denom[j],num[j]);
for(j=0;j<= x;j++)
		free(v[j]);
	free(v);
        
    }
    return 0;
}
int min(int a,int b)
    {
    if(a>b)
        return b;
    return a;
    
}
void sort(int array[1000],int n)
    {
    int c,d,swap;
    for (c = 0 ; c < ( n - 1 ); c++)
  {
    for (d = 0 ; d < n - c - 1; d++)
    {
      if (array[d] > array[d+1]) /* For decreasing order use < */
      {
        swap       = array[d];
        array[d]   = array[d+1];
        array[d+1] = swap;
      }
    }
  }
}

