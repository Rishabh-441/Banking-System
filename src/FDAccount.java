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