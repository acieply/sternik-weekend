package pl.sternik.weekend.entites;

import java.math.BigDecimal;
import java.util.Date;

//@Entity
//@XmlRootElement
public class Moneta {

	// @NotNull
	// @Id
	private Long numerKatalogowy;

	// @NotNull
	private Long rocznik;

	private String marka;
	// @NotEmpty
	private String model;
	// @NotNull
	private BigDecimal cenaZakupu;
	// @NotNull
	private Date dataWprowadzeniaModelu;
	// @NotEmpty
	private String rodzajPaliwa;
	// @NotNull
	private Status status;

	public static Moneta produceMoneta(Long numerKatalogowy, String rodzajPaliwa, Long rocznik, String model,
			String marka, Date dataWprowadzeniaModelu, BigDecimal cenaZakupu, Status status) {
		Moneta m = new Moneta();
		m.numerKatalogowy = numerKatalogowy;
		m.rodzajPaliwa = rodzajPaliwa;
		m.rocznik = rocznik;
		m.marka = marka;
		m.model = model;
		m.cenaZakupu = cenaZakupu;
		m.dataWprowadzeniaModelu = dataWprowadzeniaModelu;
		m.status = status;
		return m;
	}

	public Long getNumerKatalogowy() {
		return numerKatalogowy;
	}

	public Long getRocznik() {
		return rocznik;
	}

	public String getMarka() {
		return marka;
	}

	public String getModel() {
		return model;
	}

	public BigDecimal getCenaZakupu() {
		return cenaZakupu;
	}

	public Date getDataWprowadzeniaModelu() {
		return dataWprowadzeniaModelu;
	}

	public String getRodzajPaliwa() {
		return rodzajPaliwa;
	}

	public Status getStatus() {
		return status;
	}

	public void setNumerKatalogowy(Long numerKatalogowy) {
		this.numerKatalogowy = numerKatalogowy;
	}

	public void setRocznik(Long rocznik) {
		this.rocznik = rocznik;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setCenaZakupu(BigDecimal cenaZakupu) {
		this.cenaZakupu = cenaZakupu;
	}

	public void setDataWprowadzeniaModelu(Date dataWprowadzeniaModelu) {
		this.dataWprowadzeniaModelu = dataWprowadzeniaModelu;
	}

	public void setRodzajPaliwa(String rodzajPaliwa) {
		this.rodzajPaliwa = rodzajPaliwa;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marka == null) ? 0 : marka.hashCode());
		result = prime * result + ((cenaZakupu == null) ? 0 : cenaZakupu.hashCode());
		result = prime * result + ((dataWprowadzeniaModelu == null) ? 0 : dataWprowadzeniaModelu.hashCode());
		result = prime * result + ((rodzajPaliwa == null) ? 0 : rodzajPaliwa.hashCode());
		result = prime * result + ((rocznik == null) ? 0 : rocznik.hashCode());
		result = prime * result + ((numerKatalogowy == null) ? 0 : numerKatalogowy.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moneta other = (Moneta) obj;
		if (marka == null) {
			if (other.marka != null)
				return false;
		} else if (!marka.equals(other.marka))
			return false;
		if (cenaZakupu == null) {
			if (other.cenaZakupu != null)
				return false;
		} else if (!cenaZakupu.equals(other.cenaZakupu))
			return false;
		if (dataWprowadzeniaModelu == null) {
			if (other.dataWprowadzeniaModelu != null)
				return false;
		} else if (!dataWprowadzeniaModelu.equals(other.dataWprowadzeniaModelu))
			return false;
		if (rodzajPaliwa == null) {
			if (other.rodzajPaliwa != null)
				return false;
		} else if (!rodzajPaliwa.equals(other.rodzajPaliwa))
			return false;
		if (rocznik == null) {
			if (other.rocznik != null)
				return false;
		} else if (!rocznik.equals(other.rocznik))
			return false;
		if (numerKatalogowy == null) {
			if (other.numerKatalogowy != null)
				return false;
		} else if (!numerKatalogowy.equals(other.numerKatalogowy))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Moneta [numerKatalogowy=" + numerKatalogowy + ", rocznik=" + rocznik + ", marka=" + marka + ", model="
				+ model + ", cenaZakupu=" + cenaZakupu + ", dataWprowadzeniaModelu=" + dataWprowadzeniaModelu + ", rodzajPaliwa="
				+ rodzajPaliwa + ", status=" + status + "]";
	}

}
