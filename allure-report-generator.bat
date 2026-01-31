@echo off
echo Running tests and generating Allure report...

REM Step 1: Generate Allure report (this is optional, `allure serve` will also generate it)
REM allure generate --clean allure-results

REM Step 2: Serve the Allure report and open it in the browser
echo Starting Allure server and opening the report in your default browser...
allure serve allure-results

pause

REM Optional: Exit the script
exit