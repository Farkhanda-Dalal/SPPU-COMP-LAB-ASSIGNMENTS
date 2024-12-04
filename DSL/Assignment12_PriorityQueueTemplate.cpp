#include <iostream>
using namespace std;

// Template class for - data items with priority
template <typename T>
class PriorityQueueNode
{
public:
    T data;
    int priority;
    PriorityQueueNode<T> *next;

    PriorityQueueNode(const T &d, int p) : data(d), priority(p), next(nullptr) {}

    // Overloading the <= operator
    bool operator<=(const PriorityQueueNode<T> &other) const
    {
        return priority <= other.priority;
    }
};

// Template class for - Priority Queue
template <typename T>
class PriorityQueue
{
private:
    PriorityQueueNode<T> *front;

public:
    PriorityQueue() : front(nullptr) {}

    void enqueue(const T &data, int priority)
    {
        PriorityQueueNode<T> *newNode = new PriorityQueueNode<T>(data, priority);

        if (front == nullptr || priority > front->priority)
        {
            newNode->next = front;
            front = newNode;
        }
        else
        {
            PriorityQueueNode<T> *current = front;
            while (current->next != nullptr && priority <= current->next->priority)
            {
                current = current->next;
            }

            newNode->next = current->next;
            current->next = newNode;
        }

        cout << "Item with priority " << priority << " added to the queue." << endl;
    }

    void dequeue()
    {
        if (front == nullptr)
        {
            cout << "Queue is empty. No item to dequeue." << endl;
            return;
        }

        PriorityQueueNode<T> *temp = front;
        front = front->next;

        cout << "Item with priority " << temp->priority << " dequeued from the queue." << endl;

        delete temp;
    }

    void display()
    {
        if (front == nullptr)
        {
            cout << "Queue is empty." << endl;
            return;
        }

        cout << "Items in the queue: ";
        PriorityQueueNode<T> *current = front;
        while (current != nullptr)
        {
            cout << "\n Data : " << current->data << " (Priority : " << current->priority << ") ";
            current = current->next;
        }
        cout << endl;
    }
};

int main()
{
    PriorityQueue<int> intPriorityQueue;

    int choice, data, priority;

    do
    {
        cout << "\nMenu:\n";
        cout << "1. Enqueue\n";
        cout << "2. Dequeue\n";
        cout << "3. Display\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice)
        {
        case 1:
            cout << "Enter data to enqueue: ";
            cin >> data;
            cout << "Enter priority: ";
            cin >> priority;
            intPriorityQueue.enqueue(data, priority);
            break;

        case 2:
            intPriorityQueue.dequeue();
            break;

        case 3:
            intPriorityQueue.display();
            break;

        case 4:
            cout << "Exiting program.\n";
            break;

        default:
            cout << "Invalid choice. Please enter a valid option.\n";
        }
    } while (choice != 4);

    return 0;
}
