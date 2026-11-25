// Part B
    public class VirtualPetB{
        private String name;
        private int energyLevel;
        private int happinessLevel;
        private int weightinGrams;
        private int ageInYears;
        private int ageInMonths;

        public VirtualPetB(String aName){
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

        public void feed(Food food){
            energyLevel += food.getEnergyRating();
            happinessLevel += food.getHappinessRating();
            weightinGrams += food.getWeightGain();

            getEnergyLevel();
            getHappinessLevel();
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

        public boolean play(Game game){
            weightinGrams -= game.getWeightDecr();
            if(weightinGrams < 5){
                weightinGrams = 5;
            }

            boolean won = game.isWinner();

            if(won){
                happinessLevel += game.getHappinessIncr();
            } else{
                happinessLevel -= game.getHappinessIncr();
            }

            getHappinessLevel();
            return won;
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