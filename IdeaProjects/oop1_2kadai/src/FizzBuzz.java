public class FizzBuzz {
    public static void main(String[] args) {
        //1から100までの数値で繰り返し処理をさせます。
        for (int count = 1; count <= 100; count++) {
            // 数値が、3の倍数かつ5の倍数の時、「FizzBuzz」と表示
            if(count % 3 == 0 && count % 5 == 0){
                System.out.println("FizzBuzz");
            }
            // 数値が、3の倍数の時、「Fizz」と表示
            else if(count % 3 == 0){
                System.out.println("Fizz");
            }
            //数値が、5の倍数の時、「Buzz」と表示
            else if(count % 5 == 0){
                System.out.println("Buzz");
            }
            //上記以外、数値をそのまま表示
            else{

                System.out.println(count);
            }
        }
    }
}





