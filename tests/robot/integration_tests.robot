*** Settings ***
Library           AppiumLibrary

*** Variables ***
${REMOTE_URL}     http://localhost:4723/wd/hub
${PLATFORM_NAME}  Android
${DEVICE_NAME}    Android Emulator
${APP_PACKAGE}    com.viola2013.popularmoviesapp
${APP_ACTIVITY}   .MainActivity

*** Test Cases ***
Integration Flow: Welcome to Movie Details
    Open Application    ${REMOTE_URL}    platformName=${PLATFORM_NAME}    deviceName=${DEVICE_NAME}    appPackage=${APP_PACKAGE}    appActivity=${APP_ACTIVITY}    automationName=UiAutomator2
    Wait Until Page Contains    View Popular Movies    timeout=10s
    Click Element    xpath=//android.widget.Button[@text='VIEW POPULAR MOVIES']
    Wait Until Page Contains Element    xpath=//android.widget.ImageView    timeout=15s
    Click Element    xpath=(//android.widget.ImageView)[1]
    Wait Until Page Contains    Release Date:    timeout=10s
    [Teardown]    Close Application
