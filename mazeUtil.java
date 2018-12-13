import java.util.*;

public class MazeSol {
    final int N = 4;
    
    void printSolution(int sol[][]) {
        for(int i = 0; i < N ; i++) {
            for(int j=0; j < N ; j++){
                System.out.println(sol[i][j]);
            }
            System.out.println(" ");
        }
    }
    
    boolean isSafe(int maze[][], int x, int y){
        if(x >= 0 && x < N && y >=0 && y < N && maze[x][y] == 1)
            return true;
        return false;
    }
   
    boolean solveMaze(int maze[][]){
        int sol[][] = {
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
        };
        
        if(solveMazeUtil(maze, 0, 0, sol) == false){
            System.out.println("Can not solve");
            return false;
        }
        
        printSolution(sol);
        return true;
    }
    
    boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]){
        
        if(x == N-1 && y == N-1) {
            sol[x][y] = 1;
            return true;
        }
        
        if(isSafe(maze, x, y)){
            sol[x][y] = 1;
            if(solveMazeUtil(maze, x + 1, y, sol)){
                return true;
            }
            
            if(solveMazeUtil(maze, x, y + 1, sol)){
                return true;
            }
            
            sol[x][y] = 0;
            return false;
        }
        
        return false;
    }
    
    public static void main(String args[]) {
        
        MazeSol sol = new MazeSol();
        int maze[][] = {{1, 0, 0, 0},
        {1, 1, 0, 1},
        {0, 1, 0, 0},
        {1, 1, 1, 1}
        };
        
        sol.solveMaze(maze);
    
    }
}
