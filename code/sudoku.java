package code;
import  java.util.*;
public class sudoku{
public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the order of the Sudoku You want to play");
    int n = scan.nextInt();
    int table[][] = new int[n][n];
    boolean completed = false;
    while (!completed)
    {
        System.out.println("Enter the value and its respective row and column");
        int value = scan.nextInt();
        int row = scan.nextInt();
        int column = scan.nextInt();
        if (check(value,table,row,column)) table[row-1][column-1] =  value;
        else{
            System.out.println("The value you entered doesn't  suits in that place , Try with another one");
            continue;
        }
        completed = isCompleted(table);
        if (completed){
            System.out.println("Congratulations , you have completed the Puzzle");
        }
        print(table);
    }
}
private static void print(int[][]arr){
    System.out.print("    ");
    for (int i=0;i<arr.length;i++) System.out.print("["+(i+1)+"]");
    System.out.println();
    for (int i=0;i<arr.length;i++)
    {
        System.out.print(" ["+(i+1)+"] ");
        for (int j=0;j<arr.length;j++){
            System.out.print(arr[i][j]+"  ");
        }
        System.out.println();
    }
}
private static boolean check(int value,int[][] arr,int row , int column){
    for (int i=0;i<arr.length;i++)
    {
        if (column-1 != i && value==arr[row-1][i]) return false;
    }
    for (int i=0;i<arr.length;i++)
    {
        if(row-1 != i && value==arr[i][column-1]) return false;
    }
    return true;
}
private static boolean isCompleted(int[][] arr)
  {
      int reqSum =  (arr.length*(arr.length+1))/2 ;
        for (int i=0;i< arr.length;i++)
        {
          int sum=0;
          for (int j=0;j<arr[i].length;j++)
          {
              sum += arr[i][j];
          }
          if (sum!=reqSum) return false;
        }
    return true;
  }
}