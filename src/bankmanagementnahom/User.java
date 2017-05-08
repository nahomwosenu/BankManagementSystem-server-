
package bankmanagementnahom;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.Icon;
public class User {
    private String username;
    private String password;
    public static enum Types{admin,customer};
    private Types type;
    private String imagePath;
    public User(String username, String password, Types type,String image) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.imagePath=image;
    }
    public static boolean addUser(String username, String password, Types type,String image){
        String query="insert into user values('"+username+"','"+password+"','"+type+"','"+image+"')";
        boolean b=DB.executeUpdate(query);
        return b;
    }
    public Types getAdmin(){
        return Types.admin;
    }
    public Types getCustomer(){
        return Types.customer;
    }
    public static User findUser(String username){
        String[] data=DB.getRow("user",4,"username='"+username+"'");
        if(data[0]!=null && !data[0].isEmpty()){
            String type=data[2];
            Types t;
            if(type.equalsIgnoreCase("admin"))
                t=Types.admin;
            else t=Types.customer;
            User user=new User(data[0],data[1],t,data[3]);
            return user;
        }
        return null;
    }
    public Icon getImageIcon(){
        Icon icon=new ImageIcon(this.imagePath);
        return icon;
    }
    public String getImagePath(){
        return this.imagePath;
    }
    public void setImagePath(String image){
        this.imagePath=image;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }
    public static boolean addUser(User u){
        
        return false;
    }
}
