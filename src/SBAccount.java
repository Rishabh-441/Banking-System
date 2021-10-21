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
