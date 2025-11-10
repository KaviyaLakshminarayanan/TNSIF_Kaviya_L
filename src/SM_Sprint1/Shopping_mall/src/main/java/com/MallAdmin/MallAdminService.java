package com.MallAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MallAdminService {

    @Autowired
    private MallAdminRepository repo;

    // Fetches all MallAdmin records from the database
    public List<MallAdmin> listAll() {
        return repo.findAll();
    }

    // Saves a new or updated MallAdmin entity
    public MallAdmin save(MallAdmin mallAdmin) {
        if (mallAdmin.getLastLoginTime() == null) {
            // Set the current date if the lastLoginTime is not provided
            mallAdmin.setLastLoginTime(LocalDateTime.now());
        }
        return repo.save(mallAdmin);
    }

    // Fetches a MallAdmin by its ID
    public MallAdmin get(Integer id) {
        return ((Optional<MallAdmin>) repo.findById(id))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "MallAdmin not found with ID: " + id));
    }

    // Deletes a MallAdmin by its ID
    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "MallAdmin not found with ID: " + id);
        }
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting MallAdmin with ID: " + id);
        }
    }
}
