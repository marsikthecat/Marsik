#pragma once

#include <stdlib.h>
#include <stdio.h>
#include "../../string.hpp"

template <typename T>
struct TreeNode {
    string key;
    T data;
    TreeNode* left;
    TreeNode* right;
};

template <typename T>
TreeNode<T> treeNode_init(T data) {
   TreeNode<T> node; 
   node.data = data;
   node.left = NULL;
   node.right = NULL;
   return node.data;
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

template <typename T>
T treeNode_getKey(TreeNode<T> node) {
    return node.key;
} 