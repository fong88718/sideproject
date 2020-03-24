#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	int n,size,size1,s=1;
	scanf("%d",&n);
	while(n!=0)
	{
		fflush(stdin);
		scanf("N = %d",&size);
		int i,j,k=0,check = 0;
		long a[size][size];
		
		for(i=0;i<size;i++)
		{
			for(j=0;j<size;j++)
			{
				scanf("%d",&a[i][j]);
				if(a[i][j]<0)
					check = 1;
			}
		}
		if(size%2==0)
			size1 = size/2;
		else
			size1 = size/2 + 1;
			
		for(i=0;i<=size1;i++)
		{
			for(j=0;j<=size1;j++)
			{
				if(a[i][j]!=a[size - i-1][size - j-1])
				{
					
					k = 1;
					break;
				}	
			}
			if(k)
				break;
		}
		if(check ==1 || k==1)
			printf("Test #%d: Non-symmetric\n",s++);
		else
			printf("Test #%d: Symmetric\n",s++);
		n--;
	}
	return 0;
}


