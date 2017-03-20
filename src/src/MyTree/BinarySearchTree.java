package src.MyTree;

public class BinarySearchTree {
    //二叉搜索树的节点
    class BinarySearchTreeNode {
        private int data;
        public BinarySearchTreeNode left;
        public BinarySearchTreeNode right;

        public BinarySearchTreeNode(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    private BinarySearchTreeNode root;

    //清空二叉搜索树
    public void makeEmpty() {
        root = null;
    }

    //判断是否空
    public boolean isEmpty() {
        return root == null;
    }

    //判断是否包含指定数据
    public boolean contains(int x) {
        return contains(x, root);
    }

    private boolean contains(int x, BinarySearchTreeNode t) {
        if (t == null) {
            return false;
        }
        if (x > t.getData()) {
            contains(x, t.right);
        }
        if (x < t.getData()) {
            contains(x, t.left);
        }
        return true;
    }

    //寻找最大值
    public int findMin() {
        return findMin(root).getData();
    }

    private BinarySearchTreeNode findMin(BinarySearchTreeNode t) {
        if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    //寻找最小值
    public int findMax() {
        return findMax(root).getData();
    }

    private BinarySearchTreeNode findMax(BinarySearchTreeNode t) {
        if (t.right == null) {
            return t;
        }
        return findMax(t.right);
    }

    //插入数据
    public void insert(int x) {
        root = insert(x, root);
    }

    private BinarySearchTreeNode insert(int x, BinarySearchTreeNode t) {
        if (x > t.getData()) {
            if (t.right != null) {
                t.right = insert(x, t.right);
            } else {
                t.right = new BinarySearchTreeNode(x);
            }
        }
        if (x < t.getData()) {
            if (t.left != null) {
                t.left = insert(x, t.left);
            } else {
                t.left = new BinarySearchTreeNode(x);
            }
        }
        return t;
    }

    //删除数据
    public void remove(int x) {
        remove(x, root);
    }

    private BinarySearchTreeNode remove(int x, BinarySearchTreeNode t) {
        if (t == null) {
            return t;
        }
        if (x > t.getData()) {
            t.right = remove(x, t.right);
        } else if (x < t.getData()) {
            t.left = remove(x, t.left);
        } else if (t.left != null && t.right != null) {
            t.setData(findMin(t.right).getData());
            t.right = remove(t.getData(), t.right);
        } else {
            t = (t.left == null ? t.right : t.left);
        }
        return t;
    }

}

