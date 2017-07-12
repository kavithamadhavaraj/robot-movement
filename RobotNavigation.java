//Author : Kavitha Madhavaraj
//Date : 05/07/2017

// n -> Size of the matrix

/**
 * PROBLEM DESCRIPTION
 * A robot is located in the upper-left corner of a 4×4 grid. The robot can move either up, down, left, or right, but cannot go to the same location twice. The robot is trying to reach the lower-right corner of the grid. Your task is to find out the number of unique ways to reach the destination.
 */


import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
public class RobotNavigation
{
	public static int n=4; //Problem statement says 4*4
	public static int pathCount = 0;
	public static Stack<String> paths = new Stack<String>(); // Contains all unique paths traced
	//Upward movement of the robot
	public static void moveUp(int row, int col, boolean[][] grid){	
		if((row != 0) && !(grid[row-1][col])){
				move(row-1, col, grid);
				grid[row-1][col] = false;
		}
	}
	//Downward movement of the robot
	public static void moveDown(int row, int col, boolean[][] grid){
		if((row != n-1) && (!grid[row+1][col])){		
				move(row+1, col, grid);
				grid[row+1][col] = false;
		}
	}
	//Left movement of the robot
	public static void moveLeft(int row, int col, boolean[][] grid){
		if((col != 0) && (!grid[row][col-1])){
				move(row, col-1, grid);
				grid[row][col-1] = false;
		}
	}
	//Right movement of the robot
	public static void moveRight(int row, int col, boolean[][] grid){
		if((col != n-1) && (!grid[row][col+1])){			
				//System.out.println(row + " : " + (col+1));
				move(row, col+1, grid);
				//System.out.println(row + " : "+ col);
				grid[row][col+1] = false;
		}
	}
	public static int move(int row, int col, boolean[][] grid){
		//Some stack manipulations to get hold of the paths being traced.
		paths.push(row+":"+col);
		//Mark the cell as traced.
		grid[row][col] = true;
		//Reached the destination (lower-right) corner of grid
		if(row == n-1 && col == n-1){
		    System.out.println("Count:" + ++pathCount);
			System.out.println("Path:" + Arrays.toString(paths.toArray()));
			paths.pop();
		}
		else{
			moveUp(row, col, grid);
			moveDown(row, col, grid);
			moveLeft(row, col, grid);
			moveRight(row, col, grid);
			paths.pop();
			//System.out.println("Dead Path");
		}
		return pathCount;

	}
	public static void main(String[] args)
    {	
		//Initiate the Grid. False in a cell means it has not been reached yet.
		boolean[][] grid = new boolean[n][n];
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				grid[i][j] = false;
			}
		}
		//Start moving the robot, and prints the total count of the unique paths traced.
	    System.out.println("\n*********************\nTotal Count:" + move(0, 0, grid)+"\n*********************");
	}
}