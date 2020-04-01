import java.sql.*;
/*
* Импорт пакета java.sql
* Загрузка нужно драйвера в коде
* Создание соединения с базой данных
* Создание выражения для выполнения SQL запроса
* Выполнение SQL запроса и обработка результатов
* */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        //Знать наизусть что и зачем
        Connection connection = null; //хранит соединение с б.д.
        Statement statement = null; //хранит и выполняет sql запросы
        ResultSet resultSet = null; //получает результаты выполнения sql запросов

        try{

            //динамическая регистрация драйвера SQLit
            Driver driver = (Driver) Class.forName("org.sqlite.JDBC").newInstance();
            //Driver.Manager.registerDriver(driver);

            //Создание подключения к базе данны по пути, указанному в урл
            String url = "jdbc:sqlite:D:\\SQLite Expert Personal 5\\DataBases\\CarShop_3.db";
            connection = DriverManager.getConnection(url); //проверяют какую бд хотим подключить
            //и смотрит есть ли у нас драйвер а мы его сделали в 14 строке

            //Всё, что было выше - знать как отче наш

            //Подготовка SQL запроса
            String sql = "SELECT * FROM spr_Model"; //запрос примерный
            statement = connection.createStatement(); //создаем экземпляр не через нью а через креат

            //Выполнение SQL запроса
            resultSet = statement.executeQuery(sql);

            //обработка результатов
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id")+"-"+resultSet.getObject("name"));
            }

        }catch(Throwable exc){
            System.out.println("exc"+exc);
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            }catch (Exception exc){}
        }
    }
}
