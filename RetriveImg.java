import java.io.FileOutputStream;
import java.sql.*;

public class RetrieveImg {
    public static void main(String[] args){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoproject","userid","password");

            PreparedStatement preparedStatement = con.prepareStatement("select * from imgtable");
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            Blob b = rs.getBlob(2);
            byte arr[] = new byte[(int)b.length()];
            arr = b.getBytes(1,(int)b.length());

            String  file = System.getProperty("user.dir");
            file = file+"//src//a.jpg";
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(arr);
            fileOutputStream.close();
            System.out.println("OK");
            con.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
