// deletion from a specific index/position

// brute force approach
public class Delete
{
  public static void main(String... args)
  {
    int cap = 5, size = 4-1, delete = 2, deleteVal = 3;
    int[] nums = new int[cap];
    nums[0] = 1; nums[1] = 2; nums[2] = 3; nums[3] = 5;
    
    for (int i = delete; i <= size; i++)
    {
      nums[i] = nums[i+1];
    }
    
    for (int i = 0; i < size; i++)
    System.out.print(nums[i] + " ");
  }
}
