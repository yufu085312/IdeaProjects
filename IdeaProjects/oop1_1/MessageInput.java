import java.util.Scanner; 

public class MessageInput {
  public static void main(String[] args) {

     System.out.println("こんにちは、メッセージをどうぞ");    

    Scanner in = new Scanner(System.in);

    String inputLine = in.nextLine();
    
    System.out.println("メッセージを受信しました");

     System.out.println("----");

    System.out.println(inputLine);

     System.out.println("----");

    in.close();
  }
}
