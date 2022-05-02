package algorithm;


public class Jig2 {
	public static void main(String[] args) {
		new JigSolver(200, 49, 36);
	}
}

class JigSolver {
	private final int PUZZLE_COUNT;
	private final double PICTURE_RATIO;
	private final double BADNESS_P_EXTRA = 0.005;
	private final int SEARCH_RANGE = 50;
	
	private double badness;
	private int estPuzzleCnt;
	
	public JigSolver(int puzzleCnt, double width, double height) {
		super();
		PUZZLE_COUNT = puzzleCnt;
		PICTURE_RATIO = width/height;
		badness = 100;
		solve();
	}
	
	public void solve() {
		System.out.println("Puzzle count: " + PUZZLE_COUNT);
		System.out.printf("Picture ratio: %f\n\n", PICTURE_RATIO);
		for(int i = 0; i <= SEARCH_RANGE; i++) {
			solve(PUZZLE_COUNT + i, i);
		}
		printEstPuzzleCnt();
	}
	
	private void solve(int puzzleCnt, int num) {
		double gridRatio = puzzleCnt;
		double pieceRatio = 0;
		double badness = 0;
		int factor = 1;
		for(int i = 1; i <= Math.sqrt(puzzleCnt); i += 1 + puzzleCnt%2) {
			if(puzzleCnt % i == 0) {
				if((double)puzzleCnt/i/i < gridRatio) {
					gridRatio = (double)puzzleCnt/i/i;
					pieceRatio = gridRatio/PICTURE_RATIO;
					int extraPieces = puzzleCnt - PUZZLE_COUNT; 
					badness = pieceRatio * Math.pow((1 + BADNESS_P_EXTRA), extraPieces);
					factor = i;
					if(badness < this.badness) {
						this.badness = badness;
						estPuzzleCnt = puzzleCnt;
					}
				}
			}
		}
		print(String.valueOf(num), puzzleCnt, gridRatio, factor, pieceRatio, badness);
	}
	
	private void printEstPuzzleCnt() {
		System.out.printf("Best guess for piece count is %d pieces.", estPuzzleCnt);
	}
	
	private void print(String num, int puzzleCnt, double gridRatio, int factor, double pieceRatio, double... badness) {
		System.out.printf("%s.%s\n", num, "=".repeat(100));
		System.out.printf("For %d pieces, closest grid ratio is %f of %dX%d board. Piece ratio: %f.\n",
				puzzleCnt, gridRatio, factor, puzzleCnt/factor, pieceRatio);
		for(double i : badness) {
			System.out.printf("Badness rating: %f\n\n", i);
		}
	}
}