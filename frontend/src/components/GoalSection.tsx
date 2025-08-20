import type { Goal } from "../types";
import GoalJar from "./GoalJar";

interface GoalsSectionProps {
  goals: Goal[];
}

function GoalSection({ goals }: GoalsSectionProps) {
  return (
    <section>
      <h2 className="text-2xl font-semibold mb-4 border-b pb-2">Your Goal Jars</h2>
      <div className="bg-white p-6 rounded-lg shadow-md space-y-6">
        {goals.length > 0 ? (
          goals.map(goal => <GoalJar key={goal.id} goal={goal} />)
        ) : (
          <p className="text-slate-400 text-center py-4">You haven't created any goals yet. Let's make one!</p>
        )}
      </div>
    </section>
  );
}

export default GoalSection;