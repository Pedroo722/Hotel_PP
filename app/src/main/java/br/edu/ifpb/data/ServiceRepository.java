// package br.edu.ifpb.data;

// import br.edu.ifpb.domain.model.*;
// import br.edu.ifpb.domain.wrappers.Id;
// import br.edu.ifpb.exceptions.ServiceNotFoundException;
// import br.edu.ifpb.interfaces.repository.ServiceRepositoryInterface;
// import java.sql.*;
// import java.util.ArrayList;
// import java.util.List;

// public class ServiceRepository implements ServiceRepositoryInterface {
//     private static ServiceRepository instance;
//     private List<Service> services;
//     private ObjectMapper objectMapper;

//     private ServiceRepository() {
//         this.services = new ArrayList<>();
//         this.objectMapper = new ObjectMapper();
//         loadServicesFromDB();
//     }

//     public static ServiceRepository getInstance() {
//         if (instance == null) {
//             instance = new ServiceRepository();
//         }
//         return instance;
//     }

//     private Connection connect() {
//         String url = "jdbc:sqlite:meu_banco_de_dados.db";
//         Connection conn = null;
//         try {
//             conn = DriverManager.getConnection(url);
//         } catch (SQLException e) {
//             System.out.println(e.getMessage());
//         }
//         return conn;
//     }

//     public void saveServicesToDB() {
//         String insertServiceSql = "INSERT INTO services(description, components) VALUES(?, ?)";
//         try (Connection conn = this.connect();
//              PreparedStatement insertStmt = conn.prepareStatement(insertServiceSql)) {

//             for (Service service : services) {
//                 insertStmt.setString(1, service.getDescription()); // Supondo que Service tem um método getDescription()
//                 String componentsJson = objectMapper.writeValueAsString(service.getListOfServices());
//                 insertStmt.setString(2, componentsJson);
//                 insertStmt.executeUpdate();
//             }
//         } catch (SQLException e) {
//             System.out.println(e.getMessage());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     public void loadServicesFromDB() {
//         String loadServicesSql = "SELECT id, description, components FROM services";

//         try (Connection conn = this.connect();
//              Statement stmt = conn.createStatement();
//              ResultSet rs = stmt.executeQuery(loadServicesSql)) {

//             services.clear();

//             while (rs.next()) {
//                 Id serviceId = new Id(rs.getInt("id"));
//                 String description = rs.getString("description");
//                 String componentsJson = rs.getString("components");

//                 List<ServiceComponent> components = objectMapper.readValue(componentsJson, new TypeReference<List<ServiceComponent>>() {});
//                 Service service = new Service(serviceId);
//                 service.setDescription(description);
//                 service.setListOfServices(components);

//                 services.add(service);
//             }
//         } catch (SQLException e) {
//             System.out.println(e.getMessage());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     @Override
//     public void addService(Service service) {
//         String insertServiceSql = "INSERT INTO services(id, description, components) VALUES(?, ?, ?)";

//         try (Connection conn = this.connect();
//              PreparedStatement insertStmt = conn.prepareStatement(insertServiceSql)) {

//             insertStmt.setInt(1, service.getServiceId().getValue());
//             insertStmt.setString(2, service.getDescription());
//             String componentsJson = objectMapper.writeValueAsString(service.getListOfServices());
//             insertStmt.setString(3, componentsJson);
//             insertStmt.executeUpdate();

//             services.add(service);
//         } catch (SQLException e) {
//             System.out.println(e.getMessage());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     @Override
//     public void updateService(Service updatedService) {
//         String updateServiceSql = "UPDATE services SET description = ?, components = ? WHERE id = ?";

//         try (Connection conn = this.connect();
//              PreparedStatement updateStmt = conn.prepareStatement(updateServiceSql)) {

//             updateStmt.setString(1, updatedService.getDescription());
//             String componentsJson = objectMapper.writeValueAsString(updatedService.getListOfServices());
//             updateStmt.setString(2, componentsJson);
//             updateStmt.setInt(3, updatedService.getServiceId().getValue());
//             updateStmt.executeUpdate();

//             for (int i = 0; i < services.size(); i++) {
//                 if (services.get(i).getServiceId().equals(updatedService.getServiceId())) {
//                     services.set(i, updatedService);
//                     return;
//                 }
//             }
//         } catch (SQLException e) {
//             System.out.println("Erro ao atualizar serviço: " + e.getMessage());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         throw new ServiceNotFoundException();
//     }

//     @Override
//     public void removeService(Id id) {
//         String deleteServiceSql = "DELETE FROM services WHERE id = ?";

//         try (Connection conn = this.connect();
//              PreparedStatement deleteStmt = conn.prepareStatement(deleteServiceSql)) {

//             deleteStmt.setInt(1, id.getValue());
//             int affectedRows = deleteStmt.executeUpdate();

//             if (affectedRows > 0) {
//                 services.removeIf(service -> service.getServiceId().equals(id));
//             } else {
//                 System.out.println("Nenhum serviço encontrado com o ID fornecido.");
//             }
//         } catch (SQLException e) {
//             System.out.println("Erro ao remover serviço: " + e.getMessage());
//         }
//     }

//     @Override
//     public List<Service> getServices() {
//         return services;
//     }

//     @Override
//     public Service findServiceById(Id id) {
//         for (Service service : services) {
//             if (service.getServiceId().equals(id)) {
//                 return service;
//             }
//         }
//         throw new ServiceNotFoundException();
//     }
// }
