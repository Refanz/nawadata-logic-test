import java.util.Scanner;

public class PemberantasanSosialBerskalaBesar {

    public static int[] sortArray(int[] membersFamily) {
        int arrLength = membersFamily.length;

        for (int i = 0; i < arrLength; i++) {
            for (int j = 0; j < arrLength; j++) {

                if (j == arrLength - 1) break;

                if (membersFamily[j] < membersFamily[j + 1]) {
                    int temp = membersFamily[j];
                    membersFamily[j] = membersFamily[j + 1];
                    membersFamily[j + 1] = temp;
                }
            }
        }

        return membersFamily;
    }

    public static int getMinimumBus(int[] membersFamily) {
        int minimumBus = 0;

        int[] members = sortArray(membersFamily);

        for (int i = 0; i < members.length; i++) {

            if (i == members.length - 1) break;

            if (members[i] == 4) {
                minimumBus++;
                continue;
            }

            int temp = members[i] + members[i + 1];

            if (temp <= 4) {
                minimumBus++;
                i = i + 2;
            }

            if (temp > 4) minimumBus++;
        }

        return minimumBus;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the number of families : ");
        int numberOfFamilies = Integer.parseInt(input.nextLine());

        System.out.print("Input the number of members in the family (separated by a space) : ");
        String[] numberOfMembersFamily = input.nextLine().split(" ");

        if (numberOfMembersFamily.length != numberOfFamilies) {
            System.out.println("Input must be equal with count of family");
            return;
        }

        int[] members = new int[numberOfFamilies];

        for (int i = 0; i < numberOfFamilies; i++) {
            members[i] = Integer.parseInt(numberOfMembersFamily[i]);
        }

        System.out.println("Minimum bus required is : " + getMinimumBus(members));
    }
}
