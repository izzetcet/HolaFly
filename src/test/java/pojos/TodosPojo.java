package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/*
 POJO : Plain Old Java Object

 To create POJO CLASS we need to do 5 step
 1-Create "private" variables
 2-Create all getter() and setter() methods
 3-Create constructor without parameter
 4-Create constructor with all parameter
 5-Create toString() method

 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TodosPojo {

    private int userId;
    private String title;
    private boolean completed;

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public TodosPojo() {
    }

    public TodosPojo(int userId, String title, boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "TodosPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
