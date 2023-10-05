# S-des
## 闯关报告
#### 第1关：基本测试
根据S-DES算法编写和调试程序，提供GUI解密支持用户交互。输入可以是8bit的数据和10bit的密钥，输出是8bit的密文。    
程序的GUI如下图所示：
![image](https://github.com/revovle2/S-des/assets/93172576/72dde28a-2d71-43e3-8350-7e7b7209df05)     

<p align="center">图1 加解密的主GUI界面</p>

当未输入明文或密钥时，GUI会提示输入：
![image](https://github.com/revovle2/S-des/assets/93172576/e7886c77-fe77-4de3-a438-ce179e108d5d)

<p align="center">图2 未输入明文</p>

未输入密钥：

![image](https://github.com/revovle2/S-des/assets/93172576/09829795-5428-4d7b-8607-43b2e93d2b5d)

<p align="center">图3 未输入密钥</p>

先测试最基础的二进制明文 密钥随机生成为1010000110

明文为11100011

加密结果如下：密文为01100011

![image](https://github.com/revovle2/S-des/assets/93172576/f90636b1-9536-46c0-bf91-6c7648aca280)

<p align="center">图4 加密过程</p>

对01100011解密得11100011 完全对应

![image](https://github.com/revovle2/S-des/assets/93172576/d39bce1d-dd29-4827-b16a-769241d2de55)

<p align="center">图5 解密过程</p>

#### 第二关 交叉测试

考虑到是算法标准，所有人在编写程序的时候需要使用相同算法流程和转换单元(P-Box、S-Box等)，以保证算法和程序在异构的系统或平台上都可以正常运行。

设有A和B两组位同学(选择相同的密钥K)；则A、B组同学编写的程序对明文P进行加密得到相同的密文C；或者B组同学接收到A组程序加密的密文C，使用B组程序进行解密可得到与A相同的P。

本组的加解密测试如下：

加密二进制明文

![HI4S{3(X5YB9 C 9 5T $1](https://github.com/revovle2/S-des/assets/93172576/7310fab9-a933-4919-94c5-4c79f31dd819)

<p align="center">图6 加密二进制明文（本组）</p>

加密ascaii码

![J(I283Y%O02%V}SAQCW1 7B](https://github.com/revovle2/S-des/assets/93172576/4eb46382-efb2-48d0-8912-84e460209558)

<p align="center">图7 加密ASCII码明文（本组）</p>

交叉组测试：

加密二进制明文

![{ Y2$3VX) XAJNLOXONX}Q1](https://github.com/revovle2/S-des/assets/93172576/2c36065f-b1e4-492c-acda-be1f11d6513b)

<p align="center">图8 加密二进制码明文（交叉组）</p>

加密ASCII码

![A2X0)EYJS4JJ98PN3Q8(HYK](https://github.com/revovle2/S-des/assets/93172576/05335c14-563d-4cfc-916e-77fa699db0ab)

<p align="center">图9 加密ascii码明文（交叉组）</p>

结论：组间测试通过，第二关通过！

#### 第三关 拓展功能

考虑到向实用性扩展，加密算法的数据输入可以是ASII编码字符串(分组为1 Byte)，对应地输出也可以是ACII字符串(很可能是乱码)。

在第一关的相关演示中，已经展示了ASCII码字符串的加密解密，现在再演示一次：

加密明文cqu

![image](https://github.com/revovle2/S-des/assets/93172576/257a8153-f416-497b-a785-cb60358f3062)

<p align="center">图10 加密明文cqu</p>

解密密文得到cqu

![image](https://github.com/revovle2/S-des/assets/93172576/a5556170-d33a-4020-a998-5f0fa9fb8d42)

<p align="center">图11 解密密文得到cqu</p>

此外，本程序提供了汉字明文加解密功能：

![image](https://github.com/revovle2/S-des/assets/93172576/317c8eff-58e4-4581-b9e7-c508d686847f)
<p align="center">图11.1 加密 重庆大学</p>

![image](https://github.com/revovle2/S-des/assets/93172576/14131b90-49f8-4c3f-8b5f-3f2bb597fc16)
<p align="center">图11.2 解密 重庆大学</p>





第三关通过！

#### 第四关 暴力破解

假设你找到了使用相同密钥的明、密文对(一个或多个)，请尝试使用暴力破解的方法找到正确的密钥Key。

在编写程序时，你也可以考虑使用多线程的方式提升破解的效率。请设定时间戳，用视频或动图展示你在多长时间内完成了暴力破解。

破解二进制明文结果如下：密钥为1011001000

![image](https://github.com/revovle2/S-des/assets/93172576/c99d3311-11b3-4048-b550-bf456da67eaf)


<p align="center">图12 破解二进制明文</p>

可以看到得到了密钥

破解ASCII码： 密钥同上

![image](https://github.com/revovle2/S-des/assets/93172576/e8868b25-0738-4c38-88e3-765dd0b83279)

<p align="center">图13 破解ASCII明密文对</p>

从毫秒级时间戳可以看到，找到两个密钥所需的时间在毫秒级上是一模一样的，可以认为是同时完成

关卡四通过！

#### 关卡五 封闭测试

根据第4关的结果，进一步分析，对于你随机选择的一个明密文对，是不是有不止一个密钥Key？

进一步扩展，对应明文空间任意给定的明文分组P_{n}，是否会出现选择不同的密钥K_{i}\ne K_{j}加密得到相同密文C_n的情况？

根据第四关的结果，所选择的明密文对，均有不止一个密钥，见图12与图13.


![image](https://github.com/revovle2/S-des/assets/93172576/14435c89-e3ed-4d87-8066-87035dbb2915)

<p align="center">图14 密钥一加密cqu</p>

![image](https://github.com/revovle2/S-des/assets/93172576/72e6ce18-1351-47f7-b21c-cc0ff6ec4441)

<p align="center">图15 密钥二加密cqu</p>

可以看到，出现了不同密钥加密明文cqu ，得到的密文相同的情况

关卡五，通过！测试完美结束！

## 开发手册
#### 1、算法简介

​	S-DES是一个供教学而非安全使用的加密算法，与DES的特性和结构类似，但它参数小，明文分组为8位，主密钥为10位，采用两轮迭代。它主要包括两个部分：密钥生成和数据的加密解密。

##### 1.1 密钥生成：

​	将10位密钥扩展成两个8位子密钥。

$$
密钥扩展算法：k_i=P_8(Shift^i(P_{10}(K))),(i=1,2)
$$

##### 1.2 数据加密解密：

​	将数据通过一系列变换加密成密文，或者使用逆变换解密成明文。

$$
加密算法：C=IP^{-1}(f_{k_2}(SW)(f_{k_1}(IP(P))))
$$

$$
解密算法：P=IP^{-1}(f_{k_1}(SW(f_{k_2})(IP(C))))
$$

##### 1.3 拓展功能

​	本项目在原有S-DES算法基础上，支持对任意位数二进制明密文的加密解	密，以及对字符串类型（包括汉字）密文的加密解密功能。
​	另外增加了暴力破解功能，针对已知的明密文对遍历所有的密钥空间，搜	索到满足将密文解密成明文的所有密钥。

#### 2、详细介绍

##### 2.1 基本功能模块

```` java
/*********************************1、密钥扩展置换*************************************/
//***P10
static String P10(String Key) {
    char[] key = Key.toCharArray(); // 转换成数组
    char[] new_key = {key[2], key[4], key[1], key[6], key[3], key[9], key[0], key[8], key[7], key[5]};
    return String.valueOf(new_key);
}

//***P8
static String P8(String Key) {
    char[] key = Key.toCharArray(); // 转换成数组
    char[] new_key = {key[5], key[2], key[6], key[3], key[7], key[4], key[9], key[8]};
    return java.lang.String.valueOf(new_key);
}

//***shift
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

//密钥扩展 得到 K2	注：此处的k2扩展函数与网上的略有区别
static String key_expansion2(String Key) {
    return P8(leftShift(leftShift(P10(Key))));
}

/***********************************2、轮函数**************************************/
//初始置换盒
//***IP
static String IP(String Text) {
    char[] text = Text.toCharArray();
    char[] new_text = {text[1], text[5], text[2], text[0], text[3], text[7], text[4], text[6]};
    return java.lang.String.valueOf(new_text);
}

//最终置换盒
//***IP_1  最终置换
static String IP_1(String Text) {
    char[] text = Text.toCharArray();
    char[] new_text = {text[3], text[0], text[2], text[4], text[6], text[1], text[7], text[5]};
    return java.lang.String.valueOf(new_text);
}

//轮函数
//EPBox
static String EPBox(String Text) {
    char[] text = Text.toCharArray();
    char[] new_text = {text[3], text[0], text[1], text[2], text[1], text[2], text[3], text[0]};
    return java.lang.String.valueOf(new_text);
}
//SBox1
static int[][] SBox1 = {{1, 0, 3, 2}, {3, 2, 1, 0}, {0, 2, 1, 3}, {3, 1, 0, 2}};
//SBox2		注：此处的SBox2与网上的略有区别
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

//***F1
static String F1(String Key1) {
    return XOR(TextL, SPBox(substitution(XOR(EPBox(TextR), Key1))));
}

//***SW
static void SW(String textL) {
    TextL = TextR;
    TextR = textL;
}

//***F2
static String F2(String Key2) {
    return XOR(TextL, SPBox(substitution(XOR(EPBox(TextR), Key2))));
}
````



##### 2.2 加密解密算法

​	基本的加密、解密功能，输入八位二进制文本和十位密钥，返回对应的明文或密文。

```` java
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
````

​	拓展的加密解密算法。在原来加密解密的基础上，对于**不同长度的二进制文本**，对其右补零（不影响左边的值）使其字符长度达到八的倍数，然后对每一个八比特分组进行加密或者解密，最后将所有的明密文分组整合，返回完整的明密文字符串。
​	对于**不同长度的字符串文本**（针对字母、各种符号、空格和汉字而言），若字符串中**不包含汉字字符**，将每一个字符转换成**八位**二进制表示，进行加密解密，然后将处理过的二进制转化成字符形式，最后输出；若字符串中**包含汉字**，将每一个字符转换成**十六位**二进制表示，然后分别对前八位和后八位进行加密解密，之后转换成二进制形式输出。

````  java
//加密字符串
static String encryptString(String plainText, String key) 
{
    String ciphertext = "";                       //密文
    String binaryText = "";                       //单个字符的二进制表示
    String cipherBinaryText = "";                 //加密后的二进制字符串
    String plainBinaryType = "[0*1*]*[1*0*]*";    //二进制类型的明文

    //如果明文是二进制类型
    if (plainText.matches(plainBinaryType)) 
    {
        while ((plainText.length() % 8) != 0)//不是8的整数，右补零
        {       
            plainText = plainText + "0";
        }
        for (int i = 0; i < plainText.length() / 8; i++) 
        {
            ciphertext += encrypt(plainText.substring(0 + 8 * i, 8 + 8 * i), key);
        }
    }
    //如果明文是字符串类型
    else 
    {
        char[] strChar = plainText.toCharArray();     //将字符串表示为二进制字符串,对每一个二进制字符串加密
        if (isContainChinese(plainText)) 
        {
            for (int i = 0; i < strChar.length; i++) 
            {
                binaryText = Integer.toBinaryString(strChar[i]);
                while (binaryText.length() < 16) 
                {
                    binaryText = "0" + binaryText;      //小于16位，左补0
            	}
                //将加密后的二进制字符串转换成字符，然后拼接成明文
                cipherBinaryText = encrypt(binaryText.substring(0, 8), key) + encrypt(binaryText.substring(8, 16), key);
                ciphertext += Character.toString((char) Integer.parseInt(cipherBinaryText, 2));
            }
        }
        else 
        {
            for (int i = 0; i < strChar.length; i++) 
            {
                binaryText = Integer.toBinaryString(strChar[i]);
                while (binaryText.length() < 8) 
                {
                    binaryText = "0" + binaryText;      //小于8位，左补0
            	}
                //将加密后的二进制字符串转换成字符，然后拼接成明文
                cipherBinaryText = encrypt(binaryText, key);
              ciphertext+=Character.toString((char)Integer.parseInt(cipherBinaryText, 2));
            }
        }
    }
    return ciphertext;
}

//解密字符串
static String decodeString(String cipherText, String key) 
{
    String plaintext = "";                        //明文
    String binaryText = "";                       //单个字符的二进制表示
    String plainBinaryText = "";                  //解密后的二进制字符串
    String cipherBinaryType = "[0*1*]*[1*0*]*";   //二进制类型的密文

    //如果密文是二进制类型
    if (cipherText.matches(cipherBinaryType)) 
    {
        while ((cipherText.length() % 8) != 0) //不是8的整数，右补零
        {       
            cipherText = cipherText + "0";
        }
        for (int i = 0; i < cipherText.length() / 8; i++) 
        {
            plaintext += decode(cipherText.substring(0 + 8 * i, 8 + 8 * i), key);
        }
    }
    //如果密文是字符串类型
    else {
        char[] strChar = cipherText.toCharArray();     //将字符串表示为二进制字符串,对每一个二进制字符串解密
        if (isMoreThan15bits(cipherText)) 
        {
            for (int i = 0; i < strChar.length; i++) 
            {
                binaryText = Integer.toBinaryString(strChar[i]);
                while (binaryText.length() < 16) 
                {
                    binaryText = "0" + binaryText;      //小于16位，左补0
              	}
                //将解密后的二进制字符串转换成字符
                plainBinaryText = decode(binaryText.substring(0, 8), key) + decode(binaryText.substring(8, 16), key);
                plaintext += Character.toString((char) Integer.parseInt(plainBinaryText, 2));
            }
        } 
        else 
        {
            for (int i = 0; i < strChar.length; i++) 
            {
                binaryText = Integer.toBinaryString(strChar[i]);
                while (binaryText.length() < 8) 
                {
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
````

##### 2.3 暴力破解算法

​	对于输入的明密文对，遍历10比特密钥空间，输出每一个满足将密文解密成明文的密钥以及搜索到该密钥的时间。可以发现，对于同一个明密文对，可能存在多个不同的密钥与之对应。

```` java
//暴力破解
    static void bruteForceAttack(String ciphertext, String plainText) {
        String theKey = "";                         //遍历密钥
        String cipherType1 = "[0*1*]*[1*0*]*";      //二进制数组成的密文
        Date date = new Date();                     //显示时间
        int num = 0;								//密钥个数
        if (ciphertext.matches(cipherType1)) //如果 密文是二进制数
        {
            //如果二进制明文长度小于密文长度，右补零
            while (plainText.length() < ciphertext.length()) {
                plainText = plainText + "0";
            }
			//遍历所有的十位二进制数
            for (int i = 0; i < 1024; i++) {
                theKey = Integer.toBinaryString(i);
                while (theKey.length() < 10) {               //不够10位向左补0
                    theKey = "0" + theKey;
                }
                if (decodeString(ciphertext, theKey).equals(plainText)) 
                {
                    num++;
                    System.out.println(date.toString() + ":第" + num + "个密钥：" + theKey);
                }
            }
        } 
        else  //如果密文是字符串
        {    
            //遍历所有的二进制数
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
````

##### 2.4 GUI与用户交互

###### 2.4.1 主页面

```` java
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class UI  {
    public static void main(String[] args) {
        JFrame frame = new JFrame("S-DES加密解密工具");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        centerWindow(frame);
        frame.setLayout(new BorderLayout(50, 20));
        JPanel jp=new JPanel();

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 15, 20));
        inputPanel.setBorder(BorderFactory.createTitledBorder("输入"));
        JLabel plaintextLabel = new JLabel("在此输入你要加密的明文或要解密的密文:");
        JTextField plaintextField = new JTextField();
        JLabel keyLabel = new JLabel("密钥 (10位二进制):");
        JTextField keyField = new JTextField();
        JButton random=new JButton("生成随机密钥");



        inputPanel.add(plaintextLabel);
        inputPanel.add(plaintextField);
        inputPanel.add(keyLabel);
        inputPanel.add(keyField);
        inputPanel.add(random);

        JPanel resultPanel = new JPanel(new GridLayout(3,2,15,20));
        resultPanel.setBorder(BorderFactory.createTitledBorder("结果"));
        JLabel resultLabel = new JLabel("密文:");
        JTextField encry_text=new JTextField();
        JLabel resultLabel2 = new JLabel("明文:");
        JTextField decry_text=new JTextField();
        JLabel message=new JLabel("");
        JLabel famous=new JLabel("                                            @design by B5 513");
        resultPanel.add(resultLabel);
        resultPanel.add(encry_text);
        resultPanel.add(resultLabel2);
        resultPanel.add(decry_text);
        resultPanel.add(message);
        resultPanel.add(famous);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton encryptButton = new JButton("加密");
        JButton decryptButton = new JButton("解密");
        JButton bruteForceButton = new JButton("暴力破解");
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);
        buttonPanel.add(bruteForceButton);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(resultPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        //字体部分
        Font font = new Font("微软雅黑", Font.PLAIN, 16);
        plaintextLabel.setFont(font);
        keyLabel.setFont(font);
        encryptButton.setFont(font);
        decryptButton.setFont(font);
        bruteForceButton.setFont(font);
        resultLabel.setFont(font);
        plaintextField.setFont(font);
        keyField.setFont(font);
        resultLabel2.setFont(font);
        message.setFont(font);
        encry_text.setFont(font);
        decry_text.setFont(font);
        famous.setFont(new Font("宋体",font.PLAIN,10));

        random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random=new Random();
                int temp= random.nextInt(1024);//生成一个0-1024的随机数
                String key=Integer.toBinaryString(temp);
                while (key.length()<10){
                    key="0"+key;
                }
                keyField.setText(key);
            }
        });

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 实现S-DES加密的代码
                if (plaintextField.getText().trim().equals("")){
                    message.setText("<html><font color='red'>请输入明文!</font> </html>");

                } else if (keyField.getText().trim().equals("")) {
                    message.setText("<html><font color='red'>请输入密钥!</font> </html>");

                } else {
                    String plaintext = plaintextField.getText();
                    String key = keyField.getText();
                    String ciphertext = performSDESEncryption(plaintext, key);
                    // resultLabel.setText("<html><font color='green'>加密结果:</font> " + ciphertext + "</html>");
                    encry_text.setText("加密结果:" + ciphertext);
                }
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 实现S-DES解密的代码
                String ciphertext = plaintextField.getText();
                String key = keyField.getText();
                String plaintext = performSDESDecryption(ciphertext, key);

                decry_text.setText("解密结果:" + plaintext );
            }
        });
        bruteForceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                violent_decrypt violentui=new violent_decrypt();
                violentui.setVisible(true);
            }
        });

        frame.setVisible(true);
    }

    // 设置窗口位置为屏幕中央
    private static void centerWindow(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();

        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;

        frame.setLocation(x, y);
    }

    // 在这里添加S-DES加密逻辑
    private static String performSDESEncryption(String plaintext, String key) {
        // 实现S-DES加密的代码
        String ciphertext = SDES.encryptString(plaintext,key);
        return ciphertext;
    }

    // 在这里添加S-DES解密逻辑
    private static String performSDESDecryption(String ciphertext, String key) {
        // 实现S-DES解密的代码
        String plaintext = SDES.decodeString(ciphertext,key);
        return plaintext;
    }

}

````

###### 2.4.2 暴力破解页面

```` java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class violent_decrypt extends JFrame{
    JFrame window1=new JFrame("暴力破解");
    JLabel lb1=new JLabel("");
    JLabel lb2=new JLabel("");
    JLabel lb3=new JLabel("");
    JLabel lb4=new JLabel("");
    JTextField plain_field=new JTextField();
    JTextField encry_field=new JTextField();
    JTextArea result=new JTextArea();
    JButton bt1=new JButton("开始破解");

    public violent_decrypt() {
        setVisible(true);
        VioInit();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void VioInit(){
        this.setTitle("暴力破解");
        this.setSize(800,600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        int frameWidth = this.getWidth();
        int frameHeight = this.getHeight();

        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;
        this.setLocation(x,y);
        JPanel jp =new JPanel(null);
        this.add(jp);

        lb1.setText("请输入明文:");
        lb2.setText("请输入密文:");
        lb3.setText("破解结果:");
        lb4.setText("");

        lb1.setBounds(100,50,100,50);
        lb2.setBounds(100,100,100,50);
        lb3.setBounds(100,150,100,50);
        lb4.setBounds(300,150,100,50);
        plain_field.setBounds(200,60,300,30);
        encry_field.setBounds(200,120,300,30);
        result.setBounds(100,200,500,350);
        bt1.setBounds(600,80,100,30);

        jp.add(lb1);
        jp.add(lb2);
        jp.add(lb3);
        jp.add(lb4);
        jp.add(plain_field);
        jp.add(encry_field);
        jp.add(result);
        jp.add(bt1);

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(plain_field.getText().trim().equals("")){
                    lb4.setText("<html><font color='red'>请输入明文 !</font> </html>");
                }
                else if(encry_field.getText().trim().equals("")){
                    lb4.setText("<html><font color='red'>请输入密文 !</font> </html>");
                }
                else
                {
                        String plain=plain_field.getText();
                        String cipher=encry_field.getText();

                        String theKey="";                           //遍历密钥
                        String cipherType1="[0*1*]*[1*0*]*";        //二进制数组成的密文
                        Date date = new Date();                     //显示时间

                        int num=0;
                        if (cipher.matches(cipherType1)) //如果 密文是二进制数
                        {
                            while(plain.length()<cipher.length()){
                                plain=plain+"0";
                            }

                            for(int i=0;i<1024;i++) {
                                theKey = Integer.toBinaryString(i);
                                while (theKey.length() < 10) {               //不够10位向左补0
                                    theKey = "0" + theKey;
                                }

                                if (SDES.decodeString(cipher, theKey).equals(plain)) {
                                    num++;
                                    result.append(date.toString()+":第" + num + "个密钥：" + theKey+"\n");
                                }
                            }
                        }
                        else{                                //如果密文是字符串
                            for(int i=0;i<1024;i++) {
                                theKey = Integer.toBinaryString(i);
                                while (theKey.length() < 10) {               //不够10位向左补0
                                    theKey = "0" + theKey;
                                }
                                if (SDES.decodeString(cipher, theKey).equals(plain)) {
                                    num++;
                                    result.append(date.toString()+":第" + num + "个密钥：" + theKey+"\n");
                                }
                            }
                        }
                        if(num==0){
                            result.append("出错，未找到密钥!\n");
                        }
                    }
            }
        });
    }
    public static void main(String[] args) {
        violent_decrypt violentui=new violent_decrypt();
    }
}

````







## 用户指南
#### 1.开始之前

1.1 引言

欢迎使用S-DES Java程序！本程序是一个基于Simplified Data Encryption Standard（简化数据加密标准，S-DES）算法的实现，旨在为您提供一个简单而强大的加密和解密工具。本手册将引导您了解如何使用该程序，以便您能够轻松地保护和恢复敏感信息。

1.2 关于S-DES算法

S-DES算法是一种轻量级的数据加密算法，旨在保护数据的机密性。虽然它不如更复杂的加密算法（如AES或RSA）那样强大，但它是一个教育性的工具，可用于学习和理解基本的加密概念。S-DES算法包括初步置换、轮函数、子密钥生成和最终置换等步骤，这些步骤共同构成了加密和解密的过程。

1.3 本手册的目的

本手册的目的是为您提供使用S-DES Java程序的指南。您将会了解如何安装程序、运行简单的加密和解密操作，以及利用不同选项和功能进行更高级的操作。我们将提供示例代码、命令行参数说明和错误处理指南，以帮助您充分利用该程序。

#### 2.安装与配置

2.1 程序的安装

本S-des分为三个Java文件，其中，程序的主要算法功能的实现在Simpledes.java文件里实现，剩下的ui.java以及violent_decrypt.java 均为java swing的java文件。要运行本程序，只需把三个java文件放在同一个java project里，运行 UI.java 即可

2.2 本程序运行在java jdk 1.8以上，使用前请确保java版本不要过于老旧

#### 3.快速入门

3.1 安装和配置

首先，确保您已经成功安装并配置了S-DES Java程序，按照用户手册中的指南进行设置。如果您还没有完成这一步，请返回至安装与配置部分。

3.2 运行程序

运行 ui.java

![image](https://github.com/revovle2/S-des/assets/93172576/df74d075-908e-4c07-b6f8-562b91d656a5)

3.3.1 加密操作

现在，假设你有一个明文需要加密 ，在GUI的第一个输入框中输入你的明文：

![image](https://github.com/revovle2/S-des/assets/93172576/a29b5d6b-d8c6-456f-a385-20ac7bdafcb7)

在第二个输入框输入10bit的二进制密钥 ，此外，本程序提供了随机生成密钥的按钮，可以直接点击生成

![image](https://github.com/revovle2/S-des/assets/93172576/2a2c59f5-f47b-457a-947a-ba5b0a1b15e7)

未输入明文或密钥时，会自动提示

![image](https://github.com/revovle2/S-des/assets/93172576/5d3125f5-9b52-4f4b-9b02-019469dd34dd)

当输入好明文以及密钥后，点击 加密按钮，随后输出密文：

![image](https://github.com/revovle2/S-des/assets/93172576/3a82e3ba-faba-492f-a4c9-9347ac304e0f)

当需要解密密文时，只需把密钥以及密文输入到第一个输入框即可，随后点击解密按钮：

![image](https://github.com/revovle2/S-des/assets/93172576/2ce2caf4-15c2-4c71-a307-d2a9f3677fed)

3.3.2 暴力破解功能

在GUI中点击"暴力破解"  按钮，会打开新窗口

![image](https://github.com/revovle2/S-des/assets/93172576/3ae429e2-df62-40b5-be43-af1d2352107a)

输入明密文对 ，程序便会遍历密钥空间，找出能将明文加密成密文的密钥

![1 IMK1B~}W6 W3`P)HY1XYX](https://github.com/revovle2/S-des/assets/93172576/06578395-f09e-494b-9d9d-59846bc9e545)

3.4 完成！

您已经成功执行了S-DES加密和解密操作。这是一个简单的示例，用于演示程序的基本功能。请记住，S-DES算法是用于教育和学习的，而不是用于高度安全的加密任务。在实际应用中，您可能需要更强大的加密算法。

对于更高级的用法和更多选项，请查看用户手册中的其他部分。如果您遇到任何问题或需要进一步的帮助，请参考错误处理与故障排除部分或联系我们的支持团队。

感谢您选择使用S-DES Java程序！

#### 4.S-DES算法解释

4.1 基本原理图

![image](https://github.com/revovle2/S-des/assets/93172576/0622ce57-624d-4cb2-81e9-8c530a8f6f93)

4.2 算法原理

4.2.1 初始置换（IP initialpermutation）

S-DES加密过程的第一步是初始置换（Initial Permutation，IP）。在这一步中，明文消息的位被重新排列，以生成一个初始置换后的消息。初始置换是根据预定的IP置换表进行的。

本程序初始置换盒如下：
![image](https://github.com/revovle2/S-des/assets/93172576/1498b706-1afa-4179-b6e8-41f5344ee2b3)


4.2.2 轮函数（Round Function）
轮函数是S-DES算法的核心组成部分。它包括以下步骤：

4.2.2.1 密钥生成

从初始密钥生成两个子密钥：K1和K2。这些子密钥将用于加密和解密的两个轮次。

输入一个10bit初始密钥，随后根据如图所示的算法生成子密钥 K1 以及K2

![image](https://github.com/revovle2/S-des/assets/93172576/306a5c14-7236-482a-8002-f47510cb4dcd)


4.2.2.2 扩展/置换（Expansion/Permutation）

在每个轮次中，明文消息的一半位被扩展和重新排列，以生成扩展/置换后的消息。

![image](https://github.com/revovle2/S-des/assets/93172576/43eb71c5-f931-45cf-9c54-0334d89b310e)


4.2.2.3 与子密钥的异或运算

扩展/置换后的消息与生成的子密钥进行异或运算。

4.2.2.4 S-盒替代

异或后的结果通过S-盒进行替代。S-盒是一种非线性变换，根据特定的映射规则将4位输入映射到4位输出。

本程序使用的两个S-box如下图：

![image](https://github.com/revovle2/S-des/assets/93172576/7011482b-3816-406c-b9b5-985d80692f4c)


4.2.5 P-盒置换

S-盒替代后的结果通过P-盒进行置换，以生成最终的轮函数结果。使用的p盒如下：

![image](https://github.com/revovle2/S-des/assets/93172576/ff0c7196-1e69-40f3-bbfe-f96d570c9081)


4.2.3 轮交换
S-DES算法包括两个轮次，每个轮次使用轮函数对数据进行处理。在第一轮后，左半部分和右半部分的数据被交换，然后再次应用轮函数。这个交换确保了解密操作可以正确进行，因为解密是加密的逆操作。


4.2.4 最终置换（FP）
最终置换是S-DES加密的最后一步，与初始置换相反。它重新排列左半部分和右半部分的数据，以生成最终的加密密文。

最终置换盒如下：

![image](https://github.com/revovle2/S-des/assets/93172576/0ec7f8b0-ca16-4bb6-a521-3178c021289e)

S-DES算法的这些步骤共同构成了加密和解密的过程。它是一种轻量级的加密算法，用于保护数据的机密性。请注意，虽然S-DES算法对于教育和学习非常有用，但在实际应用中，可能需要更强大的加密算法以满足更高的安全要求。

#### 5. 错误处理与故障排除
尽管我们致力于提供一个稳定可靠的S-DES Java程序，但在使用过程中仍然可能会遇到一些问题。本节将提供一些常见问题的解决方法，以帮助您排除潜在的错误。

5.1 错误消息
在程序出现错误时，可能会生成错误消息，以指示问题所在。请注意并记录错误消息的内容，以便更轻松地解决问题。

5.2 常见问题和解决方法
问题 1：程序无法启动或闪退
解决方法：
确保已经正确安装了Java运行时环境（JRE）。您可以在命令行中运行java -version来检查是否安装了JRE。
检查程序的命令行参数是否正确。确保文件路径和选项的拼写正确。 

问题 2：加密或解密操作失败
解决方法：
检查密钥是否正确。确保密钥文件包含了8位二进制数字，并且与加密和解密操作中使用的密钥相匹配。
验证输入文件的存在和内容。确保明文或密文文件存在，并且包含有效的数据。

问题 3：程序速度较慢
解决方法：
S-DES算法是一个轻量级算法，但如果处理大量数据，可能会感到速度较慢。考虑使用更快速的加密算法（如AES）来提高性能。

问题 4：其他错误消息
解决方法：
在遇到不同的错误消息时，查阅程序的用户手册，以了解特定错误的含义和解决方法。
如果错误无法解决，请联系我们的支持团队，提供尽可能详细的错误信息和步骤。

5.3 联系支持
如果您遇到无法解决的问题或需要进一步的帮助，请不要犹豫，联系我们的支持团队。您可以通过以下方式联系我们：

电子邮件：20214511@cqu.edu.cn 

QQ:1635031764


我们的支持团队将尽力协助您解决问题，并提供所需的帮助和支持。

5.4 总结
在使用S-DES Java程序时，可能会出现各种问题，但大多数问题都可以通过仔细检查和一些简单的步骤来解决。本节提供了一些常见问题的解决方法，以及联系支持团队的方式。我们希望您能够顺利使用S-DES Java程序，同时也感谢您的支持。

#### 6.测试用例

##### 6.1 加密二进制明文

场景：您希望使用S-DES Java程序加密一条简短的二进制消息。

准备明文消息，例如：11010011。
选择一个10位的S-DES密钥。
在GUI中对应位置输入即可

##### 6.2 加密ASCII码

场景：您希望使用S-DES Java程序加密一条简短的英文句子消息。

准备明文消息，例如：hello world 。
选择一个10位的S-DES密钥。
在GUI中对应位置输入即可

##### 6.3 加密中文

场景：您希望使用S-DES Java程序加密一条简短的中文句子消息。

准备明文消息，例如：重庆大学 。
选择一个10位的S-DES密钥。
在GUI中对应位置输入即可

#### 7. 性能和安全性注意事项
在使用S-DES Java程序时，有一些性能和安全性方面的注意事项需要考虑。本节将介绍这些注意事项，以帮助您更好地理解程序的性能和安全性。

###### 7.1 性能注意事项
7.1.1 加密速度
S-DES算法是一个轻量级的加密算法，但当处理大量数据时，可能会感到速度较慢。如果需要更高性能的加密，考虑使用更快速的加密算法，如AES（高级加密标准）。

7.1.2 文件大小
请注意，S-DES加密可能导致文件大小的增加。加密后的数据通常会稍大于原始数据。确保您有足够的存储空间来存储加密后的文件。

##### 7.2 安全性注意事项
7.2.1 密钥安全
S-DES的安全性高度依赖于所选择的密钥。请确保您的S-DES密钥足够复杂和随机，以防止破解。不要轻易共享密钥。

7.2.2 密文存储
加密后的数据应当妥善存储。确保只有授权的用户能够访问密文，并采取措施保护密钥的安全性。

7.2.3 加密强度
S-DES算法是用于教育和学习的，不适用于高度敏感的数据。对于高度安全性要求的数据，请使用更强大的加密算法，如AES。

7.2.4 定期更换密钥
为了增强安全性，建议定期更换密钥。密钥的定期更换可以降低潜在攻击的风险。

###### 7.3 总结
在使用S-DES Java程序时，请谨慎考虑性能和安全性方面的注意事项。了解加密速度、密钥安全、文件大小和加密强度等问题对于有效使用程序非常重要。根据您的需求和安全性要求，可以选择更适合的加密算法和安全措施。

#### 8. 常见问题解答（FAQ）
本节包含了一些常见的问题和解答，以帮助您更好地理解和使用S-DES Java程序。

8.1 一般问题
Q1：S-DES是什么？

A1：S-DES（Simplified Data Encryption Standard）是一种轻量级的数据加密算法，用于保护数据的机密性。它是一种用于教育和学习的算法，不适用于高度安全性要求的任务。

Q2：我可以在哪里找到S-DES的更多信息？

A2：您可以查阅相关的加密学教材或网络资源，以深入了解S-DES算法的工作原理。

8.2 安装和配置

Q3：如何安装S-DES Java程序？

A3：请参考用户手册的安装与配置部分，其中包含了安装程序的详细步骤。

Q4：我需要安装特定的Java版本吗？

A4：是的，S-DES Java程序需要特定的Java运行时环境（JRE）。请确保您安装了兼容的Java版本。

8.3 加密和解密操作

Q5：如何选择一个合适的S-DES密钥？

A5：S-DES密钥应该是8位的二进制数字（0和1的组合）。选择一个足够复杂和随机的密钥以提高安全性。

Q6：S-DES适用于哪些加密任务？

A6：S-DES是一个用于教育和学习的算法，适用于基本的加密任务。对于高度安全性要求的任务，请使用更强大的加密算法，如AES。

8.4 故障排除

Q7：程序无法启动，如何解决？

A7：请确保已正确安装Java运行时环境（JRE）并检查程序的命令行参数是否正确。

Q8：如何处理加密或解密操作失败？

A8：请检查密钥、输入文件和选项是否正确，并确保文件存在和包含有效数据。

Q9:代码出现乱码怎么办？

A9：将编码从UTF-8 改为GBK

8.5 安全性

Q10：S-DES算法安全吗？

A10：S-DES算法是用于教育和学习的算法，不适用于高度安全性要求的任务。对于高度安全性要求的任务，请使用更强大的加密算法。

Q11：如何确保密文的安全性？

A11：加密后的数据应妥善存储，只有授权的用户才能访问密文。此外，密钥的安全性也是保障密文安全的关键。

8.6 联系支持

Q12：如何联系支持团队获取帮助？

A12：您可以通过电子邮件或访问我们的支持页面联系支持团队，详细信息请参阅用户手册的联系信息部分。

8.7 总结

本节提供了一些常见问题和解答，希望能帮助您更好地使用S-DES Java程序。如果您遇到其他问题或需要进一步的帮助，请不要犹豫，联系我们的支持团队。

#### 9.附录
9.1 参考文献

\[1\]\ 密码编码学与网络安全——原理与实践（第八版）ISBN 97871214065098 William Stalling著 陈晶等人译

#### 10.历史版本
版本v1.0 初始版本 2023.10.3

v1.1  最新版本 修复了加密中文时的部分BUG 2023.10.4



































