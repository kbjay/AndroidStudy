流程
https://kbjay.github.io/2018/08/01/Android-%E5%8F%8D%E7%BC%96%E8%AF%91%E8%AF%A6%E7%BB%86%E6%B5%81%E7%A8%8B/

遇到的坑
1. 查看寄存器的值显示“Internal error” : android p跟q的机器会有这个问题，使用R的机器即可
https://github.com/JesusFreke/smali/issues/691
2. android studio 4.0+ 无法安装amalidea插件，提示不兼容
使用o.o6的插件即可
3. 通过adb am start -D -n 命令开启应用 ; 使用adb forward tcp:xxx jdwp:xxx 链接手机的应用端口跟电脑的debugger端口；点击run-> attrach debugger to android process 之后waiting for debugger 弹窗不消失；需要在as中设置工程的sdk版本跟手机的sdk版本一致

apktool
https://www.cnblogs.com/kai-/p/13582497.html

smaliidea下载
https://github.com/JesusFreke/smalidea/releases/tag/v0.06

amali 语法：
https://juejin.cn/post/6844903732774174734
