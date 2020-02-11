package LeetCode43;

public class Solution {
    String singleMultiply(String num1, char num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        int digit2 = num2 - '0';
        for (int i = num1.length() - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            int product = digit1 * digit2 + carry;
            stringBuilder.append(product % 10);
            carry = product / 10;
        }
        if (carry != 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }

    public String multiply(String num1, String num2) {
        String[] products = new String[num2.length()];
        int maxLength = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int zeroNum = num2.length() - 1 - i;
            products[i] = singleMultiply(num1, num2.charAt(i));
            for (int j = 0; j < zeroNum; j++) {
                products[i] += "0";
            }
            maxLength = Math.max(maxLength, products[i].length());
        }
        for (int i = 0; i < products.length; i++) {
            int zeroNum = maxLength - products[i].length();
            String zero = "";
            for (int j = 0; j < zeroNum; j++) {
                zero += "0";
            }
            products[i] = zero + products[i];
        }
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = maxLength - 1; i >= 0; i--) {
            int sum = carry;
            for (int j = 0; j < products.length; j++) {
                sum += products[j].charAt(i) - '0';
            }
            stringBuilder.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            stringBuilder.append(carry);
        }
        String result = stringBuilder.reverse().toString();
        if (result.charAt(0) == '0') {
            return "0";
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("9999", "0"));
    }
}
