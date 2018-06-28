# learn-android-from-commits

> 跟着仓库提交记录学习Android开发，实现[SimpleNews](https://github.com/Gnotes/SimpleNews)项目

## 开发环境

- JDK: 1.8
- Gradle: 4.4
- Android Studio: 3.1.3
- OS: Mac

# Follow Me

## 第一章

- [初始化项目](https://github.com/Gnotes/learn-android-from-commits/commit/a450ed0f47babdf3fd8468b4f0a3c4d153439491)

打开 `Android Studio` 初始化一个Android项目 `SimpleNews`，选择 `minSdkVersion` 为 `19` ，默认会使用当前下载的最新编译版本 `compileSdkVersion` ，我的是`27`，然后选择创建一个 `Basic Activity` ，`Finish`，安装完成后可以看到初始化的项目。点击启动会展示如下界面。  

  <img src="./screenshot/1.png" width="320"/>

### 需要了解的知识点

- Toolbar
- FloatingActionButton
- Snackbar
- CoordinatorLayout
- AppBarLayout
- ConstraintLayout
- xmlns
- supportsRtl
- roundIcon
- apply plugin: 'com.android.application'
- apply plugin: 'com.android.library'
- com.android.support:appcompat-v7:*
- com.android.support.constraint:constraint-layout:*
- com.android.support:design:*

## 其他知识点

Android Studio 模拟器截屏：`Command + s`