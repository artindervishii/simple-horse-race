
import java.util.*;


public class Horse{
public static void main(String[] args) throws InterruptedException {
    Scanner input = new Scanner(System.in);

    int[] tracks = new int[70];

    int bet;

    System.out.println("==============");
    System.out.println("||Gara me Kuaj||");
    System.out.println("==============");
    System.out.println("Me sa kuaj doni qe te jete gara?"
            + "\n 2 deri ne 10 kuaj jane te lejuar qe te filloj gara ");
    int horses;
    do {
        horses = input.nextInt();
    } while (horses < 2 || horses > 10);
    int[] move = new int[horses];
    double[] betHorse = new double[horses];

    System.out.println("Sa persona jane te interesuar te hyne ne bast?");
    int number = input.nextInt();
    for (int i = 1; i <= number; i++) {
        do {
            for (int j = 1; j <= horses; j++) {
                System.out.println("[" + j + "]" + " per Kalin " + j);
            }
            System.out.println("Person nr." + i + ": Ne cilin kal deshironi te vendosni bast");
            bet = input.nextInt();
        } while (bet < 1 || bet > horses);
        for (int p = 1; p <= horses; p++) {
            if (bet == p) {
                System.out.println("Shuma qe doni te vendosni ne bast");
                betHorse[bet - 1] += input.nextDouble();
            }
        }
        for (int j = 1; j <= horses; j++) {
            System.out.println("Basti per kalin " + j + " p" + betHorse[j - 1]);
        }
    }

    System.out.println("Ne rregull gara eshte gati");
    System.out.println("Gara po fillon per ...:");
    int num3 = 3;
    for (int i = 1; i <= num3; num3--) {
        System.out.println(num3);
        Thread.sleep(1000);
    }
    do {
        Thread.sleep(100);

        int[] numbers = new int[horses];
        for (int i = 0; i < horses; i++) {
            numbers[i] = 1 + (int) (Math.random() * 6);
        }
        for (int i = 0; i < horses; i++) {
            if (numbers[i] >= 1 && numbers[i] <= 3) {
                move[i]++;
            } else if (numbers[i] == 4 && numbers[i] == 5) {
                move[i] = move[i] + 3;
            } else if (numbers[i] == 6) {
                move[i] = move[i] + 5;
            }
        }
        System.out.println("\n\n\n");
        for (int i = 1; i <= horses; i++){
            System.out.println("Kali " + i +" ne poziten:" + move[i-1]);
        }
        for (int i = 1; i <= horses; i++) {
            for (int j = 0; j < move[i - 1]; j++) {
                System.out.print("--");
            }
            System.out.println(i + "H" + move[i - 1]);

        }

    } while (move[horses-1] < tracks.length );

    for (int i = 1; i <= horses; i++) {
        if (move[i - 1] > tracks.length) {
            System.out.println("Kali " + i + " e perfundoi garen,  Ai i cili ka vere bast per kalin " + i + " won " + betHorse[i - 1] * 2);
        }
    }

}
}