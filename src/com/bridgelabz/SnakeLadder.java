package com.bridgelabz;

public class SnakeLadder {
    public static final int WIN_POSITION = 100;

    public static void main(String[] args) {

        int snakePosition[] = {8, 12, 18, 21, 28, 38, 50, 62, 77, 82,};
        int ladderPosition[] = {20, 30, 45, 66, 88};
        int player1Position = 0;
        System.out.println("Start the snake ladder game");
        System.out.println("Player 1 is at position " + player1Position);
        System.out.println("Player 1 rolls a dice");

        while (player1Position < WIN_POSITION) {

            int rolledResult = (int) (Math.random() * 6) + 1;
            System.out.println("\nPlayer 1 rolls a dice & result is " + rolledResult);

            if (player1Position + rolledResult <= WIN_POSITION) {
                player1Position += rolledResult;
                System.out.println("Player 1 moves to position " + player1Position);

                for (int snake : snakePosition) {
                    if (player1Position == snake) {
                        player1Position -= rolledResult;
                        System.out.println("Oops! Player 1 got a snake at position " + snake);
                        System.out.println("Player 1 moves back to position " + player1Position);
                        break;
                    }
                }

                for (int ladder : ladderPosition) {
                    if (player1Position == ladder) {
                        player1Position += rolledResult;
                        if (player1Position > WIN_POSITION) {
                            player1Position = WIN_POSITION;
                        }
                        System.out.println(" Player 1 got a ladder at position " + ladder);
                        System.out.println("Player 1 moves forward to position " + player1Position);
                        break;
                    }
                }
            } else {
                System.out.println("Dice roll exceeds WIN_POSITION. Player stays at position " + player1Position);
            }
        }

        System.out.println("\nPlayer 1 wins the game by reaching position " + player1Position + "!");
    }
}