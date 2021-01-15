package entity;

public class Manager extends User{
    private int ExpInYear;

    public Manager(int id, String fullName, String email, String passWord, Role role, int expInYear) {
        super(id, fullName, email, passWord, role);
        ExpInYear = expInYear;
    }


    public int getExpInYear() {
        return ExpInYear;
    }

    public void setExpInYear(int expInYear) {
        ExpInYear = expInYear;
    }

}
