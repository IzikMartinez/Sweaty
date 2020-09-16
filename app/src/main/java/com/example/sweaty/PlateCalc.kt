class PlateCalc {
    fun countPlates(weight: Int) {
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

        print("You must add:\n");
        if(forty != 0)
            println("45: $forty")
        if (thir != 0)
            println("35: $thir")
        if (twen!= 0)
            println("25: $twen")
        if (ten != 0)
            println("10: $ten")
        if (five!= 0)
            println("5: $five")
        if (pointFive!=0)
            println("2.5: $pointFive")
    }
}