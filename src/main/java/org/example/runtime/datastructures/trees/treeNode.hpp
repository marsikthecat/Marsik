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
TreeNode<T> init_treenode(T data) {
   TreeNode<T> node; 
   node.height = 1;
   node.data = data;
   node.left = NULL;
   node.right = NULL;
   return node;
} 

template <typename T>
T treenode_getData(TreeNode<T> node) {
    return node.data;
} 

template <typename T>
void treenode_setData(TreeNode<T> node, T data) {
    node.data = data;
} 

template <typename T>
TreeNode<T> treenode_getLeft(TreeNode<T> node) {
    return node.left;
} 

template <typename T>
TreeNode<T> treenode_getRight(TreeNode<T> node) {
    return node.right;
} 