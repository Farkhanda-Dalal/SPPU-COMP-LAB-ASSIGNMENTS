class Search:
    ls=[]
        
    def inputlist(self):
        ls=[]
        n=int(input("Enter number of students: \n"))
        print("Enter list:")
        for i in range(n):
            k=int(input(" "))
            ls.append(k)
        return ls 
            
    def linsearch(self,ls,key):
        
        n=len(ls)
        i=0
        while(i<n):
            if(ls[i]==key):
                return i
            else:
                i+=1
        return -1
    
    
    def sentinelSearch(self,arr, n, key):       
    
        
        last = arr[n - 1]

        arr[n - 1] = key
        i = 0

        while (arr[i] != key):
            i += 1

        arr[n - 1] = last

        if ((i < n - 1) or (arr[n - 1] == key)):
            print(key, "present at index: ", i)
        else:
            print("Element not found")
    
    def swapping(self,a,b):
        temp=0
        temp=a
        a=b
        b=temp
        return a,b
    
    def sorting(self,ls,n):
        n=len(self.ls)
        for i in range(n):
            for j in range(0,n-i-1):
                if ls[j]>ls[j+1]:
                    self.swapping(self,ls[j],ls[j+1])
        return ls
    
    def binary_search(self,ls,x,low,high,mid):
        self.sorting(self,ls)
        if high>=low:
            mid=low+(high-low)//2
            
            if ls[mid]==x:
                return mid
            elif ls[mid]<x:
                low=mid+1
            else:
                high=mid-1
        else:
            return -1
        
    def binary_search_recursive(self,ls,low,high,mid,x):
        #recursive
        while low<=high:
            mid=low+(high-low)//2
            
            if ls[mid]==x:
                return mid
            elif ls[mid]>x:
                return self.binary_search(self,ls,mid-1,x)
            else:
                return self.binary_search(self,ls,high,mid+1,x)
                
        else:
            return -1   
        
    def fibonacci_search(self,ls,size,key):
        n=len(ls)
        offset = -1
        
        f0 = 0
        f1 = 1
        f2 = 1
        while(f2 < n):
            f0 = f1
            f1 = f2
            f2 = f1 + f0
        
        
        while(f2 > 1):
            index = min(offset + f0, n - 1)
            if ls[index] < key:
                f2 = f1
                f1 = f0
                f0 = f2 - f1
                start = index
            elif ls[index] > key:
                f2 = f0
                f1 = f1 - f0
                f0 = f2 - f1
            else:
                return index
        if (f1) and (ls[n - 1] == key):
            return n - 1
        return None
    
obj=Search()
ls=[]
ls=obj.inputlist()
n=len(ls)
s=0

key=int(input("Enter element to search: "))
print("Operations:\n1.Linear search\n2.Sentinel Search\n3.Binary search\n4.Recursive Binary Search\n5.Fibonacci Search\n6.None\n")

while s==0:
    t=int(input("Enter your search operation: "))
    if t==1:
        print(obj.linsearch(ls,key))
    if t==2:
        obj.sentinelSearch(ls,n,key)
    if t==3:
        obj.binary_search(ls,0,n-1,key)
    if t==4:
        obj.binary_search_recursive(ls,key) 
    if t==5:
        obj.fibonacci_search(ls,n,key)
    if t==6:
        break;
