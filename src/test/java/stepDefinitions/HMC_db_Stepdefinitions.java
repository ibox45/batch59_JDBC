package stepDefinitions;

import io.cucumber.java.en.Given;

import java.sql.*;


public class HMC_db_Stepdefinitions {

    String url="jdbc:sqlserver://184.168.194.58:1433;databaseName=hotelmycamp ;"+
            "user=techproed;password=P2s@rt65";
    String username="techproed";
    String password="P2s@rt65";

    Connection connection; // DATAbase 'e bağlanmamızı sağlar
    Statement statement; // query calıştırmamızı sağlıyor
    ResultSet resultSet; // query sonucunda dönen sonucu store etmemizi sağlıyor
    @Given("kullanici HMC veri tabanina baglanir")
    public void kullanici_hmc_veri_tabanina_baglanir() throws SQLException {
        connection= DriverManager.getConnection(url,username,password);
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
    @Given("kullanici {string} tablosundaki {string} verilerini alir")
    public void kullanici_tablosundaki_verilerini_alir(String table, String field) throws SQLException {
        String query ="SELECT " +field+" FROM "+ table;
        resultSet=statement.executeQuery(query);
    }
    @Given("kullanici {string} sutunundaki verileri okur")
    public void kullanici_sutunundaki_verileri_okur(String field) throws SQLException {

        //resultset iterator gibi calisir
        resultSet.first();
        System.out.println((resultSet.getString("price")));  //225.0000
        resultSet.next();  //itarator'a benzer şekilde calısır.
                            // next()'u imleci bir sonraki degerin yanına goturur
                           // bize true veya false doner.
        System.out.println((resultSet.getString("price")));  //4000.0000

        System.out.println(resultSet.next());  //true
        System.out.println((resultSet.getString("price")));   //445.0000
        //next() kullanılırken cok dikkatli olmalıyız.
        //cunku nerede olursa olsun imleci bir sonraki elemente gecirecektir.

        System.out.println("==========Liste=========");
        resultSet.absolute(0);
       // int sira=1;
        while(resultSet.next()){
            System.out.println(resultSet.getRow()+". kayit: "+(resultSet.getString("price")));
           // sira++;  sira. kayıt diyordum getRow() 'u ogrenince bu şekilde duzenledım.
        }

        //tabloda kaç satir oldugunu nasil buluruz
        resultSet.last();
        System.out.println(resultSet.getRow());


    }
}
