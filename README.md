# Student Record Management System 
**Technical Documentation & Architecture Report**

## 1. Executive Summary
The Student Record Management System is a lightweight, console-based Java application designed to perform standard CRUD 
(Create, Read, Update, Delete) operations for educational institutions. The primary objective of this project was to engineer 
a reliable backend system that manages user inputs, handles data storage through primary data structures, and executes search algorithms efficiently.

## 2. System Architecture
The application operates on a single-threaded runtime environment using Core Java.
It utilizes a continuous `while` loop to maintain the state of the application menu,
ensuring the system remains active until the user explicitly triggers the termination sequence. 

**Data Structures Utilized:**
* **Parallel 1D Arrays:** Used to simulate database tables (`studentIDs` and `studentNames`). 
* **State Trackers:** An integer variable (`studentCount`) acts as a dynamic pointer,
*  ensuring new data is always appended to the first available array index without overwriting existing records.

## 3. Core Functionalities & Logic Flow
The system is divided into modular methods to separate concerns and improve code readability.

* **Data Ingestion (`addStudent`):** Utilizes the `java.util.Scanner` class to capture console inputs.
*  The system mitigates buffer overflow errors by clearing the scanner pipeline (`scanner.nextLine()`) between integer and string inputs.
* **Data Retrieval (`viewStudents`):** Implements a standard `for` loop traversal.
* It includes an edge-case handler that verifies if the system is empty (`studentCount == 0`) before attempting to iterate, preventing unnecessary processing.
* **Search Algorithm (`searchStudent`):** Deploys a **Linear Search Algorithm** with an $O(N)$ time complexity.
*  It iterates through the populated array indexes. Upon identifying a matching ID, it immediately breaks the loop using a `return` statement,
*   optimizing runtime efficiency.

## 4. Testing & Debugging Parameters
During the development lifecycle, the system was subjected to rigorous logic flow testing to ensure stability.
* **Input Validation:** Ensured the `Scanner` accurately captured multi-word string
* inputs (e.g., First and Last names) without throwing `InputMismatchException` errors.
* **Boundary Testing:** Verified that the loop logic correctly terminates at the `studentCount` boundary,
*  preventing `ArrayIndexOutOfBounds` exceptions.
* **Algorithm Verification:** Confirmed the linear search successfully identifies both the first and last elements in the array,
*  and correctly outputs a "Not Found" state when querying non-existent IDs.
