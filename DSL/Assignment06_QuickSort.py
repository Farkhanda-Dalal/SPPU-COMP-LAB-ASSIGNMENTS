class Sorting():
    lst=[]
    def inputlist(self):
        lst=[]
        n=int(input("Enter the number of students: "))
        for i in range(n):
            k=float(input("\nEnter Percentage: "))
            lst.append(k)
        return lst 
    
    def partition(self,lst,low,high):
        pivot=lst[high]
        i=low-1
        for j in range(low,high):
            if lst[j]<=pivot:
                i=i+1
                (lst[i],lst[j])=(lst[j],lst[i])
        (lst[i+1],lst[high])=(lst[high],lst[i+1])
        return i+1
    
    def quicksort(self,lst,low,high):
        if low<high:
            pi=self.partition(lst,low,high)
            self.quicksort(lst,low,pi-1)
            self.quicksort(lst,pi+1,high)

obj=Sorting()
lst=obj.inputlist()
n=len(lst)
obj.quicksort(lst,0,n-1)
print("\nSorted Array is: ",lst[-n:])
print("\nTop 5 scores: ",lst[-1:-6:-1])
