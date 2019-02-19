package repository;

import model.User;
import model.UserCommentsCount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepository extends SQLRepository {


    public UsersRepository(Connection connection) {
        super(connection);
    }

    public List<User> findAll() throws SQLException {

        String query = "select * from users";

        PreparedStatement preparedStatement = getConnection()
                .prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<User> users = new ArrayList<>();

        while (resultSet.next()) {
            users.add(resultSetToUser(resultSet));
        }
        return users;
    }

    public void save(User user) throws SQLException {
        String query = "insert into users (id, username, email) " +
                "values (default, ?, ?)";

        PreparedStatement preparedStatement = getConnection()
                .prepareStatement(query);

        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.execute();
    }

    public void update(User user) throws SQLException {
        String query = "update users set email = ? where id = ?";

        PreparedStatement preparedStatement = getConnection()
                .prepareStatement(query);

        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setInt(2, user.getId());
        preparedStatement.execute();
    }

    public Optional<User> findByUsername(String username) throws Exception {
        String query = "select * from users where username = ?";

        PreparedStatement preparedStatement = getConnection()
                .prepareStatement(query);
        preparedStatement.setString(1, username);

        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next() ? Optional.of(resultSetToUser(resultSet)) : Optional.empty();
    }

    public List<UserCommentsCount> findUserCommentsCount() throws Exception {
        String query = "select *, (select count(*) from comments c where c.userId = u.id) comments_count from users u";

        PreparedStatement preparedStatement = getConnection()
                .prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<UserCommentsCount> userCommentsCounts = new ArrayList<>();
        while (resultSet.next()) {
            User user = resultSetToUser(resultSet);
            Integer count = resultSet.getInt("comments_count");
            userCommentsCounts.add(new UserCommentsCount(user, count));
        }
        return userCommentsCounts;
    }

    private User resultSetToUser(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String email = resultSet.getString("email");
        return new User(id, username, email);
    }
}
