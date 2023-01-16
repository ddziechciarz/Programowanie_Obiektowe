public class Country {
    private String countryName;
    public String getCountryName(){
        return countryName;
    }
    private int speciesCount;
    public int getSpeciesCount(){
        return speciesCount;
    }
    private int endemicSpeciesCount;
    public int getEndemicSpeciesCount(){
        return endemicSpeciesCount;
    }

    public Country(String name, int species, int endemicSpecies){
        countryName = name;
        speciesCount = species;
        endemicSpeciesCount = endemicSpecies;
    }

    public void DisplayData(){
        System.out.println("Country: " + countryName + " species count: " + speciesCount + " endemic species count: " + endemicSpeciesCount);
    }
}
