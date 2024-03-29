public class Main {
    public static void main(String[] args) {
        String alphabet = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";

        String text = "Шифр Цезаря має замало ключів — на одиницю менше, ніж літер в \n" +
                "абетці. Перебір усіх ключів не викликає складнощів. Тому дешифрування \n" +
                "одним з ключів обов’язково дасть вірний відкритий текст";

        int key = 4;

        System.out.println("----------------------------");
        System.out.println("Encrypted");
        text = CesarCipher.encrypt(text, alphabet, key);
        System.out.println(text);

        System.out.println("----------------------------");
        System.out.println("Decrypted");
        text = CesarCipher.decrypt(text, alphabet, key);
        System.out.println(text);

    }
}