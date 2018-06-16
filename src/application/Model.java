package application;

public class Model {
    public static final int X = 1;
    public static final int O = -1;
    public static final int BLANK = 0;

    public static final int SIZE = 3;
    private int[][] table;
    private int activePlayer;

    public void setValue(int x, int y, int value) {
        table[x][y] = value;
    }

    public int getValue(int x, int y) {
        return table[x][y];
    }

    public int getActivePlayer() {
        return activePlayer;
    }

    public void switchPlayer() {
        activePlayer = -activePlayer;
    }

    /*
     * Konstruktor
     */
    public Model() {
        table = new int[SIZE][SIZE];
        activePlayer = O;
    }

    /*
     * Metoda sprawdzaj¹ca kto wygra³
     */
    public int getWinner() {
        int winner = BLANK;

        //sprawdzamy wiersze
        for(int row=0; row < SIZE; row++) {
            for(int col=1; col < SIZE; col++) {
                if(table[row][col] !=  table[row][col-1]) {
                    //przerywamy sprawdzanie tego wiersza
                    break;
                } else if(col == SIZE-1) {
                    winner = table[row][col];
                    return winner;
                }
            }
        }

        //sprawdzamy kolumny
        for(int row=0; row < SIZE; row++) {
            for(int col=1; col < SIZE; col++) {
                if(table[col][row] !=  table[col-1][row]) {
                    //przerywamy sprawdzanie tej kolumny
                    break;
                } else if(col == SIZE-1) {
                    winner = table[col][row];
                    return winner;
                }
            }
        }

        //sprawdzamy pierwsz¹ przek¹tn¹
        for(int i=1; i<SIZE; i++) {
            if(table[i][i] != table[i-1][i-1]) {
                break;
            } else if(i == SIZE-1) {
                winner = table[i][i];
                return winner;
            }
        }

        //sprawdzamy drug¹ przek¹tn¹
        for(int i=0; i < SIZE-1; i++) {
            if(table[i][SIZE-1 - i] != table[i+1][SIZE-2 - i]) {
                break;
            } else if(i == SIZE-2) {
                winner = table[i][i];
                return winner;
            }
        }

        return winner;
    }
}
