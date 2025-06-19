🏫 Student Management System – Java (OOP CLI Project)
A Java-based command-line Student Management System using all core Object-Oriented Programming (OOP) concepts. The system consists of two modules: Admin and Student. Admin can manage branches, subjects, and exams. Students can register, choose their academic path, take exams, and view results.

✅ Features
Admin Module
Admin login using a password

Add branches

Add subjects to branches

Add exam papers (questions and answers)

View all student results

Student Module
Register with name, age, email, and phone

System generates a unique Student ID

Login using Student ID

View personal profile

Select a branch

Choose subjects from the selected branch

Take exams based on selected subjects

View results

⚙️ Non-Functional Requirements
Text-based command-line interface (CLI)

Modular and maintainable code using Java OOPs principles

🔁 OOP Concepts Used
Concept	Usage
Encapsulation	All class variables are private and accessed via getters/setters
Inheritance	Admin and Student inherit from the abstract User class
Polymorphism	Method overriding for menu() in Admin and Student classes
Abstraction	Abstract class User defines common structure for user types

🧱 Class Structure and Responsibilities
User (abstract)
Common base class for Admin and Student. Holds shared attributes like name and the menu() method.

Admin extends User
Handles login, branch management, subject creation, and student result viewing.

Student extends User
Holds personal information, student ID, and performs all academic tasks like selecting subjects and taking exams.

Branch
Represents a department or specialization. Contains a list of subjects.

Subject
Contains the subject name and its corresponding ExamPaper.

ExamPaper
Holds a single question and the correct answer.

Result
Static class for saving and displaying student performance.

🔄 Application Flow
Launch the application using Main.java

Home menu includes:

Admin Login

Student Login

Register Student

Exit

Admin Flow
Prompted for password

Options to add branches, subjects, exam papers, and view student results

Student Flow
Registration collects name, age, email, phone

A unique Student ID is generated

Login using Student ID

Menu to:

View profile

Select branch

Choose subjects

Take exams

View results

