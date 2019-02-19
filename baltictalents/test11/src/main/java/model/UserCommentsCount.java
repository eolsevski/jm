package model;

public class UserCommentsCount {

    private User user;
    private Integer count;

    public UserCommentsCount(User user, Integer count) {
        this.user = user;
        this.count = count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "UserCommentsCount{" +
                "user=" + user +
                ", count=" + count +
                '}';
    }
}
