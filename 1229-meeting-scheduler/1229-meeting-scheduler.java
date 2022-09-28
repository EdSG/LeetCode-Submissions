class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> result = new ArrayList<>();
        
        PriorityQueue<int[]> slots = new PriorityQueue<>((slot1, slot2) -> slot1[0] - slot2[0]);
        
        for (int[] slot: slots1) {
            if (slot[1] - slot[0] >= duration) slots.offer(slot);
        }
        for (int[] slot: slots2) {
            if (slot[1] - slot[0] >= duration) slots.offer(slot);
        }
        
        while (slots.size() > 1) {
            int[] slot1 = slots.poll();
            int[] slot2 = slots.peek();
            
            if (slot1[1] >= slot2[0] + duration) {
                result.add(slot2[0]);
                result.add(slot2[0] + duration);
                break;
            }
        }
        
        return result;
    }
}