#include <iostream>
using namespace std;

class Node
{
public:
  int data;
  Node *next;

  Node()
  {
    this->data = 0;
    this->next = NULL;
  }
};

class LinkedList
{
private:
  Node *head[10];

public:
  void create()
  {
    for (int i = 0; i < 10; i++)
    {
      head[i] = new Node();
      head[i] = NULL;

      for (int j = 0; j < 7; j++)
      {
        Node *newNode = new Node();
        if (head[i] == NULL)
        {
          head[i] = newNode;
          newNode->next = head[i];
        }
        else
        {
          Node *temp = head[i];
          while (temp->next != head[i])
          {
            temp = temp->next;
          }
          temp->next = newNode;
          newNode->next = head[i];
        }
      }
    }
   // cout << "create done" << endl;
  }

  void printlist()
  {
    Node *temp = new Node();

    for (int i = 0; i < 10; i++)
    {
      temp = head[i];
      for (int j = 0; j < 7; j++)
      {

        cout << temp->data << " ";
        temp = temp->next;
      }

      cout << endl;
    }
  //  cout << "print done" << endl;
  }

  void random_booking()
  {
    int seats = 3;
    int r = 4;
    Node *temp = new Node();
    temp = head[3];
    for (int i = 0; i < 7; i++)
    {

      if (i >= 2 && i <= 4)
      {
        temp->data = 1;
      }
      temp = temp->next;
    }
  }

  
  
void booking() {
    int seats, row, col;
    cout << "Enter the no of seats to be booked: " << endl;
    cin >> seats;
    cout << "Enter the row number: " << endl;
    cin >> row;
    cout << "Enter the column number: " << endl;
    cin >> col;

    if (row < 0 || row >= 10 || col < 0 || col >= 7) {
        cout << "Invalid row or column number." << endl;
        return;
    }

    Node* temp = head[row];
    for (int i = 0; i < col; i++) {
        temp = temp->next;
    }

    for (int i = 0; i < seats; i++) {
        temp->data = 1;
        temp = temp->next;
    }

    cout << "Booking successful." << endl;
}
  void cancel_Booking()
  {
        int seats, row, col;
    cout << "Enter the no of seats to be cancelled: " << endl;
    cin >> seats;
    cout << "Enter the row number: " << endl;
    cin >> row;
    cout << "Enter the column number: " << endl;
    cin >> col;

    if (row < 0 || row >= 10 || col < 0 || col >= 7) {
        cout << "Invalid row or column number." << endl;
        return;
    }

    Node* temp = head[row];
    for (int i = 0; i < col; i++) {
        temp = temp->next;
    }

    for (int i = 0; i < seats; i++) {
        temp->data = 0;
        temp = temp->next;
    }

    cout << "Cancellation successful." << endl;
  }
};

int main()
{
  

  LinkedList l1;
 
  l1.create();
 
   while(true)
   {cout<<"***Menu**"<<endl;
    cout<<"1.Display "<<endl<<"2.Book the tickets"<<endl<<"3.Cancel the tickets"<<endl;
  int ch;
  cout<<"Enter the operation to be performed :" <<endl;
  cin>>ch;
 switch(ch)
 {
  
    case 1:
    l1.printlist();
    break;
    case 2:
    l1.booking();
  
    break;
    case 3:
    l1.cancel_Booking();
    break;
    default:
    cout<<"Enter valid input"<<endl;
 }
 }
  return 0;
}
