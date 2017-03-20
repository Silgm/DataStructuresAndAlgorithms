package src.MyLinkList;

public class LinkList {
    //创建链表
    public Node createList(int[] numbers) {
        Node head = null;
        Node tail = null;
        for (int val : numbers) {
            if (head == null) {
                tail = head = new Node(val);
            } else {
                tail = tail.next = new Node(val);
            }
        }
        return head;
    }

    //输出链表
    public void printList(Node head) {
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.getValue() + "  ");
        }
    }

    //反向输出链表
    public void printListFromEnd(Node head) {
        if (head.next != null) {
            printListFromEnd(head.next);
            System.out.println(head.next.getValue());
        }
    }

    //删除倒数第n个节点
    public Node NthNodeFromEnd(Node head, int NthNode) {
        Node pre = head;
        Node last = head;
        for (int i = 0; i < NthNode + 1; i++, pre = pre.next) {
            if (pre == null) {
                return null;
            }
        }
        while (pre != null) {
            last = last.next;
            pre = pre.next;
        }
        if (last.next == pre) {
            return head;
        } else {
            pre = last.next;
            last.next = pre.next;
            pre.next = null;
        }
        return head;
    }

    //Floyed环判定法
    public boolean DoesLinkedListContainsLoop(Node head) {
        if (head.next == null) {
            return false;
        }
        Node fast = head.next;
        Node slow = head.next;
        while (true) {
            if (slow == null || fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
    }

    //翻转链表
    public Node ReverseList(Node head) {
        Node shead = head.next;
        Node pre = null;
        Node temp = null;
        while (shead != null) {
            pre = shead.next;
            shead.next = temp;
            temp = shead;
            shead = pre;
        }
        head.next = temp;
        return head;
    }

    //寻找中间节点
    public Node findMiddle(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null) {
            if (fast.next == null) {
                fast = null;
            } else {
                fast = fast.next.next;
            }
            slow = slow.next;
        }
        return slow;
    }

    //将两个升序链表合成一个升序链表
    public Node mergeList(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.getValue() < head2.getValue()) {
            head2 = mergeList(head1.next, head2);
            head1.next = head2;
            return head1;
        } else {
            head1 = mergeList(head1, head2.next);
            head2.next = head1;
            return head2;
        }
    }

}

class Node {
    private int value;
    public Node next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public Node(int value) {

        this.value = value;
    }
}
