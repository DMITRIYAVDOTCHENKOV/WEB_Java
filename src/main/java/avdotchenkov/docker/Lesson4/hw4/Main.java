package avdotchenkov.docker.Lesson4.hw4;

public class Main {
    private static int SIZE = 4;

    private static final String[][] array1 = new String[][]
            {{"2", "5", "6", "4"},
                    {"2", "5", "6", "4"},
                    {"2", "5", "6", "4"},
                    {"2", "5", "6", "4"}};

    private static final String[][] array2 = new String[][]
            {{"2", "5", "6", "4"},
                    {"2", "5", "f", "4"},
                    {"2", "5", "6", "4"},
                    {"2", "5", "6", "4"}};

    public static final String[][] array3 = new String[][]
            {{"2", "5", "6", "4"},
                    {"2", "5", "6", "4", "6"},
                    {"2", "5", "6",},
                    {"2", "5", "6", "4"}};


    public static void checkingForNumericArrayValues(String[][] intMyArray) {
        int sum = 0;
        for (int i = 0; i < intMyArray.length; i++) {
            for (int j = 0; j < intMyArray[i].length; j++) {
                String array = intMyArray[i][j];
                try {
                    sum += Integer.parseInt(array);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(array, i, j);
                }
                String value = intMyArray[i][j];
                System.out.print(sum + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }




    public static void checkingForGoingOutOfTheArray(String[][] myArray) {

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                if (myArray.length != SIZE || myArray[i].length != SIZE) {
                    throw new MyArraySizeException();
                }
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }


    public static void main(String[] args) {
        //Метод проверки массива на цифровые значение, + сложение всех чисел массива.
        try {
            checkingForNumericArrayValues(array1);
        } catch (MyArrayDataException e) {
            e.getMessage();
            System.out.println("В массиве, запрещенные знаки!!");
        }


        // Вызываем метот проверки выхода за пределы массива
        try {
            checkingForGoingOutOfTheArray(array3);
        } catch (MyArraySizeException e) {
            e.getMessage();
            System.out.println("Выход за приделы массива!! " + " размер массива не более: " + SIZE);
        }

    }
}