# Project
 
The project's main goal is to create the IQVR vehicle management system. Through an online portal, this system enables car owners to handle crucial responsibilities like insurance, fine payments, ownership transfers, and vehicle registration. Making it simple and effective for owners to manage and access services relating to their vehicles is the aim. Our primary goal was to analyse the system requirements, identify key processes and actors, and create structured diagrams to provide a clear understanding of the system design.
  
We developed key diagrams, including **DFDs** (Level 0 and 1) and a **Use Case Diagram** to show interactions between actors and processes. Detailed **use case specifications** were provided for **Renew Registration**, **Ownership Transfer**, and **Pay Fines**, covering triggers, conditions, and flows. A **Class Diagram** was also created to represent entities like **Vehicle, Owner, and Insurance Policy**, with proper associations such as **composition and aggregation**.
  
## Team
 
- Sara Alsada sa2203519@student.qu.edu.qa
- Alaa Elareer ae2203638@student.qu.edu.qa
-  Aisha Allenjawi  aa2001665@qu.edu.qa 
 
## Challenges
 
1. **Challenge #1: Integrating External Systems**
    - One of the major challenges was connecting the iQVR system with external services like **qPay** for payment processing. Ensuring secure communication between the systems and handling real-time data exchanges, especially for sensitive credit card information, was difficult. It required thorough testing to make sure everything worked smoothly without security risks.
2. **Challenge #2: Managing Complex Scenarios**
    - Handling various real-life situations, like failed payments or incorrect vehicle details, added complexity to the project. We had to design alternative flows to manage these issues properly, making sure the system could handle errors without confusing the user. Planning for and coding these scenarios required extra time and effort.
3. **Challenge #3: Correct Use of Associations**
	- Deciding when to use **aggregation vs. composition** in the **class diagram** required a deep understanding of the dependencies between entities, such as **Vehicle-Fitness Certificate** (composition) and **Owner-Vehicle** (aggregation). Misinterpreting these relationships could impact the design’s accuracy
4. **Challenge #4: User Experience Design**
    - Designing the system to be both functional and user-friendly was challenging. We had to balance the technical aspects with ease of use, ensuring that vehicle owners could easily navigate the system and complete tasks like paying fines or transferring ownership without confusion.

 
## Lessons
 
- **Lesson #1: The Value of Good System Design**
    - Creating a clear system design with class diagrams is very important. By assigning specific responsibilities to each class, like **Vehicle**, **Owner**, and **Insurance**, it was easier to develop and avoid confusion during the project. This helped keep the system organized.
    
- **Lesson #2: Breaking Down Complex Systems into Smaller Components**
	- Decomposing the system into **smaller processes** (e.g., splitting registered and unregistered ownership transfers) made it easier to handle complex flows. This approach ensured that each team member could focus on specific parts without being overwhelmed.
	
- **Lesson #3: Dealing with Real-life Issues**
    - We learned that planning for real-life issues, like payment failures or incorrect vehicle details, is necessary. Adding clear error messages and allowing users to try again made the system more reliable and user-friendly.
    
- **Lesson #4: Making the System Easy to Use**
    - We found that making the system simple and easy for users was just as important as building its features. Clear instructions and a user-friendly design help vehicle owners complete tasks like paying fines or transferring ownership easily.
    
- **Lesson #5: Time Management and Task Allocation**
	- Working on multiple diagrams (DFDs, class diagrams, use case diagrams) taught us the importance of **dividing tasks** effectively and setting clear deadlines to ensure steady progress. This prevented bottlenecks and kept the project on track.
 
## References

- [Use Cases](https://queue.qa/cmps310/labs/03-use-cases/) used to develop our **use case diagrams** and ensure proper use of **"include" and "extend" relationships**. It also provided insight on writing detailed **use case specifications**, covering triggers, pre-conditions, post-conditions, and flows.
- [class Diagram Multiplicity](https://www.umlboard.com/docs/relations/multiplicity/) Used to depict **class associations** and how to use **multiplicity** to define relationships properly. **Inheritance and abstract classes** were also covered, which were crucial for our IQVR system.