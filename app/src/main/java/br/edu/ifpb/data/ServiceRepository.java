package br.edu.ifpb.data;

import br.edu.ifpb.domain.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.domain.model.services.*;
import br.edu.ifpb.domain.wrappers.*;
import br.edu.ifpb.exceptions.*;
import br.edu.ifpb.interfaces.service.*;

public class ServiceRepository {
    private List<Service> services;
    private static ServiceRepository instance;

    private ServiceRepository() {
        this.services = new ArrayList<>();
        loadServicesFromDB();
    }

    // Padrão de Criação: Singleton
    public static ServiceRepository getInstance() {
        if (instance == null) {
            instance = new ServiceRepository();
        }
        return instance;
    }

    private Connection connect() {
        String url = "jdbc:sqlite:meu_banco_de_dados.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void saveServicesToDB() {
        String insertSql = "INSERT INTO services (id, breakfeast_service, pet_care_service, spa_service, tourism_guide_service) VALUES (?, ?, ?, ?, ?)";
        String updateSql = "UPDATE services SET breakfeast_service = ?, pet_care_service = ?, spa_service = ?, tourism_guide_service = ? WHERE id = ?";
    
        try (Connection conn = this.connect()) {
            for (Service service : this.services) {
                ServiceDecorator serviceDecorator = service.getServices();
    
                boolean breakfast = serviceDecorator instanceof BreakFastService;
                boolean petcare = serviceDecorator instanceof PetCareService;
                boolean spa = serviceDecorator instanceof SpaService;
                boolean tourism = serviceDecorator instanceof TourismGuideService;
    
                // Verifica se o serviço já existe no banco
                if (serviceExists(conn, service.getServiceId().getValue())) {
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                        updateStmt.setBoolean(1, breakfast);
                        updateStmt.setBoolean(2, petcare);
                        updateStmt.setBoolean(3, spa);
                        updateStmt.setBoolean(4, tourism);
                        updateStmt.setInt(5, service.getServiceId().getValue());
    
                        updateStmt.executeUpdate();
                    }
                } else {
                    // Insere novo serviço
                    try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                        insertStmt.setInt(1, service.getServiceId().getValue());
                        insertStmt.setBoolean(2, breakfast);
                        insertStmt.setBoolean(3, petcare);
                        insertStmt.setBoolean(4, spa);
                        insertStmt.setBoolean(5, tourism);
    
                        insertStmt.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean serviceExists(Connection conn, int serviceId) {
        String checkSql = "SELECT id FROM services WHERE id = ?";
    
        try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
            checkStmt.setInt(1, serviceId);
            ResultSet rs = checkStmt.executeQuery();
    
            return rs.next(); // true = ja existe no banco 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void loadServicesFromDB() {
        String selectSql = "SELECT id, breakfeast_service, pet_care_service, spa_service, tourism_guide_service FROM services";

        try (Connection conn = this.connect();
             PreparedStatement selectStmt = conn.prepareStatement(selectSql);
             ResultSet rs = selectStmt.executeQuery()) {

            while (rs.next()) {
                // Inicializa serviço básico
                ServiceDecorator services = new BaseService();
                
                // Checar quais serviços estão presentes e adicionar os decoradores correspondentes
                if (rs.getBoolean("breakfeast_service")) {
                    services = new BreakFastService(services);
                }
                if (rs.getBoolean("pet_care_service")) {
                    services = new PetCareService(services);
                }
                if (rs.getBoolean("spa_service")) {
                    services = new SpaService(services);
                }
                if (rs.getBoolean("tourism_guide_service")) {
                    services = new TourismGuideService(services);
                }

                // Criar objeto Service e adicionar à lista interna
                Service service = new Service();
                service.setServiceId(new Id(rs.getInt("id")));
                service.addService(services);

                this.services.add(service);  // Adiciona o serviço à lista interna
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addService(Service service, boolean hasBreakfast, boolean hasPetCare, boolean hasSpa, boolean hasTourism) {
        String insertSql = "INSERT INTO services (id, breakfeast_service, pet_care_service, spa_service, tourism_guide_service) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = this.connect();
            PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {

            insertStmt.setInt(1, service.getServiceId().getValue());
            insertStmt.setBoolean(2, hasBreakfast);
            insertStmt.setBoolean(3, hasPetCare);
            insertStmt.setBoolean(4, hasSpa);
            insertStmt.setBoolean(5, hasTourism);

            insertStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateService(Service service) {
        String updateSql = "UPDATE services SET breakfeast_service = ?, pet_care_service = ?, spa_service = ?, tourism_guide_service = ? WHERE id = ?";
    
        try (Connection conn = this.connect();
            PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
    
            ServiceDecorator serviceDecorator = service.getServices();
    
            boolean breakfast = serviceDecorator instanceof BreakFastService;
            boolean petcare = serviceDecorator instanceof PetCareService;
            boolean spa = serviceDecorator instanceof SpaService;
            boolean tourism = serviceDecorator instanceof TourismGuideService;
    
            updateStmt.setBoolean(1, breakfast);
            updateStmt.setBoolean(2, petcare);
            updateStmt.setBoolean(3, spa);
            updateStmt.setBoolean(4, tourism);
            updateStmt.setInt(5, service.getServiceId().getValue());
    
            int affectedRows = updateStmt.executeUpdate();
            if (affectedRows == 0) {
                throw new ServiceNotFoundException();
            }
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeService(Id serviceId) {
        String deleteSql = "DELETE FROM services WHERE id = ?";
    
        try (Connection conn = this.connect();
            PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {
    
            deleteStmt.setInt(1, serviceId.getValue());
    
            int affectedRows = deleteStmt.executeUpdate();
            if (affectedRows == 0) {
                throw new ServiceNotFoundException();
            }
    
            services.removeIf(service -> service.getServiceId().equals(serviceId));
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    

    public List<Service> getServices() {
        return services;
    }

    public Service findServiceById(Id serviceId) {
        for (Service service : services) {
            if (service.getServiceId().equals(serviceId)) {
                return service;
            }
        }
        throw new ServiceNotFoundException();
    }
}
