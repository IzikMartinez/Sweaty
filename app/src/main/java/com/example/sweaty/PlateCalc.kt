class PlateCalc constructor(working: String){
    private val weight: Int = working.toInt()
    fun countPlates(): String {
        var plateWeight = weight - 45;
        var forty=0; var thir=0; var twen=0; var ten=0; var five=0; var pointFive =0;

        while (plateWeight > 0) {
            if (plateWeight >= 90) {
                plateWeight -= 90;
                forty += 1;
            } else if (plateWeight >= 70) {
                plateWeight -=70;
                thir += 1;
            } else if (plateWeight >= 50) {
                plateWeight -= 50;
                twen += 1;
            } else if (plateWeight >= 20) {
                plateWeight -= 20;
                ten += 1;
            } else if (plateWeight >= 10) {
                plateWeight -= 10;
                five += 1;
            } else if (plateWeight >= 5) {
                plateWeight -= 5
                pointFive +=1
            } else {
                plateWeight -=1
            }
        }

        var outString: String = ""
        if(forty != 0)
            outString += "45: $forty\n"
        if (thir != 0)
            outString += "35: $thir\n"
        if (twen!= 0)
            outString += "25: $twen\n"
        if (ten != 0)
            outString += "10: $ten\n"
        if (five!= 0)
            outString += "5: $five\n"
        if (pointFive!=0)
            outString += "2.5: $pointFive\n"

        return outString
    }
}