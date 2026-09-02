class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        char dir = 'N';
        for(int i = 0; i < instructions.length(); i++) {
            if(instructions.charAt(i) == 'G') {
                if(dir == 'N') {
                    x++;
                }else if(dir == 'S') {
                    x--;
                }else if(dir == 'E') {
                    y++;
                }else {
                    y--;
                }
            }else {
                if(instructions.charAt(i) == 'L') {
                    if(dir == 'N') {
                        dir = 'W';
                    }else if(dir == 'W') {
                        dir = 'S';
                    }else if(dir == 'S') {
                        dir = 'E';
                    }else {
                        dir = 'N';
                    }
                }else {
                    if(dir == 'N') {
                        dir = 'E';
                    }else if(dir == 'E') {
                        dir = 'S';
                    }else if(dir == 'S') {
                        dir = 'W';
                    }else {
                        dir = 'N';
                    }
                }
            }
        }
        return (x == 0 && y == 0) || dir != 'N';
    }
}