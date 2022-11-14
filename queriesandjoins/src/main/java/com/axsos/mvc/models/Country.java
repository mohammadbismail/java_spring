package com.axsos.mvc.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="countries")
public class Country {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String code;

    @NotNull
    private String name;


    @NotNull
    private String region;

    @NotNull
    private Double surfaceArea;

    @NotNull
    private Short indepYear;

    @NotNull
    private Integer population;

    @NotNull
    private Double lifeExpectancy;

    @NotNull
    private Double gnp;

    @NotNull
    private Double gnpOld;
    
    
    
    @NotNull
    private enum continent {
        Asia, Africa, NorthAmerica, SouthAmerica, Antarctica, Europe, Australia
    };
    
    @NotNull
    private String localName;

    @NotNull
    private String govermentForm;

    @NotNull
    private String headOfState;

    @NotNull
    private Integer capital;

    @NotNull
    private String code2;

	@Column(updatable=false)
    @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<City> cities;
	
	@Column(updatable=false)
    @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<Language> language;

	public Country() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Double getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(Double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public Short getIndepYear() {
		return indepYear;
	}

	public void setIndepYear(Short indepYear) {
		this.indepYear = indepYear;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Double getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(Double lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public Double getGnp() {
		return gnp;
	}

	public void setGnp(Double gnp) {
		this.gnp = gnp;
	}

	public Double getGnpOld() {
		return gnpOld;
	}

	public void setGnpOld(Double gnpOld) {
		this.gnpOld = gnpOld;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getGovermentForm() {
		return govermentForm;
	}

	public void setGovermentForm(String govermentForm) {
		this.govermentForm = govermentForm;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<Language> getLanguage() {
		return language;
	}

	public void setLanguage(List<Language> language) {
		this.language = language;
	}
	
	
	
	
}
