Feature: Login Page

  Scenario Outline: Check access url login page
    Given Input url web dms "<Url>"
    Then Menampilkan halaman login "<TxtLoginPage>"
    Examples:
      | Url                                       | TxtLoginPage |
      | https://dev.ptdika.com/lamar2/loginuser   | Not Found    |
      | https://dev.ptdika.com/dokumen/home/login | DOKUMEN   |

  Scenario Outline: Check login page
    When User input username "<Username>"
    And User input password "<Password>"
    And Klik tombol Sign In
    Then Berhasil login dan menampilkan halaman home "<Message>"

    Examples:
      | Username | Password | Message |
      | qq       | a        | true    |
      |          | a        | true    |
      | qq       |          | true    |
      | qa3      | a        | Home    |
