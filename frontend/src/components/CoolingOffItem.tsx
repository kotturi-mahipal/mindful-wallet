import type { CoolingOffItem } from "../types";

// =================================================================
// Component: CoolingOffItem (New Component!)
// This component displays a single cooling-off item.
// =================================================================
interface CoolingOffItemProps {
  item: CoolingOffItem;
}

function CoolingOffItemDisplay({ item }: CoolingOffItemProps) {
  // In a future step, we'll add a real countdown timer here.
  const timeLeft = "23:59:59"; 

  return (
    <div className="flex justify-between items-center">
      <div>
        <p className="font-semibold">{item.itemName}</p>
        <p className="text-slate-500 text-sm">₹{item.amount.toFixed(2)}</p>
      </div>
      <div className="text-right">
        <p className="font-mono text-lg text-red-500">{timeLeft}</p>
        <p className="text-slate-400 text-xs">Time Left</p>
      </div>
    </div>
  );
}

export default CoolingOffItemDisplay;