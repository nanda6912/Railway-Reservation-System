# Railway-Reservation-System

A complete console-based railway ticket booking system built using Core Java, demonstrating OOP, arrays, data validation, multi-passenger booking, berth allocation, and clean menu-driven interaction.
<br>
📘 Project Overview

The Railway Reservation System simulates core functionalities of a real railway booking system.
Users can:

✔ View available trains
<br>
✔ Check seat availability
<br>
✔ Book multiple tickets in a single transaction
<br>
✔ Enter passenger name, age, and berth preference
<br>
✔ Auto-allocate berth based on age if not chosen
<br>
✔ Cancel booked tickets
<br>
✔ View passenger list with berth and age details
<br>
This project is ideal for Core Java practice, beginner-level projects, placement, and resume building.

🧠 Features
<br>
🔹 1. Train & Seat Availability

View all trains

Seats, fare, and berth availability

Seat status (Booked / Free)

🔹 2. Book Multiple Tickets

Enter number of passengers

Enter name + age for each passenger

Choose berth (or auto-assign)

Allocates based on IRCTC-like rules:

Age > 60 ➝ Lower Berth

30 < Age ≤ 60 ➝ Middle Berth

10 ≤ Age ≤ 30 ➝ Upper Berth

Children < 10 ➝ Side Lower Berth

🔹 3. Fare Calculation

Fare displayed per passenger

Total fare shown at end of booking

🔹 4. Cancellation

Cancel a seat by entering seat number

Frees up berth and seat

🔹 5. Passenger List

View all booked passengers

Shows name, age, berth type, and seat number

🏗️ Project Structure
<br>
Railway-Reservation-System/
<br>
│
├── src/
<br>
│   ├── Train.java
<br>
│   └── RailwayReservationSystem.java
<br>
│
└── README.md
<br>
🛠️ Tech Stack
<br>
Technology	  ------- ----------------- Purpose
<br>
Java (Core Java)	----------------------Application logic
<br>
OOP	-------------------------------------Classes, objects, methods
<br>
Arrays	--------------------------------Seat allocation, passenger storage
<br>
Scanner API----------------------------	User input
<br>
Menu-driven console ---------------------UI	Interaction
