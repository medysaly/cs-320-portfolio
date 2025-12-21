# cs-320-portfolio

How can I ensure that my code, program, or software is functional and secure?

I ensure functionality by writing comprehensive JUnit tests that cover not just valid inputs (the "happy path"), but also edge cases, boundary values, and invalid inputs. To maintain security, I implement strict input validation within the code constructors—such as checking for null values or excessive string lengths—to prevent invalid data from compromising the system's integrity.

How do I interpret user needs and incorporate them into a program?

I interpret user needs by carefully analyzing the requirements document and breaking down each request into specific, testable constraints (e.g., "ID cannot exceed 10 characters"). I then incorporate these needs by adopting a test-driven mindset, writing test cases that explicitly verify these requirements are met before I even finish writing the logic.

How do I approach designing software?

I approach software design by focusing on modularity and separation of concerns, keeping data objects (like Contact) distinct from the services that manage them (like ContactService). I also prioritize robust error handling during the design phase, planning ahead for how the system should gracefully reject invalid data or handle exceptions without crashing.
