#include<stdio.h>
#include<conio.h>
#include<string.h>

int main()

{
	char user[10];
	char pass[10];
	char u[10]="abc";
	char p[10]="123";
	printf("Username:");
	scanf("%s",&user);
	printf("Password:");
	scanf("%s",&pass);
	if(strcmp(user,u)==0&&strcmp(pass,p)==0)
	printf("Loading... Just one moment! ");
	else
	printf("Username or password is wrong!");
	getch();
	return 0;
}
