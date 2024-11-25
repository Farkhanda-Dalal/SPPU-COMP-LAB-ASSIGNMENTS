#include<iostream>
using namespace std;



template <class T> void selection(T a[], int n)
{
	int min_ind;
    for(int i=0; i<n;i++)
    {
        min_ind = i;
        for(int j = i;j<n;j++)
        {
            if(a[j] < a[i])
            {
                min_ind = j;
            }

        }
        
        float c = a[i];
        a[i] = a[min_ind];
        a[min_ind] = c;
        for (int i = 0; i < n; i++)
		cout << a[i] << " ";
        cout<<endl;

    }
}

template <class T> void insertion_sort(T a[],int n)
{
    float val;
    int hole =0;
    for(int i=1;i<n;i++)
    {
        val = a[i];
        hole =i;
        while (hole > 0 && a[hole-1] > val)
        {
            a[hole] =a[hole -1];
            hole--;

        }
        a[hole] = val;
        
    }
}


int main()
{
	int a[5] = { 10, 50, 30, 40, 20 };
	int n = sizeof(a) / sizeof(a[0]);

	
	selection<int>(a, n);

	cout << " Sorted array : ";
	for (int i = 0; i < n; i++)
		cout << a[i] << " ";
	cout << endl;

    float b[5] = { 10.10, 9.05, 6.5, 5.7, 1};
	int size = sizeof(a) / sizeof(a[0]);

	
	insertion_sort<float>(b, size);

	cout << " Sorted array : ";
	for (int i = 0; i < n; i++)
		cout << b[i] << " ";
	cout << endl;

	return 0;
}
