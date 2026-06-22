package com.duoc.msadmin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.msadmin.model.Admin;
import com.duoc.msadmin.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    


    //CREATE
    public Admin crearAdmin(Admin admin) {
    if (adminRepository.existsByNombre(admin.getNombre())) {
        throw new RuntimeException("Admin con nombre " + admin.getNombre() + " ya existe");
            }return adminRepository.save(admin);
            
    }



    //READ 
    public List<Admin> mostrarAdministradores() {
        if (adminRepository.findAll().isEmpty()) {
            throw new RuntimeException("No hay administradores registrados");
        }
        return adminRepository.findAll();
    }

    
    //FIND BY ID
    public Admin buscarAdminPorId(Integer idAdmin) {
        return adminRepository.findById(idAdmin)
                .orElseThrow(() -> new RuntimeException("Admin con id " + idAdmin + " no encontrado"));
    }

     
    //DELETE
    public void eliminarAdmin(Integer idAdmin) {
        if (!adminRepository.existsById(idAdmin)) {
            throw new RuntimeException("Admin con id " + idAdmin + " no encontrado");
        }adminRepository.deleteById(idAdmin);
    }
    
}
