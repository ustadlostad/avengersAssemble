# Project Title

Yemek Sepeti Challenge

## Before Starting

* TestNG and Selenium are used for this project.

## Test Covarage

1) Login scenarios

2) Add / delete favorite restaurant scenarios

## How to Run Tests and Get Report

After cloning the project "mvn clean test" command can be used via using command line.

Example : <projectFolderLocation> mvn clean test

Report Location :
projectFolderLocation\test-results\extent.html

Report file need to be opened with a browser.

Failed test screenshots will be available project's Fails folder.

## Before Run

Tests are running cross browser by default. If it needs to be switch parallel run, testN.xml file needs to be
rearranged.

parallel="tests" thread-count="2" states need to be added in the testNG.xml file.

## Structure

MAVEN - Project Structure.

## Project Owner

Batur Türkmen [ustadlostad](https://github.com/ustadlostad)
