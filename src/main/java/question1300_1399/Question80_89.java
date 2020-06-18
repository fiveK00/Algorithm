package question1300_1399;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Question80_89 {
    /* Q1
    * 公司有编号为 1 到 n 的 n 个工程师，给你两个数组 speed 和 efficiency ，其中 speed[i] 和 efficiency[i] 
    * 分别代表第 i 位工程师的速度和效率。请你返回由最多 k 个工程师组成的 ​​​​​​最大团队表现值 ，
        团队表现值 的定义为：一个团队中「所有工程师速度的和」乘以他们「效率值中的最小值」。
        由于答案可能很大，请你返回结果对 10^9 + 7 取余后的结果。
    *
    * */
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] items = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            items[i][0] = speed[i];
            items[i][1] = efficiency[i];
        }
        Arrays.sort(items, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return b[1] - a[1];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long res = 0, sum = 0;
        for(int i = 0 ; i < n ; i++){
            if(queue.size() > k - 1){
                sum -= queue.poll();
            }
            res = Math.max(res, (sum + items[i][0])* items[i][1]);
            queue.add(items[i][0]);
            sum += items[i][0];
        }
        return (int)(res % ((int)1e9 + 7));
    }
    //修改远程tag
    //提交测试
    //提交测试2
}
