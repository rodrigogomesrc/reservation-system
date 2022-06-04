package controller;

import model.ClientData;
import model.DTO.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ReservationService;

import java.util.ArrayList;

@RestController
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(){
        this.reservationService = new ReservationService();
    }
    @PostMapping("/attemptReservation")
    public ResponseEntity<String> attemptReservation(@RequestBody ReservationInfoDTO riDTO){
        ClientData clientData = new ClientData(riDTO.getCpf(),riDTO.getClientName());
        String response = reservationService.attemptReservation(riDTO.getRestaurantName(),riDTO.getDate(), clientData);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/cancelReservation")
    public ResponseEntity<String> cancelReservation(@RequestBody ReservationInfoDTO riDTO){
        String response = reservationService.cancelReservation(riDTO.getRestaurantName(),riDTO.getDate(), riDTO.getCpf());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/getRestaurantsList")
    public ResponseEntity<RestaurantListDTO> getRestaurantsList(){
        RestaurantListDTO rlDTO = new RestaurantListDTO();
        rlDTO.setRestaurantes(reservationService.getRestaurantList());
        return  ResponseEntity.ok().body(rlDTO);
    }
    @PostMapping("/listRestaurantMenu")
    public ResponseEntity<MenuDTO> getRestaurantMenu(@RequestBody RestaurantDTO rDTO){
        String restaurant = rDTO.getName();
        ArrayList<MenuItemDTO> menuItensDTO = new ArrayList<MenuItemDTO>();
        reservationService.getRestaurantMenu(restaurant).forEach(menuItem ->
                menuItensDTO.add(
                        new MenuItemDTO(menuItem.getName(),menuItem.getPrice()
                        )
                )
        );
        MenuDTO menu = new MenuDTO(menuItensDTO);
        return ResponseEntity.ok().body(menu);
    }

    @PostMapping("/checkReservationStatus")
    public ResponseEntity<String> checkReservationsStatus(@RequestBody ClientDataDTO cdDTO){
        String response = reservationService.checkReservationsStatus(cdDTO.getCpf());
        return ResponseEntity.ok().body(response);
    }

}
