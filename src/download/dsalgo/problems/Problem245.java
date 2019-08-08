package download.dsalgo.problems;

import java.util.*;

/**
 * Knight movement on a chess board
 * 
 * Given any source point and destination point on a chess board, we need to
 * find whether Knight can move to the destination or not.
 * 
 * Knight's movements on a chess board
 * 
 * The above figure details the movements for a knight ( 8 possibilities ). Note
 * that a knight cannot go out of the board.
 * 
 * If yes, then what would be the minimum number of steps for the knight to move
 * to the said point. If knight can not move from the source point to the
 * destination point, then return -1
 * 
 * Input:
 * 
 * N, M, x1, y1, x2, y2 where N and M are size of chess board x1, y1 coordinates
 * of source point x2, y2 coordinates of destination point Output:
 * 
 * return Minimum moves or -1 Example
 * 
 * Input : 8 8 1 1 8 8 Output : 6
 * 
 * @author kaussark
 *
 */
public class Problem245 {

	public static void main(String[] args) {
		int xBoard = 2;
		int yBoard = 20;
		int kPosX = 1;
		int kPosY = 18;
		int tPosX = 1;
		int tPosY = 5;

		System.out.println(new Problem245().knight(xBoard, yBoard, kPosX, kPosY,
				tPosX, tPosY));
	}

	private static class Position {
		int x, y, distance;

		public boolean equals(Object object) {

			if (object == null) {
				return false;
			}

			if (!(object instanceof Position)) {
				return false;
			}
			Position pos = (Position) object;
			if (pos.x != x || pos.y != y) {
				return false;
			}
			return true;
		}

		public String toString() {
			return "[" + x + "|" + y + "]";
		}
	}

	public int knight(int A, int B, int C, int D, int E, int F) {
		boolean[][] chessBoard = new boolean[A + 1][B + 1];

		Position knight = new Position();
		Position target = new Position();
		knight.x = C;
		knight.y = D;
		knight.distance = 0;
		target.x = E;
		target.y = F;

		int[] px = { -2, -2, -1, -1, 1, 1, 2, 2 };
		int[] py = { -1, 1, -2, 2, -2, 2, -1, 1 };

		Queue<Position> posQ = new LinkedList<>();
		posQ.offer(knight);
		chessBoard[knight.x][knight.y] = true;
		while (!posQ.isEmpty()) {
			Position position = posQ.poll();

			if (position.equals(target)) {
				return position.distance;
			}
			for (int pos = 0; pos < 8; pos++) {
				Position nextPos = new Position();
				nextPos.x = position.x + px[pos];
				nextPos.y = position.y + py[pos];
				if (isValid(nextPos,A,B) && !chessBoard[nextPos.x][nextPos.y]) {
					chessBoard[nextPos.x][nextPos.y] = true;
					nextPos.distance = position.distance + 1;
					posQ.offer(nextPos);
				}
			}
		}
		return -1;
	}

	private boolean isValid(Position nextPos,int maxRow, int maxCol) {
		if (nextPos.x <= 0 || nextPos.y <= 0 || nextPos.x > maxRow || nextPos.y > maxCol)
			return false;
		return true;
	}

}
