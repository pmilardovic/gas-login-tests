# Giphy automated tests

<img src="https://user-images.githubusercontent.com/18185475/97309328-274ab080-1862-11eb-9f45-c613df78c353.png" width="300" height="100">

Giphy is a website that enables users to explore and share website GIFs and most popular animated GIFs.

##### In the repository there is a folder 'Documentation'. The folder contains detailed documentation about the project -> Test Plan, Test Cases and Jenkins Setup


## Development environment

## Java

You must have Java installed.<br/>
Download it from Oracle http://www.oracle.com/technetwork/java/javase/downloads/index.html and install. (If you don't have it already)

## Git Bash

 Download Git Bash.<br/>
 Follow instructions here: https://www.stanleyulili.com/git/how-to-install-git-bash-on-windows/ and install. (If you don't have it already)

## Running tests using Git command line (Git Bash) or Windows cmd (No IntelliJ needed)

1. Create an empty folder where you want to clone the project. 
2. Open Git Bash inside the created folder and run following command: git clone https://github.com/pmilardovic/giphy-automated-tests.git
3. A popup will open where github username and password are required. 
4. After entering valid credentials, repository is successfully cloned within the folder.

How to run the tests: 

1. Navigate to the directory where the tests are located.
2. For Windows: **./gradlew test**

3. For MacOS: <br/>
   a. Run **brew install gradle** <br/>
   b. Give root access to gradlew by doing: **chmod +x ./gradlew** <br/> 
   c. Run **./gradlew test**<br/>

4. Windows cmd: **gradlew test**

<img src="https://user-images.githubusercontent.com/18185475/97432719-af8d8c00-191c-11eb-8773-fed115f2ea1d.png" width="550" height="450">

After executing the tests, the test report is visible in the reports folder.
The correct path where the reports are located is pointed out in Git Bash.

<img src="https://user-images.githubusercontent.com/18185475/97435433-b1594e80-1920-11eb-93e0-593c85973e02.png" width="550" height="450">

<img src="https://user-images.githubusercontent.com/18185475/97416490-cc1ec980-1906-11eb-940f-4b1ebf19e20f.png" width="550" height="350">

## IntelliJ IDEA

The recommended development environment is IntelliJ IDEA community version.
Download it from Jet BRAINS https://www.jetbrains.com/idea/download and install it.

1. If no project is currently opened, click Get from Version Control on the Welcome screen or from the main menu or select VCS | Get from Version Control.

<img src="https://user-images.githubusercontent.com/18185475/97410756-c07bd480-18ff-11eb-9baa-5ac23729ac28.png" width="550" height="300">

2. In the Get from Version Control dialog, specify the URL of the remote repository you want to clone, or select one of the VCS hosting services on the left.
3. Click Clone. If you want to create a project based on the sources you have cloned, click Yes in the confirmation dialog.

   If your project contains submodules, they will also be cloned and automatically registered as project roots.

<img src="https://user-images.githubusercontent.com/18185475/97410252-20be4680-18ff-11eb-8c5b-7ba82232c163.png" width="550" height="300">

## Running tests

For running tests, if not already, please download Chrome browser https://www.google.com/chrome/?brand

To run all tests, select folder 'test' in the Project tool window and press Ctrl+Shift+F10 or select Run Tests in 'folder' from the context menu.

<img src="https://user-images.githubusercontent.com/18185475/97411116-236d6b80-1900-11eb-9e38-6e406c03c73c.png" width="550" height="450">

To run a single test, click on the 'test' folder again and click the desired test class.
From the test class select the test method and run by pressing Ctrl+Shift+F10 or select Run Tests in 'folder' from the context menu.

<img src="https://user-images.githubusercontent.com/18185475/97411486-9ecf1d00-1900-11eb-882c-84f09c07ee10.png" width="550" height="450">

After IntelliJ IDEA finishes running your tests, it shows the results in the Run tool window on the Test Runner tab. 

<img src="https://user-images.githubusercontent.com/18185475/97411941-2f0d6200-1901-11eb-8be1-9116bc4f53f1.png" width="550" height="450">

## Stop tests

Click the Stop button or press Ctrl+F2 to terminate the process immediately.

<img src="https://user-images.githubusercontent.com/18185475/97412375-c8d50f00-1901-11eb-8d82-d6ed15cd61cc.png" width="500" height="550">


## Exporting Test Results

For exporting test results to a different format click the 'Export Test Results' on the Test Runner toolbar.

<img src="https://user-images.githubusercontent.com/18185475/97416869-48b1a800-1907-11eb-8e35-15ecf9ef5410.png" width="500" height="350">

1. Select the format in which you want to save the file: HTML, XML 
2. Specify the name of the output file and its location.
3. If you want to open the file in your browser after you export it, select the Open exported file in browser checkbox. Click OK.

<img src="https://user-images.githubusercontent.com/18185475/97417425-f58c2500-1907-11eb-97da-b233b549d1fa.png" width="250" height="250">
