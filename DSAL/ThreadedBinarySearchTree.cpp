#include <iostream>
using namespace std;

class Node{
    int data;
    Node *left;
    Node *right;
    bool lbit;
    bool rbit;

    public:
        Node(){
            data=0;
            left=right=nullptr;
            lbit=rbit=0;
        }

        Node(int data){
            this->data=data;
            left=right=nullptr;
            lbit=rbit=0;
        }

        friend class TBST;
};

class TBST{
    Node *root, *head;

    public:
        TBST(){
            root=head=nullptr;
        }

        Node* getRoot(){
            return root;
        }

        void insert(int key){
            if(root==nullptr){
                head=new Node(-9999);
                root=new Node(key);

                head->right=head;
                head->left=root;
                head->lbit=1;

                root->left=head;
                root->right=head;
                cout<<"Root Inserted: |"<<root->lbit<<"|"<<root->data<<"|"<<root->rbit<<"|"<<endl;
                return;
            }
            else{
                Node *parent=root;
                Node *newNode=new Node(key);

                while (true)
                {
                    if(key==parent->data){
                        delete newNode;
                        cout<<"Cannot insert duplicate node data"<<endl;
                        return;
                    }
                    else if(key<parent->data){
                        if(parent->lbit==1){
                            parent=parent->left;
                        }
                        else{
                            newNode->left=parent->left;
                            newNode->right=parent;
                            parent->left=newNode;
                            parent->lbit=1;
                            cout<<"Parent  : |"<<parent->lbit<<"|"<<parent->data<<"|"<<parent->rbit<<"|"<<endl;
                            cout<<"New Node: |"<<newNode->lbit<<"|"<<newNode->data<<"|"<<newNode->rbit<<"|"<<endl;
                            return;
                        }
                    }
                    else{
                        if(parent->rbit==1){
                            parent=parent->right;
                        }
                        else{
                            newNode->right=parent->right;
                            newNode->left=parent;
                            parent->right=newNode;
                            parent->rbit=1;
                            cout<<"Parent  : |"<<parent->lbit<<"|"<<parent->data<<"|"<<parent->rbit<<"|"<<endl;
                            cout<<"New Node: |"<<newNode->lbit<<"|"<<newNode->data<<"|"<<newNode->rbit<<"|"<<endl;
                            return;
                        }
                    }
                }
                
            }
        }

        
        void inorder(Node *temp){
            //traverse to leftmost node
            while(temp->lbit==1){
                temp=temp->left;
            }
            while(temp!=head){
                cout<<temp->data<<"\t";
                if(temp->rbit==1){
                    temp=temp->right;
                    while(temp->lbit==1){
                        temp=temp->left;
                    }
                }
                else{
                    temp=temp->right;
                }
            }
        }

        void preorder(Node *temp){
            bool flag=0;

            while(temp!=head){
                if(flag==0){
                    cout<<temp->data<<"\t";
                }
                if(flag==0 && temp->lbit==1){
                    temp=temp->left;
                }
                else{
                    flag=(temp->rbit==1)?(0):(1);
                    temp=temp->right;
                }
            }
        }

        Node* min(Node *temp){
            if(temp->lbit==1){
                return min(temp->left);
            }
            cout<<"Smallest node in tree:"<<temp->data<<endl;
        }

        Node* max(Node *temp){
            if(temp->rbit==1){
                return max(temp->right);
            }
            cout<<"Largest node in tree:"<<temp->data<<endl;
            
        }

        bool search(int key,Node *&curr,Node *&parent){
            while(curr!=head){
                if(key==curr->data){
                    return true;
                }
                else{
                    parent=curr;
                    if(key<curr->data){
                        curr=curr->left;
                    }
                    else{
                        curr=curr->right;
                    }
                }
            }
            return false;
        }

        void deletion(Node *&p, Node *&t)
    {
       //2 Links
        if (t->lbit == 1 && t->rbit == 1)
        {
            Node *cs = t->right;
            p = t;
            while (cs->lbit == 1)
            {
                p = cs;
                cs = cs->left;
            }
            t->data = cs->data;
            t = cs;
            cout<<"Deleting Node Having 2 links"<<endl;
        }

        // leaf node 
        if (t->lbit == 0 && t->rbit == 0)
        {
            if (p->left == t)
            {
                cout<<"Deleting Leaf (Left)"<<endl;
                p->left = t->left;
                p->lbit = 0;
            }
            else
            {
                cout<<"Deleting Leaf (Right)"<<endl;
                p->right = t->right;
                p->rbit = 0;
            }
            delete t;
        }

        // left Link, right thread
        if (t->lbit == 1 && t->rbit == 0)
        {
            Node *temp = t->left;
            if (p->left == t)
            {
                p->left = temp;
            }

            else
            {
                p->right = temp;
            }

            while (temp->rbit == 1)
            {
                temp = temp->right;
            }
            temp->right = t->right;
            cout<<"Deleting Node with left link"<<endl;
            delete t;
        }

        // right link, left thread
        if (t->lbit == 0 && t->rbit == 1)
        {
            Node *temp = t->right;
            if (p->left == t)
            {
                p->left = temp;
            }
            else
            {
                p->right = temp;
            }

            while (temp->lbit == 1)
            {
                temp = temp->left;
            }
            temp->left = t->left;
            cout<<"Deleting Node with right link"<<endl;
            delete t;
        }
    }
    
};

int main(){
    TBST tbst;
    Node *curr, *parent;
    int n,data;
    char ch='y';

    while(ch=='y'){
        cout<<"\n1.Insert\n2.Inorder\n3.Preorer\n4.Delete\n5.Min and Max\nEnter your choice:"<<endl;
        cin>>n;

        switch (n)
        {
        case 1:
            cout<<"Enter no of nodes to be inserted:";
            cin>>n;
            for (int i = 0; i < n; i++)
            {
                cout<<"Enter data:";
                cin>>data;
                tbst.insert(data);
            }
            break;

        case 2:
            cout << "Inorder Taversal :\t";
            tbst.inorder(tbst.getRoot());
            break;

        case 3:
            cout << "Preorder Taversal :\t";
            tbst.preorder(tbst.getRoot());
            break;

        case 4:
            cout<<"Enter node to be deleted:"<<endl;
            cin>>data;

            curr=tbst.getRoot();
            parent=nullptr;
            if(tbst.search(data,curr,parent)){
                tbst.deletion(parent,curr);
                cout<<data<<"was deleted";
            }
            else{
                cout<<"Element not found"<<endl;
            }
            break;

        case 5:
            tbst.min(tbst.getRoot());
            tbst.max(tbst.getRoot());
            break;
        
        default:
            break;
        }
    }
}