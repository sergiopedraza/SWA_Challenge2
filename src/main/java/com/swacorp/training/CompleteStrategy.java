/*
 * @(#)CompleteStrategy.java
 *
 * Copyright (c) 2016 Southwest Airlines, Co.
 * 2702 Love Field Drive, Dallas, TX 75235, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Southwest Airlines, Co.
 */
package com.swacorp.training;


public class CompleteStrategy extends AbstractResponseTypeStrategy {

   public CompleteStrategy(String status, String message) {
      super(status, message);
   }

   @Override
   public StrategyResult decode() {
      StrategyResult result = new StrategyResult();
      result.setResponseDescription("");
      result.setResponseType("SUCCESSFUL");

      return result;
   }

   @Override
   public boolean isImplementable() {
      return getStatus().equals("COMPLETE");
   }

}
