package br.edu.ifpb.interfaces;

public interface GuestIF {
    public void registerGuest();

    public void updateGuest(int userId, String newName, String newPassword, String newCpf);

    public void cancelRegistration(int userId);

    public void checkIn(int userId);

    public void checkOut(int userId); 

}
