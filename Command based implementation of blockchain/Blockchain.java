import java.util.ArrayList;

public class Blockchain {
    private ArrayList<Block> blockchain;

    // Constructor
    public Blockchain() {
        blockchain = new ArrayList<>();
        // Create the first block (genesis block)
        blockchain.add(createGenesisBlock());
    }

    // Create the first block (genesis block)
    private Block createGenesisBlock() {
        return new Block("genesis_voter", "genesis_candidate", "0");
    }

    // Add a new vote (block) to the blockchain
    public void addVote(String voterId, String candidateName) {
        String previousHash = blockchain.get(blockchain.size() - 1).getHash();
        Block newBlock = new Block(voterId, candidateName, previousHash);
        blockchain.add(newBlock);
    }

    // Display the blockchain
    public void displayBlockchain() {
        for (Block block : blockchain) {
            System.out.println("Vote by Voter ID: " + block.getVoterId());
            System.out.println("Voted for: " + block.getCandidateName());
            System.out.println("Timestamp: " + block.getTimestamp());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Hash: " + block.getHash());
            System.out.println("---------------");
        }
    }

    // Get the latest block
    public Block getLatestBlock() {
        return blockchain.get(blockchain.size() - 1);
    }

    // Size method to get the number of blocks in the blockchain
    public int size() {
        return blockchain.size();
    }

    // Get a block by index
    public Block get(int index) {
        return blockchain.get(index);
    }
}
