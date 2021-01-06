package com.backend.Ex1_Collection;

import com.entity.Student;

import java.util.*;

public class Ex1_Question1 {
    private ArrayList<Student> students;
    private Scanner scanner;

    public Ex1_Question1() {
        scanner = new Scanner(System.in);
        students = new ArrayList<>();
        createStudent();
    }

    public void createStudent() {
//        System.out.println("Bạn muốn nhập bao nhiêu học sinh ?");
//        int count = scanner.nextInt();
//        for (int i = 0; i < count; i++){
//            students.add(new Student());
//        }

        students.add(new Student("Kim"));
        students.add(new Student("Mộc"));
        students.add(new Student("Kim"));
        students.add(new Student("Hỏa"));
        students.add(new Student("Mộc"));
    }

    public void printStudent() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // a) in ra tổng số phần tử của Students
    public void sentenceA() {
        System.out.println("Số student = " + students.size());
    }

    // b) get ra phần tử thứ 4
    public void sentenceB() {
        System.out.println("Phần tử thứ 4 = " + students.get(3).toString());
    }

    // c) get ra phần tử đầu và cuối mảng
    public void sentenceC() {
        System.out.println("Phần tử đầu tiên = " + students.get(0).toString());
        System.out.println("Phần tử cuối cùng = " + students.get(students.size() - 1).toString());
    }

    // d) Thêm 1 phần tử vào vị trí đầu của students
    public void sentenceD() {
        students.add(0, new Student());
        System.out.println("Danh sách sau khi thêm mới: ");
        printStudent();
    }

    // e) Thêm 1 phần tử vào vị trí cuối
    public void sentenceE() {
        students.add(students.size(), new Student());
        System.out.println("Danh sách sau khi thêm mới: ");
        printStudent();
    }

    // f) Đảo ngược vị trí của students
    public void sentenceF() {
        Collections.reverse(students);
        System.out.println("Danh sách Students sau khi đảo ngược: ");
        printStudent();
    }

    // g) Tạo method tìm kiếm Student theo ID
    public void sentenceG() {
        System.out.println("Mời nhập id cần tìm: ");
        int id = scanner.nextInt();
        if (id > students.size() || id < 1) {
            System.out.println("Vị trí không hợp lệ");
        } else {
            System.out.println("Kết quả tìm kiếm: ");
            System.out.println(students.get(id - 1).toString());
        }
    }

    // h) Tạo method tìm kiếm theo Tên
    public void sentenceH() {
        System.out.println("Mời nhập tên cần tìm: ");
        String s = scanner.nextLine();
        for (Student student : students) {
            if (student.getName().equals(s)) {
                System.out.println("Tìm kiếm thành công: ");
                System.out.println(student.toString());
                return;
            }
        }
        System.out.println("Không có tên trong danh sách!");
    }

    // i) Tạo method in ra các student có trùng tên
    public void sentenceI() {
        for (int i = 0; i < students.size(); i++) {
            for (int j = i + 1; j < students.size(); j++) {
                // So sánh tên của student
                if (students.get(i).getName().equals(students.get(j).getName())) {
                    System.out.println("Các student trùng tên: ");
                    System.out.println(students.get(i));
                    System.out.println(students.get(j));
                }
            }
        }
    }

    // j) Xóa name của student có id = 2
    public void sentenceJ() {
        students.get(1).setName(null);
        System.out.println("Danh sách student sau khi xóa name id 2: ");
        printStudent();
    }

    // k) delete student có id = 5
    public void sentenceK() {
        for (Student student : students) {
            if (student.getId()==5) {
                students.remove(student.getId());
            }
        }
        students.remove(4);
        System.out.println("Danh sách sau khi xóa student có id = 5: ");
        printStudent();
    }

    // l) Tạo students copy:
    public void sentenceL() {
        List<Student> studentCopies = new ArrayList<>();
        //Copy nhanh List
        studentCopies.addAll(students);
    }
}
