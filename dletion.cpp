#include<iostream>
using namespace std;
struct Node{
    int data;
    Node* next;
};
void InsertionAtBeginning(Node* &head, int value){
    Node* newNode = new Node{value, head};
    head = newNode;
}void printList(Node* head){
    Node* temp = head;
    while(temp != nullptr){
        cout<< temp->data<<"->";
        head = temp->next;
    }
    cout<<"NULL"<<endl;
}
void deleteNode(Node* &head, int value){
    if(head == nullptr)return;
    //at beginning
    if(head->data == value){
        Node* temp = head;
        head = head->next;
        delete temp;
        return;
    }
    //middle or end
    Node* prev = head;
    Node curr = curr->next;
    while(curr != nullptr && curr-> data != value){
        prev = curr;
        curr = curr->next;
    }
}
int main(){

    Node* head = nullptr;
InsertionAtEnd(head, 10);
InsertionAtEnd(head, 20);
InsertionAtEnd(head, 30);
InsertionAtEnd(head, 40);
    cout<<"Original list : ";
    printList(head);

    deleteNode(head 10);
    cout<<"After deleting head(10)"
    printList(head);
      return 0;
}
