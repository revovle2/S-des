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





























