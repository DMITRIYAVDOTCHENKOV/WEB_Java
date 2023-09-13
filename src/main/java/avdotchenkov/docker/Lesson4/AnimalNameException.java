package avdotchenkov.docker.Lesson4;

public class AnimalNameException extends Exception{

    private final String name;

    public String getName() {
        return name;
    }

    public AnimalNameException(String message, String name) {
        super(message);
        this.name = name;
    }
}
