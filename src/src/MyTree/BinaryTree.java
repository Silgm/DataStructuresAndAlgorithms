package src.MyTree;

import javax.swing.text.LayoutQueue;
import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root;
    private int pos = 0;
    private int[] a = {1, 2, 4, 0, 0, 5, 0, 0, 3, 6, 0, 0, 7, 0, 0};

    //创建二叉树
    public Node createTree() {
        Node node = null;
        if (a[pos] != 0) {
            node = new Node();
            node.setData(a[pos]);
            pos++;
            node.setLetf(createTree());
            node.setRight(createTree());
        } else {
            pos++;
        }
        return node;
    }

    //前序遍历
    public void printTree_Pre(Node node) {
        if (node != null) {
            System.out.println(node.getData());
            printTree_Pre(node.getLetf());
            printTree_Pre(node.getRight());
        }
    }

    //中序遍历
    public void printTree_In(Node node) {
        if (node != null) {
            printTree_In(node.getLetf());
            System.out.println(node.getData());
            printTree_In(node.getRight());
        }
    }

    //后序遍历
    public void printTree_Post(Node node) {
        if (node != null) {
            printTree_Post(node.getLetf());
            printTree_Post(node.getRight());
            System.out.println(node.getData());
        }
    }

    //层序遍历
    public void printTree_Level(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> queen = new LinkedList<>();
        queen.add(root);
        while (!queen.isEmpty()) {
            Node node = queen.getFirst();
            System.out.println(node.getData());
            if (node.getLetf() != null) {
                queen.add(node.getLetf());
            }
            if (node.getRight() != null) {
                queen.add(node.getRight());
            }
            queen.removeFirst();
        }
    }

    //查找二叉树中的最大值
    public int findMax(Node node) {
        if (node != null) {
            int rootvalue = node.getData();
            int max = rootvalue;
            int leftvalue;
            int rightvalue;
            leftvalue = findMax(node.getLetf());
            rightvalue = findMax(node.getRight());
            if (leftvalue > max) {
                max = leftvalue;
            }
            if (rightvalue > max) {
                max = rightvalue;
            }
            return max;
        }
        return Integer.MIN_VALUE;
    }

    //判断二叉树是否含有指定元素
    public boolean hasData(Node node, int data) {
        boolean t = false;
        if (node != null) {
            if (node.getData() == data) {
                t = true;
            } else {
                t = hasData(node.getLetf(), data);
                if (t) {
                    return t;
                }
                t = hasData(node.getRight(), data);
                if (t) {
                    return t;
                }
            }
        }
        return t;
    }

    //获取二叉树节点个数
    public int size(Node node) {
        if (node != null) {
            return 1 + size(node.getLetf()) + size(node.getRight());
        } else {
            return 0;
        }
    }

    //删除二叉树
    public void deleteBinaryTree(Node node) {
        if (node == null) {
            return;
        } else {
            deleteBinaryTree(node.getLetf());
            deleteBinaryTree(node.getRight());
            node = null;
        }
    }

    //倒向输出二叉树
    public void printTree_Reverse(Node root) {
        LinkedList<Node> list = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        list.add(root);
        if (root == null) {
            return;
        }
        while (!list.isEmpty()) {
            Node node = list.getFirst();
            if (node.getLetf() != null) {
                list.add(node.getLetf());
            }
            if (node.getRight() != null) {
                list.add(node.getRight());
            }
            stack.push(node);
            list.removeFirst();
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().getData());
        }
    }

    //获取树的高度
    public int high(Node node) {
        if (node == null) {
            return 0;
        } else {
            int left_high = high(node.getLetf());
            int right_high = high(node.getRight());
            if (right_high > left_high) {
                return right_high + 1;
            } else {
                return left_high + 1;
            }
        }
    }

    //获取二叉树最深的节点
    public int deepestNode(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        queue.add(root);
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        while (!queue.isEmpty()) {
            Node node = queue.getFirst();
            if (node.getLetf() != null) {
                queue.add(node.getLetf());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
            stack.push(node);
            queue.removeFirst();
        }
        return stack.pop().getData();
    }

    //判断两个二叉树是否相同
    public boolean sameTree(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return false;
        } else {
            if ((node1.getData() == node2.getData()) &&
                    (sameTree(node1.getLetf(), node2.getRight())) &&
                    (sameTree(node1.getRight(), node2.getRight()))) {
                return true;
            } else {
                return false;
            }
        }
    }

    //找到元素值总和最大的一层
    public int bigestLevel(Node root) {
        if (root == null) {
            return 0;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int value = 0;
        int max = root.getData();
        int level = 0;
        int maxlevel = 1;
        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();
            if (node != null) {
                value += node.getData();
                if (node.getLetf() != null) {
                    queue.add(node.getLetf());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            } else {
                level++;
                if (value > max) {
                    max = value;
                    maxlevel = level;
                }
                value = 0;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
        return maxlevel;
    }

    //以下3个方法输出二叉树从根节点到所有叶子节点的路径
    public void printPaths(Node root) {
        int[] path = new int[256];
        printPaths(root, path, 0);
    }

    private void printPaths(Node node, int[] path, int len) {
        if (node == null) {
            return;
        }
        path[len++] = node.getData();
        if (node.getLetf() == null && node.getRight() == null) {
            printArray(path, len);
        } else {
            printPaths(node.getLetf(), path, len);
            printPaths(node.getRight(), path, len);
        }
    }

    private void printArray(int[] a, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    //是否存在路径数据和等于给定值
    public boolean hasPathSum(Node node, int sum) {
        if (node == null) {
            return sum == 0;
        }
        sum -= node.getData();
        return hasPathSum(node.getLetf(), sum) || hasPathSum(node.getRight(), sum);
    }

    //求出二叉树所有节点的数据总和
    public int sumAllNode(Node node) {
        if (node == null) {
            return 0;
        }
        return sumAllNode(node.getLetf()) + sumAllNode(node.getRight()) + node.getData();
    }

    //镜像转换二叉树
    public Node mirrorOfBinaryTree(Node node) {
        if (node == null) {
            return null;
        }
        Node temp = node.getLetf();
        node.setLetf(node.getRight());
        node.setLetf(temp);
        mirrorOfBinaryTree(node.getLetf());
        mirrorOfBinaryTree(node.getRight());
        return node;
    }

    //输出给定节点的所有的祖先节点
    public boolean printAllAncestors(Node root, Node node) {
        if (root == null) {
            return false;
        }
        if (root.getLetf() == node || root.getRight() == node || printAllAncestors(root.getLetf(), node) || printAllAncestors(root.getRight(), node)) {
            System.out.print(root.getData());
            return true;
        } else {
            return false;
        }
    }

}

class Node {
    private int data;
    private Node letf;
    private Node right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLetf() {
        return letf;
    }

    public void setLetf(Node letf) {
        this.letf = letf;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
