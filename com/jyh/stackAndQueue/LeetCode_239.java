package com.jyh.stackAndQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 239. 滑动窗口最大值
 * leetcode url : https://leetcode.cn/problems/sliding-window-maximum/
 * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0239.%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E6%9C%80%E5%A4%A7%E5%80%BC.md
 * 官方题解比自己写的要清晰地多！建议看官方题解
 */
public class LeetCode_239 {
    public static void main(String[] args) {
        int[] nums = {-7,-8,7,5,7,1,6,0};
        int k = 4;
        Solution s1 = new Solution();

        System.out.println(Arrays.toString(s1.maxSlidingWindow(nums, k)));

    }
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            MonotonicQueue monotonicQueue = new MonotonicQueue(k);
            int[] ans = new int[nums.length - k + 1];
            //先放入一个滑动窗口
            for (int i = 0; i < k; i++) {
                monotonicQueue.offer(nums[i]);
            }
            ans[0] = monotonicQueue.peek();
            //开始滑动
            for (int i = k; i < nums.length; i ++){
                int popNum = nums[i-k];
                if(popNum == monotonicQueue.peek()){
                    monotonicQueue.poll();
                }
                monotonicQueue.offer(nums[i]);
                ans[i - k + 1] = monotonicQueue.peek();
            }
            return ans;
        }
    }
    /**
     * 单调队列(注意！单调队列队尾也可以出队！)，核心点在于元素入队的时候，要依次与队尾元素进行比较，直到队尾比入队元素大或者没元素了直接入队！！
     */
    static class MonotonicQueue {
        Deque<Integer> queue;
        int maxCapacity;
        public MonotonicQueue(int maxCapacity){
            queue = new LinkedList<>();
            this.maxCapacity = maxCapacity;
        }
        public void offer(int num){
            if(queue.size() == maxCapacity){
                queue.pollFirst();
            }
            if(queue.size() == 0){
                queue.offerLast(num);
                return;
            }
            int maxValue = queue.peekFirst();
            if(num > maxValue){
                for (int i = 0; i < queue.size(); i++) {
                    queue.clear();
                }
                queue.offerLast(num);
            }
            else {
                while (num > queue.peekLast()){
                    queue.pollLast();
                }
                queue.offerLast(num);
            }

        }
        public int poll(){
            return queue.pollFirst();
        }
        public int peek(){
            return queue.peekFirst();
        }
    }
}
