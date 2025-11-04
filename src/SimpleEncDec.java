import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;
public class SimpleEncDec {
	private static final long SEED = 73890;
	public static String load(String instring) {
	    byte[] data = Base64.getDecoder().decode(instring);
	    randomMask(data);
	    return new String(data, StandardCharsets.UTF_8);
	} 
	public static String save(String plaintext) {
	    byte[] data = plaintext.getBytes(StandardCharsets.UTF_8);
	    randomMask(data);
	    return Base64.getEncoder().encodeToString(data);
	}
	private static void randomMask(byte[] data) {
	    Random generator = new Random(SEED);

	    for (int i = 0; i < data.length; i++) {
	        int mask = generator.nextInt(256);
	        data[i] = (byte) (data[i] ^ mask);
	    }
	}
    public static void main(String args[]) throws ClassNotFoundException, IOException {
    	String encrypted = SimpleEncDec.save("+447596974113");
    	String decrypted = SimpleEncDec.load(encrypted);
    	
    	System.out.println("Encrypted: "+ encrypted);
    	System.out.println("Decrypted: "+ decrypted);
    }
}
