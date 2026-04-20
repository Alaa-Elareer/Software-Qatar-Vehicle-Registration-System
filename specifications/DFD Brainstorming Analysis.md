### ** Internal Processes**

1. **Vehicle Registration & Renewal **
    - Registers new vehicles and renews existing registrations.
    - **Inputs**: VIN, insurance policy, fitness certificate (if required), fine status.
    - **Outputs**: Registration stickers, invoices, renewal confirmation.
2. **Ownership Transfer(Registered Vehicle) *
    
    - Transfers ownership of registered vehicles between two owners.
    - **Inputs**:
    - VIN, QID (Current Owner), New Owner Details, Insurance Policy, Fine Check.
    - **qPay System**: Payment for any unpaid invoices or fines.
- **Data Stores**:
    - **Vehicles Database**: Update registration details.
    - **Owners Database**: Record the new owner and update the previous owner.
    - 
3. **Ownership Transfer(Unregistered Vehicle)**

- **Inputs**:
    - VIN, Vehicle Details (Make, Model, Year), Current Owner Details, New Owner QID.
- **External Interactions**:
    - **Manufacturer System**: Validate VIN and specifications.
    - **Qatar Trade Service**: Confirm import details if applicable.
- **Data Stores**:
    - **Vehicles Database**: Create new registration entry.
    - **Owners Database**: Record ownership details.

    
    
4. **Accident Reporting **
    
    - Reports accidents between vehicles and sends reports to insurance companies.
    - **Inputs**: Accident details (VIN, description, date).
    - **Outputs**: Accident reports, acknowledgment to involved parties.
5. **Payment Processing **
    
    - Handles payments for fines and invoices through the qPay system.
    - **Inputs**: Payment requests (with credit card details).
    - **Outputs**: Payment receipts, updated invoice status.
6. **Fine & Offense Management **
    
    - Manages offenses, fines, and vehicle confiscation orders.
    - **Inputs**: Offense queries, VIN, fine records.
    - **Outputs**: Offense reports, confiscation orders.

### **External Entities (Actors)**

1. **Vehicle Owner**
2. **Insurance Company**
3. **Authorized Workshop**
4. **Traffic Police (with Departments)**
5. **qPay System**
6. **Vehicle Manufacturer System**
7. **Qatar Trade Service**

### **Data Stores in iQVR System**

1. **Vehicles Database**: 
	Stores VIN, make, model, year, and registration details.
2. **Owners Database**: 
	Stores current and previous owner details (QID, name, address).
3. **Insurance Policies Database**:
	Stores policy number,  VIN, validity, and company contact.
4. **Fitness Certificates Database**: 
	Stores certificate number, VIN, and issuing workshop.
5. **Accident Records Database**: 
	Stores date, time, vehicle details, and insurance acknowledgments.
6. **Fines and Invoices Database**: 
	 Stores fines, payment status, and invoices for offenses and renewals.
7. **Acknowledgment Logs**:
	stores responses from external systems (insurance, qPay).
