Feature: Data Master

  Scenario: Navigation menu data master (departemen)
    When klik Data master
    Then klik departemen

  Scenario: Mencari data berdasarkan input data
    When input data search departemen
    And klik search
    Then menampilkan data departemen

  Scenario Outline: Input data departemen valid
    When user klik input data departemen
    And user mengisi data departemen "<Departemen>"
    And user klik simpan add departemen
    Then data departemen ditambahkan "<type>" "<Departemen>"

    Examples:
      | Departemen   | type    |
      | Juara Coding | positif |
      |              | negatif |


#  Scenario: Input data departemen invalid
#    When user klik input data departemen invalid
#    And user mengosongkan data nama departemen
#    Then user klik simpan departemen invalid
#
#  Scenario: Edit data departemen valid
#    When user klik button edit
#    And user update nama departemen valid
#    Then user klik simpan update data departemen valid
#
#  Scenario: