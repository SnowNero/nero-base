package com.leet.processing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2019-07-25
 * Time: 16:50
 */
public class Subject6ZigZagConversion {

    /*public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int rows = Math.min(numRows, s.length());
        String[][] resArr = new String[rows][s.length()];
        int row = 0;
        int column = 0;
        boolean down = true;
        for (char c : s.toCharArray()) {
            String cString = String.valueOf(c);
            resArr[row][column] = cString;
            if (row == 0 || row == rows - 1) {
                down = true;
            } else {
                down = false;
            }
            if (down) {
                row++;
            } else {
                row--;
                column++;
            }
        }
        StringBuffer res = new StringBuffer();
        String resString;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < s.length(); j++) {
                resString = resArr[i][j];
                if (resString != null) {
                    res.append(resString);
                }
            }
        }
        return res.toString();
    }*/

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += (goingDown ? 1 : -1);
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

}
