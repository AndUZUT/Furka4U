package wizut.tpsi.ogloszenia;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import wizut.tpsi.ogloszenia.services.OffersService;

@Controller
public class HomeController {
    
    @Autowired
    private OffersService offersservice;
    
    @RequestMapping("/")
    public String home(Model model) throws SQLException{
        
        model.addAttribute("producent",offersservice.getCarManufacturer(2));
        model.addAttribute("model", offersservice.getModel(3));
        return "home";
    }
}
