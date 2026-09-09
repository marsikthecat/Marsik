#pragma once

#include "treenode.hpp"
#include <algorithm>
#include <iostream>
#include <queue>

using namespace std;

template <typename T>
struct BinaryTree {
    TreeNode<T>* root;
    int numberOfNodes;
    int capacity;
};

template <typename T>
BinaryTree<T> init_binarytree() {
    BinaryTree<T> tree{};
    tree.root = nullptr;
    tree.numberOfNodes = 0;
    tree.capacity = 10;
    return tree;
}

template <typename T>
void binarytree_insert(BinaryTree<T>& tree, T data) {
    TreeNode<T>* node = new TreeNode<T>(init_treenode(data));
    if (tree.root == nullptr) {
        tree.root = node;
        tree.numberOfNodes++;
        return;
    }
    TreeNode<T>* current = tree.root;
    while (true) {
        if (node->data < current->data) {
            if (current->left == nullptr) {
                current->left = node;
                tree.numberOfNodes++;
                return;
            }
            current = current->left;
        } else {
            if (current->right == nullptr) {
                current->right = node;
                tree.numberOfNodes++;
                return;
            }
            current = current->right;
        }
    }
}

template <typename T>
TreeNode<T>* binarytree_removeNode(TreeNode<T>* root, T data) {
    if (root == nullptr) return nullptr;
    if (data < root->data) root->left = binarytree_removeNode(root->left, data);
    else if (data > root->data) root->right = binarytree_removeNode(root->right, data);
    else if (root->left == nullptr) return root->right;
    else if (root->right == nullptr) return root->left;
    else {
        TreeNode<T>* successor = root->right;
        while (successor->left != nullptr) successor = successor->left;
        root->data = successor->data;
        root->right = binarytree_removeNode(root->right, successor->data);
    }
    return root;
}

template <typename T>
void binarytree_remove(BinaryTree<T>& tree, T data) {
    tree.root = binarytree_removeNode(tree.root, data);
}

template <typename T>
TreeNode<T> binarytree_search(BinaryTree<T> tree, T data) {
    TreeNode<T>* current = tree.root;
    while (current != nullptr) {
        if (data == current->data) return *current;
        current = data < current->data ? current->left : current->right;
    }
    return init_treenode(T{});
}

template <typename T>
int binarytree_heightNode(TreeNode<T>* root) {
    if (root == nullptr) return 0;
    return max(binarytree_heightNode(root->left), binarytree_heightNode(root->right)) + 1;
}

template <typename T>
int binarytree_height(BinaryTree<T> tree) {
    return binarytree_heightNode(tree.root);
}

template <typename T>
void binarytree_inorderNode(TreeNode<T>* root) {
    if (root == nullptr) return;
    binarytree_inorderNode(root->left);
    cout << root->data << " ";
    binarytree_inorderNode(root->right);
}

template <typename T>
void binarytree_inorder(BinaryTree<T> tree) { binarytree_inorderNode(tree.root); }

template <typename T>
void binarytree_preorderNode(TreeNode<T>* root) {
    if (root == nullptr) return;
    cout << root->data << " ";
    binarytree_preorderNode(root->left);
    binarytree_preorderNode(root->right);
}

template <typename T>
void binarytree_preorder(BinaryTree<T> tree) { binarytree_preorderNode(tree.root); }

template <typename T>
void binarytree_postorderNode(TreeNode<T>* root) {
    if (root == nullptr) return;
    binarytree_postorderNode(root->left);
    binarytree_postorderNode(root->right);
    cout << root->data << " ";
}

template <typename T>
void binarytree_postorder(BinaryTree<T> tree) { binarytree_postorderNode(tree.root); }

template <typename T>
void binarytree_levelorder(BinaryTree<T> tree) {
    if (tree.root == nullptr) return;
    queue<TreeNode<T>*> nodes;
    nodes.push(tree.root);
    while (!nodes.empty()) {
        TreeNode<T>* current = nodes.front();
        nodes.pop();
        cout << current->data << " ";
        if (current->left != nullptr) nodes.push(current->left);
        if (current->right != nullptr) nodes.push(current->right);
    }
}
