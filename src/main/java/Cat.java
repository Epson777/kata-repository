import java.util.Objects;

public class Cat {
    private String message;

    public Cat(String voice) {
        this.message = voice;
    }

    public Cat() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String voice) {
        this.message = voice;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "voice='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(message, cat.message);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(message);
    }
}
