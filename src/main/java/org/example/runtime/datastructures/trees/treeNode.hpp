#pragma once

#include <stdlib.h>
#include <stdio.h>
#include <string>

using namespace std;

template <typename T>
struct TreeNode {
    T data;
    TreeNode* left;
    TreeNode* right;
    int height;
};

template <typename T>
TreeNode<T> treeNode_init(T data) {
   TreeNode<T> node; 
   node.height = 1;
   node.data = data;
   node.left = NULL;
   node.right = NULL;
   return node;
} 

template <typename T>
T treeNode_getData(TreeNode<T> node) {
    return node.data;
} 

template <typename T>
void treeNode_setData(TreeNode<T> node, T data) {
    node.data = data;
} 

template <typename T>
TreeNode<T> treeNode_getLeft(TreeNode<T> node) {
    return node.left;
} 

template <typename T>
TreeNode<T> treeNode_getRight(TreeNode<T> node) {
    return node.right;
} 