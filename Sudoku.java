import org.apache.log4j.Logger;

public class Sudoku {


static Logger logger = Logger.getLogger(Sudoku.class.getName());
	
	

	public static boolean checkValidity(int[][] sudoku, int row, int column, int digit) {
		
		
		logger.info("Checking the validity of digit against row");
		for (int r = 0; r < sudoku.length; r++) {
			if (sudoku[row][r] == digit) {
				
				return false;//The digit which we are trying to add ,if it is already present in rowthen return false
			}
		}

		logger.info("Checking the validity of digit against column");
		for (int c = 0; c < sudoku.length; c++) {
			if (sudoku[c][column] == digit) {
				
				return false;//The digit which we are trying to add ,if it is already present in column then return false
			}
		}

		
		logger.info("Checking the validity of digit against corresponding 3*3 box");

		int sqrt = (int) Math.sqrt(sudoku.length);//Taking the square root of sudoku in order to find corresponding 3*3 box
		int boxRow = row - row % sqrt;  //In order to get the starting point of 3*3 box for row 
		int boxColumn = column - column % sqrt;//In order to get the starting point of 3*3 box for column 

		for (int r = boxRow; r < boxRow + sqrt; r++) {
			for (int c = boxColumn; c < boxColumn + sqrt; c++) {
				if (sudoku[r][c] == digit) {
					
					return false;
				}
			}
		}

		logger.info("If there is no clash in row ,column and square box the return true ");
		return true;
	}

}
