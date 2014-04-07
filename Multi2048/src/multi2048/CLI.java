/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package multi2048;

import java.util.Scanner;

/**
 *
 * @author ingmar
 */
public class CLI {
    public static void main(String args){
        Scanner sc = new Scanner(System.in);
        Board b = new Board();
        System.out.println("+-----------+");
        System.out.println("| Multi2048 |");
        System.out.println("+-----------+");
        while(true){
            b.addBlock(0);
            System.out.println(b);
            System.out.println("Enter a move: ");
            String move = sc.next();
            Direction direction = Direction.UP;
            if("u".equals(move)){
                direction = Direction.UP;
            }
            else if("d".equals(move)){
                direction = Direction.DOWN;
            }
            else if("l".equals(move)){
                direction = Direction.LEFT;
            }
            else if("r".equals(move)){
                direction = Direction.RIGHT;
            }
            b.move(direction, 0);
                
        }
    }
}
