package com.bridgelabz;

public class SnakeLadder {
    public static final int WIN_POSITION = 100;

    public static void main(String[] args) {

        int snakePosition[] = {8, 12, 18, 21, 28, 38, 50, 62, 77, 82};
        int ladderPosition[] = {20, 30, 45, 66, 88};

        int player1Position = 0;
        int player2Position = 0;

        System.out.println("Start the Snake and Ladder game");

        while (player1Position < WIN_POSITION && player2Position < WIN_POSITION) {

            System.out.println("\nPlayer 1's Turn:");
            player1Position = playTurn(player1Position, snakePosition, ladderPosition);

            if (player1Position >= WIN_POSITION) {
                System.out.println("Player 1 wins!");
                break;
            }

            System.out.println("\nPlayer 2's Turn:");
            player2Position = playTurn(player2Position, snakePosition, ladderPosition);

            if (player2Position >= WIN_POSITION) {
                System.out.println("Player 2 wins!");
                break;
            }
        }
    }

    public static int playTurn(int playerPosition, int[] snakes, int[] ladders) {
        int diceRoll = (int) (Math.random() * 6) + 1;
        System.out.println("Dice rolled: " + diceRoll);

        playerPosition += diceRoll;
        System.out.println("Moved to position: " + playerPosition);

        for (int snake : snakes) {
            if (playerPosition == snake) {
                System.out.println("Oh no! Bitten by a snake at " + snake);
                playerPosition -= diceRoll;
                if (playerPosition < 0)
                    playerPosition = 0;
                System.out.println("Moved back to position: " + playerPosition);
                return playerPosition;
            }
        }

        for (int ladder : ladders) {
            if (playerPosition == ladder) {
                System.out.println("Great! Climbed a ladder at " + ladder);
                playerPosition += diceRoll;
                if (playerPosition > WIN_POSITION)
                    playerPosition = WIN_POSITION;
                System.out.println("Moved forward to position: " + playerPosition);
                return playerPosition;
            }
        }

        if (playerPosition > WIN_POSITION) {
            playerPosition -= diceRoll;
            System.out.println("Roll exceeds WIN_POSITION. Staying at position: " + playerPosition);
        }

        return playerPosition;
    }
}
