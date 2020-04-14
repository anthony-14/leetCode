package ytt.lc.easy;

import java.util.HashSet;
import java.util.Set;

public class Solution3
{
    public static void main(String[] args)
    {
        /*
        给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
        eg:输入: "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
         */
        String str = "a";

        System.out.println(lengthOfLongestSubstring(str));

        String str2 = "abcddefghi";
        System.out.println(lengthOfLongestSubstring2(str2));

    }

    public static int lengthOfLongestSubstring(String s) {
        /*
        将字符串转为数组
        定义一个最长量
        遍历数组，以下标0最为最长字串开始，如果后面匹配到相同字符则记录当前字串长度，并以下标1开始进行二次匹配
         */
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length == 1)
        {
            return 1;
        }
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < length-1; i++)
        {
            set.add(chars[i]);
            for (int j = i+1; j < length; j++)
            {
                if (!set.add(chars[j]) || length -1 == j)
                {
                    int temp = set.size();
                    if (temp > max)
                    {
                        max = temp;
                    }
                    set.clear();
                    if (length-1 == j)
                    {
                        return max;
                    }
                    break;
                }
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

}
