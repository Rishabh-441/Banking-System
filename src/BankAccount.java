import java.util.Scanner;

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

