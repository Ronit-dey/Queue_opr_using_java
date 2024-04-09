import java.util.Scanner;

class Queue {
    private final int MAX_SIZE = 5;
    private int items[];
    private int front, rear;

    public Queue() {
        items = new int[MAX_SIZE];
        front = rear = -1;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Check if the queue is full
    public boolean isFull() {
        return rear == MAX_SIZE - 1;
    }

    // Enqueue an item (add to the back)
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            items[rear] = data;
        }
    }

    // Dequeue an item (remove from the front)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1; // Indicate error or use a different approach for handling empty queue
        } else {
            int data = items[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front++;
            }
            return data;
        }
    }

    // Peek at the front item of the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1; // Indicate error or use a different approach for handling empty queue
        } else {
            return items[front];
        }
    }

    // Display the contents of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(items[i] + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();

        int choice, value;

        do {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (!queue.isFull()) {
                        System.out.print("Enter value to enqueue: ");
                        value = scanner.nextInt();
                        queue.enqueue(value);
                        System.out.println(value + " enqueued successfully");
                    }
                    break;
                case 2:
                    value = queue.dequeue();
                    if (value != -1) {
                        System.out.println(value + " dequeued successfully");
                    }
                    break;
                case 3:
                    value = queue.peek();
                    if (value != -1) {
                        System.out.println("Front element is: " + value);
                    }
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);
    }
}