# Mindful Wallet

A full-stack expense tracker designed not just to log what you spend, but to help you understand *why* you spend. Built as a personal tool to combat impulse spending, this application introduces mindful friction and visual goals to build healthier financial habits.

## The "Why" Behind Mindful Wallet

As someone with ADHD, I've always found traditional budgeting apps overwhelming. They're great at showing you where your money went, but they don't help with the core problem I faced: the cycle of impulse spending, losing track of money and later regret. I needed a tool that wasn't just about categorization and spreadsheets, but about understanding the emotional triggers behind my spending.

I built Mindful Wallet to be the product I couldn't find—a mindful spending companion. It's designed to be simple, non-judgmental, and focused on building self-awareness rather than enforcing strict budgets.

## Key Features

The MVP is built on three core principles designed to interrupt the impulse cycle:

1.  **The "Why" Journal:** When logging an expense, especially an unplanned one, the app prompts you to jot down how you're feeling. This creates a powerful log of your spending triggers over time.
2.  **The "Cooling-Off" Period:** For categories you mark as "impulse buys" (like takeout or online shopping), you first log the *intent* to purchase. This starts a 24-hour timer, creating a crucial pause that allows your logical brain to catch up with your impulsive brain.
3.  **Visual "Goal Jars":** When you successfully skip an impulse purchase, you can transfer the money you saved into a visual "Goal Jar." Watching the jar fill up provides a tangible and motivating sense of accomplishment that abstract numbers often lack.

## Architectural Diagram

*(Note: WIP)*

## Tech Stack

* **Backend**: Java, Spring Boot, Spring Data JPA, PostgreSQL
* **Frontend**: React, TypeScript, Vite, Axios, Tailwind CSS
* **Deployment**: Heroku (Backend & DB), Vercel (Frontend)

## Getting Started

To run this project locally, you'll need Java, Node.js, and a running PostgreSQL instance.

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/kotturi-mahipal/mindful-wallet.git](https://github.com/kotturi-mahipal/mindful-wallet.git)
    ```
2.  **Backend Setup:**
    * Navigate to the `backend` directory.
    * Create a PostgreSQL database named `mindful_wallet_db`.
    * Update the `src/main/resources/application.properties` file with your PostgreSQL username and password.
    * Run the Spring Boot application from your IDE or using `./mvnw spring-boot:run`. The backend will be running on `http://localhost:8080`.
3.  **Frontend Setup:**
    * Navigate to the `frontend` directory.
    * Install the necessary packages: `npm install`
    * Start the development server: `npm run dev`. The frontend will be running on `http://localhost:5173`.

## API Endpoints

The backend exposes the following RESTful API endpoints:

| Method | Endpoint              | Description                      |
| :----- | :-------------------- | :------------------------------- |
| `POST` | `/api/expenses`       | Log a new expense.               |
| `GET`  | `/api/expenses`       | Get all logged expenses.         |
| `POST` | `/api/cooling-off`    | Start a new cooling-off period.  |
| `GET`  | `/api/cooling-off`    | Get all active cooling-off items.|
| `POST` | `/api/goals`          | Create a new savings goal.       |
| `GET`  | `/api/goals`          | Get all savings goals.           |
| `POST` | `/api/goals/{id}/add` | Add funds to a specific goal.    |

## Future Improvements

* **User Authentication**: Implement secure user accounts to store data privately.
* **Real-Time Countdown**: Add a live countdown timer for cooling-off items.
* **Data Visualization**: Create charts and graphs to help visualize spending patterns and triggers.
* **Mobile App**: Package the application as a native mobile app using a framework like React Native.