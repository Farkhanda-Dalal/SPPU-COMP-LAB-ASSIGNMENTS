#include <iostream>

#include <vector>

#include <string>

#include <limits> // Correctly included for numeric_limits

using namespace std;



const int TABLE_SIZE = 10; // Adjust size as needed



struct Client {

    string name;

    string phone;

    bool isEmpty;



    Client() : name(""), phone(""), isEmpty(true) {}

};



int hashFunction(string key) {

    int hashValue = 0;

    for (char c : key) {

        hashValue += int(c);

    }

    return hashValue%TABLE_SIZE;

}



class HashTable {

private:

    vector<Client> table;

    int probingType; // 0 for without replacement, 1 for with replacement



public:

    HashTable(int type) : table(TABLE_SIZE), probingType(type) {}



    void insert(string name, string phone) {

        int index = hashFunction(name);

        int originalIndex = index, count = 0;

        bool placed = false;



        while (!table[index].isEmpty && count < TABLE_SIZE) {

            if (probingType == 1 && (index - hashFunction(table[index].name) + TABLE_SIZE) % TABLE_SIZE > (index - originalIndex + TABLE_SIZE) % TABLE_SIZE) {

                swap(name, table[index].name);

                swap(phone, table[index].phone);

            }

            index = (index + 1) % TABLE_SIZE;

            count++;

        }



        if (count < TABLE_SIZE) {

            table[index].name = name;

            table[index].phone = phone;

            table[index].isEmpty = false;

            placed = true;

        }



        if (!placed) {

            cout << "Table is full or unable to place the client due to excessive collisions." << endl;

        }

    }



    string find(string name) {

        int index = hashFunction(name);

        int count = 0;



        while (table[index].isEmpty == false && count++ < TABLE_SIZE) {

            if (table[index].name == name) {

                return table[index].phone;

            }

            index = (index + 1) % TABLE_SIZE;

        }

        return "Not found";

    }



    void displayTable() {

        cout << "Index\tName\tPhone\n";

        for (int i = 0; i < TABLE_SIZE; ++i) {

            if (!table[i].isEmpty) {

                cout << i << "\t" << table[i].name << "\t" << table[i].phone << endl;

            }

        }

    }



    void clear() {

        for (auto &client : table) {

            client.isEmpty = true;

        }

    }

};



void menu() {

    cout << "\n*** Telephone Book Database Menu ***\n";

    cout << "1. Insert Client\n";

    cout << "2. Find Client Phone\n";

    cout << "3. Display Table\n";

    cout << "4. Clear Table\n";

    cout << "5. Exit\n";

    cout << "Enter your choice: ";

}



int main() {

    int choice, type;

    string name, phone;



    HashTable table(0);

    HashTable table1(1);



    do {

        menu();

        cin >> choice;

        cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Correct usage to clear the input buffer



        switch (choice) {

            case 1:

                cout << "Enter client name: ";

                getline(cin, name);

                cout << "Enter phone number: ";

                getline(cin, phone);

                table.insert(name, phone);

                table1.insert(name, phone);

                break;

            case 2:

                cout << "Enter client name to find: ";

                getline(cin, name);

                cout << "Phone number: " << table.find(name) << endl;

                cout << "Phone number: " << table1.find(name) << endl;

                break;

            case 3:

                table.displayTable();

                table1.displayTable();

                break;

            case 4:

                table.clear();

                table1.clear();

                cout << "Table cleared.\n";

                break;

            case 5:

                cout << "Exiting program.\n";

                break;

            default:

                cout << "Invalid choice, please try again.\n";

        }

    } while (choice != 5);



    return 0;

}
