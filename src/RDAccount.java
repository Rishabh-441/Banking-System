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