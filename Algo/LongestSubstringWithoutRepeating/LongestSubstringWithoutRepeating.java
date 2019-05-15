package algo.myprog;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

	public static void main(String[] args) {	
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("abba"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> mp = new HashMap<Character,Integer>();
		int len = s.length();
		
		int res = 0;
        int t = 0;
        int cnt = 0;
        
        for(int i = 0; i < len; i++){
        	if(mp.containsKey(s.charAt(i))) {
        		t = mp.get(s.charAt(i));
        		if(cnt > i - t)
                    cnt = i - t + 1;
                else
                    cnt++;
        	} else {
        		cnt++;
        	}
        	
        	res = (cnt > res)? cnt:res;
        	mp.put(s.charAt(i), i+1);
        }
		
		return res;
	}

}
