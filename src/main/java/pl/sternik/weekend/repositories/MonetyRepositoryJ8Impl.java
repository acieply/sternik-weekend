package pl.sternik.weekend.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pl.sternik.weekend.entites.Moneta;
import pl.sternik.weekend.entites.Status;

@Service
@Qualifier("lista")
public class MonetyRepositoryJ8Impl implements MonetyRepository {

	private List<Moneta> monety = new ArrayList<Moneta>() {
		{
			add(Moneta.produceMoneta(1L, "Benzyna", 2014L, "6", "Mazda", new Date(), new BigDecimal("100.200"),
					Status.PREMIERA));
			add(Moneta.produceMoneta(6L, "Benzyna", 2014L, "6", "Mazda", new Date(), new BigDecimal("100.200"),
					Status.PREMIERA));			;
			add(Moneta.produceMoneta(5L, "Benzyna", 2014L, "6", "Mazda", new Date(), new BigDecimal("100.200"),
					Status.PREMIERA));
		}
	};
	@Override
	public List<Moneta> findAll() {
		return this.monety;
	}

	@Override
	public Moneta readById(Long id) throws NoSuchMonetaException {
		return this.monety.stream().filter(p -> Objects.equals(p.getNumerKatalogowy(), id)).findFirst()
				.orElseThrow(NoSuchMonetaException::new);
	}

	@Override
	public Moneta create(Moneta moneta) {
		if (!monety.isEmpty()) {
			moneta.setNumerKatalogowy(
					this.monety.stream().mapToLong(p -> p.getNumerKatalogowy()).max().getAsLong() + 1);
		} else {
			moneta.setNumerKatalogowy(1L);
		}
		this.monety.add(moneta);
		return moneta;
	}

	@Override
	public Moneta update(Moneta moneta) throws NoSuchMonetaException {
		for (int i = 0; i < this.monety.size(); i++) {
			if (Objects.equals(this.monety.get(i).getNumerKatalogowy(), moneta.getNumerKatalogowy())) {
				this.monety.set(i, moneta);
				return moneta;
			}
		}
		throw new NoSuchMonetaException("Nie ma takiego samochodu: " + moneta.getNumerKatalogowy());
	}

	@Override
	public void deleteById(Long id) throws NoSuchMonetaException {
		for (int i = 0; i < this.monety.size(); i++) {
			if (Objects.equals(this.monety.get(i).getNumerKatalogowy(), id)) {
				this.monety.remove(i);
			}
		}
		throw new NoSuchMonetaException("Nie ma takiego samochodu: " + id);
	}

}
