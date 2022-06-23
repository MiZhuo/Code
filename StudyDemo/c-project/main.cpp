#include <iostream>
#include "com_example_demo_NativeTest.h"
using namespace std;

int main() {
    Java_com_example_demo_NativeTest_sayHello(nullptr, nullptr);
    jstring jstring1 = (jstring) "法法";
    jstring str = Java_com_example_demo_NativeTest_callBack(nullptr, nullptr,jstring1);
    cout << str << endl;
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
