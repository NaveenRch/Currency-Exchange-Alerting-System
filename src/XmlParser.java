
import java.util.*;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.io.File;

public class XmlParser extends TimerTask {

	public void run() {

		NodeList nodes = toGetNodeList();
		if (nodes == null)
			System.exit(0);
		else {
			for (int i = 0; i < nodes.getLength(); i++) {
				Node elemNode = nodes.item(i);
				Element elem = (Element) elemNode;

				if (elemNode.getNodeType() == Node.ELEMENT_NODE) {

					if (UserInput.currencyPair.equalsIgnoreCase(elem.getAttribute("Symbol"))) {
						if (Float.parseFloat(
								elem.getElementsByTagName("Bid").item(0).getTextContent()) > UserInput.targetRate) {
							System.out.println("Entered Target Rate is " + UserInput.targetRate
									+ ", which is less than Current Rate : "
									+ elem.getElementsByTagName("Bid").item(0).getTextContent());

						} else if (Float.parseFloat(
								elem.getElementsByTagName("Bid").item(0).getTextContent()) == UserInput.targetRate) {
							System.out.println("***Alert*** Entered Target Rate is " + UserInput.targetRate
									+ ", equal to Current Rate : "
									+ elem.getElementsByTagName("Bid").item(0).getTextContent() + " ***Alert***");
							System.exit(0);

						} else if (Float.parseFloat(
								elem.getElementsByTagName("Bid").item(0).getTextContent()) < UserInput.targetRate) {
							System.out.println(
									"Entered Target Rate is " + UserInput.targetRate + ", more than the Current Rate : "
											+ elem.getElementsByTagName("Bid").item(0).getTextContent());

						}
					}
				}
			}

		}
	}

	public boolean xmlSymb() {
		Boolean b = false;

		NodeList nodes = toGetNodeList();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node elemNode = nodes.item(i);
			Element elem = (Element) elemNode;
			if (elem.getAttribute("Symbol").equalsIgnoreCase(UserInput.currencyPair)) {
				b = true;
				break;
			}

		}
		return b;

	}

	private NodeList toGetNodeList() {
		try {
			saveLocalXmlFile.saveXmlToLocal();
			Document localDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(new File(Alerter.localFile));
			localDoc.getDocumentElement().normalize();
			NodeList nodes = localDoc.getElementsByTagName("Rate");
			return nodes;
		} catch (Exception e) {
			System.out.println("Cannot Parse the XML File");
			return null;
		}

	}
}
