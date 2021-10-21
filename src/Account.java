public abstract class Account{
    double rateOfInterest;
    double amount;
    String type;

    public Account() {
        super();
    }

    public Account(double amount) {
        this.amount = amount;
    }

    public Account(String type) {
        this.type = type;
    }

    public Account(double amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    abstract double calculateInterest();
}
