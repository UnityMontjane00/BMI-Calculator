//BMI Calculator Application
//Allows user to calculate BMI using metric or imperial units
//Includes input validation,category classifications and health advice
import java.util.Scanner;
import java.util.Locale;
public class BMICalculator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		scan.useLocale(Locale.US);
		
		char repeat = 0;
		
		do{
		    System.out.println("Hi,This is a BMI calculator. What is your name: ");
			String name = scan.next();
		    int unitChoice = getUnitChoice(scan);
		    
		    double weight = (unitChoice == 1) ? getValidInput(scan, "Enter your weight in kilograms: " , 10, 600) : getValidInput(scan, "Enter your weight in pounds", 22, 1300);
		    
		    double height = (unitChoice == 1) ? getValidInput(scan, "Enter your height in meters: " , 0.5, 2.5) : getValidInput(scan, "Enter your height in inches", 20, 100);
		    
		    double bmi = calculateBmi(unitChoice, weight, height);
		    
			String category = getBmiCategory(bmi);
	        
			printReport(name,bmi,category);

		    System.out.println();
		    
	}while(repeat == 'Y' || repeat == 'y');
}

     //main Method 
     public static int getUnitChoice(Scanner scan){
     int choice;
    
     while(true){
        System.out.println("Select a preferred unit: \n"
        + "1. Metric (kg, m)\n"
        + "2. Imperial (lbs, in)\n"
        + "Please select either option 1 or option 2");
        if(scan.hasNextInt()){
            choice = scan.nextInt();
            if(choice == 1 || choice == 2 ){
                break;
            }else{
                System.out.println("Invalid choice. Please enter either 1 or 2");
                }
       }else{
        System.out.println("Invalid input. Please enter a number.");
        scan.next();
    }
    }
     return choice;

}
     public static double getValidInput(Scanner scan, String prompt, double min, double max){
     double value;
    
     while(true){
        System.out.println(prompt);
        
        if(scan.hasNextDouble()){
            value = scan.nextDouble();
            if(value >= min && value <= max){
                break;
            }else{
                System.out.println("Please enter a value between %.1f and %.1f.\n" + min + max);
            }
        }else{
            System.out.println("Invalid input. Please enter a value");
            scan.next();
        }
    }
    
    return value;
}

    public static double calculateBmi(int unitChoice, double weight, double height){
    double totalBmi;
    if(unitChoice == 1){
        totalBmi = weight/(height * height);
    }else{
        totalBmi = ((703 * weight) / (height * height));
    }
     return totalBmi;
}
    public static String getBmiCategory(double bmi){
		if(bmi<18.5){
			return "Underweight";
		}else if(bmi<25){
			return "Normal weight";
		}else if(bmi<30){
			return "Overweight";
		}else if(bmi<35){
			return "Obese";
		}else{
			return "Severely Obese";
		}
} 
 
    public static void printReport(String name, double bmi, String category){
    System.out.println("\n===== REPORT =====");
    System.out.println("Name: " + name);
    System.out.printf("BMI: %.2f%n", bmi);
    System.out.println("Category: " + category);
    System.out.print("Health advice :" + name + ",");
    
    if(bmi < 18.5){
        System.out.println("Increase calorie intake and follow a balanced diet.");
    }else if(bmi < 25){
        System.out.println("You are in the right range,Maintain your current lifestyle.");
    }else if(bmi < 30){
        System.out.println("Consider Exercise and improve diet.");
    }else{
        System.out.println("Seek medical advice.");
    }
    System.out.println("======================================================\n");
  }
}
