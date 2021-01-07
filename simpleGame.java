import java.util.*

public class simpleGame{
	 public static void main(String[] args) {
		char[][] board ={{' ','|',' ','|',' '}
		{'-','+','-','+','-'}
		{' ','|','-','|',' '}
		{' ','+',' ','+',' '}
		{'-','|','-','|','-'}};

		

		Scanner Scn = new Scanner(System.in);
		System.out.println("Enter Place(1-9): ")
		int postion = scn.nextInt();
		
		System.out.println(postion);

		switch(postion){
			case 1:
				board[0][0] = 'X';
				break;
			case 2:
				board[0][2] = 'X';
				break;
			case 3:
				board[0][4] = 'X';
				break;
			case 4:
				board[2][0] = 'X';
				break;
			case 5:
				board[2][2] = 'X';
				break;
			case 6:
				board[2][4] = 'X';
				break;
			case 7:
				board[4][0] = 'X';
				break;
			case 8:
				board[4][2] = 'X';
				break;
			case 9:
				board[4][4] = 'X';
				break;

		}

		printBoard(board);
}
		public static void printBoard(char [][]board){
			for(char[] row : board){
			for(char chr : row){
				System.out.print(chr);
			}
			System.out.println();
		} 
	}
	
}