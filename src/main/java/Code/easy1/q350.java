package Code.easy1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q350 {
    //    350. 两个数组的交集 II
    public static void main(String[] args) {

        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};

        int[] intersect = new Solution350().intersect(num1, num2);
    }
}


class Solution350 {
    //    先考虑一个数组在另一个数组中重复出现的数据
//    以及他本身重复出现的次数
//    以下的狗屎代码，能过，但是效率极低
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hash1 = new HashMap<>();
        HashMap<Integer, Integer> hash2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!hash1.containsKey(nums1[i])) {
                hash1.put(nums1[i], 1);
            } else {
                hash1.put(nums1[i], hash1.get(nums1[i]) + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (!hash2.containsKey(nums2[i])) {
                hash2.put(nums2[i], 1);
            } else {
                hash2.put(nums2[i], hash2.get(nums2[i]) + 1);
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i : hash1.keySet()) {
            if (hash2.containsKey(i)) {
                int count = Math.min(hash1.get(i), hash2.get(i));
                for (int j = 0; j < count; j++) {
                    temp.add(i);
                }
            }
        }
        int[] res = new int[temp.size()];
        int k = 0;
        for (int i : temp) {
            res[k++] = i;
        }
        return res;
    }

    //    大佬代码时间
//    实际上只需要用到一个hash表既可
    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
//            把短的数组放在前，提高效率？
            return intersect1(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
//        大佬的写法就是不一样，简便多了
        for (int num : nums1) {
            // map.getOrDefault : 存在这个数就返回，不存在就返回默认值
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        // 开辟一块内存空间用来存放两个数组的交集
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            // num1中不存在这个数就在map中添加num=0
            int count = map.getOrDefault(num, 0);
            // 存在这个数就往后执行
            if (count > 0) {
                // 把这个数填充到数组中
                intersection[index++] = num;
                // 计数减一
                count--;
                // 如果还大于0
                if (count > 0) {
                    // 再次添加进去，覆盖之前那个key
                    map.put(num, count);
                } else {
                    // 不大于0移除这个数
                    map.remove(num);
                }
            }
        }
        // public static int[] copyOfRange(int[] original, int from, int to)
        // 对已有([9, 4, 0])的数组进行截取和赋值,结果为[9,4]
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
