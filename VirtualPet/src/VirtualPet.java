// Part A

public class VirtualPet {
    private String name;
    private int energyLevel;
    private int happinessLevel;
    private int weightinGrams;
    private int ageInYears;
    private int ageInMonths;

    public VirtualPet(String aName){
        this.name = aName;
        this.weightinGrams = 5;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return name + " Information: \nEnergy: " + energyLevel + "\nHappiness: " +
                happinessLevel + "\nWeight: " + weightinGrams + "g \nAge: " + ageInMonths +
                " months and " + ageInYears + " years";
    }

    public void feed(){
        weightinGrams++;
        energyLevel++;
        getEnergyLevel();
    }

    public int getEnergyLevel() {
        if(energyLevel < 0){
            energyLevel = 0;
        } else if(energyLevel > 10){
            energyLevel = 10;
        }
        return energyLevel;
    }

    public int getHappinessLevel() {
        if(happinessLevel < 0){
            happinessLevel = 0;
        } else if(happinessLevel > 10){
            happinessLevel = 10;
        }
        return happinessLevel;
    }

    public void play(){
        happinessLevel++;
        weightinGrams--;

        getHappinessLevel();

        if(weightinGrams < 5){
            weightinGrams = 5;
        }
    }

    public void updateStatus(){
        if(happinessLevel > 0 && happinessLevel < 10){
            happinessLevel--;
        }

        if(energyLevel > 0 && energyLevel < 10){
            energyLevel--;
        }

        getEnergyLevel();
        getHappinessLevel();

        ageInMonths++;
        if(ageInMonths == 12){
            this.ageInYears++;
            this.ageInMonths = 0;
        }
    }
}