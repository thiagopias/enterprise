package com.myplantdiary.enterprise.service;

import com.myplantdiary.enterprise.dao.IPlantDAO;
import com.myplantdiary.enterprise.dao.ISpecimenDAO;
import com.myplantdiary.enterprise.dto.Plant;
import com.myplantdiary.enterprise.dto.Specimen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SpecimenService implements ISpecimenService {

    @Autowired
    private ISpecimenDAO specimenDAO;

    @Autowired
    private IPlantDAO plantDAO;

    public SpecimenService() {

    }

    public SpecimenService(ISpecimenDAO specimenDAO) {

        this.specimenDAO = specimenDAO;
    }

    @Override
    public Specimen fetchById(int id) {
        Specimen foundSpecimen = specimenDAO.fetch(id);
        return foundSpecimen;
    }

    @Override
    public void delete(int id) throws Exception {
        specimenDAO.delete(id);
    }

    @Override
    public Specimen save(Specimen specimen) throws Exception {
        return specimenDAO.save(specimen);
    }

    @Override
    public List<Specimen> fetchAll() {
        return specimenDAO.fetchAll();
    }

    @Override
    public List<Plant> fetchPlants(String combinedName) throws IOException {
        return plantDAO.fetchPlants(combinedName);
    }
}