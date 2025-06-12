//program to demonstrate insertion of elements in stacks
/*
NAME : Aura Joshua
ADM NO : BSE-05-018-/2024
GROUP : 3
DATE : 10TH june
GITHUB USERNAME : aura7822
 */
#include <iostream>
#include <stack>
using namespace std;

int main() {
    stack<int> numbers;
    int n, value;
cout << "Enter numbers you want to insert : ";
    cin >> n;

    for (int i = 1; i <= n; ++i) {
        cout << "Enter number " << i << ": ";
        cin >> value;
        numbers.push(value);
        cout << "Inserted : " << value << endl;
        cout << "Current top: " << numbers.top() << "\n\n";
    }

    return 0;
}
