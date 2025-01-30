public class VotingSystem {
    private Blockchain blockchain;

    public VotingSystem() {
        blockchain = new Blockchain();
    }

    // Simulate voting process
    public void vote(String voterId, String candidateName) {
        blockchain.addVote(voterId, candidateName);
        System.out.println("Vote casted successfully for " + candidateName + " by Voter ID: " + voterId);
    }

    // Display all votes (the entire blockchain)
    public void displayVotes() {
        blockchain.displayBlockchain();
    }

    // Count votes for a specific candidate
    public void countVotes(String candidateName) {
        int count = 0;
        // Iterate over blockchain to count votes for a candidate
        for (int i = 1; i < blockchain.size(); i++) {
            if (blockchain.get(i).getCandidateName().equals(candidateName)) {
                count++;
            }
        }
        System.out.println("Votes for " + candidateName + ": " + count);
    }
}
