import java.util.*;


public class Demo {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        String a = "ababcaababcaabc";
        String b = "ababcaabc";
        s1.strStr(a, b);
        System.out.println();

    }

}
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()){
            return -1;
        }
        int[] next = new int[needle.length()];
        int pre_sum = 0;
        if (needle.length() == 1){
            next[0] = 0;
        }
        else
        {
            next[0] = 0;
            for (int i = 1, j = 0; i < next.length; i++) {
                if(needle.charAt(i) == needle.charAt(j)){
                    next[i] = pre_sum + 1;
                    pre_sum = next[i];
                    j += 1;
                }
                else
                {
                    while(j != 0){
                        pre_sum = next[j - 1];
                        j = next[j - 1];
                        if(needle.charAt(i) == needle.charAt(j)){
                            next[i] = pre_sum + 1;
                            pre_sum = next[i];
                            j ++;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0, j = 0; i < haystack.length(); ) {
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
                i++;
            }else if(j > 0){
                j = next[j - 1];
            }else{
                i++;
            }
            if(j == needle.length()){
                return i - j;
            }
        }
        return -1;
    }
}
class ListNode {
    int val;
    ListNode next;
    public ListNode() {
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        inStack = new ArrayDeque<Integer>();
        outStack = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }
}
