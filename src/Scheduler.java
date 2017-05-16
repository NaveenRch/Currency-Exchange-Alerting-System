

import java.util.Timer;

public class Scheduler {

	public static void reps() {

		try {
			Timer timeInterval = new Timer();
			XmlParser xml = new XmlParser();
			timeInterval.schedule(xml, 0, (long) UserInput.interval);

			while (true) {
				Thread.sleep((long) UserInput.interval);
			}
		} catch (Exception e) {
			System.out.println("Error in Scheduling");
		}
	}
}
