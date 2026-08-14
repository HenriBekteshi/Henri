#include<stdio.h>
#include<conio.h>

int main ()
{

int a;
int b;
printf("Give side a:");
scanf("%d",&a);
printf("Give side b:");
scanf("%d",&b);

int s=a*b;
int p=2*(a+b);
printf("Perimeter:%d\n",p);
printf("Area:%d",s);
return 0;
}


