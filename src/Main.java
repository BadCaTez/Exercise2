import java.util.Scanner;

public class Main {
    static int selectPage = 0;
    static String selectDestination = "";
    static String selectTime = "";
    static Train[] listTrain = new Train[]{
            new Train("A123B","Moscow", "11:30", 250, "cupe"),
            new Train("C666C", "HELL", "66:66", 666, "general"),
            new Train("O000O", "Ebengrad", "07:01", 30, "elite"),
            new Train("H228Y", "Prison", "03:35", 78, "reserved seat")
    };

    public static void selectMain() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Выберите запрос: \n" +
                "1.Вывети список поездов по пункту назначения \n" +
                "2.Вывести список поездов по пункту назначения и времени \n" +
                "3.Вывести список поездов по пункту назначения и общему месту \n" +
                "/");

        while (true){
            selectPage = scan.nextInt();
            if(selectPage < 4 && selectPage > 0){
                break;
            }
            else {
                System.out.println("Неверный ввод, повторите его: ");
            }
        }

        switch (selectPage){
            case 1:
                searchTrainDestination();
                break;
            case 2:
                searchTrainDestinationStartTime();
                break;
            case 3:
                searchTrainDestinationTypeseats();
                break;
        }
    }

    public static void main(String[] args) {
        selectMain();
    }

    public static void searchTrainDestination() {
        Scanner scan = new Scanner(System.in);
        boolean x = false;

        System.out.println("Введите пункт назначения: ");
        selectDestination = scan.nextLine();

        for(int i = 0; i < listTrain.length; i++){
            if(selectDestination.equals(listTrain[i].destination)){
                System.out.println(listTrain[i].numberTrain + " | " + listTrain[i].timeStart);
                x = true;
            }
        }

        if(!x){System.out.println("По вашему запросу не было найдено поездов");}
        selectMain();
    }

    public static void searchTrainDestinationStartTime(){
        Scanner scan = new Scanner(System.in);
        boolean x = false;

        System.out.println("Введите пункт назначения");
        selectDestination = scan.nextLine();

        System.out.println("Введите время отправления");
        selectTime = scan.nextLine();

        for(int i = 0; i < listTrain.length; i++){
            if(selectDestination.equals(listTrain[i].destination) &&
                    selectTime.equals(listTrain[i].timeStart)){
                System.out.println(listTrain[i].numberTrain);
                x = true;
            }
        }
        if(x){System.out.println("По вашему запросу не было найдено поездов");}

        selectMain();
    }

    public static void searchTrainDestinationTypeseats(){
        Scanner scan = new Scanner(System.in);
        boolean x = false;

        System.out.println("Введите пункт назначения");
        selectDestination = scan.nextLine();

        for(int i = 0; i < listTrain.length; i++){
            if(selectDestination.equals(listTrain[i].destination) &&
                    listTrain[i].typePlaces.equals("general")){
                System.out.println(listTrain[i].numberTrain + " | " + listTrain[i].timeStart);
                x = true;
            }
        }
        if(x){System.out.println("По вашему запросу не было найдено поездов");}

        selectMain();
    }
}

class Train {
    String numberTrain;
    String destination;
    String timeStart;
    int places;
    String typePlaces;

    public Train (String numberTrain, String destination,
                  String timeStart, int places, String typePlaces) {
        this.numberTrain = numberTrain;
        this.destination = destination;
        this.timeStart = timeStart;
        this.places = places;
        this.typePlaces = typePlaces;
    }

    public String getNumberTrain() {
        return numberTrain;
    }
    public void setNumberTrain(String numberTrain) {
        this.numberTrain = numberTrain;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTimeStart() {
        return timeStart;
    }
    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public int getPlaces() {
        return places;
    }
    public void setPlaces(int places) {
        this.places = places;
    }

    public String getTypePlaces() {
        return typePlaces;
    }

    public void setTypePlaces(String typePlaces) {
        this.typePlaces = typePlaces;
    }
}
