@echo off

REM Serve the Allure report
allure generate allure-results --clean -o allure-report

REM Pause to keep the command window open
pause

exit

