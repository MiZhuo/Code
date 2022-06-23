cmake_minimum_required(VERSION 3.17)
project(c_project)

set(CMAKE_CXX_STANDARD 14)

##add_executable(c_project main.cpp com_example_demo_NativeTest.cpp)
add_library(c_project SHARED com_example_demo_NativeTest.cpp)