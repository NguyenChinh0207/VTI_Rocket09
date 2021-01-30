package entity;

public class User {
    private int id;
    private String fullName;
    private String email;
    private String passWord;
    private Role role;

    public User(int id,String fullName, String email, String passWord, Role role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.passWord = passWord;
        this.role = role;
    }

    public User(String fullName, String email, String passWord, Role role) {
        this.fullName = fullName;
        this.email = email;
        this.passWord = passWord;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }



}
