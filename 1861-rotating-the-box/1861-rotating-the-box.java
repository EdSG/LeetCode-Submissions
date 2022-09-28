class Solution {
    public char[][] rotateTheBox(char[][] box) {
        char[][] rotatedBox = new char[box[0].length][box.length];
        
        for (int i = 0 ; i < box.length ; i++) {
            for (int j = 0 ; j < box[0].length ; j++) {
                rotatedBox[j][box.length - 1 - i] = box[i][j];
            }
        }
        
        for (int col = 0 ; col < rotatedBox[0].length ; col++) {
            int bottom = rotatedBox.length - 1;
            int curPos = bottom;
            
            while (curPos >= 0) {
                if (rotatedBox[curPos][col] == '*') {
                    while (curPos >= 0 && rotatedBox[curPos][col] != '.') {
                       bottom = --curPos;
                    }
                }
                
                if (curPos >= 0 && rotatedBox[curPos][col] == '#') {
                   if (rotatedBox[bottom][col] == '.') {
                       rotatedBox[bottom][col] = '#';
                       rotatedBox[curPos][col] = '.';
                   } else {
                       curPos--;
                   }
                   bottom--;
                }
                
                while (curPos >= 0 && rotatedBox[curPos][col] == '.') {
                    curPos--;
                }
            }
        }
        
        return rotatedBox;
    }
}