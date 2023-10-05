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

//        bruteForceButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // 创建一个线程来执行暴力破解
//                Thread bruteForceThread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        String ciphertext = plaintextField.getText();
//                        String result = "";
//                                //performBruteForceSDES(ciphertext);
//                        if (result != null) {
//                            // 更新 UI 显示破解结果
//                            SwingUtilities.invokeLater(new Runnable() {
//                                @Override
//                                public void run() {
//                                    resultLabel.setText("<html><font color='red'>破解结果:</font> " + result + "</html>");
//                                }
//                            });
//                        } else {
//                            // 未找到明文
//                            SwingUtilities.invokeLater(new Runnable() {
//                                @Override
//                                public void run() {
//                                    resultLabel.setText("<html><font color='red'>未找到明文</font></html>");
//                                }
//                            });
//                        }
//                    }
//                });
//                bruteForceThread.start();
//            }
//        });
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
        String ciphertext = Simpledes.encryptString(plaintext,key);
        return ciphertext;
    }

    // 在这里添加S-DES解密逻辑
    private static String performSDESDecryption(String ciphertext, String key) {
        // 实现S-DES解密的代码
        String plaintext = Simpledes.decodeString(ciphertext,key);
        return plaintext;
    }

}
