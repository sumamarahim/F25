// inserting value at the end

/*
// brute force approach
public class Insertion
{
  public static void main(String... args)
  {
    int size = 4, cap = 5;
    int[] nums = new int[cap];
    
    nums[0] = 1; nums[1] = 2; nums[2] = 3; nums[3] = 4;
    
    
    for (int i = 0; i <= size; i++)
    {
      if (i == 3)
      {
        nums[i+1] = 5;
      }
    }
    
    for (int i = 0; i <= size; i++)
    {
      System.out.print(nums[i] + " ");
    }
  }
}

**/

// method 2
public class Insertion
{
  public static void main(String... args)
  {
    int size = 4, cap = 5;
    int[] nums = new int[cap];
    
    nums[0] = 1; nums[1] = 2; nums[2] = 3; nums[3] = 4;
    
    nums[size] = 5;

    for (int i = 0; i <= size; i++)
    {
      System.out.print(nums[i] + " ");
    }
  }
}
