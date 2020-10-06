package com.company;
import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ProjectZero {
    public static String name = null;
    public static String address1 = null;
    public static String address2 = null;
    public static String city = null;
    public static String state = null;
    public static int zip = 0;

    public static void main(String[] args) {
        List<ConcreteMailingAddress>myList = new ArrayList<>();
        Project0Helper helper = new Project0Helper();
        Scanner inputFileScanner; //Create a scanner to read in the file contents
        try {
            //Create a scanner to ask the user to paste the path of their input file.
            Scanner inScanner = new Scanner(System.in);
            System.out.println("Input file:");
            String filePath = inScanner.nextLine();
            File file = new File(filePath);//Create a new file object.

            inputFileScanner = new Scanner(file); //Read the file contents
            try {
                //Read the file and store all the address in an ArrayList called myList.
                while(inputFileScanner.hasNext()) {
                    name = inputFileScanner.nextLine();
                    address1 = inputFileScanner.nextLine();
                    address2 = inputFileScanner.nextLine();
                    city = inputFileScanner.nextLine();
                    state = inputFileScanner.nextLine();
                    zip = inputFileScanner.nextInt();
                    inputFileScanner.nextLine();  // get rid of the rest of the line after the zip code
                    myList.add(new ConcreteMailingAddress(name, address1, address2, city, state, zip));
                }
            }
            catch(NoSuchElementException e) {
                //For some reason the scanner wasn't reading in the final address, so this method was placed in the
                //catch exception to add that last address to myList.
                myList.add(new ConcreteMailingAddress(name, address1, address2, city, state, zip));
            }
        }
        catch (FileNotFoundException e) {e.printStackTrace();}

        //This converts the ArrayList to an Array for the project0helper class. This code was basically provided by Dr. Heuring.
        ConcreteMailingAddress[] addressArray = new ConcreteMailingAddress[myList.size()];
        for(int i = 0; i < myList.size(); i++)
        {
            addressArray[i] = myList.get(i);
        }

        try{
            //Ask the user what they would like to name thier output file, and send the contents of
            //the sorted list into that file.
            Scanner scan = new Scanner(System.in);
            System.out.println("Output File: ");
            String outputFileName = scan.nextLine();

            helper.checkStartingOrder(addressArray);
            RadixSort(myList); //Call the radix sort method to sort the addresses.
            PrintWriter pw = new PrintWriter(outputFileName);//Create a printwriter and send in the sorted contents to the output file the user states.

            //PrintWriter will then go and send in all the sorted addresses into the file that the user chooses.
            //This file will be structured in the same way the input file was structured.
            for(int i = 0; i < myList.size(); i++){
                pw.println(myList.get(i).getName());
                pw.println(myList.get(i).getAddressLine1());
                pw.println(myList.get(i).getAddressLine2());
                pw.println(myList.get(i).getCity());
                pw.println(myList.get(i).getState());
                pw.println(myList.get(i).getZipCode());
            }
            pw.close();//Close the printwriter

            //This for loop gets the contents from the ArrayList myList and puts it into the array addressArray.
            for(int i = 0; i < myList.size(); i++)
            {
                addressArray[i] = myList.get(i);
            }
            helper.checkFinalOrder(addressArray);
        }
        catch(IOException e){e.printStackTrace();}
    }

    //This method is the radixSort method which sorts the address by their Zip Codes.
    public static List<ConcreteMailingAddress> RadixSort(List<ConcreteMailingAddress> sortedList){
        //Create a 2d arrayList, and then create 10 1-D bins.
        List<List<ConcreteMailingAddress>> listSorter = new ArrayList<List<ConcreteMailingAddress>>();
        List<ConcreteMailingAddress> binZero = new ArrayList<ConcreteMailingAddress>();
        List<ConcreteMailingAddress> binOne = new ArrayList<ConcreteMailingAddress>();
        List<ConcreteMailingAddress> binTwo = new ArrayList<ConcreteMailingAddress>();
        List<ConcreteMailingAddress> binThree = new ArrayList<ConcreteMailingAddress>();
        List<ConcreteMailingAddress> binFour = new ArrayList<ConcreteMailingAddress>();
        List<ConcreteMailingAddress> binFive = new ArrayList<ConcreteMailingAddress>();
        List<ConcreteMailingAddress> binSix = new ArrayList<ConcreteMailingAddress>();
        List<ConcreteMailingAddress> binSeven = new ArrayList<ConcreteMailingAddress>();
        List<ConcreteMailingAddress> binEight = new ArrayList<ConcreteMailingAddress>();
        List<ConcreteMailingAddress> binNine = new ArrayList<ConcreteMailingAddress>();

        //Add the bins to the 2-D ArrayList.
        listSorter.add(binZero);
        listSorter.add(binOne);
        listSorter.add(binTwo);
        listSorter.add(binThree);
        listSorter.add(binFour);
        listSorter.add(binFive);
        listSorter.add(binSix);
        listSorter.add(binSeven);
        listSorter.add(binEight);
        listSorter.add(binNine);

            /*
            This nested for loop will go through each and every zip code attached to the address. Then
            it will accordingly put the zip codes into the correct bins, by grabbing each of the digits in the zip
            code.
             */
        for(int i = 1; i <= 5; i++){
            for(int j = 0; j < sortedList.size(); j++){
                int zipDigit = sortedList.get(j).getZipCodeDigit(i);
                if(zipDigit == 0)
                    binZero.add(sortedList.get(j));
                else if(zipDigit == 1)
                    binOne.add(sortedList.get(j));
                else if(zipDigit == 2)
                    binTwo.add(sortedList.get(j));
                else if(zipDigit == 3)
                    binThree.add(sortedList.get(j));
                else if(zipDigit == 4)
                    binFour.add(sortedList.get(j));
                else if(zipDigit == 5)
                    binFive.add(sortedList.get(j));
                else if(zipDigit == 6)
                    binSix.add(sortedList.get(j));
                else if(zipDigit == 7)
                    binSeven.add(sortedList.get(j));
                else if(zipDigit == 8)
                    binEight.add(sortedList.get(j));
                else if(zipDigit == 9)
                    binNine.add(sortedList.get(j));
                else
                    System.out.println("Error in sort. Try again.");
            }
            clearList(listSorter, sortedList); //Call the clear list method to clear bins and add sorted list back to the ArrayList.
        }
        return sortedList;
    }

    //This method clears the bins and then adds those address that were in the bins, back to the list.
    public static void clearList(List<List<ConcreteMailingAddress>> listSorter,List<ConcreteMailingAddress> sortedList)
    {
        sortedList.clear();
        for(int k = 0; k < listSorter.size(); k++){
            for(int j = 0; j < listSorter.get(k).size(); j++){
                sortedList.add(listSorter.get(k).get(j));
            }
            listSorter.get(k).clear();
        }
    }

}
