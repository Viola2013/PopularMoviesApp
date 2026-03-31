*** Settings ***
Library           AppiumLibrary

*** Variables ***
${REMOTE_URL}     http://localhost:4723/wd/hub
${PLATFORM_NAME}  Android
${DEVICE_NAME}    Android Emulator
${APP_PACKAGE}    com.viola2013.popularmoviesapp
${APP_ACTIVITY}   .MainActivity

*** Test Cases ***
Verify App Launch And Welcome Screen
    Open Application    ${REMOTE_URL}    platformName=${PLATFORM_NAME}    deviceName=${DEVICE_NAME}    appPackage=${APP_PACKAGE}    appActivity=${APP_ACTIVITY}    automationName=UiAutomator2
    Wait Until Page Contains    Popular Movies App    timeout=10s
    Wait Until Page Contains    View Popular Movies
    [Teardown]    Close Application
