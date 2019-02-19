import model.User;
import repository.CommentsRepository;
import repository.UsersRepository;
import service.UserService;

import java.sql.SQLException;

public class Main {
    MysqlConnector mysqlConnector = new MysqlConnector();
    UsersRepository usersRepository =
            new UsersRepository(mysqlConnector.getConnection());

    CommentsRepository commentsRepository =
            new CommentsRepository(mysqlConnector.getConnection());

    UserService userService = new UserService(usersRepository, commentsRepository);

    public Main() throws SQLException {
    }

    public static void main(String[]args) throws Exception {
        User user = new User(1, "u12", "borat1@email");


        Main main = new Main();
        main.
        userService.saveOrUpdate(user);
        main.
        userService.getUserCommentsCount().forEach(System.out::println);



    }


}
