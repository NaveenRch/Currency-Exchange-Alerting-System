

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
	public static String currencyPair;
	public static float targetRate;
	public static double interval;
	private static boolean d = false;

	public static void readInputs() {
		Scanner inputScan = new Scanner(System.in);
		System.out.println("Enter Currency Exchange Pair: ");
		while (true) {
			try {
				currencyPair = inputScan.nextLine();
				XmlParser x = new XmlParser();
				setD(x.xmlSymb());
				if (d == false) {
					System.out.println("Enter a Valid Currency Exchange Pair!!!");
					System.out.println("Enter Currency Exchange Pair: ");
				} else
					break;
			} catch (Exception e) {
				System.out.println("Enter a Valid Currency Exchange Pair!!!");
			}
		}
		System.out.println("Enter Target Rate: ");
		while (true) {
			try {
				targetRate = inputScan.nextFloat();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Enter a Valid Target Rate!!!");
				System.out.println("Enter Target Rate: ");
				inputScan.nextLine();
			}
		}
		while (true) {
			try {
				System.out.print("Enter the Interval for the Scheduler, in seconds: ");
				interval = inputScan.nextFloat() * 1000;
				break;
			} catch (Exception e) {
				System.out.println("Enter a Valid Time Interval!!!");
				inputScan.nextLine();
			}

		}
		inputScan.close();

	}

	public static boolean isD() {
		return d;
	}

	public static void setD(boolean d) {
		UserInput.d = d;
	}
}
