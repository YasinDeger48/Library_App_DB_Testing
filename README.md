# Cucumber Framework for Library_App_DB_Testing
## _Framework Format_

<img src="https://github.com/YasinDeger48/XFleet_Cucumber/blob/master/cucumber.png" width="80" height="80">


## Clone the repository and make the desired code changes:

```sh
git clone https://github.com/YasinDeger48/XFleet_Cucumber.git
```


create Java packages:
> runners,
> pages(POM),
> utilities,
> step_definitions

### Runners directory,
- This classes just needs annotations to understand that cucumber features would be run through it and you can specify feature files to be picked up plus the steps package location.

### Pages (POM) directory,
- Page Object Model, also known as POM, is a design pattern in Selenium that creates an object repository for storing all web elements. It is useful in reducing code duplication and improves test case maintenance. In Page Object Model, consider each web page of an application as a class file.

### Utilities Directory,
- To store utility like Excel Utility, Config Utility, Report Utility, Database Utility, Screenshot Utility, Driver, CucumberRunnerTest etc. We can also keep util in src/main/java if dev and test code is in same framework.

### Step Definitions Directory,
- To store cucumber step definitions

Create Utility packages:
> Driver(Singleton Design Pattern),
> BrowserUtils,
> ConfigurationReader

### Driver Class benefits,
- We are writing too many lines just to be able to instantiate our WebDriver
- We are having hard time to pass the SAME 'driver' instance around in our project.When we are using any utilty method, currently we have to pass "WebDriver driver" as argument in each utility method.
- Singleton Design Pattern guarantuees to return same object everytime we want to use the object.


### BrowserUtils Class benefits,
- We need that for basic and easy to understandable code
- Also include static wait


### ConfigurationProperties benefits,
- to avoid hard coding,
- externilize the test data and avoid effecting the project,
- centerlized location,
- cross browser testing

create resources directory same level with java directory the purpose is to hold our scenarios for the project


