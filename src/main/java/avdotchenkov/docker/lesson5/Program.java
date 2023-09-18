package avdotchenkov.docker.lesson5;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {

    /**
     1.  Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
     2.  Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
     3.* Написать метод, который проверяет, присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
     4.* Написать метод, проверяющий, есть ли указанное слово в папке
     */

//    private static final Random random = new Random();
//    private static final int CHAR_BOUND_L = 65;
//    private static final int CHAR_BOUND_H = 90;
    private static final String TO_SEARCH = "GeekBrains";

    public static void main(String[] args) throws IOException {

        String fileName1 = "file1.txt";
        String fileName2 = "file2.txt";
        String fileName3 = "file3_res.txt";

        writeFileContents(fileName1, generateSymbols(50));
        writeFileContents(fileName2, generateSymbols(50));

        concatenate(fileName1, fileName2, fileName3);

        if (searchInFile(fileName3, TO_SEARCH)) {
            System.out.println("Файл " + fileName3 + " содержит искомое слово " + TO_SEARCH);
        } else {
            System.out.println("Файл " + fileName3 + " не содержит искомое слово " + TO_SEARCH);
        }

        List<String> result = searchMatch(new File("."), TO_SEARCH);
        for (String s : result) {
            System.out.println("Файл " + s + " содержит искомое слово " + TO_SEARCH);
        }
    }

    private static List<String> searchMatch(File dir, String search) throws IOException {
        List<String> list = new ArrayList<>();
        File[] files = dir.listFiles();
        if (files == null)
            return list;
        for (File file : files) {
            if (file.isDirectory())
                continue;
            if (searchInFile(file.getName(), search)) {
                list.add(file.getName());
            }
        }
        return list;
    }

    /**
     * Метод генерации некоторой последовательности символов
     *
     * @param count кол-во символов
     * @return последовательность символов
     */
    private static String generateSymbols(int count) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    /**
     * Записать последовательность символов в файл
     *
     * @param fileName имя файла
     * @param content  содержимое файла
     * @throws IOException
     */
    private static void writeFileContents(String fileName, String content) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(content);
        }
    }

    private static void concatenate(String fileIn1, String fileIn2, String fileOut) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileOut)) {
            try (BufferedReader reader1 = new BufferedReader(new FileReader(fileIn1))) {
                String line;
                while ((line = reader1.readLine()) != null) {
                    fileWriter.write(line + "\n");
                }
            }

            try (BufferedReader reader2 = new BufferedReader(new FileReader(fileIn2))) {
                String line;
                while ((line = reader2.readLine()) != null) {
                    fileWriter.write(line + "\n");
                }
            }
        }
    }

    private static boolean searchInFile(String fileName, String search) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(search)) {
                    return true;
                }
            }
        }
        return false;
    }
}
//        System.out.println(generateSymbols(30));
//        writeFileContents("sample01.txt", 30);
//        writeFileContents("sample02.txt", 30, 1);
//        concatenate("sample01.txt", "sample02.txt", "sample03_res.txt");
//
//        if (searchInFile("sample03_res.txt", TO_SEARCH))
//            System.out.printf("Файл %s содержит искомое слово %s\n", "sample03_res.txt", TO_SEARCH);
//
//        String[] fileNames = new String[10];
//        for (int i = 0; i < fileNames.length; i++) {
//            fileNames[i] = "file_" + i + ".txt";
//            writeFileContents(fileNames[i], 30, 3);
//            System.out.printf("Файл %s создан.\n", fileNames[i]);
//        }
//
//        List<String> result = searchMatch(new File("."), TO_SEARCH);
//        for (String s : result) {
//            System.out.printf("Файл %s содержит искомое слово %s\n", s, TO_SEARCH);
//        }
//
//    }
//
//    private static List<String> searchMatch(File dir, String search) throws IOException{
//        dir = new File(dir.getCanonicalPath());
//        List<String> list = new ArrayList<>();
//        File[] files = dir.listFiles();
//        if (files == null)
//            return list;
//        for (int i = 0; i < files.length; i++){
//            if (files[i].isDirectory())
//                continue;
//            if (searchInFile(files[i].getName(), search)){
//                list.add(files[i].getName());
//            }
//        }
//        return list;
//    }
//
//
//    /**
//     * Метод генерации некоторой последовательности символов
//     * @param count кол-во символов
//     * @return последовательность символов
//     */
//    private static String generateSymbols(String count){
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < count.length(); i++){
//            stringBuilder.append((char) random.nextInt(CHAR_BOUND_L, CHAR_BOUND_H + 1));
//        }
//        return stringBuilder.toString();
//    }
//
//    /**
//     * Записать последовательность символов в файл
//     * @param fileName имя файла
//     * @param length кол-во символов
//     * @throws IOException
//     */
//    private static void writeFileContents(String fileName, int length) throws IOException {
//        try(FileOutputStream fileOutputStream = new FileOutputStream(fileName)){
//            fileOutputStream.write(generateSymbols(String.valueOf(length)).getBytes());
//        }
//    }
//
//    private static void writeFileContents(String fileName, int length, int i) throws IOException {
//        try(FileOutputStream fileOutputStream = new FileOutputStream(fileName)){
//            if (random.nextInt(i) == 0){
//                fileOutputStream.write(TO_SEARCH.getBytes());
//            }
//            fileOutputStream.write(generateSymbols(String.valueOf(length)).getBytes());
//        }
//    }
//
//    private static void concatenate(String fileIn1, String fileIn2, String fileOut) throws IOException{
//        // На запись
//        try(FileOutputStream fileOutputStream = new FileOutputStream(fileOut)){
//
//            int c;
//            // На чтение
//            try(FileInputStream fileInputStream = new FileInputStream(fileIn1)){
//                while ( (c = fileInputStream.read()) != -1)
//                    fileOutputStream.write(c);
//            }
//
//            // На чтение
//            try(FileInputStream fileInputStream = new FileInputStream(fileIn2)){
//                while ( (c = fileInputStream.read()) != -1)
//                    fileOutputStream.write(c);
//            }
//        }
//    }
//
//    /**
//     * Определить, содержится ли в файле искомое слово
//     * @param fileName имя файла
//     * @param search слово
//     * @return результат поиска
//     * @throws IOException
//     */
//    private static boolean searchInFile(String fileName, String search) throws IOException{
//        try(FileInputStream fileInputStream = new FileInputStream(fileName)){
//            byte[] searchData = search.getBytes();
//            int c;
//            int i = 0;
//            while ( (c = fileInputStream.read()) != -1){
//                if (c == searchData[i]) {
//                    i++;
//                }
//                else{
//                    i = 0;
//                    if (c == searchData[i])
//                        i++;
//                    continue;
//                }
//                if (i == searchData.length){
//                    return true;
//                }
//            }
//            return false;
//        }
//    }
//}
