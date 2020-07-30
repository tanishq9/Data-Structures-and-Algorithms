public class Solution {
    public int solve(int A, int B) {
        int count=0;
        int x=A,y=B;
        // top left diagonal
        while(x>=1 && y<=8){
            x--;
            y++;
            count++;
        }
        x=A;y=B;
        // bottom right diagonal
        while(x<=8 && y>=1){
            x++;
            y--;
            count++;
        }
        x=A;y=B;
        // top right diagonal
        while(x<=8 && y<=8){
            x++;
            y++;
            count++;
        }
        x=A;y=B;
        // bottom left diagonal
        while(x>=1 && y>=1){
            x--;
            y--;
            count++;
        }
        return count-4;
    }
}
