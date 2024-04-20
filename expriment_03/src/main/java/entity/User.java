package entity;

public class User {
    private String userName;

    private long loginTime;

    public User(String userName, long loginTime) {
        this.userName = userName;
        this.loginTime = loginTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }
}
