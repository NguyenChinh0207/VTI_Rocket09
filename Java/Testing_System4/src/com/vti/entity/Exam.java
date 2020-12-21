/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vti.entity;

import java.time.LocalDate;



public class Exam {
    private int                 id;
    private String              code;
    private String              title;
    private CategoryQuestion    categoryQuestion;
    private int                 duration;
    private Account             account;
    private LocalDate                creatDate;
    private Question[]          questions;
}
