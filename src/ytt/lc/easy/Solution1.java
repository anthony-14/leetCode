package ytt.lc.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 两数之和
 * @author yindb
 * @date 2020/4/9
 */
public class Solution1
{
    public static void main(String[] args)
    {
        // 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个整数，并返回他们的数组下标。
        // 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
        // eg1:
        int[] nums = {-1, 0, -1, 1, 2};
        int target = 0;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + "," + result[1]);
    }

    private static int[] twoSum(int[] nums, int target)
    {
        /*
        Solution1：for循环嵌套
         */
        // for (int i = 0; i < nums.length; i++)
        // {
        //     for (int j = i+1; j < nums.length; j++)
        //     {
        //         if (nums[i] + nums[j] == target)
        //         {
        //             return new int[]{i, j};
        //         }
        //     }
        // }

        /*
        Solution2：hashMap存储遍历后计算出的差值和数组下标，后续循环比对匹配差值
         */
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++)
        {
            int key = target - nums[i];
            if (map.containsKey(key))
            {
                return new int[]{map.get(key), i};
            }
            map.put(key, i);
        }
        throw new IllegalArgumentException("unsolvable");
    }
}
