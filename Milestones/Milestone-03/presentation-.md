# Qatar Vehicle System - Project Presentation

**Team Members:**
- **Alaa Elareer**: ae2203638@student.qu.edu.qa  
- **Sara Alsada**: sa2203519@student.qu.edu.qa  
- **Aisha Allenjawi**: aa2001665@qu.edu.qa  

---

### Qatar Vehicle Registration System: Overview and Progress

The Qatar Vehicle Registration System aims to streamline vehicle-related processes such as registration, accident reporting, ownership transfers, and payment of fines and invoices. This system is designed to benefit both car owners and regulatory authorities, offering an automated, efficient, and secure method to handle all these tasks.

- **Goal**: To provide an efficient platform for vehicle owners to manage their vehicles and associated services.  
- **Technology Stack**: Java, JavaFX, Scene Builder, Visual Paradigm, IntelliJ IDEA, JUnit, Pandoc for documentation and presentation.

---

### Project Summary

The Qatar Vehicle Registration System includes several key features:

- **Accident Reporting**: Users can create accident reports, send them to insurance companies, and store the reports in a database.  
- **Ownership Transfer**: The system validates the Vehicle Identification Number (VIN), Qatari ID (QID), and processes payments.  
- **Pay Fines and Invoices**: Users can pay fines and invoices securely through integration with the qPay system.  

The project follows a **modular design** approach, with separate classes and components for each feature. We are utilizing **JavaFX** for the GUI, with **JUnit** used for unit testing and integration testing.

---

### Milestone 1 - Software Requirements Analysis

In **Milestone 1**, the focus was on analyzing and defining the system’s requirements. The following key diagrams and use case specifications were created:

- **Data Flow Diagrams (DFD)**: Level 0 and Level 1 diagrams illustrating data movement between processes.  
- **Use Case Diagram**: Depicting key use cases like "Renew Registration," "Ownership Transfer," and "Pay Fines."  
- **Class Diagram**: A detailed design showing system classes, their attributes, methods, and relationships.  

**Challenges Faced:**
- Defining system boundaries and ensuring clear distinctions between different components (e.g., vehicle registration vs. accident reporting).  
- Identifying and validating system actors and interactions.

---

## Use Case Specifications

### Key Use Cases

1. **Renew a Registered Vehicle**: Renew a vehicle in the system.  
2. **Transfer Registered Vehicle**: Transfer registered vehicle ownership between two owners.  
3. **Pay Fines and Invoices**: Manage payment of vehicle-related fines and invoices.  
4. **Transfer Unregistered Vehicle**: Transfer unregistered vehicle ownership between two owners.  

- Each use case was analyzed and documented, defining:  
  - Actors, preconditions, postconditions.  
  - Normal and alternative flows.

---

### Milestone 2 - Design and Implementation

**Milestone 2** focused on the design and implementation of the system's core features. This included:

- **Sequence Diagrams** for key use cases like "Transfer Registered Vehicle" and "Pay Fines and Invoices."  
- **Class Diagram**: Refining the design based on implementation details.  
- **Constraints and Non-Functional Requirements (NFRs)**: Considered performance, scalability, and security in system design.

**Implementation of Use Cases:**
- **Transfer Ownership**  
- **Pay Fines and Invoices**

The milestone also included **unit testing**, **integration testing**, and testing **quality requirements**.

---

### User Interface Design and Implementation 
The **user interface (UI)** was developed using **JavaFX**, prioritizing ease of use and accessibility. Key features include:

- **Intuitive Navigation**: Smooth processes with minimal learning curve.  
- **Form Validation**: Real-time input validation improves accuracy.  
- **User Feedback**: Success/error messages provide clear feedback.  
- **Responsive Layout**: Adapts to different screen sizes.  

**Use Cases Implemented:**
- **Transfer Ownership**: Form for VIN and QID input with validation.  
- **Pay Fines and Invoices**: Secure payment interface integrated with qPay.  

**Technologies Used:**
- **JavaFX**: For building the UI.  
- **FXML & SceneBuilder**: For easy layout design.

---

### Unit Testing for Core Functionalities

Unit testing was performed to ensure the core functionalities of the system were working as expected. Key tests included:

1. **testFileReport()**:  
   - Verifies the `fileReport()` method initializes reports with correct data.  
   - Assertions: Non-null `reportID`, correct `location`, proper vehicle assignments.  

2. **testSendToInsurance()**:  
   - Verifies `sendToInsurance()` correctly sets acknowledgment.  
   - Assertions: Acknowledgment includes "Acknowledged by Insurance Company."  

3. **testStoreReport()**:  
   - Verifies `storeReport()` saves reports to a file.  
   - Assertions: Existence of `AccidentReports.txt` after saving.

**Test Results:**  
- All unit tests passed, ensuring that core functionalities such as creating and storing reports, and communicating with insurance companies, work as expected.
---

### Integration Testing for Accident Reporting

Integration testing ensured seamless interaction between components. Key test:

**Test Case: testManageAccidentIntegration()**  
- **Objective:** Simulate a real-world accident scenario and ensure proper interaction between components.  
- **Process:**  
  - Vehicles initialized.  
  - Accident report created, acknowledged, and stored.  
- **Assertions:**  
  - Report ID is generated.  
  - Accident location and vehicle details captured.  
  - Report acknowledged and stored.

**Test Results:**  
- Passed, confirming cohesive component interaction.

---

### Non-Functional Requirement Testing

1. **Availability Test**:
    - **Objective:** Measure the system’s efficiency under load.
    - **Method:** Simulated heavy calculations (e.g., summing numbers up to 1,000,000) to assess performance.
    - **Result:** The system performed the task without delays, confirming availability under normal usage.
2. **Usability Test**:
    - **Objective:** Ensure the system is easy to use for the end user.
    - **Method:** Created an interactive interface where users select options like "Register Vehicle" or "Pay Fine." Task completion times were measured.
    - **Result:** The system responded quickly, confirming that it is intuitive and user-friendly.

---

### Challenges Encountered So Far

1. **Integration Complexity**: Managing interactions between components.  
2. **Performance Optimization**: Handling large data efficiently.  
3. **UI/UX Design**: Balancing functionality and usability.

Solutions were found through iterative development and testing.

---

### Lessons Learned During the Project

1. **System Design**: Early detailed diagrams simplified development.  
2. **Decomposing Tasks**: Breaking down features eased implementation.  
3. **User Experience**: Feedback improved the interface design.

---
 
### Future Work and Next Steps  

1. **Design Patterns Implementation**: Apply at least two design patterns to improve architecture.  
2. **Project Management Deliverables**: Create a Gantt chart and dependency graph to track progress.  
3. **Reflection and Team Evaluation**: Prepare individual reflection reports on experiences, challenges, and lessons learned.

---

### Conclusion  

Significant progress has been made on the Qatar Vehicle Registration System. Core features such as accident reporting, ownership transfer, and payment processing have been successfully implemented and tested.  

This project has provided valuable insights into system design, integration, and user-centered development. We look forward to finalizing the remaining tasks and delivering a robust, user-friendly solution.

---

# We Appreciate your Attention!
Any Questions?