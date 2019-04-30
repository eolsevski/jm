package service;


import model.Gyventojas;
import repository.GyventojasRepository;

import java.sql.SQLException;
import java.util.List;

public class GyventojasService {

    private GyventojasRepository gyventojasRepository;

    public GyventojasService(GyventojasRepository gyventojasRepository) {
        this.gyventojasRepository = gyventojasRepository;

    }

    public List<Gyventojas> uzkrautiDuomenis() {

        List<Gyventojas> gyventojai = null;

        try {
            gyventojai = gyventojasRepository.findAll();
        } catch (SQLException sqlException) {
            System.out.println("Failed to fetch user comment counts " + sqlException.getMessage());
        } catch (Exception exception) {
            System.out.println("Unexpected" + exception.getMessage());
        }
        return gyventojai;
    }
}
