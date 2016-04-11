/*
 * @(#)BunisessExceptionStrategy.java
 *
 * Copyright (c) 2016 Southwest Airlines, Co.
 * 2702 Love Field Drive, Dallas, TX 75235, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Southwest Airlines, Co.
 */
package com.swacorp.training;

import org.apache.commons.lang3.StringUtils;

public class BunisessExceptionStrategy extends AbstractResponseTypeStrategy {

   public BunisessExceptionStrategy(String status, String message) {
      super(status, message);
   }

   @Override
   public StrategyResult decode() {

      StrategyResult result = new StrategyResult();

      int points = getMessage().indexOf(":");
      int comma = getMessage().indexOf(",");

      if (points > comma) {
         result.setResponseDescription(getMessage());
         result.setResponseType("BUSINESS_ERROR");
      } else {
         result.setResponseDescription(getMessage().substring(points, comma));
         result.setResponseType("BUSINESS_ERROR");
      }
      return result;
   }

   @Override
   public boolean isImplementable() {
      return StringUtils.substringBefore(getMessage(), "\n").contains("Errors");
   }

}
