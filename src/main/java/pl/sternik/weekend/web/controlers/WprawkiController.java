package pl.sternik.weekend.web.controlers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WprawkiController { 

	
//	@GetMapping("/wprawki2")
//	@ResponseBody
//	public String wprawkiParam(@RequestParam("cos") String cosParam){
//		return "Wprawki z param cos =" + cosParam)
//	}
	
	
	@RequestMapping(path = "/wprawki", method = RequestMethod.GET)
	public String wprawki(ModelMap model) {
		model.put("msg", "Wartosc z modelu");
		model.addAttribute("data", new Date());
		return "wprawki";
	}

	@GetMapping("/wprawki/{cos}")
	public String wprawki(@PathVariable String cos, ModelMap model) {
		model.addAttribute("cos", cos);
		model.put("msg", "Wartosc z modelu");
		model.addAttribute("data", new Date());
		return "wprawki";
	}
	
	@GetMapping("/wprawki3")
    @ResponseBody
    public String wprawkiHeader(@RequestHeader("User-Agent") String cosParam) {
    	return "Uzywasz przegladarki:=" + cosParam;
    }
	
	
	

}