import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    String name;
    String service;

    public Customer(String name, String service) {
        this.name = name;
        this.service = service;
    }
}

class QueueManager {
    ArrayList<Customer> queue;

    public QueueManager() {
        queue = new ArrayList<>();
    }

    public void enqueue(Customer customer) {
        queue.add(customer);
        System.out.println(customer.name + " bergabung dalam antrian untuk " + customer.service);
    }

    public void dequeue() {
        if (!queue.isEmpty()) {
            Customer customer = queue.remove(0);
            System.out.println(customer.name + " siap dilayani untuk " + customer.service);
        } else {
            System.out.println("Antrian kosong. Tidak ada pelanggan yang dilayani.");
        }
    }

    public void displayQueue() {
        System.out.println("Antrian Saat Ini:");
        if (queue.isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            int position = 1;
            for (Customer customer : queue) {
                System.out.println(position + ". " + customer.name + " - " + customer.service);
                position++;
            }
        }
    }

    public static void main(String[] args) {
        QueueManager queueManager = new QueueManager();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("Menu:");
            System.out.println("1. Masukkan jumlah antrian ");
            System.out.println("2. Tampilkan antrian saat ini");
            System.out.println("3. Panggil pelanggan ");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Masukkan jumlah antrian: ");
                    int numOfCustomers = scanner.nextInt();
                    for (int i = 1; i <= numOfCustomers; i++) {
                        System.out.print("Masukkan nama pelanggan ke-" + i + ": ");
                        String customerName = scanner.next();
                        System.out.print("Masukkan jenis layanan pelanggan ke-" + i + ": ");
                        String customerService = scanner.next();
                        Customer newCustomer = new Customer(customerName, customerService);
                        queueManager.enqueue(newCustomer);
                    }
                }
                case 2 -> queueManager.displayQueue();
                case 3 -> queueManager.dequeue();
                case 4 -> System.out.println("Keluar dari program.");
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
            System.out.println();
        }
        scanner.close();
    }
}