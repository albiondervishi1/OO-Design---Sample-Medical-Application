class measurementConversion
{
	private patientFile patient = new patientFile();
	private sensors sensor = new sensors();
	
	private double heart = sensor.heartRateGenerator();
	private double temp = sensor.temperatureGenerator();
	private double bloodPressure = sensor.bloodPressureGenerator();
	private double bloodGlucose = sensor.bloodGlucoseLevelGenerator();
	
	/* Scientific conversion for Heart Rate to Calories Burned */
	private double heartRateConverter(double heartRate, int age, double weight){
		
		return(0.6309 * heartRate + 0.2017 * age + 0.09036 * weight) + 55.0969;
	}
	
	/* Scientific conversion for Body Temperature to Celsius */
	private double temperatureConverter(double bodyTemp){
		
		double celsius = bodyTemp - 32;
		celsius /= 9;
		celsius *= 5;
		
		return celsius;
	}
	
	/* Scientific conversion for Blood Pressure(kpa) to Torr */
	private double bloodPressureConverter(double bloodPressure){
		
		return(7.500615781804145 * bloodPressure);
	}
	
	
	/* Scientific conversion for Blood Glucose Level(mmoL) to mg/dl */
	private double bloodGlucoseLevelConverter(double mmoL){

		return(mmoL * 18);
	}
		
	/* Unit converter can only be generated by manual input */
	private double unitConverter(double a, double b, double rawUnits){
		
		return(a + (b * rawUnits));
	}
	
	public void convertCalculator(){
	
		System.out.println('\n' + "Please select one of the following measurement options." + '\n');
		System.out.println("1." + '\t' + "Heart Rate to Calories Burned");
		System.out.println("2." + '\t' + "Body Temperature to Celsius");
		System.out.println("3." + '\t' + "Blood Pressure(kpa) to Torr");
		System.out.println("4." + '\t' + "Blood Glucose Level(mmoL) to mg/dl");
		System.out.println("5." + '\t' + "Unit measurement" + '\n');
		
		System.out.print("Please select which sensor to convert: ");
		int choice = Console.readInt();
		
		System.out.print('\n' + "Would you like to convert measurements manually or from sensor input (m/s): ");
		char select = Console.readChar();
		
		/* If user wishes to include values generated by sensor input */
		if(select == 's')
			convertSensorCalculator(choice);
		/* If user wishes to include values generated by manual input */
		else if(select == 'm')
			convertManualCalculator(choice);
		else
			System.out.println("Invalid selection");
	}
	
	/* Conversion optionality by sensor input */
	public void convertSensorCalculator(int choice){
	
		System.out.print("Result: ");
		/* Converting heart rate to calories burned */
		if(choice == 1)
			System.out.println(heartRateConverter(heart, patient.age, patient.weight) + " Calories Burned" + '\n');
	
		/* Converting body temperature to celsius */
		else if(choice == 2)
			System.out.println(temperatureConverter(temp) + " Celsius" + '\n');
		
		/* Converting blood pressure to Torr */
		else if(choice == 3)
			System.out.println(bloodPressureConverter(bloodPressure) + " Torr" + '\n');
		
		/* Converting blood glucose level to mg/dl */
		else if(choice == 4)
			System.out.println(bloodGlucoseLevelConverter(bloodGlucose) + " mmoL" + '\n');
		
		else if(choice == 5)
			System.out.println("No sensor value - user input required..." + '\n');
		
		else
			System.out.println("Invalid input" + '\n');
	}
	
	/* Conversion optionality by manual input */
	public void convertManualCalculator(int choice){
		
		System.out.println();
		
		/* Converting heart rate to calories burned */
		if(choice == 1){
			System.out.print("Enter heart rate: ");
			double heartRate = Console.readDouble();
			
			System.out.print("Enter age: ");
			int age = Console.readInt();
			
			System.out.print("Enter weight: ");
			double weight = Console.readDouble();
			
			System.out.println("Result: " + heartRateConverter(heartRate, age, weight) + " Calories Burned" + '\n');
		}
		
		/* Converting body temperature to celsius */	
		else if(choice == 2){
			System.out.print("Enter body temperature: ");
			double temp = Console.readDouble();
			
			System.out.println("Result: " + temperatureConverter(temp) + " Celsius" + '\n');
		}
		
		/* Converting blood pressure to Torr */
		else if(choice == 3){
			System.out.print("Enter blood pressure: ");
			double bloodPressure = Console.readDouble();
			
			System.out.println("Result: " + bloodPressureConverter(bloodPressure) + " Torr" + '\n');
		}
		
		/* Converting blood glucose level to mg/dl */
		else if(choice == 4){
			System.out.print("Enter blood glucose level: ");
			double bloodGlucoseLevel = Console.readDouble();
			
			System.out.println("Result: " + bloodGlucoseLevelConverter(bloodGlucoseLevel) + " mmoL" + '\n');
		}
		
		/* Converting raw units into useful units */
		else if(choice == 5){
			System.out.print("Enter 2 values: ");
			double a = Console.readDouble();
			double b = Console.readDouble();
			
			System.out.print("Enter raw units: ");
			double rawUnits = Console.readDouble();
			
			System.out.println("Result: " + unitConverter(a, b, rawUnits) + " useful units" + '\n');
		}
		
		else
			System.out.println("Invalid input" + '\n');
	}
}