package DFS;

import java.util.Random;

public class GenerateMaze {
    public int[][] maze(int n){
        int[][] maze = new int[n][n];

        //initialize maze
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    maze[i][j] = 0;
                }else{
                    maze[i][j] = 1;
                }
            }
        }
        generate(maze, 0, 0);
        return maze;
    }

    private void generate(int[][] maze, int x, int y){
        //generate directions
        int[] dir = new int[]{0,1,2,3};
        shuffle(dir);
        for(Integer i : dir){
            int nextX = move(i, x, y, 2)[0];
            int nextY = move(i, x, y, 2)[1];
            if(isValidWall(maze, nextX, nextY)){
                maze[move(i, x, y, 1)[0]][move(i, x, y, 1)[1]] = 0;
                maze[nextX][nextY] = 0;
                generate(maze, nextX, nextY);
            }
        }
    }

    private void shuffle(int[] dir){
        for(int i = 0; i < dir.length; i++){
            Random r = new Random();
            int index = r.nextInt(4);
            int temp = dir[i];
            dir[i] = dir[index];
            dir[index] = temp;
        }
    }

    private int[] move(int dir, int x, int y, int steps){
        //上
        if(dir == 0){
            x -= steps;
            //右
        }else if(dir == 1){
            y += steps;
            //下
        }else if(dir == 2){
            x += steps;
            //左
        }else if(dir == 3){
            y -= steps;
        }
        return new int[]{x,y};
    }

    private boolean isValidWall(int[][] maze, int x, int y){
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1;
    }
}
