/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingsystem_assignment1;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

/**
 *
 * @author May tinh Duy Toi
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    //Table 1:Department
        Department dep1 = new Department();
        dep1.id=1;
        dep1.departmantName= "Sale";
        
        Department dep2 = new Department();
        dep2.id=2;
        dep2.departmantName= "Marketing";
        
        Department dep3 = new Department();
        dep3.id=3;
        dep3.departmantName= "IT";

    //Table 2: Position
        Position po1 = new Position();
        po1.id=1;
        po1.positionName=PositionName.DEV;
        
        Position po2 = new Position();
        po2.id=2;
        po2.positionName=PositionName.TEST;

        Position po3 = new Position();
        po3.id=3;
        po3.positionName=PositionName.SCRUM_MASTER;
        
        Position po4 = new Position();
        po4.id=4;
        po4.positionName=PositionName.PM;
        
    //Table 3: Account
        Account acc1 = new Account();
        acc1.id=1;
        acc1.email="nchinh407@gmail.com";
        acc1.userName="nchinh407";
        acc1.fullName="Nguyen Thi Chinh";
        acc1.department= dep1;
        acc1.position=po2;
        acc1.createDate= LocalDate.now();
        
        Account acc2 = new Account();
        acc2.id=2;
        acc2.email="mailan055@gmail.com";
        acc2.userName="mailan";
        acc2.fullName="Nguyen Mai Lan";
        acc2.department= dep1;
        acc2.position=po2;
        acc2.createDate= LocalDate.of(2020, 12, 11);
        
        Account acc3 = new Account();
        acc3.id=3;
        acc3.email="anhtu@gmail.com";
        acc3.userName="Anhtu";
        acc3.fullName="Ha Anh Tu";
        acc3.department= dep2;
        acc3.position=po3; 
        acc3.createDate= LocalDate.of(2020, 12, 11);
            

    //Table 4: Group
        Group group1= new Group();
        group1.id=1;
        group1.groupName="Frontend";
        group1.creator=acc2;
        group1.createDate=LocalDate.now();
        
        Group group2= new Group();
        group2.id=2;
        group2.groupName="Backend";
        group2.creator=acc2;
        group2.createDate=LocalDate.now();

        
        Group group3= new Group();
        group3.id=3;
        group3.groupName="Frontend";
        group3.creator=acc2;
        group3.createDate=LocalDate.now();

        Group[] groupAcc1 ={group1, group3};
        acc1.groups=groupAcc1;
        
        Group[] groupAcc2 ={group2, group3};
        acc2.groups=groupAcc2;
        
        Group[] groupAcc3 ={group1, group2, group3};
        acc3.groups=groupAcc3;
        
        Account[] AccGroup1 ={acc1, acc3};
        group1.accounts=AccGroup1;
        
        Account[] AccGroup2 ={acc2, acc3};
        group2.accounts=AccGroup2;
        
        Account[] AccGroup3 ={acc1, acc2, acc3};
        group3.accounts=AccGroup3;


    //Table 5: TypeQuestion
        TypeQuestion typeQ1=new TypeQuestion();
        typeQ1.id=1;
        typeQ1.typeName=TypeName.ESSAY;
        
        TypeQuestion typeQ2=new TypeQuestion();
        typeQ2.id=2;
        typeQ2.typeName=TypeName.MULTIPLE_CHOICE;
       

    //Table 6: CategoryQuestion
        CategoryQuestion cateGoryQ1=new CategoryQuestion();
        cateGoryQ1.id=1;
        cateGoryQ1.categoryName="SQL";
        
        CategoryQuestion cateGoryQ2=new CategoryQuestion();
        cateGoryQ2.id=2;
        cateGoryQ2.categoryName="Java";
        
        CategoryQuestion cateGoryQ3=new CategoryQuestion();
        cateGoryQ3.id=3;
        cateGoryQ3.categoryName="React";

    //Table 7: Question
        Question q1=new Question();
        q1.id=1;
        q1.content="SQL la gi";
        q1.categoryQuestion=cateGoryQ1;
        q1.typeQuestion=typeQ2;
        q1.account=acc1;
        q1.createDate=LocalDate.now();
        
        Question q2=new Question();
        q2.id=2;
        q2.content="JAVA la gi";
        q2.categoryQuestion=cateGoryQ2;
        q2.typeQuestion=typeQ2;
        q2.account=acc1;
        q2.createDate=LocalDate.now();
        
        Question q3=new Question();
        q3.id=3;
        q3.content="React la gi";
        q3.categoryQuestion=cateGoryQ3;
        q3.typeQuestion=typeQ1;
        q3.account=acc1;
        q3.createDate=LocalDate.now();
  

    //Table 8: Answer
        Answer a1=new Answer();
        a1.id=1;
        a1.content="SQL la ngon ngu chung de truy cap vao co so du lieu";
        a1.question=q1;
        a1.isCorrect=true;
        
        Answer a2=new Answer();
        a2.id=2;
        a2.content="Java la ngon ngu chung de truy cap vao co so du lieu";
        a2.question=q2;
        a2.isCorrect=false;
        
        Answer a3=new Answer();
        a3.id=3;
        a3.content="SQL la ngon ngu chung de truy cap vao co so du lieu";
        a3.question=q3;
        a3.isCorrect=false;
        
        
    //Table 9: Exam
        Exam e1=new Exam();
        e1.id=1;
        e1.code="44gg";
        e1.title="Thi thu lan 1";
        e1.categoryQuestion=cateGoryQ1;
        e1.account=acc1;
        e1.creatDate=LocalDate.now();
        e1.duration=60;
        
        Exam e2=new Exam();
        e2.id=2;
        e2.code="47gg";
        e2.title="Thi thu lan 2";
        e2.categoryQuestion=cateGoryQ2;
        e2.account=acc3;
        e2.creatDate=LocalDate.now();
        e2.duration=90;
        
        Exam e3=new Exam();
        e3.id=3;
        e3.code="49gg";
        e3.title="Thi thu lan 3";
        e3.categoryQuestion=cateGoryQ2;
        e3.account=acc3;
        e3.creatDate=LocalDate.now();
        e3.duration=120;
    
        Question[] questionsOfExam1= {q1,q2,q3};
        e1.questions=questionsOfExam1;
        
        Question[] questionsOfExam2= {q2,q3};
        e2.questions=questionsOfExam2;
        
        Question[] questionsOfExam3= {q1,q2};
        e3.questions=questionsOfExam3;
        
        Exam[] examsOfQ1={e1,e3};
        q1.exams=examsOfQ1;
        
        Exam[] examsOfQ2={e1,e2,e3};
        q2.exams=examsOfQ2;
        
        Exam[] examsOfQ3={e1,e2};
        q3.exams=examsOfQ3;
        
        
        
//        Print Object
        //Table 1:Department
        System.out.println("Department ID 2: "+dep1.id);
        System.out.println("Department Name: "+dep1.departmantName);
        System.out.println("Department ID 2: "+dep2.id);
        System.out.println("Department Name: "+dep2.departmantName);
        System.out.println("Department ID 3: "+dep3.id);
        System.out.println("Department Name: "+dep3.departmantName);
        System.out.println("\n");
        
        //Table 2: Position
        System.out.println("Position ID 1: "+po1.id);
        System.out.println("Position Name: "+po1.positionName);
        System.out.println("\n");
        
        //Table 3: Account
        System.out.println("Account ID 1: "+acc1.id);
        System.out.println("Email: "+acc1.email);
        System.out.println("Full Name: "+acc1.fullName);
        System.out.println("Department Name: "+acc1.department.departmantName);
        System.out.println("Position Name: "+acc1.position.positionName);
        System.out.println("Create date: "+acc1.createDate);
        System.out.println("Groups of Account1: ");
        for(int i=0;i<acc1.groups.length;i++){
            System.out.println(acc1.groups[i].groupName);
        }
        System.out.println("\n");
        
        //Table 4: Group
        System.out.println("Group ID 1: "+group1.id);
        System.out.println("Group Name: "+group1.groupName);
        System.out.println("Creator: "+group1.creator);
        System.out.println("Create Date: "+group1.createDate);
        System.out.println("Accounts of group1: ");
        for(int i=0;i<group1.accounts.length;i++){
            System.out.println(group1.accounts[i].fullName);
        }
        System.out.println("\n");
        //Table 5: TypeQuestion
        System.out.println("Type ID 1: "+typeQ1.id);
        System.out.println("TypeQuestion Name: "+typeQ1.typeName);
        System.out.println("\n");
        
        //Table 6: CategoryQuestion
        System.out.println("categoryQ ID 2: "+cateGoryQ2.id);
        System.out.println("categoryQ Name: "+cateGoryQ2.categoryName);
        System.out.println("\n");
        
        //Table 7: Question
        System.out.println("Question ID 3: "+q3.id);
        System.out.println("Content : "+q3.content);
        System.out.println("category Question : "+q3.categoryQuestion.categoryName);
        System.out.println("typeQuestion : "+q3.typeQuestion.typeName);
        System.out.println("Account create : "+q3.account.fullName);
        System.out.println("Create date : "+q3.createDate);
        System.out.println("Exams of Question : ");
        for(int i=0;i<q3.exams.length;i++){
            System.out.println(q3.exams[i].title);
        }       
        System.out.println("\n");
        
        //Table 8: Answer
        System.out.println("Answer id 3: "+a3.id);
        System.out.println("Content: "+a3.content);
        System.out.println("Question: "+a3.question.content);
        System.out.println("is Correct: "+a3.isCorrect);
        System.out.println("\n");
        
        //Table 9: Exam
        System.out.println("Exam id 1: "+e1.id);
        System.out.println("title : "+e1.title);
        System.out.println("duration : "+e1.duration);
        System.out.println("creatDate : "+e1.creatDate);
        System.out.println("Questions of exam : ");
        for(int i=0;i<e1.questions.length;i++){
            System.out.println(e1.questions[i].content);
        }
        
    }
}
