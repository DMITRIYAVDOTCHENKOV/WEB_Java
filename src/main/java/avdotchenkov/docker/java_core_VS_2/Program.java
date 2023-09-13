package avdotchenkov.docker.java_core_VS_2;

import java.util.Random;
import java.util.Scanner;

public class Program {
    public static final String AI_WIN_MSG = "Победил компьютер!";
    public static final String HUMAN_WIN_MSG = "Победил человек!";
    public static final String DRAW_MSG = "Ничья!";
    private static final int SIZE = 3; // размер поля
    private static final int DOT_TO_WIN = 3;// кол-во символов в линии для победы
    private static final char DOT_HUMAN = 'X'; // Фишка игрока - человека
    private static final char DOT_AI = 'O'; // Фишка игрока - компьютер
    private static final char DOT_EMPTY = '*'; //  Признак пустого поля

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] fieled; // Двумерный массив хранит текущее состояние игрового поля

    private static int fieldSizeX; // Размерность игрового поля
    private static int fieldSizeY; // Размерность игрового поля

    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkGameState(DOT_HUMAN, "Вы победили"))
                    break;
                aiTurn();
                printField();
                if (checkGameState(DOT_AI, "Победил компьютер"))
                    break;
            }
            System.out.println("Сыграть еще раз? Y-да, N-нет ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    private static void initialize() {
        fieldSizeX = SIZE;
        fieldSizeY = SIZE;
        fieled = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                fieled[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка игрового поля
     */
    private static void printField() {
        System.out.print("+");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++) {
            System.out.print((x % 2 == 0) ? "-" : x / 2 + 1);
        }
        System.out.println();
        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(fieled[x][y] + "|");
            }
            System.out.println();
        }
        for (int x = 0; x < fieldSizeX * 2 + 1; x++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Обработка хода игрока (человек)
     */
    private static void humanTurn() {
        int x, y;
        do {

            System.out.print("Введите координаты хода X и Y ( от 1 до 3) через через пробел >>> ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        fieled[x][y] = DOT_HUMAN;
    }

    /**
     * Проверка, ячейки является ли пустой (DOT_EMPTY)
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellEmpty(int x, int y) {
        return fieled[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать размерность игрового поля)
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Обработка хода компьютера
     */
    private static void aiTurn() {
        int x, y;
        do {

            System.out.print("Введите координаты хода X и Y ( от 1 до 3) через\n через пробел >>> ");
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        fieled[x][y] = DOT_AI;
    }

    /**
     * Проверка состояния игры
     *
     * @param c фишка игрока
     * @param s победа слоган
     */
    private static boolean checkGameState(char c, String s) {
        if (checkWin(c)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья");
            return true;
        }
        return false; //Игра продолжается
    }


    /**
     * Проверка на победу
     *
     * @param c
     * @return
     */
    private static boolean checkWin(char c) {
        // по трем горизонталям
        if (fieled[0][0] == c && fieled[0][1] == c && fieled[0][2] == c)
            return true;
        if (fieled[1][0] == c && fieled[2][1] == c && fieled[1][2] == c)
            return true;
        if (fieled[2][0] == c && fieled[2][1] == c && fieled[2][2] == c)
            return true;

        // по трем вертикалям
        if (fieled[0][0] == c && fieled[1][0] == c && fieled[2][0] == c)
            return true;
        if (fieled[0][1] == c && fieled[1][1] == c && fieled[2][1] == c)
            return true;
        if (fieled[0][2] == c && fieled[1][2] == c && fieled[2][2] == c)
            return true;

        // по диагоналям
        //    private static boolean Diagonals(char symbol){
        int mainDiagCounter = 0;
        int sideDiagCounter = 0;
        for (int i = 0; i < SIZE; i++) {
            mainDiagCounter = (fieled[i][i] == c) ? mainDiagCounter +1 : 0;
            sideDiagCounter = (fieled[i][fieled.length - 1 - i] ==c) ? sideDiagCounter + 1 : 0;
            if (mainDiagCounter == DOT_TO_WIN || sideDiagCounter == DOT_TO_WIN) {
                return true;
            }
        }
        return false;
    }


    /**
     * Проверка на ничью
     *
     * @return
     */
    private static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x, y))
                    return false;
            }
        }
        return true;
    }
}