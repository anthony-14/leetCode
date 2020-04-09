package ytt.lc.easy;

/**
 * Description: 两数相加
 *
 * @author yindb
 * @date 2020/4/9
 */
public class Solution2
{
    public static void main(String[] args)
    {
        /*
        给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
        eg:输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
            输出：7 -> 0 -> 8
            原因：342 + 465 = 807
         */
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);

        ListNode listNode = addTwoNumbers(l1, l2);

        System.out.println(listNode.toString());
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        /*
        链表逆序存储，返回结果也要求逆序，所以直接按顺序计算向后进位
         */
        // 此处复制一份是因pre随循环执行会一直改变对象地址，所以需要使用原始对象来存储返回结果
        ListNode listNode = new ListNode(-1),pre = listNode;

        int t = 0;

        while (l1 != null || l2 != null || t != 0)
        {
            // 当链表长度不一时，则默认链表较短的取值为0，不会影响最后结果
            if (l1 != null)
            {
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null)
            {
                t += l2.val;
                l2 = l2.next;
            }
            // 取余作为当前数
            pre.next = new ListNode(t % 10);
            pre = pre.next;
            // 取商作为进位数
            t /= 10;
        }
        return listNode.next;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
    }

    @Override
    public String toString()
    {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
