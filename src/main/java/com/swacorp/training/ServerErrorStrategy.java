/*
 * @(#)ServerErrorStrategy.java
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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ServerErrorStrategy extends AbstractResponseTypeStrategy {

   private Logger log = LogManager.getLogger("im-ITOPS_APPENDER");
   public static final String ERROR_NOT_MESSAGE = "Could not send Message.";
   public static final String SERVER_ERROR = "EX_ERROR";

   public ServerErrorStrategy(String status, String message) {
      super(status, message);
   }

   @Override
   public StrategyResult decode() {
      StrategyResult result = new StrategyResult();
      result.setResponseDescription("SERVER_ERROR");
      result.setResponseType("SERVER_ERROR");
      log.error("SERVER_ERROR");
      return result;
   }

   @Override
   public boolean isImplementable() {
      String fline = StringUtils.substringBefore(getMessage(), "\n");
      return StringUtils.substringAfterLast(fline, ":").trim().equals(ERROR_NOT_MESSAGE)
            || fline.trim().equals(ERROR_NOT_MESSAGE) || getStatus().equals(SERVER_ERROR);
   }

}
