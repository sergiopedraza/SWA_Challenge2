/*
 * @(#)StrategySolver.java
 *
 * Copyright (c) 2016 Southwest Airlines, Co.
 * 2702 Love Field Drive, Dallas, TX 75235, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Southwest Airlines, Co.
 */
package com.swacorp.training;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class StrategySolver {

   private final String status;
   
   private final String message;
   

   public StrategySolver(final String status, final String message) {
	   
	   this.status = status;
	   this.message = message;
   }

   public StrategyResult messageDecode() {
	   
	   return  getResponseStrategy();

   }

	private StrategyResult getResponseStrategy() {

		AbstractResponseTypeStrategy strategy = null;
			
		if(status.equals("COMPLETE")){
			strategy = new CompleteStrategy(status, message);
		}
		else{
			String fline = StringUtils.substringBefore(message, "\n");
			if(StringUtils.substringAfterLast(fline, ":").trim().equals(ServerErrorStrategy.ERROR_NOT_MESSAGE)
		            || fline.trim().equals(ServerErrorStrategy.ERROR_NOT_MESSAGE) 
		            || status.equals(ServerErrorStrategy.SERVER_ERROR)){
				
				strategy = new ServerErrorStrategy(status, message);
			}
			
		}
		
		return strategy.decode();
	}

	
}
