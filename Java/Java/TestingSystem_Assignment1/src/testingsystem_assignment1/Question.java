/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingsystem_assignment1;

import java.time.LocalDate;
import java.util.Date;

public class Question {
   int                  id;
   String               content;
   CategoryQuestion     categoryQuestion;
   TypeQuestion         typeQuestion;
   Account              account;
   LocalDate                 createDate;
   Exam[]               exams;
}
