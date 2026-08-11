#include<stdio.h>
#include<conio.h>
int main ()
{
	char v;
	int x,y;
	int r=0;
	printf("Enter the value you wish to perform:");
	scanf("%c",&v);
	printf("X:");
	scanf("%d",&x);
	printf("Y:");
	scanf("%d",&y);
	if (v=='-')
	r=x-y;
	if(v=='+')
	r=x+y;
	if(v=='*')
	r=x*y;
	if(v=='/')
	r=x/y;
	printf("Result:%d",r);
	getch();
	return 0;
}
