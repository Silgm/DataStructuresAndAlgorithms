package src.MyHash;

import java.util.LinkedList;
import java.util.List;

public class SeparateCahiningHashTable {
    private final static int DEFAULT_TABLE_SIZE = 101;
    private List<Integer>[] theLists;
    private int currentSize;

    //无参数构造方法，使用默认大小
    public SeparateCahiningHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    //带参数构造方法，使用指定大小
    public SeparateCahiningHashTable(int size) {
        theLists = new LinkedList[size];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
        currentSize = size;
    }

    //添加、插入元素
    public void insert(int data) {
        int pos = myHash(data);
        if (!theLists[pos].contains(data)) {
            theLists[pos].add(data);
            if (++currentSize > theLists.length) {
                reHash();
            }
        }
    }

    //删除指定元素
    public void remove(int data) {
        int pos = myHash(data);
        if (theLists[pos].contains(data)) {
            theLists[pos].remove((Integer) data);
            currentSize--;
        }
    }

    //查看是否包含指定元素
    public boolean contains(int data) {
        List<Integer> list = theLists[myHash(data)];
        return list.contains(data);
    }

    //清空散列
    public void makeEmpty() {
        for (int i = 0; i < theLists.length; i++) {
            theLists[i].clear();
        }
        currentSize = 0;
    }

    //重新建立一个两倍大的散列
    private void reHash() {
        List<Integer>[] oldList = theLists;
        theLists = new LinkedList[currentSize * 2];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
        for (int i = 0; i < oldList.length; i++) {
            for (int value : oldList[i]) {
                insert(value);
            }
        }
    }

    //散列主键值计算公式函数
    private int myHash(int data) {
        int hashValue = (data * 7 + 6) / 5;
        hashValue %= theLists.length;
        if (hashValue < 0) {
            hashValue += theLists.length;
        }
        return hashValue;
    }
}
