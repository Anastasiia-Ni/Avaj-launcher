package src;

import java.io.IOException;
import src.utils.FileParser;

public class App {

    public static void main( String[] args ) {
        if (args.length == 1) {
            try {
                FileParser parser = new FileParser(args[0]);
                parser.processFile();


            }
            catch (IOException e){
                System.out.println("Error processing file: " + e.getMessage());
            }
            // создать класс парсер для открывания проверки  и считывания файл
        }
        else {
            System.out.println("Wrong number of arguments. One argument is expected: the file path.");
        }

    }

}