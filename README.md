# elderSystem
app
# elderSystem

代码解释
1.com.example.eldersystem文件夹下，不同的功能就创建不同的文件夹，比如sms文件夹对应短信功能，weather对应天气功能，db是数据库，fragment是碎片，gson是存放GSON模型相关的代码，service是服务，util是工具相关代码
2.layout文件夹下没有分类，名称是activity开头的，代表有相关联的活动，activity后面的单词代表相应的功能，如activity_smssent.xml，activity_weather.xml         不是activity开头的，代表单纯的布局，如weather开头的是天气界面的子布局(weather_aqi.xml,weather_now.xml等)，最后通过引入布局的方式集成到activity_weather.xml中
3.layout文件夹下，push_left_in和push_right_out是为了回退活动时，改变动画效果
4，activity_main.xml的布局是引入了desktop_layout.xml，如果需要修改主界面的布局，请修改desktop_layout.xml文件！！！！
