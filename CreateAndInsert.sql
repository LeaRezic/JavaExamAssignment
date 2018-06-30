CREATE DATABASE VirgoHospitals
GO
USE VirgoHospitals
GO

--USE master
--DROP DATABASE VirgoHospitals
--GO


-- KREIRANJE TABLICA (i INSERT)
CREATE TABLE Country (
	IDCountry INT IDENTITY
	,Name NVARCHAR(50) NOT NULL UNIQUE
	,CONSTRAINT PK_Country PRIMARY KEY (IDCountry)
)

INSERT INTO Country (Name)
VALUES ('Canada')
,('Mexico')

CREATE TABLE City (
	IDCity INT IDENTITY
	,Name NVARCHAR(50) NOT NULL
	,CountryID INT NOT NULL
	,CONSTRAINT PK_City PRIMARY KEY (IDCity)
	,CONSTRAINT FK_CityCountry FOREIGN KEY (CountryID) REFERENCES Country(IDCountry)
)

INSERT INTO City (Name, CountryID)
VALUES ('Winnipeg',1)
,('Toronto',1)
,('Ottawa',1)
,('Vancouver',1)
,('Victoria',1)
,('Golden',1)
,('Tulum',2)
,('Merida',2)
,('Chichen Itza',2)
,('Comitan',2)
,('San Cristobal de las Casas',2)
,('Las Margaritas',2)

CREATE TABLE BasicDetails (
	IDBasicDetails INT IDENTITY
	,FirstName NVARCHAR(50) NOT NULL
	,MiddleName NVARCHAR(50)
	,LastName NVARCHAR(50) NOT NULL
	,FullStreet NVARCHAR(255) NOT NULL
	,PINcode NVARCHAR(15) NOT NULL
	,CityID INT NOT NULL
	,Telephone NVARCHAR(15)
	,MobilePhone NVARCHAR(15)
	,Email NVARCHAR(50)
	,CONSTRAINT PK_PersonBase PRIMARY KEY (IDBasicDetails)
	,CONSTRAINT FK_BasicDetailsCity FOREIGN KEY (CityID) REFERENCES City(IDCity)
)

INSERT INTO BasicDetails (FirstName, MiddleName, LastName, FullStreet, PINcode, CityID, Telephone, MobilePhone, Email)
VALUES ('Graham','Arthur','Chapman','101 Doctor Street','24341',1,'(111) 539-4457','(010101) 318596','chapman@outpatient.ca')
,('John','Marwood','Cleese','202 Doctor Street','24341',1,'(222) 539-4457','(020202) 318596','cleese@outpatient.ca')
,('Eric',NULL,'Idle','303 Doctor Street','24341',1,'(333) 539-4457','(030303) 318596','idle@outpatient.ca')
,('Michael','Edward','Palin','404 Doctor Street','24341',1,'(444) 539-4457','(040404) 318596','palin@outpatient.ca')
,('Terence','Graham Parence','Jones','505 Doctor Street','24341',1,'(555) 539-4457','(050505) 318596','jones@outpatient.ca')
,('Terrence','Vance','Gilliam','606 Doctor Street','24341',1,'(666) 539-4457','(060606) 318596','gilliam@outpatient.ca')

INSERT INTO BasicDetails (FirstName, MiddleName, LastName, FullStreet, PINcode, CityID, Telephone, MobilePhone, Email)
VALUES ('Aureliano','Maximilian','Jose','Some street 22','24341',1,'(406) 456-1072','(0964) 76876783','semper@nulla.org')
,('Juan',NULL,'Jose','Thirteenth Av 654','6179 YY',2,'(753) 708-9945','(039029) 920817','Vivamus.non.lorem@congue.org')
,('Helen','of','Troy','Nonummy Street','33981',3,'(423) 304-8479','(00597) 1746904','ornare@ornarefacilisiseget.co.uk')
,('Marry',NULL,'Poppins','Posuere St. 1071','17016',4,'(863) 240-7778','(024) 52273014','risus@NuncmaurisMorbi.net')
,('Juan','Jose','Jedanaesti','Rhoncus Rd. 109','96831-420',9,'(139) 506-3578','(0196) 03899475','pede.ac.urna@nibh.net')
,('Pipi','Duga','Čarapa','Nunc Street 43','319174',10,'(572) 128-4970','(063) 71935907','ullamcorper@dapibus.co.uk')
,('Dunja',NULL,'Kotonjata','Proin Street 67','74095',11,'(496) 359-1628','(0719) 67368144','magna.malesuada.vel@conubianostra.co.uk')
,('Milica',NULL,'Krmpotić','Lorem Avenue 686','13640',12,'(198) 937-2207','(036586) 655851','Duis.risus.odio@libero.co.uk')

CREATE TABLE MaritalStatus (
	IDMaritalStatus INT IDENTITY
	,Name NVARCHAR(25)
	,CONSTRAINT PK_MaritalStatus PRIMARY KEY (IDMaritalStatus)
)

INSERT INTO MaritalStatus (Name)
VALUES ('Married')
,('Single')
,('Divorced')
,('Widowed')
,('Civil_Partnership')

CREATE TABLE BloodType (
	IDBloodType INT IDENTITY
	,Name NVARCHAR(5)
	,CONSTRAINT PK_BloodType PRIMARY KEY (IDBloodType)
)

INSERT INTO BloodType (Name)
VALUES ('A+')
,('A-')
,('B+')
,('B-')
,('AB+')
,('AB-')
,('0-')
,('0+')

CREATE TABLE PersonalDetails (
	IDPersonalDetails INT IDENTITY
	,Sex BIT
	,DateOfBirth DATE
	,MaritalStatusID INT
	,Occupation NVARCHAR(50)
	,Height FLOAT
	,Weight FLOAT
	,BloodTypeID INT
	,CONSTRAINT PK_PersonalDetails PRIMARY KEY (IDPersonalDetails)
	,CONSTRAINT FK_PersonalDetailsMaritalStatus FOREIGN KEY (MaritalStatusID) REFERENCES MaritalStatus(IDMaritalStatus)
	,CONSTRAINT FK_PersonalDetailsBloodType FOREIGN KEY (BloodTypeID) REFERENCES BloodType(IDBloodType)
)

INSERT INTO PersonalDetails(Sex, DateOfBirth, MaritalStatusID, Occupation, Height, Weight, BloodTypeID)
VALUES (0,'1989-01-01',1,'Carpenter',190,89,1)
,(0,'1978-12-06',2,'Programmer',155,65,2)
,(1,'1980-02-02',3,'Pilot',188,50.4,3)
,(1,'1999-05-05',4,'Astronaut',178,124.2,4)
,(0,'2010-11-07',5,'English teacher',202,102,5)
,(1,'2002-04-30',1,'Prison guard',190,156.5,6)
,(1,'1981-10-17',1,'Mason',215,156,7)
,(1,'2012-12-02',2,'Electrician',195,205.3,8)

CREATE TABLE LifestyleDetails (
	IDLifestyleDetails INT IDENTITY
	,Vegetarian BIT
	,CigaretsPerDay INT
	,CoffeeTeaPerDay INT
	,AlcoholicDrinksPerDay INT
	,StimulantsUsed NVARCHAR(255)
	,HomeCookedFood BIT
	,CONSTRAINT PK_LifestyleDetails PRIMARY KEY (IDLifestyleDetails)
)

INSERT INTO LifestyleDetails (Vegetarian, CigaretsPerDay, CoffeeTeaPerDay, AlcoholicDrinksPerDay, StimulantsUsed, HomeCookedFood)
VALUES (1,10,2,1,'Eats everything with a teaspoon of LSD',1)
,(0,0,0,12,'Straight edge besides alcohol',0)
,(0,0,0,0,'Clean as a drop',1)
,(0,10,5,3,'Rehabilitated drug addict',1)
,(1,5,2,0,'No record of substance abuse',1)
,(1,12,1,1,'Consumes medical weed',0)
,(1,0,2,0,'Only shrooms',1)
,(0,0,1,1,'No record of substance abuse',0)

CREATE TABLE ComplaintDetails (
	IDComplaintDetails INT IDENTITY
	,Complaint NVARCHAR(MAX)
	,TreatmentHistory NVARCHAR(MAX)
	,TreatedAtHospital NVARCHAR(255)
	,CONSTRAINT PK_ComplaintDetails PRIMARY KEY (IDComplaintDetails)
)

INSERT INTO ComplaintDetails (Complaint, TreatmentHistory, TreatedAtHospital)
VALUES ('Severe Headache','None','Non-applicable')
,('Severe Dehydration','None','Non-applicable')
,('Diabetic condition worsening','Taking insulin pills already','St Lucas hospital')
,('Gunshot wound','None','Non-applicable')
,('Diarrhea problems','Was treated for exotic parasites','Institut Andrija Štampar')
,('Hears voices','None','Non-applicable')
,('Pains in left arm, under the elbow','None','Non-applicable')
,('Sunburnt pretty bad','None','Non-applicable')

CREATE TABLE MedicalDetails (
	IDMedicalDetails INT IDENTITY
	,AllergiesCondition NVARCHAR(MAX)
	,DiabeticCondition NVARCHAR(MAX)
	,HypertensiveCondition NVARCHAR(MAX)
	,CardiacCondition NVARCHAR(MAX)
	,RespiratoryCondition NVARCHAR(MAX)
	,DigestiveCondition NVARCHAR(MAX)
	,MuscularCondition NVARCHAR(MAX)
	,NeurologicalCondition NVARCHAR(MAX)
	,CONSTRAINT PK_MedicalDetails PRIMARY KEY (IDMedicalDetails)
)

INSERT INTO MedicalDetails (AllergiesCondition, DiabeticCondition, HypertensiveCondition, CardiacCondition, RespiratoryCondition, DigestiveCondition, MuscularCondition, NeurologicalCondition)
VALUES ('No known allergies','Not diabetic','Low blood pressure','Regular','Problems with right lung','Regular','Regular','Marginally crazy')
,('No known allergies','Not diabetic','Low blood pressure','Regular','Problems with left lung','Regular','Regular','Depression')  
,('Allergic to dog hair','Not diabetic','Low blood pressure','Regular','Problems with left lung','Regular','Regular','Marginally crazy')
,('No allergies','Diabetes type 3','Slithly elevated blood ressure','Regular','Regular','Regular','Regular','Regular')
,('Allergic to strawberries','Diabetes type 1','Slithly elevated blood ressure','Regular','Regular','Regular','Regular','Regular')
,('Allergic to gluten','Not diabetic','Regular','Regular','Regular','Regular','Regular','Hypohondric')
,('No allergies','Not diabetic','Regular','Regular','Regular','Regular','Regular','Regular')
,('Allergic to waking up early','Not diabetic','Slithly elevated blood ressure','Regular','Regular','Regular','Regular','Heavy PTSD')

CREATE TABLE Patient (
	IDPatient INT IDENTITY NOT NULL
	,BasicDetailsID INT NOT NULL UNIQUE
	,OPID NVARCHAR(11) UNIQUE
	,FullRegistrationDate DATE
	,NextOfKinID INT NOT NULL
	,NextOfKinRelationship NVARCHAR(25) NOT NULL
	,PersonalDetailsID INT UNIQUE
	,LifestyleDetailsID INT UNIQUE
	,ComplaintDetailsID INT UNIQUE
	,MedicalDetailsID INT UNIQUE
	,CONSTRAINT PK_Patient PRIMARY KEY (IDPatient)
	,CONSTRAINT FK_PatientBasicDetails FOREIGN KEY (BasicDetailsID) REFERENCES BasicDetails(IDBasicDetails)
	,CONSTRAINT FK_PatientNextOfKin FOREIGN KEY (NextOfKinID) REFERENCES BasicDetails(IDBasicDetails)
	,CONSTRAINT FK_PatientPersonalDetails FOREIGN KEY (PersonalDetailsID) REFERENCES PersonalDetails(IDPersonalDetails)
	,CONSTRAINT FK_PatientLifestyleDetails FOREIGN KEY (LifestyleDetailsID) REFERENCES LifestyleDetails(IDLifestyleDetails)
	,CONSTRAINT FK_PatientComplaintDetails FOREIGN KEY (ComplaintDetailsID) REFERENCES ComplaintDetails(IDComplaintDetails)
	,CONSTRAINT FK_PatientMedicalDetails FOREIGN KEY (MedicalDetailsID) REFERENCES MedicalDetails(IDMedicalDetails)
)

SELECT * FROM Patient

INSERT INTO Patient (BasicDetailsID, OPID, FullRegistrationDate, NextOfKinID, NextOfKinRelationship, PersonalDetailsID, ComplaintDetailsID, LifestyleDetailsID, MedicalDetailsID)
VALUES (7,'87188223259','2017-05-05',15,'Mother',1,1,1,1)
,(8,'48019226761','2016-04-04',16,'Father',2,2,2,2)
,(9,'93550881931','2018-06-21',17,'Sister',3,3,3,3)
,(10,'05880656338','2017-06-18',18,'Brother',4,4,4,4)
,(11,'40035183923','2017-05-05',19,'Sister',5,5,5,5)
,(12,'19855476155','2017-05-05',20,'Uncle',6,6,6,6)
,(13,'17020343481','2017-05-05',21,'Aunt',7,7,7,7)
,(14,'70977075197','2017-05-05',22,'Sister',8,8,8,8)

SELECT * FROM BasicDetails

INSERT INTO BasicDetails (FirstName, MiddleName, LastName, FullStreet, PINcode, CityID, Telephone, MobilePhone, Email)
VALUES ('Jane',NULL,'Mother','Some street 22','24341',1,'(406) 456-1072','(0964) 76876783','mom@nulla.org')
,('John',NULL,'Dad','Thirteenth Av 654','6179 YY',2,'(753) 708-9945','(039029) 920817','dad@congue.org')
,('Some','Random','Sister','Nonummy Street','33981',3,'(423) 304-8479','(00597) 1746904','sis@ornarefacilisiseget.co.uk')
,('Some','Random','Brother','Posuere St. 1071','17016',4,'(863) 240-7778','(024) 52273014','bro@NuncmaurisMorbi.net')
,('Juana','Jose','Sister','Rhoncus Rd. 109','96831-420',9,'(139) 506-3578','(0196) 03899475','sis@nibh.net')
,('Some','FaraAway','Uncle','Nunc Street 43','319174',10,'(572) 128-4970','(063) 71935907','uncle@dapibus.co.uk')
,('Favorite',NULL,'Aunt','Proin Street 67','74095',11,'(496) 359-1628','(0719) 67368144','aunt@conubianostra.co.uk')
,('Brother','From Another','Mother','Lorem Avenue 686','13640',12,'(198) 937-2207','(036586) 655851','bro@libero.co.uk')

CREATE TABLE HospitalServiceCategory (
	IDHospitalServiceCategory INT IDENTITY
	,Name NVARCHAR(50)
	,CONSTRAINT PK_HospitalServiceCategory PRIMARY KEY (IDHospitalServiceCategory)
)

INSERT INTO HospitalServiceCategory (Name)
VALUES ('Medicine')
,('Medical_Consultation')
,('Laboratory_Test')

CREATE TABLE HospitalService (
	IDHospitalService INT IDENTITY
	,Name NVARCHAR(50) NOT NULL
	,Description NVARCHAR(255) NULL
	,BasicPrice MONEY NOT NULL
	,CategoryID INT NOT NULL
	,CONSTRAINT PK_HospitalService PRIMARY KEY (IDHospitalService)
	,CONSTRAINT FK_HospitalServiceHospitalServiceCategory FOREIGN KEY (CategoryID) REFERENCES HospitalServiceCategory(IDHospitalServiceCategory)
)

INSERT INTO HospitalService (Name, Description, BasicPrice, CategoryID)
VALUES ('Neofen','40 pills of 50mg strong stuff for headaches',29.99,1)
,('Mucinex','150 ml cough syrup',39.99,1)
,('Gaviscon','24 chewable tablets for gastrointestinal issues',50,1)
,('Voltaren Emulgel','200 ml muscle relief gel',34.77,1)
,('Prinivil','20 pills with lisoprinil',29.99,1)
,('Kafetin','20 addictive pills',20,1)
,('Basic Consultation','Medical consultation with a general phisician, no examination performed',100,2)
,('Follow-up Consultation','Brief follow up consultation with test results',80,2)
,('Examination Consultation','More complex medical consultation with basic tests performed',150,2)
,('Sugar-Level test','Testing sugar levels in blood',30,3)
,('Blood test','Basic blood test with standard indicators',50,3)
,('Thiroid Puncture','Detailed analysis of thiroid hormones',150,3)
,('Urinal test','Basic urinal test',50,3)

CREATE TABLE DoctorSpecialization (
	IDDoctorSpecialization INT IDENTITY
	,Name NVARCHAR(100) NOT NULL
	,CONSTRAINT PK_DoctorSpecialization PRIMARY KEY (IDDoctorSpecialization)
)

INSERT INTO DoctorSpecialization (Name)
VALUES ('General_Physician')
,('Anesthesiologist')
,('Cardiologist')
,('Dermatologist')
,('Gastroenterologist')

CREATE TABLE Doctor (
	IDDoctor INT IDENTITY
	,BasicDetailsID INT UNIQUE
	,Title NVARCHAR(50) NOT NULL
	,SpecializationID INT NOT NULL
	,Active BIT NOT NULL
	,CONSTRAINT PK_Doctor PRIMARY KEY (IDDoctor)
	,CONSTRAINT FK_DoctorBasicDetails FOREIGN KEY (BasicDetailsID) REFERENCES BasicDetails(IDBasicDetails)
	,CONSTRAINT FK_DoctorSpecialization FOREIGN KEY (SpecializationID) REFERENCES DoctorSpecialization(IDDoctorSpecialization)
)

INSERT INTO Doctor (BasicDetailsID, Title, SpecializationID, Active)
VALUES (1,'Dr.',1,1)
,(2,'Dr.',1,1)
,(3,'Dr.',1,1)
,(4,'Dr.',1,1)
,(5,'Dr.',1,1)
,(6,'Dr.',1,1)

CREATE TABLE Appointment (
	IDAppointment INT IDENTITY
	,[Date] DATE NOT NULL
	,PatientID INT NOT NULL
	,DoctorID INT NOT NULL
	,Diagnosis NVARCHAR(MAX)
	,CONSTRAINT PK_Appointment PRIMARY KEY (IDAppointment)
	,CONSTRAINT FK_PatientAppointment FOREIGN KEY (PatientID) REFERENCES Patient(IDPatient)
	,CONSTRAINT FK_DoctorAppointment FOREIGN KEY (DoctorID) REFERENCES Doctor(IDDoctor)
)

INSERT INTO Appointment ([Date], PatientID, DoctorID, Diagnosis)
VALUES ('2018-01-01',1,1,'The patient should work less and have some pills')
,('2018-06-12',2,1,'Relax')
,('2018-10-01',3,2,'Wash behind the ears')
,('2018-02-22',4,2,'Eat more fruit')
,('2018-03-03',5,3,'Go have an operation')
,('2018-01-15',6,4,'The patient should visit a nut house')
,('2018-01-23',7,5,'Antibiotics')
,('2018-04-01',8,6,'Should stop bothering doctors for no reason')

CREATE TABLE AppointmentService (
	IDAppointmentService INT IDENTITY
	,HospitalServiceID INT
	,AppointmentID INT
	,CONSTRAINT PK_AppointmentService PRIMARY KEY (IDAppointmentService)
	,CONSTRAINT FK_Service FOREIGN KEY (HospitalServiceID) REFERENCES HospitalService(IDHospitalService)
	,CONSTRAINT FK_Appointment FOREIGN KEY (AppointmentID) REFERENCES Appointment(IDAppointment)
)

INSERT INTO AppointmentService (HospitalServiceID, AppointmentID)
VALUES (7,1)
,(7,2),(1,2),(6,2)
,(7,3)
,(7,4)
,(7,5),(2,5)
,(7,6)
,(7,7),(5,7)
,(7,8)

CREATE TABLE Receipt (
	IDReceipt INT IDENTITY
	,IssueDate DATETIME NOT NULL DEFAULT (GETDATE()) 
	,AppointmentID INT NOT NULL
	,CreditCard BIT
	,TotalPrice MONEY NOT NULL
	,CONSTRAINT PK_Receipt PRIMARY KEY (IDReceipt)
	,CONSTRAINT FK_ReceiptAppointment FOREIGN KEY (AppointmentID) REFERENCES Appointment(IDAppointment)
)

CREATE TABLE EmergencyRegistration (
	IDEmergencyRegistration INT IDENTITY
	,RegistryDate DATE NOT NULL
	,PatientID INT NOT NULL UNIQUE
	,PatientSex BIT NOT NULL
	,BriefComplaint NVARCHAR(255) NOT NULL
	,PatientFirstName NVARCHAR(50) NOT NULL
	,PatientMiddleName NVARCHAR(50) NULL
	,PatientLastName NVARCHAR(50) NOT NULL
	,RelativeFirstName NVARCHAR(50) NOT NULL
	,RelativeMiddleName NVARCHAR(50) NULL
	,RelativeLastName NVARCHAR(50) NOT NULL
	,RelationshipOfRelative NVARCHAR(50) NOT NULL
	,PatientContact NVARCHAR(25) NOT NULL
	,RelativeContact NVARCHAR(25) NOT NULL
	,CONSTRAINT PK_EmergencyRegistration PRIMARY KEY (IDEmergencyRegistration)
	,CONSTRAINT FK_EmergencyRegistrationPatient FOREIGN KEY (PatientID) REFERENCES Patient(IDPatient)
)