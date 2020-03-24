#include<stdio.h>
int main(void)
{
	double n1,n2,sum=0;
	char c1,c2;
	
	scanf("%lf",&n1);
	sum=n1;

	while(1)
	{
		scanf("%c",&c1);
		if(c1=='=')
		{
			fflush(stdin);
			printf("%0.2lf",sum);
			scanf("%c",&c1);
			
		}
		scanf("%lf",&n2);
		switch(c1)
		{
			case '+' :sum+=n2;break;
			case '-' :sum-=n2;break;
			case '*' :sum*=n2;break;
			case '/' :sum/=n2;break;
		}		
	}
	return 0;
}
