In the Qatar Vehicle Registration System (QVS), the Factory Pattern and Observer Pattern were chosen to address specific system requirements effectively. Here's a concise explanation of their selection:

## 1. Factory Pattern (Creational):

- Object Creation Separation: Simplifies the creation of different vehicle types (e.g., Car, Truck) through a centralized Vehicle Factory class, keeping the logic independent of the client code.
- Extensibility: Easily accommodates new vehicle types (e.g., Bus, Motorcycle) without altering existing code.
- Flexibility & Loose Coupling: Abstracts object creation, reducing dependencies between client code and specific implementations.
- Simplified Initialization: Encapsulates complex object creation logic, enhancing maintainability.

## 2. Observer Pattern (Behavioral):

- Decoupled Communication: Ensures Vehicle Registration notifies stakeholders (e.g., Traffic Police, Insurance Companies) of registration status changes without direct dependencies.
- Real-Time Updates: Automatically communicates critical changes (e.g., unregistration) to all observers.
- Scalability: Supports dynamic addition of new observers (e.g., Vehicle Inspection Authorities) without modifying core logic.
- Loose Coupling: Keeps the system modular, allowing components to evolve independently.

These patterns ensure the QVS remains flexible, maintainable, and scalable while addressing its core functional needs.