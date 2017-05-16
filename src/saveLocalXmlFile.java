

import java.io.*;
import java.net.*;

public class saveLocalXmlFile {

	public static void saveXmlToLocal() {
		
		try {
			URL url = new URL(Alerter.URL);
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/5.0");
			BufferedReader buf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			File fileStatus = new File(Alerter.localFile);

			if (fileStatus.exists()) {
				fileStatus.delete();
			} else {
				fileStatus.createNewFile();
			}
			
			FileWriter writer = new FileWriter(fileStatus.getAbsoluteFile());
			BufferedWriter bufwriter = new BufferedWriter(writer);

			while ((line = buf.readLine()) != null)
				bufwriter.write(line.concat("\n"));
			bufwriter.close();
			buf.close();

		} catch (IOException e) {
			System.out.println("URL error");
		}
	}
}
