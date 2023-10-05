import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.time.Instant;

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
                result.setText("");
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
                    // 获取当前的时间戳
                    Instant instant = Instant.now();

                    // 获取毫秒级别的时间戳
                    long milliseconds = instant.toEpochMilli();

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

                            if (Simpledes.decodeString(cipher, theKey).equals(plain)) {
                                num++;
                                result.append(date.toString()+milliseconds+":第" + num + "个密钥：" + theKey+"\n");
                            }
                        }
                    }
                    else{                                //如果密文是字符串
                        for(int i=0;i<1024;i++) {
                            theKey = Integer.toBinaryString(i);
                            while (theKey.length() < 10) {               //不够10位向左补0
                                theKey = "0" + theKey;
                            }
                            if (Simpledes.decodeString(cipher, theKey).equals(plain)) {
                                num++;
                                result.append(date.toString()+milliseconds+":第" + num + "个密钥：" + theKey+"\n");
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
