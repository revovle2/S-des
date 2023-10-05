import java.awt.*;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Simpledes {
    //2.3.1 密钥扩展置换
    //P10
    static String P10(String Key) {
        char[] key = Key.toCharArray(); // 转换成数组
        char[] new_key = {key[2], key[4], key[1], key[6], key[3], key[9], key[0], key[8], key[7], key[5]};
        return String.valueOf(new_key);
    }

    //P8
    static String P8(String Key) {
        char[] key = Key.toCharArray(); // 转换成数组
        char[] new_key = {key[5], key[2], key[6], key[3], key[7], key[4], key[9], key[8]};
        return java.lang.String.valueOf(new_key);
    }

    //左移
    static String leftShift(String Key) {
        String k1 = Key.substring(0, 5);
        String k2 = Key.substring(5, 10);
        String keyL = k1.substring(1) + k1.substring(0, 1);
        String keyR = k2.substring(1) + k2.substring(0, 1);
        return keyL + keyR;
    }

    //密钥扩展 得到 K1
    static String key_expansion1(String Key) {
        return P8(leftShift(P10(Key)));
    }

    //密钥扩展 得到 K2
    static String key_expansion2(String Key) {
        return P8(leftShift(leftShift(P10(Key))));
    }


    //2.3.2 初始置换盒
    //IP
    static String IP(String Text) {
        char[] text = Text.toCharArray();
        char[] new_text = {text[1], text[5], text[2], text[0], text[3], text[7], text[4], text[6]};
        return java.lang.String.valueOf(new_text);
    }

    //2.3.3 最终置换盒
    //IP_1  最终置换
    static String IP_1(String Text) {
        char[] text = Text.toCharArray();
        char[] new_text = {text[3], text[0], text[2], text[4], text[6], text[1], text[7], text[5]};
        return java.lang.String.valueOf(new_text);
    }

    //2.3.4 轮函数
    //EPBox
    static String EPBox(String Text) {
        char[] text = Text.toCharArray();
        char[] new_text = {text[3], text[0], text[1], text[2], text[1], text[2], text[3], text[0]};
        return java.lang.String.valueOf(new_text);
    }

    //SBox1
    static int[][] SBox1 = {{1, 0, 3, 2}, {3, 2, 1, 0}, {0, 2, 1, 3}, {3, 1, 0, 2}};
    //SBox2
    static int[][] SBox2 = {{0, 1, 2, 3}, {2, 3, 1, 0}, {3, 0, 1, 2}, {2, 1, 0, 3}};

    //SPBox
    static String SPBox(String Text) {
        char[] text = Text.toCharArray();
        char[] new_text = {text[1], text[3], text[2], text[0]};
        return java.lang.String.valueOf(new_text);
    }

    //其他函数
    //异或
    static String XOR(String str1, String str2) {
        String res = "";
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                res += '0';
            } else {
                res += '1';
            }
        }
        return res;
    }

    //将字符串表示的二进制转换为数字
    static int transferToNumber(String str) {
        switch (str) {
            case "00":
                return 0;
            case "01":
                return 1;
            case "10":
                return 2;
            default:
                return 3;
        }
    }

    //将数字转换为字符串表示的二进制
    static String transferToString(int num) {
        switch (num) {
            case 0:
                return "00";
            case 1:
                return "01";
            case 2:
                return "10";
            default:
                return "11";
        }
    }

    //替换
    static String substitution(String Text) {
        String a = Text.substring(0, 1) + Text.substring(3, 4);
        String b = Text.substring(1, 3);
        String c = Text.substring(4, 5) + Text.substring(7, 8);
        String d = Text.substring(5, 7);
        int x = SBox1[transferToNumber(a)][transferToNumber(b)];
        int y = SBox2[transferToNumber(c)][transferToNumber(d)];
        return transferToString(x) + transferToString(y);
    }

    static String TextL;    //文本左边部分
    static String TextR;    //文本右边部分

    //轮变换   F1
    static String F1(String Key1) {
        return XOR(TextL, SPBox(substitution(XOR(EPBox(TextR), Key1))));
    }

    //轮变换   左右互换
    static void SW(String textL) {
        TextL = TextR;
        TextR = textL;
    }

    //轮变换   F2
    static String F2(String Key2) {
        return XOR(TextL, SPBox(substitution(XOR(EPBox(TextR), Key2))));
    }


    //加密算法
    static String encrypt(String plainText, String key) {
        String Key1 = key_expansion1(key);          //生成子密钥
        String Key2 = key_expansion2(key);

        TextL = IP(plainText).substring(0, 4);
        TextR = IP(plainText).substring(4, 8);
        String textl = F1(Key1);
        SW(textl);
        return IP_1(F2(Key2) + TextR);
    }

    //解密算法
    static String decode(String cipherText, String key) {
        String Key1 = key_expansion1(key);          //生成子密钥
        String Key2 = key_expansion2(key);

        TextL = IP(cipherText).substring(0, 4);
        TextR = IP(cipherText).substring(4, 8);
        String textl = F2(Key2);
        SW(textl);
        return IP_1(F1(Key1) + TextR);
    }

    //加密字符串
    static String encryptString(String plainText, String key) {
        String ciphertext = "";                       //密文
        String binaryText = "";                       //单个字符的二进制表示
        String cipherBinaryText = "";                 //加密后的二进制字符串
        String plainBinaryType = "[0*1*]*[1*0*]*";    //二进制类型的明文

        //如果明文是二进制类型
        if (plainText.matches(plainBinaryType)) {
            while ((plainText.length() % 8) != 0) {       //不是8的整数，右补零
                plainText = plainText + "0";
            }
            for (int i = 0; i < plainText.length() / 8; i++) {
                ciphertext += encrypt(plainText.substring(0 + 8 * i, 8 + 8 * i), key);
            }
        }
        //如果明文是字符串类型
        else {

            char[] strChar = plainText.toCharArray();     //将字符串表示为二进制字符串,对每一个二进制字符串加密
            if (isContainChinese(plainText)) {
                for (int i = 0; i < strChar.length; i++) {
                    binaryText = Integer.toBinaryString(strChar[i]);

                    while (binaryText.length() < 16) {
                        binaryText = "0" + binaryText;      //小于16位，左补0
                    }
                    //将加密后的二进制字符串转换成字符，然后拼接成明文
                    cipherBinaryText = encrypt(binaryText.substring(0, 8), key) + encrypt(binaryText.substring(8, 16), key);
                    ciphertext += Character.toString((char) Integer.parseInt(cipherBinaryText, 2));
                }
            } else {
                for (int i = 0; i < strChar.length; i++) {
                    binaryText = Integer.toBinaryString(strChar[i]);

                    while (binaryText.length() < 8) {
                        binaryText = "0" + binaryText;      //小于8位，左补0
                    }
                    //将加密后的二进制字符串转换成字符，然后拼接成明文
                    cipherBinaryText = encrypt(binaryText, key);
                    ciphertext += Character.toString((char) Integer.parseInt(cipherBinaryText, 2));
                }
            }
        }
        return ciphertext;
    }

    //解密字符串
    static String decodeString(String cipherText, String key) {
        String plaintext = "";                        //明文
        String binaryText = "";                       //单个字符的二进制表示
        String plainBinaryText = "";                  //解密后的二进制字符串
        String cipherBinaryType = "[0*1*]*[1*0*]*";   //二进制类型的密文

        //如果密文是二进制类型
        if (cipherText.matches(cipherBinaryType)) {
            while ((cipherText.length() % 8) != 0) {       //不是8的整数，右补零
                cipherText = cipherText + "0";
            }
            for (int i = 0; i < cipherText.length() / 8; i++) {
                plaintext += decode(cipherText.substring(0 + 8 * i, 8 + 8 * i), key);
            }
        }
        //如果密文是字符串类型
        else {
            char[] strChar = cipherText.toCharArray();     //将字符串表示为二进制字符串,对每一个二进制字符串解密
            if (isMoreThan15bits(cipherText)) {

                for (int i = 0; i < strChar.length; i++) {
                    binaryText = Integer.toBinaryString(strChar[i]);

                    while (binaryText.length() < 16) {
                        binaryText = "0" + binaryText;      //小于16位，左补0
                    }
                    //将解密后的二进制字符串转换成字符
                    plainBinaryText = decode(binaryText.substring(0, 8), key) + decode(binaryText.substring(8, 16), key);
                    plaintext += Character.toString((char) Integer.parseInt(plainBinaryText, 2));
                }
            } else {

                for (int i = 0; i < strChar.length; i++) {
                    binaryText = Integer.toBinaryString(strChar[i]);

                    while (binaryText.length() < 8) {
                        binaryText = "0" + binaryText;      //小于8位，左补0
                    }
                    //将解密后的二进制字符串转换成字符
                    plainBinaryText = decode(binaryText, key);
                    plaintext += Character.toString((char) Integer.parseInt(plainBinaryText, 2));
                }
            }
        }
        return plaintext;
    }

    //暴力破解
    static void bruteForceAttack(String ciphertext, String plainText) {
        System.out.println("开始暴力破解");

        String theKey = "";                           //遍历密钥
        String cipherType1 = "[0*1*]*[1*0*]*";        //二进制数组成的密文
        Date date = new Date();                     //显示时间

        int num = 0;
        if (ciphertext.matches(cipherType1)) //如果 密文是二进制数
        {

            while (plainText.length() < ciphertext.length()) {
                plainText = plainText + "0";
            }

            for (int i = 0; i < 1024; i++) {
                theKey = Integer.toBinaryString(i);
                while (theKey.length() < 10) {               //不够10位向左补0
                    theKey = "0" + theKey;
                }

                if (decodeString(ciphertext, theKey).equals(plainText)) {
                    num++;
                    System.out.println(date.toString() + ":第" + num + "个密钥：" + theKey);
                }
            }
        } else {                                //如果密文是字符串
            for (int i = 0; i < 1024; i++) {
                theKey = Integer.toBinaryString(i);
                while (theKey.length() < 10) {               //不够10位向左补0
                    theKey = "0" + theKey;
                }
                if (decodeString(ciphertext, theKey).equals(plainText)) {
                    num++;
                    System.out.println(date.toString() + ":第" + num + "个密钥：" + theKey);
                }
            }
        }
    }

    //检测字符串中是否包含中文
    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4E00-\u9FFF|\\！|\\，|\\。|\\（|\\）|\\《|\\》|\\“|\\”|\\？|\\：|\\；|\\【|\\】]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    //检测字符串中是否有字符的二进制数超过15位
    public static boolean isMoreThan15bits(String str){
        char[] strchar = str.toCharArray();
        for(int i=0;i<str.length();i++){
            if(Integer.toBinaryString(strchar[i]).length()>=15){
                return true;
            }
        }
        return false;
    }

    //主函数
    public static void main(String[] args) {
        /*System.out.println("请输入明文");                   //输入明文
        Scanner sin = new Scanner(System.in);
        String plainText = sin.next();

        System.out.println("请输入 10bits 密钥");         //输入密钥
        sin = new Scanner(System.in);
        String Key = sin.next();*/

        String plainText = "";      //测试用明文
        String Key = "";            //测试用密钥
        plainText = "strstr";     //C:01000011 01000100 1010000100000000 0000101101101010
        Key = "1010000010";

        /*//测试 二进制明文
        String ciphertext1 = encrypt(plainText,Key);     //生成密文
        String plaintext1 =  decode(ciphertext1,Key);     //生成明文
        System.out.println("密文1:"+ciphertext1);
        System.out.println("明文1:"+plaintext1);*/

        //测试 字符串
        String ciphertext2 = encryptString(plainText, Key);
        System.out.println("密文2:" + ciphertext2);
        String plaintext2 = decodeString(ciphertext2, Key);
        System.out.println("明文2:" + plaintext2);

        //测试暴力破解
        bruteForceAttack(ciphertext2, plaintext2);


    }
}