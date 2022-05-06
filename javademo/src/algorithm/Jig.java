package algorithm;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

//trying the jig programm matt parker wrote in the video why don't jigsaw puszzles have the correct number of pieces
public class Jig {
	static int variationNum;
	static int puzzleCount;
	static double pictureWidth;
	static double pictureHeight;
	
	public static void main(String[] args) {
		variationNum = 5;
		puzzleCount = 200;
		pictureWidth = 49;
		pictureHeight = 36;
		new JigSolver(puzzleCount, pictureWidth, pictureHeight, variationNum);
		System.out.println("\n\n2.===================\n\n");
		variationNum = 5;
		puzzleCount = 150;
		pictureWidth = 49;
		pictureHeight = 36;
		new JigSolver(puzzleCount, pictureWidth, pictureHeight, variationNum);
		System.out.println("\n\n3.===================\n\n");
		variationNum = 5;
		puzzleCount = 1000;
		pictureWidth = 33;
		pictureHeight = 22.8;
		new JigSolver(puzzleCount, pictureWidth, pictureHeight, variationNum);
		System.out.println("\n\n4.===================\n\n");
		variationNum = 20;
		puzzleCount = 1000;
		pictureWidth = 530;
		pictureHeight = 530;
		new JigSolver(puzzleCount, pictureWidth, pictureHeight, variationNum);
	}
}

class JigSolver { 
	final int PUZZLE_COUNT;
	final double PICTURE_WIDTH;
	final double PICTURE_HEIGHT;
	final int VARIATION_NUM;
	final double PICTURE_RATIO;
	
	Map<Integer, Integer> factors;
	double gridRatio;
	double pieceRatio;
	int factor;
	
	int estPuzzleCnt;
	Map<Integer, Integer> estFactors;
	double estGridRatio;
	double estPieceRatio;
	int estFactor;

	public JigSolver(int PUZZLE_COUNT, double PICTURE_WIDTH, double PICTURE_HEIGHT, int VARIATION_NUM) {
		this.PUZZLE_COUNT = PUZZLE_COUNT;
		this.PICTURE_WIDTH = PICTURE_WIDTH;
		this.PICTURE_HEIGHT = PICTURE_HEIGHT;
		this.VARIATION_NUM = VARIATION_NUM;
		this.PICTURE_RATIO = PICTURE_WIDTH/PICTURE_HEIGHT;
		solve();
	}
	public void solve() {
		solveActual();
		solveEst();
		print();
	}
	
	public void solveActual() {
		factors = getFactors(PUZZLE_COUNT);
		gridRatio = PUZZLE_COUNT;
		double tempPieceRatio = PICTURE_RATIO/gridRatio;
		for(int j : factors.keySet()) {
			gridRatio = factors.get(j)/(double)j;
			if(Math.abs(1 - PICTURE_RATIO/gridRatio) < Math.abs(1 - tempPieceRatio)) {
				factor = j;
				tempPieceRatio = gridRatio/PICTURE_RATIO;
			}
		}
		if(Math.abs(1 - tempPieceRatio) < Math.abs(1 - pieceRatio)) {
			pieceRatio = tempPieceRatio;
		}
	}
	
	public void solveEst() {
		int a = 0;
		for(int i = 0; i < VARIATION_NUM*2; i++) {
			estFactors = getFactors(PUZZLE_COUNT - VARIATION_NUM + i);
			estGridRatio = PUZZLE_COUNT - VARIATION_NUM + i;
			double tempPieceRatio = PICTURE_RATIO/estGridRatio;
			for(int j : estFactors.keySet()) {
				estGridRatio = estFactors.get(j)/(double)j;
				if(Math.abs(1 - PICTURE_RATIO/estGridRatio) < Math.abs(1 - tempPieceRatio)) {
					estFactor = j;
					tempPieceRatio = estGridRatio/PICTURE_RATIO;
				}
			}
			if(Math.abs(1 - tempPieceRatio) < Math.abs(1 - estPieceRatio)) {
				estPieceRatio = tempPieceRatio;
				a = i;
			}
		}
		
		estPuzzleCnt = PUZZLE_COUNT -  VARIATION_NUM + a;
		estFactors = getFactors(estPuzzleCnt);
		estGridRatio = estPuzzleCnt;
		double tempPieceRatio = PICTURE_RATIO/estGridRatio;
		for(int j : estFactors.keySet()) {
			estGridRatio = estFactors.get(j)/(double)j;
			if(Math.abs(1 - PICTURE_RATIO/estGridRatio) < Math.abs(1 - tempPieceRatio)) {
				estFactor = j;
				tempPieceRatio = estGridRatio/PICTURE_RATIO;
			}
		}
		
	}
	
	public Map<Integer, Integer> getFactors(int cnt){
		Map<Integer, Integer> factors = new TreeMap<>();
		int step = cnt%2 == 0 ? 1 : 2;
		for(int i = 1; i < Math.sqrt(cnt); i += step) {
			if(cnt % i == 0) {
				factors.put(i, cnt/i);
			}
		}
		return factors;
	}
	
	public String mapToString(Map<?,?> map) {
		return factors.keySet().stream()
			      .map(key -> key + "=" + factors.get(key))
			      .collect(Collectors.joining(", ", "{", "}"));
	}
	
	public void print() {
		System.out.printf("Picture ratio: %f\n\n", PICTURE_RATIO);
		System.out.printf("Puzzle count: %d\n", PUZZLE_COUNT);
		System.out.printf("Factors of puzzle pieces(%d): %s\n", PUZZLE_COUNT, mapToString(factors));
		System.out.printf("Best grid ratio: %f. Factors of: %dX%d\n", gridRatio, factors.get(factor), factor);
		System.out.printf("Piece ratio: %f\n", pieceRatio);
		System.out.println("===================================");
		System.out.printf("Estimated puzzle count: %d\n", estPuzzleCnt);
		System.out.printf("Factors of estimated puzzle pieces(%d): %s\n", estPuzzleCnt, mapToString(estFactors));
		System.out.printf("Best estimated grid ratio: %f. Factors of: %dX%d\n", estGridRatio, estFactors.get(estFactor), estFactor);
		System.out.printf("Estimated piece ratio: %f\n", estPieceRatio);
	}
}







