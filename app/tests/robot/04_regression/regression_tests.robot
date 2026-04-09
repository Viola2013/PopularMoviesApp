*** Settings ***
Resource          ../resources/resources.resource

*** Test Cases ***
Regression: Verify Sort and About Dialog
    Open Application To Welcome Screen
    Go To Movie Grid

    # Check About Dialog
    Wait Until Page Contains Element    accessibility_id=About    timeout=10s
    Click Element    accessibility_id=About

    # Verify Dialog Content (Usage string from strings.xml)
    Wait Until Page Contains    Usage:

    # Close Dialog
    Click Element    android=new UiSelector().text("OK")

    # Check Sort Toggle
    Wait Until Page Contains Element    accessibility_id=Sort    timeout=10s
    Click Element    accessibility_id=Sort

    # Verify we are still on the grid (Sort icon is visible)
    Wait Until Page Contains Element    accessibility_id=Sort    timeout=15s

    [Teardown]    Close Application
