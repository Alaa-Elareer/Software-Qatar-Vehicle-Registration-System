**01-Transfer Registered Vehicle**

- Name: Transfer Registered Vehicle
- Description: This use case allows the current owner to transfer ownership of a registered vehicle to a new owner. The system validates the vehicle registration details, checks for unpaid bills, confirms the insurance policy, generates an invoice for the transfer fee.
- Primary actor:
	- Current Owner
	- New Owner
	
- Goal: To transfer the ownership of a registered vehicle from the **current owner** to a **new owner**, ensuring the correct assignment of the vehicle, proper payment of the transfer fee, and issuance of a new registration sticker.
- Triggers: The current owner initiates the transfer by selecting **"Transfer Registered Vehicle"** option and providing the **VIN and their QID**.
- Preconditions:
	- The **current owner** must have the vehicle registered in their name.
	
- Postconditions:
	- The vehicle ownership is transferred to the **new owner**.
	- - An **invoice for the transfer fee** is generated.
	- A **new registration sticker** is issued to the new owner.
	- The insurance policy remains the same unless updated by the new owner.
- Main scenario:

| Actor Action                                                                | System Response                                                                                 |
| --------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| 1. Current owner selects **"Transfer Registered Vehicle"**.                 | 2. System prompts for **VIN and QID of the current owner**                                      |
| 3. Current owner enters **VIN and QID**.                                    | 4. System retrieves the ** vehicle registration details**.                                      |
|                                                                             | 5. If the VIN and QID match, the system continues. 5a                                           |
|                                                                             | 6. System checks for **unpaid invoices or fines**. 6a                                           |
|                                                                             | 7.If no dues are found, the system **requests the new owner's details**.                        |
| 8. Current owner provides **name, QID, and mobile number** of the new owner | 9. System assigns the **vehicle to the new owner**                                              |
|                                                                             | 10. System marks the **current owner as the previous owner**.                                   |
|                                                                             | 11.The system confirms the **insurance policy remains unchanged**.                              |
| 12.New owner can update the insurance policy later if needed.               | 13. System generates a **new registration sticker** for the vehicle and completes the transfer. |
|                                                                             | 14. System creates an **invoice for the transfer fee** and marks it as payable.                 |
-  **Alternative Flows**:
	- 5a: Incorrect VIN or QID Provided
		- System terminates the session with the message **"Incorrect Information**"
	- 6a: Unpaid Invoices or Fines Detected
		- System terminates the session with the message **"Pay the bills first."**
	
- Special requirements:
	- Sensitive personal data (like QID) must be securely handled according to system policies. 


**02-Pay Fines and Invoices.**

- Name: Pay Fines and Invoices.
- Description: 
	This use case allows a **vehicle owner** to view and pay any outstanding fines or invoices linked to their vehicle. The qPay system, which communicates with the bank to authenticate a credit card and approve the transaction, is used to process the payment. The system modifications the owner's account creates a receipt, and labels the invoices as paid as soon as the payment is successful.
- Primary actor:
	- Vehicle Owner
	- qPay System
- Goal: 
	To allow vehicle owners to **pay outstanding fines or invoices** securely through the **qPay system**.
- Triggers:  The vehicle owner initiates the payment process by selecting the option to pay fines or invoices.
- Preconditions:
	- The details of the car registration must exist in the system.
	- There must be a minimum of one outstanding bill or fine on the vehicle.
	
- Postconditions:
	- The chosen bills and penalties been marked as paid.
	- The owner receives and views a payment receipt that has been generated.
	- The vehicle's unpaid invoice list is updated via the system. 
- Main scenario:

| Actor Action                                             | System Response                                                                                               |
| -------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- |
| 1. Vehicle owner selects **"Pay Fines/Invoices"**.       | 2. System prompts for **VIN** and **credit card details** (card number, holder name, expiry).                 |
| 3. Vehicle owner enters the **VIN and card details**.    | 4. System retrieves the **vehicle registration details**. 4a                                                  |
|                                                          | 5. If the details are correct, the system displays a **list of unpaid fines/invoices**.                       |
| 6. Vehicle owner selects the **invoices/fines to pay**.  | 7. System computes the **total amount** to be paid                                                            |
|                                                          | 8. System forwards the **card details and amount** to the **qPay system**.                                    |
| 9. qPay system checks the card’s validity with the bank. |                                                                                                               |
| 10. qPay system **authorizes the payment**. 10a          | 11. System **records the payment status**. 11a                                                                |
|                                                          | 12. Upon completion, the system generates a payment receipt and designates the fines and invoices as settled. |
|                                                          | 13. System **updates the unpaid invoices list** and displays the receipt to the owner.                        |
-  **Alternative Flows**:
	- 4a: If the VIN does not match any vehicle in the system:
		- System Displays **"Invalid VIN"** and prompts the owner to re-enter the VIN.
	- 10a: If the **qPay system** detects an invalid card:
		- **qPay system** Displays an **error message** and prompts the owner to re-enter valid card details.
	- 11a: if the **bank declines the payment**
		- **qPay system**  Displays **"Payment failed. Please try again"** and allows the owner to retry.
	
- Special requirements:
	- Credit card data must be processed securely at all times.  
	- In order to validate cards and authorize payments, the payment process necessitates real-time communication with the qPay system.

**03-Renew a Registered Vehicle.**

- Name: Renew a Registered Vehicle
- Description: This use case allows a **vehicle owner** to renew the registration of a vehicle. The system validates the fitness certificate, insurance policy, and checks for any unpaid fines before generating a new registration sticker and renewal invoice.
- Primary actor:
	- Vehicle Owner
	- Authorized Workshop
	- Insurance Company
	
- Goal: To successfully renew the vehicle registration by making sure that all conditions are satisfied, including a valid insurance policy, a fitness certificate, and the absence of any outstanding traffic penalties.
- Triggers: The **vehicle owner** initiates the renewal by entering the vehicle’s **VIN** in the system.
- Preconditions:
	- The car needs to be registered in the system already.
	- It is necessary to have the Vehicle Identification Number (VIN) on hand.

- Postconditions:
	- The registration validity is extended by issuing a new vehicle registration.
	- The invoice and new registration sticker are created.
	- The registration is accompanied by the vehicle's insurance policy and fitness certificate.
- Main scenario:

| Actor Action                                                                   | System Response                                                                           |
| ------------------------------------------------------------------------------ | ----------------------------------------------------------------------------------------- |
| 1. Vehicle owner inputs the VIN into the system to renew a registered vehicle. | 2. System retrieves the registration details.                                             |
|                                                                                | 3. System checks if the vehicle is **over two years old**.                                |
|                                                                                | 4.If the vehicle is older than two years, system checks for a fitness certificate. 4a     |
|                                                                                | 5. System retrieves the compulsory insurance policy. 5a                                   |
|                                                                                | 6. If the insurance is valid, the system checks for **unpaid fines or invoices**. 6a      |
|                                                                                | 7. System **renews the registration** with the same validity as the new insurance policy. |
|                                                                                | 8. System attaches the insurance policy and fitness certificate to the registration.      |
|                                                                                | 9. System prepares a new registration sticker with updated validity.                      |
|                                                                                | 10. System generates an invoice for the registration renewal.                             |
- Alternative Flows:
	- 4a: If no fitness certificate is found:
		- the system terminates the renewal process with the message **"Get fitness certificate first."** 
	- 5a: If the insurance policy is not found,:
		- the system terminates the renewal process with the message **"Get insurance policy."** 
	- 6a: if there are unpaid fines or invoices:
		- the system terminates the renewal process and displays a message **"Pay the bill first."**
- Special requirements:
	-  System Integration: Must connect with databases for fitness certificates, insurance, fines, and registration details.
	- Real-time Validation: Must validate data in real-time for fines, fitness certificates, and insurance.
	- Security: Ensure secure data transmission, especially for personal and financial info.
	- Error Handling: Provide clear messages for missing certificates, insurance, or fines.
	- Payment Gateway: Integrate with a secure payment system (like qPay) for paying fines.

**04-Transfer Unregistered Vehicle**

- Name: Transfer Unregistered Vehicle
- Description: In order to transfer ownership of an unregistered car to a new owner via the iQVR system, the existing owner follows the procedures outlined in this use case.
- Actors:
	- Current Owner
	- New owner
	 -  Vehicle Manufacturer System
	  	- Qatar Trade Service System	  
- Triggers: 
	- Using the iQVR system, the existing owner starts the transfer procedure for an unregistered car.
- Precondition:
	- The car must meet the requirements for transfer, such as being imported, validated, and clear of any pending legal or financial issues.  
	- The vehicle's valid details (make, model, and VIN) are in the possession of the current owner.  
	- The credentials used by the current owner to access the iQVR system are valid.

- Post condition
	- Ownership of the unregistered vehicle is successfully transferred to the new owner.
	- The system generates an invoice for the transfer fee, which can be paid later.
	- The new owner is responsible for registering the vehicle.
- Normal Scenario

| Actor actions                                                                          | System response                                                                             |
| -------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- |
| 1-The Current Owner logs into iQVR.                                                    | 2-authenticates the credentials                                                             |
| 3-The owner selects "Transfer Unregistered Vehicle."                                   | 4-displays the form to enter vehicle details.                                               |
| 5-The Current Owner enters the vehicle's VIN, make, model, and other relevant details. | 6- System sends the details to the Vehicle Manufacturer System for verification             |
| 7- Manufacturer confirms the vehicle details. 7a                                       | 8- System requests the current owner’s name and QID                                         |
| 9-The Current Owner provides the new owner's name, QID, and contact information.       | 10- System sends the VIN and QID to Qatar Trade Service to verify import status.            |
| 11- If import is confirmed, the system retrieves the insurance policy. 11a             | 12-System assigns a registration number to the vehicle and display it to the owner          |
| 13-Current owner provides the new owner’s name, QID, address, and mobile number.       | 14-The vehicle is assigned to the new owner by the system, which also stores their details. |
|                                                                                        | 15- System designates the previous owner as the current owner.                              |
|                                                                                        | 16- System generates a new registration sticker.                                            |
|                                                                                        | 17. System creates an invoice for the transfer fee, payable by the new owner                |
-  **Alternative Flows:**
		7 a-  if the vehicle manufacturer cannot verify the vehicle’s details, the system terminates the process with **"Incorrect vehicle information."**.
		10a-  if Qatar Trade Service cannot confirm the vehicle’s import, the system terminates the session with **"Incorrect ownership."**
		