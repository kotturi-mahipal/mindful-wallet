// =================================================================
// CoolingOffSection Component
// =================================================================

import type { CoolingOffItem } from "../types";
import CoolingOffItemDisplay from "./CoolingOffItem";

interface CoolingOffSectionProps {
  items: CoolingOffItem[];
}

function CoolingOffSection({ items }: CoolingOffSectionProps) {
  return (
    <section>
      <h2 className="text-2xl font-semibold mb-4 border-b pb-2">Cooling-Off Items</h2>
      <div className="bg-white p-6 rounded-lg shadow-md space-y-4">
        {items.length > 0 ? (
          items.map(item => <CoolingOffItemDisplay key={item.id} item={item} />)
        ) : (
          <p className="text-slate-400 text-center py-4">No items in your cooling-off list. Great job!</p>
        )}
      </div>
    </section>
  );
}

export default CoolingOffSection;