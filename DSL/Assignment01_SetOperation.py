# U=[1,2,3,4,5,6,7,8,9,10]
# A=[1,3,5,7,9]
# B=[3,5,6,8]
# C=[1,6,9,10]

print("--------------------------INPUTS------------------------------------")
U = list(map(int, input("Enter Universal Set:").split()))
A = list(map(int, input("Enter A Set:").split()))
B = list(map(int, input("Enter B Set:").split()))
C = list(map(int, input("Enter C Set:").split()))
print("U =",U)
print("A =",A)
print("B =",B)
print("C =",C)
def union(a, b):
    union = []
    for i in a:
        union += [i]
    for i in b:
        flag = 0
        for j in union:
            if (i == j):
                flag = 1
                break
        if (flag == 0):
            union += [i]
    return union


def inter(a, b):
    inter = []
    for i in a:
        for j in b:
            if (i == j):
                inter += [i]
    return inter


def sub(a, b):
    ans = []
    for i in a:
        flag = False
        for j in b:
            if (j == i):
                flag = True
                break
        if (flag == False):
            ans += [i]
    return ans


unionAB = union(A, B)
interAB = inter(A, B)

st=0
while(st<=1):
    print("--------------------------MENU----------------------------------")
    ch = int(input("1.A union B\n2.A intersection B\n3.A union B - A intersection B\n4.Universal Set - A union B\n5.A intersection C - B\nEnter choice:"))
    if(ch==1):
        print("A Union B=", unionAB)
    elif(ch==2):
        print("A Intersection B=", interAB)
    elif (ch == 3):
        print("A Union B - A Intersection B=",sub(unionAB, interAB))
    elif(ch==4):
        print("Universal Set - A Union B=", sub(U, unionAB))
    elif(ch==5):
        print("A Intersection C - B=", sub(inter(A, C), B))
    else:
        print("Incorrect Input")
    st=int(input("Enter 1 to see menu:"))





