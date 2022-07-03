Feature: US1005 Kullanici databasede update yapar

  Scenario: Kullanici update yapabilmeli

    Given kullanici DBUtils ile HMC veri tabanina baglanir
    Then tHOTEL tablosunda IDHotel degeri 1 olan kaydin Email bilgisini "yannii@gmail.com" yapar
    #UPDATE tHOTEL SET Email = 'sizOldunuz@gmail.com' WHERE IDHotel=1016;
