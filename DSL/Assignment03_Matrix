import numpy as np
print("\nEnter values for matrix 1: ")
matrix1=[]
rows1=int(input("Enter the number of rows: "))
colmns1=int(input("Enter the number of columns: "))
for i in range(rows1):
    row1=[]
    for j in range(colmns1): 
        value=int(input(f"Enter element at ({i+1},{j+1}): "))
        row1.append(value)
    matrix1.append(row1)    
print("\nMatrix 1 is:\n",np.matrix(matrix1))   
print("\nEnter values for matrix 2:") 
matrix2=[]
rows2=int(input("Enter the number of rows: "))
colmns2=int(input("Enter the number of columns: "))
for i in range(rows2):
    row2=[]
    for j in range(colmns2):
        value=int(input(f"Enter element at ({i+1},{j+1}): "))
        row2.append(value)
    matrix2.append(row2)
print("\nMatrix 2 is:\n",np.matrix(matrix2))

class matrix():
    
    def __init__(self,matrix1,matrix2,rm1,rm2,cm1,cm2):
        self.matrix1=matrix1
        self.matrix2=matrix2
        self.rm1=rm1
        self.rm2=rm2
        self.cm1=cm1
        self.cm2=cm2

    
    def addition(self):
        if self.rm1 == self.rm2 and self.cm1 == self.cm2 :
            a=[]
            for i in range(self.rm1):
                row=[]
                for j in range(self.cm1):
                    e=self.matrix1[i][j]+self.matrix2[i][j]
                    row.append(e)
                a.append(row)
            print("\nAddition is:\n",np.matrix(a))
        else:
            print("\nAddition not possible")  
            
    def subtraction(self):
    
        if self.rm1 == self.rm2 and self.cm1 == self.cm2 :
            a=[]
            for i in range(self.rm1):
                row=[]
                for j in range(self.cm1):
                    e=self.matrix1[i][j]-self.matrix2[i][j]
                    row.append(e)
                a.append(row)
            print("\nSubtraction is:\n",np.matrix(a))
        else:
            print("\nSubtraction not possible")

    def multiplication(self):
        if self.cm1==self.rm2:
            a=[]
            for i in range(self.rm1):
                row=[]
                for j in range(self.cm2):
                    e=0
                    for k in range(self.rm2):
                        e=e+self.matrix1[i][j]*self.matrix2[i][j]
                    row.append(e)
                a.append(row)
            print("\nMultiplication is:\n",np.matrix(a))
            
    def transpose(self):
        a=[]
        for i in range(self.rm1):
            row=[]
            for j in range(self.cm1):
                e=self.matrix1[j][i]
                row.append(e)
            a.append(row)
        print("\nTranspose is:\n",np.matrix(a))
        "\n"
       
                
                
obj=matrix(matrix1,matrix2,rows1,rows2,colmns1,colmns2)

print("\nOperations:\n1.Addition\n2.Subtraction\n3.Multiplication\n4.Transpose\n5.None")
t=0

while t==0:
    x1=int(input("\nEnter Operation: "))
    if x1==1:
        obj.addition()
    if x1==2:
        obj.subtraction()
    if x1==3:
        obj.multiplication()
    if x1==4:
        obj.transpose()
    if x1==5:
        break
