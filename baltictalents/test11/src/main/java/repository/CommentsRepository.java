package repository;



import model.Comment;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class CommentsRepository extends SQLRepository {

    private PreparedStatement findByIdQuery;

    public CommentsRepository(Connection connection) throws SQLException {
        super(connection);
        this.findByIdQuery = connection
                .prepareStatement("select * from comments where id = ?");
    }

    public List<Comment> find() throws SQLException {

        String query = "select * from comments";

        ResultSet resultSet = getConnection()
                .prepareStatement(query)
                .executeQuery();

        List<Comment> comments = new ArrayList<>();
        while (resultSet.next()) {
            comments.add(resultSetToComment(resultSet));
        }
        return comments;
    }

    public Optional<Comment> findById(Integer findId) throws SQLException {

        findByIdQuery.setInt(1, findId);
        ResultSet resultSet = findByIdQuery.executeQuery();
        return resultSet.next() ? Optional.of(resultSetToComment(resultSet)) : Optional.empty();
    }

    public Map<Integer, Integer> countByUsers() throws SQLException {
        String query = "select userId, count(*) c from comments group by userId";


        ResultSet resultSet = getConnection()
                .prepareStatement(query)
                .executeQuery();

        Map<Integer, Integer> countByUserId = new HashMap<>();
        while (resultSet.next()) {
            Integer userId = resultSet.getObject("userId") == null ? null : resultSet.getInt("c");
            Integer count = resultSet.getInt("c");
            countByUserId.put(userId, count);
        }
        return countByUserId;
    }

    public Integer countByUserId(Integer userId) throws SQLException {
        String query = "select count(*) from comments where userId = ?";

        PreparedStatement preparedStatement = getConnection()
                .prepareStatement(query);
        preparedStatement.setInt(1, userId);

        ResultSet resultSet =  preparedStatement.executeQuery();
        return resultSet.next() ? resultSet.getInt(1) : 0;
    }

    public void save(Comment comment) throws SQLException {

        String query = "insert into comments (id, webpage, summary, comment, userId, createdOn) " +
                "values (default, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = getConnection()
                .prepareStatement(query);

        preparedStatement.setString(1, comment.getWebpage());
        preparedStatement.setString(2, comment.getSummary());
        preparedStatement.setString(3, comment.getComment());

        if (comment.getUserId().isPresent()) {
            preparedStatement.setInt(4, comment.getUserId().get());
        } else {
            preparedStatement.setNull(4, Types.INTEGER);
        }
        preparedStatement.setTimestamp(5, Timestamp.valueOf(comment.getCreatedOn()));
        preparedStatement.execute();
    }

    private Comment resultSetToComment(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String webpage = resultSet.getString("webpage");
        String summary = resultSet.getString("summary");
        String comment = resultSet.getString("comment");
        Optional<Integer> userId = resultSet.getObject("userId") == null ? Optional.empty() : Optional.of(resultSet.getInt("user_id"));
        LocalDateTime createdOn = resultSet
                .getTimestamp("createdOn")
                .toLocalDateTime();
        return new Comment(id, webpage, summary, comment, userId, createdOn);
    }
    // select username, webpage, comments from comments join users u on u.id = user_id;
}
