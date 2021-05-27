public class EncryptDecrypt {
    
    private int shift;
    private String mode;
    private String message;
    
    public int getShift() {
        return this.shift;
    }
    
    public void setShift(int shift) {
        this.shift = shift;
    }
    
    public String getMode() {
        return this.mode;
    }
    
    public void setMode(String mode) {
        this.mode = mode;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void printMessage() {
        System.out.println(this.message);
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public EncryptDecrypt(int shift, String mode, String message) {
        this.shift = shift;
        this.mode = mode;
        this.message = message;
    }
    
    public EncryptDecrypt() {
        this.shift = 0;
        this.mode = "enc";
        this.message = "";
    }
    
    public void encrypt() {
        StringBuilder strBuild = new StringBuilder();
        char newChar = '[';

        for (int i = 0; i < message.length(); i++) {
            if ( (int)this.message.charAt(i) >= 32 && (int)this.message.charAt(i) <= 126) {
                newChar = getNewChar(this.message.charAt(i), this.shift);
                strBuild.append(newChar);
            }
        }
        this.setMessage(strBuild.toString());
    }
    
    private char getNewChar(char charToReplace, int key) {
        int charAsInt = (int)charToReplace;
        char newChar = 'x';

        if (charAsInt + shift > 126) {
            newChar = (char)(charAsInt + key - 126 + 32);
        } else if (charAsInt + key < 32) {
            int num = charAsInt + key;
            int num2 = 32 - num;
            newChar = (char)(126 - num2);
        } else {
            newChar = (char)(charAsInt + key);
        }
        return newChar;
    }
}
