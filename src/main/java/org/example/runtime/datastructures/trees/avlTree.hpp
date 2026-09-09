#pragma once

#include "treenode.hpp"
#include <algorithm>
#include <iostream>

using namespace std;

template <typename T>
struct AvlTree {
    TreeNode<T>* root;
    int numberOfNodes;
    int capacity;
};

template <typename T>
AvlTree<T> init_avltree() {
    AvlTree<T> tree{};
    tree.root = nullptr;
    tree.numberOfNodes = 0;
    tree.capacity = 10;
    return tree;
}

template <typename T>
int avltree_getHeight(TreeNode<T>* node) { return node == nullptr ? 0 : node->height; }

template <typename T>
void avltree_updateHeight(TreeNode<T>* node) {
    if (node != nullptr) node->height = max(avltree_getHeight(node->left), avltree_getHeight(node->right)) + 1;
}

template <typename T>
int avltree_balance(TreeNode<T>* node) { return node == nullptr ? 0 : avltree_getHeight(node->right) - avltree_getHeight(node->left); }

template <typename T>
TreeNode<T>* avltree_rotateLeft(TreeNode<T>* node) {
    TreeNode<T>* replacement = node->right;
    node->right = replacement->left;
    replacement->left = node;
    avltree_updateHeight(node);
    avltree_updateHeight(replacement);
    return replacement;
}

template <typename T>
TreeNode<T>* avltree_rotateRight(TreeNode<T>* node) {
    TreeNode<T>* replacement = node->left;
    node->left = replacement->right;
    replacement->right = node;
    avltree_updateHeight(node);
    avltree_updateHeight(replacement);
    return replacement;
}

template <typename T>
TreeNode<T>* avltree_balanceNode(TreeNode<T>* node) {
    if (node == nullptr) return nullptr;
    avltree_updateHeight(node);
    int balance = avltree_balance(node);
    if (balance > 1) {
        if (avltree_balance(node->right) < 0) node->right = avltree_rotateRight(node->right);
        return avltree_rotateLeft(node);
    }
    if (balance < -1) {
        if (avltree_balance(node->left) > 0) node->left = avltree_rotateLeft(node->left);
        return avltree_rotateRight(node);
    }
    return node;
}

template <typename T>
TreeNode<T>* avltree_insertNode(TreeNode<T>* root, TreeNode<T>* node) {
    if (root == nullptr) return node;
    if (node->data < root->data) root->left = avltree_insertNode(root->left, node);
    else root->right = avltree_insertNode(root->right, node);
    return avltree_balanceNode(root);
}

template <typename T>
void avltree_insert(AvlTree<T>& tree, T data) {
    tree.root = avltree_insertNode(tree.root, new TreeNode<T>(init_treeNode(data)));
    tree.numberOfNodes++;
}

template <typename T>
TreeNode<T>* avltree_findNode(TreeNode<T>* root, T data) {
    if (root == nullptr || root->data == data) return root;
    return data < root->data ? avltree_findNode(root->left, data) : avltree_findNode(root->right, data);
}

template <typename T>
TreeNode<T>* avltree_minNode(TreeNode<T>* root) {
    while (root != nullptr && root->left != nullptr) root = root->left;
    return root;
}

template <typename T>
TreeNode<T>* avltree_removeNode(TreeNode<T>* root, T data) {
    if (root == nullptr) return nullptr;
    if (data < root->data) root->left = avltree_removeNode(root->left, data);
    else if (data > root->data) root->right = avltree_removeNode(root->right, data);
    else if (root->left == nullptr) return root->right;
    else if (root->right == nullptr) return root->left;
    else {
        TreeNode<T>* successor = avltree_minNode(root->right);
        root->data = successor->data;
        root->right = avltree_removeNode(root->right, successor->data);
    }
    return avltree_balanceNode(root);
}

template <typename T>
void avltree_delete(AvlTree<T>& tree, T data) {
    if (avltree_findNode(tree.root, data) != nullptr) {
        tree.root = avltree_removeNode(tree.root, data);
        tree.numberOfNodes--;
    }
}

template <typename T>
TreeNode<T> avltree_search(AvlTree<T> tree, T data) {
    TreeNode<T>* node = avltree_findNode(tree.root, data);
    return node == nullptr ? init_treeNode(T{}) : *node;
}

template <typename T>
bool avltree_contains(AvlTree<T> tree, T data) { return avltree_findNode(tree.root, data) != nullptr; }

template <typename T>
int avltree_height(AvlTree<T> tree) { return avltree_getHeight(tree.root); }

template <typename T>
void avltree_inorderNode(TreeNode<T>* node) {
    if (node == nullptr) return;
    avltree_inorderNode(node->left);
    cout << node->data << " ";
    avltree_inorderNode(node->right);
}

template <typename T>
void avltree_inorder(AvlTree<T> tree) { avltree_inorderNode(tree.root); }

template <typename T>
void avltree_preorderNode(TreeNode<T>* node) {
    if (node == nullptr) return;
    cout << node->data << " ";
    avltree_preorderNode(node->left);
    avltree_preorderNode(node->right);
}

template <typename T>
void avltree_preorder(AvlTree<T> tree) { avltree_preorderNode(tree.root); }

template <typename T>
void avltree_postorderNode(TreeNode<T>* node) {
    if (node == nullptr) return;
    avltree_postorderNode(node->left);
    avltree_postorderNode(node->right);
    cout << node->data << " ";
}

template <typename T>
void avltree_postorder(AvlTree<T> tree) { avltree_postorderNode(tree.root); }
