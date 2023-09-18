package avdotchenkov.docker.lesson5;

import java.io.File;

public class Tree {

    public static void main(String[] args) {

        print(new File("."), "", true);

    }

    /**
     * TODO: Доработать метод print, необходимо распечатывать директории и файлы
     *
     * @param file
     * @param indent
     * @param isLast
     */
    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─ ");
            indent += "   ";
        } else {
            System.out.print("├─ ");
            indent += "│  ";
        }
        System.out.println(file.getName());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null)
                return;

            int subItemTotal = files.length;
            for (int i = 0; i < subItemTotal; i++) {
                boolean isSubItemLast = (i == subItemTotal - 1);
                File subItem = files[i];
                if (subItem.isDirectory()) {
                    print(subItem, indent + (isLast ? "   " : "│  "), isSubItemLast);
                } else {
                    System.out.print(indent);
                    System.out.print(isSubItemLast ? "└─ " : "├─ ");
                    System.out.println(subItem.getName());
                }
            }
        }
    }
//    public static void print(File file, String indent, boolean isLast){
//        System.out.print(indent);
//        if (isLast){
//            System.out.print("└─");
//            indent += "  ";
//        }
//        else{
//            System.out.print("├─");
//            indent += "│ ";
//        }
//        System.out.println(file.getName());
//
//        File[] files = file.listFiles();
//        if (files == null)
//            return;
//
//        int subDirTotal = 0;
//        for (int i = 0; i < files.length; i++){
//            if (files[i].isDirectory())
//                subDirTotal++;
//        }
//
//        int subDirCounter = 0;
//        for (int i = 0; i < files.length; i++){
//            if (files[i].isDirectory()){
//                subDirCounter++;
//                print(files[i], indent, subDirCounter == subDirTotal);
//            }
//        }

    }
