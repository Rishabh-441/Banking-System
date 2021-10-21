import java.util.Scanner;

abstract class Account{
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
class FDAccount extends Account{
    int noOfDays;

    public FDAccount(double amount, int noOfDays) {
        super(amount);
        this.noOfDays = noOfDays;
    }

    public FDAccount(double a, String t, int d) {
        super(a,t);
        this.noOfDays = d;
    }

    public double calculateInterest(){
        if (this.amount < 1_00_00_000.0){

            if (type.equals("General")){
                if (noOfDays >= 7 && noOfDays <= 14){
                    rateOfInterest = 4.5;
                }
                else if (noOfDays >= 15 && noOfDays <= 29){
                    rateOfInterest = 4.75;
                }
                else if(noOfDays >= 30 && noOfDays <= 45){
                    rateOfInterest = 5.5;
                }
                else if(noOfDays >= 46 && noOfDays <= 60){
                    rateOfInterest = 7;
                }
                else if(noOfDays >= 61 && noOfDays <= 184){
                    rateOfInterest = 7.5;
                }
                else if(noOfDays >= 185 && noOfDays <= 365){
                    rateOfInterest = 8.0;
                }
            }
            else if(type.equals("Senior Citizen")){
                if (noOfDays >= 7 && noOfDays <= 14){
                    rateOfInterest = 5.0;
                }
                else if (noOfDays >= 15 && noOfDays <= 29){
                    rateOfInterest = 5.25;
                }
                else if(noOfDays >= 30 && noOfDays <= 45){
                    rateOfInterest = 6.0;
                }
                else if(noOfDays >= 46 && noOfDays <= 60){
                    rateOfInterest = 7.5;
                }
                else if(noOfDays >= 61 && noOfDays <= 184){
                    rateOfInterest = 8.0;
                }
                else if(noOfDays >= 185 && noOfDays <= 365){
                    rateOfInterest = 8.5;
                }
            }
        }
        else{
            if (noOfDays >= 7 && noOfDays <= 14){
                rateOfInterest = 6.5;
            }
            else if (noOfDays >= 15 && noOfDays <= 45){
                rateOfInterest = 6.75;
            }
            else if(noOfDays >= 46 && noOfDays <= 60){
                rateOfInterest = 8;
            }
            else if(noOfDays >= 61 && noOfDays <= 184){
                rateOfInterest = 8.5;
            }
            else if(noOfDays >= 185 && noOfDays <= 365) {
                rateOfInterest = 10.0;
            }
        }
        return rateOfInterest;
    }

}
class RDInterest extends Account{
    int maturityPeriod;

    public RDInterest() {
        super();
    }

    public RDInterest(double amount, String type, int maturityPeriod) {
        super(amount, type);
        this.maturityPeriod = maturityPeriod;
    }

    public double calculateInterest(){
        if(type.equals("General")){
            if (maturityPeriod <= 6){
                rateOfInterest = 7.5;
            }
            else if (maturityPeriod <= 9){
                rateOfInterest = 7.75;
            }
            else if (maturityPeriod <= 12){
                rateOfInterest = 8.0;
            }
            else if(maturityPeriod <= 15){
                rateOfInterest = 8.25;
            }
            else if (maturityPeriod <= 18){
                rateOfInterest = 8.50;
            }
            else if(maturityPeriod <= 21){
                rateOfInterest =  8.75;
            }
        }
        else if (type.equals("Senior Citizen")){
            if (maturityPeriod <= 6){
                rateOfInterest = 8.0;
            }
            else if (maturityPeriod <= 9){
                rateOfInterest = 8.25;
            }
            else if (maturityPeriod <= 12){
                rateOfInterest = 8.50;
            }
            else if(maturityPeriod <= 15){
                rateOfInterest = 8.75;
            }
            else if (maturityPeriod <= 18){
                rateOfInterest = 9.0;
            }
            else if(maturityPeriod <= 21){
                rateOfInterest = 9.25;
            }
        }
        return rateOfInterest;
    }
}
class SBAccount extends Account{
    public SBAccount(String type) {
        super(type);
    }

    public double calculateInterest(){
        if (type.equals("Normal")){
            rateOfInterest = 4.0;
        }
        else if(type.equals("NRI")){
            rateOfInterest = 6.0;
        }
        return rateOfInterest;
    }

}


public class BankAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while(n!= 4){
            System.out.println("PRESS\n1. INTEREST CALCULATOR--SB\n2. INTEREST CALCULATOR--FD\n3. INTEREST CALCULATOR--RD\n4.EXIT");
            n = sc.nextInt();
            if (n == 1) {
                System.out.println("ENTER THE AVERAGE AMOUNT IN YOUR ACCOUNT:");
                double a = sc.nextDouble();
                System.out.println("ENTER THE TYPE OF ACCOUNT(Normal or NRI):");
                String t = sc.next();
                if (t.equals("Normal") || t.equals("NRI")) {
                    SBAccount obj = new SBAccount(t);
                    System.out.println("Interest gained: RS " + ((obj.calculateInterest() / 100) * a));
                }
                else {
                    System.out.println("YOU ENTERED INVALID TYPE");
                    continue;
                }
            }
            else if (n == 2){
                System.out.println("ENTER THE FD AMOUNT:");
                double a = sc.nextDouble();
                System.out.println("ENTER THE NUMBER OF DAYS:");
                int d = sc.nextInt();
                String t;
                if ( a < 1_00_00_000 && a >0){
                    System.out.println("ENTER YOUR AGE:");
                    int age = sc.nextInt();
                    t = "Senior Citizen";
                    if (age <= 50){
                        t = "General";
                    }
                    FDAccount obj = new FDAccount(a,t,d);
                    System.out.println("Interest gained: RS " + ((obj.calculateInterest() / 100) * a));
                }
                else if (a >= 1_00_00_000){
                    FDAccount obj = new FDAccount(a,d);
                    System.out.println("Interest gained: RS " + ((obj.calculateInterest() / 100) * a));
                }
                else {
                    System.out.println("YOU ENTERED AN INVALID AMOUNT");
                    break;
                }
            }
            else if (n==3){

                System.out.println("ENTER THE FD AMOUNT:");
                int a = sc.nextInt();
                System.out.println("ENTER THE AGE OF ACCOUNT HOLDER:");
                int age = sc.nextInt();
                System.out.println("ENTER THE MATURITY PERIOD (in months):");
                int mp = sc.nextInt();
                String t = "Senior Citizen";
                if (age <= 50){
                    t = "General";
                }
                RDInterest obj = new RDInterest(a,t,mp);
                System.out.println("Interest gained: RS " + (obj.calculateInterest()/100)*a);
            }

            else if (n==4) {
                System.out.println("*****EXIT FROM THE BANK*****");
                break;
            }
            else {
                System.out.println("YOU ENTERED AN INVALID NUMBER------PLEASE RETRY AGAIN");
            }
        }

    }
}

