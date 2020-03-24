#include<stdio.h>
#include<string.h>

int main(void)
{
	int n,g=1;
	scanf("%d",&n);
	
	while(n!=0)
	{
		char str[100];
		int  k = 0, i, j, ptr = 0;
		
		printf("Case %d:",g++);
		
		scanf("%s",&str);
		
		for(i=0 ; i<strlen(str) ; i+=2)
		{
			if('9' >= str[i+2] && str[i+2] >= '0')
			{
				if('9' >= str[i+3] && str[i+3] >= '0')
				{
					k = (str[i]-'0')*100+(str[i+1]-'0')*10 + str[i+2]-'0';
					ptr=2;
				}			
				else
				{
					k = (str[i+1]-'0')*10 + str[i+2]-'0';
					ptr = 1;
				}
				
			}
			else
			{
				k = str[i+1]-'0';
				ptr = 0;
			}
				
			for(j=0;j<k;j++)
				printf("%c",str[i]);
				
			if(ptr == 1)
				i++;
			if(ptr == 2)
				i=i+2;
		}
		printf("\n");
		n--;
	}

	return 0;
}


