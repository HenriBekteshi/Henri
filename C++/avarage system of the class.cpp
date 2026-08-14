#include <stdio.h>
#include <conio.h>

int max(int tab[], int n)
{
    int max = tab[0];

    for(int i = 0; i < n; ++i)
        if(tab[i] > max)
            max = tab[i];

    return max;
}



int min(int tab[], int n)
{
    int min = tab[0];

    for(int i = 0; i < n; ++i)
        if(tab[i] < min)
            min = tab[i];

    return min;
}



int main()
{
    int tab[200];
    float s = 0;
    int n;

    printf("How many students are in the class? ");
    scanf("%d", &n);

    for(int i = 0; i < n; ++i)
    {
        printf("Show student's grade: ");
        scanf("%d", &tab[i]);
        s = s + tab[i];
    }

    printf("The sum is: %.2f\n", s);
    printf("Avg is: %.2f\n", s/n);

    int m = max(tab, n);
    int mi = min(tab, n);

    printf("Max grade: %d\n", m);
    printf("Min grade: %d\n", mi);
}
