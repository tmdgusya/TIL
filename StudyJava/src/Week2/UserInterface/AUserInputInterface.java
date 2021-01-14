package Week2.UserInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AUserInputInterface implements UserInputInterface {

    String[] inputArray;
    String userInput;

    @Override
    public String userInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLocation = br.readLine();
        return inputLocation;
    }

    @Override
    public String[] parsingLocation(String input) {
        String locationManufacturing = locationManufacturing(input);
        this.inputArray = locationManufacturing.split(" ");
        return inputArray;
    }

    @Override
    public int howManyCountOfLocations() throws IllegalAccessException {
        if(inputArray.length == 0){
            throw new IllegalAccessException("아직 좌표를 입력하지 않았습니다. 잘못된 접근입니다.");
        }
        return inputArray.length;
    }

    private String locationManufacturing(String input) {
        String one = input.replaceAll("[^0-9,)]","");
        String two = one.replaceAll("[)]"," ");
        String three = two.replaceAll("[,]", " ");
        return three;
    }
}
