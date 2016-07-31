#include<stdio.h>
main()
{
	char str[1000][1000],space,corpus[100][100];
	int n=0,i,j,m,x,y,count;
	float f;
	//printf("enter no of target terms");
	//scanf("%d",&n);
	//for(i=0;i<n;i++)
	//scanf("%s",str[i]);
		do
		{
			scanf("%s",str[n++]);
			printf("%s ",str[n-1]);
			scanf("%c",&space);
		}while(space==' ');
	//printf("no of corpus lines");
	scanf("%d",&m);
	for(i=0;i<m;i++)
	{
		j=0;
		do
		{
			scanf("%s",corpus[j++]);

			scanf("%c",&space);
		}while(space==' ');
		//for(x=0;x<j;x++)
		//printf("%s",corpus[x]);
		count=0;
		for(x=0;x<n;x++)
		{
			
			for(y=0;y<j;y++)
			{
				if(strcmp(str[x],corpus[y])==0)
				count++;
			}
		}
		f=(float)count/(n+j-count);
		printf("%.2f:",f);
		for(x=0;x<j;x++)
			printf("%s ",corpus[x]);

	}
}
