#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

// class for Item Data
class Item
{
    int code;
    string name;
    int cost;
    int quantity;

public:
// Default constructor
    Item()
    {
        code = 0;
        name = "xxxx";
        cost = 0;
        quantity = 0;
    }
// Parameterized construtor
    Item(int c, string n, int p, int q)
    {
        code = c;
        name = n;
        cost = p;
        quantity = q;
    }
// Inline functions
    void getData();
    void displayData();
    int getCode() const
    {
        return code;
    }
};

// function to get Data
void Item::getData()
{
    cout << "Enter Item Code:";
    cin >> code;
    cout << "Enter Item Name:";
    cin >> name;
    cout << "Enter Item Cost:";
    cin >> cost;
    cout << "Enter Item Quantity:";
    cin >> quantity;
}

// function to print Data
void Item::displayData()
{
    cout << "Enter Item Code:" << code << endl;
    cout << "Enter Item Name:" << name << endl;
    cout << "Enter Item Cost:" << cost << endl;
    cout << "Enter Item Quantity:" << quantity << endl;
}

// supportive function for sorting to compare Item object code 
bool compareItems(const Item &item1, const Item &item2)
{
    return item1.getCode() < item2.getCode();
}

// vector built in function to sort Data
void sortData(vector<Item> &list)
{
    sort(list.begin(), list.end(), compareItems);
}

// print object data
void printItem(Item &obj)
{
    cout<<"------------------------"<<endl;
    obj.displayData();
    cout<<"------------------------"<<endl;
}

// function to search data
void searchData(const vector<Item> &list, int code)
{
    auto itr = find_if(list.begin(), list.end(),
                       [code](const Item &item) { return item.getCode() == code; });

    if (itr != list.end())
    {
        cout << "Item found at position = " << distance(list.begin(), itr)+1 << endl;
    }
    else
    {
        cout << "Item not found" << endl;
    }
}

int main()
{
    vector<Item> itemList;

    cout << "---- Welcome to PICT Stationary Database! ----" << endl;
    int choice = 0;

    while (choice != -1)
    {
        cout << "\n------------ MENU ------------" << endl;
        cout << "1. Create new item entry\n"
             << "2. Display all items\n"
             << "3. Sort the item\n"
             << "4. Search item by item-code\n"
             << "5. ---\n"
             << "-1. Exit" << endl;
        cout << "--------------------------------" << endl;

        cout << "Enter you choice = ";
        cin >> choice;

        switch (choice)
        {
        case 1: // Create new item entry
        {
            Item item1;
            cout << "------------New Item Entry------------" << endl;
            item1.getData();
            itemList.push_back(item1);
            cout << "new entry added!\n";
            break;
        }

        case 2: // Display all items
        {
            for_each(itemList.begin(), itemList.end(), printItem);
            break;
        }

        case 3:
        {
            sortData(itemList);
			cout << "Items are Sorted!" << endl;
			break;
        }

        case 4:
        {
            int code;
            cout<<"Enter The Item Code to Search: ";
            cin>> code;
            searchData(itemList, code);
        }

        case -1: // exit
        {
            cout << "#-------Exit-------#" << endl;
            choice = -1;
            break;
        }
        }
    }
    return 0;
}
