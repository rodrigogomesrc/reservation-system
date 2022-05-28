package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
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
    @PostMapping("/attemptReservation")
    public ResponseEntity<String> attemptReservation(@RequestBody String reservationInfo){

    }

}
