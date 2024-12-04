#include<iostream>
#include<string>
using namespace std;
class Stack
{
    private:
    char stack[50];
    int max;
    int top;
    public:
    Stack()
    {
        max=50;
        top=-1;
    }
    bool isfull()
    {
        if(top==max-1) return true;
        else return false;
    }
    bool isempty()
    {
        if(top==-1) return true;
        else return false;
    }
    void push(char ch)
    {
        if(!isfull())
        {
            top++;
            stack[top]=ch;
        }
        else
        {
            cout<<"Stack is full !"<<endl;
        }
    }
    int pop()
    {
        if(!isempty())
        {
            int val=stack[top];
            top--;
            return val;
        }
        else
        {
            cout<<"Stack is empty !"<<endl;
        }
    }
    int precedence(char c)
    {
        if(c=='*' || c=='/') return 2;
        else if(c=='+' || c=='-') return 1;
        else return 0;
    }
    string InfixtoPostfix(string exp)
    {
        string ans;
        for(int i=0;i<exp.size();i++)
        {
            char ch=exp[i];
            // If operand directly add to output
            if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9'))
            {
                ans+=ch;
            }
            // If '(' (open bracket) the push to stack
            else if(ch=='(')
            {
                push('(');
            }
            // If ') (close bracket) then pop the stack until open  bracket is detected
            else if(ch==')')
            {
                while(stack[top]!='(')
                {
                    ans +=stack[top];
                    pop();
                }
                pop();
            }
            // If operator is found then output OR pop according to the precedence
            else{
                while(!isempty() && precedence(exp[i])<=precedence(stack[top]))
                {
                    ans +=stack[top];
                    pop();
                }
                push(ch);
            }
        }
        // Making stack empty ans adding to output
        while(!isempty())
        {
            ans +=stack[top];
                pop();
        }
        cout<<"The postfix epression is : "<<ans<<endl;
        return ans;
    }
    
    void postfixEval(string postfix)
    {
    //....Index of Postfix String
     int j;
    
     int Operand1; //...to store Operands
     int Operand2;
    
     for(j=0; postfix[j] != '\0'; j++)
     {
     //....If Operands - Push in Stack
    
     if(postfix[j] == 'a' || postfix[j] == 'b' || postfix[j] == 'c' || postfix[j] == 'd')
     {
     switch(postfix[j])
     {
     case 'a': push(2);
     break;
     case 'b': push(3); 
     break;
     case 'c': push(4);
     break;
     case 'd': push(5);
     break;
     }
     }
     else //....if Operator: Pop 2 Operands,do operation and Push result in stack.
     {
     Operand2 = pop(); //....Second Operand : due to LIFO
    
     Operand1 = pop(); //....First Operand : due to LIFO
    
     switch(postfix[j]) //....Do an Operatoration as per the Operator.
     {
     case '+':
     push(Operand1 + Operand2);
     break;
     case '-':
     push(Operand1 - Operand2);
     break;
     case '*':
     push(Operand1 * Operand2);
     break;
     case '/':
     push(Operand1 / Operand2);
     break;
     }
     }
     }
    
     cout<<"\n\t Postfix Expression Evaluation: "<<pop();
    }

};

int main()
{
string str;
    cout<<"Enter the infix expression : ";
    cin>>str;
    Stack s1;
    string a=s1.InfixtoPostfix(str);
    s1.postfixEval(a);

 cout<<"\n\n";
 return 0;
}