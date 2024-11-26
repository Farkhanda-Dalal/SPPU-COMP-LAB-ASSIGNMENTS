#include <iostream>
using namespace std;
#include <stack>

class Node{
    int data;
    Node *left,*right;

    public:
    Node(){
        int data=0;
        left=right=nullptr;
    }

    Node(int data){
        this->data=data;
        left=right=nullptr;
    }

    friend class Tree;
};

class Tree{
    Node *root;

    Node* makeTree(){
        int data;
        char ch;

        cout<<"Enter node data:"<<endl;
        cin>>data;
        Node* temp=new Node(data);

        cout<<"Do you want to create left child of "<<temp->data<<"? (y/n):"<<endl;
        cin>>ch;
        if(ch=='y'){
            temp->left=makeTree();
        }

        cout<<"Do you want to create right child of "<<temp->data<<"? (y/n):"<<endl;
        cin>>ch;
        if(ch=='y'){
            temp->right=makeTree();
        }

        return temp;
    }

    public:
    Tree(){
        root=nullptr;
    }

    void create(){
        root=makeTree();
    }

    Node* getRoot(){
        return root;
    }

    void InorderRecur(Node *temp){

        if(temp!=nullptr){
            InorderRecur(temp->left);
            cout<<temp->data<<"\t";
            InorderRecur(temp->right);
        }
    }

    void PreOrderRecur(Node *temp){
        if(temp!=nullptr){
            cout<<temp->data<<"\t";
            PreOrderRecur(temp->left);
            PreOrderRecur(temp->right);
        }
    }

    void PostOrderRecur(Node *temp){
        if(temp!=nullptr){
            PostOrderRecur(temp->left);
            PostOrderRecur(temp->right);
            cout<<temp->data<<"\t";
        }
    }

    void InorderNon(Node *root){
        Node *curr=root;
        stack<Node*> st;

        while (curr!=nullptr || !st.empty())
        {
            while (curr!=nullptr)
            {
                st.push(curr);
                curr=curr->left;
            }
            curr=st.top();
            st.pop();
            cout<<curr->data<<"\t";
            curr=curr->right;
        }

    }

    void PreorderNon(Node *root){
        stack <Node*> st;
        st.push(root);

        while(!st.empty()){
            Node *temp=st.top();
            st.pop();
            cout<<temp->data<<"\t";
            if(temp->right){
                st.push(temp->right);
            }
            if(temp->left){
                st.push(temp->left);
            }
        }
    }

    void PostorderNon(Node *root){
        stack<Node*> st;
        stack<int> out;
        st.push(root);

        while(!st.empty()){
            Node *temp=st.top();
            st.pop();
            out.push(temp->data);
            if(temp->left){
                st.push(temp->left);
            }
            if(temp->right){
                st.push(temp->right);
            }
        }
        while (!out.empty())
        {
            cout<<out.top()<<"\t";
            out.pop();
        }
        
    }

    int height(Node* temp){
        int lh,rh;

        if(temp!=nullptr){
            lh=height(temp->left);
            rh=height(temp->right);
            if(lh>rh){
                return (lh+1);
            }
            else{
                return(rh+1);
            }
        }
        else{
            return 0;
        }
    }

    int leaves(Node *root)
    {
        if (root == nullptr)
        {
            return 0;
        }
        if (root->left == nullptr && root->right == nullptr)
        {
            return 1;
        }
        else
        {
            return (leaves(root->left) + leaves(root->right));
        }
    }

    int internalNodes(Node *root)
    {
        if (root == NULL || (root->left == NULL && root->right == NULL))
        {
            return 0;
        }
        else
        {
            return internalNodes(root->left) + internalNodes(root->right) + 1;
        }
    }
        
    void createMirror(Node *n)
    {
        Node *rchild = n->right;
        Node *lchild = n->left;
        n->left = rchild;
        n->right = lchild;
        if (lchild)
            createMirror(lchild);
        if (rchild)
            createMirror(rchild);
    }

    Node *copy(Node *temp){
        Node *copyTree;

        if(temp!=nullptr){
            copyTree=new Node;
            copyTree->data=temp->data;
            copyTree->left=copy(temp->left);
            copyTree->right=copy(temp->right);
        }

        return copyTree;
    }

    void eraseTree(Node *node) {
		if (node != NULL) {
			eraseTree(node->left);
			eraseTree(node->right);

			delete node;
			node = NULL;
		}
		return;
	}
};

int main(){
    Tree t;
    Node *root;

    cout<<"---------CREATING TREE---------"<<endl;
    t.create();

    char ch='y';
    int n=0;
    while(ch=='y'){
        cout<<"\n1.Inorder Recursive\n2.Pre-order Recursive\n3.Post-order Recursive\n4.Inorder Non-Recursive\n5.Pre-order Non-Recursive\n6.Post-order Non-Recursive\n7.Height of Tree\n8.Count Leaves\n9.Count Internal Nodes\n10.Mirror Tree\n11.Copy Tree\nEnter your choice:"<<endl;
        cin>>n;

        switch(n){
            case 1:
                cout<<"Inorder Traversal Recursive:\t";
                t.InorderRecur(t.getRoot());
                break;

            case 2:
                cout<<"Preorder Traversal Recursive:\t";
                t.PreOrderRecur(t.getRoot());
                break;

            case 3:
                cout<<"Postorder Traversal Recursive:\t";
                t.PostOrderRecur(t.getRoot());
                break;

            case 4:
                cout<<"Inorder Traversal Non-Recursive:\t";
                t.InorderNon(t.getRoot());
                break;

            case 5:
                cout<<"Preorder Traversal Non-Recursive:\t";
                t.PreorderNon(t.getRoot());
                break;

            case 6:
                cout<<"Postorder Traversal Non-Recursive:\t";
                t.PostorderNon(t.getRoot());
                break;

            case 7:
                cout<<"Height of Tree="<<t.height(t.getRoot())<<endl;
                break;

            case 8:
                cout<<"No of leaf nodes="<<t.leaves(t.getRoot())<<endl;
                break;

            case 9:
                cout<<"No of internal nodes="<<t.internalNodes(t.getRoot())<<endl;
                break;

            case 10:
                t.createMirror(t.getRoot());
                cout<<"Tree was mirrored"<<endl;
                break;

            default:
                ch='n';
                cout<<"----------END OF PROGRAM----------";
        }
    }
    


}
