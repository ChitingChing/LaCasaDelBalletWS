/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacasadelballetws.entities.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Seeting
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.lacasadelballetws.entities.service.AlumnoFacadeREST.class);
        resources.add(com.lacasadelballetws.entities.service.CategoriaFacadeREST.class);
        resources.add(com.lacasadelballetws.entities.service.CursoFacadeREST.class);
        resources.add(com.lacasadelballetws.entities.service.MatriculaFacadeREST.class);
        resources.add(com.lacasadelballetws.entities.service.PagoFacadeREST.class);
        resources.add(com.lacasadelballetws.entities.service.PagoventaFacadeREST.class);
        resources.add(com.lacasadelballetws.entities.service.PrecioFacadeREST.class);
        resources.add(com.lacasadelballetws.entities.service.ProductoFacadeREST.class);
        resources.add(com.lacasadelballetws.entities.service.TipocursoFacadeREST.class);
        resources.add(com.lacasadelballetws.entities.service.VentaFacadeREST.class);
    }
    
}
