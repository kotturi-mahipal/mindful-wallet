import type {Goal} from '../types';

interface GoalJarProps {
  goal: Goal;
}

function GoalJar({ goal }: GoalJarProps) {
  const progress = (goal.currentAmount / goal.targetAmount) * 100;

  return (
    <div>
      <div className="flex justify-between items-baseline mb-2">
        <h3 className="text-xl font-bold">{goal.goalName}</h3>
        <p className="text-slate-500 font-medium">
          ₹{goal.currentAmount.toFixed(2)} / ₹{goal.targetAmount.toFixed(2)}
        </p>
      </div>
      <div className="w-full bg-slate-200 rounded-full h-4">
        <div
          className="bg-green-500 h-4 rounded-full transition-all duration-500"
          style={{ width: `${progress}%` }}
        ></div>
      </div>
    </div>
  );
}

export default GoalJar;