*** Settings ***
Resource          ../resources/resources.resource

*** Test Cases ***
Integration Flow: Welcome to Movie Details
    Open Application To Welcome Screen
    Go To Movie Grid

    # Tap the first movie in the grid
    Click Element    xpath=(//android.view.View[@clickable='true'])[2]

    # Verify we are on details screen
    Wait Until Page Contains    Release Date:    timeout=10s
    Wait Until Page Contains    Overview:        timeout=5s
    [Teardown]    Close Application
