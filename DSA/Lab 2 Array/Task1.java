/*
  Name: Sumama Rahim
  Registration# F24BSCS039
  Subject: Data Structures and Algorithms
  Instructor: Ms. Engr. Afifa Zafar
  Date: 09/27/2025
  
  
  Lab 2: Arrays and Pointers
*/

/* Task 1: n this Lab, you will have to implement the basic functions needed to build the List based on array as given below. You have to provide the implementation of given functions. Suppose we have an array like this: (This task has to implemented both by static and dynamic allocation)
*/

// created to call all functions of this class
class functions
{
  int cap = 10, size = 5;
  int[] Array1 = new int[cap];
  int[] Array2 = new int[cap];
  int[] Array3 = new int[cap];
   
  void insert(int addValue)
  {
    Array1[0] = 5; Array1[1] = 3; Array1[2] = 8; Array1[3] = 15; Array1[4] = 12;
    
    // insert value at beginning
    for (int i = size; i >= 0; i--)
    {
      Array1[i+1] = Array1[i];
      if (i == 0)
      Array1[0] = addValue;
    }
  }
  
  // insert value at specific position
  void insertAtSpecificPosition(int specificPosition, int addValue)
  {
    Array2[0] = 5; Array2[1] = 3; Array2[2] = 8; Array2[3] = 15; Array2[4] = 12;
    
    for (int i = size; i >= specificPosition-1; i--)
    {
      Array2[i+1] = Array2[i];
      if (i == specificPosition-1)
      Array2[specificPosition-1] = addValue;
    }
  }
  
  
  // to remove specific value
  void remove(int toRemove)
  {
    Array3[0] = 5; Array3[1] = 3; Array3[2] = 8; Array3[3] = 15; Array3[4] = 12;
    int indexedAt = 0; // to store the index of toRemove value
    
    // to find the index of required value
    for (int i = 0; i <= size; i++)
    {
      if (Array3[i] == toRemove)
      {
        indexedAt = i;
      }
    }
    // to remove
    for (int i = indexedAt; i <= size; i++)
    {
      Array3[i] = Array3[i+1];
    }
  }
  
  
  // to display all array values
  void display()
  {
    // insert at the beginning
    System.out.println("Inserted at the beginning of Array1"); 
    for (int i = 0; i <= size; i++)
    {
      System.out.print(Array1[i] + " ");
    }
    
    // insert at specific position
    System.out.println("\nInserted at specific position of Array2"); 
    for (int i = 0; i <= size; i++)
    {
      System.out.print(Array2[i] + " ");
    }
    
    // to remove specific value
    System.out.println("\n Removed specified value from Array3"); 
    for (int i = 0; i < size-1; i++)
    {
      System.out.print(Array3[i] + " ");
    }
  }
}



// brute force approach
public class Task1
{
  public static void main(String... args)
  {
    // creating object to call created functions
    functions call = new functions();
    // calling functions
    call.insert(1); // value to enter
    call.insertAtSpecificPosition(6, 17); // position and value
    call.insertAtSpecificPosition(3, 20); // position and value
    call.remove(8); // to remove the specified(8) value
    call.display(); // to display all function's output
  }
}
