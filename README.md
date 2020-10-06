# MailAddressSorter
In this project you will input an array of mailing addresses from a file and sort them into zip code order.
Once sorted you should output the mailing addresses to an output file in the new sorted order. Each
mailing address should be stored as an object (more on this later) in an array. Once you read in the
mailing addresses you should then call a method to check the starting order. Once you have finished
sorting the addresses you should call a second method to check the sorted list. You will also call
methods in order to time the sort.

Your program will need to implement an interface to represent the mailing addresses. The interface is
available with this assignment. The interface describes different methods to get fields from the class.
In addition, it includes a complete constructor and an input method. These will help you set up your
basic object for an address. In addition, there is a routine get zip digit which will return the given digit
from the zip code. The units digit is digit 1, the tens digit is digit 2, etc…
Once you have implemented your mailing address class you should then work on opening the input file
and reading in an array of the mailing addresses. The array will be no more than 10,000 elements
long, You should read addresses until you reach the end of file or an exception occurs. I strongly
suggest that you print out your array of addresses at this point and check if they are correct. The name
of the input file should be read in from the system input. A sample data file with only a few addresses
will be provided as an initial test. A further test set with a much larger number of addresses will be
added before the due date.
To sort the items you will implement a radix sort.
