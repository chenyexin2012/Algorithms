package com.holmes.leecode;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author Administrator
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        new LengthOfLongestSubstring();
    }

    public LengthOfLongestSubstring() {
        System.out.println(lengthOfLongestSubstring("asdfg"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 1) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        int result = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            sb.append(charArray[i]);
            for (int j = i + 1; j < charArray.length; j++) {
                if (sb.indexOf(String.valueOf(charArray[j])) >= 0) {
                    break;
                } else {
                    sb.append(charArray[j]);
                }
            }
            if (result < sb.length()) {
                result = sb.length();
            }
            sb = new StringBuilder();
        }
        return result;
    }
}
