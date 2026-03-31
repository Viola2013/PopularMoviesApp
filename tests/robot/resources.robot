*** Settings ***
Library           AppiumLibrary

*** Variables ***
${REMOTE_URL}     http://localhost:4723/wd/hub
${PLATFORM_NAME}  Android
${DEVICE_NAME}    Android Emulator
${APP_PACKAGE}    com.viola2013.popularmoviesapp
${APP_ACTIVITY}   .MainActivity
${AUTOMATION_NAME}  UiAutomator2

*** Keywords ***
Open Application To Welcome Screen
    Open Application    ${REMOTE_URL}    platformName=${PLATFORM_NAME}    deviceName=${DEVICE_NAME}    appPackage=${APP_PACKAGE}    appActivity=${APP_ACTIVITY}    automationName=${AUTOMATION_NAME}
    Wait Until Page Contains    Popular Movies App    timeout=10s

Go To Movie Grid
    Wait Until Page Contains    View Popular Movies    timeout=10s
    # Using click text is more robust in some cases than full xpath if index/class changes
    Click Text    View Popular Movies
    Wait Until Page Contains Element    xpath=//android.widget.ImageView    timeout=15s
