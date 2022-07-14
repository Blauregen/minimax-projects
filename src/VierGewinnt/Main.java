package VierGewinnt;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /********* Scanner und Variablen **********/
        //Scanner
        Scanner blub = new Scanner(System.in);

        //Hauptvars.
        char[][] field = new char[6][7];
        String gamemode;
        boolean[] gameend = new boolean[1];
        int counter = 1;
        int[] line = new int[7];
        boolean[] check = new boolean[7];

        //Tempvars.
        String sTemp;
        char cTemp;
        int iTemp = 0;

        //Fill
        Arrays.fill(line, 6);
        for (int i = 0; i < field.length; i++) {
            Arrays.fill(field[i], ' ');
        }
        do {
            /********* Hauptspiel *********/
            System.out.println("\n4 Gewinnt! Schaffe es als erster 4 in einer Reihe zu bekommen und du hast gewonnen!");

            //2 Spieler/Bot selection
            do {
                System.out.print("Möchtest du gegen einen Bot oder gegen einen Freund spielen? (Eingabe: B od. S): ");
                gamemode = blub.next().toUpperCase();
            } while (!gamemode.equals("B") && !gamemode.equals("S"));

            //Spieler-beginn
            if (gamemode.equals("S")) {
                do {
                    System.out.print("\nWürfelt wer zuerst beginnen darf! Spieler 1 wähle gerade oder ungerade (Eingabe: G od. U): ");
                    sTemp = blub.next().toUpperCase();
                } while (!sTemp.equals("G") && !sTemp.equals("U"));
                iTemp = Methods.random(6);
                cTemp = Methods.evenOdd(iTemp);
                System.out.printf("Es wurde eine %d gewürfelt! ", iTemp);
                if (sTemp.equals("G") && cTemp == 'E') {
                    System.out.print("Gerade gewinnt, Spieler 1 beginnt =)");
                    counter = 1;
                } else if (sTemp.equals("U") && cTemp == 'O') {
                    System.out.print("Ungerade gewinnt, Spieler 1 beginnt =)");
                    counter = 1;
                } else if (sTemp.equals("U") && cTemp == 'E') {
                    System.out.print("Gerade gewinnt, Spieler 2 beginnt =)");
                    counter = 2;
                } else if (sTemp.equals("G") && cTemp == 'O') {
                    System.out.print("Ungerade gewinnt, Spieler 2 beginnt =)");
                    counter = 2;
                }
                Thread.sleep(1500);
            }

            //Field Print
            do {
                //Spalteneingabe
                if (gamemode.equals("S")) {
                    do {
                        if (Methods.FullCheck(check)) {
                            Methods.printField(field);
                            gameend[0] = true;
                            break;
                        }
                        Methods.printField(field);
                        Methods.duoPlayerInput(counter, field, line, check);
                        counter = (counter < 2) ? 2 : 1;
                        gameend[0] = Methods.winCheck(iTemp, field, line);
                    } while (!gameend[0]);
                } else {
                    //TODO: Schleife fehlt
                    Methods.printField(field);
                    Methods.soloPlayerInput(field, line, check);
                    gameend[0] = Methods.FullCheck(check);
                    gameend[0] = Methods.winCheck(iTemp, field, line);
                }
            } while (!gameend[0]);
            System.out.println("Möchten Sie erneut spielen?");
            sTemp = blub.next().toUpperCase();
        }while (sTemp.equals("J"));
    }
}
