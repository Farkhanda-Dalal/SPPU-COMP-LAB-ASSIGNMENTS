#include <iostream>
#include <string>

class Publication {
protected:
    std::string title;
    float price;

public:
    Publication() : title(""), price(0.0) {}

    void getData() {
        std::cout << "Enter the title: ";
        std::cin >> title;
        std::cout << "Enter the price: ";
        std::cin >> price;
    }

    void displayData() {
        std::cout << "Title: " << title << std::endl;
        std::cout << "Price: $" << price << std::endl;
    }
};

class Book : public Publication {
private:
    int pageCount;

public:
    Book() : pageCount(0) {}

    void getData() {
        Publication::getData();
        std::cout << "Enter the page count: ";
        std::cin >> pageCount;
    }

    void displayData() {
        Publication::displayData();
        std::cout << "Page Count: " << pageCount << " pages" << std::endl;
    }
};

class Tape : public Publication {
private:
    float playingTime;

public:
    Tape() : playingTime(0.0) {}

    void getData() {
        Publication::getData();
        std::cout << "Enter the playing time (minutes): ";
        std::cin >> playingTime;
    }

    void displayData() {
        Publication::displayData();
        std::cout << "Playing Time: " << playingTime << " minutes" << std::endl;
    }
};

int main() {
    Book book;
    Tape tape;

    try {
        std::cout << "Enter book details:" << std::endl;
        book.getData();

        std::cout << "\nEnter audio cassette details:" << std::endl;
        tape.getData();

        std::cout << "\nBook details:" << std::endl;
        book.displayData();

        std::cout << "\nAudio cassette details:" << std::endl;
        tape.displayData();
    } catch (...) {
        std::cerr << "An exception occurred. Resetting all data member values to zero." << std::endl;
        book = Book();
        tape = Tape();
    }

    return 0;
}
