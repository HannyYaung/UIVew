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
 
 ### 1.3 setXfermode(Xfermode xfermode)
 "Xfermode" 其实就是 "Transfer mode"，用 "X" 来代替 "Trans" 是一些美国人喜欢用的简写方式。严谨地讲， Xfermode 指的是你要绘制的内容和 Canvas 的目标位置的内容应该怎样结合计算出最终的颜色。但通俗地说，其实就是要你以绘制的内容作为源图像，以 View 中已有的内容作为目标图像，选取一个  PorterDuff.Mode 作为绘制内容的颜色处理方案
 
 
 ## 效果
 - 设置抗锯齿 setAntiAlias
 - 设置setStyle(),设置填充风格
 - 设置线条形状（setStrokeWidth(float width), setStrokeCap(Paint.Cap cap), setStrokeJoin(Paint.Join join), setStrokeMiter(float miter) 。）

## 色彩
- 抖动 setDither()
- setFilterBitmap(boolean filter) 是否使用双线性来过滤绘制
- setPathEffect(PathEffect effect)
>  Android 中的 6 种 PathEffect。PathEffect 分为两类，单一效果的 CornerPathEffect DiscretePathEffect DashPathEffect PathDashPathEffect ，和组合效果的 SumPathEffect ComposePathEffect。

- setShadowLayer(float radius, float dx, float dy, int shadowColor) 在之后的绘制内容下面加一层阴影。
- setMaskFilter(MaskFilter maskfilter) 

> 为之后的绘制设置 MaskFilter。上一个方法 setShadowLayer() 是设置的在绘制层下方的附加效果；而这个 MaskFilter 和它相反，设置的是在绘制层上方的附加效果。
  到现在已经有两个 setXxxFilter(filter) 了。前面有一个 setColorFilter(filter) ，是对每个像素的颜色进行过滤；而这里的 setMaskFilter(filter) 则是基于整个画面来进行过滤。
  MaskFilter 有两种： BlurMaskFilter 和 EmbossMaskFilter。
  
## 获取绘制的 Path 
- getFillPath(Path src, Path dst)
- getTextPath(String text, int start, int end, float x, float y, Path path) / getTextPath(char[] text, int index, int count, float x, float y, Path path)
  
 
 ## view的绘制顺序
 - 背景
 - 主体（onDraw）
 - 子View(dispatchDraw)
 - 滑动边缘渐变和滑动条
 - 前景
 
 ![](https://ws4.sinaimg.cn/large/006tKfTcly1fiiwb2nr63j30ga0bddgg.jpg)
 
 ### 1 draw()总调度
 
 简化版代码
 ```
 public void draw(Canvas canvas) {  
     ...
 
     drawBackground(Canvas); // 绘制背景（不能重写）
     onDraw(Canvas); // 绘制主体
     dispatchDraw(Canvas); // 绘制子 View
     onDrawForeground(Canvas); // 绘制滑动相关和前景
 
     ...
 }
 ```
 -[](https://ws2.sinaimg.cn/large/006tKfTcly1fiix28rb6mj30ru0c8jsb.jpg)
 
 ### 2 重写draw()
 - 写在super.draw()的后面会覆盖掉所有的东西
 - 如果写在super.draw()的上面的，那就是在背景之后，那还有用吗，这个作用可以用到EditText 上，我既不想去掉下面的那个线，又想给一个背景颜色
 
 -[](https://ws3.sinaimg.cn/large/006tKfTcly1fii5jk7l19j30q70e0di5.jpg)
 
 ### 注意事项
 
- 在 ViewGroup 的子类中重写除 dispatchDraw() 以外的绘制方法时，可能需要调用 setWillNotDraw(false)；
- 在重写的方法有多个选择时，优先选择 onDraw()。