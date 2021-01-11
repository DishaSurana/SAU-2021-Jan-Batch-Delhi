-- CREATE DATABASE STUDENT;     NOT AVAILABLE IN ORACLE LIVE SQL

CREATE TABLE StudentBasicInformation 
(  
    StudentName         VARCHAR(20)     NOT NULL,   
    StudentSurName      VARCHAR(20),   
    StudentRollNo       INT, 
    StudentAddress      VARCHAR(30),   
    StudentBdate        DATE,  
    StudentMobile       NUMBER(10)      NOT NULL, 
    StudentSex          CHAR(1),   
    PRIMARY KEY(StudentRollNo) 
)


INSERT INTO StudentBasicInformation 
(StudentRollNo, StudentName, StudentSurName, StudentSex, StudentBdate, StudentMobile, StudentAddress)
VALUES (1, 'Ram', 'Gopal', 'M', TO_DATE('12/01/2016', 'DD/MM/YYYY'), 9812347816, '123/5 Bhopal,MP');

INSERT INTO StudentBasicInformation 
(StudentRollNo, StudentName, StudentSurName, StudentSex, StudentBdate, StudentMobile, StudentAddress)
VALUES (2, 'Ramya', 'Goel', 'F', TO_DATE('02/02/2000', 'DD/MM/YYYY'), 8818847816, 'House-995 Ashok Vihar,Delhi');

INSERT INTO StudentBasicInformation 
(StudentRollNo, StudentName, StudentSurName, StudentSex, StudentBdate, StudentMobile, StudentAddress)
VALUES (3, 'Sanya', 'Agarwal', 'F', TO_DATE('01/02/1994', 'DD/MM/YYYY'), 7812847816, 'House-11 Preet Vihar,Gujarat');


INSERT INTO StudentBasicInformation 
(StudentRollNo, StudentName, StudentSurName, StudentSex, StudentBdate, StudentMobile, StudentAddress)
VALUES (4, 'Deepak', 'Chauhan', 'M', TO_DATE('11/08/1995', 'DD/MM/YYYY'), 7812819116, '812/11 Ram Nagar,Gujarat');


INSERT INTO StudentBasicInformation 
(StudentRollNo, StudentName, StudentSurName, StudentSex, StudentBdate, StudentMobile, StudentAddress)
VALUES (5, 'Nishant', 'Chauhan', 'F', TO_DATE('01/10/1993', 'DD/MM/YYYY'), 9912819116, '11/4 Ramya Building,Mumbai');


INSERT INTO StudentBasicInformation 
(StudentRollNo, StudentName, StudentSurName, StudentSex, StudentBdate, StudentMobile, StudentAddress)
VALUES (6, 'Priyanka', 'Chopra', 'F', TO_DATE('16/03/1998', 'DD/MM/YYYY'), 9910019116, 'Flat-101 Santok Tower,Mumbai');


INSERT INTO StudentBasicInformation 
(StudentRollNo, StudentName, StudentSurName, StudentSex, StudentBdate, StudentMobile, StudentAddress)
VALUES (7, 'Virat', 'Kohli', 'F', TO_DATE('12/05/1993', 'DD/MM/YYYY'), 9912800116, 'Flat-11/4 Paschim Vihar,Delhi');


INSERT INTO StudentBasicInformation 
(StudentRollNo, StudentName, StudentSurName, StudentSex, StudentBdate, StudentMobile, StudentAddress)
VALUES (8, 'M.S', 'Dhoni', 'M', TO_DATE('07/08/1991', 'DD/MM/YYYY'), 9912800777, 'House-119 Sarita Vihar,Ranchi');


INSERT INTO StudentBasicInformation 
(StudentRollNo, StudentName, StudentSurName, StudentSex, StudentBdate, StudentMobile, StudentAddress)
VALUES (9, 'Alia', 'Bhatt', 'F', TO_DATE('11/05/1997', 'DD/MM/YYYY'), 9900800116, 'Flat-23/9 Paschim Vihar,Delhi');


INSERT INTO StudentBasicInformation 
(StudentRollNo, StudentName, StudentSurName, StudentSex, StudentBdate, StudentMobile, StudentAddress)
VALUES (10, 'Saadhvi', 'Mehra', 'F', TO_DATE('11/05/1997', 'DD/MM/YYYY'), 9900822116, 'House-192 Janak Puri,Delhi');

SELECT * FROM StudentBasicInformation;

-- ===================================================================================

CREATE TABLE StudentAdmissionPaymentDetails
(
StudentRollNo   INT     NOT NULL,
AmountPaid      DECIMAL(8,2),
AmountBalance   DECIMAL(8,2),
TransactionID   NUMBER(6),
PaymentMode     VARCHAR(7),
TransactionTime TIMESTAMP,
Semester        INT,
PRIMARY KEY (TransactionID),
FOREIGN KEY (StudentRollNo) references StudentBasicInformation(StudentRollNo)
)

INSERT ALL
INTO StudentAdmissionPaymentDetails
(TransactionID, StudentRollNo, AmountPaid, AmountBalance, TransactionTime, PaymentMode, Semester)
VALUES (101001, 1, 10000.00, 0.00, TIMESTAMP '2019-01-31 09:26:50.12' , 'Offline', 2)
INTO StudentAdmissionPaymentDetails
(TransactionID, StudentRollNo, AmountPaid, AmountBalance, TransactionTime, PaymentMode, Semester)
VALUES (101002, 1, 9000.00, 1000.00, TIMESTAMP '2020-01-31 11:26:50.12' , 'Online', 4)
INTO StudentAdmissionPaymentDetails
(TransactionID, StudentRollNo, AmountPaid, AmountBalance, TransactionTime, PaymentMode, Semester)
VALUES (101003, 2, 10030.00, 0.00, TIMESTAMP '2018-03-31 15:26:22.32' , 'Online', 2)
INTO StudentAdmissionPaymentDetails
(TransactionID, StudentRollNo, AmountPaid, AmountBalance, TransactionTime, PaymentMode, Semester)
VALUES (101004, 3, 10030.00, 20.00, TIMESTAMP '2018-02-21 05:16:02.12' , 'Offline', 2)
INTO StudentAdmissionPaymentDetails
(TransactionID, StudentRollNo, AmountPaid, AmountBalance, TransactionTime, PaymentMode, Semester)
VALUES (101005, 2, 10030.00, 0.00, TIMESTAMP '2019-08-21 15:20:22.32' , 'Online', 3)
INTO StudentAdmissionPaymentDetails
(TransactionID, StudentRollNo, AmountPaid, AmountBalance, TransactionTime, PaymentMode, Semester)
VALUES (101006, 3, 10030.00, 20.00, TIMESTAMP '2019-09-01 05:01:02.12' , 'Offline', 3)
INTO StudentAdmissionPaymentDetails
(TransactionID, StudentRollNo, AmountPaid, AmountBalance, TransactionTime, PaymentMode, Semester)
VALUES (101007, 4, 10030.00, 50.00, TIMESTAMP '2018-08-01 06:01:32.52' , 'Online', 1)
INTO StudentAdmissionPaymentDetails
(TransactionID, StudentRollNo, AmountPaid, AmountBalance, TransactionTime, PaymentMode, Semester)
VALUES (101008, 4, 10000.00, 50.00, TIMESTAMP '2019-07-29 14:01:33.42' , 'Offline', 3)
INTO StudentAdmissionPaymentDetails
(TransactionID, StudentRollNo, AmountPaid, AmountBalance, TransactionTime, PaymentMode, Semester)
VALUES (101009, 5, 10050.00, 20.00, TIMESTAMP '2018-09-01 15:01:02.11' , 'Offline', 5)
INTO StudentAdmissionPaymentDetails
(TransactionID, StudentRollNo, AmountPaid, AmountBalance, TransactionTime, PaymentMode, Semester)
VALUES (101010, 6, 10010.00, 40.00, TIMESTAMP '2020-09-01 09:59:02.12' , 'Offline', 5)
SELECT * FROM dual;

-- UPDATE StudentAdmissionPaymentDetails SET TransactionID = TransactionID-100000 ;

SELECT * FROM StudentAdmissionPaymentDetails order by transactionid ;

-- DROP TABLE StudentAdmissionPaymentDetails
-- ============================================================================================

CREATE TABLE StudentSubjectInformation
(
SubjectOpted 			VARCHAR(10),
StudentRollNo 			INT,
SubjectTotalMarks 		INT,
SubjectObtainedMarks 	INT,
StudentMarksPercentage 	DECIMAL(8,2),
Semester 			    INT,
PRIMARY KEY (SubjectOpted,StudentRollNo),
FOREIGN KEY (StudentRollNo) references StudentBasicInformation(StudentRollNo)
)

INSERT ALL 
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('DBMS', 3, 89, 100, 1)    
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('DS', 3, 55, 70, 2 )   
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('DBMS', 4, 90, 100, 1)    
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('ALGO', 4, 60, 70, 3 )       
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('ALGO', 5, 86, 100, 3)    
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('DS', 5, 62, 70, 2 )  
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('DBMS', 1, 91, 100, 1)    
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('DS', 2, 69, 80, 2 )   
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('DBMS', 2, 50, 70, 1)    
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('ALGO', 1, 60, 70, 3 )       
SELECT * FROM dual;

INSERT ALL 
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('DBMS', 5, 91, 100, 1)    
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('DS', 6, 55, 80, 2 )   
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('DBMS', 7, 82, 100, 1)    
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('ALGO', 6, 52, 75, 3 )       
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('ALGO', 8, 86, 100, 3)    
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('DS', 8, 42, 70, 2 )  
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('DBMS', 8, 71, 80, 1)    
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('DS', 9, 79, 80, 2 )   
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('DBMS', 9, 55, 70, 1)    
INTO StudentSubjectInformation (SubjectOpted, StudentRollNo, SubjectObtainedMarks, SubjectTotalMarks, Semester) VALUES  ('ALGO', 10, 82, 100, 3 )       
SELECT * FROM dual;

SELECT * FROM StudentSubjectInformation;

-- DROP TABLE SubjectScholarshipInformation;

CREATE TABLE SubjectScholarshipInformation
(
    ScholarshipId 			NUMBER GENERATED BY DEFAULT AS IDENTITY,
    StudentRollNo			INT,
    ScholarshipName		    VARCHAR(70),
    ScholarshipDescription	VARCHAR(100),
    ScholarshipAmount		DECIMAL(8,2),
    ScholarshipCategory		VARCHAR(20),
    ScholarshipStartDate	    DATE,
    ScholarshipEndDate		DATE,
    PRIMARY KEY (ScholarshipId),
    FOREIGN KEY (StudentRollNo) references StudentBasicInformation(StudentRollNo)
)

SELECT count( *) FROM SubjectScholarshipInformation


INSERT INTO SubjectScholarshipInformation 
(StudentRollNo, ScholarshipName, ScholarshipDescription, ScholarshipAmount, ScholarshipCategory, ScholarshipStartDate, ScholarshipEndDate)
VALUES(1, 'Indira Gandhi Scholarship Scheme', 'The scheme is for a single girl child who has taken admission in regular, full-time',
36200, 'ALL',to_date('08-11-2019','mm-dd-yyyy'),to_date('08-11-2020','mm-dd-yyyy'))

INSERT INTO SubjectScholarshipInformation 
(StudentRollNo, ScholarshipName, ScholarshipDescription, ScholarshipAmount, ScholarshipCategory, ScholarshipStartDate, ScholarshipEndDate)
VALUES(2, 'PG Merit Scholarship for University Rank Holder', 'Candidate should be the first or second rank holder at the UG level',
3100, 'ALL',to_date('08-09-2018','mm-dd-yyyy'),to_date('09-09-2020','mm-dd-yyyy'))

INSERT INTO SubjectScholarshipInformation 
(StudentRollNo, ScholarshipName, ScholarshipDescription, ScholarshipAmount, ScholarshipCategory, ScholarshipStartDate, ScholarshipEndDate)
VALUES(4, 'Special Scholarship Scheme Ishan Uday for NER', 'The annual income of the family should not be more than Rs.4.5 Lakh.',
7200, 'OBC',to_date('09-01-2017','mm-dd-yyyy'),to_date('08-01-2018','mm-dd-yyyy'))

INSERT INTO SubjectScholarshipInformation 
(StudentRollNo, ScholarshipName, ScholarshipDescription, ScholarshipAmount, ScholarshipCategory, ScholarshipStartDate, ScholarshipEndDate)
VALUES(3, 'Indira Gandhi Scholarship Scheme', 'The scheme is applicable to such a single girl child who has taken admission in regular',
36200, 'ALL',to_date('06-11-2018','mm-dd-yyyy'),to_date('06-11-2019','mm-dd-yyyy'))

INSERT INTO SubjectScholarshipInformation 
(StudentRollNo, ScholarshipName, ScholarshipDescription, ScholarshipAmount, ScholarshipCategory, ScholarshipStartDate, ScholarshipEndDate)
VALUES(5, 'PG Merit Scholarship for University Rank Holder', 'Candidate should be the first or second rank holder at the UG level',
3100, 'ALL',to_date('02-09-2017','mm-dd-yyyy'),to_date('02-09-2019','mm-dd-yyyy'))

INSERT INTO SubjectScholarshipInformation 
(StudentRollNo, ScholarshipName, ScholarshipDescription, ScholarshipAmount, ScholarshipCategory, ScholarshipStartDate, ScholarshipEndDate)
VALUES(6, 'Emeritus Fellowship', 'The candidate must have given their service career with quality research and distributed work.',
8000, 'SC',to_date('09-01-2019','mm-dd-yyyy'),to_date('08-02-2020','mm-dd-yyyy'))

INSERT INTO SubjectScholarshipInformation 
(StudentRollNo, ScholarshipName, ScholarshipDescription, ScholarshipAmount, ScholarshipCategory, ScholarshipStartDate, ScholarshipEndDate)
VALUES(8, 'Post Graduate Merit Scholarship for University Rank Holder', 'Candidate should be the first or second rank holder at the UG level',
3100, 'ALL',to_date('10-09-2018','mm-dd-yyyy'),to_date('10-09-2020','mm-dd-yyyy'))

INSERT INTO SubjectScholarshipInformation 
(StudentRollNo, ScholarshipName, ScholarshipDescription, ScholarshipAmount, ScholarshipCategory, ScholarshipStartDate, ScholarshipEndDate)
VALUES(7, 'Emeritus Fellowship', 'The candidate must have given their service career with quality research and distributed work.',
8000, 'SC',to_date('01-01-2020','mm-dd-yyyy'),to_date('01-01-2021','mm-dd-yyyy'))

INSERT INTO SubjectScholarshipInformation 
(StudentRollNo, ScholarshipName, ScholarshipDescription, ScholarshipAmount, ScholarshipCategory, ScholarshipStartDate, ScholarshipEndDate)
VALUES(9, 'Post-Doctoral Fellowship to SC/ST Candidates', 'The fellowship is for unemployed candidates who have a Ph.D. degree in relevant subject.',
5000, 'ST',to_date('01-11-2019','mm-dd-yyyy'),to_date('01-11-2021','mm-dd-yyyy'))

INSERT INTO SubjectScholarshipInformation 
(StudentRollNo, ScholarshipName, ScholarshipDescription, ScholarshipAmount, ScholarshipCategory, ScholarshipStartDate, ScholarshipEndDate)
VALUES(10, 'Dr.D.S.Kothari Postdoctoral Fellowship Scheme', 'The fellowship is for applicants <35 yrs age who has Ph.D. degree in science faculty.',
2000, 'SC',to_date('05-19-2020','mm-dd-yyyy'),to_date('05-19-2021','mm-dd-yyyy'))

INSERT INTO SubjectScholarshipInformation 
(StudentRollNo, ScholarshipName, ScholarshipDescription, ScholarshipAmount, ScholarshipCategory, ScholarshipStartDate, ScholarshipEndDate)
VALUES(1, 'CV Raman Scholarship Scheme', 'The scheme is for a child who has taken admission in regular, full-time PG',
5200, 'HANDICAPPED',to_date('08-11-2017','mm-dd-yyyy'),to_date('08-11-2018','mm-dd-yyyy'))




