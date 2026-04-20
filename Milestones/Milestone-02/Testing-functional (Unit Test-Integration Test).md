##  **Unit Testing Report for Accident Report Class**:

**Objective:**  
The primary goal of these unit tests is to ensure that the core functionalities of the `AccidentReport` class are working as expected. These functionalities include creating a report, sending it to an insurance company, and storing the report in a file. By testing these methods, we ensure that the `AccidentReport` class behaves correctly in typical usage scenarios.

### **Test 1:  testFileReport()

This test verifies that the `fileReport()` method in the `AccidentReport` class properly initializes the report with the correct data. We are testing whether the report object is created with the expected attributes, such as the report ID, location, and associated vehicles.

- We begin by creating two `Vehicle` objects representing the vehicles involved in the accident:
    - `vehicleAtFault`: This is the vehicle deemed responsible for the accident.
    - `victimVehicle`: This is the vehicle that was damaged or affected by the accident.
- Both vehicles are given basic information, including a VIN, Model, Year, and Owner details.
- An instance of the `AccidentReport` class is then created, passing the accident location ("Doha") along with the two vehicle objects.

- **Assertions:**
- The `reportID` is not null, confirming a unique report ID is generated.
- The `location` matches the input ("Doha").
- The vehicles are correctly assigned to the report.
**Outcome:**  
	The test passed, ensuring accurate initialization of the report.

### **Test 2:  testSendToInsurance()

**Purpose:**  
The `sendToInsurance()` method is responsible for simulating the process of sending the accident report to an insurance company. This test checks whether the acknowledgment string is correctly set in the `AccidentReport` object.

- We create two `Vehicle` objects (`vehicleAtFault` and `victimVehicle`) with basic details, similar to the previous test.
- An instance of the `AccidentReport` class is created, and the accident location ("Doha") along with the two vehicles are provided.

**Assertions:**
- The `insuranceAcknowledgment` contains the phrase "Acknowledged by Insurance Company," verifying acknowledgment is correctly recorded.
**Outcome:**  
The test passed, confirming the report is acknowledged after being sent.

### **Test 3:  testStoreReport()
**Purpose:**  
This test ensures that the `storeReport()` method correctly saves the accident report to a file.

- Two vehicle objects and an `AccidentReport` instance are created as before. The `storeReport()` method is called.

**Assertions:**
- - We check that the file `AccidentReports.txt` exists after the `storeReport()` method is executed. This file is where the accident reports are stored.
- The test assumes that the file will be created or appended to if it already exists, and that the necessary information about the accident will be written correctly.
**Outcome:**  
The test passed, ensuring reports are saved to disk without issues.

![[Pasted image 20241123134907.png]]


## **Integration Testing Report for Accident Report Class**:

**Objective:**  
The integration test aims to validate that the components of the `ManageAccidentFX` and `AccidentReport` system work cohesively to manage accidents, generate reports, and store them correctly.
### **Test Case:  testManageAccidentIntegration()**
**Purpose:**  
To simulate a real-world scenario where an accident occurs, validate the interaction between system components, and confirm that accident reports are successfully filed, processed, and stored. This test ensures seamless communication between classes and verifies file persistence.
**Overview:**  
The test simulates a real-world accident involving two vehicles: a Toyota Corolla owned by Ahmed Doe and a Honda Civic owned by Nasser. It initializes these vehicles and their respective owners, sets the accident location as "Downtown," and generates an accident report using the `AccidentReport` class. Key operations include filing the report, sending it to an insurance company, receiving acknowledgment, and storing the report in a file.

**Validation Processes:**
- **Data Initialization:** Vehicle and owner details are correctly established and passed into the report.
- **Report Creation:** The `AccidentReport` object accurately captures the accident location, date, and vehicle details, including generating a unique report ID.
- **Insurance Communication:** The test verifies the report's successful transmission to the insurance company and receipt of acknowledgment.
- **File Storage:** Persistent storage is confirmed by the existence of the file `AccidentReports.txt`, containing essential report details.

**Assertions:**  
Assertions confirm the system's accuracy by ensuring the report ID is not null, the location matches, and the offending and victim vehicle details are correct. Additionally, the storage file's existence validates successful persistence.

**Outcome:**  
The integration test demonstrates the system’s ability to manage accident scenarios cohesively, with all components interacting seamlessly. Data initialization, external communication, and file storage operated reliably.

![[Pasted image 20241123140324.png]] 
