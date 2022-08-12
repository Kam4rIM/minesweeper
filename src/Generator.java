import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class Generator {

    public static int maxx;
    public static int maxy;

    private static boolean check_exists(int[] a, int[][] arr) {
        for (int[] s : arr) {
            if (Arrays.equals(a, s)) {
                return true;
            }
        }
        return false;
    }

    public static int[][] get_nearby(int x, int y) {
        if (x == 0 & y==0){
            return new int[][]{{x+1, y+1}, {x+1, y}, {x, y+1}};
        }
        else if (x == maxx & y==maxy){
            return new int[][]{{x-1, y-1}, {x-1, y}, {x, y-1}};
        }
        else if (x==maxx & y==0) {
            return new int[][]{{x, y+1}, {x-1, y+1}, {x-1, y}};
        }
        else if (x==0 & y==maxy) {
            return new int[][]{{x+1, y}, {x, y-1}, {x+1, y-1}};
        }
        else if (x==0) {
            return new int[][]{{x+1, y+1}, {x+1, y}, {x+1, y-1}, {x, y+1}, {x, y-1}};
        }
        else if (x==maxx) {
            return new int[][]{{x, y+1}, {x, y-1}, {x-1, y+1}, {x-1, y}, {x-1, y-1}};
        }
        else if (y==0) {
            return new int[][]{{x+1, y+1}, {x+1, y}, {x, y+1}, {x-1, y+1}, {x-1, y}};
        }
        else if (y==maxy) {
            return new int[][]{{x+1, y}, {x+1, y-1}, {x, y-1}, {x-1, y}, {x-1, y-1}};
        }

        else {
            return new int[][]{{x+1, y+1}, {x+1, y}, {x+1, y-1}, {x, y+1}, {x, y-1}, {x-1, y+1}, {x-1, y}, {x-1, y-1}};
        }
    }

    public static Tile[][] Generate(int Height, int Width, int Mines_amount){
        Random random = new Random();
        Tile[][] Field = new Tile[Height][Width];
        int[][] mines = new int[Mines_amount][2];
        for (int i = 0; i < Mines_amount; i++){
            int x = random.nextInt(Width);
            int y = random.nextInt(Height);
            int[] tile = {x, y};
            if (check_exists(tile, mines)) {
                i--;
            }
            else {
                mines[i][0] = x;
                mines[i][1] = y;
            }

        }

        for (int coord_y = 0; coord_y < Height; coord_y++) {
            for (int coord_x = 0; coord_x < Width; coord_x++) {
                int[] coords = {coord_x, coord_y};
                if (check_exists(coords, mines)) {
                    Field[coord_y][coord_x] = new Mine(coord_x, coord_y);
                }
                else {
                    Field[coord_y][coord_x] = new Digit(coord_x, coord_y);
                }
            }
        }

//        for (int i[] : mines){
//            for(int j: i){
//                System.out.print(j);
//                System.out.print(" ");
//            }
//            System.out.print("\n");
//        }

        for (Tile[] i : Field){
            for (Tile j : i){
                j.set_digit(Field);
            }
        }

        return Field;
    }
}
