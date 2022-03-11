package xh.app.collection;

public class Movie {
    private String name;
    private String author;
    private double score;

    public Movie() {
    }

    public Movie(String name, String author, double score) {
        this.name = name;
        this.author = author;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", score=" + score +
                '}';
    }

}
