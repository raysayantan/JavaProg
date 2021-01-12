/*
Given two sparse vectors, compute their dot product.

Implement class SparseVector:

SparseVector(nums) Initializes the object with the vector nums
dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently and compute the dot product between two SparseVector.

Follow up: What if only one of the vectors is sparse?

 

Example 1:

Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
Output: 8
Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8
Example 2:

Input: nums1 = [0,1,0,0,0], nums2 = [0,0,0,0,2]
Output: 0
Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0
Example 3:

Input: nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
Output: 6
 

Constraints:

n == nums1.length == nums2.length
1 <= n <= 10^5
0 <= nums1[i], nums2[i] <= 100
*/
class SparseVector {
    List<Pair<Integer, Integer>> vector = new ArrayList<>();
    SparseVector(int[] nums) {
        for(int idx = 0; idx < nums.length; idx++){
            if(nums[idx] != 0){
                vector.add(new Pair<Integer, Integer>(idx, nums[idx]));
            }
        }
    }
    
    public List<Pair<Integer, Integer>> getVector(){
        return vector;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int product = 0;
        List<Pair<Integer, Integer>> v = vec.getVector();
        int idx1 = 0;
        int idx2 = 0;
        while(idx1 < vector.size() && idx2 < v.size()){
            int pos1 = vector.get(idx1).getKey();
            int pos2 = v.get(idx2).getKey();
            if(pos1 == pos2){
                product += vector.get(idx1).getValue() * v.get(idx2).getValue();
                idx1++;
                idx2++;
            } else {
                if(pos1 > pos2){
                    idx2++;
                } else {
                    idx1++;
                }
            }
        }
        
        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
