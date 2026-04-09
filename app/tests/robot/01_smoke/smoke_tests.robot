*** Settings ***
Resource          ../resources/resources.resource

*** Test Cases ***
Smoke Test: Launch App and Verify Title
    Open Application To Welcome Screen
    Wait Until Page Contains    Popular Movies App    timeout=15s
    [Teardown]    Close Application
