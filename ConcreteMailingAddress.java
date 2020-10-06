package com.company;

public class ConcreteMailingAddress implements MailAddressInterface {
    protected String name;
    protected String address1;
    protected String address2;
    protected String city;
    protected String state;
    protected int zip;
    protected int tempZip;

    //This constructor is created to take in all the contents of the file, create them as objects, then put those objects into the arrayList.
    public ConcreteMailingAddress(String name, String address1, String address2, String city, String state, int zip)
    {
        this.name = name;
        this.address1 = address1;
        this.address2=address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddressLine1() {
        return address1;
    }

    @Override
    public String getAddressLine2() {
        return address2;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public int getZipCode() {
        return zip;
    }

    @Override
    public int getZipCodeDigit(int digit) {
        tempZip = zip;
        int outputZip = 0;
        switch (digit) {
            case 1:
                outputZip = tempZip % 10;
                break;
            case 2:
                tempZip /= 10;
                outputZip = tempZip % 10;
                break;
            case 3:
                tempZip /= Math.pow(10, 2);
                outputZip = tempZip % 10;
                break;
            case 4:
                tempZip /= Math.pow(10, 3);
                outputZip = tempZip % 10;
                break;
            case 5:
                tempZip /= Math.pow(10, 4);
                outputZip = tempZip % 10;
                break;
//            default:
//                outputZip = 0;
        }
        return outputZip;
    }
}
