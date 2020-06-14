# Library-Books-Issue-and-Renewal-System

It is an application that performs the basic operations in a library. 

### Performs the following functionalities:
* Search for the book’s availability.
* Admins have special authorities.
* Issuing a book.
* Add a new book.
* Return book

### Components used:
+ `JPanel` - It acts as a base and we can add all the components on it.
+ `JButton` - A clickable button.
+ `JLabel`
+ `JTable` - We can create tables.
+ `JTextField` - We can take input from user.
+ `JComboBox` - Dropdown box.
and many others.

### Overview:

* Start the application by running the [Welcome.java](https://github.com/Yashi1011/Library-Books-Issue-and-Renewal-System/blob/master/src/library/Welcome.java) file. It contains a header image which I placed on a separate panel and side orange stripe. It contains 2 buttons.
  * *Admin*: It will lead us to admin's page.
  * *Student*: It will lead us to student’s page.


*  On clicking `Admin` button, we’ll get the frame where we can log in. For this project, I added only one admin account. Program for this is in [Admin_login.java](https://github.com/Yashi1011/Library-Books-Issue-and-Renewal-System/blob/master/src/library/Admin_login.java). `Home` button will lead us to the Home page.
   * *Username* : Admin
   * *Password* : passwd123


* After logging in, In the next frame, we’ll have 4 options. The program file is [Admin_page.java](https://github.com/Yashi1011/Library-Books-Issue-and-Renewal-System/blob/master/src/library/Admin_page.java).
   * `Add book`
   * `Issue book`
   * `Return book`
   * `Logout`


* `Add book`
The ID of the book will be automatically generated once we add the book. Use the given data to test: 

    Title | Author | Year | Language
    --- | --- | --- | ---
    The Fellowship of the Ring (The Lord of the Rings, #1) | J.R.R. Tolkien | 1954 | eng
    Mockingjay (The Hunger Games, #3) | Suzanne Collins | 2010 | eng
    Harry Potter and the Order of the Phoenix (Harry Potter, #5) | J.K. Rowling, Mary GrandPrA | 2003 | eng
    The Lovely Bones | Alice Sebold | 2002 | eng
    Harry Potter and the Chamber of Secrets (Harry Potter, #2) | J.K. Rowling, Mary GrandPrA | 1998 | eng


* `Issue Book`
    It will take ID as input and gives the details of respective book details from the records after clicking the `Check Availability` button. 
    After checking the records if the number of available copies is more than 0 then the `Issue Book` button will be activated. 
    On clicking the `Issue Book` button, the book will be issued and the records will be updated.

* `Return book` 
    It will also take ID as input and gives the details of respective book details from the records after clicking the `Check` button. 
    After checking the records if the number of issued copies is more than 0 then the `Return Book` button will be activated. 
    On clicking the `Return Book` button, the book will be issued and the records will be updated.

* `Logout`
    On clicking the `Logout` button, it asks for conformations if we want to logout or not. On clicking ‘yes’, It’ll take us to *Admins login* page frame.

* On clicking the `Student` button, we’ll go to the student’s page where we can see the list of books available in our library. ( [Student_page.java](https://github.com/Yashi1011/Library-Books-Issue-and-Renewal-System/blob/master/src/library/Student_page.java) )
     The data is read from the file and placed in a table. There is a `search` option so that we can search for the book we want. It works on all the fields. And we can sort each column in ascending and descending orders by double-clicking on the column title. 

