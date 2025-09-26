// inserting at a specific index/position

// brute force approach
public class InsertionAtPoint
{
  public static void main(String... args)
  {
    int cap = 5, size = 4-1, addAt = 3, addVal = 4;
    int[] nums = new int[cap];
    nums[0] = 1; nums[1] = 2; nums[2] = 3; nums[3] = 5;
    
    for (int i = size; i >= addAt; i--)
    {
      nums[i+1] = nums[i];
      if (i == addAt)
        nums[addAt] = addVal;
    }
    
    for (int i = 0; i < cap; i++)
    System.out.print(nums[i] + " ");
  }
}
