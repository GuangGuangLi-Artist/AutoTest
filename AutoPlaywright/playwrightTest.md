
#执行测试并生成Allure报告

    1.mvn clean test
    2.allure generate target/allure-results --clean -o target/allure-report
    3.allure open target/allure-report
---------------------------------------
    1.mvn allure:serve

