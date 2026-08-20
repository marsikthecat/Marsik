#include "treeNode.hpp"
#include "../../allocator/allocator.hpp"
#include "../../error/error.hpp"

using namespace std;

template <typename T>
struct AVLTree {
    TreeNode<T> root;
    int numberOfNodes;
    int capacity;
};

template <typename T>
AVLTree<T> avlTree_init() {
    AVLTree<T> tree;
    tree.numberOfNodes = 0;
    tree.root = NULL;
    tree.capacity = 10;
    return tree;
}

template <typename T>
int avlTree_balance(TreeNode<T> node) {
    return node == NULL ? 0 : avlTree_getHeight(node.right)
        - avlTree_getHeight(node.left);
}

template <typename T>
void avlTree_updateHeight(TreeNode<T> node) {
    int heightOfLeft = avlTree_getHeight(node.left);
    int heightOfRight = avlTree_getHeight(node.right);
    node.height = max(heightOfLeft, heightOfRight) + 1;
}


template <typename T>
TreeNode<T> avlTree_rotateLeft(TreeNode<T> node) {
    TreeNode<T> n1 = node.right;
    TreeNode<T> n2 = n1.left;
    n1.left = node;
    node.right = n2;
    avlTree_updateHeight(node);
    avlTree_updateHeight(n1);
    return n1;
}

template <typename T>
TreeNode<T> avlTree_rotateRight(TreeNode<T> node) {
    TreeNode<T> n1 = node.left;
    TreeNode<T> n2 = n1.right;
    n1.right = node;
    node.left = n2;
    avlTree_updateHeight(node);
    avlTree_updateHeight(n1);
    return n1;
}

template <typename T>
TreeNode<T> avlTree_bringTreeToBalance(TreeNode<T> root) {
    avlTree_updateHeight(root);
    int balance = avlTree_balance(root);
    if (balance > 1) {
        if (avlTree_balance(root.right) < 0) {
            root.right = avlTree_rotateRight(root.right);
        }
        return avlTree_rotateLeft(root);
    }
    if (balance < -1) {
        if (avlTree_balance(root.left) > 0) {
            root.left = avlTree_rotateLeft(root.left);
        }
        return avlTree_rotateRight(root);
    }
    return root;
}

template <typename T>
TreeNode<T> avlTree_bstInsert(TreeNode<T> root, TreeNode<T> node) {
    if (root == NULL) {
        return node;
    }
    if (node.data < root.data) {
        root.left = avlTree_bstInsert(root.left, node);
    } else {
        root.right = avlTree_bstInsert(root.right, node);
    }
    return avlTree_bringTreeToBalance(root);
}

template <typename T>
void avlTree_insert(AVLTree<T>* tree, TreeNode<T> node) {
    if (node == NULL) {
        return;
    }
    tree->root = avlTree_bstInsert(tree->root, node);
    tree->numberOfNodes++;
}

template <typename T>
TreeNode<T> avlTree_successor(TreeNode<T> root) {
    return root.left == NULL ? root : avlTree_successor(root.left);
}

template <typename T>
TreeNode<T> avlTree_remove(TreeNode<T> root, T data) {
    if (root == NULL) {
        return NULL;
    }
    if (data < root.data) {
        root.left = avlTree_remove(root.left, data);
    } else if (data > root.data) {
        root.right = avlTree_remove(root.right, data);
    } else {
        if (root.right == NULL) {
            root = root.left;
        } else if (root.left == NULL) {
            root = root.right;
        } else {
            TreeNode<T> n = avlTree_successor(root.right);
            root.data = n.data;
            root.right = avlTree_remove(root.right, root.data );
        }
    }
    if (root == NULL) {
        return NULL;
    }
    return avlTree_bringTreeToBalance(root);
}

template <typename T>
void avlTree_delete(AVLTree<T>* tree, T data) {
    if (avlTree_search(tree, data) != NULL) {
        tree->root = avlTree_remove(tree->root, data);
        tree->numberOfNodes--;
    }
}

template <typename T>
TreeNode<T> avlTree_findNode(TreeNode<T> root, T data) {
    if (root == NULL || data == root.data) {
        return root;
    }
    return data < root.data ? avlTree_findNode(root.left, data)
        : avlTree_findNode(root.right, data);
}

template <typename T>
TreeNode<T> avlTree_search( AVLTree<T>* tree, T data) {
    return avlTree_findNode(tree->root, data);
}

template <typename T>
bool avlTree_contains(AVLTree<T>* tree, T data) {
    return avlTree_search(tree, data) != NULL;
}

template <typename T>
int avlTree_height(AVLTree<T>* tree) {
    return avlTree_getHeight(tree->root);
}

template <typename T>
void avlTree_inorder(TreeNode<T> root) {
    if (root == NULL) {
        return;
    }
    avlTree_inorder(root.left);
    cout << root.data << " ";
    avlTree_inorder(root.right);
}

template <typename T>
void avlTree_inorder(AVLTree<T>* tree) {
    if (tree->root == NULL) {
        runtimeWarning("Tree does not have any nodes");
        return;
    }
    avlTree_inorder(tree->root);
}


template <typename T>
void avlTree_preorder(TreeNode<T> root) {
    if (root == NULL) {
        return;
    }
    cout << root.data << " ";
    avlTree_preorder(root.left);
    avlTree_preorder(root.right);
}

template <typename T>
void avlTree_preorder(AVLTree<T>* tree) {
    if (tree->root == NULL) {
        runtimeWarning("Tree does not have any nodes");
        return;
    }

    avlTree_preorder(tree->root);
}

template <typename T>
void avlTree_postorder(TreeNode<T> root) {
    if (root == NULL) {
        return;
    }
    avlTree_postorder(root.left);
    avlTree_postorder(root.right);
    cout << root.data << " ";
}

template <typename T>
void avlTree_postorder(AVLTree<T>* tree) {
    if (tree->root == NULL) {
        runtimeWarning("Tree does not have any nodes");
        return;
    }
    avlTree_postorder(tree->root);
}