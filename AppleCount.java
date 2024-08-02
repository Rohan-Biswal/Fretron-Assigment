import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AppleCount{
    public static void main(String[] args) {
        ArrayList<Integer> appleWeights = new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        
        System.out.println("Enter apple weight in gram (-1 to stop): ");
        while (true) {
            int weight = scanner.nextInt();
            if (weight == -1) {
                break;
            }
            appleWeights.add(weight);
        }
        
        Collections.sort(appleWeights,Collections.reverseOrder());
        int ramAmount =50;
        int shamAmount =30;
        int rahimAmount =20;
        int totalAmount = ramAmount+shamAmount+rahimAmount;
        
        double ramShare= ramAmount/(double)totalAmount;
        double shamShare= shamAmount/(double)totalAmount;
        double rahimShare= rahimAmount/(double)totalAmount;
        int totalWeight= appleWeights.stream().mapToInt(Integer::intValue).sum();
        
        double ramTargetWeight= totalWeight*ramShare;
        double shamTargetWeight= totalWeight*shamShare;
        double rahimTargetWeight= totalWeight*rahimShare;

        ArrayList<Integer> ramApples =new ArrayList<>();
        ArrayList<Integer> shamApples =new ArrayList<>();
        ArrayList<Integer> rahimApples =new ArrayList<>();

        for (int weight : appleWeights) {
            if (ramTargetWeight>= weight) {
                ramApples.add(weight);
                ramTargetWeight-= weight;
            } else if (shamTargetWeight>= weight) {
                shamApples.add(weight);
                shamTargetWeight-= weight;
            } else {
                rahimApples.add(weight);
                rahimTargetWeight-= weight;
            }
        }

        System.out.println("Distribution Result:");
        System.out.println("Ram: " + ramApples);
        System.out.println("Sham: " + shamApples);
        System.out.println("Rahim: " + rahimApples);
    }
}
