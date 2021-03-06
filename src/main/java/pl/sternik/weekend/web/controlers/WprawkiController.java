package pl.sternik.weekend.web.controlers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.sternik.weekend.repositories.MonetaAlreadyExistsException;
import pl.sternik.weekend.repositories.MonetyRepository;
import pl.sternik.weekend.repositories.NoSuchMonetaException;
import pl.sternik.weekend.entites.Moneta;
import pl.sternik.weekend.entites.Status;

@Controller
public class WprawkiController {

	@Autowired
	@Qualifier("tablica")
	MonetyRepository baza;

	@GetMapping("/wprawki2")
	@ResponseBody
	public String wprawkiParam(@RequestParam("cos") String cosParam) {
		return "Wprawki z param cos =" + cosParam;
	}

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

	@GetMapping(value = "wprawki/monety/{id}/json", produces = "application/json")
	@ResponseBody

	public ResponseEntity<Moneta> viewAsJson(@PathVariable("id") Long id, final ModelMap model) {
		Moneta m;
		try {
			m = baza.readById(id);
			return new ResponseEntity<Moneta>(m, HttpStatus.OK);

		} catch (NoSuchMonetaException e) {
			// TODO: handle exception

			System.out.println(e.getClass().getName());
			m = new Moneta();
			m.setNumerKatalogowy(id);
			m.setRodzajPaliwa("benzyna");
			m.setStatus(Status.WYPRZEDAZ);
			m.setRocznik(2010L);
		}
		try {
			baza.create(m);

		} catch (MonetaAlreadyExistsException el) {
			// TODO: handle exception
			System.out.println(el.getClass().getName());
		}
		return new ResponseEntity<Moneta>(m, HttpStatus.CREATED);
	}

}