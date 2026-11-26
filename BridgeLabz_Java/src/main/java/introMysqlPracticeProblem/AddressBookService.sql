-- UC1: Create database
CREATE DATABASE AddressBookService;

USE AddressBookService;

-- UC2 : Ability to create a Address Book Table with first and last names, address, city,state, zip, phone number and email as its attributes
CREATE TABLE AddressBook (
                             firstName VARCHAR(50),lastName VARCHAR(50),address VARCHAR(255),
                             city VARCHAR(50),state VARCHAR(50),zip VARCHAR(10),phoneNumber VARCHAR(15),
                             email VARCHAR(100)
);

-- UC3: Insert New Contacts into AddressBook
INSERT INTO AddressBook
(firstName, lastName, address, city, state, zip, phoneNumber, email)
VALUES
    ('Rithika', 'S', 'Anna Nagar', 'Chennai', 'Tamil Nadu', '600040', '9876543210', 'rithika@gmail.com');

INSERT INTO AddressBook
(firstName, lastName, address, city, state, zip, phoneNumber, email)
VALUES
    ('Priya', 'Sharma', 'MG Road', 'Bangalore', 'Karnataka', '560001', '9876543211', 'priya@gmail.com');

INSERT INTO AddressBook
(firstName, lastName, address, city, state, zip, phoneNumber, email)
VALUES
    ('Arun', 'Kumar', 'T Nagar', 'Chennai', 'Tamil Nadu', '600017', '9876543212', 'arun@gmail.com');

-- UC4: Edit Existing Contact Using Their Name
SET SQL_SAFE_UPDATES = 0;
UPDATE AddressBook
SET
    address = 'Velachery',
    city = 'Chennai',
    state = 'Tamil Nadu',
    zip = '600042',
    phoneNumber = '9876543219',
    email = 'rithika17@gmail.com'
WHERE firstName = 'Rithika' AND lastName = 'S';

-- UC5: Delete a person using person's name
DELETE FROM AddressBook WHERE firstName = 'Rithika' AND lastName = 'S';

-- UC6: Retrieve persons belonging to a City or State
SELECT * FROM AddressBook WHERE city='Chennai' OR state='Tamil Nadu';

-- UC7: Understand the size of Address Book by City and State
SELECT city, state, COUNT(*) AS ContactCount FROM AddressBook GROUP BY city, state;

-- UC8: Retrieve entries alphabetically by person's name for a given city
SELECT * FROM AddressBook WHERE city = 'Chennai' ORDER BY firstName ASC, lastName ASC;

-- UC9: Identify each Address Book with Name and Type.
ALTER TABLE AddressBook ADD name VARCHAR(50),ADD type VARCHAR(50);
UPDATE AddressBook
SET name = 'Personal',
    type = 'Family'
WHERE firstName = 'Arun';


-- UC10: Get the number of contact persons by type
SELECT type, COUNT(*) AS ContactCount FROM AddressBook GROUP BY type;

-- UC11: Ability to add a person to both Friend and Family
CREATE TABLE ContactType (
                             contactId INT AUTO_INCREMENT PRIMARY KEY,
                             firstName VARCHAR(50),
                             lastName VARCHAR(50),
                             type VARCHAR(50)
);
INSERT INTO ContactType (firstName, lastName, type) VALUES ('Rithika', 'S', 'Friend'),('Rithika', 'S', 'Family');

SELECT * FROM ContactType;

-- UC12
RENAME TABLE AddressBook TO OldAddressBook;
CREATE TABLE Contact (
                         ContactID INT AUTO_INCREMENT PRIMARY KEY,
                         FirstName VARCHAR(50),LastName VARCHAR(50),Address VARCHAR(255),
                         City VARCHAR(50),State VARCHAR(50),ZIP VARCHAR(10));
CREATE TABLE AddressBook (
                             AddressBookID INT AUTO_INCREMENT PRIMARY KEY,
                             Name VARCHAR(50),
                             Type VARCHAR(50)
);
CREATE TABLE ContactAddressBook (
                                    ContactID INT,
                                    AddressBookID INT,

                                    PRIMARY KEY (ContactID, AddressBookID),

                                    FOREIGN KEY (ContactID)
                                        REFERENCES Contact(ContactID),

                                    FOREIGN KEY (AddressBookID)
                                        REFERENCES AddressBook(AddressBookID)
);

CREATE TABLE ContactPhone (
                              PhoneID INT AUTO_INCREMENT PRIMARY KEY,
                              ContactID INT,
                              PhoneNumber VARCHAR(15),
                              FOREIGN KEY (ContactID) REFERENCES Contact(ContactID)
);
CREATE TABLE ContactEmail (
                              EmailID INT AUTO_INCREMENT PRIMARY KEY,
                              ContactID INT,
                              Email VARCHAR(100),
                              FOREIGN KEY (ContactID) REFERENCES Contact(ContactID)
);



-- UC13: ENSURE ALL RETRIEVAL QUERIES WORK WITH
-- THE NEW TABLE STRUCTURE

-- UC6: RETRIEVE PERSONS BELONGING TO A CITY OR STATE
-- Retrieve contacts by City
SELECT * FROM Contact WHERE City = 'Chennai';
-- Retrieve contacts by State
SELECT * FROM Contact WHERE State = 'Tamil Nadu';

-- UC7: UNDERSTAND ADDRESS BOOK SIZE BY CITY AND STATE
SELECT City,State,COUNT(*) AS ContactCount FROM Contact GROUP BY City, State;

-- UC8: RETRIEVE ENTRIES SORTED ALPHABETICALLY
-- BY PERSON'S NAME FOR A GIVEN CITY
SELECT * FROM Contact WHERE City = 'Chennai' ORDER BY FirstName ASC, LastName ASC;


-- UC10: GET NUMBER OF CONTACT PERSONS BY TYPE
SELECT AB.Type,COUNT(DISTINCT CAB.ContactID) AS ContactCount FROM AddressBook AB
                                                                      JOIN ContactAddressBook CAB ON AB.AddressBookID = CAB.AddressBookID GROUP BY AB.Type;
-- RETRIEVE CONTACT DETAILS WITH ADDRESS BOOK TYPE
SELECT C.ContactID,C.FirstName,C.LastName,AB.Name AS AddressBookName,AB.Type
FROM Contact C JOIN ContactAddressBook CAB ON C.ContactID = CAB.ContactID
               JOIN AddressBook AB ON CAB.AddressBookID = AB.AddressBookID;
-- VERIFY ALL TABLES
SELECT * FROM Contact;
SELECT * FROM AddressBook;
SELECT * FROM ContactAddressBook;



