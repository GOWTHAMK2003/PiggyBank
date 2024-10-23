import java.util.*;

class Account {
    private String name;
    private String email;
    private String password;
    private String accno;
    private double balance;
    private List<Expense> expenses;

    public Account(String name, String email, String password, String accno, double balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.accno = accno;
        this.balance = balance;
        this.expenses = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAccNo(String accno) {
        this.accno = accno;
    }

    public String getAccNo() {
        return accno;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void addExpense(Expense expense) {
        if (expense.getAmount() > balance) {
            System.out.println("Insufficient Balance");
        } else {
            expenses.add(expense);
            balance -= expense.getAmount();
        }
    }

    public void showBalance() {
        System.out.println("Balance: Rs " + balance);
    }

    public void showExpenses() {
        System.out.println("Expenses:");
        int s = 0;
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }
}

abstract class Expense {
    private String description;
    private double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return description + ": Rs " + amount;
    }
}

class Grocery extends Expense {
    public Grocery(String description, double amount) {
        super(description, amount);
    }
}

class Entertainment extends Expense {
    public Entertainment(String description, double amount) {
        super(description, amount);
    }
}

class BillExpense extends Expense {
    public BillExpense(String description, double amount) {
        super(description, amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = null;
        boolean running = true;

        System.out.println("Welcome To Our Piggy Bank Application");
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Add Account Details");
            System.out.println("2. View Balance");
            System.out.println("3. Add Grocery Expense");
            System.out.println("4. Add Entertainment Expense");
            System.out.println("5. Add Bill Expense");
            System.out.println("6. View Expenses");
            System.out.println("7. Exit");
            System.out.println("Enter your choice:");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter your Name:");
                    sc.nextLine(); 
                    String name = sc.nextLine();
                    System.out.println("Enter your Email id:");
                    String email = sc.nextLine();
                    System.out.println("Enter your Password:");
                    String password = sc.nextLine();
                    System.out.println("Enter your Account Number:");
                    String accountNumber = sc.nextLine();
                    System.out.println("Enter your Initial Deposit Amount:");
                    double balance = sc.nextDouble();
                    acc = new Account(name, email, password, accountNumber, balance);
                    System.out.println("Account created successfully!");
                    break;
                case 2:
                    if (acc != null) {
                        acc.showBalance();
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case 3:
                    if (acc != null) {
                        System.out.println("Enter description for Grocery Expense:");
                        sc.nextLine(); 
                        String groceryDescription = sc.nextLine();
                        System.out.println("Enter amount for Grocery Expense:");
                        double groceryAmount = sc.nextDouble();
                        acc.addExpense(new Grocery(groceryDescription, groceryAmount));
                        System.out.println("Grocery expense added successfully!");
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case 4:
                    if (acc != null) {
                        System.out.println("Enter description for Entertainment Expense:");
                        sc.nextLine();  
                        String entertainmentDescription = sc.nextLine();
                        System.out.println("Enter amount for Entertainment Expense:");
                        double entertainmentAmount = sc.nextDouble();
                        acc.addExpense(new Entertainment(entertainmentDescription, entertainmentAmount));
                        System.out.println("Entertainment expense added successfully!");
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case 5:
                    if (acc != null) {
                        System.out.println("Enter description for Bill Expense:");
                        sc.nextLine(); 
                        String billDescription = sc.nextLine();
                        System.out.println("Enter amount for Bill Expense:");
                        double billAmount = sc.nextDouble();
                        acc.addExpense(new BillExpense(billDescription, billAmount));
                        System.out.println("Bill expense added successfully!");
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case 6:
                    if (acc != null) {
                        acc.showExpenses();
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case 7:
                    running = false;
                    System.out.println("Thank you for using Piggy Bank Application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}