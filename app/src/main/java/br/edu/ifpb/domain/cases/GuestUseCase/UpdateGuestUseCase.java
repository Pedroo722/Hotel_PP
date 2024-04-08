    package br.edu.ifpb.domain.cases.GuestUseCase;

    import br.edu.ifpb.data.GuestRepository;
    import br.edu.ifpb.domain.model.*;
    import br.edu.ifpb.domain.repository.GuestRepositoryInterface;
    import br.edu.ifpb.domain.wrappers.*;
    import br.edu.ifpb.interfaces.controller.UpdateGuestUseCaseIF;

    public class UpdateGuestUseCase implements UpdateGuestUseCaseIF {
        private GuestRepositoryInterface repository;

        public UpdateGuestUseCase() {
            this.repository = GuestRepository.getInstance();
        }

        public void updateGuest(Id userId, Name newName, CPF newCpf, GuestStatus newStatus, Id newReserveId) {
            Guest guest = repository.findGuestById(userId);

            if(guest == null) {
                System.out.println("Guest não encontrado!");
                return;
            }

            guest.setName(newName);
            guest.setCpf(newCpf);
            guest.setStatus(newStatus);
            guest.setReserveId(newReserveId);
        }
    }
