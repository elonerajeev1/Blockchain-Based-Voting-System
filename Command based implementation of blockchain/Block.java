import java.security.MessageDigest;

public class Block {
    private String previousHash;  // Hash of previous block
    private String hash;          // Hash of current block
    private String voterId;       // Voter ID to simulate identity (for demo purposes)
    private String candidateName; // Candidate being voted for
    private long timestamp;       // Timestamp when the vote was cast

    // Constructor
    public Block(String voterId, String candidateName, String previousHash) {
        this.voterId = voterId;
        this.candidateName = candidateName;
        this.previousHash = previousHash;
        this.timestamp = System.currentTimeMillis();
        this.hash = calculateHash();  // Calculate hash upon creation
    }

    // Calculate hash of the block
    public String calculateHash() {
        String input = previousHash + Long.toString(timestamp) + voterId + candidateName;
        return applySha256(input);
    }

    // Apply SHA-256 hash function
    private String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error applying SHA-256 hash", e);
        }
    }

    // Getters
    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getVoterId() {
        return voterId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
