package service;


import model.User;
import model.UserCommentsCount;
import repository.CommentsRepository;
import repository.UsersRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserService {

    private UsersRepository usersRepository;
    private CommentsRepository commentsRepository;

    public UserService(UsersRepository usersRepository, CommentsRepository commentsRepository) {
        this.usersRepository = usersRepository;
        this.commentsRepository = commentsRepository;
    }

    public void saveOrUpdate(User user) throws Exception {
        try {
            Optional<User> foundUser = usersRepository.findByUsername(user.getUsername());

            if (foundUser.isPresent()) {
                usersRepository.update(user);
            } else {
                usersRepository.save(user);
            }
        } catch (SQLException sqlException) {
            System.out.println("Failed while saving or updating user" + sqlException.getMessage());
            throw new Exception(sqlException.getMessage());
        } catch (Exception exception) {
            System.out.println("Unexpected" + exception.getMessage());
        }
    }

    public List<UserCommentsCount> getUserCommentsCount() {

        List<UserCommentsCount> userCommentsCounts = null;

        try {
            userCommentsCounts = usersRepository.findUserCommentsCount();
        } catch (SQLException sqlException) {
            System.out.println("Failed to fetch user comment counts " + sqlException.getMessage());
        } catch (Exception exception) {
            System.out.println("Unexpected" + exception.getMessage());
        }
        return userCommentsCounts;
    }
}
