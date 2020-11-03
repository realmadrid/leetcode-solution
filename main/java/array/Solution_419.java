package array;

/**
 * 沉没战舰法
 */
public class Solution_419 {
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    sink(board, i, j);
                }
            }
        }
        return count;
    }

    private void sink(char[][] board, int x, int y) {
        // 如果坐标超出边界或该位置是'.'，则直接返回
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1 || board[x][y] == '.') {
            return;
        }
        board[x][y] = '.';
        sink(board, x - 1, y);
        sink(board, x + 1, y);
        sink(board, x, y - 1);
        sink(board, x, y + 1);
    }
}
