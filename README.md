*BEAUTY* -*JAVA* ![](https://img.shields.io/badge/license-MIT-0a7bbd.svg?longCache=true&style=flat-square)

#  说明

用 Java 调用腾讯 AI 的 API ，实现人脸识别和检测。

需要去 [https://ai.qq.com](https://ai.qq.com)那创建应用，接入人脸检测与分析这个 API，然后修改一下 Face.java 文件中 deface 方法里的 APP_ID、APP_KEY。

用到了两个 jar 包，一个是 taip-4.3.5.jar，是已经封装好了的，[直接就能用来](http://taip.mydoc.io/)调用 API，如下图所示。

![](https://upload-images.jianshu.io/upload_images/2989110-48b4b1e772d20351.png)

另一个 jar 包是 gson-2.8.0.jar，用来处理数据。

image 里有一些图片，我是直接从腾讯 AI 那下载来的，可以拿来识别。

给一个项目的图

![](https://upload-images.jianshu.io/upload_images/2989110-630d28f8484268d5.png)

#  截图

打开后的截图

![](https://upload-images.jianshu.io/upload_images/2989110-ae94c8e1bdf15309.png)

选取照片后的截图

![](https://upload-images.jianshu.io/upload_images/2989110-543747e55d460895.png)

#  注意

请记得把 jar 包导入，右键项目，然后在 Build Path 那点击 Configure Build Path...

![](https://upload-images.jianshu.io/upload_images/2989110-2a419ee6a89eb1e1.png)

然后点击 Add JARs... 进行导入

![](https://upload-images.jianshu.io/upload_images/2989110-e314fa2d20c05285.png)