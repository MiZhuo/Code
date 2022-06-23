//
// Created by 迷浊 on 2020/12/20.
//
#include<iostream>
#include "com_example_demo_NativeTest.h"
using namespace std;

void Java_com_example_demo_NativeTest_sayHello(JNIEnv *, jclass) {
    cout << "Hello World!Here is C++" << endl;
}

jstring Java_com_example_demo_NativeTest_callBack(JNIEnv *, jclass, jstring str) {
    return str;
}
