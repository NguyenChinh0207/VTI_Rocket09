/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingsystem_assignment1;

import java.time.LocalDate;


public class Account {
    int             id;
    String          email;
    String          userName;
    String          fullName;
    Department      department;
    Position        position;
    LocalDate            createDate;
    Group[]         groups;//1 account co the thuoc nhieu group
}
