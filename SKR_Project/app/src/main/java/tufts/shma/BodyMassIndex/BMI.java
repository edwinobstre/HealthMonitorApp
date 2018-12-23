package tufts.shma.BodyMassIndex;

public class BMI{

    public String BMI_caculate(String currentWeight, String height){

        // BMI = kg/m2
        double BMI = Double.valueOf(currentWeight) / (Math.pow(Double.valueOf(height)/100,2));

        return String.valueOf(BMI);
    }
}
