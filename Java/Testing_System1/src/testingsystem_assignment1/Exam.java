/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingsystem_assignment1;

import java.time.LocalDate;



public class Exam {
    int                 id;
    String              code;
    String              title;
    CategoryQuestion    categoryQuestion;
    int                 duration;
    Account             account;
    LocalDate                creatDate;
    Question[]          questions;
}
