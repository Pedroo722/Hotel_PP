package br.edu.ifpb.domain.model;

import br.edu.ifpb.domain.wrappers.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GuestTest {

    @Test
    public void testGuestCreation() {
        Name name = new Name("John Doe");
        CPF cpf = new CPF("123.456.789-00");
        Guest guest = new Guest(name, cpf);
        
        assertNotNull(guest.getUserId());
        assertEquals(name, guest.getName());
        assertEquals(cpf, guest.getCpf());
        assertNull(guest.getReserveId());
        assertEquals(GuestStatus.NOT_HOSTED, guest.getStatus());
    }

    @Test
    public void testSetName() {
        Name name = new Name("John Doe");
        CPF cpf = new CPF("123.456.789-00");
        Guest guest = new Guest(name, cpf);
        
        Name newName = new Name("Jane Doe");
        guest.setName(newName);
        
        assertEquals(newName, guest.getName());
    }

    @Test
    public void testSetCpf() {
        Name name = new Name("John Doe");
        CPF cpf = new CPF("123.456.789-00");
        Guest guest = new Guest(name, cpf);
        
        CPF newCpf = new CPF("987.654.321-00");
        guest.setCpf(newCpf);
        
        assertEquals(newCpf, guest.getCpf());
    }

    @Test
    public void testSetReserveId() {
        Name name = new Name("John Doe");
        CPF cpf = new CPF("123.456.789-00");
        Guest guest = new Guest(name, cpf);
        
        Id reserveId = new Id();
        guest.setReserveId(reserveId);
        
        assertEquals(reserveId, guest.getReserveId());
    }

    @Test
    public void testSetStatus() {
        Name name = new Name("John Doe");
        CPF cpf = new CPF("123.456.789-00");
        Guest guest = new Guest(name, cpf);
        
        guest.setStatus(GuestStatus.HOSTED);
        
        assertEquals(GuestStatus.HOSTED, guest.getStatus());
    }

    @Test
    public void testToString() {
        Name name = new Name("John Doe");
        CPF cpf = new CPF("123.456.789-00");
        Guest guest = new Guest(name, cpf);
        
        Id reserveId = new Id();
        guest.setReserveId(reserveId);
        guest.setStatus(GuestStatus.HOSTED);
        
        String expected = "* ID: " + guest.getUserId() + "\n" +
                          "* Nome: " + name + "\n" +
                          "* CPF: " + cpf + "\n" +
                          "* Reserva: [" + reserveId + "]" + "\n" +
                          "* Status: " + GuestStatus.HOSTED;
        
        assertEquals(expected, guest.toString());
    }
}
