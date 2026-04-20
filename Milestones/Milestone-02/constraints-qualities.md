### **Quality Attributes:**

| **Quality Attribute** | **Architecture Requirement**                                                                                                                                                                                                                                                                      |
| --------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Usability**         | The system should provide a clear and simple interface. Users, including vehicle owners and staff, should be able to complete essential tasks like vehicle registration and fine payments in under 2 minutes on average.                                                                          |
| **Security**          | The system should block access after three consecutive failed login attempts and log all unauthorized access attempts.                                                                                                                                                                            |
| **Interoperable**     | The system must integrate seamlessly with external systems like **qPay**, ensuring that transactions reflect accurately within 2 seconds after processing.                                                                                                                                        |
| **Availability**      | The system should guarantee 99% uptime under normal operating conditions and handle up to 100 concurrent users efficiently. It should also be resilient to sudden spikes in demand, handling up to 200 users simultaneously during peak times without interruptions.                              |
| **Portability**       | The system must be able to run on multiple platforms, including desktops, tablets, and mobile devices. The system must function effectively across platforms, including Windows, macOS, Android, and iOS, ensuring a consistent and responsive user experience across desktop and mobile devices. |
| **Modifiability**     | The system must support modular architecture to enable the addition of new features or updates with minimal disruption, ensuring downtime does not exceed 5 minutes for any update.                                                                                                               |

---

### **Constraints:**

| **Constraints**               | **Description**                                                                                                                                    |
| ----------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Resource Constraints**      | Hiring is limited to 10 technical staff, and the system is restricted to using 20 servers.                                                         |
| **Practical Constraints**     | The system is restricted by a fixed budget for hardware and staffing, requiring optimized resource allocation.                                     |
| **Technological Constraints** | The system must remain fully compatible with the **qPay** platform for payment processing, with no alternative systems allowed.                    |
| **Regulatory Constraints**    | The system must comply with Qatar’s Data Privacy Law, ensuring data encryption in transit, and providing access only to authorized personnel.      |
| **Operational Constraints**   | The system will be maintained by a single administrator, requiring processes like account setup and backups to be largely automated or simplified. |
