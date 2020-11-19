/*
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

 

Note:

The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
*/
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encodedStr = new StringBuilder();
        //Will be encoding with string preceded by its size in 4 bytes
        for(int idx = 0; idx < strs.size(); idx++){
            int len = strs.get(idx).length();
            String lenStr = Integer.toString(len);
            StringBuilder sb = new StringBuilder();
            
            //prepend the len with 0
            for(int i = 0; i < 4 - lenStr.length(); i++){
                sb.append('0');
            }
            sb.append(lenStr);
            encodedStr.append(sb.toString());
            encodedStr.append(strs.get(idx));
        }
        
        return encodedStr.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        //While decode first 4 chars are length n then the string of that length
        List<String> strList = new ArrayList<>();
        int len = s.length();
        int idx = 0;
        while(idx < len){
            if(idx + 3 >= len) break;
            int strlen = Integer.parseInt(s.substring(idx, idx + 4));
            idx += 4;
            if(idx + strlen > len) break;
            strList.add(s.substring(idx, idx + strlen));
            idx += strlen;
        }
        
        return strList;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
