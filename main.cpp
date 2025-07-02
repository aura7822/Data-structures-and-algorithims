#include<iostream>
using namespace std;
struct Node{
    int data;
    Node* next;
};
void InsertAtBeginning(Node* &head, int value){
    Node* newNode = new Node();
    newNode->data = value;
    newNode->next = head;
    head = newNode;
}
void InsertAtEnd(Node* &head, int value){
    Node* newNode = new Node();
    newNode->data = value;
    newNode->next = nullptr;
    if(head == nullptr){
        head = newNode;
        return;
    }
    Node* temp = head;
    while(temp->next != nullptr){
        temp = temp->next;
    }
    temp->next = newNode;
}
int main(){
    Node* head = nullptr;
    InsertAtBeginning(head, 10);
    InsertAtBeginning(head, 20);
    cout<<"After inserting at the beginning : ";
    printList(head);

    InsertAtEnd(head, 30);
    InsertAtEnd(head, 40);
    cout<<"After inserting at the end : ";
    printList(head);

    return 0;
}
