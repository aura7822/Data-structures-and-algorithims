<a href="https://git.io/typing-svg">
  <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&size=26&pause=600&color=33FF00&center=true&vCenter=true&width=950&lines=Data+Structures+%26+Algorithms+in+C++;Linear+%26+Non-Linear+Structures;By+Aura" alt="Typing SVG" />
</a>

<div align="center">

<img src="https://img.shields.io/badge/Language-C++-blue?style=for-the-badge&logo=c%2B%2B&logoColor=white" />
<img src="https://img.shields.io/badge/Status-Active-success?style=for-the-badge&logo=github" />
<img src="https://img.shields.io/badge/Focus-DSA-red?style=for-the-badge" />

</div>

---

# 📚 Data Structures & Algorithms – C++

This repository contains **implementations of core Data Structures & Algorithms in C++**,  
covering both **linear** and **non-linear** structures 🚀.

---

## 📂 Repository Structure
📦 dsa-cpp
┣ 📂 linear
┃ ┣ array.cpp
┃ ┣ linked_list.cpp
┃ ┣ stack.cpp
┃ ┗ queue.cpp
┣ 📂 non_linear
┃ ┣ binary_tree.cpp
┃ ┣ graph.cpp
┃ ┗ heap.cpp
┗ README.md

yaml
Copy code

---

## ✨ Topics Covered
- ✅ Arrays & Strings  
- ✅ Linked Lists (Singly, Doubly, Circular)  
- ✅ Stacks & Queues  
- ✅ Trees (Binary Tree, BST)  
- ✅ Graphs (BFS, DFS)  
- ✅ Heaps & Priority Queues  
- ✅ Sorting & Searching Algorithms  

---

## 🚀 Getting Started
### 🔧 Prerequisites
- Install [C++ Compiler (g++)](https://gcc.gnu.org/)  
- Any IDE or text editor (VS Code recommended ⚡)

### ▶️ Compile & Run
```bash
g++ array.cpp -o array
./array
🔹 Linear Data Structures
📌 Array Example
cpp
Copy code
#include <iostream>
using namespace std;

int main() {
    int arr[5] = {10, 20, 30, 40, 50};

    cout << "Array elements: ";
    for (int i = 0; i < 5; i++) {
        cout << arr[i] << " ";
    }
    return 0;
}
📌 Stack Example
cpp
Copy code
#include <iostream>
#include <stack>
using namespace std;

int main() {
    stack<int> st;
    st.push(1);
    st.push(2);
    st.push(3);

    cout << "Stack top: " << st.top() << endl;
    st.pop();
    cout << "After pop, top: " << st.top() << endl;

    return 0;
}
🔹 Non-Linear Data Structures
📌 Binary Tree Example
cpp
Copy code
#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    Node(int val) {
        data = val;
        left = right = NULL;
    }
};

void inorder(Node* root) {
    if (root == NULL) return;
    inorder(root->left);
    cout << root->data << " ";
    inorder(root->right);
}

int main() {
    Node* root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);

    cout << "Inorder Traversal: ";
    inorder(root);

    return 0;
}
📌 Graph Example (Adjacency List)
cpp
Copy code
#include <iostream>
#include <vector>
using namespace std;

int main() {
    int V = 5;
    vector<int> adj[V];

    adj[0].push_back(1);
    adj[0].push_back(4);
    adj[1].push_back(2);
    adj[1].push_back(3);

    cout << "Graph adjacency list:" << endl;
    for (int i = 0; i < V; i++) {
        cout << i << " -> ";
        for (int x : adj[i]) cout << x << " ";
        cout << endl;
    }
    return 0;
}
⚡ Contribution
Want to add more algorithms (sorting, searching, dynamic programming)?
Fork the repo and submit a pull request 🔥.

⚠️ Disclaimer
This repo is purely for educational purposes.
Not optimized for competitive programming — meant for learning & revision.

<div align="center">
💡 "Programs must be written for people to read, and only incidentally for machines to execute." – Harold Abelson

⭐ Star the repo if you find it useful!

</div> ```
