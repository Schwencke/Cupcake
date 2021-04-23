package business.entities;

public class User {
    private int userId;
    private int roleId;
    private String role;
    private String firstname;
    private String lastname;
    private String phoneNo;
    private int balance;
    private String email;
    private String password;

    public User() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(int userId, int roleId, String firstname, String lastname, String phoneNo, int balance, String email, String password) {
        this.userId = userId;
        this.roleId = roleId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNo = phoneNo;
        this.balance = balance;
        this.email = email;
        this.password = password;
    }

    public User(String firstname, String lastname, String phoneNo,  String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNo = phoneNo;
        this.email = email;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
