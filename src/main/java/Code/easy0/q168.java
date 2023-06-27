package Code.easy0;

public class q168 {
    //    168. Excel表列名称
    public static void main(String[] args) {
        String s = new Solution168().convertToTitle(52);
        System.out.println(s);
    }
}

class Solution168 {
    //    实际上是一个 26 进制的转换
//    递归和 栈是相同的思想
//    下面使用递归，比较简单

    StringBuilder res = new StringBuilder();
    String map = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    //    自己写的狗屎代码，但是效率比较高的了
    public String convertToTitle(int columnNumber) {
        if (columnNumber > 0 && columnNumber < 27) {
            res.append(map.charAt(columnNumber - 1));
            return res.toString();
        } else {
            int temp = columnNumber % 26;
            if (temp == 0) {
                //                26的倍数需要特殊处理，如 52 应该为 AZ
                convertToTitle(columnNumber / 26 - 1);
            } else {
                convertToTitle(columnNumber / 26);
            }
            if (temp == 0) {
//                26的倍数需要特殊处理，如 52 应该为 AZ
                res.append("Z");
            } else {
                res.append(map.charAt(temp - 1));
            }
            return res.toString();
        }
    }

    //    看看大佬们的代码
    public String convertToTitle1(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
//        这个reverse比较常用
        sb.reverse();
        return sb.toString();
    }
}