import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {
    public static char[][] map;
    public static final int MAP_SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Man's victory!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw!");
                break;
            }
            computerTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Computer victory!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw!");
                break;
            }
        }
        System.out.println("Game over.");

    }


    public static void initMap() {
        map = new char[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= MAP_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn() {
        int xCoordinate;
        int yCoordinate;
        do {
            System.out.println("Enter coordinates in the format \"x\" space \"y\"");
            xCoordinate = sc.nextInt() - 1;
            yCoordinate = sc.nextInt() - 1;
        } while (!isCellValidHumanOrComputerTurn(xCoordinate, yCoordinate));
        map[yCoordinate][xCoordinate] = DOT_X;
    }

    public static void computerTurn() {
        int xCoordinate;
        int yCoordinate;
        do {
            xCoordinate = rand.nextInt(MAP_SIZE);
            yCoordinate = rand.nextInt(MAP_SIZE);
        } while (!isCellValidHumanOrComputerTurn(xCoordinate, yCoordinate));
        System.out.println("The computer went to the point " + (xCoordinate + 1) + " " + (yCoordinate + 1));
        map[yCoordinate][xCoordinate] = DOT_O;
    }

    private static boolean isCellValidHumanOrComputerTurn(int xCoordinate, int yCoordinate) {
        if (xCoordinate < 0 || xCoordinate >= MAP_SIZE || yCoordinate < 0 || yCoordinate >= MAP_SIZE) {
            System.out.println("Error! Incorrect coordinates entered.");
            return false;
        }
        if (map[yCoordinate][xCoordinate] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char symbol) {
        int countSymbol;
        for (int i = 0; i < MAP_SIZE; i++) {
            countSymbol = 0;
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == symbol) {
                    countSymbol++;
                } else {
                    countSymbol--;
                }
                if (countSymbol == DOTS_TO_WIN) {
                    System.out.println("Horizontal.");
                    return true;
                }
            }
        }
        for (int i = 0; i < MAP_SIZE; i++) {
            countSymbol = 0;
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[j][i] == symbol) {
                    countSymbol++;
                } else {
                    countSymbol--;
                }
                if (countSymbol == DOTS_TO_WIN) {
                    System.out.println("Vertical.");
                    return true;
                }
            }
        }
        countSymbol = 0;
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (i == j) {
                    if (map[i][j] == symbol) {
                        countSymbol++;
                    } else {
                        countSymbol--;
                    }
                }
                if (countSymbol >= DOTS_TO_WIN) {
                    System.out.println("Left Diagonal!");
                    return true;
                }
            }
        }
        countSymbol = 0;
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (i == j - 1) {
                    if (map[i][j] == symbol) {
                        countSymbol++;
                    } else {
                        countSymbol--;
                    }
                }
                if (countSymbol >= DOTS_TO_WIN) {
                    System.out.println("Left Diagonal!!");
                    return true;
                }
            }
        }
        countSymbol = 0;
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (i - 1 == j) {
                    if (map[i][j] == symbol) {
                        countSymbol++;
                    } else {
                        countSymbol--;
                    }
                }
                if (countSymbol >= DOTS_TO_WIN) {
                    System.out.println("Left Diagonal!!!");
                    return true;
                }
            }
        }

        countSymbol = 0;
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (j == MAP_SIZE - i - 1) {
                    if (map[j][i] == symbol) {
                        countSymbol++;
                    } else {
                        countSymbol--;
                    }
                }
                if (countSymbol >= DOTS_TO_WIN) {
                    System.out.println("Right Diagonal!");
                    return true;
                }
            }
        }

        countSymbol = 0;
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (j == MAP_SIZE - i - 2) {
                    if (map[j][i] == symbol) {
                        countSymbol++;
                    } else {
                        countSymbol--;
                    }
                }
                if (countSymbol >= DOTS_TO_WIN) {
                    System.out.println("Right Diagonal!!");
                    return true;
                }
            }
        }

        countSymbol = 0;
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (j - 1 == MAP_SIZE - i - 1) {
                    if (map[j][i] == symbol) {
                        countSymbol++;
                    } else {
                        countSymbol--;
                    }
                }
                if (countSymbol >= DOTS_TO_WIN) {
                    System.out.println("Right Diagonal!!!");
                    return true;
                }
            }
        }
        return false;
    }
}
