/*
 * @(#)BadRequestStrategy.java
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

public class BadRequestStrategy extends AbstractResponseTypeStrategy {

   public BadRequestStrategy(String status, String message) {
      super(status, message);
   }

//   @Override
   public StrategyResult decode() {
      StrategyResult result = new StrategyResult();

      result.setResponseDescription(getMessage());
      result.setResponseType("BAD_REQUEST_ERROR");

      return result;
   }

//   @Override
   public boolean isImplementable() {
      String fline = StringUtils.substringBefore(getMessage(), "\n");
      return (fline.contains("xpath=null") && fline.contains("java.lang.NullPointerException"));
   }

}
