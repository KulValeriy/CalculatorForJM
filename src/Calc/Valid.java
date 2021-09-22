package Calc;

public class Valid {

    public static void isInputDataValid(String[] parts) {
        if (parts.length != 3) {
            throw new RuntimeException("Введите 2 значения и операнд через пробел, например: 1 + 2");
        }
    }

    public static boolean isArabian(String str1, String str2) {
        return IntData.getArab().contains(str1) && IntData.getArab().contains(str2);
    }

    public static boolean isRoman(String str1, String str2) {
        return IntData.getRome().contains(str1) && IntData.getRome().contains(str2);
    }
}

