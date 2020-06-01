De Anza College CIS
Home
CIS36A
CIS36B
CIS22C
Lab 2 - Generic, Doubly-Linked List (100 pts)
Due Friday, April 24 at 11:59pm on Canvas

Pair Programming Requirement (Half Credit for Not Pair Programming)
Both partners fill in, sign and date the pair programming contract and BOTH partners submit this file.
Only one partner submits the lab assignment on Canvas. Please make sure both your names are on ALL the files.
Both partners follow the rules for pair programming.

Before you begin!
Install Eclipse on your home computer (if needed)
You are required to use Eclipse in this class (Yes, really!).
See my tutorial for help installing and creating a new project, and for a trouble shooting guide
See the De Anza CIS Tutorial on Eclipse for Mac and Windows
Install Zoom and invite your partner to a Zoom meeting
Follow the tutorial from the Office of Online Education here

Part 1: Project Set Up
Complete the tutorial from Lab 1 if you have not already.
Make sure that your code compiles and runs properly on Eclipse

Part 2: Creating a Doubly-Linked List Class
The next part of your assignment is to alter the List class from the tutorial to be a doubly-linked list.
The principle difference for our doubly-linked List class, is that each node will contain a reference to both to the next node and to the previous node in the List.
You can visualize a doubly-linked list like so:


Image source.

Therefore, your inner Node class will be updated to look like the following:

private class Node {
private T data;
private Node next;
private Node prev;

public Node(T data) {
this.data = data;
this.next = null;
this.prev = null;
}
}
Additionally, bear in mind that the first Node of the list now has a prev Node reference to null while the last Node has a next Node reference to null.
The advantage of the prev reference is the ease with which we can traverse the list in both directions, and also perform some more challenging operations such as removeLast().
To account for the presence of this additional reference variable in the Node class, you will need to make updates to the tutorail code for many of the List methods.
Most of these updates are as simple as adding one line of code to the method.
However, removeLast() will change significantly. Hint: remove the loop from this method!
For example, let's look at the insertFirst() method:
      /**
     * Creates a new first element
     * @param data the data to insert at the
     * front of the list
     * @postcondition a new first element
     */
    public void addFirst(T data) {
        if (first == null) {
            first = last = new Node(data);
        } else {
            Node N = new Node(data);
            N.next = first;
            first.prev = N;
            first = N;
        }
        length++;
    }
Important! Each time you update one of your methods, run your tests again to make sure your List is still working properly.
If you want more information on doubly-linked lists, you can watch this short video (8 min).

Part 3: Pre and Post Conditions
As you update each method from the tutorial to convert it into a doubly-linked list method, also fill in the pre and postconditions for each method, as necessary.
An example has been completed for you above.
Remember that preconditions indicate what conditions must be met BEFORE the user calls the method. The method will not work properly unless the preconditions are met.
Postconditions indicate what will be the result of the method call. In other words, what conditions will exist after the method is called.
See class notes from this week and also watch the lesson videos.

Part 4: Adding New Functionality to your List Class
Your doubly-linked list needs to be able to perform all of the same operations as the singly-linked list.
However, as you may have noted when writing tutorial, the singly-linked List class was very limited.
You could only add and remove data at the two ends of the List
What about the middle of the List?
How can we access data or insert and remove data from the middle of the List?
To increase the functionality of our class, we will be adding some new methods and a new member variable to the List.
First, add a new private member variable to the class to store the iterator - a node reference that we will use to move around the List container.
Unlike the first and last Nodes, which must always remain in the same location, the iterator will need to change positions in the List.
private int length;
private Node first;
private Node last;
private Node iterator;
All of the required methods for this lab are described below:


Constructors:
constructor: constructs a new linked list object.
copy constructor: makes a copy of this list object
Mutators:
removeFirst: removes the element at the beginning of the list   
removeLast: removes the element at the end of the list <--Important: Rewrite for this Lab! Remove while loop
addFirst: inserts an element at the beginning of the linked list
addLast: inserts an element at the end of the list
placeIterator: moves the iterator to the start of the list
removeIterator: removes the element currently pointed to by the iterator. Postcondition: Iterator then points to NULL.
addIterator: inserts an element after the node currently pointed to by the iterator
advanceIterator: moves the iterator up by one node
reverseIterator: moves the iterator down by one node
Accessors:
getFirst: returns the first element
getLast: returns the last element
isEmpty: tests whether the linked list is empty
getLength: returns the current length of the list
getIterator: returns the element currently pointed at by the iterator
offEnd: returns whether the iterator is off the end of the list, i.e. is NULL
equals: overrides the equals method for object to compares this list to another list to see if they contain the same data in the same order.

Additional Operations:
toString: overrides the toString method for object to print the contents of the linked list to the screen separated by a blank space
printNumberedList: prints the contents of the linked list to the screen in the format #. <element> followed by a newline
Note that, as you write each method, you must also write its Javadoc comment, including, where necessary, using the @precondition tag and @postcondition tag for each method, as well as the @throws tag.
Hint: You can use the above descriptions as a starting point for your Javadoc comments.
You should also test your methods inside of ListTest.java - two method calls minimum for each of the 20 methods.
Part 5: Scheduler App (20 pts)
Create a class called Scheduler.java inside of your List project folder
This program should store a user schedule inside of a linked list - with one event stored per node
It should call the List iterator methods to move events around in the schedule
There are 3 menu options offered to the user:
A: Add an event
R: Remove and event
X: Exit
The Add an event option:
Should prompt for a new event and then store the event at the front of the List
Next, it should prompt the user whether or not to move the event up in the schedule (later in the schedule) and how far up, as shown in the example output below
The above functionality will require you to call placeIterator(), advanceIterator() and addIterator()
It should also do some error checking if the user wants to move the event past the end of the List, and allow the user to keep entering values until giving a valid input. (See sample output below)
The remove an event option:
Prompts the user for the number of the event and removes it (call placeIterator(), advanceIterator() the specified number of times followed by removeIterator())
The exit option should print "Goodbye" and end the application
The program should also check whether the user has entered an invalid menu option (A value other than A, R or X or their lower case equivalents) and print an error message as shown below.
Scheduler.java should give identical output (including formatting and line spacing) to the output below (given the same user input):
Example Output:

Welcome to the Scheduler App!

You have no upcoming events!

Select from the following options:
A: Add an event
R: Remove an event
X: Exit

Enter your choice: A

Please enter an event: Walk dog

Your Current Schedule:

1. Walk dog

Select from the following options:
A: Add an event
R: Remove an event
X: Exit

Enter your choice: A

Please enter an event: Make dinner

You just added the following event to your schedule: Make dinner

Your Current Schedule:

1. Make dinner
2. Walk dog

Would you like to move this event up in your schedule (Y/N): Y
Enter the number of places: 1

Your Current Schedule:

1. Walk dog
2. Make dinner

Select from the following options:
A: Add an event
R: Remove an event
X: Exit

Enter your choice: A

Please enter an event: Grade labs

You just added the following event to your schedule: Grade labs

Your Current Schedule:

1. Grade labs
2. Walk dog
3. Make dinner

Would you like to move this event up in your schedule (Y/N): Y
Enter the number of places: 10
Sorry that input is invalid!

Enter the number of places: 18
Sorry that input is invalid!

Enter the number of places: 2

Your Current Schedule:

1. Walk dog
2. Make dinner
3. Grade labs

Select from the following options:
A: Add an event
R: Remove an event
X: Exit

Enter your choice: R
Enter the number of the event to remove: 2

Removing: Make dinner

Your Current Schedule:

1. Walk dog
2. Grade labs

Select from the following options:
A: Add an event
R: Remove an event
X: Exit

Enter your choice: X

Goodbye!

Specifications for Submission

Please submit the following files to Canvas (one partner):
List.java (a complete and fully commented generic, doubly-linked List class, including specified methods)
ListTest.java (test file with at least 2 method calls to each method written)
Scheduler.java (source file with all of the logic to create the Scheduler App shown above)
Pair programming contract (both partners)
Important: You must name your files exactly as described above
Also, your code must compile using Eclipse for Java.
Please submit each file separately (no zip files or other compressed file type -5 pts).
Please remove all package statements before submitting (-5 pts).


How You Will Be Graded:

No credit if your List.java file contains any additional methods other than those specified in the directions or if the inner Node class has been altered in any way from what was given in this Lab.
Make sure that you test your list thoroughly inside of ListTest.java!
No credit if your List doesn't compile or run using the Eclipse IDE as specified above
No credit if your program doesn't compile. Make sure to comment out the parts that aren't working (if any) before you submit.
Please include a block comment with your name on the top of EACH file like so:

/**
* @author FirstName LastName
* @author FirstName LastName
* CIS 22C, Lab 2
*/
54 points of the credit will be for submitting a complete and functional generic, doubly-linked list (3 points per correct method)
15 points for adequate testing (each method fully tested - minimum of two method calls per method -inside of ListTest.java class)
15 points for correct pre and postconditions noted in the Javadoc comment for each method and using the style demonstrated in class.
16 for a complete and functional Scheduler.java that works as shown in the sample output.
-50 points if you do not complete this assignment following the rules of pair programming
-5 points for missing pair programming contract
Please submit each file separately (no zip files or other compressed file type -5 pts).
Please remove all package statements before submitting (-5 pts).
0 points for incorrectly named files


Sign in|Report Abuse|Print Page|Powered By Google Sites
