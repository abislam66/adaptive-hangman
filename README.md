\# Adaptive Hangman Engine



An adversarial Hangman implementation in Java that dynamically adapts the hidden word to minimize information revealed to the player.



\## Problem

Traditional Hangman commits to a single hidden word at the start of the game. This project explores an alternative strategy where the system delays commitment by maintaining a set of valid words consistent with the player’s guesses.



\## Approach

\- Loaded a dictionary and filtered candidate words by length

\- Grouped remaining words into word families using HashMap and HashSet

\- Selected the largest word family each round to maximize ambiguity

\- Updated revealed letters and remaining guesses iteratively



\## Tech Stack

Java | HashMap | HashSet | Algorithms



\## How to Run

Compile and run from the project directory:



\## Key Learnings

\- Using Maps and Sets to model dynamic state efficiently

\- Designing adversarial algorithms under constraints

\- Tradeoffs between optimality and scalability



