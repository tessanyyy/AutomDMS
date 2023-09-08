Feature: Home

  Scenario: Klik internal
    When user klik more info internal
    Then menampilkan halaman internal

  Scenario: Klik eksternal
    When user klik tab home eksternal
    And user klik more info eksternal
    Then menampilkan halaman eksternal

  Scenario: Klik perizinan
    When user klik tab home perizinan
    And user klik more info perizinan
    Then menampilkan halaman perizinan

