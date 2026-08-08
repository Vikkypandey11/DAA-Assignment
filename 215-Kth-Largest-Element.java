class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int target) {
        if (left == right) {
            return nums[left];
        }

        int pivotIndex = left + (int)(Math.random() * (right - left + 1));

        int temp = nums[pivotIndex];
        nums[pivotIndex] = nums[right];
        nums[right] = temp;

        int pivot = nums[right];
        int index = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }

        temp = nums[index];
        nums[index] = nums[right];
        nums[right] = temp;

        if (index == target) {
            return nums[index];
        } else if (index < target) {
            return quickSelect(nums, index + 1, right, target);
        } else {
            return quickSelect(nums, left, index - 1, target);
        }
    }
}
