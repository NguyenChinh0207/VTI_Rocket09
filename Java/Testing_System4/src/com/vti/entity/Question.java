/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vti.entity;

import java.time.LocalDate;


public class Question {
   private int                  id;
   private String               content;
   private CategoryQuestion     categoryQuestion;
   private TypeQuestion         typeQuestion;
   private Account              account;
   private LocalDate            createDate;
   private Exam[]               exams;
}
