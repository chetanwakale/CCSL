import java.math.BigInteger;
import java.util.Scanner;

class RSAUserInput {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        // Taking two prime numbers as input
        System.out.print("Enter first prime number (p): ");
        int p = sc.nextInt();
        
        System.out.print("Enter second prime number (q): ");
        int q = sc.nextInt();

        // RSA calculations
        int n = p * q;
        int z = (p - 1) * (q - 1);
        System.out.println("The value of z = " + z);

        int e;
        for (e = 2; e < z; e++) {
            if (gcd(e, z) == 1) {
                break;
            }
        }
        System.out.println("The value of e = " + e);

        int d = 0;
        for (int i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        System.out.println("The value of d = " + d);
        
        // Taking message input
        System.out.print("Enter the message (as number) to encrypt: ");
        int msg = sc.nextInt();
        
        // Encryption
        double c = (Math.pow(msg, e)) % n;
        System.out.println("Encrypted message is: " + (int)c);

        // Decryption using BigInteger
        BigInteger N = BigInteger.valueOf(n);
        BigInteger C = BigInteger.valueOf((int)c);
        BigInteger msgback = (C.pow(d)).mod(N);
        System.out.println("Decrypted message is: " + msgback);
        
        sc.close();
    }

    // Function to calculate GCD
    static int gcd(int e, int z) {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }
}

