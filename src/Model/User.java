package Model;

public class User {
    //创建成员变量，暂存前后端传输的数据
    private String username;
    private String password;
    //构造函数
    public User(){}
    //重写构造函数
    public User(String username,String password){
        this.username = username;
        this.password = password;
    }
    //get、set方法保证数据传输的安全性
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}
