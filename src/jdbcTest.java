import java.sql.*;

public class jdbcTest {
    public static void main(String[] args) {
        Connection c = null;
        Statement s = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功！");

            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8","root","ztt19971114.");
            System.out.println("连接成功，获取连接对象： "+ c);
            s = c.createStatement();
            System.out.println("获取Statement对象"+s);

            String sql = "insert into person values(1,"+"'z'"+",20)";
            s.execute(sql);
            System.out.println("执行插入语句成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (s != null)
                try {
                    s.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();

                }

            if(c != null){
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
