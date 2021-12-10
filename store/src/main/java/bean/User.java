package bean;

public class User {
    private String username;
    private String password;
    private int user_id;
    public User(){}
    public User(int user_id, String username, String password) {
        this.password = password;
        this.user_id = user_id;
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public String getUsername(){
        return username;
    }
    public int getUser_id() {
        return user_id;
    }
}
