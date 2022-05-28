package controller;

import model.DTO.*;
import model.RestaurantList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ReservationService;

import java.awt.*;
import java.util.ArrayList;

@RestController
public class ReservationController {
    private final ReservationService reservationService;
    /*
    PostMapping("/hours")
    public ResponseEntity<HourListConsumptionDTO> getConsumptionByHourOfDay(
            @RequestBody GetFromDateDTO searchParams) throws ParseException {

        Optional<Sensor> found = sensorService.findById(searchParams.getSensorId());
        if (!found.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        HourListConsumptionDTO response;
        try {
            response = consumptionService.getConsumptionByHourOfDay(searchParams);

        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        return ResponseEntity.ok().body(response);
    }
     */


    public ReservationController(){
        this.reservationService = new ReservationService();
    }
    @PostMapping("/attemptReservation")
    public ResponseEntity<String> attemptReservation(@RequestBody ReservationInfoDTO riDTO){

        return null;
    }


    @GetMapping("/getRestaurantsList")
    public ResponseEntity<RestaurantListDTO> getRestaurantsList(){
        RestaurantListDTO rlDTO = new RestaurantListDTO();
        rlDTO.setRestaurantes(reservationService.getRestaurantList());
        return  ResponseEntity.ok().body(rlDTO);
    }
    @GetMapping("/getRestaurantMenu")
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
}
