/*
 * @(#)StrategyResult.java
 *
 * Copyright (c) 2016 Southwest Airlines, Co.
 * 2702 Love Field Drive, Dallas, TX 75235, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Southwest Airlines, Co.
 */
package com.swacorp.training;


public class StrategyResult {

   private String responseType;
   private String responseDescription;

   public String getResponseType() {
      return responseType;
   }

   public void setResponseType(String responseType) {
      this.responseType = responseType;
   }

   public String getResponseDescription() {
      return responseDescription;
   }

   public void setResponseDescription(String responseDescription) {
      this.responseDescription = responseDescription;
   }

}
