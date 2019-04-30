package repository;

import model.Gyventojas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GyventojasRepository extends SQLRepository {

    public GyventojasRepository(Connection connection) {
        super(connection);
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public List<Gyventojas> findAll() throws SQLException {

        String query = "select * from gyventojai";

        PreparedStatement preparedStatement = getConnection()
                .prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Gyventojas> gyventojas = new ArrayList<>();

        while (resultSet.next()) {
            gyventojas.add(resultSetToGyventojas(resultSet));
        }
        return gyventojas;
    }

    private Gyventojas resultSetToGyventojas(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String vardas= resultSet.getString("vardas");
        String pavarde= resultSet.getString("pavarde");
        java.sql.Date gimimo_metai = resultSet.getDate("gimimo_metai");;
        String gatve = resultSet.getString("gatve");
        String tautybe = resultSet.getString("tautybe");;
        return new Gyventojas(id,vardas,pavarde,gimimo_metai,gatve,tautybe);
    }
}
