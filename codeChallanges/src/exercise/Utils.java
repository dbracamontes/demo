package exercise;

import java.util.HashSet;

public class Utils {
	public static HashSet<Number> setPrimos = new HashSet<>();
	public static HashSet<Number> setNoPrimos = new HashSet<>();

	public boolean isPrimo(int number) {	
		if(setPrimos.contains(number) || number == 2) {
			return true;
		}
		
		if(setNoPrimos.contains(number) || number < 2  || number % 2 == 0) {
			return false;
		}
		
		for(int i= 2; i < number; i++) {
			if( number % i == 0) {
				setNoPrimos.add(number);
				return false;
			}
			
		}
		
		setPrimos.add(number);
		return true;
	}
	
	public static void main(String[] args) {
		Utils util = new Utils();
		System.out.println("Es primo " + util.isPrimo(4));
		System.out.println("Es primo " + util.isPrimo(2));
		System.out.println("Es primo " + util.isPrimo(5));
		System.out.println("Es primo " + util.isPrimo(5));
		System.out.println("Es primo " + util.isPrimo(6));
		System.out.println("Es primo " + util.isPrimo(17));
		System.out.println("Es primo " + util.isPrimo(6));
		System.out.println("Es primo " + util.isPrimo(4));
		System.out.println("Es primo " + util.isPrimo(19));
		
	}
	
}
