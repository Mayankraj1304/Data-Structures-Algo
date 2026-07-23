class MyCircularQueue {
    private final int[] queue;
    private final int capacity;
    private int front;
    private int size;

    // Constructor: Initialize object with size k
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.front = 0;
        this.size = 0;
    }
    
    // Inserts an element at the rear. Returns true if successful.
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        // Calculate the next available insert position
        int insertIdx = (front + size) % capacity;
        queue[insertIdx] = value;
        size++;
        return true;
    }
    
    // Deletes an element from the front. Returns true if successful.
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        // Advance front pointer forward (wraps around via modulo)
        front = (front + 1) % capacity;
        size--;
        return true;
    }
    
    // Returns the item at the front. Returns -1 if empty.
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }
    
    // Returns the item at the rear. Returns -1 if empty.
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int rearIdx = (front + size - 1) % capacity;
        return queue[rearIdx];
    }
    
    // Checks whether the circular queue is empty.
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Checks whether the circular queue is full.
    public boolean isFull() {
        return size == capacity;
    }
}