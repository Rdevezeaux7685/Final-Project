# Final Project: Secure Programming NWMUS 2023
[![Run JUnit Tests (Gradle)](https://github.com/Rdevezeaux7685/Final-Project/actions/workflows/runtests.yml/badge.svg)](https://github.com/Rdevezeaux7685/Final-Project/actions/workflows/runtests.yml)

![Coverage](.github/badges/jacoco.svg)

## Table of Contents

- [Project Analysis](#1-project-analysis)
  - [PMD](#pmd)
  - [Coverage](#coverage)
    - [IntelliJ](#inteliji)
    - [JaCoCo](#jacoco)
      - [Exclude Class/Methods](#exclude-classmethods)
  - [Tests](#tests-and-github-workflow)
    - [Fighting with Java](#fighting-with-java)
    

---

# Project Analysis

## PMD

For project analysis, I employed the [PMD Source Code Analyzer](https://pmd.github.io/).

The analysis results can be explored in detail through the following link: [PMD-Report](/Analysis/PMD-Report.html)



![PMD Report](/Analysis/PMD-Report.png)


## Coverage

I will be firstly using both <span style="background-color:#3498db; color:#fff;">Intelij Building Coverage</span> and <span style="background-color:#e74c3c; color:#fff;">Jacoco</span>
As one can see on the following screenshots, the coverage was terrible, but wasn't at 0, which is already, something.


### Inteliji


![](/Analysis/Coverage/Intelij/Coverage-Report.png)

Html report can be found here: [Intelij report](/Analysis/Coverage/Intelij)


### Jacoco

![](/Analysis/Coverage/JaCoCo/jacoco-report.png)

Html report can be found here: [Jacoco report](/Analysis/Coverage/JaCoCo)


I have added a GitHub workflow that make a Jacoco report at every push, I also provide a percentage badge that was put in the beginning of this README.

This is the original badge before I made the tests.
![img.png](Analysis/Coverage/JaCoCo/jacocobadge.png)

#### Exclude Class/Methods

To exclude classes and/or methods from the Jacoco report, I have added the @Generated annotation following the instruction in this source [Exclusions from Jacoco Report](https://www.baeldung.com/jacoco-report-exclude)



---

By putting the 2 reports next to each other, we can directly stop some big difference of result, especially for the **data**

![](/Analysis/Coverage-compare.png)


## Tests and GitHub Workflow

My workflow action can be found here:
[GitHub Actions](https://github.com/Rdevezeaux7685/Final-Project/actions/workflows/runtests.yml). The actions are run automatically at every `push`.


While the gradle plugin on Intilij works perfectly fine, It seems I am unable to use ./gradlew from the terminal. 
It is also having the same problem in GitHub actions I created.

**This was fixed by changing the JAVA version to java 17.**

> Jacoco badge instructions: [jacoco-badge-generator](https://github.com/cicirello/jacoco-badge-generator)


#### Fighting with Java

Adding this `%USERS%.jdks\azul-17.0.9\bin` to my path to change the version of java and be able to build this from the terminal.

For the GitHub action, just needed to update the yml file (version Java 17)

---

*Presented by: Romane Devezeaux de Lavergne*
