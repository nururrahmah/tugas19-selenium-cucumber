Feature: Login Functionality

  Scenario: Login dengan data benar (positif)
    Given saya berada di halaman login
    When saya memasukkan username "tomsmith" dan password "SuperSecretPassword!"
    And saya klik tombol login
    Then saya berhasil login ke halaman dashboard

  Scenario: Login dengan data salah (negatif)
    Given saya berada di halaman login
    When saya memasukkan username "tomsmith" dan password "wrong"
    And saya klik tombol login
    Then saya melihat pesan error "Your password is invalid!"

  Scenario: Login dengan username kosong (batas)
    Given saya berada di halaman login
    When saya memasukkan username "" dan password "12345"
    And saya klik tombol login
    Then saya melihat pesan error "Your username is invalid!"
