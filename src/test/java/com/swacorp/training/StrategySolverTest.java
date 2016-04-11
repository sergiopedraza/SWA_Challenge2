package com.swacorp.training;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class StrategySolverTest {
	
	private StrategySolver toTest;
	
	private static final String COMPLETE_STATUS = "COMPLETE";
	
	private static final String SUCCESSFUL_TYPE = "SUCCESSFUL"; 
	
	
  
  @Test
  public void shouldGetASuccessfulResponse(){
	  
	  String message = "Test Complete Message";
	  
	  toTest = new StrategySolver(COMPLETE_STATUS, message);
	  StrategyResult strategyResult = toTest.messageDecode();
	  
	  assertEquals("Type not expected", 
			  strategyResult.getResponseType(), 
			  SUCCESSFUL_TYPE);
  }
  
  @Test
  public void shouldGetServerErrorResponseAnalyzingMessageWithColonInFirstLine(){
	  
	  StringBuilder message = new StringBuilder("Test Complete Message");
	  message.append(" for ServerErrorStrategy");
	  message.append(":").append("   ").append(ServerErrorStrategy.ERROR_NOT_MESSAGE);
	  message.append("\n").append(" An important error message");
	  
	  
	  toTest = new StrategySolver(ServerErrorStrategy.SERVER_ERROR, message.toString());
	  StrategyResult strategyResult = toTest.messageDecode();
	  assertEquals("SERVER_ERROR", strategyResult.getResponseDescription());
  }
  
  @Test
  public void shouldGetServerErrorResponseAnalyzingMessageWithOutColonInFirstLine(){
	  
	  StringBuilder message = new StringBuilder(ServerErrorStrategy.ERROR_NOT_MESSAGE);
	  message.append("\n").append(" An important error message");
	  
	  
	  toTest = new StrategySolver(ServerErrorStrategy.SERVER_ERROR, message.toString());
	  StrategyResult strategyResult = toTest.messageDecode();
	  assertEquals("SERVER_ERROR", strategyResult.getResponseDescription());
  }
  
  @Test
  public void shouldGetServerErrorResponseAnalyzingStatus(){
	  
	  StringBuilder message = new StringBuilder(" An important error message");
	  
	  
	  toTest = new StrategySolver(ServerErrorStrategy.SERVER_ERROR, message.toString());
	  StrategyResult strategyResult = toTest.messageDecode();
	  assertEquals("SERVER_ERROR", strategyResult.getResponseType());
  }
}
