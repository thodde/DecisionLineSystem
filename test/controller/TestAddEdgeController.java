package controller;
import java.awt.event.MouseEvent;
import view.EdgeDisplayForm;
import xml.Message;
import model.DecisionLinesEvent;
import model.Line;
import model.Model;
import junit.framework.TestCase;
public class TestAddEdgeController extends TestCase {
 
 public void setupEvent() {
  
  Model model = Model.getModel();
   
  model.myTurn = true;
  DecisionLinesEvent dle = DecisionLinesEvent.getInstance();
  
  dle.setQuestion("Why now?");
  dle.setMode("roundRobin");
  dle.setType("closed");
  dle.setRounds(2);
  dle.setNumChoices(3);
  dle.setEventID("ABC112");
  
  Line choice1 = new Line("Apple", 0);
  dle.setChoice(choice1);
  Line choice2 = new Line("Orange", 0);
  dle.setChoice(choice2);
  Line choice3 = new Line("Cherry", 0);
  dle.setChoice(choice2);
  model.connectedUsers.clear();
  model.connectedUsers.add("Bob");
  model.connectedUsers.add("Rita");
  model.connectedUsers.add("Sam");
 }

 public void testAddEdgeControllerClickAllGood() {
  setupEvent();
  Model model = Model.getModel();
  
  String expected = "<addEdgeRequest id='ABC112' left='1' right='2' height='113' />";
  
  EdgeDisplayForm edf = new EdgeDisplayForm();
  
  DecisionLinesEvent dle = DecisionLinesEvent.getInstance();
  
  AddEdgeController aec = new AddEdgeController(edf);
  
  int x = 130;
  int y = 100;
  
  MouseEvent arg = new MouseEvent(edf, 0, 0, 0, x, y, 0, false);
  
  assertTrue(aec.processMouseClick(arg));
  
  String generatedXML = aec.xmlString;
  // get XML string from public XML generator method
  String xmlStrippedMessage = "";
  // strip GUID from generated XML (varies from run to run)
  int index = generatedXML.indexOf("<a");
  if (index != -1)
  {
   xmlStrippedMessage = generatedXML.substring(index);
   index = xmlStrippedMessage.indexOf("</");
   if (index != -1)
   {
    xmlStrippedMessage = xmlStrippedMessage.substring(0, index);
   }
  }
   
 assertEquals(expected, xmlStrippedMessage);
  
 }
 
 public void testAddEdgeControllerClickNotTurn() {
  setupEvent();
  Model model = Model.getModel();
  
  model.myTurn = false;
  //model.connectedUsers.remove("Sam");
  
  EdgeDisplayForm edf = new EdgeDisplayForm();
  
  DecisionLinesEvent dle = DecisionLinesEvent.getInstance();
  
  AddEdgeController aec = new AddEdgeController(edf);
  
  int x = 130;
  int y = 100;
  
  MouseEvent arg = new MouseEvent(edf, 0, 0, 0, x, y, 0, false);
  
  assertFalse(aec.processMouseClick(arg));
 }
 
 public void testAddEdgeControllerClickMissingPlayer() {
  setupEvent();
  Model model = Model.getModel();
  
  //model.myTurn = false;
  model.connectedUsers.remove("Sam");
  
  EdgeDisplayForm edf = new EdgeDisplayForm();
  
  DecisionLinesEvent dle = DecisionLinesEvent.getInstance();
  
  AddEdgeController aec = new AddEdgeController(edf);
  
  int x = 130;
  int y = 100;
  
  MouseEvent arg = new MouseEvent(edf, 0, 0, 0, x, y, 0, false);
  
  assertFalse(aec.processMouseClick(arg));
 }
 
 public void testAddEdgeControllerClickBadYValue() {
  setupEvent();
  Model model = Model.getModel();
  
  //model.myTurn = false;
  model.connectedUsers.remove("Sam");
  
  EdgeDisplayForm edf = new EdgeDisplayForm();
  
  DecisionLinesEvent dle = DecisionLinesEvent.getInstance();
  
  AddEdgeController aec = new AddEdgeController(edf);
  
  int x = 130;
  int y = 5;
  
  MouseEvent arg = new MouseEvent(edf, 0, 0, 0, x, y, 0, false);
  
  assertFalse(aec.processMouseClick(arg));
 }
}