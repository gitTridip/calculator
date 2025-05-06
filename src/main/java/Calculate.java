package main.java;

import java.util.LinkedList;

public class Calculate {
	static LinkedList<String> dataStore;
	static String evaluateExpression(LinkedList<String> data) throws PopupException{
		dataStore=data;
		for(int i=0;i<=1;i++) {
			for(int j=0;j<data.size();j++) {
				String operator=data.get(j);
				if(i==0 && operator.length()==1 && (operator.contains("/") || operator.contains("*") || operator.contains("%"))) {
					char op=operator.charAt(0);
					switch(op) {
					case '%':
						modulo(j);
						j=-1;
						break;
					case '/':
						divide(j);
						j=-1;
						break;
					case '*':
						multiply(j);
						j=-1;
						break;
					}
				}
				else if(i==1 && operator.length()==1 && (operator.contains("+") || operator.contains("-"))) {
					char op=operator.charAt(0);
					switch(op) {
					case '+':
						plus(j);
						j=-1;
						break;
					case '-':
						minus(j);
						j=-1;
						break;
					}
				}
			}
		}
		
		double result = Double.parseDouble(dataStore.get(0));
		if (result % 1 == 0) {
		    return Integer.toString((int) result);
		}
		return Double.toString(result);
			
    }
	
	static void modulo(int j) {
		double num1=Double.parseDouble(dataStore.get(j-1));
		double num2=Double.parseDouble(dataStore.get(j+1));
		if(num2==0) 
			dataStore.set(j-1, "0");
		else
			dataStore.set(j-1, num1%num2+"");
		
		dataStore.remove(j + 1);
		dataStore.remove(j);

	}
	static void divide(int j) throws PopupException {
		double num1=Double.parseDouble(dataStore.get(j-1));
		double num2=Double.parseDouble(dataStore.get(j+1));
		if(num2==0) 
			throw new PopupException("Error: divisible by zero");
		else
			dataStore.set(j-1, num1/num2+"");
		
		dataStore.remove(j + 1);
		dataStore.remove(j);

	}
	static void multiply(int j) {
		double num1=Double.parseDouble(dataStore.get(j-1));
		double num2=Double.parseDouble(dataStore.get(j+1));
		dataStore.set(j-1, num1*num2+"");
		dataStore.remove(j + 1);
		dataStore.remove(j);
	}
	static void plus(int j) {
		double num1=Double.parseDouble(dataStore.get(j-1));
		double num2=Double.parseDouble(dataStore.get(j+1));
		dataStore.set(j-1, num1+num2+"");
		dataStore.remove(j + 1);
		dataStore.remove(j);
	}
	static void minus(int j) {
		double num1=Double.parseDouble(dataStore.get(j-1));
		double num2=Double.parseDouble(dataStore.get(j+1));
		dataStore.set(j-1, num1-num2+"");
		dataStore.remove(j + 1);
		dataStore.remove(j);
	}
}
