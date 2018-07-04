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

Paint 设置颜色的方法有两种:一种是直接用paint.setClor()/ARGB()来设置颜色,另外一种是用Sharder来制定着色方案.

### 1.1.1直接设置颜色

```

paint.setColor(Color.parseColor("#009688"));  
canvas.drawRect(30, 30, 230, 180, paint);

paint.setColor(Color.parseColor("#FF9800"));  
canvas.drawLine(300, 30, 450, 180, paint);

paint.setColor(Color.parseColor("#E91E63"));  
canvas.drawText("HenCoder", 500, 130, paint); 

```