package avdotchenkov.docker.Lesson4.hw4;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(String cellValue, int row, int col) {
        super(String.format("Неверное значение '%s' в ячейки [%d][%d]", cellValue, row, col));
    }

}