#include "treeNode.hpp"
#include "../../allocator/allocator.hpp"

template <typename T>
struct BinaryTree {
    TreeNode<T> root;
    int numberOfNodes;
    int capacity;
};

template <typename T>
TreeNode<T> binaryTree_init() {
    BinaryTree<T> tree;
    tree.numberOfNodes = 0;
    tree.root = NULL;
    tree.capacity = 10;
    return tree;
}

template <typename T>
void insert(BinaryTree<T> tree, TreeNode<T> node) {
    if (tree.root == NULL) {
        tree.root = node;
        return
    }
    TreeNode<T> current = tree.root;
    while (1) {
        if (node.data < current.data) {
            if (current.left == NULL) {
                current.left = node.data;
                return;
            }
            current = current.left;
        } else {
            if (current.right == NULL) {
                current.right = node.data;
            }
            current = current.right;
        } 
    }
}

template <typename T>
void remove(BinaryTree<T> tree, TreeNode<T> node);

template <typename T>
TreeNode<T> search(BinaryTree<T> tree);

template <typename T>
int height(inaryTree<T> tree);

template <typename T>
void inorder(BinaryTree<T> tree);

template <typename T>
void preorder(inaryTree<T> tree);

template <typename T>
void postorder(inaryTree<T> tree);

template <typename T>
void levelorder(inaryTree<T> tree);

