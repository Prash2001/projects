import java.io.File;
import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class dmoParser {

  public static void main(String[] args) {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    try {
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse("myinfo.xml");
      // document.getDocumentElement().normalize();
      NodeList celebritylist = document.getElementsByTagName("celebrity");
      for (int i = 0; i < celebritylist.getLength(); i++) {
        Node c = celebritylist.item(i);
        if (c.getNodeType() == Node.ELEMENT_NODE) {
          Element celebrity = (Element) c;
          System.out.println("Celebrity Type : " + celebrity.getAttribute("type"));
          NodeList name = celebrity.getChildNodes();
          for (int j = 0; j < name.getLength(); j++) {
            Node cname = name.item(j);
            if (cname.getNodeType() == Node.ELEMENT_NODE) {
              System.out.println(cname.getNodeName() + " : " + cname.getTextContent());
            }
          }

        }
      }
    } catch (ParserConfigurationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
