package src.ClassicsQuestion;

public class EightQueensQuestion {
    private boolean[] row = new boolean[8];
    private boolean[] column = new boolean[8];
    private boolean[] left = new boolean[15];
    private boolean[] right = new boolean[15];
    private int[] position = new int[8];
    private int p = -1;
    private int method = 0;

    public EightQueensQuestion() {
        for (int i = 0; i < 8; i++) {
            row[i] = true;
            column[i] = true;
            position[i] = -1;
        }
        for (int i = 0; i < 15; i++) {
            left[i] = true;
            right[i] = true;
        }
    }

    public boolean inQueen(int nowrow, int nowcolumn) {
        boolean t = false;
        if (row[nowrow] && column[nowcolumn] && left[nowrow + nowcolumn] && right[nowrow - nowcolumn + 7]) {
            t = true;
        }
        return t;
    }

    public void changemap(int nowrow, int nowcolumn, boolean b) {
        row[nowrow] = b;
        column[nowcolumn] = b;
        left[nowrow + nowcolumn] = b;
        right[nowrow - nowcolumn + 7] = b;
        position[nowrow] = nowcolumn;
    }

    public void printmap() {
        System.out.println("皇后问题的第" + method + "种解法");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (position[i] == j) {
                    System.out.print("@  ");
                } else {
                    System.out.print("#  ");
                }
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------");
    }

    public void QueenQuestion() {
        int nowrow = 0, nowcolumn;
        while (true) {
            for (nowcolumn = p + 1; nowcolumn < 8 && !inQueen(nowrow, nowcolumn); nowcolumn++) ;
            if (nowcolumn < 8) {
                changemap(nowrow, nowcolumn, false);
            } else {
                if (nowrow > 0) {
                    nowrow--;
                    changemap(nowrow, position[nowrow], true);
                    p = position[nowrow];
                    continue;
                } else {
                    break;
                }
            }
            if (nowrow == 7) {
                method++;
                printmap();
                changemap(7, position[nowrow], true);
                p = position[nowrow];
            } else {
                nowrow++;
                p = -1;
            }
        }
    }

}