CREATE DATABASE OutpatientManagement
GO
USE OutpatientManagement
GO

--USE master
--DROP DATABASE OutpatientManagement
--GO


-- KREIRANJE TABLICA
CREATE TABLE Country (
	IDCountry INT IDENTITY
	,Name NVARCHAR(50) NOT NULL
	,CONSTRAINT PK_Country PRIMARY KEY (IDCountry)
)

CREATE TABLE City (
	IDCity INT IDENTITY
	,Name NVARCHAR(50) NOT NULL
	,CountryID INT NOT NULL
	,CONSTRAINT PK_City PRIMARY KEY (IDCity)
	,CONSTRAINT FK_CityCountry FOREIGN KEY (CountryID) REFERENCES Country(IDCountry)
)

CREATE TABLE [Address] (
	IDAddress INT IDENTITY
	,FullStreet NVARCHAR(255) NOT NULL
	,PINcode NVARCHAR(15) NOT NULL
	,CityID INT NOT NULL
	,CONSTRAINT PK_Address PRIMARY KEY (IDAddress)
	,CONSTRAINT FK_AddressCity FOREIGN KEY (CityID) REFERENCES City(IDCity)
)

CREATE TABLE ContactInformation (
	IDContactInformation INT IDENTITY
	,Telephone NVARCHAR(15)
	,MobilePhone NVARCHAR(15)
	,Email NVARCHAR(50)
	,CONSTRAINT PK_ContactInformation PRIMARY KEY (IDContactInformation)
)

CREATE TABLE BasicDetails (
	IDPerson INT IDENTITY
	,FirstName NVARCHAR(50) NOT NULL
	,MiddleName NVARCHAR(50)
	,LastName NVARCHAR(50) NOT NULL
	,Sex BIT
	,DateOfBirth DATE
	,ContactInformationID INT NOT NULL
	,AddressID INT
	,CONSTRAINT PK_PersonBase PRIMARY KEY (IDPerson)
	,CONSTRAINT FK_PersonContactInformation FOREIGN KEY (ContactInformationID) REFERENCES ContactInformation(IDContactInformation)
	,CONSTRAINT FK_PersonAddress FOREIGN KEY (AddressID) REFERENCES [Address](IDAddress)
)

CREATE TABLE PersonalDetails (
	IDPersonalDetails INT IDENTITY
	,MaritalStatus NVARCHAR(50)
	,Occupation NVARCHAR(50)
	,Height FLOAT
	,Weight FLOAT
	,BloodTypeRH NVARCHAR(15)
	,CONSTRAINT PK_PersonalDetails PRIMARY KEY (IDPersonalDetails)
)

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


CREATE TABLE ComplaintDetails (
	IDComplaintDetails INT IDENTITY
	,Complaint NVARCHAR(MAX)
	,TreatmentHistory NVARCHAR(MAX)
	,TreatedAtHospital NVARCHAR(255)
	,CONSTRAINT PK_ComplaintDetails PRIMARY KEY (IDComplaintDetails)
)

CREATE TABLE MedicalDetails (
	IDMedicalDetails INT IDENTITY
	,SurgeriesHistory NVARCHAR(MAX)
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

CREATE TABLE Patient (
	IDPatient INT IDENTITY NOT NULL
	,BasicDetailsID INT NOT NULL
	,OPID NVARCHAR(11)
	,FullRegistrationDate DATE
	,NextOfKinID INT NOT NULL
	,NextOfKinRelationship NVARCHAR(25) NOT NULL
	,PersonalDetailsID INT
	,LifestyleDetailsID INT
	,ComplaintDetailsID INT
	,MedicalDetailsID INT
	,CONSTRAINT PK_Patient PRIMARY KEY (IDPatient)
	,CONSTRAINT FK_PatientBasicDetails FOREIGN KEY (BasicDetailsID) REFERENCES BasicDetails(IDPerson)
	,CONSTRAINT FK_PatientNextOfKin FOREIGN KEY (NextOfKinID) REFERENCES BasicDetails(IDPerson)
	,CONSTRAINT FK_PatientPersonalDetails FOREIGN KEY (PersonalDetailsID) REFERENCES PersonalDetails(IDPersonalDetails)
	,CONSTRAINT FK_PatientLifestyleDetails FOREIGN KEY (LifestyleDetailsID) REFERENCES LifestyleDetails(IDLifestyleDetails)
	,CONSTRAINT FK_PatientComplaintDetails FOREIGN KEY (ComplaintDetailsID) REFERENCES ComplaintDetails(IDComplaintDetails)
	,CONSTRAINT FK_PatientMedicalDetails FOREIGN KEY (MedicalDetailsID) REFERENCES MedicalDetails(IDMedicalDetails)
)

CREATE TABLE HospitalServiceCategory (
	IDHospitalServiceCategory INT IDENTITY
	,Name NVARCHAR(50) NOT NULL
	,CONSTRAINT PK_HospitalServiceCategory PRIMARY KEY (IDHospitalServiceCategory)
)

CREATE TABLE HospitalService (
	IDHospitalService INT IDENTITY
	,Name NVARCHAR(50) NOT NULL
	,Description NVARCHAR(255) NULL
	,BasicPrice MONEY NOT NULL
	,CategoryID INT NOT NULL
	,CONSTRAINT PK_HospitalService PRIMARY KEY (IDHospitalService)
	,CONSTRAINT FK_HospitalServiceCategory FOREIGN KEY (CategoryID) REFERENCES HospitalServiceCategory(IDHospitalServiceCategory)
)

CREATE TABLE Doctor (
	IDDoctor INT IDENTITY
	,BasicDetailsID INT
	,Title NVARCHAR(50) NOT NULL
	,Active BIT NOT NULL
	,CONSTRAINT PK_Doctor PRIMARY KEY (IDDoctor)
	,CONSTRAINT FK_DoctorBasicDetails FOREIGN KEY (BasicDetailsID) REFERENCES BasicDetails(IDPerson)
)


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

CREATE TABLE AppointmentService (
	IDAppointmentService INT IDENTITY
	,HospitalServiceID INT
	,AppointmentID INT
	,CONSTRAINT PK_AppointmentService PRIMARY KEY (IDAppointmentService)
	,CONSTRAINT FK_Service FOREIGN KEY (HospitalServiceID) REFERENCES HospitalService(IDHospitalService)
	,CONSTRAINT FK_Appointment FOREIGN KEY (AppointmentID) REFERENCES Appointment(IDAppointment)
)

CREATE TABLE Receipt(
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
	,PatientID INT NOT NULL
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


-- NEKA INSERTANJA - grdo, neuredno, treba sredit

INSERT INTO Country (Name)
VALUES ('Canada')
--,('Norway')
--,('Croatia')
--,('El Salvador')
--,('Latvia')
,('Mexico')

INSERT INTO City (Name, CountryID)
VALUES ('Winnipeg',1)
,('Toronto',1)
,('London',1)
,('Ottawa',1)
,('Kingston',1)
,('Kitchener',1)
,('Vancouver',1)
,('Victoria',1)
,('Tofino',1)
,('Golden',1)
,('Edmonton',1)
,('Winnipeg',1)
--,('Lillehammer',6)
--,('Vagamo',6)
--,('Lom',6)
--,('Fagernes',6)
--,('Beitostolen',6)
--,('Otta',6)
,('Tulum',2)
,('Merida',2)
,('Chichen Itza',2)
,('Comitan',2)
,('San Cristobal de las Casas',2)
,('Las Margaritas',2)

INSERT INTO Address (FullStreet, PINcode, CityID)
VALUES ('Some street 22','24341',1)
,('Thirteenth Av 654','6179 YY',2)
,('Nonummy Street','33981',3)
,('Posuere St. 1071','17016',4)
,('Rhoncus Rd. 109','96831-420',14)
,('Nunc Street 43','319174',15)
,('Proin Street 67','74095',16)
,('Lorem Avenue 686','13640',17)
--,('Ap #119-3181 In Ave','98731',24)
--,('902-8653 Vehicula. Avenue','866212',19)
--,('Ap #614-3760 Dolor. St.','13541',14)
--,('960-7506 Venenatis St.','6646',16)
--,('7814 Porttitor Rd.','4516',16)
--,('P.O. Box 339, 9608 Nunc Avenue','29077',19)
--,('Ap #309-2439 Faucibus. St.','89-784',4)
--,('866-2367 Ultricies St.','1144',1)
--,('Ap #236-2594 Metus Avenue','9809 MH',23)
--,('5309 Accumsan Road','94-588',7)
--,('P.O. Box 391, 9194 Dictum Road','12756',15)
--,('572-3262 Non, Rd.','3179',4)
--,('Ap #867-7012 Eu Ave','QC8A 3JD',21)
--,('Ap #858-4908 Amet, Road','90906',22)
--,('793-7568 Habitant Ave','65029',21)
--,('Ap #136-537 Ultrices. Ave','96085',23)
--,('Ap #723-422 Ipsum St.','38552',7)
--,('671-1084 Mauris Ave','95-119',22)
--,('722-8951 Feugiat Ave','998281',4)
--,('9129 Vivamus St.','70223-355',24)
--,('3954 Sed St.','60907',23)
--,('Ap #547-300 Gravida St.','25056',14)
--,('6382 Pellentesque, Rd.','70013',19)
--,('Ap #833-2438 Semper St.','22950-202',2)
--,('Ap #917-8732 Velit Ave','2271',16)
--,('5670 Et Avenue','0608',4)
--,('Ap #842-7561 Pellentesque St.','F0V 7OA',18)
--,('Ap #688-8267 Lorem Ave','01788',22)
--,('P.O. Box 197, 2899 Imperdiet St.','77032',6)
--,('1378 Purus. Rd.','48476',20)
--,('P.O. Box 213, 8277 Cras Av.','16794',9)
--,('3500 Cras Ave','84617',13)
--,('833-8859 Nascetur St.','146971',6)
--,('Ap #636-8761 In, Street','54947',12)
--,('2619 Tempor Street','71116',12)
--,('3473 Venenatis St.','33-828',1)
--,('Ap #195-7389 Eget, Rd.','1736 MB',6)
--,('P.O. Box 730, 123 Primis Road','5427 PX',9)
--,('Ap #454-6163 Metus St.','12885',22)
--,('6023 Proin St.','52296',1)
--,('Ap #187-8752 Duis Street','538922',5)
--,('P.O. Box 499, 1027 Non, Rd.','43489',6)

INSERT INTO ContactInformation([Telephone],[MobilePhone],[Email])
VALUES('(406) 456-1072','(0964) 76876783','semper@nulla.org')
,('(753) 708-9945','(039029) 920817','Vivamus.non.lorem@congue.org')
,('(423) 304-8479','(00597) 1746904','ornare@ornarefacilisiseget.co.uk')
,('(651) 354-2692','(0445) 54953593','pharetra.Nam@gravidasagittis.org')
,('(863) 240-7778','(024) 52273014','risus@NuncmaurisMorbi.net')
,('(572) 128-4970','(063) 71935907','ullamcorper@dapibus.co.uk')
,('(139) 506-3578','(0196) 03899475','pede.ac.urna@nibh.net')
,('(496) 359-1628','(0719) 67368144','magna.malesuada.vel@conubianostra.co.uk')
,('(198) 937-2207','(036586) 655851','Duis.risus.odio@libero.co.uk')
--,('(160) 502-2952','(01787) 7626846','magna.a@convallisconvallisdolor.co.uk')
--,('(398) 410-4640','(05472) 1810889','libero.Morbi@milorem.com'),('(628) 661-7602','(015) 55538977','risus@Sedauctorodio.edu'),('(840) 933-2787','(0849) 43278459','enim.Etiam.imperdiet@nuncQuisque.edu'),('(813) 230-4003','(0833) 08777059','Proin.nisl@necquam.com'),('(545) 222-0724','(02669) 1062470','Etiam.laoreet.libero@luctuset.edu'),('(504) 556-1088','(0082) 92392721','ut@nonsapien.org'),('(452) 983-1914','(08456) 6154366','Phasellus.dolor.elit@diam.co.uk'),('(814) 801-4983','(083) 23005070','arcu.Sed.et@eleifendnecmalesuada.org'),('(912) 617-9209','(0982) 65944422','sollicitudin.commodo@anteipsumprimis.edu'),('(480) 962-2376','(068) 44953302','augue@etmalesuada.com')
--,('(150) 986-0760','(09423) 6651097','nec.malesuada@augueeutellus.org'),('(913) 567-4901','(036618) 476427','augue.porttitor.interdum@aliquam.ca'),('(874) 418-9349','(020) 89316028','gravida.sagittis.Duis@maurisaliquam.com'),('(325) 598-0086','(0238) 54648304','et.malesuada@magnaet.co.uk'),('(611) 164-3461','(011) 55792604','quam@aliquet.ca'),('(223) 639-5508','(05551) 1984335','scelerisque.mollis@rutrummagnaCras.ca'),('(181) 173-9136','(00373) 5547228','dictum@sem.org'),('(177) 477-0459','(0279) 40494277','pede.Nunc@estacmattis.edu'),('(457) 113-4424','(069) 52788781','convallis.est.vitae@vitae.com'),('(940) 228-9139','(034) 74652952','a.scelerisque.sed@Curabiturmassa.co.uk')
--,('(205) 794-8618','(049) 41578012','dis@necluctusfelis.ca'),('(492) 359-5513','(031692) 908451','tempus.scelerisque@tinciduntvehicula.net'),('(946) 306-9986','(03871) 5184916','erat@ornareliberoat.edu'),('(540) 754-1998','(0098) 37651770','eu@ultrices.net'),('(531) 103-0130','(07400) 5733582','magna.Praesent@ac.edu'),('(316) 389-7215','(0410) 02503887','lacus@Lorem.net'),('(419) 253-8598','(02922) 7497555','non.bibendum.sed@dictum.edu'),('(958) 866-1521','(038829) 996012','orci@pharetraNamac.net'),('(631) 390-8738','(091) 97051836','Cum.sociis@ornarelectusjusto.edu'),('(346) 929-4625','(0500) 74740124','id.risus.quis@Crasvehiculaaliquet.co.uk')
--,('(454) 527-1227','(033) 15928378','eget.magna@velquamdignissim.edu'),('(757) 154-8358','(034785) 128658','cursus.et.magna@pede.net'),('(518) 105-2872','(057) 64950699','non.justo.Proin@duisemper.co.uk'),('(811) 296-1957','(051) 36015468','in@imperdietnec.ca'),('(496) 426-9371','(0217) 42202972','tempor.est@auctor.net'),('(348) 463-7686','(083) 38584434','purus.sapien@incursus.org'),('(716) 362-9742','(04654) 3386679','feugiat.metus@Vivamus.com'),('(907) 144-7063','(07834) 9754055','rutrum@semutcursus.org'),('(332) 292-1542','(090) 95042736','mauris@Sed.ca'),('(809) 170-8642','(033923) 973790','convallis.ligula@fringillaornareplacerat.co.uk')
--,('(677) 539-4457','(039607) 318596','sociosqu.ad.litora@fermentumrisus.org'),('(891) 314-1675','(067) 39813424','Nulla@Sedauctor.co.uk'),('(558) 677-6141','(054) 22159919','posuere.cubilia@adipiscing.co.uk'),('(495) 305-9483','(036481) 056866','sollicitudin@Vivamus.com'),('(961) 875-0147','(072) 78881307','Donec.tempus@duinecurna.org'),('(233) 959-5710','(00439) 5141786','sit.amet.ante@Vivamussit.net'),('(612) 192-2323','(068) 90828837','fringilla@Duisatlacus.edu'),('(752) 502-9476','(094) 34487389','arcu@magnisdis.com'),('(352) 446-1860','(022) 63277799','nonummy.ipsum.non@ipsum.co.uk'),('(372) 260-7415','(0300) 84165581','sit.amet@feugiatnecdiam.edu')
--,('(512) 666-7035','(0615) 63891681','semper@dictumPhasellus.net'),('(980) 417-9155','(075) 20084038','per@quam.edu'),('(674) 152-2686','(035700) 097028','sed.libero.Proin@liberoest.edu'),('(682) 740-5987','(039056) 183168','Aliquam.nec@dolorDonecfringilla.org'),('(210) 551-3987','(034936) 342015','Nullam.scelerisque.neque@tinciduntnequevitae.edu'),('(985) 347-7117','(028) 42355014','erat.eget@nonmagna.org'),('(920) 868-3933','(01626) 3269973','Duis.volutpat@scelerisque.co.uk'),('(850) 573-7031','(02470) 2037544','Vivamus@fermentumrisus.co.uk'),('(280) 790-4732','(06853) 7044103','felis@semvitae.edu'),('(962) 550-2023','(021) 97773172','cursus.et@amet.net')
--,('(783) 792-8924','(055) 47280843','nulla@sem.org'),('(348) 826-5099','(060) 98553976','egestas@dapibusligula.co.uk'),('(793) 244-1385','(033838) 810765','tristique@sem.ca'),('(703) 996-1839','(0070) 81010445','ipsum.dolor@pedeblanditcongue.co.uk'),('(540) 525-2376','(0666) 09790050','velit.eu@enim.net'),('(562) 272-4947','(036931) 892024','tellus.imperdiet@lectusjusto.net'),('(851) 614-5512','(096) 44869731','turpis.egestas.Aliquam@luctus.net'),('(725) 184-6814','(032842) 650726','dui@Maurismolestiepharetra.co.uk'),('(571) 897-1542','(012) 25387506','enim.nisl@adipiscingfringilla.edu'),('(912) 355-8536','(06594) 5637134','ultrices.Vivamus@aptenttacitisociosqu.org')
--,('(698) 345-9112','(036412) 240280','adipiscing.lobortis.risus@egetnisidictum.net'),('(236) 332-1265','(0051) 17411275','Morbi@utodiovel.edu'),('(164) 518-2795','(010) 42976439','parturient.montes.nascetur@Proin.com'),('(776) 411-2097','(0943) 74266632','felis.Nulla.tempor@tempor.ca'),('(396) 167-8270','(08623) 7132353','posuere@ullamcorper.co.uk'),('(247) 122-4091','(088) 86074015','mauris.id.sapien@a.org'),('(421) 422-9049','(023) 09578878','Nulla.facilisi@temporest.co.uk'),('(752) 983-3707','(09792) 8818400','Vivamus@laoreet.org'),('(306) 191-3865','(037) 50946462','mi.tempor@Maurismolestie.ca'),('(339) 488-1986','(033849) 012091','velit@felisullamcorper.org')
--,('(574) 681-3605','(0841) 59657081','eleifend@ligula.ca'),('(151) 702-7294','(02062) 0989753','dui.lectus.rutrum@venenatislacusEtiam.edu'),('(145) 731-6765','(036155) 773055','Duis@nasceturridiculus.net'),('(726) 225-6727','(033666) 643626','sagittis.lobortis@nislMaecenasmalesuada.co.uk'),('(585) 372-9840','(030503) 369726','imperdiet@Crasegetnisi.com'),('(501) 659-9911','(074) 25179510','dolor.dapibus.gravida@ametrisusDonec.org'),('(100) 499-9170','(064) 89559512','dui@Sedauctor.co.uk'),('(423) 828-1136','(028) 57058661','dignissim.tempor.arcu@Duisac.org'),('(184) 420-2234','(042) 93809419','dignissim.Maecenas@Namnulla.edu'),('(327) 278-5837','(036352) 031555','lectus.pede@dis.net')

INSERT INTO HospitalServiceCategory (Name)
VALUES ('Medicine'),('Medical Consultation'),('Laboratory Test')

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

-- za DOKTORE da znam koji su
INSERT INTO ContactInformation([Telephone],[MobilePhone],[Email])
VALUES ('(111) 539-4457','(010101) 318596','chapman@outpatient.ca')
,('(222) 539-4457','(020202) 318596','palin@outpatient.ca')
,('(333) 539-4457','(030303) 318596','cleese@outpatient.ca')
,('(444) 539-4457','(040404) 318596','gilliam@outpatient.ca')
,('(555) 539-4457','(050505) 318596','idle@outpatient.ca')
,('(666) 539-4457','(060606) 318596','jones@outpatient.ca')

INSERT INTO Address (FullStreet, PINcode, CityID)
VALUES ('101 Doctor Street','24341',1)
,('202 Doctor Street','24341',1)
,('303 Doctor Street','24341',1)
,('404 Doctor Street','24341',1)
,('505 Doctor Street','24341',1)
,('606 Doctor Street','24341',1)

INSERT INTO BasicDetails(FirstName, LastName, Sex, DateOfBirth, ContactInformationID, AddressID)
VALUES ('Graham','Chapman','1','1941-01-08',11,14)
,('John','Cleese','1','1939-10-27',13,13)
,('Eric','Idle','1','1943-03-29',15,12)
,('Michael','Palin','1','1940-11-22',12,11)
,('Terry','Jones','1','1943-05-05',16,10)
,('Terry','Gilliam','1','1942-02-01',14,9)
-- + posebno zgenerirana skripta za pacijente

INSERT INTO BasicDetails (FirstName, MiddleName, LastName, Sex, DateOfBirth, ContactInformationID, AddressID)
VALUES ('Aureliano','Maximilian','Jose',0,'1989-01-01',9,1)
,('Juan',NULL,'Jose',0,'1978-12-06',2,2)
,('Helen','of','Troy',1,'1980-02-02',3,3)
,('Marry',NULL,'Poppins',1,'1999-05-05',4,4)
,('Juan','Jose','Jedanaesti',0,'2010-11-07',5,5)
,('Pipi','Duga','Čarapa',1,'2002-04-30',6,6)
,('Dunja',NULL,'Kotonjata',1,'1981-10-17',7,7)
,('Milica',NULL,'Krmpotić',1,'2012-12-02',8,8)

INSERT INTO PersonalDetails(MaritalStatus, Occupation, Height, Weight, BloodTypeRH)
VALUES ('Married','Carpenter',190,89,'B-')
,('Widowed','Programmer',155,65,'AB+')
,('Single','Pilot',188,50.4,'B+')
,('Civil Partnership','Astronaut',178,124.2,'0-')
--,('Married','English teacher',202,102,'A+')
--,('Single','Road worker',170,100,'AB-')
--,('Married','Prison guard',190,156.5,'A+')
--,('Married','Mason',215,156,'AB-')
--,('Widowed','Electrician',195,205.3,'0+')
--,('Civil Partnership','Project manager',213,198,'0-')
--,('Married','University professor',189,147.5,'AB+')


INSERT INTO LifestyleDetails (Vegetarian, CigaretsPerDay, CoffeeTeaPerDay, AlcoholicDrinksPerDay, StimulantsUsed, HomeCookedFood)
VALUES (1,10,2,1,'Eats everything with a teaspoon of LSD',1)
,(0,0,0,12,'Straight edge besides alcohol',0)
,(0,0,0,0,'Clean as a drop',1)
,(0,10,5,3,'Rehabilitated drug addict',1)
--,(1,5,2,0,'No record of substance abuse',1)
--,(1,12,1,1,'Consumes medical weed',0)
--,(1,0,2,0,'Only shrooms',1)
--,(0,0,1,1,'No record of substance abuse',0)
--,(1,0,0,1,'No record of substance abuse',1)
--,(0,30,1,2,'Regural heavy drug abuse due to work related stress',0)
--,(0,15,2,1,'Occasional puff',1)


INSERT INTO ComplaintDetails (Complaint, TreatmentHistory, TreatedAtHospital)
VALUES ('Severe Headache','None','Non-applicable')
,('Severe Dehydration','None','Non-applicable')
,('Diabetic condition worsening','Taking insulin pills already','St Lucas hospital')
,('Gunshot wound','None','Non-applicable')


INSERT INTO MedicalDetails (SurgeriesHistory, AllergiesCondition, DiabeticCondition, HypertensiveCondition, CardiacCondition, RespiratoryCondition, DigestiveCondition, MuscularCondition, NeurologicalCondition)
VALUES ('No major surgeries','No known allergies','Not diabetic','Low blood pressure','Regular','Problems with right lung','Regular','Regular','Marginally crazy')
,('Has a fake bladder','No known allergies','Not diabetic','Low blood pressure','Regular','Problems with left lung','Regular','Regular','Depression')  
,('Tonsils removed at age of 7','Allergic to dog hair','Not diabetic','Low blood pressure','Regular','Problems with left lung','Regular','Regular','Marginally crazy')
,('No major surgeries','No allergies','Diabetes type 3','Slithly elevated blood ressure','Regular','Regular','Regular','Regular','Regular')
--,('Had a heart transplant','Allergic to strawberries','Diabetes type 1','Slithly elevated blood ressure','Regular','Regular','Regular','Regular','Regular','Regular')
--,('No major surgeries','Allergic to gluten','Not diabetic','Regular','Regular','Regular','Regular','Regular','Regular','Hypohondric')
--,('No major surgeries','No allergies','Not diabetic','Regular','Regular','Regular','Regular','Regular','Regular','Regular')
--,('Prostetic arm and leg','Allergic to waking up early','Not diabetic','Slithly elevated blood ressure','Regular','Regular','Regular','Regular','Regular','Heavy PTSD')
--,('No major surgeries','Allergic to pollen','Not diabetic','High blood pressure','Regular','Regular','Regular','Regular','Regular','Depression')
--,('No major surgeries','No allergies','Diabetes type 2','High blood pressure','Regular','Regular','Regular','Regular','Parkinsons','Relaxed')
--,('No major surgeries','Allergic to cat fur','Diabetes type 2','High blood pressure','Regular','Regular','Regular','Regular','Regular','Regular')


INSERT INTO Patient (BasicDetailsID, OPID, FullRegistrationDate, NextOfKinID, NextOfKinRelationship, PersonalDetailsID, LifestyleDetailsID, MedicalDetailsID)
VALUES (10,'87188223259','2017-05-05',14,'Brother',1,1,1)
,(11,'48019226761','2016-04-04',15,'Sister',2,2,2)
,(12,'93550881931','2018-06-21',16,'Sister',3,3,3)
,(13,'05880656338','2017-06-18',17,'Cousin',4,4,4)
--,(71,'40035183923','2017-05-05',72,'Uncle',5,5,5)
--,(76,'19855476155','2017-05-05',80,'Father',6,6,6)
--,(81,'17020343481','2017-05-05',83,'Mother',7,7,7)
--,(84,'70977075197','2017-05-05',87,'Father',8,8,8)
--,(91,'62264821615','2017-05-05',96,'Sister',9,9,9)
--,(98,'52342105396','2017-05-05',99,'Uncle',10,10,10)

INSERT INTO Doctor (BasicDetailsID, Title, Active)
VALUES (3,'Dr.',1)
,(4,'Dr.',1)
,(5,'Dr.',1)
,(6,'Dr.',1)
,(7,'Dr.',1)
,(8,'Dr.',1)


INSERT INTO Appointment ([Date], PatientID, DoctorID, Diagnosis)
VALUES ('2018-01-01',1,1,'The patient should work less and have some pills')
,('2018-06-12',2,1,'Relax')
,('2018-10-01',3,2,'Wash behind the ears')
,('2018-02-22',4,2,'Eat more fruit')
--,('2018-03-03',5,3,'Go have an operation')
--,('2018-01-15',6,4,'The patient should visit a nut house')
--,('2018-01-23',7,5,'Antibiotics')
--,('2018-04-01',8,6,'Should stop bothering doctors for no reason')
--,('2018-05-04',9,3,'Should drink more water in life')
--,('2018-05-25',10,4,'Try magnesium pills, if no effect should come for additional test')

INSERT INTO AppointmentService (HospitalServiceID, AppointmentID)
VALUES (1,2),(6,2),(7,2),(7,3),(7,4),(7,5),(2,5)--,(7,6),(7,7),(5,7),(7,8),(9,9),(7,10)