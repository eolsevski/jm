package service;

import model.Comment;
import repository.CommentsRepository;

import java.util.Optional;

public class CommentsService {

    private CommentsRepository commentsRepository;

    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public void save(Comment comment) throws Exception {

        try {
            commentsRepository.save(comment);
        } catch (Exception e) {
            throw new Exception("Error while saving comment" + e.getMessage());
        }
    }

    public Optional<Comment> get(Integer id) throws Exception {

        try {
            return commentsRepository.findById(id);
        } catch (Exception e) {
            throw new Exception("Error while finding comment" + e.getMessage());
        }
    }
}
