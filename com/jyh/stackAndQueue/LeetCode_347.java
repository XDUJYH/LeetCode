package com.jyh.stackAndQueue;


import java.util.*;

/**
 * 347. 前 K 个高频元素
 * leetcode url : https://leetcode.cn/problems/top-k-frequent-elements/
 * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0347.%E5%89%8DK%E4%B8%AA%E9%AB%98%E9%A2%91%E5%85%83%E7%B4%A0.md
 */
public class LeetCode_347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        Solution s1 = new Solution();
        System.out.println(Arrays.toString(s1.topKFrequent(nums,k)));

    }

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            for (int num : nums) {
                if(!map.containsKey(num)){
                    map.put(num,0);
                }
                else {
                    int count = 0;
                    count = map.get(num);
                    count++;
                    map.put(num,count);
                }
            }

            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];//小于返回负数，等于返回0，大于返回正数
                }
            });
            for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                int num = entry.getKey(), count = entry.getValue();
                if(priorityQueue.size() < k){
                    priorityQueue.offer(new int[]{num,count});
                }
                else if (priorityQueue.peek()[1] < count){
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{num,count});
                }
            }
            int[] ans = new int[k];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = priorityQueue.poll()[0];
            }
            return ans;
        }
    }
}
