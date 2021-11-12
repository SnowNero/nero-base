package com.leet.settled;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2019-07-08
 * Time: 23:41
 */
public class Subject3LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        char c;
        StringBuffer sb = new StringBuffer();
        if (s.length() == 0) {
            return res;
        }
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (sb.indexOf(String.valueOf(c)) != -1) {
                while (sb.length() != 0 && sb.charAt(0) != c) {
                    sb.deleteCharAt(0);
                }
                while (sb.length() != 0 && sb.charAt(0) == c) {
                    sb.deleteCharAt(0);
                }
            }
            sb.append(s.charAt(i));
            if (sb.length() > res) {
                res = sb.length();
            }
        }
        return res;
    }

    /*public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }*/


}
