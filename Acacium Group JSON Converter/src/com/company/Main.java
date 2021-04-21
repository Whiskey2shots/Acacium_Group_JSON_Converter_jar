package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        System.out.println("please enter the path to your csv:");
        String input = scanner.nextLine();

        System.out.println("please enter the path to where you would like your json:");
        String output = scanner.nextLine();

        List nurses = readCsvFile(input);//reading in csv from src folder inside project

        CSV_JSON(nurses, output + "/" + "nurses.json");//exporting json to specified folder
    }

    private static List readCsvFile(String filePath) {

        //intialising

        BufferedReader fileReader = null;
        CSVParser csvParser = null;

        List nurses = new ArrayList();
        List broken = new ArrayList();

        try {//reading in csv utilizing first row as a header row
            fileReader = new BufferedReader(new FileReader(filePath));
            csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            Iterable <CSVRecord>csvRecords = csvParser.getRecords();//retrieves records from csv

            for (CSVRecord csvRecord : csvRecords) {

                Nurse nurse = new Nurse(//creating nurse objects to enter into the nurses list

                        csvRecord.get("creator"),
                        Integer.parseInt(csvRecord.get("break")),
                        csvRecord.get("description"),
                        csvRecord.get("start"),
                        csvRecord.get("end"),
                        csvRecord.get("shiftType")
                );
                String nursecheck = String.valueOf(nurse.ShiftType);//checking for null data
                System.out.println(nursecheck);
                if (nursecheck.isEmpty()) {
                    broken.add(nurse);//adds the nurse object to a list that will not be printed
                }
                else {
                    nurses.add(nurse);//adds the nurse object to a list that will be printed
                }

            }

        } catch (Exception e) {
            System.out.println("Reading CSV Error!");//in case of errors
            System.exit(0);
        } finally {
            try {
                fileReader.close();
                csvParser.close();
            } catch (IOException e) {
                System.out.println("Closing fileReader/csvParser Error!");//in case of errors
                e.printStackTrace();
            }
        }

        return nurses;
    }

    private static void CSV_JSON(List nurses, String pathFile) {
        ObjectMapper mapper = new ObjectMapper();

        File file = new File(pathFile);
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, nurses);//prints out the nurses list to the json file, prints in a pretty format
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}