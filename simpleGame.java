import java.util.*;

public class simpleGame{

	static  ArrayList<Integer> positionOfPlayer = new ArrayList<Integer>();
	static  ArrayList<Integer> positionOfMachine = new ArrayList<Integer>();

	 public static void main(String[] args) {
		char[][] board ={{' ','|',' ','|',' '},
		{'-','+','-','+','-'},
		{' ','|',' ','|',' '},
		{'-','|','-','|','-'},
		{' ','+',' ','+',' '}};


		while (true) {
			Scanner scn = new Scanner(System.in);
			System.out.print("Enter Place(1-9): ");
			int postion = scn.nextInt();
			while (positionOfPlayer.contains(postion)||positionOfMachine.contains(positionOfPlayer)){
				System.out.println("Position Taken! Try another Position");
				postion = scn.nextInt();
			}

			placeCase(board, postion, "player");
			String result = chooseWinner();
			if(result.length()>0) {
				System.out.println(result);
				break;
			}

			//importing random class
			Random random = new Random();
			int machinePos = random.nextInt(9) + 1;
			while (positionOfPlayer.contains(machinePos)||positionOfMachine.contains(postion)){
				machinePos = random.nextInt(9) + 1;
			}
			placeCase(board, machinePos, "machine");

			printBoard(board);
			result = chooseWinner();
			if(result.length()>0){
				System.out.println(result);
				break;
			}

		}
}
		public static void printBoard(char [][]board){
			for(char[] row : board){
			for(char chr : row){
				System.out.print(chr);
			}
			System.out.println();
		} 
	}

	public static void placeCase(char[][] board, int postion,String player){

	 	char symbol = ' ';
	 	if(player.equals("player")){
	 		symbol = 'X';
	 		positionOfPlayer.add(postion);
		}else if (player.equals("machine")){
	 		symbol = '0';
	 		positionOfPlayer.add(postion);
		}
		
		switch(postion){
			case 1:
				board[0][0] = symbol;
				break;
			case 2:
				board[0][2] = symbol;
				break;
			case 3:
				board[0][4] = symbol;
				break;
			case 4:
				board[2][0] = symbol;
				break;
			case 5:
				board[2][2] = symbol;
				break;
			case 6:
				board[2][4] = symbol;
				break;
			case 7:
				board[4][0] = symbol;
				break;
			case 8:
				board[4][2] = symbol;
				break;
			case 9:
				board[4][4] = symbol;
				break;
			default:
				break;

		}
	}

	public static String chooseWinner(){

	 	List topRw = Arrays.asList(1,2,3);
		List midRw = Arrays.asList(4,5,6);
		List btmRw = Arrays.asList(7,8,9);
		List leftCl = Arrays.asList(1,4,7);
		List midCl = Arrays.asList(2,5,8);
		List rightCl = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(7,5,3);

		List<List> conditionsWin = new ArrayList<>();
		conditionsWin.add(topRw);
		conditionsWin.add(midRw);
		conditionsWin.add(btmRw);
		conditionsWin.add(leftCl);
		conditionsWin.add(midCl);
		conditionsWin.add(rightCl);
		conditionsWin.add(cross1);
		conditionsWin.add(cross2);

		for(List list : conditionsWin) {
			if (positionOfPlayer.containsAll(list)) {
				return "You Won!";
			}else if(positionOfMachine.contains(list)){
				return "Computer Won!";
			}else if(positionOfPlayer.size()+positionOfMachine.size()==9){
				return "Drawn";

			}
		}

		return "";
	}
	
}