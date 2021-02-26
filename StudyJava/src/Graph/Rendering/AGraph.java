package Graph.Rendering;

import java.awt.*;
import java.util.Arrays;

public class AGraph implements Graph{

    String[][] graphMap;
    int maxHeight;
    int maxWidth;
    int idx = 0;

    public void render(int x1, int y1, int x2, int y2){
        maxHeight = Math.max(y1, y2);
        maxWidth = x2;
        int max = Math.max(maxHeight, maxWidth)+1;
        graphMap = new String[max][max];
        initializingArray(max);
        graphMap[max-y1][x1-1] = "🌝";
        graphMap[max-y2][x2-1] = "🌕";
        Dimension
        printGraph(max);
    }


    public void render(int x1, int y1, int x2, int y2, int x3, int y3){
        maxHeight = Math.max(Math.max(y1, y2),y3);
        maxWidth = Math.max(Math.max(x1, x2),x3);
        int max = Math.max(maxHeight, maxWidth)+1;
        graphMap = new String[max][max];
        initializingArray(max);
        graphMap[max-y1][x1-1] = "🌝";
        graphMap[max-y2][x2-1] = "🌕";
        graphMap[max-y3][x3-1] = "🌚";
        printGraph(max);
    }

    public void render(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        maxHeight = Math.max(Math.max(y1, y2),Math.max(y3,y4));
        maxWidth = Math.max(Math.max(x1, x2),Math.max(x3,x4));
        int max = Math.max(maxHeight, maxWidth);
        graphMap = new String[max][max];
        initializingArray(max);
        graphMap[max-y1][x1-1] = "🌝";
        graphMap[max-y2][x2-1] = "🌕";
        graphMap[max-y3][x3-1] = "🌚";
        graphMap[max-y4][x4-1] = "🌍";
        printGraph(max);
    }

    private void initializingArray(int size){
        for(int i = 0; i<size; i++){
            for(int j=0; j<size; j++){
                graphMap[i][j] = "";
            }
        }
    }

    private void printGraph(int max) {
        max += 1;
        for (String[] line : graphMap) {
            max--;
            System.out.println(max + "  " + Arrays.toString(line));
        }
    }
}
