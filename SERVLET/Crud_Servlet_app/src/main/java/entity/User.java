package entity;

public class User {
    private String id;
    private String fullname;
    private String email;
    private Long mobile;
    private int age;
    private String password;
    private String gender;
    private double salary;

    public User(String id, String fullname, String email, Long mobile, int age, String password, String gender, double salary) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.mobile = mobile;
        this.age = age;
        this.password = password;
        this.gender = gender;
        this.salary = salary;
    }

    public User() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
