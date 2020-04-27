# `ACLFramework`
<b>`If you've application in android, ios & web platforms and want to automate with single code base? This framework is for you.`</b><br><br>
This is a generic Page Object Model which solves all your automation needs with single codebase.<br>
We often tend to create different test frameworks for different platforms and it's very difficult for anyone to serve all platform needs in one test automation framework.<br>

<b>`ACLFramework solves all your needs. You just give the locator and leave the rest to OneFramework.`</b><br>

## Contents:

* [Features](#features)
* [Libraries Used](#libraries-used)
* [Prerequisites Installations](#prerequisites-installations)
* [Appium Setup](#appium-setup)
* [How This Framework Works](#how-this-framework-works)
* [How To Run Tests](#how-to-run-tests)
* [How To See Allure Result Report](#how-to-see-allure-result-report)
* [Image Comparison Output](#image-comparison-output)

## Features:

* Easy to automate any type of application 
* Cross platform(mobile & web) support with single codebase
* Page Object Model
* TestNG integration
* Image Comparison
* Allure Reporting
* Robust in nature
* Many configurations

## Libraries Used:

1. Appium
2. Selenium WebDriver
3. Java
4. TestNG
5. Gradle
6. WebDriverManager
7. AShot
8. Allure Report

## Prerequisites Installations:

1. <b>`JAVA 1.8`</b> - Install Java and set the JAVA_HOME path on your machine.
2. <b>`Node & NPM`</b> - Download & install node from `https://nodejs.org/en/download/`.
3. <b>`Gradle`</b> - Install Gradle.
4. <b>`Android`</b> - Install Android Studio & set <i><b>ANDROID_HOME</b></i> path.<br>
    -  Downloading the Android SDK
    -  Download the Android SDK tools such as 
       1. Build tools
       2. Platform tools
       3. Android Emulator
       4. Intel HAXM installer etc.....
       5. Create an emulator device from AVD manager   
5. <b>`iOS`</b> - Install XCode on your machine & download required iPhone/iPad simulators.<br>
6. <b>`Allure Report`</b> - Install Allure Report library on your machine. Please follow below link to install it on MAC.<br>
    Similarly install allure-report installer on your respective machine.
    https://docs.qameta.io/allure/#_installing_a_commandline
    
<b>`Note: If you want to run only on WEB, you don't need anything except JAVA.`</b><br>
<b>`Mentioned installations Node, Android & iOS are for mobile app automation & Rest like Gradle & Allure are for framework level`</b> 

## Appium Setup:

- <b>`Install Appium`</b> 
``` 
 $ sudo npm install -g appium@1.9.1 --unsafe-perm=true --allow-root 
```
- <b>`Appium Doctor`</b> - which is used to see if the appium setup is correctly done or not. Run it and fix the issues as per that.<br>
``` 
 $ sudo npm install -g appium-doctor --unsafe-perm=true --allow-root
 $ appium-doctor
```

## How This Framework Works:

This framework is built in Page Object Model style using TestNG framework.<br>
We have "testng.xml" file which has tests for each and every platform in cross browser/device testing fashion.
 
###### Here are the minimal things you have to do:
 
 - Create your tests
 - Create your Page Object class w.r.t test that you have written
 - If mobile app, Set the android, ios device details in corresponding files in resources directory
 - If web app, Set web app URL in BaseTest
 
## How To Run Tests:

$ gradle clean build
$ java -jar build/libs/Automation-1.0-SNAPSHOT.jar capture
$ java -jar build/libs/Automation-1.0-SNAPSHOT.jar compare
```
<b>`Note:`</b>`capture & compare are the image capture and compare modes.`</b>

## How To See Allure Result Report:

Once test execution is complete, allure-results directory gets generated. I assume you have already installed allure on your machine. If not, install it. If yes, run below command to see the report.
```
$ allure serve <allure-results path>
```

## Image Comparison Output:

Once image comparison is complete, all the images w.r.t platforms are published into local baselineImages directory at root level.
Now go to specific directory and get the image comparison resulted images.

difference image is created only when there is a difference in actual vs expected images.