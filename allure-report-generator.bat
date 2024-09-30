@echo off
REM Change directory to the location of the project
cd /d %~dp0

REM Generate the Allure report
allure generate --clean allure-results

REM Serve the Allure report on a local server
allure serve allure-results
