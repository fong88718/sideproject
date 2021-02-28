#include<stdio.h>
#include<stdlib.h>
int main(void)
{
	int a,b,c,d ,i,k,i1=0,j=0,r;
	
	printf("enter A matrix size(m by n):");
	scanf("%d%d",&a,&b); //matrix size 
	printf("enter B matrix size(n by k):");
	scanf("%d%d",&c,&d);
	
	if(b!=c)  //matrix size error
		printf("matrix size Error");
	else
	{
		long m1[a][b];
		long m2[c][d];
		long m3[a][d];
		printf("enter A matrix entry\n");
		for(i=0;i<a;i++)
			for(k=0;k<b;k++)
				scanf("%ld",&m1[i][k]);  
				
		printf("enter B matrix entry\n");			
		for(i=0;i<c;i++)
			for(k=0;k<d;k++)
				scanf("%ld",&m2[i][k]);
			
	
		for(i=0;i<a;i++) //computing
		{
			for(j=0;j<d;j++)
			{
				m3[i][j]=0;
				for(r=0;r<c;r++)					
					m3[i][j]+= m1[i][r]*m2[r][j];	
					
			}
		}		
		printf("result:\n");		
		for(i=0;i<a;i++)
		{
			for(j=0;j<d;j++)
				printf("%ld ",m3[i][j]);
			
			printf("\n");
		}
	}
	return 0;
}
