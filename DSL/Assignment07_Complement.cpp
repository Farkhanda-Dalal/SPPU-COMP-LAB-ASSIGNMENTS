#include<iostream>
using namespace std;
//--------------------------------------------------------
//--------------------------------------DLL Node Structure
struct DLLNode
{
 int bit; //...0 or 1 |0|-><-|1|-><-|0|-><-|0|
 struct DLLNode *prev;
 struct DLLNode *next;
}*Head1, *Head2;
//--------------------------------------------------------
//----------------------------------Create_DLL() Function
struct DLLNode* create_DLL(struct DLLNode *Head)
{
 struct DLLNode *temp, *Newnode;
 int i;
 int size = 4; //....for 4 bits of Binary No.

 for(i=0; i<size; i++)
 {
 //....Step 01: Allocate Memory Dynamically
 Newnode = new struct DLLNode;

 //....Step 02: Store data and address
 cout<<"\n\n\t Enter a bit(0/1): ";
 cin>>Newnode->bit;
 Newnode->prev = NULL;
 Newnode->next = NULL;

 //....Step 03: Attach Newnode in DLL.
 
 if(Head == NULL)
 {
 Head = Newnode;
 temp = Head;
 }
 else
 {
 temp->next = Newnode;
 Newnode->prev = temp;
 temp = Newnode;
 }
 cout<<"\t Node for "<<Newnode->bit<<" is added in DLL...!!!";
 }

 return Head;

}
//-----------------------------------------------------------
//--------------------------------------Display_DLL() Function
void display_DLL(struct DLLNode *Head)
{
 struct DLLNode *temp;

 cout<<"\n\n\t Head->";
 temp = Head;
 while(temp != NULL)
 {
 cout<<"->|"<<temp->bit<<"|<-";
 temp = temp->next;
 }
}
//---------------------------------------------------------
//--------------------------1's and 2's Compliment() Function
void Compliment(struct DLLNode *Head)
{
 struct DLLNode *temp;

 //.......For 1's Compliment

 cout<<"\n\n Binary No1 :";
 display_DLL(Head);

 temp = Head;
 while(temp != NULL)
 {
 if(temp->bit == 0)
 temp->bit = 1;
 else
 temp->bit = 0;

 temp = temp->next;
 }

 cout<<"\n\n 1's Compliment:";
 display_DLL(Head);
 //.......For 2's Compliment

 temp = Head; //.....To reach last Node/LSB.
 while(temp->next != NULL)
 temp = temp->next;

 while(temp->bit == 1)
 {
 temp->bit = 0;
 temp = temp->prev;
 }
 temp->bit = 1;

 cout<<"\n\n 2's Compliment:";
 display_DLL(Head);
}
//---------------------------------------------------------
//----------------------------------Add BinaryNos() Function
void add_Binary(struct DLLNode *head1, struct DLLNode *head2)
{
 struct DLLNode *temp1, *temp2;

 temp1 = head1; //.....To reach last Node/LSB of List-1 & List-2
 while(temp1->next != NULL)
 temp1 = temp1->next;

 temp2 = head2;
 while(temp2->next != NULL)
 temp2 = temp2->next;

 while(temp1 != NULL && temp2 != NULL)
 {
 if(temp1->bit == 0 && temp2->bit == 0)
 temp1->bit = 0;
 else if(temp1->bit == 0 && temp2->bit == 1)
 temp1->bit = 1;
 else if(temp1->bit == 1 && temp2->bit == 0)
 temp1->bit = 1;
 else
 temp1->bit = 0;

 temp1 = temp1->prev;
 temp2 = temp2->prev;
 }

 display_DLL(head1);

}
//------------------------------------------------------
//----------------------------------------Main() Function
int main()
{
 Head1 = NULL;
 Head2 = NULL;

 cout<<"\n\n-------------------------------------------";
 cout<<"\n A] Creating Doubly Linked List For Binary No1 :";
 cout<<"\n---------------------------------------------";
 Head1 = create_DLL(Head1);

 cout<<"\n\n-------------------------------------------";
 cout<<"\n B] Creating Doubly Linked List For Binary No2 :";
 cout<<"\n---------------------------------------------";
 Head2 = create_DLL(Head2);

 cout<<"\n\n-------------------------------------------";
 cout<<"\n C] Showing Doubly Linked List For Binary No1 :";
 cout<<"\n---------------------------------------------";
 display_DLL(Head1);

 cout<<"\n\n-------------------------------------------";
 cout<<"\n D] Showing Doubly Linked List For Binary No2 :";
 cout<<"\n---------------------------------------------";

 display_DLL(Head2);

 cout<<"\n\n-------------------------------------------";
 cout<<"\n E] Addition of Binary No1 and No2 ";
 cout<<"\n---------------------------------------------";
 add_Binary(Head1, Head2);

 cout<<"\n\n-------------------------------------------";
 cout<<"\n F] 1's and 2's Compliment of Binary No1: ";
 cout<<"\n---------------------------------------------";
 Compliment(Head1);

 cout<<"\n\n";

 return 0;
}
