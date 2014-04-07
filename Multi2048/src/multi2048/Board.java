/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multi2048;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Ingmar Dasseville
 * @author Jeroen Tempels
 */
public class Board {

    public static final int SIZE = 4;
    public static final int PLAYERS = 2;

    //boards[players][row][column]
    public int[][][] boards = new int[PLAYERS][SIZE][SIZE];
    public int middle;

    public Board() {

    }

    public boolean move(Direction d, int board) {
        int[][] b = boards[board];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int current = d.getSquare(i * SIZE + j);
                int cy = current / SIZE;
                int cx = current % SIZE;

                boolean nonZero = false;
                if (b[cy][cx] == 0) { //empty cell
                    for (int k = j + 1; k < SIZE; k++) { //move all further blocks
                        int kt = d.getSquare(i * SIZE + k);
                        int kx = kt % SIZE;
                        int ky = kt / SIZE;
                        int pk = d.getSquare(i * SIZE + k - 1);
                        int pkx = pk % SIZE;
                        int pky = pk / SIZE;
                        b[pky][pkx] = b[ky][kx];
                        if (b[pky][pkx] != 0) {
                            nonZero |= true;
                        }

                    }
                    int lk = d.getSquare(i * SIZE + SIZE - 1);
                    b[lk / SIZE][lk % SIZE] = 0;

                    if (nonZero) {
                        j--;
                    }

                } else {
                    for (int k = j + 1; k < SIZE; k++) {
                        int o = d.getSquare(i * SIZE + k);
                        if (b[cy][cx] == b[o / SIZE][o % SIZE]) {
                            b[cy][cx]++;
                            b[o / SIZE][o % SIZE] = 0;
                            break;
                        } else if (b[o / SIZE][o % SIZE] != 0) {
                            break;
                        }
                    }
                }
            }
        }

        return false;
    }

    public void addBlock(int board) {
        int number = 1;
        if (Math.random() < 0.25) {
            number = 2;
        }
        ArrayList<Integer> freeIndices = getFreeIndices(board);
        Random r = new Random();
        int place = freeIndices.get(r.nextInt(freeIndices.size()));
        boards[board][place / SIZE][place % SIZE] = number;
    }

    private ArrayList<Integer> getFreeIndices(int board) {
        ArrayList<Integer> freeIndices = new ArrayList<Integer>();
        for (int i = 0; i < SIZE * SIZE; i++) {
            if (0 == boards[board][i / SIZE][i % SIZE]) {
                freeIndices.add(i);
            }
        }
        return freeIndices;
    }

    public boolean isFinished(int board){
        return getFreeIndices(board).size() == 0;
    }
    
    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < SIZE; i++) {
            out += Arrays.toString(boards[0][i]) + "\n";
        }

        return out;

    }

}
