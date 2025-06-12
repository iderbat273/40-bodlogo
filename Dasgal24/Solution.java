import java.io.*;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] values = br.readLine().split(" ");
        int pos = Integer.parseInt(br.readLine());
        
        if (n == 0) {
            System.out.println("false");
            return;
        }
        
        ListNode[] nodes = new ListNode[n];
        ListNode head = new ListNode(Integer.parseInt(values[0]));
        nodes[0] = head;
        
        for (int i = 1; i < n; i++) {
            nodes[i] = new ListNode(Integer.parseInt(values[i]));
            nodes[i-1].next = nodes[i];
        }
        
        if (pos >= 0 && pos < n) {
            nodes[n-1].next = nodes[pos];
        }
        
        System.out.println(hasCycle(head));
    }
}