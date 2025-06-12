//program to demonstrate removing of elements in stacks using c++
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
    cout << "Enter the numbers you want to insert : ";
    cin >> n;

    for (int i = 1; i <= n; ++i) {
        cout << "Enter number " << i << ": ";
        cin >> value;
        numbers.push(value);
    }

    cout << "\nRemoving elements from the stack:\n";

    while (!numbers.empty()) {
        cout << "Popped: " << numbers.top() << endl;
        numbers.pop();
    }

    cout << "✅ Stack is now empty.\n";

    return 0;
}
