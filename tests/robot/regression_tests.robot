*** Settings ***
Library           AppiumLibrary

*** Variables ***
${REMOTE_URL}     http://localhost:4723/wd/hub
${PLATFORM_NAME}  Android
${DEVICE_NAME}    Android Emulator
${APP_PACKAGE}    com.viola2013.popularmoviesapp
${APP_ACTIVITY}   .MainActivity

*** Test Cases ***
Regression: Verify Sort and About Dialog
    Open Application    ${REMOTE_URL}    platformName=${PLATFORM_NAME}    deviceName=${DEVICE_NAME}    appPackage=${APP_PACKAGE}    appActivity=${APP_ACTIVITY}    automationName=UiAutomator2

    # Go to Grid
    Wait Until Page Contains    View Popular Movies    timeout=10s
    Click Element    xpath=//android.widget.Button[@text='VIEW POPULAR MOVIES']

    # Check About
    Wait Until Page Contains Element    accessibility_id=About    timeout=10s
    Click Element    accessibility_id=About
    Wait Until Page Contains    Usage:
    Click Element    xpath=//android.widget.Button[@text='OK']

    # Check Sort Toggle (Stars/ThumbUp icons)
    Wait Until Page Contains Element    accessibility_id=Sort
    Click Element    accessibility_id=Sort
    # Simple check that we are still on the grid
    Wait Until Page Contains Element    xpath=//android.widget.ImageView

    [Teardown]    Close Application
