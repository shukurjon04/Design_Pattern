package singleton;

import java.sql.*;

public class DatabaseConnection {

    private static volatile DatabaseConnection databaseConnection;

    private Connection connection;

    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "postgres";
    private static final String password =  "root";

    private DatabaseConnection(){
        try {
            this.connection = DriverManager.getConnection(url,username,password);
            System.out.println("database connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DatabaseConnection getInstance(){
        if (databaseConnection==null){
            synchronized (DatabaseConnection.class){
                if (databaseConnection==null){
                    databaseConnection = new DatabaseConnection();
                }
            }
        }
        return databaseConnection;
    }

    public void saveTransaction(String cardNumber, double amount, String status){
        String sql = """
                insert into tranzaction(card_number,amount,status)
                values(?,?,?)
                """;

        try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,cardNumber);
            ps.setDouble(2,amount);
            ps.setString(3,status);
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()){
                System.out.println("Tranzaksiya saqlandi! "+generatedKeys.getLong("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existsTransaction(Long id){
        String sql = "select count(*) from tranzaction where id = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1,id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                return resultSet.getInt(1)>0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public void updateStatus(Long id,String status){
        String sql = "update tranzaction set status = ? where id =?";
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1,status);
            ps.setLong(2,id);
            ps.executeUpdate();
            System.out.println("DB status yangilandi "+id+" -> "+status);
        } catch (SQLException e) {
            System.out.println("xatolik yuz berdi statusni yangilash jarayonida!");
            throw new RuntimeException(e);
        }
    }
    public void close(){
        try {
            if (connection!=null&& !connection.isClosed()){
                connection.close();
                System.out.println("DB ulanish yopildi ! ");
            }
        } catch (SQLException e) {
            System.out.println("DB yopilishida hatolik yuz berdi!!!!");
            throw new RuntimeException(e);
        }
    }


}
