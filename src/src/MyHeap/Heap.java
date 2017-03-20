package src.MyHeap;

public class Heap {
    public int[] array;
    public int count;
    public int capacity;
    public int heap_type;

    //堆的初始化
    public Heap(int capacity, int heap_type) {
        this.capacity = capacity;
        this.heap_type = heap_type;
        this.count = 0;
        this.array = new int[capacity];
    }

    //获得父亲节点的位置索引
    public int getParent(int position) {
        if (position >= count || position <= 0) {
            return -1;
        }
        return (position - 1) / 2;
    }

    //获得左孩子节点的位置索引
    public int getLeftChild(int position) {
        int left = position * 2 + 1;
        if (left >= count) {
            return -1;
        }
        return left;
    }

    //获得右孩子节点的位置索引
    public int getRightChild(int position) {
        int right = position * 2 + 2;
        if (right >= count) {
            return -1;
        }
        return right;
    }

    //单个位置的堆调整
    public void percolateDown(int position) {
        int l, r, max, temp;
        l = getLeftChild(position);
        r = getRightChild(position);
        if (l != -1 && array[l] > array[position]) {
            max = array[l];
        } else {
            max = array[position];
        }
        if (r != -1 && array[r] > array[position]) {
            max = array[r];
        } else {
            max = array[position];
        }
        if (max != position) {
            temp = array[position];
            array[position] = array[max];
            array[max] = temp;
            percolateDown(max);
        }
    }

    //删除堆顶元素
    public int deleteMax() {
        int data = array[0];
        array[0] = array[count - 1];
        count--;
        percolateDown(0);
        return data;
    }

    //插入元素
    public int insert(int data) {
        this.count++;
        int i = count - 1;
        while (i > 0 && data > array[(i - 1) / 2]) {
            array[i] = array[(i - 1) / 2];
            i = (i - 1) / 2;
        }
        return data;
    }

    //创建堆
    public void buildHeap(int[] A) {
        this.count = A.length;
        for (int i = 0; i < A.length; i++) {
            this.array[i]=A[i];
        }
        for(int i=(A.length-1)/2;i>=0;i--){
            this.percolateDown(i);
        }
    }
}
