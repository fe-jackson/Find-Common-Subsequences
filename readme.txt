PROJECT TITLE: Find Common Subsequences

DATE: November 21, 2020

AUTHOR: Fe Jackson

PURPOSE OF PROJECT: This program was an assignment for a 200 level college course
called Programming Systems. The assignment instructions were the following:

"You will write a Java program that compares several DNA strands and looks for
common subsequences among the strands. Each DNA strand consists of a sequence
of bases (A, G, C, U) and is represented as a line of characters in an input
file. For example, this would represent four DNA strands:

UACUCGGAUGUUGCAGAG
GACCAGUUAUACUCGUCUGAGAG
UCUUACUCGGAUGCUAGAGCUAGGA
CCUGGAGCACUCGCCUG

A common subsequence is a sequence of bases where the same sequence of bases
appears in all the strands. The common subsequence can be at any location in
each strand. With the above example, a common subsequence is "ACUCG" and it
appears in each of the strands (2nd, 11th, 5th, and 9th positions,
respectively). We only consider common subsequences that are between 5 and 15
characters long, inclusivly. That is, we wouldn't count the "GAG" common
subsequence even though it appears in each strand.

The strands are of various lengths and there could be more than one common
subsequence that appears in all of them. Your program will need to find all of
the subsequences and then print them out in order from longest to
shortest. See the output.txt file for the exact format and values.

This assignment includes several data files containing DNA strands. All of the
data files have the same subsequences in their DNA strands so the results from
your program will be the same on all of the files (exactly what is in
output.txt)."

HOW TO START THIS PROJECT: Compile FindCommonSubsequences.java and ReadLines.java
on any Java compiler. An example of a free Java compiler is a program called 
BlueJ.

USER INSTRUCTIONS:
Run the main function in the ReadLines class, passing it a string containing the 
path the text file containing the strings that the program will be comparing. The 
provided text files are "large.txt", "medium.txt", "small.txt", "verylarge.txt", 
and "verysmall.txt". Each provided file, when provided to the program, will prompt 
the same output from the program.