package Graph.UserInterface;

import java.io.IOException;

public interface UserInputInterface {

    public String userInput() throws IOException;

    public String[] parsingLocation(String input);

    public int howManyCountOfLocations() throws IllegalAccessException;
}
