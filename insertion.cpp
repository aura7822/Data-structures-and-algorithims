//inserting of array elements
#include<iostream>
using namespace std;
int main(){
   const int SIZE = 5;
   int arr[SIZE] = {}, i;

   cout<<"Array before Insertion : \n"<<endl;
   for(int i = 0;i<SIZE; i++){
      cout<<"arr["<<i<<"] ="<<arr[i]<<endl;
   }
   cout<<"\n=== Inserting Array Elements ===\n"<<endl;
   for(int i = 0; i<SIZE; i++){
      arr[i] = i+2;
   }
   cout<<"Array after Insertion : \n"<<endl;
   for(int i = 0;i<SIZE; i++){
      cout<<"arr["<<i<<"] ="<<arr[i]<<endl;
   }
   return 0;
}
