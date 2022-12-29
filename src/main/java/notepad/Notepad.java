package notepad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Notepad {
    private static  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Notepad() {
    }

   public static void run() throws IOException {
        Record.fillMap();
        Record.print();
    }

    private static class Record {

        private static HashMap<Date, HashMap<Integer, Record>> notepads = new HashMap<>();

        private String name;
        private String description;

        Record(String name, String description) {
            this.name = name;
            this.description = description;
        }

        static void print() {
            for (Map.Entry<Date, HashMap<Integer, Record>> el: notepads.entrySet()) {
                System.out.println("Date: " + el.getKey());
                for (Map.Entry<Integer, Record> innerEl: el.getValue().entrySet()) {
                    System.out.println("id = " + innerEl.getKey() + ", Record: " + innerEl.getValue().toString());
                }
            }
        }

        static void fillMap() throws IOException {
            Date currentDate = new Date();
            HashMap<Integer,Record> innerMap = fillInnerMap();
            notepads.put(currentDate, innerMap);
        }

        private static HashMap<Integer, Record> fillInnerMap() throws IOException {
            HashMap<Integer, Record> innerMap = new HashMap<>();
            int numberOfRecords = getNumberOfRecords();
            String name = "";
            String description = "";
            for (int i = 0; i < numberOfRecords; i++) {
                name = getNameFromConsole();
                description = getDescriptionFromConsole();
                innerMap.put(i, new Record(name, description));
            }
            return innerMap;
        }

        private static String getDescriptionFromConsole() throws IOException {
            String description ;
            System.out.println("Input description record: ");
            description = reader.readLine();
            return description;

        }

        private static String getNameFromConsole() throws IOException {
            String name;
            System.out.println("Input name record: ");
            name = reader.readLine();
            return name;
        }

        private static int getNumberOfRecords() throws IOException {
            System.out.println("Input number of records: ");
            return Integer.parseInt(reader.readLine());
        }

        @Override
        public String toString() {
            return "[name= " + name + ", description= " + description + "]";
        }
    }
}
