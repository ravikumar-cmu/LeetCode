public class SearchRotateSortedArray {
        public int search(int[] nums, int target) {
        
        return binarySearch(nums,0,nums.length-1, target);
    }
    
    int binarySearch(int[] nums, int lo, int hi, int target) {
        
        int mid =0;
        while (lo < hi) {
            mid = (lo+hi)/2;
            System.out.println(mid);
            
            if (nums[lo] < nums[hi]) {
                if (target < nums[lo] || target > nums[hi]) {
                    return -1;
                }
                    
            }
            
            if (nums[mid] == target ) {
                return mid;
            }
            
            if (nums[mid] > nums[hi]) {
                
                if (target < nums[mid] && target > nums[hi]) {
                    hi = mid;
                    
                } else {
                    lo = mid+1;
                }
            } else {
                if (target > nums[mid] && target < nums[hi]) {
                    lo = mid +1;
                } else {
                    hi =mid;
                }
            }
             
        }
        return -1;
        
    }

    public static void main(String[] args) {
        SearchRotateSortedArray s = new SearchRotateSortedArray();

        int [] nums = {1};

        int res = s.search(nums, 0);

        System.out.println(res);

    }
}