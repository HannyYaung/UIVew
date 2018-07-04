# UIVew
Android﻿三大瓶颈之一：自定义 View

# Paint
### Paint 的API 大致可以分为四类

- 颜色
- 效果
- drawText()相关
- 初始化

### 1颜色
 Canvas 绘制的内容,有三层对颜色的处理:
![ww](https://ws3.sinaimg.cn/large/52eb2279ly1fig6dcywn2j20j909yabu.jpg)

### 1.1基本颜色
   
![](https://ws3.sinaimg.cn/large/52eb2279ly1fig6gxcusnj20iw04xmzr.jpg)

Paint设置颜色的方法有两种:一种是直接用paint.setClor()/ARGB()来设置颜色,另外一种是用Sharder来制定着色方案.

### 1.1.1 直接设置颜色

### setColor(int color)


```

paint.setColor(Color.parseColor("#009688"));  
canvas.drawRect(30, 30, 230, 180, paint);

paint.setColor(Color.parseColor("#FF9800"));  
canvas.drawLine(300, 30, 450, 180, paint);

paint.setColor(Color.parseColor("#E91E63"));  
canvas.drawText("HenCoder", 500, 130, paint); 

```
### setARGB(int a,int r,int g,int b)

 ```
   paint.setARGB(100, 255, 0, 0);  
   canvas.drawRect(0, 0, 200, 200, paint);  
   paint.setARGB(100, 0, 0, 0);  
   canvas.drawLine(0, 0, 200, 200, paint);
 
 ```
 ### setShader(Shader shader) 设置Shader
 
 在Android的绘制里使用Shader,并不是直接用Shader这个类,而是用他的几个子类,具体来讲有LinearGradient RadialGradient SweepGradient BitmapShader ComposeShader 
 
 ### 1.2 setColoFilter(ColorFilter colorFilter)
 颜色过滤器,在Paint 里设置ColorFilter,使用的是Paint.setClolorFilter();ColorFilter并不直接使用,而是使用它的子类.它共有三个子类分别是LightingColorFilter ProterDuffColorFilter ColorMatrixColorFilter .
 
 
 
 
 