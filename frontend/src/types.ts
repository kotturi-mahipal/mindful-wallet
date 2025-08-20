export interface Goal {
    id: number;
    goalName: string;
    targetAmount: number;
    currentAmount: number;
}

export interface CoolingOffItem {
    id: number;
    itemName: string;
    amount: number;
    category: string;
    expiresAt: string;
}