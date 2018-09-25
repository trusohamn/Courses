#include <iostream>
using std::cout; using std::endl;

size_t length(const char* cstr);
bool   isLetter(char c);
char*  reverse(char* cstr);
size_t words(const char* cstr);
size_t words2(const char* cstr);
char*  concat(char* t, const char* s);

int main() {

    cout << "is b a letter: " << isLetter('b')<< endl;
    cout << "is space a letter: " << isLetter(' ')<< endl;
    char s4[] = "Marta Alabrudzinska";
    cout << "reverse: " << reverse(s4) << endl;
    cout << "reverse bis: " << reverse(s4) << endl;
    cout << "length : " << length(s4)  << endl;
    cout << "words  : " << words(s4)  << endl;
    cout << "concat : "<< concat(concat(s4,", s"),"14010") << endl;


}

// definitions of functions
size_t length(const char* cstr){
    //returns the length of the C-string 
    const char* l = cstr;
    while ( *l++ );
    return l - cstr - 1;
}
bool   isLetter(char c){
    //checks if the passed character is a letter (upper and lowercase)
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
}
char*  reverse(char* cstr){
    //reverses the order of characters in the C-string

    //deep copy of cstr
    char* t2 = new char[length(cstr) + 1];
    char *c = cstr - 1;
    while ( *++t2 = *++c);

    //copy of pointer
    char *cp = cstr - 1;

    while ( *++cp){
        //cout << *cp;
        *cp = *--t2;
        //cout << *cp << endl;
    }
    return cstr;
}
size_t words(const char* cstr){
    //returns the number of words in the C-string cstr; 
    int words = 0;
    cstr = cstr -1;
    bool startBreak = true;
    while(*++cstr){
        if(startBreak && isLetter(*cstr)){
            //cout << *cstr << endl;
            startBreak = false;
            ++words;
        }
        else if (!isLetter(*cstr)) startBreak = true;
    }
    return words;
}
size_t words2(const char* cstr){
    //returns the number of words at least 2 letters long
    int words = 0;
    cstr = cstr -1;
    bool firstLetter = false;
    bool startBreak = true;
    while(*++cstr){
        if(startBreak && isLetter(*cstr)){
            if(firstLetter){
              ++words;
              startBreak = false;
              firstLetter = false;
              //cout << *cstr << endl;
            }
            else firstLetter = true;
        }
        else if (!isLetter(*cstr)) {
                startBreak = true;
                firstLetter = false;
        }
    }
    return words;
}
char*  concat(char* t, const char* s){
    //concatenates a C-string s to t; 
    char* t2 = t - 1;
    while ( *++t2 );
    while ( *t2++ = *s++ );
    return t;
}
