class Solution {
    public boolean rotateString(String A, String B) {
        int alen = A.length();
        int blen = B.length();
        
        if(alen != blen) return false;
        if(alen == 0) return true;
        if(A.equals(B)) return true;
        
        for(int idx = 1; idx < alen; idx++){
            if(A.substring(idx).equals(B.substring(0, blen - idx))
              && A.substring(0, idx).equals(B.substring(blen - idx))){
                return true;
            }
        }
        
        return false;
    }
}
