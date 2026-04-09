*** Settings ***
Resource          ../resources/resources.resource

*** Test Cases ***
Verify App Launch And Welcome Screen
    Open Application To Welcome Screen
    [Teardown]    Close Application
