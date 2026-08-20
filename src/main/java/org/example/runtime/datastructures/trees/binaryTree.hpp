#include "treeNode.hpp"
#include "../../allocator/allocator.hpp"

using namespace std;

template <typename T>
struct BinaryTree {
    TreeNode<T> root;
    int numberOfNodes;
    int capacity;
};

template <typename T>
TreeNode<T> binaryTree_init() {
    BinaryTree<T> tree;
    tree.root = NULL;
    tree.numberOfNodes = 0;
    tree.capacity = 10;
    return tree;
}

template <typename T>
void binaryTree_insert(BinaryTree<T> tree, T data) {
    TreeNode<T> node = treeNode_init(data);
    if (tree.root == NULL) {
        tree.root = node;
        tree.numberOfNodes++;
        return;
    }
    TreeNode<T> current = tree.root;
    while (1) {
        if (node.data < current.data) {
            if (current.left == NULL) {
                current.left = node;
                tree.numberOfNodes++;
                return;
            }
            current = current.left;
        } else {
            if (current.right == NULL) {
                current.right = node;
                tree.numberOfNodes++;
                return;
            }
            current = current.right;
        } 
    }
}

template <typename T>
void binaryTree_remove(BinaryTree<T> tree, T data) {
    TreeNode<T> node = treeNode_init(data);
    if (tree.root == NULL) {
        return;
    }
    if (node.data < tree.root.data) {
        binaryTree_remove(tree.root.left, node);
    } else if (node.data > tree.root.data) {
        binaryTree_remove(tree.root.right, node);
    } else {
        if (tree.root.left == NULL && tree.root.right == NULL) {
            tree.root = NULL;
        } else if (tree.root.left == NULL) {
            tree.root = tree.root.right;
        } else if (tree.root.right == NULL) {
            tree.root = tree.root.left;
        } else {
            TreeNode<T> temp = findMin(tree.root.right);
            tree.root.data = temp.data;
            remove(tree.root.right, temp);
        }
    }
}
template <typename T>
TreeNode<T> binaryTree_search(BinaryTree<T> tree, T data) {
    if (tree.root == NULL) {
        return NULL;
    }
    TreeNode<T> current = tree.root;
    while (current != NULL) {
        if (data < current.data) {
            current = current.left;
        } else if (data > current.data) {
            current = current.right;
        } else {
            return current;
        }
    }
    return NULL;
}
    
template <typename T>
int binaryTree_height(BinaryTree<T> tree) {
    if (tree.root == NULL) {
        return 0;
    }
    int leftHeight = binaryTree_height(tree.root.left);
    int rightHeight = binaryTree_height(tree.root.right);
    return max(leftHeight, rightHeight) + 1;
}

template <typename T>
void binaryTree_inorder(BinaryTree<T> tree) {
    if (tree.root == NULL) {
        return;
    }
    binaryTree_inorder(tree.root.left);
    cout << tree.root.data << " ";
    binaryTree_inorder(tree.root.right);
}

template <typename T>
void binaryTree_preorder(BinaryTree<T> tree) {
    if (tree.root == NULL) {
        return;
    }
    cout << tree.root.data << " ";
    binaryTree_preorder(tree.root.left);
    binaryTree_preorder(tree.root.right);
}

template <typename T>
void binaryTree_postorder(BinaryTree<T> tree) {
    if (tree.root == NULL) {
        return;
    }
    binaryTree_postorder(tree.root.left);
    binaryTree_postorder(tree.root.right);
    cout << tree.root.data << " ";
}

template <typename T>
void binaryTree_levelorder(BinaryTree<T> tree) {
    if (tree.root == NULL) {
        return;
    }
    queue<TreeNode<T>> q;
    q.push(tree.root);
    while (!q.empty()) {
        TreeNode<T> current = q.front();
        q.pop();
        cout << current.data << " ";
        if (current.left != NULL) {
            q.push(current.left);
        }
        if (current.right != NULL) {
            q.push(current.right);
        }
    }
}