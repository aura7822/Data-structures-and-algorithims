#include<iostream>
using namespace std;
#define MAX_SIZE 100
class Stack{
private :
   int stack MAX_SIZE, top;
public :
   Stack(){
      top = -1;
   }
   bool isEmpty(){
      return(top == -1);
   }
   bool isFull(){
      return(top == MAX_SIZE - 1);
   }
   //pushing
   void push(int value){
      if(isFull()){
         cout<<"Stack overflow ! cannot push"<<value<<endl;
         return;
      }
      stack[++top]=value;
      cout<<"Pushed : "<<value<<" into the stack"<<endl;
   }
   //popping
   int pop(){
      if(isEmpty()){
         cout<<"Cannot pop from an empty stack!"<<endl;
         return -1;
      }
      return stack[top--];
   }
   //peeking
   int peek(){
      if(isEmpty()){
         cout<<"Stack is empty"<<endl;
         return -1;
      }
      return stack[top];
   }
};
int main(){
   Stack s;
   s.push(10);
   s.push(20);
   s.push(30);

   cout<<"Top element : "<<s.peek()<<endl;
   cout<<"Popped"<<s.pop()<<endl;
}
