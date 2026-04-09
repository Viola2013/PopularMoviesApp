*** Settings ***
Library           AppiumLibrary

*** Variables ***
${REMOTE_URL}     http://127.0.0.1:4723
${PLATFORM_NAME}  Android
${DEVICE_NAME}    R58N109C91Y
${APP_PACKAGE}    com.viola2013.popularmoviesapp
${APP_ACTIVITY}   com.viola2013.popularmoviesapp.MainActivity
${APP_PATH}       C:/Users/mervi/AndroidStudioProjects/PopularMoviesApp/app/build/intermediates/apk/debug/app-debug.apk
${AUTOMATION_NAME}  UiAutomator2

*** Keywords ***
Open Application To Welcome Screen
    # Launching by Package/Activity to bypass APK signature verification
    Open Application    ${REMOTE_URL}
    ...    platformName=${PLATFORM_NAME}
    ...    deviceName=${DEVICE_NAME}
    ...    appPackage=${APP_PACKAGE}
    ...    appActivity=${APP_ACTIVITY}
    ...    automationName=${AUTOMATION_NAME}
    ...    noReset=false
    ...    fullReset=false

    Wait Until Page Contains    Popular Movies App    timeout=30s

Go To Movie Grid
    Wait Until Element Is Visible    android=new UiSelector().text("View Popular Movies")    timeout=15s
    Click Element    android=new UiSelector().text("View Popular Movies")
    # Wait for the Sort icon to appear in the top bar, indicating movies loaded successfully
    Wait Until Page Contains Element    accessibility_id=Sort    timeout=25s
