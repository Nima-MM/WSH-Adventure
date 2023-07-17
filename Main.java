import java.util.Scanner;

public class Main {

    // deklariere statc Variablen, damit Aufruf auf Klassenebene
    static boolean ort = false;
    static int player_uberAction = 0;
    static int w = 0; 
    static int h = 0; 
    static int s = 0;

    public static void main(String[] args) {
        uberAction();
    }

    /* uberAction */
    public static void uberAction() {

        // player-greeting
        System.out.println(" \n\nHelloPlayer!\n");
        // hint for player
        System.out.println("Hinweis:::\n" +
                "Sie befinden sich an Ort: " + StringOrt() + "\n"+
                "Sie halten " + StringItem() + " in den Haenden!\n"+
                "::" + h + "::\n");

        /* input-options */
        System.out.println("Eingabe:::\n\n" +
                "1 -> zum Ziel des Spiels. \n\n" +
                "2 -> zum Aufheben. \n\n" +
                "3 -> zum Ablegen. \n\n" +
                "4 -> zum Reisen. \n\n");
        // Erstelle ein Scanner-Objekt
        Scanner scanner_uberAction = new Scanner(System.in);
        // Gib eine Aufforderung zur Eingabe aus
        System.out.println("Bitte treffen Sie eine Auswahl: ");
        // Lese die Eingabe von der Konsole ein
        player_uberAction = scanner_uberAction.nextInt();
        // Gib die eingegebene Text zurück
        System.out.println("\n-> Sie haben eingegeben: " + player_uberAction + "");
        // Schließe den Scanner
        // scanner_uberAction.close();

        /* switch-case */
        switch (player_uberAction) {

            case 2:
                System.out.println("Aufheben!\n");
                Aufheben();
                break;
            case 3:
                System.out.println("Ablegen!\n");
                Ablegen();
                break;
            case 4:
                System.out.println("Reisen!\n" + "Du faehrst mit der Faehre auf die andere Seite.\n");
                ort = Reisen();
                Foodcheck();
                if (Foodcheck() == 1 || Foodcheck() == 2 || Foodcheck() == 3 || Foodcheck() == 4 || Foodcheck() == 5) {
                    break;
                }
                uberAction();
                break;
            // Weitere case-Blöcke für weitere Werte
            default:
                System.out.println("HelloPlayer!");
                break;
        }

    }

    /* Aufheben */

    public static void Aufheben() {
        int player_Aufheben = 0;
        System.out.println("Welches dieser Items moechtest du aufheben?\n");
        System.out.println("(Hinweise:::" +
                "Sie können ein einziges Item bei sich tragen!)\n" +
                "Für den Item, das Sie wünschen, geben Sie die entsprechende Zahl ein: " + "\n");
        if ((w == 0 || h == 0 || s == 0) && ort == false) {
            if (w == 0) {
                System.out.println("1. Wolf\n");
            }
            if (h == 0) {
                System.out.println("2. Huhn\n");
            }
            if (s == 0) {
                System.out.println("3. Salat\n");
            }
            if (w != 0 && h != 0 && s != 0) {
                System.out.println("Sie haben schon alles!\n");
            }
            System.out.println("4. Zurueck zum Menu\n");
        }if((w == 2 && h == 2 && s == 2) && ort == false){System.out.println("4. Zurueck zum Menu\n");}

        if ((w == 2 || h == 2 || s == 2) && ort == true) {
            if (w == 2) {
                System.out.println("1. Wolf!\n");
            }
            if (h == 2) {
                System.out.println("2. Huhn!\n");
            }
            if (s == 2) {
                System.out.println("3. Salat!\n");
            }
            if (w != 2 && h != 2 && s != 2) {
                System.out.println("Sie haben schon alles!\n");
            }
            System.out.println("4. Zurueck zum Menu\n");
        }if((w == 0 && h == 0 && s == 0) && ort == true){System.out.println("4. Zurueck zum Menu\n");}

        // Erstelle ein Scanner-Objekt
        Scanner scanner_Aufheben = new Scanner(System.in);
        // Gib eine Aufforderung zur Eingabe aus
        System.out.println("Aufheben:: Bitte treffen Sie eine Auswahl: ");
        // Lese die Eingabe von der Konsole ein
        player_Aufheben = scanner_Aufheben.nextInt();
        // Gib die eingegebene Text zurück
        System.out.println("\n->Aufheben:: Sie haben eingegeben: " + player_Aufheben + "");
        // Schließe den Scanner
      

        /* switch-case ort !!! A !!! */
        if ((w == 0 || h == 0 || s == 0) && ort == false) {
            switch (player_Aufheben) {
                case 1:
                if (h == 1 || s == 1) {
                    System.out.println("Sie halten bereits " + StringItem() + " in den Haenden!");
                }else{
                    System.out.println("Wolf aufgehoben!");
                    w = 1;
                }
                    uberAction();
                    break;
                case 2:
                if (w == 1 || s == 1) {
                    System.out.println("Sie halten bereits " + StringItem() + " in den Haenden!");
                }else{
                    System.out.println("Huhn aufgehoben!");
                    h = 1;
                }
                    uberAction();
                    break;
                case 3:
                if (w == 1 || h == 1) {
                    System.out.println("Sie halten bereits " + StringItem() + " in den Haenden!");
                }else{
                    System.out.println("Salat aufgehoben!");
                    s = 1;
                }
                    uberAction();
                    break;
                case 4:
                    uberAction();
                    break;
                // Weitere case-Blöcke für weitere Werte
                default:
                    System.out.println("Ungueltige Eingabe!\n" + "\n");
                    Aufheben();
                    break;
            }
        }
        if((w == 0 && h == 0 && s == 0) && ort == true){
            System.out.println("Es gibt an " + StringOrt() + " nichts zum aufheben!"); uberAction();
        }

        /* switch-case ort !!! B !!! */
        if ((w == 2 || h == 2 || s == 2) && ort == true) {
            System.out.println("Soweit so good");
            switch (player_Aufheben) {
                case 1:
                if (h == 3 || s == 3) {
                    System.out.println("Sie halten bereits " + StringItem() + " in den Haenden!");
                }else{
                    System.out.println("Wolf aufgehoben!");
                    w = 3;
                }
                    uberAction();
                    break;
                case 2:
                if (w == 3 || s == 3) {
                    System.out.println("Sie halten bereits " + StringItem() + " in den Haenden!");
                }else{
                    System.out.println("Huhn aufgehoben!");
                    h = 3;
                }
                    uberAction();
                    break;
                case 3:
                if (w == 3 || h == 3) {
                    System.out.println("Sie halten bereits " + StringItem() + " in den Haenden!");
                }else{
                    System.out.println("Salat aufgehoben!");
                    s = 3;
                }
                    uberAction();
                    break;
                case 4:
                    uberAction();
                    break;
                // Weitere case-Blöcke für weitere Werte
                default:
                    System.out.println("Ungueltige Eingabe!\n" + "\n");
                    Aufheben();
                    break;
            }
        }
        if((w == 2 && h == 2 && s == 2) && ort == false){
            System.out.println("Es gibt an " + StringOrt() + " nichts zum aufheben!"); uberAction();
        }
    }

    /* Ablegen */
public static void Ablegen(){
    int player_Ablegen = 0;
    String item = "Item";

    item = StringItem();

    if (item.equals("Wolf") || item.equals("Huhn") || item.equals("Salat")) {
        System.out.println("Moechtest du >>" + item + "<< ablegen?\n");    
    } else {
        System.out.println("Sie tragen kein Item bei sich!\n");
        uberAction();  
    }

    // Erstelle ein Scanner-Objekt
    Scanner scanner_Ablegen = new Scanner(System.in);
    // Gib eine Aufforderung zur Eingabe aus
    System.out.println("Ablegen: Bitte treffen Sie eine Auswahl: \n");
    if (item == "Wolf") {
        System.out.println("1. zum Ablegen\n" + 
        "4. zurueck zum Menu");
    }
    if (item == "Huhn") {
        System.out.println("2. zum Ablegen\n" + 
        "4. zurueck zum Menu");
    }
    if (item == "Salat") {
        System.out.println("3. zum Ablegen\n" + 
        "4. zurueck zum Menu");
    }
    // Lese die Eingabe von der Konsole ein
    player_Ablegen = scanner_Ablegen.nextInt();
    // Gib die eingegebene Text zurück
    System.out.println("\n-> Ablegen: Sie haben eingegeben: " + player_Ablegen + "");
    // Schließe den Scanner
    // scanner_Ablegen.close();
    
    /* switch-case ort !!! A !!! */
    
    if ((w == 1 || h == 1 || s == 1) && ort == false) {
        switch (player_Ablegen) {
            case 1:
            if(w == 1){
                System.out.println("Wolf abgelegt!");
                w = 0;
                uberAction();}
                else{System.out.println("Sie besitzen " + item + " und nicht den Wolf!\n");
                Ablegen();
                }
                break;
            case 2:
            if(h == 1){
                System.out.println("Huhn abgelegt!");
                h = 0;
                uberAction();}
                else{System.out.println("Sie besitzen " + item + " und nicht das Huhn!\n");
                Ablegen();
                }
                break;
            case 3:
            if(s == 1){
                System.out.println("Salat abgelegt!");
                s = 0;
                uberAction();}
                else{System.out.println("Sie besitzen " + item + " und nicht den Salat!\n");
                Ablegen();
                }
                break;
            case 4:
                uberAction();
                break;
            // Weitere case-Blöcke für weitere Werte
            default:
                System.out.println("Ungueltige Eingabe!\n" +
                "\n");
                Ablegen();
                break;
        }
    }
    /* switch-case ort !!! B !!! */
    if ((w == 3 || h == 3 || s == 3) && ort == true) {
        switch (player_Ablegen) {
            case 1:
            if(w == 3){
                System.out.println("Wolf abgelegt!");
                w = 2;
                uberAction();}
                else{System.out.println("Sie besitzen " + item + " und nicht den Wolf!\n");
                Ablegen();
                }
                break;
            case 2:
            if(h == 3){
                System.out.println("Huhn abgelegt!");
                h = 2;
                System.out.println("Wallah bille: " + h);
                uberAction();}
                else{System.out.println("Sie besitzen " + item + " und nicht das Huhn!\n");
                Ablegen();
                }
                break;
            case 3:
            if(s == 3){
                System.out.println("Salat abgelegt!");
                s = 2;
                uberAction();}
                else{System.out.println("Sie besitzen " + item + " und nicht den Salat!\n");
                Ablegen();
                }
                break;
            case 4:
                uberAction();
                break;
            // Weitere case-Blöcke für weitere Werte
            default:
                System.out.println("Ungueltige Eingabe!\n" +
                "\n");
                Ablegen();
                break;
        }
    }
  }

    public static boolean Reisen(){
        if(ort == false){
            if(w == 1){w = 3;}
            if(h == 1){h = 3;}
            if(s == 1){s = 3;}
            return true;
        }
        if(ort == true){
            if(w == 3){w = 1;}
            if(h == 3){h = 1;}
            if(s == 3){s = 1;}
            return false;
        }
        return false;
    }

    public static String StringItem() {
        if (w == 1) {
            return "Wolf";
        }
        if (w == 3) {
            return "Wolf";
        }

        if (h == 1) {
            return "Huhn";
        }
        if (h == 3) {
            return "Huhn";
        }

        if (s == 1) {
            return "Salat";
        }
        if (s == 3) {
            return "Salat";
        }
    return "kein Item";
    }

    public static String StringOrt(){
    if(ort == false){
        return "A";
    }
    if(ort == true){
        return "B";
    }
    return "Unbekannt";
    }


    public static int Foodcheck(){
        if (w == 0 && h == 0) {
            System.out.println("Der Wolf hat das Huhn gefressen! Gameover D:");
            return 1;
        }
        if (h == 0 && s == 0) {
            System.out.println("Das Huhn hat den Salat gefressen! Gameover D:");
            return 2;
        }
        if (w == 2 && h == 2) {
            System.out.println("Der Wolf hat das Huhn gefressen! Gameover D:");
            return 3;
        }
        if (h == 2 && s == 2) {
            System.out.println("Das Huhn hat den Salat gefressen! Gameover D:");
            return 4;
        }
        if (w == 2 && h == 2 && s == 2) {
            System.out.println("Sie haben gewonnen. Sie geile sau! :D");
            return 5;
        }
        return 0;
    }
}