## Day 01 – JVM & Java Execution

### Key Learnings
- Java execution flow
- Bytecode & JVM
- Stack vs Heap (intro)

### Hands-on
- Compiled and ran Java manually using javac and java

### Interview Notes
Understanding JVM internals is critical for performance-sensitive backend systems.
1️⃣ What Java REALLY is

Java is not just a language. It’s a platform.

It has 3 main parts:

🔹 JDK (Java Development Kit)

Tools for developers

javac, java, debugger, etc.

🔹 JVM (Java Virtual Machine)

The engine that runs Java

Manages:

Memory

Garbage Collection

Threads

🔹 JRE (Java Runtime Environment)

JVM + core libraries

Enough to run, not develop

📌 Google cares about JVM — because performance, latency, and memory live here.

🧠 PART 2: WHAT HAPPENS WHEN JAVA RUNS (VERY IMPORTANT)

Let’s say you write:

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

Step-by-step execution:

Main.java → source code

javac Main.java
⮕ creates Main.class

.class file contains bytecode

JVM:

Loads class (Class Loader)

Verifies bytecode (security)

Executes using:

Interpreter

JIT compiler (later)

📌 Key idea:
Java is compiled AND interpreted.

🧠 PART 3: BYTECODE (WHY GOOGLE LIKES JAVA)
What is bytecode?

Not machine code

Not source code

Intermediate, platform-independent

That’s why:

Write once, run anywhere


##Stack

Method calls

Local variables

Fast

Per thread

##Heap

Objects

Shared across threads

Garbage collected

int x = 10;          // stack
User u = new User(); // reference on stack, object on heap


