package br.imd.reservationsystem.client.application;

import service.ReservationService;

public class CheckReservationsUpdate extends Thread{
    long cpf;
    public CheckReservationsUpdate(long cpf){
        this.cpf = cpf;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String response = ReservationService.checkReservationStatus(cpf);
            if(!response.equals("")) {
                System.out.println(response);
            }
        }

    }
}