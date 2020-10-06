package com.company;
import java.util.*;
import java.io.*;

public class Project0Helper {
    protected ArrayList<Integer> zipList;
    long startTime, endTime;
    int outOfOrder, missingZip;

    public Project0Helper() {
        zipList = new ArrayList<Integer> (100);
        startTime = 0;
        endTime = 0;
        outOfOrder = 0;
        missingZip = 0;
    }
    public void checkStartingOrder(MailAddressInterface mailingList[]) {
        for (int i = 0; i < mailingList.length; i++) {
            if (mailingList[i] != null) {
                zipList.add(mailingList[i].getZipCode());
            }
        }
        startTime = System.currentTimeMillis();
    }
    public void checkFinalOrder(MailAddressInterface mailingList[]) {
        int finalListSize = mailingList.length;

        endTime = System.currentTimeMillis();
        for (int i = 0; i < mailingList.length; i++) {
            if (mailingList[i] == null) {
                finalListSize = i;
                break;
            }
        }

        if (zipList.size() != finalListSize) {
            System.out.println("Final list size does not match initial list size!");
            System.out.println("Initial List Size = " + zipList.size() );
            System.out.println("Final List Size = " + finalListSize);
        } else {
            System.out.println("Initial and Final list sizes match.");
        }

        for (int i=1; i < finalListSize; i++) {
            if (mailingList[i-1].getZipCode() > mailingList[i].getZipCode()) {
                System.out.println("Zip Code Out of Order");
                System.out.println("Address " + (i-1));
                System.out.println(mailingList[i-1]);
                System.out.println("Address " + (i));
                System.out.println(mailingList[i]);
                outOfOrder++;
            }
        }

        zipList.sort(null);
        for (int i = 0; i < finalListSize; i++) {
            if (mailingList[i].getZipCode() != zipList.get(i).intValue()) {
                System.out.println("Expecting to see zip code "+zipList.get(i).intValue());
                System.out.println("Found: ");
                System.out.println(mailingList[i]);
                missingZip++;
            }
        }

        System.out.println("Time Taken = "+(endTime - startTime)+" msec");
    }
}
