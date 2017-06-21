package perfecthashing;

public class SecondaryHash {
	int a,b;
	long p;
	long h2[];
	int size;
	SecondaryHash(int n)
	{
		h2=new long[n];
		size=n;
	}
	void ChangeValues(int a,int b,long p)
	{
		this.a=a;
		this.b=b;
		this.p=p;
	}
	void intializeArray()
	{
		for(int i=0;i<h2.length;i++)
			h2[i]=-1;
	}

}
