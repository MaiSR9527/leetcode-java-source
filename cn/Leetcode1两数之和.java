import java.util.HashMap;
import java.util.Map;

/**
 * 题目：两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 题目地址：https://leetcode-cn.com/problems/two-sum/
 *
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @date 2020/12/23 23:24
 */
public class Leetcode1两数之和 {
    public int[] toSum(int[] nums, int target) {
        // 每个元素只能用一次，只有一种结果。可以利用HashMap的特性，同样的key的hash值一样
        // map的key位数组里的元素，value为给元素的下标
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            // 用target减去每一个nums里的数
            int key = target - nums[i];
            // 检查一下map
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }
            // 不存在，存进去
            map.put(nums[i], i);
        }
        return null;
    }

}
