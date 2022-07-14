package VierGewinnt;

import java.util.Scanner;

public class Methods {
    public static int random(int max) {
        int output;
        output = (int) (Math.random() * max);
        return output + 1;
    }

    public static char evenOdd(int number) {
        char output;
        if (number % 2 == 0) {
            output = 'E';
        } else {
            output = 'O';
        }
        return output;
    }

    public static boolean FullCheck(boolean[] check) {
        return check[0] && check[1] && check[2] && check[3] && check[4] && check[5] && check[6];
    }

    public static void printField(char[][] field) {
        System.out.println("\n\n\t\t\tReihen:");
        System.out.println("_____________________________");
        System.out.println("| 1 | 2 | 3 | 4 | 5 | 6 | 7 |");
        System.out.print("=============================");

        for (int i = 0; i < field.length; i++) {
            System.out.println();
            for (int j = 0; j < field[0].length; j++) {
                System.out.printf("| %c ", field[i][j]);
            }
            System.out.print("|");
        }
        System.out.println("\n_____________________________\n");
    }

    public static void duoPlayerInput(int counter, char[][] field, int[] line, boolean[] check) {
        //Vars
        int iTemp;
        Scanner blub = new Scanner(System.in);
        do {
            System.out.printf("Spieler %d ist an der Reihe, wähle eine Spalte: ", counter);
            iTemp = blub.nextInt() - 1;
            if (iTemp > 0 && iTemp < 7 && field[1][iTemp] != ' ') {
                check[iTemp] = true;
            }
        } while (iTemp < 0 || iTemp > 6);
        if (field[0][iTemp] != ' ') {
            check[iTemp] = true;
            do {
                System.out.print("Diese Spalte ist leider voll versuche es erneut: ");
                iTemp = blub.nextInt() - 1;
                if (FullCheck(check)) {
                    System.out.println("Das Feld ist voll, dieses Spiel ist Unentschieden ausgegangen!");
                    return;
                }
            } while (iTemp < 0 || iTemp > 6 || field[0][iTemp] != ' ');
        }

        line[iTemp]--;
        field[line[iTemp]][iTemp] = (counter == 1) ? 'X' : 'O';
    }

    public static void soloPlayerInput(char[][] field, int[] line, boolean[] check) {
        int iTemp;
        Scanner blub = new Scanner(System.in);
        do {
            System.out.print("Du bist an der Reihe! Wähle eine Spalte: ");
            iTemp = blub.nextInt() - 1;
        } while (iTemp < 0 || iTemp > 6);
        do {
            if (Methods.FullCheck(check)) {
                return;
            }
            if (field[0][iTemp] != ' ') {
                check[iTemp] = true;
                do {
                    System.out.print("Diese Spalte ist leider voll versuche es erneut: ");
                    iTemp = blub.nextInt() - 1;
                } while (iTemp < 0 || iTemp > 6 || check[iTemp]);
            }
            line[iTemp]--;
            field[line[iTemp]][iTemp] = 'X';
        } while (check[iTemp]);
    }

    public static boolean winCheck(int iTemp, char[][] field, int[] line) {
        boolean win = false;
        if (field[line[iTemp]][iTemp] == 1){
            //
        }
        return win;
        //ToDO: Abfrage mit -/+ rechnungen ausführen
    }

    public static int Bot(char[][] field) {
        int move = 0;
        return move;
    }

}
