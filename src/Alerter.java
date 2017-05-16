

public class Alerter {
	public static String localFile = "./src/money.xml";
	public static String URL = "https://rates.fxcm.com/RatesXML";

	public static void main(String args[]) {

		UserInput.readInputs();
		Scheduler.reps();
	}

}
