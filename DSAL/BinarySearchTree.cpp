#include <iostream>
#include <stack>
#include <queue>
using namespace std;

class Node{
    int data;
    Node *left;
    Node *right;

    public:
        friend class BST;

        Node(){
            data=0;
            left=nullptr;
            right=nullptr;
        }

        Node(int data){
            this->data=data;
            this->left=nullptr;
            this->right=nullptr;
        }
};

class BST{
    Node *root;

    public:
        BST(int data){
            this->root=new Node(data);
        }

        Node* getRoot(){
            return root;
        }

        void insert(int data){
            Node *curr=root;
            Node* prev=nullptr;

            while (curr!=nullptr){
                prev=curr;
                if(data<curr->data){
                    curr=curr->left;
                }
                else{
                    curr=curr->right;
                }
            }

            Node *newNode=new Node(data);
            if(data<prev->data){
                prev->left=newNode;
            }
            else{
                prev->right=newNode;
            }
            
        }

        void ascending(Node *temp){
            if(temp!=nullptr){
                ascending(temp->left);
                cout<<temp->data<<"\t";
                ascending(temp->right);
            }
        }

        void descending(Node *temp){
            if(temp!=nullptr){
                descending(temp->right);
                cout<<temp->data<<"\t";
                descending(temp->left);
            }
        }

        void ascendingNonRecursive(Node *root){
            Node *curr=root;
            stack <Node*> st;

            while(curr!=nullptr || !st.empty()){
                while(curr!=nullptr){
                    st.push(curr);
                    curr=curr->left;
                }
                curr=st.top();
                st.pop();
                cout<<curr->data<<"\t";
                curr=curr->right;
            }
        }

        void descendingNonRecursive(Node *root){
            Node *curr=root;
            stack <Node*> st;

            while(curr!=nullptr || !st.empty()){
                while(curr!=nullptr){
                    st.push(curr);
                    curr=curr->right;
                }
                curr=st.top();
                st.pop();
                cout<<curr->data<<"\t";
                curr=curr->left;
            }
        }

        void levelOrder(Node *root){
            queue<Node*> q;
            q.push(root);

            while(!q.empty()){
                Node *temp=q.front();
                cout<<temp->data<<"\t";
                q.pop();
                if(temp->left!=nullptr){
                    q.push(temp->left);
                }
                if(temp->right!=nullptr){
                    q.push(temp->right);
                }
            }
        }

        void mirror(Node *temp){
            Node *lchild=temp->left;
            Node *rchild=temp->right;

            temp->left=rchild;
            temp->right=lchild;

            if(lchild)
                mirror(lchild);
            if(rchild)
                mirror(rchild);
        }

       void minmax(Node *root){
            Node *curr=root;
            while(curr->left!=nullptr){
                curr=curr->left;
            }
            cout<<"The node with minimum data is "<<curr->data<<endl;

            curr=root;
            while(curr->right!=nullptr){
                curr=curr->right;
            }
             cout<<"The node with maximum data is "<<curr->data<<endl;
       }

       int longest_path(Node* root){
        if(root==NULL){
            return 0;
        }
        int left = longest_path(root->left);
        int right = longest_path(root->right);
        int count;
        if(left>=right){
            count = left+1;
        }
        else{
            count = right+1;
        }
        return count;
    }

    void search(int key){
        Node *curr=root;
        int level=0;

        while(curr!=nullptr){
            if(key==curr->data){
                cout<<key<<" was found at level "<<level<<endl;
                return;
            }
            else if(key<curr->data){
                curr=curr->left;
                level++;
            }
            else{
                curr=curr->right;
                level++;
            }
        }

        if(curr==nullptr){
            cout<<key<<" was not found in tree"<<endl;
        }
    }

};

int main(){
    int n;
    cout<<"Enter root of the binary search tree:"<<endl;
    cin>>n;
    BST bst(n);

    char ch='y';
    int op,no;

    while(ch=='y'){
        cout<<"\n1.Insert Nodes\n2.Ascending, Descending Print\n3.Ascending, Descending Non-recursive print\n4.Level Order Print\n5.Min and Max Data\n6.No of nodes in longest path\n7.Search\n8.Mirror\n9.Exit\nEnter your choice:"<<endl;
        cin>>op;

        switch (op)
        {
        case 1:
            cout<<"Enter no of nodes to be inserted:"<<endl;
            cin>>n;
            for (int i = 0; i < n; i++)
            {
                int data;
                cout<<"Enter node data:"<<endl;
                cin>>data;
                bst.insert(data);
            }
            break;
        
        case 2:
            cout<<"\nTree in Ascending Order:\t";
            bst.ascending(bst.getRoot());

            cout<<"\nTree in Descending Order:\t";
            bst.descending(bst.getRoot());
            break;

        case 3:
            cout<<"\nTree in Ascending Order Non-Recursive:\t";
            bst.ascendingNonRecursive(bst.getRoot());

            cout<<"\nTree in Descending Order Non-Recursive:\t";
            bst.descendingNonRecursive(bst.getRoot());
            break;

        case 4:
            cout<<"Level Order:\t";
            bst.levelOrder(bst.getRoot());
            break;

        case 5:
            bst.minmax(bst.getRoot());
            break;

        case 6:
            no=bst.longest_path(bst.getRoot());
            cout<<"No of nodes in the longest path="<<no<<endl;
            break;

        case 7:
            cout<<"Enter no to be searched:";
            cin>>no;
            bst.search(no);
            break;

        case 8:
            bst.mirror(bst.getRoot());
            cout<<"Mirrored Tree in Inorder:\t";
            bst.ascending(bst.getRoot());
            break;

        case 9:
            ch='n';
            cout<<"--------END OF PROGRAM--------"<<endl;
            break;

        default:
            ch='n';
            cout<<"--------END OF PROGRAM--------"<<endl;
            break;
        }
    }
 
    
}

