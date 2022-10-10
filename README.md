# qa-automation-tests
This will be CucumberBDD Framework which will be capable of testing UI, API, db and More. It will use Java, TestNG, Gherkin and generate JVM Report

# Project Owner
Hassan Bhuiyan

# Automation Engineers
Hassan Bhuiyan,
Dee Karim and 
Craig Alford

# To fix code
1. CTL+A
2. CTL+ALT+L

# CarSaver-Automation-Test-Framework
Cucumber IO, Gherkin, Selenium WebDriver, Maven, TestNG, JVM Cucumber Report, GitLab and Java

# Pre Condition
1. Install Java JDK+JRE. Java home path for windows only
2. Install IDE such as Eclipse or IntelliJ
3. Ensure you have maven configured

# RUN OPTIONS
1. Clone the project
2. To run in parallel use command: mvn clean verify -Denv=stage -Dbrowser=ch -Dcucumber.filter.tags="@test"
3. To run in single use flag -Dthreads=single; mvn clean verify -Dthreads=single
4. To exclude a specific tag use 'not' with tag name i.e. mvn clean verify -Denv=stage -Dbrowser=ch -Dcucumber.filter.tags="not @ignore"
5. To post results to JIRA use flag -DPostResultsToJira=true

# Execute NE SSO Test
1. Run in single thread:
    1. mvn clean verify -Dthreads=single -Denv=stage_ne -Dbrowser=ch -Dcucumber.filter.tags="@NE_sso" -Dmaven.test.failure.ignore=true
2. Run in multiple threads:
    1. mvn clean verify -Denv=prod_carSaver -Dbrowser=ch -Dcucumber.filter.tags="NE" -Dmaven.test.failure.ignore=true

# Execute NON SSO eCommerce Tests
1. Run in single thread:
   1. mvn clean verify -Dthreads=single -Denv=stage_cse -Dbrowser=ch -Dcucumber.filter.tags="@CSE" -Dmaven.test.failure.ignore=true
Multiple tags:
   2. mvn clean verify -Dthreads=single -Denv=stage_cse -Dbrowser=ch -Dcucumber.filter.tags="@CSE_checkBox and not @BUG" -Dmaven.test.failure.ignore=true

# Execute Upgrade Test
1. Run in single thread:
   1. mvn clean verify -Dthreads=single -Denv=stage_up -Dbrowser=ch -Dcucumber.filter.tags="@UP" -Dmaven.test.failure.ignore=true

# Execute Portal Test
1. mvn clean verify -Dthreads=single -Denv=stage_portal -Dbrowser=ch -Dcucumber.filter.tags="@portal" -Dmaven.test.failure.ignore=true

# Execute Atlas Test
1. mvn clean verify -Dthreads=single -Denv=stage_atlas -Dbrowser=ch -Dcucumber.filter.tags="@atlas" -Dmaven.test.failure.ignore=true