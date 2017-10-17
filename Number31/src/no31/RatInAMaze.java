package no31;

public class RatInAMaze {

	public int[][] solution;

	public RatInAMaze(int N) {
		solution = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solution[i][j] = 0;
			}
		}
	}

	public void inputMaze(int[][] maze, int N) {
		if (findPath(maze, 0, 0, N, "down")) {
			print(solution, N);
		}else{
			System.out.println("NO PATH FOUND");
		}
		
	}

	public boolean findPath(int[][] maze, int x, int y, int N, String direction) {
		if(x==N-1 && y==N-1){
			solution[x][y] = 1;
			return true;
		}
		if (isSafeToGo(maze, x, y, N)) {
			solution[x][y] = 1;			
			if(direction!="up" && findPath(maze, x+1, y, N, "down")){
				return true;
			}
			if(direction!="left" && findPath(maze, x, y+1, N,"right")){ 
				return true;
			}
			if(direction!="down" && findPath(maze, x-1, y, N, "up")){ 
				return true;
			}
			if(direction!="right" &&  findPath(maze, x, y-1, N, "left")){
				return true;
			}
			
			solution[x][y] = 0;
			return false;
		}
		return false;
	}


	public boolean isSafeToGo(int[][] maze, int x, int y, int N) {
		if (x >= 0 && y >= 0 && x < N  && y < N && maze[x][y] != 0) {
			return true;
		}
		return false;
	}
	public void print(int [][] solution, int N){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(" " + solution[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
            
		int N = 5;
		int[][] maze = { { 1, 0, 1, 1,1 }, { 1, 1, 1, 0,1 }, { 0, 0,0, 1, 1 },
				{ 0, 0, 0, 1,0 },{ 0, 0,0, 1, 1 } };
		RatInAMaze r = new RatInAMaze(N);
		r.inputMaze(maze, N);
	}

}