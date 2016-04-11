package com.swacorp.training;


public class ClientDemo {

	public static void main(String ...args){
		   StrategySolver solver = new StrategySolver("COMPLETE", "sOME MESSAGE");
	       StrategyResult result = solver.messageDecode();
	       System.out.println("1. " + result.getResponseType());
	       System.out.println("2. " + result.getResponseDescription());
	}
}
