package Helikopter.Controller;

import Helikopter.Entitete.Helikopter;
import Helikopter.Service.HelikopterService;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class HelikopterController {

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Resource
    HelikopterService helikopterService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping(value= "/helikopterList")
    public List<Helikopter> getHelikopter() {
        return helikopterService.findAll();
    }

    @PostMapping(value = "/dodajHelikopter")
    public void dodajHelikopter(@RequestBody Helikopter helikopter) {
        helikopterService.dodajHelikopter(helikopter);
    }

    @RequestMapping(value = "/brisiHelikopter/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void brisiHelikopter(@PathVariable("id") int id) {
        System.out.println("(Service Side) Deleting helikopter with Id: " + id);
        helikopterService.brisiHelikopter(id);
    }
}