#include<stdio.h>

int main(void)
{
	int i,n,k=0,n1,j,power=0;
	int a[100];
	printf("enter number:");
	while(scanf("%d",&n)!=EOF)
	{ 
		printf("result: ");
		n1=n;
		for(i=2;i<n1;i++)
		{
			if(n%i==0)
			{
				n=n/i;
				a[k++]=i;
				i--;
			}
		}
		for(i=0;i<k;i++)
		{
			printf("%d",a[i]);
			if(i!=k-1 && (a[i] == a[i+1]))
			{
				for(j=0;j<k;j++)
				{
					if(a[i]==a[j])
						power++;
				}
				printf("^%d",power);
				i=i+power-1;
				power=0;				
			}
			if(i!=k-1)			
				printf(" * ");
		}
		if(k==0)
			printf("%d",n);
			
		printf("\n");
		k=0;
	}
	return 0;
}
