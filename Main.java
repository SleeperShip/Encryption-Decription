import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String mode = input.nextLine();
        String message = input.nextLine();
        int shift = input.nextInt();
        
        if (mode.equals("dec")) {
            shift *= -1;    
        }
        
        EncryptDecrypt secret = new EncryptDecrypt(shift, mode, message);
        secret.encrypt();
        secret.printMessage();
    }
}
