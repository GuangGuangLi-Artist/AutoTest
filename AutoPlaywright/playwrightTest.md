
#执行测试并生成Allure报告

    1.mvn clean test
    2.allure generate target/allure-results --clean -o target/allure-report
    3.allure open target/allure-report
---------------------------------------
    1.mvn allure:serve
---------------------------------------
    1.执行不同的测试套 mvn clean test -DsuiteFile="src/test/resources/suites/login-suite.xml"
    2.mvn clean test \ -DsuiteFile="src/test/resources/suites/regression-suite.xml" \ -Ddata.format="json"


