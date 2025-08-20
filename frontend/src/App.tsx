import { useEffect, useState } from 'react';
import Header from './components/Header';
import CoolingOffSection  from './components/CoolingOffSection';
import GoalSection from './components/GoalSection';
import type { CoolingOffItem, Goal } from './types';
import axios from 'axios';

function App() {
  const [goals, setGoals] = useState<Goal[]>([]);
  const [coolingOffItems, setCoolingOffItems] = useState<CoolingOffItem[]>([]);

  // This useEffect hook now fetches both goals and cooling-off items.
  useEffect(() => {
    const fetchData = async () => {
      try {
        // We can fetch data in parallel to be more efficient.
        const [goalsResponse, coolingOffResponse] = await Promise.all([
          axios.get('http://localhost:8080/api/goals'),
          axios.get('http://localhost:8080/api/cooling-off')
        ]);
        setGoals(goalsResponse.data);
        setCoolingOffItems(coolingOffResponse.data);
      } catch (error) {
        console.error("Failed to fetch data:", error);
      }
    };

    fetchData();
  }, []);

  return (
    <div className="bg-slate-50 min-h-screen font-sans text-slate-800">
      <div className="mx-auto w-full max-w-2xl p-4 sm:p-6">
        <Header />

        <main className="space-y-8">
          <section className="text-center">
            <button className="bg-blue-600 text-white font-bold py-3 px-8 rounded-lg shadow-lg hover:bg-blue-700 transition-all duration-200">
              Log an Expense or Intent
            </button>
          </section>

          {/* We pass the 'coolingOffItems' state down to the CoolingOffSection. */}
          <CoolingOffSection items={coolingOffItems} />
          
          {/* We pass the 'goals' state down to the GoalsSection. */}
          <GoalSection goals={goals} />
        </main>
      </div>
    </div>
  );
}

export default App;
