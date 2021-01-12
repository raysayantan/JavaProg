class SparseVector {
    HashMap<Integer, Integer> mapper = new HashMap<>();
    SparseVector(int[] nums) {
        for(int idx = 0; idx < nums.length; idx++){
            if(nums[idx] != 0){
                mapper.put(idx, nums[idx]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int product = 0;
        for(Map.Entry<Integer, Integer> e : mapper.entrySet()){
            int key = e.getKey();
            if(vec.mapper.containsKey(key)){
                product += e.getValue() * vec.mapper.get(key);
            }
        }
        
        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
