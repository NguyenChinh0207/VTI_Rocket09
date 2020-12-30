package com.entity.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileManager {
    public boolean isFileExists(String pathFile){
        File file=new File(pathFile);
        System.out.println(file.exists()?"File is exists":"File is not exists");
        return false;

    }
    public void createNewFile(String pathFile) throws Exception {
        if (isFileExists(pathFile)) {
            throw new Exception("Error! File Exist.");
        }
        else{
            File file =new File(pathFile);
            if(file.createNewFile())
                System.out.println("Create successfully!");
            else
                System.out.println("create fail!");
        }

    }
    public void createNewFile(String path, String fileName) throws Exception {
        String pathFile = path + "\\" + fileName;
        createNewFile(pathFile);

    }
    public void deleteFile(String pathFile) throws Exception {
        if(!isFileExists(pathFile))
            throw new Exception("Error! File Not Exist.");
        else{
            File file =new File(pathFile);
            if(file.delete())
                System.out.println("Delete successfully!");
            else
                System.out.println("Delete fail!");
        }
    }
    public boolean isFolder(String path){
        File file =new File(path);
        System.out.println(file.isDirectory()?"Path is folder":"path is file");
        return false;
    }
    public void getAllFileName(String path) {
        File file = new File(path);
        if(isFolder(path)){
            for(String fileName:file.list()){
                System.out.println(fileName);
            }
        }
    }
    public void copyFile(String sourceFile, String distinationPath, String newName){

    }
    public void copyFile(String sourceFile, String newPath){

    }
    public void moveFile(String sourceFile,String destinationPath) throws IOException {
//        if (!isFileExists(sourceFile)) {
//            throw new Exception("Error! File Not Exist.");
//        }
        File file = new File(sourceFile);
        File dest = new File(destinationPath);

        Files.move(file.toPath(), dest.toPath());

    }
    public void renameFile(String pathFile, String newName) throws Exception {

            if (!isFileExists(pathFile)) {
                throw new Exception("error!File is not exists");
            }
            if (isFileExists(newName)) {
                throw new Exception("error! name is exists");
            }
            File oldNameFile = new File(pathFile);
            File newNameFile = new File(newName);

            oldNameFile.renameTo(newNameFile);

    }
    public static boolean isFolderExists(String pathFolder) {
        return new File(pathFolder).exists() ? true : false;
    }

    public void createNewFolder(String newPathFolder) throws Exception {
        if (isFolderExists(newPathFolder)) {
            throw new Exception("Error! Folder Exist.");
        }

        new File(newPathFolder).mkdir();

    }


    public void Question1(){
        isFileExists("C:\\Users\\May tinh Duy Toi\\Documents\\in1.txt");
    }
    public void Question2()  {
      try{
          createNewFile("C:\\Users\\May tinh Duy Toi\\Documents\\in.txt");
          createNewFile("C:\\Users\\May tinh Duy Toi\\Documents\\FILE\\newFile.txt");
          createNewFile("C:\\Users\\May tinh Duy Toi\\Documents\\FILE","newFile2.txt");
      }
      catch(Exception e){
          System.out.println(e.getMessage());
      }

    }
    public void Question4(){
        try{
            deleteFile("C:\\Users\\May tinh Duy Toi\\Documents\\FILE\\newFile.txt");

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void Question5(){
        isFolder("C:\\Users\\May tinh Duy Toi\\Documents");
       // System.out.println(isFolder("C:\\Users\\May tinh Duy Toi\\Documents\\in.txt")?"path is Folder":"path is file");
    }
    public void Question6()  {

        getAllFileName("C:\\Users\\May tinh Duy Toi\\Documents\\FILE");

    }
    public void Question8() throws IOException {
        moveFile("C:\\Users\\May tinh Duy Toi\\Documents\\FILE\\newFile2.txt","D:\\LTHT\\dest1.txt");
    }
    public void Question9() throws Exception {

        renameFile("C:\\Users\\May tinh Duy Toi\\Documents\\FILE\\newFile1.txt","C:\\Users\\May tinh Duy Toi\\Documents\\FILE\\newFileNew.txt");

    }
    public void Question10(){
       try{
           createNewFolder("C:\\Users\\May tinh Duy Toi\\Documents\\FILE1");
       }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
    }
}
