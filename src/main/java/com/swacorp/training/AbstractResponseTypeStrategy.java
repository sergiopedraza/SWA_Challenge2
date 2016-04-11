/*
 * @(#)AbstractResponseTypeStrategy.java
 *
 * Copyright (c) 2016 Southwest Airlines, Co.
 * 2702 Love Field Drive, Dallas, TX 75235, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Southwest Airlines, Co.
 */
package com.swacorp.training;

public abstract class AbstractResponseTypeStrategy implements ResponseStrategy {

   private String message;
   private String status;

   public AbstractResponseTypeStrategy(String status, String message) {
      this.message = message;
      this.status = status;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

}
