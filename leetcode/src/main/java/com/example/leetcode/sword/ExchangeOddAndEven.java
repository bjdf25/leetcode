package sword;

public class ExchangeOddAndEven {

    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            /**
             * 不能直接nums[i++],i++在执行(nums[i++] & 1)步骤后就会自增，还没有走到判断奇偶的逻辑
             */
//            while(i < j && (nums[i++] & 1) == 1);
//            while(i < j && (nums[j--] & 1) == 0);
            while(i < j && (nums[i] & 1) == 1) i++;
            while(i < j && (nums[j] & 1) == 0) j--;
            if(i >= j) break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
