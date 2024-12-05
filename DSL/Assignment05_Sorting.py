class Sorting():
    lst=[]
    def inputlist(self):
        lst=[]
        n=int(input("Enter the number of students: "))
        for i in range(n):
            k=float(input("\nEnter Percentages: "))
            lst.append(k)
        return lst 

    def insertion_sort(self,lst,n):     
        n=len(lst)   
        for x in range(1, n):
            key = lst[x]
            j = x - 1                      
            while j >= 0 and key < lst[j]:
                lst[j + 1] = lst[j]
                j = j - 1                        
            lst[j + 1] = key
        print("\nThe sorted list is: ",lst[-n:])
        print("\nThe top five scores are: ",lst[-1:-6:-1])
    
    def shell_sort(self,lst,n):
        n=len(lst)
        i=n//2
        while i>0:
            for j in range(i,n):
                key=lst[j]
                x=j
                while(key<lst[x-i]):
                    lst[x]=lst[x-i]
                    lst[x-i]=key
            i//=2
        print("\nThe sorted list is: ",lst[-n:])
        print("\nThe top five scores are: ",lst[-1:-6:-1])
        

obj=Sorting()
lst=[]
lst=obj.inputlist()
n=len(lst)

s=0
print("\nSelect the type of sort: \n1.Insertion Sort\n2.Shell Sort\n3.Exit\n")

while s==0:
    t=int(input("Enter the type of sort:"))
    if t==1:
        obj.insertion_sort(lst,n)
    if t==2:
        obj.shell_sort(lst,n)
    if t==3:
        print("Exited successfully, thank you")
        break
