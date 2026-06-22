package com.duoc.mstipohabitacion.dataloader;

import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase abstracta base para dataloaders (seeders) coherente en todos los microservicios.
 * Proporciona estructura común para carga de datos de prueba.
 */
public abstract class AbstractDataLoader implements CommandLineRunner {
    
    protected static final Logger logger = LoggerFactory.getLogger(AbstractDataLoader.class);
    
    /**
     * Verifica si ya existen datos en la base de datos
     */
    protected abstract boolean datosExisten();
    
    /**
     * Carga los datos de prueba
     */
    protected abstract void cargarDatos();
    
    /**
     * Obtiene el nombre del dataloader para logs
     */
    protected abstract String getNombreDataLoader();
    
    @Override
    public void run(String... args) throws Exception {
        String nombre = getNombreDataLoader();
        
        try {
            if (datosExisten()) {
                logger.info("[{}] Los datos ya existen en la base de datos. Saltando carga...", nombre);
                return;
            }
            
            logger.info("[{}] Iniciando carga de datos de prueba...", nombre);
            cargarDatos();
            logger.info("[{}] Datos cargados exitosamente ✓", nombre);
            
        } catch (Exception e) {
            logger.error("[{}] Error durante la carga de datos: {}", nombre, e.getMessage(), e);
            throw e;
        }
    }
}
