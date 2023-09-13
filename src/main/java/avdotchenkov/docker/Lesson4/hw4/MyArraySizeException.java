package avdotchenkov.docker.Lesson4.hw4;

public class MyArraySizeException extends IllegalAccessError {

    public MyArraySizeException() {
        super("Не вырный  индекс массива!");
    }
}