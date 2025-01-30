import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VotingSystem votingSystem = new VotingSystem();

        System.out.println("Welcome to Blockchain Voting System!");
        while (true) {
            System.out.println("\n1. Vote for a candidate");
            System.out.println("2. View all votes");
            System.out.println("3. Count votes for a candidate");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character after nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Enter your Voter ID: ");
                    String voterId = scanner.nextLine();
                    System.out.print("Enter the candidate name: ");
                    String candidateName = scanner.nextLine();
                    votingSystem.vote(voterId, candidateName);
                    break;
                case 2:
                    votingSystem.displayVotes();
                    break;
                case 3:
                    System.out.print("Enter the candidate name to count votes: ");
                    String candidateToCount = scanner.nextLine();
                    votingSystem.countVotes(candidateToCount);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
