#include <iostream>
using namespace std;
struct Node {
    int   data;
    Node* next;
};

Node* arrayToList(const int arr[], size_t s) {
//   creates a list of objects of type Node containing as data the numbers from the array
    Node *head = NULL, *tail = NULL, *n;
    for(size_t i=0; i<s; ++i){
        n = new Node();
        n->data = arr[i];
        n->next = NULL;

        if(head==NULL){
            head = n;
            tail = n;
            n = NULL;
        }
        else{
            tail->next = n;
            tail = n;
        }
    }
    return head;
}

Node* removeOdd(Node* head) {
//        returns the pointernto the head of the list in which all nodes 
//		containing an odd number as data are removed

    Node *head2 = nullptr, *tail = NULL;
    while(head!=NULL){
        if((head->data) %2 == 0){
            if(head2==nullptr){
                head2 = head;
                tail = head;
            }
            else{
                tail->next = head;
                tail = head;
            }
            head = head->next;
        }
        else {
            cout << "DEL:" << head->data << " ";
            Node *to_delete = head;
            head = head->next;
            delete to_delete;
        }
    }
    cout << endl;
    return head2;
}

void showList(const Node* head) {
//        prints the content of the list 
    if(head==NULL) cout << "Empty list";
    while(head!=NULL){
        cout << head->data << " ";
        head = head->next;
    }
    cout<<endl;
}

void deleteList(Node*& head) {
//       deletes all nodes of the list;
    while(head!=NULL){
        cout<< "del:" << head->data << " ";
        Node *to_delete = head;
        head = head->next;
        delete to_delete;
    }
    head = nullptr;
    cout<<endl;
}

int main() {


    cout<<endl<<"TEST2"<<endl;
    int arr2[] = {1,1,3,1,5,6};
    s = sizeof(arr2)/sizeof(*arr2);
    head = arrayToList(arr2,s);
    showList(head);
    head = removeOdd(head);
    showList(head);
    deleteList(head);
    showList(head);

    cout<<endl<<"TEST3"<<endl;
    int arr3[] = {1,1,3,1,5,1};
    s = sizeof(arr3)/sizeof(*arr3);
    head = arrayToList(arr3,s);
    showList(head);
    head = removeOdd(head);
    showList(head);
    deleteList(head);
    showList(head);
}
