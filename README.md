# Final Project: Secure Programming NWMUS 2023

[![Run JUnit Tests (Gradle)](https://github.com/Rdevezeaux7685/Final-Project/actions/workflows/runtests.yml/badge.svg)](https://github.com/Rdevezeaux7685/Final-Project/actions/workflows/runtests.yml)

![Coverage](.github/badges/jacoco.svg)

## Table of Contents

- [1. Project Analysis](#1-project-analysis)
  - [1.1 PMD](#11-pmd)
  - [1.2 Coverage](#12-coverage)
    - [1.2.1 IntelliJ](#121-intellij)
    - [1.2.2 JaCoCo](#122-jacoco)
      - [Exclude Class/Methods](#exclude-classmethods)
  - [1.3 Tests](#13-tests-and-github-workflow)
  - [1.4 Fighting with Java](#14-fighting-with-java)
- [2. Improvement](#2-improvement)
  - [2.1 Tests](#21-tests)
  - [2.2 Database / SQL](#22-database--sql)
  - [2.3 Input Validation](#23-input-validation)

---

# 1. Project Analysis

## 1.1 PMD

For project analysis, I employed the [PMD Source Code Analyzer](https://pmd.github.io/).

> pmd.bat check -d "C:\Users\romane\Documents\NW 2023\SP project"  -R rulesets/java/quickstart.xml -f html > C:\Users\romane\Desktop\testPMD.html
> 
> 
Explore the detailed analysis results [here](/Analysis/PMD-Report.html).

![PMD Report](/Analysis/PMD-Report.png)

## 1.2 Coverage

I will be using both **IntelliJ Building Coverage** and **JaCoCo**. As seen in the following screenshots, the coverage was not perfect but not at 0, which is a positive sign.

### 1.2.1 IntelliJ

![IntelliJ Coverage Report](/Analysis/Coverage/Intelij/Coverage-Report.png)

Html report can be found [here](/Analysis/Coverage/IntelliJ).

### 1.2.2 JaCoCo

![JaCoCo Coverage Report](/Analysis/Coverage/JaCoCo/jacoco-report.png)

Html report can be found [here](/Analysis/Coverage/JaCoCo).

I have added a GitHub workflow that creates a JaCoCo report with every push, along with a percentage badge at the beginning of this README. The original badge before adding the tests can be seen ![here](Analysis/Coverage/JaCoCo/jacocobadge.png).

#### Exclude Class/Methods

To exclude classes and/or methods from the JaCoCo report, I added the `@Generated` annotation, following the instructions in this [Source: Jacoco report exclude](https://www.baeldung.com/jacoco-report-exclude).

---

By putting the two reports next to each other, we can directly observe significant differences in results, especially for the **data**.

![Coverage Comparison](/Analysis/Coverage-compare.png)

---

## 1.3 Tests and GitHub Workflow

Find my workflow action [here](https://github.com/Rdevezeaux7685/Final-Project/actions/workflows/runtests.yml). 
The actions run automatically with every push.

While the Gradle plugin in IntelliJ works perfectly fine, I encountered issues using `./gradlew` from the terminal. 
his problem was resolved by changing the JAVA version to Java 17.

> Jacoco badge instructions: [jacoco-badge-generator](https://github.com/cicirello/jacoco-badge-generator)

### 1.4 Fighting with Java

Adding `%USERS%.jdks\azul-17.0.9\bin` to my path helped change the Java version, enabling building from the terminal. 
For the GitHub action, updating the YAML file to use Java 17 resolved the issue.

# 2 Improvement

## 2.1 Tests

Basic tests were added to the project using the IntelliJ built-in test generator. 
I added tests for the `domain` classes and the `util/cli` and `util`. 
Although these tests improved project coverage, they do not cover every possible outcome and could be enhanced.

![Generate Tests](Analysis/generate-test.png)

## 2.2 Database / SQL

The SQL classes were already covering the security advice provided in class. 
Usernames/passwords are **encrypted** and not used as plaintext. 
Encryption files can be found in `/util`, and the configuration file for the database is in `resource/config/config.properties`. I used **prepared statements** and `stmt.setString` to protect the data and prevent potential SQL injections.

## 2.3 Input Validation

Currently, there is no input validation, but this will be addressed in an upcoming update.

## 2.3 PMD

### 2.3.1 One-line If/Else

Upon reviewing the PMD report, some issues were identified. For instance, PMD considers having an `if` statement on one line without braces as an error.

Initially, I did not agree with this and had to add braces:
![Not Approved by PMD](/Analysis/pmd-not-ok.png)

Here is the **PMD-approved** version:
![PMD Approved](/Analysis/pmd-ok.png)

### 2.3.2 Error Messages

My `ErrorMessage` class was initially designed to return simple strings, providing minimal information in case of a code failure and exception.  PMD suggested keeping the caught exception and including it in the `ErrorMessage`. However, this approach raises concerns about confidentiality (CIA: Confidentiality, Integrity, Availability).

### PMD New report:

The new report made after improvements can be found [here](/Improvement/pmd-report.txt)
![](/Improvement/pmd.png)

_(The project has been relocated on my computer, resulting in a different file path compared to the previous report. However, the project itself remains the same)_



---

*Written by: Romane Devezeaux de Lavergne*
