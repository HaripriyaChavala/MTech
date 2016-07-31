#include<stdio.h>
#include<string.h>
void sort(char[50][50],int n);
main()
{
	char vocab[1000],corpus[1000],*temp,voc[50][50],cor[50][50][50],tar[50][50],target[100],t[1000],c[50][50][50];
	int i,j,k,n,m,size_cor[100],size_tar,size_voc,match_voc[50],y,count,l;
	float match_score,x;
	FILE *fp;
	//scanf("%s",vocab);
	fp=fopen("corpus.txt","r");
	fgets(vocab,1000,fp);
	strtok(vocab,"\n");
	temp=strtok(vocab,",");
	i=0;
	while(temp!=NULL)
	{
		strcpy(voc[i],temp);		
		i++;
		temp=strtok(NULL,",");
	}
	size_voc=i;
	sort(voc,i);
	//printf("voc_size=%d\n",size_voc);
	//printf("no of corpus lines");
	//scanf("%d",&m);
	k=0;
	while(fgets(corpus,1000,fp)!=NULL)
	{
		//scanf("%s",corpus);
		j=0;
		
		strtok(corpus,"\n");
		temp=strtok(corpus,",");
		
		while(temp!=NULL)
		{
			
			strcpy(cor[k][j],temp);
			strcpy(c[k][j],temp);
			//printf("%s,",cor[k][j]);
			j++;
			temp=strtok(NULL,",");
			
		}
		size_cor[k]=j;
		//printf("\ncorpus_size=%d\n",size_cor[k]);
		
		sort(cor[k],j);
		//for(i=0;i<j;i++)
		//	printf("%s    ",cor[k][i]);
		//printf("%d  ",j);
		match_voc[k]=0;
		for(i=0,j=0;i<size_voc&&j<size_cor[k];)
		{
			
			//printf("voc=%scorpus=%s\n",voc[i],cor[k][j]);
			if(strcmp(voc[i],cor[k][j])==0)
			{
				match_voc[k]=match_voc[k]+1;
				i++;
				j++;
			}
			else if(strcmp(voc[i],cor[k][j])>0)
			{
				j++;
			}
			else
				i++;
		}
		//printf("match_voc=%d\n",match_voc[k]);
		k++;
	}
	m=k;
	//printf("m=%d\n",m);
	fclose(fp);
	/*printf("no of target lines");
	scanf("%d",&n);*/
	fp=fopen("target.txt","r");
	while(fgets(target,100,fp)!=NULL)
	{
		
		strtok(target,"\n");
		strcpy(t,target);
		j=0;
		temp=strtok(target,",");
		while(temp!=NULL)
		{
			strcpy(tar[j],temp);
			j++;
			temp=strtok(NULL,",");
		}
		size_tar=j;
		sort(tar,j);
		match_score=-1;
		for(j=0;j<m;j++)
		{
			
			count=0;
			for(k=0,l=0;k<size_cor[j]&&l<size_tar;)
			{
				if(strcmp(cor[j][k],tar[l])==0)
				{
					k++;
					l++;
					count++;
				}
				else if(strcmp(cor[j][k],tar[l])>0)
					l++;

				else
					k++;
			}
			x=(float)count/(size_tar+match_voc[j]-count);
			if(x>match_score)
			{
				match_score=x;
				y=j;
			}
		}
		printf("%s",t);
		printf(": %.2f :",match_score);
		for(j=0;j<size_cor[y];j++)
		if(j==size_cor[y]-1)
			printf("%s",c[y][j]);
		else
			printf("%s,",c[y][j]);
		printf("\n");
			
					
		
	}
	
fclose(fp);

}


void sort(char a[50][50],int n)
{
char temp[50];
int i,j;
	for(i=0;i<n-1;i++)
	{
		for(j=0;j<n-i-1;j++)
		{
			if(strcmp(a[j],a[j+1])>0)
			{
				strcpy(temp,a[j]);
				strcpy(a[j],a[j+1]);
				strcpy(a[j+1],temp);
			}
		}
	}
}


